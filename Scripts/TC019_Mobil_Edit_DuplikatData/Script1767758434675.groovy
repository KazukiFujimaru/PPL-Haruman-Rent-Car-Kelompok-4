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
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType

WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost/haruman_rentcar/?page=daftar_mobil')
// 1. Tentukan Target
String mobilTarget = 'Xpander'

// 2. Definisi Object Tabel
// Pastikan object 'tabel_mobil_semua' mengarah ke <table> atau <tbody>
def objectTabel = findTestObject('02_Mobil/Halaman Utama/tabel_mobil_semua')

// --- STEP KRUSIAL: TUNGGU DATA ---
// Masalah utama biasanya disini: Tabel muncul, tapi teks isinya belum render dari database
WebUI.waitForElementVisible(objectTabel, 10)
WebUI.delay(2) // Tambah jeda napas 2 detik untuk memastikan text benar-benar muncul di layar

// 3. Ambil SELURUH Teks yang ada di dalam tabel tersebut
// getText pada tabel akan mengambil semua teks baris dan kolom menjadi satu paragraf panjang
String isiTabelLengkap = WebUI.getText(objectTabel)

// Debugging: Print isi tabel ke console biar Anda bisa cek apa yang dibaca robot
println("--- DEBUG ISI TABEL ---")
println(isiTabelLengkap)
println("-----------------------")

// 4. Logika Pengecekan (Manual Scan)
// Kita cek apakah paragraf panjang tadi mengandung kata 'Xpander'
if (isiTabelLengkap.contains(mobilTarget) && isiTabelLengkap.count(mobilTarget) > 1) {
    
    // KONDISI: SUDAH ADA
    // Karena search aplikasi rusak, kita scan manual dan ketemu.
    KeywordUtil.markWarning("LOG: Data '" + mobilTarget + "' SUDAH ADA di dalam tabel. Skip input data.")

} else {
    
    // KONDISI: BELUM ADA
    KeywordUtil.markPassed("LOG: Data '" + mobilTarget + "' kurang jumlahnya. Menjalankan TC Tambah Data...")
    
    // Panggil Test Case Tambah Data
    WebUI.callTestCase(findTestCase('TC006_Mobil_Tambah_Positif'), [:], FailureHandling.STOP_ON_FAILURE)
    
    // Opsional: Refresh halaman setelah nambah agar tabel terupdate
    WebUI.refresh() 
    WebUI.delay(2) // Tunggu refresh selesai
}
WebUI.click(findTestObject('Object Repository/02_Mobil/Halaman Utama/button_Edit'))
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Merk Mobil_merk_mobil'), 'Mitsubishi')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Type Mobil_tipe_mobil'), 'Xpander')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Tahun di Buat_thn_buat'), '2024')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Kapasitas_kapasitas'), '6')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Stok Mobil_stok_mobil'), '1')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_biaya_rental'), '200000')
WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_edit'))
WebUI.waitForElementVisible(findTestObject('02_Mobil/Halaman Utama/th_Plat Nomor'), 0)
WebUI.refresh()

// 1. Inisiasi
String stringCari = 'Xpander'

// --- PERBAIKAN UTAMA DI SINI ---
// Kita buat object baru on-the-fly yang khusus menargetkan BARIS (tr)
// Bukan menggunakan 'tabel_mobil_semua' yang menargetkan tabel utuh
TestObject objectSemuaBaris = new TestObject('dynamic_rows')
objectSemuaBaris.addProperty('xpath', ConditionType.EQUALS, "//tbody/tr")

// Mengambil semua elemen BARIS
List<WebElement> listMobil = WebUI.findWebElements(objectSemuaBaris, 5)

// Cek dulu berapa baris yang tertangkap (Debugging)
println("Jumlah total baris dalam tabel: " + listMobil.size())

// 2. Siapkan penghitung
int totalCari = 0

// 3. Looping: Periksa satu per satu
for (WebElement element : listMobil) {
    String teksDiBaris = element.getText()
    
    // Debugging: Lihat teks tiap baris
    // println("Baca Baris: " + teksDiBaris)
    
    // Cek apakah baris ini mengandung kata yang dicari
    if (teksDiBaris.contains(stringCari)) {
        totalCari++ 
        println("-> DITEMUKAN di baris ini! Total sementara: " + totalCari)
    }
}

println("Total '" + stringCari + "' ditemukan: " + totalCari)

// 4. Verifikasi Akhir
if (totalCari > 1) {
    KeywordUtil.markPassed("BENAR: Ditemukan tepat " + totalCari + " data mobil " + stringCari)
} else {
    KeywordUtil.markFailed("SALAH: Harusnya data lebih dari satu tapi ditemukan " + totalCari)
}
