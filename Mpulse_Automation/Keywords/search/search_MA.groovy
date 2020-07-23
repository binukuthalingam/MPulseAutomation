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

public class search_MA {

	@Keyword

	def searchMA(String RecordName){

		WebUI.waitForElementPresent(findTestObject('search/MA_click'), 20)

		WebUI.click(findTestObject('search/MA_click'))

		WebUI.waitForPageLoad(30)

		//WebUI.waitForElementPresent(findTestObject('search/search_text_box'), 30)

		WebUI.delay(20)

		WebUI.setText(findTestObject('search/search_text_box'), RecordName)

		//WebUI.waitForElementPresent(findTestObject('search/search_click'), 10)

		WebUI.click(findTestObject('search/search_click'))

		//WebUI.click(findTestObject('search/click_req_id'))

		WebUI.waitForElementPresent(findTestObject('search/click_req_id'), 10)

		WebUI.click(findTestObject('search/click_req_id',[('name') : RecordName]))

		//WebUI.delay(5)

		//WebUI.verifyElementPresent(findTestObject('search/por_assert', [('name') : RecordName]), 3)
	}
}
