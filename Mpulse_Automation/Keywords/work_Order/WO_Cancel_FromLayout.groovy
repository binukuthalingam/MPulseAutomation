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
import java.util.Date;
import java.text.SimpleDateFormat;

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class WO_Cancel_FromLayout {

	@Keyword
	def cancelWorkOrderFormLayout(){

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
		WebUI.click(findTestObject('workOrder/radiobtn', [('status') :'Canceled']))
		WebUI.acceptAlert()
		WebUI.waitForElementPresent(findTestObject('workOrder/infoLink_Search', [('name') :'ViewCancelledReasonCaption']), 5)
		WebUI.setText(findTestObject('workOrder/infoLink_Search', [('name') :'ViewCancelledReasonCaption']), 'Sanity Testing')
		WebUI.click(findTestObject('workOrder/Reason_Save'))
		WebUI.waitForAngularLoad(10)
		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/calendar_icon'))
		commonDatepicker.calendarDateSelect()
		
		int okBtnCount = commonDatepicker.getTotalCountOfElement("//span[contains(text(),'OK')]")
		if(okBtnCount>0){
			WebUI.click(findTestObject('workOrder/calendar_OK'))
		}
		
		WebUI.waitForElementPresent(findTestObject('workOrder/Required_OK'), 6)
		WebUI.click(findTestObject('workOrder/Required_OK'))
		WebUI.delay(10)
		WebUI.waitForPageLoad(5)
		WebUI.verifyElementPresent(findTestObject('workOrder/workOrder Status', [('status') :'Canceled']), 5)
		WebUI.delay(5)
	}
}
