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
import commonUtils.Common

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class MR_Creation_ListLayout {

	@Keyword
	def MR_Creation_List(String woDescription){

		Common URLNavigation = new Common()
		Common login = new Common()
		maintenance_Records.MR_Redirection redirection = new maintenance_Records.MR_Redirection()
		work_Order.WO_ListView_Redirection listRedirect = new work_Order.WO_ListView_Redirection()
		Common MRInfo_Sel = new Common()
		Common MR_Inv_Search = new Common()
		String env = findTestData('Environment').getValue(2, 1)

		String userName = findTestData('Login/Login_fields').getValue(1, 1)

		String password = findTestData('Login/Login_fields').getValue(2, 1)

		String dbName = findTestData('Login/Login_fields').getValue(3, 1)

		URLNavigation.navigateToURL(env)

		login.login(userName, password, dbName)

		redirection.maintenanceRecordRedirection()

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

		WebUI.sendKeys(findTestObject('workOrder/wo_Description_List'), woDescription)

		WebUI.waitForElementClickable(findTestObject('workOrder/Save_ListLayout'), 5)

		WebUI.click(findTestObject('workOrder/Save_ListLayout'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.waitForElementClickable(findTestObject('workOrder/calendar_OK'), 5)
		WebUI.click(findTestObject('workOrder/calendar_OK'))

		WebUI.waitForAngularLoad(10)
		WebUI.verifyElementPresent(findTestObject('workOrder/created_WO_List', [('name') :woDescription]), 3)
	}
}
