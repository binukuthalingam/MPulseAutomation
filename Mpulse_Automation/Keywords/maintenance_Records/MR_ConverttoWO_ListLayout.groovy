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

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class MR_ConverttoWO_ListLayout {

	@Keyword
	def convertWKOFromListLayout(String woDescription){

		WebUI.waitForPageLoad(10)
		WebUI.delay(5)
		WebUI.click(findTestObject('maintenanceRecords/covertToWKO'))
		WebUI.delay(3)
		WebUI.click(findTestObject('maintenanceRecords/ConfirmYes'))
		WebUI.delay(5)
		WebUI.click(findTestObject('maintenanceRecords/ConfirmYes'))
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('workOrder/created_WO_List', [('name') :woDescription]), 3)
	}
}
