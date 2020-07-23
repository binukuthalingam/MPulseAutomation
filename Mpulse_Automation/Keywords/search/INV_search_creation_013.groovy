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

public class INV_search_creation_013 {

	@Keyword

	def INV_search_create(){

		WebUI.setText(findTestObject('search/Inventory_id_search_listview'), '003-WA-0503')

		WebUI.click(findTestObject('search/back_from_listview'))

		//WebUI.delay(5)

		WebUI.waitForElementPresent(findTestObject('search/More_click'), 30)

		WebUI.click(findTestObject('search/More_click'))

		WebUI.waitForElementClickable(findTestObject('search/More_click'), 30)

		//WebUI.delay(5)

		WebUI.waitForElementPresent(findTestObject('search/Open_WKO_INV'), 30)

		WebUI.click(findTestObject('search/Open_WKO_INV'))

		WebUI.waitForElementClickable(findTestObject('search/Open_WKO_INV'), 30)

	}
}
