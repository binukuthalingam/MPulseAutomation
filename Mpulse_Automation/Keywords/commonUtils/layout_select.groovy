package commonUtils

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

public class layout_select {
	@Keyword
	def layout_selection(){

		Common URLNavigate = new Common()
		Common login = new Common()
		Common logout = new Common()
		String env = findTestData('Environment').getValue(2, 1)

		String userName = findTestData('Login/Login_fields').getValue(1, 1)

		String password = findTestData('Login/Login_fields').getValue(2, 1)

		String dbName = findTestData('Login/Login_fields').getValue(3, 1)

		URLNavigate.navigateToURL(env)

		login.login(userName, password, dbName)

		Common woInfo_Sel = new Common()
		work_Order.WO_ListView_Redirection listRedirect = new work_Order.WO_ListView_Redirection()

		work_Order.WO_Redirection redirection = new work_Order.WO_Redirection()
		redirection.workOrderRedirection()
		WebUI.waitForPageLoad(5)
		listRedirect.workOrderListLayoutRedirection()
		woInfo_Sel.layoutSelectionList('ID and Description Only')
		logout.logoutAndCloseBrowser()
	}
}
