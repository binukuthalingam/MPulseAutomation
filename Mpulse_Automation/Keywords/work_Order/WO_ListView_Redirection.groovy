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

public class WO_ListView_Redirection {

	@Keyword
	def workOrderListLayoutRedirection(){

		TestObject minimizeListLayout = findTestObject('workOrder/expandAndMinimize', [('name') :'Minimize'])
		TestObject hideMainMenu = findTestObject('workOrder/hideMenu')
		TestObject maximizeListLayout = findTestObject('workOrder/expandAndMinimize', [('name') :'Maximize'])

		try {
			WebUI.delay(3)
			WebUI.click(findTestObject('workOrder/cancel'))
			WebUI.delay(3)
		} catch (Exception e) {
			try {
				WebUI.waitForPageLoad(10)
				WebUI.delay(3)
				WebUI.verifyElementPresent(hideMainMenu, 3)
				WebUI.click(hideMainMenu)
				WebUI.delay(3)
				WebUI.verifyElementPresent(minimizeListLayout, 3)
			} catch (Exception e1) {

				try {

					WebUI.waitForPageLoad(10)
					WebUI.delay(3)
					WebUI.verifyElementPresent(maximizeListLayout, 3)
					WebUI.delay(5)
					WebUI.click(maximizeListLayout)
					WebUI.delay(3)
				} catch (Exception e2) {

					WebUI.delay(3)
					WebUI.verifyElementPresent(maximizeListLayout, 3)
					WebUI.delay(3)
					WebUI.click(maximizeListLayout)
					WebUI.delay(3)
				}
			}
		}
	}
}
