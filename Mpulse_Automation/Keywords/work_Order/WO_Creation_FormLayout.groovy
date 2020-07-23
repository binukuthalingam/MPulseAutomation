package work_Order

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
import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import commonUtils.Common


public class WO_Creation_FormLayout {

	@Keyword
	def workOrderCreation(String woDescription, String taskName, String assetName, String inventoryName){

		Common URLNavigate = new Common()
		Common login = new Common()
		Common commonWOInfo_Sel = new Common()
		work_Order.WO_Redirection redirection = new work_Order.WO_Redirection()
		work_Order.WO_FormLayout_Redirection formRedirect = new work_Order.WO_FormLayout_Redirection()

		String env = findTestData('Environment').getValue(2, 1)
		//String env = findTestData('Environment').getValue(2, 2)

		String userName = findTestData('Login/Login_fields').getValue(1, 1)

		String password = findTestData('Login/Login_fields').getValue(2, 1)

		String dbName = findTestData('Login/Login_fields').getValue(3, 1)
		//String dbName = findTestData('Login/Login_fields').getValue(3, 3)

		URLNavigate.navigateToURL(env)

		login.login(userName, password, dbName)

		redirection.workOrderRedirection()
		formRedirect.workOrderFormLayoutRedirection()

		try {
			WebUI.waitForPageLoad(30)
			WebUI.waitForAngularLoad(4)
			WebUI.waitForElementClickable(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		} catch (Exception e) {
			//WebUI.waitForElementPresent(findTestObject('workOrder/cancel'), 3)
			//WebUI.click(findTestObject('workOrder/cancel'))
			WebUI.waitForElementPresent(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5)
			WebUI.waitForAngularLoad(4)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		}


		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)


		WebUI.waitForElementClickable(findTestObject('workOrder/workOrderTabs', [('value') :1]), 5)

		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		WebUI.waitForPageLoad(10)

		WebUI.sendKeys(findTestObject('workOrder/description'), woDescription)

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'WorkOrderType', 'Event Setup', 'workOrder/groupAndType')

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'WorkOrderGroup', 'Maintenance', 'workOrder/groupAndType')

		WebUI.waitForElementClickable(findTestObject('workOrder/workOrderTabs', [('value') :2]), 5)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :2]))

		WebUI.waitForPageLoad(10)

		WebUI.waitForElementClickable(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link']), 5, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', taskName, 'Link Task', 'workOrder/taskAndAssetID')

		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('workOrder/replace'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link Additional Asset']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', assetName, 'Link Additional Asset', 'workOrder/taskAndAssetID')

		WebUI.click(findTestObject('workOrder/replace'))

		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link Additional Inventory']))
		WebUI.delay(5)
		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', inventoryName, 'Link Inventory', 'workOrder/inventoryID')

		WebUI.click(findTestObject('workOrder/replace'))

		try {
			WebUI.waitForAngularLoad(20)
			WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :4]))
		} catch (Exception e) {
			WebUI.waitForElementPresent(findTestObject('workOrder/Required_OK'), 5)
			WebUI.click(findTestObject('workOrder/Required_OK'))
			WebUI.waitForPageLoad(10)
			WebUI.waitForAngularLoad(10)
			WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :4]))
		}

		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :4]))

		commonWOInfo_Sel.enterValueInTextField('workOrder/estAndOtherCost', 'EstCost')

		commonWOInfo_Sel.enterValueInTextField('workOrder/estAndOtherCost', 'OtherCost')

		WebUI.click(findTestObject('workOrder/save'))

		//WebUI.waitForPageLoad(15)
		//WebUI.waitForAngularLoad(10)
		WebUI.delay(10)
		//WebUI.waitForElementClickable(findTestObject('workOrder/workOrderTabs', [('value') :1]),5)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		String WO_ID= WebUI.getText(findTestObject('workOrder/WO_ID'))
		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :woDescription]), 3)

	}
}
