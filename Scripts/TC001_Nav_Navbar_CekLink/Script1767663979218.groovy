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

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_HARUMAN RENT CAR'))

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/div_Sistem Informasi Rental Mobil  Haruman _080d98'))

WebUI.verifyMatch(WebUI.getUrl(), 'http://localhost/haruman_rentcar/?page=dashboard', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Social Media'))

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Facebook'))

WebUI.verifyMatch(WebUI.getUrl(), 'www.facebook.com/sfahmifadillah', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('http://localhost/haruman_rentcar/')

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Social Media'))

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Twitter'))

WebUI.verifyMatch(WebUI.getUrl(), 'www.twitter.com/sfahmifadillah', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('http://localhost/haruman_rentcar/')

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Social Media'))

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Instagram'))

WebUI.verifyMatch(WebUI.getUrl(), 'www.instagram.com/fhmifs', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('http://localhost/haruman_rentcar/')

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Social Media'))

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Google'))

WebUI.verifyMatch(WebUI.getUrl(), 'www.google.plus.com/sfahmifadillah', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('http://localhost/haruman_rentcar/')

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Admin'))

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Profile'))

WebUI.verifyNotMatch(WebUI.getUrl(), 'http://localhost/haruman_rentcar/?page=dashboard', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('http://localhost/haruman_rentcar/')

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Admin'))

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Inbox7'))

WebUI.verifyNotMatch(WebUI.getUrl(), 'http://localhost/haruman_rentcar/?page=dashboard', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('http://localhost/haruman_rentcar/')

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Admin'))

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Settings'))

WebUI.verifyNotMatch(WebUI.getUrl(), 'http://localhost/haruman_rentcar/?page=dashboard', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('http://localhost/haruman_rentcar/')

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Admin'))

WebUI.click(findTestObject('Object Repository/01_Index/Navbar/a_Log Out'))

WebUI.navigateToUrl('http://localhost/haruman_rentcar/')

WebUI.verifyNotMatch(WebUI.getUrl(), 'http://localhost/haruman_rentcar/?page=dashboard', false, FailureHandling.CONTINUE_ON_FAILURE)

