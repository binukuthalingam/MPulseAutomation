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

CustomKeywords.'commonUtils.Common.login'('Rose', '123456', 'mpulse8_inapp')

CustomKeywords.'search.redirection_INV_click.redirect_INV'()

CustomKeywords.'work_Order.WO_ListView_Redirection.workOrderListLayoutRedirection'()

CustomKeywords.'search.INV_search_creation_013.INV_search_create'()

String RecordName = WebUI.getAttribute(findTestObject('search/span_POR_View'), 'title')

//WebUI.waitForElementPresent(findTestObject('search/close_popup'), 30)

WebUI.delay(10)

WebUI.click(findTestObject('search/close_popup'))

//WebUI.waitForElementClickable(findTestObject('search/close_popup'), 30)

CustomKeywords.'search.search_MA.searchMA'(RecordName)

