package search

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.gargoylesoftware.htmlunit.javascript.host.geo.Coordinates
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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.Point

import internal.GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.interactions.internal.Locatable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import commonUtils.Common
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor




public class List_View_Search {

	@Keyword
	def listViewSearch_Row(){

		Common URLNavigate = new Common()
		Common login = new Common()

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
		WebUI.delay(3)
		listRedirect.workOrderListLayoutRedirection()
		woInfo_Sel.layoutSelectionList('ID and Description Only')
		String woName = WebUI.getAttribute(findTestObject('workOrder/wo_fromlist',[('value') : 1]), "title")
		WebUI.delay(3)
		WebUI.setText(findTestObject('workOrder/listsearch'), woName)
		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('workOrder/groupAndType',[('name') : woName]), 5)
	}

	@Keyword
	def listViewSearch_Column(){

		Common URLNavigate = new Common()
		Common login = new Common()

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
		//WebUI.waitForAngularLoad(10)
		WebUI.delay(7)
		listRedirect.workOrderListLayoutRedirection()
		WebUI.waitForAngularLoad(10)
		WebUI.clearText(findTestObject('workOrder/listsearch'))
		woInfo_Sel.layoutSelectionList('ID and Description Only')
		//WebUI.waitForPageLoad(10)
		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/filter_icon'))
		//WebUI.waitForAngularLoad(5)
		WebUI.delay(5)
		String woName = WebUI.getText(findTestObject('workOrder/column_sel'))
		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/column_sel'))
		WebUI.delay(3)
		//WebUI.waitForElementClickable(findTestObject('workOrder/calendar_OK'), 5)
		WebUI.click(findTestObject('workOrder/calendar_OK'))
		WebUI.delay(5)
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('workOrder/groupAndType',[('name') : woName]), 5)
	}
}
