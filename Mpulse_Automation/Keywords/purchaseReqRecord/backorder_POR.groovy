package purchaseReqRecord

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

public class backorder_POR {
	@Keyword
	def backordercreate(){

		commonUtils.Common back_order = new commonUtils.Common()


		back_order.tabswitch('POR/tab_switch', 'Supplier')

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/open_click'))

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/edit_statusclick'))

		WebUI.delay(6)

		back_order.req_status('POR/req_status', 'Back Order')

		WebUI.delay(6)

		WebUI.acceptAlert()

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/edit_backorderform'))

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/qtyrecvdBO_click'))

		WebUI.delay(6)

		back_order.enterValueInTextField('POR/qtyrecvdBO_edit', 'Column Qty Received, Value 0.00')

		WebUI.delay(6)

		back_order.editandsave('POR/saveandedit', 'Save', '4')

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/close_button'))
	}
}
