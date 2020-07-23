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

public class INV_search_022 {

	@Keyword
	def search(RecordName){

		commonUtils.Common ic = new commonUtils.Common()

		WebUI.delay(10)

		WebUI.setText(findTestObject('search/search_at_INV_clerk'), RecordName)

		WebUI.waitForElementPresent(findTestObject('Inventory_clerk/Go_button'), 30)

		WebUI.click(findTestObject('Inventory_clerk/Go_button'))

		WebUI.delay(8)

		//waitForElementPresent(findTestObject('Inventory_clerk/check_out'), 20)

		WebUI.click(findTestObject('Inventory_clerk/check_out'))

		WebUI.waitForElementPresent(findTestObject('Inventory_clerk/link_option'), 30)

		ic.selectValueFromDrop1('Inventory_clerk/link_option', 'Link Cart Items To', 'New Purchase Order',
				'Inventory_clerk/link_select', '1')

		WebUI.waitForElementPresent(findTestObject('Inventory_clerk/Link_items_click'), 30)

		WebUI.click(findTestObject('Inventory_clerk/Link_items_click'))

		WebUI.waitForElementPresent(findTestObject('POR/Yes_click'), 30)

		WebUI.click(findTestObject('POR/Yes_click'))

		WebUI.waitForElementPresent(findTestObject('POR/tab_switch'), 30)

		ic.tabswitch('POR/tab_switch', "Financial")

		WebUI.waitForElementPresent(findTestObject('search/por_assert'), 30)

		WebUI.verifyElementPresent(findTestObject('search/por_assert', [('name') : RecordName]), 3)
	}
}
