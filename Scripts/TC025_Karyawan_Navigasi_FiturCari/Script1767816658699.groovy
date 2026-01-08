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
import com.kms.katalon.core.testobject.ConditionType // WAJIB ADA

WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost/haruman_rentcar/?page=daftar_karyawan')

// Verifikasi elemen dasar
WebUI.verifyElementPresent(findTestObject('03_Karyawan/Halaman Utama/input_Menampilkan Daftar Karyawan_keyword'), 5)
WebUI.verifyElementPresent(findTestObject('03_Karyawan/Halaman Utama/button_Cari'), 5)
WebUI.verifyElementPresent(findTestObject('03_Karyawan/Halaman Utama/tabel_karyawan_semua'), 5)

// 1. Persiapan Data Test (Sesuaikan dengan data Karyawan Anda)
def dataPencarian = ['CS001', 'Fahmi Fadillah Septiana', 'L', 'Kp. Pasar Wetan RT/RW 02/01, Cisurupan Garut.', '3205201509980001']

// 2. Definisi Object Input & Button (Sesuai request Anda)
def inputSearch = findTestObject('03_Karyawan/Halaman Utama/input_Menampilkan Daftar Karyawan_keyword')
def btnSearch = findTestObject('03_Karyawan/Halaman Utama/button_Cari')

// 3. MEMBUAT OBJECT BARIS DINAMIS (Kunci agar hitungan akurat)
// Kita gunakan XPath yang kita temukan tadi: //div[@class="table-respondsive"]//table/tbody/tr
TestObject objBarisKaryawan = new TestObject('dynamic_rows_karyawan')
objBarisKaryawan.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,"table-respondsive")]//table/tbody/tr')

// --- STEP A: AMBIL BASELINE (JUMLAH DATA AWAL) ---
WebUI.comment('--- MENGHITUNG BASELINE DATA ---')
WebUI.clearText(inputSearch)
WebUI.click(btnSearch) // Reset tabel
WebUI.delay(2) // Tunggu tabel refresh

List<WebElement> listAwal = WebUI.findWebElements(objBarisKaryawan, 5)
int totalAwal = listAwal.size()

println("--- TOTAL DATA KARYAWAN AWAL: " + totalAwal + " Baris ---")

// --- STEP B: LOOPING TEST PENCARIAN ---
for (String kataKunci : dataPencarian) {
    
    WebUI.comment('--- MULAI TEST CARI: ' + kataKunci + ' ---')
    
    // 1. Input & Cari
    WebUI.setText(inputSearch, kataKunci)
    WebUI.click(btnSearch)
    WebUI.delay(2) // Tunggu proses filter selesai
    
    // 2. Hitung Baris Sesudah Search
    List<WebElement> listAkhir = WebUI.findWebElements(objBarisKaryawan, 5)
    int totalAkhir = listAkhir.size()
    
    println("Kata Kunci: " + kataKunci + " | Awal: " + totalAwal + " | Akhir: " + totalAkhir)
    
    // 3. Logika Verifikasi (Pass/Fail)
    if (totalAkhir == totalAwal) {
        // BUG: Jumlah tidak berubah sama sekali
        KeywordUtil.markFailed("BUG FOUND: Cari '" + kataKunci + "' GAGAL. Data tidak terfilter (Jumlah tetap " + totalAkhir + ").")
        
    } else if (totalAkhir == 0) {
        // WARNING: Data hilang semua
        KeywordUtil.markWarning("WARNING: Cari '" + kataKunci + "' menghasilkan 0 data (Data kosong).")
        
    } else {
        // SUCCESS: Jumlah berkurang (Filter bekerja)
        KeywordUtil.markPassed("SUCCESS: Cari '" + kataKunci + "' BERHASIL. Data terfilter menjadi " + totalAkhir + " baris.")
    }
}