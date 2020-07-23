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
import maintenance_Records.MR_Creation_FormLayout

public class MR_ConverttoWO {

	@Keyword
	def MRtoWO(String woDescription){

		WebUI.waitForElementClickable(findTestObject('maintenanceRecords/converttoWO'), 5)
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('maintenanceRecords/converttoWO'))
		WebUI.waitForElementPresent(findTestObject('maintenanceRecords/confirmYes'), 5)
		WebUI.delay(5)
		WebUI.click(findTestObject('maintenanceRecords/confirmYes'))
		WebUI.delay(8)
		WebUI.click(findTestObject('maintenanceRecords/confirmYes'))
		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :woDescription]), 3)
	}
}
