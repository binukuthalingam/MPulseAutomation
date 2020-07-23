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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys as Keys

public class create_POR {

	@Keyword
	def create() {
		commonUtils.Common por_create = new commonUtils.Common()

		WebUI.waitForPageLoad(20)

		WebUI.click(findTestObject('POR/Inventory_click'))

		WebUI.waitForPageLoad(20)

		WebUI.waitForElementPresent(findTestObject('POR/PurchaseReqRecord_click'), 30)

		WebUI.click(findTestObject('POR/PurchaseReqRecord_click'))

		//WebUI.waitForElementPresent(findTestObject('POR/tab_switch','Supplier'), 30)

		WebUI.delay(10)

		por_create.tabswitch('POR/tab_switch', 'Supplier')

		try {
			// WebUI.acceptAlert()
			WebUI.waitForPageLoad(20)

			WebUI.waitForElementPresent(findTestObject('POR/add_button'), 30)

			WebUI.click(findTestObject('POR/add_button'))
		}
		catch (Exception e) {
			//WebUI.delay(6)

			WebUI.waitForElementPresent(findTestObject('POR/cancel_click'), 30)

			WebUI.click(findTestObject('POR/cancel_click'))

			WebUI.waitForPageLoad(20)

			WebUI.waitForElementPresent(findTestObject('POR/add_button'), 30)

			WebUI.click(findTestObject('POR/add_button'))
		}

		WebUI.delay(6)

		WebUI.setText(findTestObject('POR/Originator_change'), 'Sanity_Tester')

		//WebUI.waitForElementPresent(findTestObject('POR/supplier_obj'), 30)

		WebUI.delay(6)

		por_create.selectValueFromDrop('POR/supplier_obj', 'Supplier', 'Adidas', 'POR/dropdown_select')

		WebUI.delay(6)

		//WebUI.waitForElementPresent(findTestObject('POR/supplier_obj'), 30)

		por_create.selectValueFromDrop('POR/supplier_obj', 'SupplierCountry', 'India', 'POR/supplier_select')

		//WebUI.waitForElementPresent(findTestObject('POR/textobj', 'SupplierCity', 'pala'), 30)

		por_create.enterValueInTextField1('POR/textobj', 'SupplierCity', 'pala')

		//WebUI.waitForElementPresent(findTestObject('POR/textobj'), 30)

		WebUI.delay(10)

		por_create.enterValueInTextField1('POR/textobj', 'SupplierAddr1', 'Inapp')

		//WebUI.waitForElementPresent(findTestObject('POR/tab_switch','Billing'), 30)

		por_create.tabswitch('POR/tab_switch', 'Billing')

		WebUI.delay(10)

		por_create.selectValueFromDrop1('POR/supplier_obj', 'BillToCompany', 'Adidas', 'POR/dropdownselect_index',
				'2')

		WebUI.delay(10)

		//WebUI.waitForElementPresent(findTestObject('POR/supplier_obj','BillToAddr1', 'Kazhakoottam'), 30)

		por_create.enterValueInTextField1('POR/supplier_obj', 'BillToAddr1', 'Kazhakoottam')

		WebUI.delay(10)

		//WebUI.waitForElementPresent(findTestObject('POR/supplier_obj'), 30)

		por_create.enterValueInTextField1('POR/supplier_obj', 'BillToContact', 'Inapp Tester')

		//WebUI.waitForElementPresent(findTestObject('POR/tab_switch','Shipping'), 30)

		por_create.tabswitch('POR/tab_switch', 'Shipping')


		por_create.selectValueFromDrop1('POR/supplier_obj', 'ShipToCompany', 'Adidas', 'POR/dropdownselect_index',
				'3')

		WebUI.delay(10)

		//WebUI.waitForElementPresent(findTestObject('POR/supplier_obj'), 30)

		por_create.selectValueFromDrop('POR/supplier_obj', 'ShipToState', 'Kerala', 'POR/dropdown_select')

		WebUI.delay(10)

		//WebUI.waitForElementPresent(findTestObject('POR/textobj'), 30)

		por_create.enterValueInTextField1('POR/textobj', 'ShipToContact', 'Inapp Tester')



		WebUI.waitForElementPresent(findTestObject('POR/orderdate_click'), 30)

		WebUI.click(findTestObject('POR/orderdate_click'))

		por_create.calendarDateSelect1('1')



		//WebUI.waitForElementPresent(findTestObject('POR/tab_switch','Financial'), 30)

		por_create.tabswitch('POR/tab_switch', 'Financial')



		WebUI.waitForElementPresent(findTestObject('POR/link_click'), 30)

		WebUI.click(findTestObject('POR/link_click'))



		WebUI.waitForElementPresent(findTestObject('POR/Viewall_button'), 30)

		WebUI.click(findTestObject('POR/Viewall_button'))


		//WebUI.waitForElementPresent(findTestObject('POR/Inventoryid_search'), 30)

		por_create.woInfoLinkSearch('POR/Inventoryid_search', '003-WA-0504', 'Link Inventory',
				'POR/Inventorysearch_result')


		//WebUI.waitForElementPresent(findTestObject('POR/linkandreplace','Link'), 30)

		por_create.linkandreplace('POR/linkandreplace', 'Link')

		WebUI.delay(10)

		//WebUI.waitForElementPresent(findTestObject('POR/saveandedit'), 30)

		por_create.editandsave('POR/saveandedit', 'Save', '2')

		WebUI.delay(10)
		//WebUI.waitForElementPresent(findTestObject('POR/saveandedit'), 30)

		por_create.editandsave('POR/saveandedit', 'Edit', '3')

		WebUI.delay(10)

		//WebUI.waitForElementPresent(findTestObject('POR/qnty_order'), 30)

		por_create.enterValueInTextField('POR/qnty_order', 'Column Qty Ordered, Filter cell')

		WebUI.delay(10)

		//WebUI.waitForElementPresent(findTestObject('POR/saveandedit'), 30)

		por_create.editandsave('POR/saveandedit', 'Save', '3')
	}
}
