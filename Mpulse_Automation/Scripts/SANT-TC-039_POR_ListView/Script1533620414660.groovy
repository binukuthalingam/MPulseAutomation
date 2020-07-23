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

WebUI.waitForPageLoad(30)

WebUI.click(findTestObject('POR_objects/Inventory_click'))

WebUI.waitForPageLoad(10)

WebUI.delay(3)

WebUI.click(findTestObject('POR_objects/PurchaseReqRecord_click'))

WebUI.delay(3)

CustomKeywords.'work_Order.WO_ListView_Redirection.workOrderListLayoutRedirection'()

WebUI.delay(3)

WebUI.click(findTestObject('POR_objects/add_new'))

WebUI.delay(3)

WebUI.clearText(findTestObject('POR_objects/orginator_edit'))

WebUI.delay(3)

WebUI.setText(findTestObject('POR_objects/orginator_edit'), 'new_test')

WebUI.delay(3)

CustomKeywords.'commonUtils.Common.editandsave'('POR_objects/saveandedit', 'Save', '1')

WebUI.delay(3)

WebUI.click(findTestObject('POR_objects/closepur_atlist_click'))

WebUI.delay(5)

WebUI.click(findTestObject('POR_objects/Yes_click'))

WebUI.delay(3)

WebUI.click(findTestObject('POR_objects/calenderclick_closepur_list'))

WebUI.delay(3)

CustomKeywords.'commonUtils.Common.calendarDateSelect'('1')

WebUI.delay(3)

WebUI.click(findTestObject('POR_objects/ok_datebutton'))

WebUI.delay(3)

WebUI.click(findTestObject('POR_objects/okbutton_closepur'))

