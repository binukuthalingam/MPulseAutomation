import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'commonUtils.Common.navigateToURL'('http://mpulse8.com')

CustomKeywords.'commonUtils.Common.login'('Kiran', 'inapp', 'mpulse8_inapp')

WebUI.delay(3)

WebUI.click(findTestObject('Calender/Calender_click'))

WebUI.delay(3)

WebUI.click(findTestObject('Calender/Date selection_Click'))

WebUI.delay(3)

String workOrder = WebUI.getText(findTestObject("Calender/verify_workOrdername"))

WebUI.click(findTestObject('Calender/Jump icon_click'))

WebUI.delay(3)

WebUI.waitForPageLoad(3)
WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('Calender/Verify Workorder', [('name') : workOrder]), 4)

