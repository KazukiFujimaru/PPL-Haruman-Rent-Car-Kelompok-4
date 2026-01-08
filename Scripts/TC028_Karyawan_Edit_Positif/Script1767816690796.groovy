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

WebUI.navigateToUrl('http://localhost/haruman_rentcar/?page=daftar_karyawan')

WebUI.click(findTestObject('Object Repository/03_Karyawan/Halaman Utama/button_Edit'))

WebUI.setText(findTestObject('03_Karyawan/Modal Edit/input_ID Karyawan Yang Akan diubah_id_cs'), 'CS0007')

WebUI.setText(findTestObject('Object Repository/03_Karyawan/Modal Edit/input_Nama Karyawan_nama_cs'), 'Aulia Putri')

WebUI.selectOptionByLabel(findTestObject('Object Repository/03_Karyawan/Modal Edit/select_Laki-LakiPerempuan'), 'Perempuan', 
    false)

WebUI.setText(findTestObject('Object Repository/03_Karyawan/Modal Edit/input_Alamat_alamat_cs'), 'Kp.Rancasalak RT/RW 02/06, Kadungora, Garut.')

WebUI.setText(findTestObject('Object Repository/03_Karyawan/Modal Edit/input_No. KTP_no_ktp'), '3205010101990001')

WebUI.click(findTestObject('Object Repository/03_Karyawan/Modal Edit/input_No. KTP_edit'))

WebUI.waitForElementVisible(findTestObject('Object Repository/03_Karyawan/Halaman Utama/th_ID Karyawan'), 5)

WebUI.verifyTextPresent('Aulia', false)

