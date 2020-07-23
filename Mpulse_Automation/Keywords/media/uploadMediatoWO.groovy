package media

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
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.By

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import commonUtils.Common

public class uploadMediatoWO {

	@Keyword
	def uploadMedia(String mediaName){

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
		WebUI.waitForPageLoad(5)
		listRedirect.workOrderListLayoutRedirection()
		WebUI.waitForPageLoad(5)
		WebUI.click(findTestObject('workOrder/wolayout'))
		WebUI.waitForAngularLoad(10)
		WebUI.scrollToElement(findTestObject('SMR/scrollcontainer'), 3)
		WebUI.click(findTestObject('SMR/scrollcontainer'))
		WebUI.waitForAngularLoad(5)
		WebUI.delay(3)
		TestObject minimizeListLayout = findTestObject('workOrder/expandAndMinimize', [('name') :'Minimize'])
		WebUI.click(minimizeListLayout)
		WebUI.waitForPageLoad(5)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :3]))
		WebUI.waitForElementClickable(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Click here to upload media']), 5)
		WebUI.waitForPageLoad(5)
		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Click here to upload media']))
		WebUI.waitForPageLoad(5)
		String home = System.getProperty('user.home')
		WebUI.uploadFile(findTestObject('SMR/choosefile'), home + '\\\\Documents\\\\sample.pdf')
		WebUI.waitForAngularLoad(10)
		WebUI.waitForPageLoad(5)
		WebUI.waitForElementPresent(findTestObject('workOrder/media_desc'), 3)
		WebUI.clearText(findTestObject('workOrder/media_desc'))
		WebUI.setText(findTestObject('workOrder/media_desc'), mediaName)
		WebUI.click(findTestObject('SMR/upload'))
		WebUI.waitForElementPresent(findTestObject('workOrder/media_verify',[('name') :mediaName]), 5)
		WebUI.verifyElementPresent(findTestObject('workOrder/media_verify',[('name') :mediaName]), 3)
		WebUI.waitForElementClickable(findTestObject('workOrder/media_verify',[('name') :mediaName]), 5)
		WebUI.click(findTestObject('workOrder/media_verify',[('name') :mediaName]))
		WebUI.click(findTestObject('workOrder/media_lens'))
		WebUI.waitForAngularLoad(10)
		WebUI.switchToFrame(findTestObject('workOrder/media_frame'), 3, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(10)
		WebUI.verifyElementPresent(findTestObject('workOrder/media_container'), 4)
		WebUI.switchToDefaultContent()
		WebUI.click(findTestObject('workOrder/mediaclose'))
		WebUI.waitForAngularLoad(10)
	}
}
