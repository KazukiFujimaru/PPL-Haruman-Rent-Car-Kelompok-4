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

WebUI.click(findTestObject('04_Pelanggan/Modal Tambah/input_Hapus_tambah'))

WebUI.waitForElementVisible(findTestObject('04_Pelanggan/Halaman Utama/th_NIK'), 0)

WebUI.verifyTextPresent('Alvin Fauzal', false)

