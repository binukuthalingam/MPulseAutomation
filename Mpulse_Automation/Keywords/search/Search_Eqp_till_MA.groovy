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

public class Search_Eqp_till_MA {

	@Keyword

	def eqpselect(){


		WebUI.click(findTestObject('search/click_CAM'))

		WebUI.delay(5)

		WebUI.click(findTestObject('search/click_eqp_rec'))

		WebUI.delay(5)

		WebUI.click(findTestObject('search/More_click'))

		WebUI.delay(5)

		WebUI.click(findTestObject('search/Open_WO_click'))

		WebUI.delay(5)

		String RecordName = WebUI.getAttribute(findTestObject('search/span_EQP_DescriptionName'), 'title')

		WebUI.click(findTestObject('search/close_popup'))
	}
}
