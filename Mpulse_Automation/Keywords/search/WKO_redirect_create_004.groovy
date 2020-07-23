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

public class WKO_redirect_create_004 {
	@Keyword

	def redirect_close(){

		commonUtils.Common rcc = new commonUtils.Common()

		WebUI.waitForPageLoad(10)

		WebUI.click(findTestObject('search/workorder_click'))

		WebUI.delay(5)

		WebUI.click(findTestObject('search/WorkOrderRecords_click_at_MA'))

		WebUI.delay(5)

		rcc.tabswitch('POR/tab_switch', 'sample')

		//CustomKeywords.'commonUtils.Common.tabswitch'('POR/tab_switch', 'sample')

		//por_create.tabswitch('POR_objects/tab_switch', 'Supplier')
		//WebUI.click(findTestObject('POR_objects/tab_switch', 'Supplier'))

		try {
			// WebUI.acceptAlert()
			WebUI.waitForPageLoad(20)

			WebUI.delay(6)

			WebUI.click(findTestObject('POR/add_button'))
		}
		catch (Exception e) {
			WebUI.delay(6)

			WebUI.click(findTestObject('POR/cancel_click'))

			WebUI.delay(6)

			WebUI.waitForPageLoad(20)

			WebUI.click(findTestObject('POR/add_button'))
		}

		WebUI.delay(6)

		WebUI.click(findTestObject('workOrder/save'))

		WebUI.delay(5)

		//WebUI.click(findTestObject('search/enter_desc_WKO_open_close'))
		//WebUI.delay(5)
		WebUI.setText(findTestObject('search/enter_desc_WKO_open_close'), 'Sanity_Tester')

		WebUI.delay(5)

		WebUI.click(findTestObject('POR/okbutton_closepur'))
	}
}
