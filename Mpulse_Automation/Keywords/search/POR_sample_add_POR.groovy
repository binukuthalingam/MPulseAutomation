package search

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

public class POR_sample_add_POR {
	@Keyword

	def add_POR(){

		commonUtils.Common por_create = new commonUtils.Common()

		por_create.tabswitch('POR/tab_switch', 'Supplier')

		try {

			WebUI.waitForPageLoad(20)
			WebUI.waitForElementClickable(findTestObject('POR/add_button'), 5)

			WebUI.click(findTestObject('POR/add_button'))
		}
		catch (Exception e) {
			WebUI.waitForPageLoad(10)

			WebUI.click(findTestObject('POR/cancel_click'))

			WebUI.delay(5)

			WebUI.click(findTestObject('POR/add_button'))
		}

		WebUI.delay(5)
		WebUI.waitForElementClickable(findTestObject('workOrder/save'), 5)

		WebUI.click(findTestObject('workOrder/save'))
	}
}
