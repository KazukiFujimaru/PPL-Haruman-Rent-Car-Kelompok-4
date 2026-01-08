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

// 1. Navigasi ke Halaman Karyawan
WebUI.navigateToUrl('http://localhost/haruman_rentcar/?page=daftar_karyawan')

WebUI.click(findTestObject('Object Repository/03_Karyawan/Halaman Utama/a_Menu Rental'))

WebUI.verifyMatch(WebUI.getUrl(), 'http://localhost/haruman_rentcar/?page=daftar_karyawan', false, FailureHandling.CONTINUE_ON_FAILURE)

// 2. Buka Modal Tambah Data
WebUI.click(findTestObject('Object Repository/03_Karyawan/Halaman Utama/button_Tambah Data'))

// Verifikasi Elemen di dalam Modal Tambah
WebUI.verifyElementPresent(findTestObject('Object Repository/03_Karyawan/Modal Tambah/div_Tambah Data Karyawan'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/03_Karyawan/Modal Tambah/div_ID Karyawan                            _5aeb07'), 
    0)

// 3. Input Data Karyawan (Sesuai Request)
WebUI.setText(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_ID Karyawan_id_cs'), 'CS005')

WebUI.setText(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_Nama Karyawan_nama_cs'), 'Stelle')

WebUI.selectOptionByLabel(findTestObject('Object Repository/03_Karyawan/Modal Tambah/select_Laki-LakiPerempuan'), 'Perempuan', 
    false)

WebUI.setText(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_Alamat_alamat_cs'), 'Astral Express')

WebUI.setText(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_No. KTP_no_ktp'), '701202')

// 4. Verifikasi Input Masuk ke Atribut Value
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_ID Karyawan_id_cs'), 
    'value', 'CS005', 3)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_Nama Karyawan_nama_cs'), 
    'value', 'Stelle', 3)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_Alamat_alamat_cs'), 'value', 
    'Astral Express', 3)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_No. KTP_no_ktp'), 'value', 
    '701202', 3)

WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/03_Karyawan/Modal Tambah/select_Laki-LakiPerempuan'), 
    'Perempuan', false, 3)

// 5. Test Tombol Reset (Hapus isi form)
WebUI.click(findTestObject('Object Repository/03_Karyawan/Modal Tambah/button_Reset'))

// Verifikasi Form Kosong Kembali
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_ID Karyawan_id_cs'), 
    'value', '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_Nama Karyawan_nama_cs'), 
    'value', '', 3)

WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/03_Karyawan/Modal Tambah/select_Laki-LakiPerempuan'), 
    'Laki-Laki', false, 3)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_Alamat_alamat_cs'), 'value', 
    '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/03_Karyawan/Modal Tambah/input_No. KTP_no_ktp'), 'value', 
    '', 3)

// 6. Tutup Modal Tambah
WebUI.click(findTestObject('Object Repository/03_Karyawan/Modal Tambah/button_'))

// 7. Test Tombol Edit (Buka Modal Edit)
WebUI.click(findTestObject('Object Repository/03_Karyawan/Halaman Utama/button_Edit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/03_Karyawan/Modal Edit/div_Edit Data Karyawan'), 0)

WebUI.verifyElementPresent(findTestObject('03_Karyawan/Modal Edit/div_ID Karyawan Yang Akan diubah           _943dfe'), 
    0)

// Tutup Modal Edit
WebUI.click(findTestObject('Object Repository/03_Karyawan/Modal Edit/button__1'))

// 8. Test Tombol Hapus (Alert)
WebUI.click(findTestObject('Object Repository/03_Karyawan/Halaman Utama/button_Hapus'))

WebUI.verifyAlertPresent(0)

WebUI.dismissAlert()

// 9. Verifikasi Tombol Cetak
WebUI.verifyElementClickable(findTestObject('Object Repository/03_Karyawan/Halaman Utama/button_Cetak Data'))
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/03_Karyawan/Halaman Utama/button_Cetak Data'), 'onClick', 
    'window.print();', 0)

