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

public class WKO_Open_Close_004 {
	@Keyword

	def close_wko(){

		commonUtils.Common wko_obj = new commonUtils.Common()

		WebUI.delay(3)


		wko_obj.tabswitch('POR/tab_switch', 'sample')


		WebUI.delay(3)

		WebUI.click(findTestObject('search/More_click'))

		WebUI.delay(5)

		WebUI.click(findTestObject('search/Close_WKO'))

		WebUI.delay(5)

		WebUI.click(findTestObject('POR/Yes_click'))

		WebUI.delay(5)

		WebUI.click(findTestObject('search/WKO_open_close_calanderclick'))

		WebUI.delay(6)

		wko_obj.calendarDateSelect()

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/ok_datebutton'))

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/okbutton_closepur'))
	}
}
