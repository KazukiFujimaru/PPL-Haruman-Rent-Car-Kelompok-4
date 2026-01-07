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

WebUI.navigateToUrl('http://localhost/haruman_rentcar/')

String landingUrl = WebUI.getUrl()
WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Halaman Utama'))
WebUI.verifyNotMatch(landingUrl, WebUI.getUrl(), false, FailureHandling.CONTINUE_ON_FAILURE)
String dashboardUrl = WebUI.getUrl()

WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Menu Rental'))
WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Daftar Mobil'))
WebUI.verifyNotMatch(dashboardUrl, WebUI.getUrl(), false, FailureHandling.CONTINUE_ON_FAILURE)
String mobilUrl = WebUI.getUrl()

WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Menu Rental'))
WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Daftar Karyawan'))
WebUI.verifyNotMatch(mobilUrl, WebUI.getUrl(), false, FailureHandling.CONTINUE_ON_FAILURE)
String karyawanUrl = WebUI.getUrl()

WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Menu Rental'))
WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Daftar Pelanggan'))
WebUI.verifyNotMatch(karyawanUrl, WebUI.getUrl(), false, FailureHandling.CONTINUE_ON_FAILURE)
String pelangganUrl = WebUI.getUrl()

WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Menu Rental'))
WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Kwitansi Rental'))
WebUI.verifyNotMatch(pelangganUrl, WebUI.getUrl(), false, FailureHandling.CONTINUE_ON_FAILURE)
String kwitansiUrl = WebUI.getUrl()

WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Menu Rental'))
WebUI.click(findTestObject('Object Repository/01_Index/Sidebar/a_Cetak Kwitansi Rental'))
WebUI.verifyNotMatch(karyawanUrl, WebUI.getUrl(), false, FailureHandling.CONTINUE_ON_FAILURE)


