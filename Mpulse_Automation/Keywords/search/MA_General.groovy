package search

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

public class MA_General {

	@Keyword

	def searchMA(String RecordName){

		try {
			WebUI.waitForElementClickable(findTestObject('search/MA_click'), 10)
			WebUI.click(findTestObject('search/MA_click'))
		} catch (Exception e) {

			WebUI.waitForPageLoad(10)
			WebUI.waitForElementClickable(findTestObject('search/MA_click'), 10)
			WebUI.click(findTestObject('search/MA_click'))
		}

		WebUI.waitForAngularLoad(10)

		WebUI.setText(findTestObject('search/search_text_box'), RecordName)

		WebUI.delay(10)

		WebUI.click(findTestObject('search/search_click'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForElementPresent(findTestObject('search/search_results',[('name') : RecordName]), 5)

		WebUI.verifyElementPresent(findTestObject('search/search_results',[('name') : RecordName]), 3)

		WebUI.verifyElementPresent(findTestObject('search/search_desc',[('name') : RecordName]), 3)
	}

	@Keyword

	def searchMAForMAtoWO(String RecordName){

		try {
			WebUI.waitForElementClickable(findTestObject('search/MA_click'), 10)
			WebUI.click(findTestObject('search/MA_click'))
		} catch (Exception e) {

			WebUI.waitForPageLoad(10)
			WebUI.waitForElementClickable(findTestObject('search/MA_click'), 10)
			WebUI.click(findTestObject('search/MA_click'))
		}

		WebUI.delay(8)

		WebUI.setText(findTestObject('search/search_text_box'), RecordName)

		WebUI.delay(8)

		WebUI.click(findTestObject('search/search_click'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForElementPresent(findTestObject('search/search_results',[('name') : RecordName]), 5)

		WebUI.verifyElementPresent(findTestObject('search/search_results',[('name') : RecordName]), 3)

		WebUI.verifyElementPresent(findTestObject('search/search_id',[('name') : RecordName]), 3)
	}

	@Keyword

	def searchMAForMRtoWO_New(String RecordName){

		WebUI.waitForElementClickable(findTestObject('maintenanceRecords/converttoWO'), 5)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('maintenanceRecords/converttoWO'))
		WebUI.waitForElementPresent(findTestObject('maintenanceRecords/confirmYes'), 5)
		WebUI.delay(5)
		WebUI.click(findTestObject('maintenanceRecords/confirmYes'))
		WebUI.delay(8)
		WebUI.click(findTestObject('maintenanceRecords/confirmYes'))
		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :RecordName]), 3)
		String MRDesc = WebUI.getAttribute(findTestObject('maintenanceRecords/MR_ID'), "title")
		WebUI.delay(4)
		search.MA_General search = new search.MA_General()
		search.searchMAForMAtoWO(MRDesc)
	}
}
