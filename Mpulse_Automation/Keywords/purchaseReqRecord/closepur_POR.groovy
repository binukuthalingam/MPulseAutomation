package purchaseReqRecord

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

public class closepur_POR {
	@Keyword
	def close(){

		commonUtils.Common closepor = new commonUtils.Common()

		closepor.tabswitch('POR/tab_switch', 'Supplier')

		WebUI.waitForElementClickable(findTestObject('POR/closepur_click'), 5)

		WebUI.click(findTestObject('POR/closepur_click'))

		WebUI.waitForElementAttributeValue(findTestObject('POR/Yes_click'), 'text', 'Yes', 5)

		WebUI.click(findTestObject('POR/Yes_click'))

		WebUI.waitForElementPresent(findTestObject('workOrder/calendar_icon'), 5)

		WebUI.click(findTestObject('workOrder/calendar_icon'))

		closepor.calendarDateSelect()

		WebUI.waitForElementPresent(findTestObject('POR/ok_datebutton'), 5)

		WebUI.click(findTestObject('POR/ok_datebutton'))

		WebUI.waitForElementClickable(findTestObject('POR/okbutton_closepur'), 5)

		WebUI.click(findTestObject('POR/okbutton_closepur'))
	}
}
