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

CustomKeywords.'commonUtils.Common.navigateToURL'('https://inapp.mpulse8.com/')

CustomKeywords.'commonUtils.Common.login'('Rose', '123456', 'mpulse8_inapp')

CustomKeywords.'search.search_MRR_redirection.redirect_MRR'()

//WebUI.waitForPageLoad(50)

//WebUI.waitForElementPresent(findTestObject('search/MRR_dropdown_click'), 20)

WebUI.delay(20)

WebUI.click(findTestObject('search/MRR_dropdown_click'))

//WebUI.waitForPageLoad(30)

//WebUI.waitForElementClickable(findTestObject('search/MRR_dropdown_click'), 50)

WebUI.delay(20)

//WebUI.waitForPageLoad(50)

//WebUI.waitForElementPresent(findTestObject('search/Pending_req_click'), 50)

WebUI.click(findTestObject('search/Pending_req_click'))

//WebUI.waitForElementClickable(findTestObject('search/Pending_req_click'), 50)

//WebUI.delay(30)

//WebUI.waitForPageLoad(30)

//WebUI.waitForElementClickable(findTestObject('search/Pending_req_click'), 20)

String RecordName = WebUI.getAttribute(findTestObject('search/span_MRR_PendingReq_Name'), 'title')

CustomKeywords.'search.pending_MRR_to_WKO.pendingtowko'()

CustomKeywords.'search.search_MA.searchMA'(RecordName)

