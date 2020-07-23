package maintenance_Records

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
import commonUtils.Common

public class MR_Creation_FormLayout {

	@Keyword
	def MRCreation(String woDescription, String assetName, String inventoryName){

		Common URLNavigation = new Common()
		Common login = new Common()
		maintenance_Records.MR_Redirection redirection = new maintenance_Records.MR_Redirection()
		Common MRInfo_Sel = new Common()
		Common MR_Inv_Search = new Common()
		work_Order.WO_FormLayout_Redirection formRedirect = new work_Order.WO_FormLayout_Redirection()
		String env = findTestData('Environment').getValue(2, 1)

		String userName = findTestData('Login/Login_fields').getValue(1, 1)

		String password = findTestData('Login/Login_fields').getValue(2, 1)

		String dbName = findTestData('Login/Login_fields').getValue(3, 1)

		URLNavigation.navigateToURL(env)

		login.login(userName, password, dbName)

		redirection.maintenanceRecordRedirection()
		formRedirect.workOrderFormLayoutRedirection()

		try {
			WebUI.waitForPageLoad(30)
			WebUI.waitForAngularLoad(4)
			WebUI.waitForElementClickable(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		} catch (Exception e) {
			WebUI.waitForElementPresent(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		}


		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.waitForElementClickable(findTestObject('workOrder/workOrderTabs', [('value') :1]), 5)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		WebUI.waitForPageLoad(10)

		WebUI.sendKeys(findTestObject('workOrder/description'), woDescription)

		MRInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'AssetType', 'Building Records', 'workOrder/groupAndType')
		MRInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'AssetType', 'Equipment Records', 'workOrder/groupAndType')
		WebUI.delay(15)
		WebUI.click(findTestObject('maintenanceRecords/specific_asset_drop', [('name') :'wkrqstforptr']))
		WebUI.setText(findTestObject('maintenanceRecords/specific_asset_drop', [('name') :'wkrqstforptr']), assetName+' (Test Sanity Asset)')
		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/groupAndType', [('name') :assetName+' (Test Sanity Asset)']))
		WebUI.delay(5)
		MRInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'FailureCode', 'Air leak', 'workOrder/groupAndType')
		WebUI.delay(3)
		MRInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'Reasoncode', 'Lack of Maintenance', 'workOrder/groupAndType')
		WebUI.delay(3)
		MRInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'WorkOrderType', 'HVAC', 'workOrder/groupAndType')


		WebUI.waitForElementClickable(findTestObject('workOrder/workOrderTabs', [('value') :4]), 5)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :4]))

		WebUI.waitForElementClickable(findTestObject('maintenanceRecords/link_Inventory'), 5, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('maintenanceRecords/link_Inventory'))

		WebUI.waitForPageLoad(10)
		MR_Inv_Search.woInfoLinkSearch('workOrder/infoLink_Search', inventoryName, 'Link Inventory', 'workOrder/taskAndAssetID')

		WebUI.click(findTestObject('maintenanceRecords/Link_Inv'))
		WebUI.waitForElementClickable(findTestObject('workOrder/save'), 5)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/save'))
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/calendar_OK'))
		WebUI.delay(5)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		String WO_ID= WebUI.getText(findTestObject('workOrder/WO_ID'))
		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :woDescription]), 3)
	}
}
