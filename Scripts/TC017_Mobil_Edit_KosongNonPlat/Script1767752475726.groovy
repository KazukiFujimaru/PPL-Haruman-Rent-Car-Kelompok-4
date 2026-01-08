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
WebUI.click(findTestObject('Object Repository/02_Mobil/Halaman Utama/button_Edit'))
String dataLama = WebUI.getAttribute(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Plat Nomor Mobil Yang Akan Diubah_plat_nomor'), 'value')
WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Plat Nomor Mobil Yang Akan Diubah_plat_nomor'),
	'')
WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_edit'))
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Edit/div_Edit Data Mobil'), 0)

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Plat Nomor Mobil Yang Akan Diubah_plat_nomor'),
	dataLama)
WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_edit'))
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Edit/div_Edit Data Mobil'), 0)

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Merk Mobil_merk_mobil'), 'Hyundai')
WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_edit'))
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Edit/div_Edit Data Mobil'), 0)

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Type Mobil_tipe_mobil'), 'Palisade')
WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_edit'))
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Edit/div_Edit Data Mobil'), 0)

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Tahun di Buat_thn_buat'), '2025')
WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_edit'))
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Edit/div_Edit Data Mobil'), 0)

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Kapasitas_kapasitas'), '5')
WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_edit'))
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Edit/div_Edit Data Mobil'), 0)

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Stok Mobil_stok_mobil'), '12')
WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_edit'))
WebUI.verifyElementPresent(findTestObject('02_Mobil/Modal Edit/div_Edit Data Mobil'), 0)

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_biaya_rental'), '350000')
WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Edit/input_Biaya Rental_edit'))

WebUI.waitForElementVisible(findTestObject('02_Mobil/Halaman Utama/th_Plat Nomor'), 0)
WebUI.verifyTextPresent('Palisade', false)

