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

public class WO_Close_ListLayout {


	@Keyword
	def closeWorkOrderListLayout(){


		commonUtils.Common commonDatepicker = new commonUtils.Common()
		WebUI.waitForPageLoad(30)
		WebUI.waitForElementClickable(findTestObject('workOrder/CloseWO'), 5)
		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/CloseWO'))
		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/List_Close_Yes'))
		WebUI.waitForElementClickable(findTestObject('workOrder/calendar_icon'), 6)
		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/calendar_icon'))
		commonDatepicker.calendarDateSelect()
		int okBtnCount = commonDatepicker.getTotalCountOfElement("//span[contains(text(),'OK')]")
		if(okBtnCount>0){
			WebUI.click(findTestObject('workOrder/calendar_OK'))
		}
		WebUI.waitForElementPresent(findTestObject('workOrder/Required_OK'), 6)
		WebUI.click(findTestObject('workOrder/Required_OK'))
		WebUI.waitForPageLoad(5)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/expandAndMinimize', [('name') :'Minimize']))
		WebUI.waitForPageLoad(5)
		WebUI.waitForAngularLoad(10)
		WebUI.verifyElementPresent(findTestObject('workOrder/workOrder Status', [('status') :'Closed']), 4)
		WebUI.delay(5)
	}
}
