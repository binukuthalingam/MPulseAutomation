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

public class pending_MRR_to_WKO {

	@Keyword

	def pendingtowko(){
		//WebUI.delay(5)

		WebUI.waitForElementPresent(findTestObject('search/span_MRR_PendingReq_Name'), 10)

		WebUI.click(findTestObject('search/span_MRR_PendingReq_Name'))

		WebUI.waitForElementClickable(findTestObject('search/span_MRR_PendingReq_Name'), 10)

		//WebUI.delay(5)

		WebUI.waitForElementPresent(findTestObject('search/Convert_Pending_to_WKO'), 20)

		WebUI.click(findTestObject('search/Convert_Pending_to_WKO'))

		WebUI.waitForElementClickable(findTestObject('search/Convert_Pending_to_WKO'), 20)

		//WebUI.delay(6)

		WebUI.waitForElementPresent(findTestObject('POR/Yes_click'), 20)

		WebUI.click(findTestObject('POR/Yes_click'))

		WebUI.waitForElementClickable(findTestObject('POR/Yes_click'), 30)

		WebUI.delay(10)

		WebUI.click(findTestObject('POR/Yes_click'))

		WebUI.delay(10)
	}
}
