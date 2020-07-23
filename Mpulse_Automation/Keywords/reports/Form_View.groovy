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
import commonUtils.Common
import work_Order.WO_Redirection

import internal.GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class Form_View {

	@Keyword
	def formView_CurrentRecord_New(String woDescription){

		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :woDescription]), 3)
		WebUI.click(findTestObject('Reports/print_btn'))
		WebUI.waitForAngularLoad(20)
		WebUI.waitForPageLoad(10)
		WebUI.switchToWindowIndex(1)


		try {
			WebUI.waitForElementClickable(findTestObject('Reports/settings_icon'), 5)
			WebUI.click(findTestObject('Reports/settings_icon'))
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
			WebUI.click(findTestObject('Reports/wo_form'))
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Current']))
			WebUI.click(findTestObject('Reports/ok_btn'))
			WebUI.waitForAngularLoad(5)
			WebUI.waitForPageLoad(5)
		} catch (Exception e) {
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
			WebUI.click(findTestObject('Reports/wo_form'))
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Current']))
			WebUI.click(findTestObject('Reports/ok_btn'))
			WebUI.waitForPageLoad(10)
		}
		 //WebUI.waitForElementPresent(findTestObject('Reports/woform'), 5)
		WebUI.delay(4)
		WebUI.verifyElementPresent(findTestObject('Reports/wo_name', [('name') :woDescription]), 3)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	}
	@Keyword
	def formView_CurrentRecord_Old(){

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
		WebUI.waitForElementPresent(findTestObject('Reports/print_btn'), 5)
		WebUI.click(findTestObject('Reports/print_btn'))
		WebUI.waitForAngularLoad(20)
		WebUI.waitForPageLoad(10)
		WebUI.switchToWindowIndex(1)
		try {
			WebUI.waitForElementClickable(findTestObject('Reports/settings_icon'), 5)
			WebUI.click(findTestObject('Reports/settings_icon'))
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
			WebUI.click(findTestObject('Reports/wo_form'))
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Current']))
			WebUI.click(findTestObject('Reports/ok_btn'))
			WebUI.waitForAngularLoad(5)
			WebUI.waitForPageLoad(5)
		} catch (Exception e) {
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/wo_form'))
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Current']))
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/ok_btn'))
			WebUI.waitForPageLoad(10)
		}
		//WebUI.waitForElementPresent(findTestObject('Reports/woform'), 5)
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Reports/wo_name', [('name') :woDescription]), 3)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0)
	}
	@Keyword
	def formView_AllRecord(){

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


		String woDescription = WebUI.getAttribute(findTestObject('Reports/desc_wo'), "title", FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :woDescription]), 3)
		WebUI.click(findTestObject('Reports/print_btn'))
		WebUI.delay(3)
		WebUI.switchToWindowIndex(1)
		WebUI.dismissAlert()

		WebUI.delay(15)
		String wTitle = WebUI.getWindowTitle()

		if(wTitle=='MPulse 8.0 - Reports'){
			WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
			String wTitleL=WebUI.getWindowTitle()
			if(wTitleL=='MPulse V8.0 - MPulse Reports'){
				WebUI.delay(5)
				WebUI.waitForElementPresent(findTestObject('Reports/settings_icon'), 3)
				WebUI.click(findTestObject('Reports/settings_icon'))
				WebUI.delay(5)
				WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
				WebUI.click(findTestObject('Reports/wo_form'))
				WebUI.click(findTestObject('Reports/report_radio', [('value') :'All']))
				WebUI.click(findTestObject('Reports/ok_btn'))
				WebUI.delay(15)
				try {
					WebUI.verifyElementPresent(findTestObject('Reports/report_loading'), 30)
				} catch (Exception e1) {
					WebUI.acceptAlert()
					WebUI.delay(15)
					WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
					WebUI.delay(15)
					WebUI.setText(findTestObject('Reports/search_report'), woDescription)
					WebUI.click(findTestObject('Reports/find_btn'))
					WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
				}
			}
			else{
				WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
				WebUI.delay(5)
				WebUI.waitForElementPresent(findTestObject('Reports/settings_icon'), 3)
				WebUI.click(findTestObject('Reports/settings_icon'))
				WebUI.delay(5)
				WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
				WebUI.click(findTestObject('Reports/wo_form'))
				WebUI.click(findTestObject('Reports/report_radio', [('value') :'All']))
				WebUI.click(findTestObject('Reports/ok_btn'))
				WebUI.delay(15)
				try {
					WebUI.verifyElementPresent(findTestObject('Reports/report_loading'), 30)
				} catch (Exception e2) {
					WebUI.acceptAlert()
					WebUI.delay(15)
					WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
					WebUI.delay(15)
					WebUI.setText(findTestObject('Reports/search_report'), woDescription)
					WebUI.click(findTestObject('Reports/find_btn'))
					WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
				}
			}
		}
		else{
			WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
			WebUI.delay(5)
			WebUI.waitForElementPresent(findTestObject('Reports/settings_icon'), 3)
			WebUI.click(findTestObject('Reports/settings_icon'))
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
			WebUI.click(findTestObject('Reports/wo_form'))
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'All']))
			WebUI.click(findTestObject('Reports/ok_btn'))
			WebUI.delay(15)
			try {
				WebUI.verifyElementPresent(findTestObject('Reports/report_loading'), 30)
			} catch (Exception e2) {
				WebUI.acceptAlert()
				WebUI.delay(15)
				WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
				WebUI.delay(15)
				WebUI.setText(findTestObject('Reports/search_report'), woDescription)
				WebUI.click(findTestObject('Reports/find_btn'))
				WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
			}
		}

		WebUI.verifyElementPresent(findTestObject('Reports/wo_name', [('name') :woDescription]), 3)
	}

	@Keyword
	def formView_CurrentLookup(){

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
		String woDescription = WebUI.getAttribute(findTestObject('Reports/desc_wo'), "title", FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :woDescription]), 3)
		WebUI.click(findTestObject('Reports/print_btn'))
		WebUI.delay(3)
		WebUI.switchToWindowIndex(1)
		WebUI.dismissAlert()

		WebUI.delay(15)
		String wTitle = WebUI.getWindowTitle()

		if(wTitle=='MPulse 8.0 - Reports'){
			WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
			String wTitleL=WebUI.getWindowTitle()
			if(wTitleL=='MPulse V8.0 - MPulse Reports'){
				WebUI.delay(5)
				WebUI.waitForElementPresent(findTestObject('Reports/settings_icon'), 3)
				WebUI.click(findTestObject('Reports/settings_icon'))
				WebUI.delay(5)
				WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
				WebUI.click(findTestObject('Reports/wo_form'))
				WebUI.click(findTestObject('Reports/report_radio', [('value') :'Selected']))
				WebUI.click(findTestObject('Reports/ok_btn'))
				WebUI.delay(15)
				try {
					WebUI.verifyElementPresent(findTestObject('Reports/report_loading'), 30)
				} catch (Exception e1) {
					WebUI.acceptAlert()
					WebUI.delay(15)
					WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
					WebUI.delay(15)
					WebUI.setText(findTestObject('Reports/search_report'), woDescription)
					WebUI.click(findTestObject('Reports/find_btn'))
					WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
				}
			}
			else{
				WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
				WebUI.delay(5)
				WebUI.waitForElementPresent(findTestObject('Reports/settings_icon'), 3)
				WebUI.click(findTestObject('Reports/settings_icon'))
				WebUI.delay(5)
				WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
				WebUI.click(findTestObject('Reports/wo_form'))
				WebUI.click(findTestObject('Reports/report_radio', [('value') :'Selected']))
				WebUI.click(findTestObject('Reports/ok_btn'))
				WebUI.delay(15)
				try {
					WebUI.verifyElementPresent(findTestObject('Reports/report_loading'), 30)
				} catch (Exception e2) {
					WebUI.acceptAlert()
					WebUI.delay(15)
					WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
					WebUI.delay(15)
					WebUI.setText(findTestObject('Reports/search_report'), woDescription)
					WebUI.click(findTestObject('Reports/find_btn'))
					WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
				}
			}
		}
		else{
			WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
			WebUI.delay(5)
			WebUI.waitForElementPresent(findTestObject('Reports/settings_icon'), 3)
			WebUI.click(findTestObject('Reports/settings_icon'))
			WebUI.delay(5)
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Form']))
			WebUI.click(findTestObject('Reports/wo_form'))
			WebUI.click(findTestObject('Reports/report_radio', [('value') :'Selected']))
			WebUI.click(findTestObject('Reports/ok_btn'))
			WebUI.delay(15)
			try {
				WebUI.verifyElementPresent(findTestObject('Reports/report_loading'), 30)
			} catch (Exception e2) {
				WebUI.acceptAlert()
				WebUI.delay(15)
				WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
				WebUI.delay(15)
				WebUI.setText(findTestObject('Reports/search_report'), woDescription)
				WebUI.click(findTestObject('Reports/find_btn'))
				WebUI.waitForElementNotPresent(findTestObject('Reports/report_loading'), 30)
			}
		}

		WebUI.verifyElementPresent(findTestObject('Reports/wo_name', [('name') :woDescription]), 3)
	}
}
