package reorder_list

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

public class reorder_list_key {

	@Keyword

	def reorder(){

		WebUI.waitForElementPresent(findTestObject('POR/Inventory_click'), 30)

		WebUI.click(findTestObject('POR/Inventory_click'))

		WebUI.waitForPageLoad(20)

		WebUI.waitForElementPresent(findTestObject('Reorder_List/reorder_click'), 30)

		WebUI.click(findTestObject('Reorder_List/reorder_click'))

		WebUI.waitForPageLoad(20)

		WebUI.delay(7)

		WebUI.click(findTestObject('Reorder_List/create_click'))

		WebUI.waitForPageLoad(20)

		WebUI.waitForElementPresent(findTestObject('POR/Yes_click'), 20)

		WebUI.click(findTestObject('POR/Yes_click'))

		WebUI.delay(10)

		WebUI.click(findTestObject('POR/Yes_click'))
	}
}
