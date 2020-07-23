package reports

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
import work_Order.WO_Redirection

public class List_View {

	@Keyword
	def ListView(){

		String env = findTestData('Environment').getValue(2, 1)
		String userName = findTestData('Login/Login_fields').getValue(1, 1)
		String password = findTestData('Login/Login_fields').getValue(2, 1)
		String dbName = findTestData('Login/Login_fields').getValue(3, 1)

		Common URLNavigate = new Common()
		URLNavigate.navigateToURL(env)
		Common Login = new Common()
		Login.login(userName, password, dbName)
		WO_Redirection redirection = new WO_Redirection()
		redirection.workOrderRedirection()
		String woDescription = WebUI.getText(findTestObject('Reports/desc_wo'))


		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :woDescription]), 3)
		WebUI.click(findTestObject('Reports/print_btn'))
		WebUI.delay(20)
		WebUI.waitForPageLoad(5)
		WebUI.switchToWindowTitle('MPulse V8.0 - MPulse Reports')
		try {
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/settings_icon'))
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'List']))
			WebUI.delay(5)
			WebUI.scrollToElement(findTestObject('Reports/list_sel'), 5)
			WebUI.click(findTestObject('Reports/list_sel'))
			WebUI.click(findTestObject('Reports/ok_btn'))
			WebUI.delay(10)
		} catch (Exception e) {
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'List']))
			WebUI.delay(5)
			WebUI.scrollToElement(findTestObject('Reports/list_sel'), 5)
			WebUI.click(findTestObject('Reports/list_sel'))
			WebUI.click(findTestObject('Reports/ok_btn'))
			WebUI.delay(10)
		}
		WebUI.verifyElementPresent(findTestObject('Reports/div_list'))
	}
}
