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

WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Tambah/button_Tambah Data'))

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Plat Nomor_plat_nomor'), 'PlatSalah')

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Merk Mobil_merk_mobil'), '12345')

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Type Mobil_tipe_mobil'), '12345')

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Tahun di Buat_thn_buat'), '-123')

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Kapasitas_kapasitas'), '-123')

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Stok Mobil_stok_mobil'), '-123')

WebUI.setText(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Biaya Rental_biaya_rental'), '-123')

WebUI.click(findTestObject('Object Repository/02_Mobil/Modal Tambah/input_Hapus_tambah'))

WebUI.verifyAlertPresent(4, FailureHandling.OPTIONAL)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('02_Mobil/Halaman Utama/th_Plat Nomor'), 0)

WebUI.verifyTextNotPresent('PlatSalah', false)

