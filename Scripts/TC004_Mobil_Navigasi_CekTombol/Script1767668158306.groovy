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

WebUI.navigateToUrl('http://localhost/haruman_rentcar/?page=daftar_mobil')
WebUI.click(findTestObject('Object Repository/02_Mobil/Halaman Utama/a_Menu Rental_1'))
WebUI.verifyMatch(WebUI.getUrl(), 'http://localhost/haruman_rentcar/?page=daftar_mobil', false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/02_Mobil/Halaman Utama/button_Tambah Data'))
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Tambah/div_Tambah Data Mobil'), 0)
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Tambah/div_Plat Nomor                             _16fefa'), 0)

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Plat Nomor_plat_nomor'), 'Z 1234 DAV')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Merk Mobil_merk_mobil'), 'Mitsubishi')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Type Mobil_tipe_mobil'), 'Xpander')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Tahun di Buat_thn_buat'), '2024')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Kapasitas_kapasitas'), '6')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Stok Mobil_stok_mobil'), '1')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Biaya Rental_biaya_rental'), '200000')

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Plat Nomor_plat_nomor'), 
    'value', 'Z 1234 DAV', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Merk Mobil_merk_mobil'), 
    'value', 'Mitsubishi', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Type Mobil_tipe_mobil'), 
    'value', 'Xpander', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Tahun di Buat_thn_buat'), 
    'value', '2024', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Kapasitas_kapasitas'), 'value', 
    '6', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Stok Mobil_stok_mobil'), 
    'value', '1', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Biaya Rental_biaya_rental'), 
    'value', '200000', 3)
WebUI.click(findTestObject('02_Mobil/Modal Tambah/button_Hapus'))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Plat Nomor_plat_nomor'), 
    'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Merk Mobil_merk_mobil'), 
    'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Type Mobil_tipe_mobil'), 
    'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Tahun di Buat_thn_buat'), 
    'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Kapasitas_kapasitas'), 'value', 
    '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Stok Mobil_stok_mobil'), 
    'value', '', 3)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Biaya Rental_biaya_rental'), 
    'value', '', 3)

WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Tambah/button__1'))
WebUI.click(findTestObject('Object Repository/02_Mobil/Halaman Utama/button_Edit'))
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Edit/div_Edit Data Mobil'), 0)
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Edit/div_Plat Nomor Mobil Yang Akan Diubah      _880353'), 0)
WebUI.click(findTestObject('02_Mobil/Modal Edit/button_'))
WebUI.click(findTestObject('Object Repository/02_Mobil/Halaman Utama/button_Hapus'))
WebUI.verifyAlertPresent(0)
WebUI.dismissAlert()
WebUI.verifyElementClickable(findTestObject('Object Repository/02_Mobil/Halaman Utama/button_Cetak Data'))
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/02_Mobil/Halaman Utama/button_Cetak Data'), 'onClick', 'window.print();', 
    0)

