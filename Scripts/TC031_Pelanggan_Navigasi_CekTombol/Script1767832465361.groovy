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

WebUI.openBrowser('')

// 1. Navigasi ke Halaman Pelanggan
// Asumsi URL page adalah 'daftar_pelanggan' atau 'pelanggan'
WebUI.navigateToUrl('http://localhost/haruman_rentcar/?page=daftar_pelanggan')

// Verifikasi Halaman Terbuka (Menggunakan Judul Halaman yang tersedia di Object Repo)
WebUI.verifyElementPresent(findTestObject('Object Repository/04_Pelanggan/Halaman Utama/h1_Menu Rental  Daftar Pelanggan'), 5)

// 2. Buka Modal Tambah Data
WebUI.click(findTestObject('Object Repository/04_Pelanggan/Halaman Utama/button_Tambah Data'))

// Verifikasi Judul Modal
WebUI.verifyElementPresent(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/h4_Tambah Data Penyewa'), 5)

// 3. Input Data Pelanggan/Penyewa
WebUI.setText(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_nik'), '3205123456789001')
WebUI.setText(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_plat_nomor'), 'Z 1824 FM')
WebUI.setText(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_nama'), 'Alvin Fauzal')
WebUI.setText(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_jk'), 'L')
WebUI.setText(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_alamat'), 'Jl. Merdeka No. 45')
WebUI.setText(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_telp'), '081234567890')
WebUI.setText(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input__lama_sewa'), '2')
WebUI.setText(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_waktu_sewa'), '01-01-2026')
WebUI.setText(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_waktu_kembali'), '03-01-2026')

// 4. Verifikasi Input Masuk ke Atribut Value (Pengecekan)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_nik'),
	'value', '3205123456789001', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_nama'),
	'value', 'Alvin Fauzal', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_jk'),
	'value', 'L', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_telp'),
	'value', '081234567890', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_alamat'),
	'value', 'Jl. Merdeka No. 45', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_plat_nomor'),
	'value', 'Z 1824 FM', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_waktu_sewa'),
	'value', '2026-01-01', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_waktu_kembali'),
	'value', '2026-03-01', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input__lama_sewa'),
	'value', '2', 3)


// 5. Test Tombol Reset (button_Hapus di dalam Modal Tambah)
WebUI.click(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/button_Hapus'))

// Verifikasi Form Kosong Kembali
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_nik'),
	'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_nama'),
	'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_jk'),
	'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_telp'),
	'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_alamat'),
	'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_plat_nomor'),
	'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_waktu_sewa'),
	'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input_waktu_kembali'),
	'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/input__lama_sewa'),
	'value', '', 3)

// 6. Tutup Modal Tambah (button_ biasanya tombol close/silang)
WebUI.click(findTestObject('Object Repository/04_Pelanggan/Modal Tambah/button_'))

// 7. Verifikasi Tombol Cetak Data (Di Halaman Utama)
// Pastikan tombol cetak memiliki fungsi window.print()
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/04_Pelanggan/Halaman Utama/button_Cetak Data'), 'onClick', 'window.print();', 5)
WebUI.verifyElementClickable(findTestObject('Object Repository/04_Pelanggan/Halaman Utama/button_Cetak Data'))