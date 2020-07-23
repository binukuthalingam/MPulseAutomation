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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class WO_FormLayout_Redirection {

	@Keyword
	def workOrderFormLayoutRedirection(){

		TestObject expandLayoutMenu = findTestObject('workOrder/expandAndMinimize', [('name') :'Show'])
		TestObject hideListLayoutSection = findTestObject('workOrder/hideListLayout')
		TestObject minimizeListLayout = findTestObject('workOrder/expandAndMinimize', [('name') :'Minimize'])
		TestObject hideMainMenu = findTestObject('workOrder/hideMenu')
		try {
			WebUI.delay(3)
			WebUI.click(findTestObject('workOrder/cancel'))
			WebUI.delay(3)
		} catch (Exception e) {

			try {
				WebUI.waitForPageLoad(10)
				WebUI.delay(3)
				WebUI.waitForElementClickable(expandLayoutMenu, 3)
				WebUI.click(expandLayoutMenu)
				WebUI.delay(3)
				WebUI.click(hideListLayoutSection)
				WebUI.delay(3)
			} catch (Exception e1) {

				try {

					WebUI.waitForPageLoad(10)
					WebUI.delay(3)
					WebUI.waitForElementClickable(hideListLayoutSection, 3)
					WebUI.click(hideListLayoutSection)
					WebUI.delay(3)
				} catch (Exception e2) {

					WebUI.delay(3)
					WebUI.click(hideMainMenu)
					WebUI.delay(5)
					WebUI.click(minimizeListLayout)
					WebUI.delay(3)
					WebUI.click(hideListLayoutSection)
				}
			}
		}
	}
}

