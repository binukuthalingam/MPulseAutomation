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



import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject



import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class por_Listview_createandclose {
	@Keyword
	def createandclose(){

		commonUtils.Common createclose = new commonUtils.Common()

		work_Order.WO_ListView_Redirection closecreate = new work_Order.WO_ListView_Redirection()

		WebUI.click(findTestObject('POR/Inventory_click'))

		WebUI.waitForPageLoad(20)

		WebUI.click(findTestObject('POR/PurchaseReqRecord_click'))

		WebUI.delay(6)

		closecreate.workOrderListLayoutRedirection()

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/add_new'))

		WebUI.delay(6)

		WebUI.clearText(findTestObject('POR/orginator_edit'))

		WebUI.delay(6)

		String Org_name = 'SanityTester_' + System.currentTimeMillis()

		WebUI.setText(findTestObject('POR/orginator_edit'), Org_name)
		//WebUI.setText(findTestObject('POR/orginator_edit'), 'New_Sanity_Tester')

		WebUI.delay(6)

		createclose.editandsave('POR/saveandedit', 'Save', '1')

		WebUI.delay(6)

		WebUI.verifyElementPresent(findTestObject('POR/org_assert', [('name') : Org_name]), 0)

		WebUI.click(findTestObject('POR/closepur_atlist_click'))

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/Yes_click'))

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/calenderclick_closepur_list'))

		WebUI.delay(6)

		createclose.calendarDateSelect1('1')

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/ok_datebutton'))

		WebUI.delay(6)

		WebUI.click(findTestObject('POR/okbutton_closepur'))
	}
}