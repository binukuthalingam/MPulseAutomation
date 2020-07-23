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

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import commonUtils.Common

public class WO_Creation_ListLayout {

	@Keyword
	def workOrderCreationList(String WO_name){

		Common URLNavigate = new Common()
		Common login = new Common()

		String env = findTestData('Environment').getValue(2, 1)

		String userName = findTestData('Login/Login_fields').getValue(1, 1)

		String password = findTestData('Login/Login_fields').getValue(2, 1)

		String dbName = findTestData('Login/Login_fields').getValue(3, 1)

		URLNavigate.navigateToURL(env)

		login.login(userName, password, dbName)

		commonUtils.Common woInfo_Sel = new commonUtils.Common()
		work_Order.WO_ListView_Redirection listRedirect = new work_Order.WO_ListView_Redirection()

		work_Order.WO_Redirection redirection = new work_Order.WO_Redirection()
		redirection.workOrderRedirection()
		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		listRedirect.workOrderListLayoutRedirection()

		try {
			WebUI.waitForPageLoad(30)
			WebUI.waitForAngularLoad(4)
			WebUI.waitForElementClickable(findTestObject('workOrder/addNew_ListLayout'), 5, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(findTestObject('workOrder/addNew_ListLayout'))
		} catch (Exception e) {
			WebUI.waitForElementPresent(findTestObject('workOrder/addNew_ListLayout'), 5)
			WebUI.waitForAngularLoad(4)
			WebUI.click(findTestObject('workOrder/addNew_ListLayout'))
		}


		WebUI.waitForPageLoad(10)

		WebUI.waitForAngularLoad(10)

		WebUI.sendKeys(findTestObject('workOrder/wo_Description_List'), WO_name)

		WebUI.waitForElementClickable(findTestObject('workOrder/Save_ListLayout'), 5)

		WebUI.click(findTestObject('workOrder/Save_ListLayout'))

		WebUI.waitForPageLoad(12)
		WebUI.verifyElementPresent(findTestObject('workOrder/created_WO_List', [('name') :WO_name]), 3)
	}
}
