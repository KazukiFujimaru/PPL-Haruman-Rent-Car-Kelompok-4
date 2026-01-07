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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost/haruman_rentcar/?page=daftar_mobil')

WebUI.verifyElementPresent(findTestObject('02_Mobil/Halaman Utama/input_Menampilkan Daftar Mobil_keyword'), 5)

WebUI.verifyElementPresent(findTestObject('02_Mobil/Halaman Utama/button_Cari'), 5)

WebUI.verifyElementPresent(findTestObject('02_Mobil/Halaman Utama/tabel_mobil_semua'), 5)

def dataPencarian = ['Z 1897 DZ', 'Honda', 'Mobillio', '2016', '10', '3', '450000']

// --- STEP 1: AMBIL BASELINE (JUMLAH DATA TOTAL SEBELUM FILTER) ---
// Pastikan tabel dalam keadaan 'clean' (menampilkan semua data) sebelum loop dimulai
WebUI.clearText(findTestObject('02_Mobil/Halaman Utama/input_Menampilkan Daftar Mobil_keyword'))
WebUI.click(findTestObject('02_Mobil/Halaman Utama/button_Cari')) // Klik cari kosong untuk reset tabel (opsional tergantung web)
WebUI.delay(1)

// Hitung jumlah baris total
List<WebElement> listBarisAwal = WebUI.findWebElements(findTestObject('02_Mobil/Halaman Utama/tabel_mobil_semua'), 5)
int jumlahDataAwal = listBarisAwal.size()

println("--- BASELINE DATA TOTAL: " + jumlahDataAwal + " Baris ---")


// --- STEP 2: LOOPING PENCARIAN ---
for (String kataKunci : dataPencarian) {
    
    // Input Kata Kunci
    WebUI.setText(findTestObject('02_Mobil/Halaman Utama/input_Menampilkan Daftar Mobil_keyword'), kataKunci)
    WebUI.click(findTestObject('02_Mobil/Halaman Utama/button_Cari'))
    WebUI.delay(1)

    // Hitung Baris SESUDAH Search
    List<WebElement> barisTabel = WebUI.findWebElements(findTestObject('02_Mobil/Halaman Utama/tabel_mobil_semua'), 5)
    int jumlahBaris = barisTabel.size()

    println((('Kata Kunci: ' + kataKunci) + ' | Awal: ' + jumlahDataAwal + ' | Akhir: ') + jumlahBaris)

    // --- LOGIKA ROBUST (COMPARISON) ---
    
    // KONDISI BUG: Jika jumlah baris SETELAH cari == jumlah baris SEBELUM cari
    // Artinya filter tidak membuang data apapun (tidak bekerja)
    if (jumlahBaris == jumlahDataAwal) {
        KeywordUtil.markFailed(((('BUG FOUND: Cari \'' + kataKunci) + '\' gagal. Tidak ada perubahan jumlah data (Tetap: ') + jumlahBaris) + ')')
    
    } else if (jumlahBaris == 0) {
        // KONDISI WARNING: Data hilang semua
        KeywordUtil.markWarning(('WARNING: Cari \'' + kataKunci) + '\' menghasilkan 0 data.')
    
    } else {
        // KONDISI SUKSES: Jumlah baris BERUBAH (Berkurang dari jumlah awal)
        KeywordUtil.markPassed(((('SUCCESS: Cari \'' + kataKunci) + '\' bekerja. Data terfilter dari ') + jumlahDataAwal) + (' menjadi ' + jumlahBaris))
    }
}