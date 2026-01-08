import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import java.util.List as List
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.testobject.ConditionType // Wajib Import ini

WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost/haruman_rentcar/?page=daftar_mobil')

// Verifikasi elemen dasar
WebUI.verifyElementPresent(findTestObject('02_Mobil/Halaman Utama/input_Menampilkan Daftar Mobil_keyword'), 5)
WebUI.verifyElementPresent(findTestObject('02_Mobil/Halaman Utama/button_Cari'), 5)
WebUI.verifyElementPresent(findTestObject('02_Mobil/Halaman Utama/tabel_mobil_semua'), 5)

def dataPencarian = ['Z 1897 DZ', 'Honda', 'Mobillio', '2016', '10', '3', '450000']

// --- PERBAIKAN 1: BUAT OBJECT DINAMIS KHUSUS BARIS (TR) ---
// Kita ambil xpath dari log Anda tadi, tapi kita tambahkan "/tr" di belakangnya
// Supaya yang dihitung adalah BARIS-nya, bukan tabel-nya.
TestObject objBarisTabel = new TestObject('dynamic_rows')
objBarisTabel.addProperty('xpath', ConditionType.EQUALS, "//table[contains(@class,'table-striped')]/tbody/tr")

// --- STEP 1: AMBIL BASELINE (JUMLAH DATA TOTAL SEBELUM FILTER) ---
WebUI.clearText(findTestObject('02_Mobil/Halaman Utama/input_Menampilkan Daftar Mobil_keyword'))
WebUI.click(findTestObject('02_Mobil/Halaman Utama/button_Cari')) 
WebUI.delay(1)

// Hitung jumlah baris total menggunakan object dinamis tadi
List<WebElement> listBarisAwal = WebUI.findWebElements(objBarisTabel, 5)
int jumlahDataAwal = listBarisAwal.size()

println("--- BASELINE DATA TOTAL: " + jumlahDataAwal + " Baris ---")

// --- STEP 2: LOOPING PENCARIAN ---
for (String kataKunci : dataPencarian) {
    
    // Input Kata Kunci
    WebUI.setText(findTestObject('02_Mobil/Halaman Utama/input_Menampilkan Daftar Mobil_keyword'), kataKunci)
    WebUI.click(findTestObject('02_Mobil/Halaman Utama/button_Cari'))
    
    // Beri waktu tabel untuk refresh/render ulang
    WebUI.delay(1)
    
    // Hitung Baris SESUDAH Search (Pakai object dinamis yang sama)
    List<WebElement> barisTabel = WebUI.findWebElements(objBarisTabel, 5)
    int jumlahBaris = barisTabel.size()

    println((('Kata Kunci: ' + kataKunci) + ' | Awal: ' + jumlahDataAwal + ' | Akhir: ') + jumlahBaris)

    // --- LOGIKA ROBUST (COMPARISON) ---
    // Logika Bug: Jika Jumlah Baris TETAP SAMA dengan Jumlah Awal, berarti Search GAGAL
    if (jumlahBaris == jumlahDataAwal) {
        KeywordUtil.markFailed(((('BUG FOUND: Cari \'' + kataKunci) + '\' gagal. Tidak ada perubahan jumlah data (Tetap: ') + jumlahBaris) + ')')
    
    } else if (jumlahBaris == 0) {
        // Warning jika data hilang semua
        KeywordUtil.markWarning(('WARNING: Cari \'' + kataKunci) + '\' menghasilkan 0 data.')
    
    } else {
        // Sukses jika jumlah baris berkurang (artinya terfilter)
        KeywordUtil.markPassed(((('SUCCESS: Cari \'' + kataKunci) + '\' bekerja. Data terfilter dari ') + jumlahDataAwal) + (' menjadi ' + jumlahBaris))
    }
}