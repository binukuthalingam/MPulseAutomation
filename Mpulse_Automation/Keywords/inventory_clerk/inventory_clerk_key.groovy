package inventory_clerk

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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
public class inventory_clerk_key {

	@Keyword
	def inventsearch(){

		WebUI.waitForPageLoad(20)

		commonUtils.Common ic = new commonUtils.Common()

		WebUI.click(findTestObject('POR/Inventory_click'))

		WebUI.waitForPageLoad(10)

		//WebUI.delay(5)

		WebUI.waitForElementPresent(findTestObject('Inventory_clerk/Inventory_clerk_click'), 30)

		WebUI.click(findTestObject('Inventory_clerk/Inventory_clerk_click'))

		WebUI.delay(5)

		WebUI.setText(findTestObject('Inventory_clerk/search_entry'), '003-WA-0511')

		//WebUI.delay(5)

		WebUI.waitForElementPresent(findTestObject('Inventory_clerk/Go_button'), 30)

		WebUI.click(findTestObject('Inventory_clerk/Go_button'))

		WebUI.delay(8)

		//WebUI.waitForElementPresent(findTestObject('Inventory_clerk/check_out'), 30)

		WebUI.click(findTestObject('Inventory_clerk/check_out'))

		//WebUI.delay(5)

		WebUI.waitForElementPresent(findTestObject('Inventory_clerk/link_option'), 30)

		ic.selectValueFromDrop1('Inventory_clerk/link_option', 'Link Cart Items To', 'New Work Order',
				'Inventory_clerk/link_select', '1')

		//WebUI.delay(3)

		WebUI.waitForElementPresent(findTestObject('Inventory_clerk/Link_items_click'), 30)

		WebUI.click(findTestObject('Inventory_clerk/Link_items_click'))

		//WebUI.delay(5)

		WebUI.waitForElementPresent(findTestObject('POR/Yes_click'), 30)

		WebUI.click(findTestObject('POR/Yes_click'))
	}
}
