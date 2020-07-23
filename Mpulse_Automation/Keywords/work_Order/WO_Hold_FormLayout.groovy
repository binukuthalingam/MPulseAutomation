package work_Order

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class WO_Hold_FormLayout {

	@Keyword
	def holdWorkOrderFormLayout(){

		commonUtils.Common commonWOInfo_Sel = new commonUtils.Common()
		commonUtils.Common commonDatepicker = new commonUtils.Common()

		try {
			WebUI.waitForPageLoad(30)
			WebUI.waitForElementClickable(findTestObject('workOrder/addAndEdit', [('name') :'Edit']), 5, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Edit']))
		} catch (Exception e) {
			WebUI.waitForElementPresent(findTestObject('workOrder/cancel'), 5)
			WebUI.click(findTestObject('workOrder/cancel'))
			WebUI.waitForElementPresent(findTestObject('workOrder/addAndEdit', [('name') :'Edit']), 5)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Edit']))
		}
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/radiobtn', [('status') :'Hold']))
		WebUI.delay(3)
		commonWOInfo_Sel.selectValueFromDrop('workOrder/HoldReason', 'HoldReason', 'Waiting for parts', 'workOrder/groupAndType')
		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/holduntil_calendar'))
		commonDatepicker.calendarDateSelect()
		WebUI.click(findTestObject('workOrder/Reason_Save'))
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('workOrder/workOrder Status', [('status') :'Hold']), 4)
		WebUI.delay(5)
	}
}
