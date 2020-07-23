package scheduled_Maintenance_Records

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
import org.openqa.selenium.Keys as Keys
import java.util.Date;
import java.text.SimpleDateFormat;

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class SMR_Creation {

	@Keyword
	def SMRCreationFixed(String SMRDescription, String taskName, String assetName, String inventoryName){

		Common URLNavigate = new Common()
		Common login = new Common()
		Common commonDatepicker = new Common()

		String env = findTestData('Environment').getValue(2, 1)

		String userName = findTestData('Login/Login_fields').getValue(1, 1)

		String password = findTestData('Login/Login_fields').getValue(2, 1)

		String dbName = findTestData('Login/Login_fields').getValue(3, 1)

		URLNavigate.navigateToURL(env)

		login.login(userName, password, dbName)

		Common commonWOInfo_Sel = new Common()

		scheduled_Maintenance_Records.SMR_Redirection redirection = new scheduled_Maintenance_Records.SMR_Redirection ()
		work_Order.WO_FormLayout_Redirection formRedirect = new work_Order.WO_FormLayout_Redirection()
		redirection.SMRRedirection()
		formRedirect.workOrderFormLayoutRedirection()

		try {
			WebUI.waitForPageLoad(30)
			WebUI.waitForAngularLoad(4)
			WebUI.waitForElementClickable(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		} catch (Exception e) {
			WebUI.waitForElementPresent(findTestObject('workOrder/cancel'), 3)
			WebUI.click(findTestObject('workOrder/cancel'))
			WebUI.waitForElementPresent(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5)
			WebUI.waitForAngularLoad(4)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		}

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)

		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		WebUI.sendKeys(findTestObject('SMR/description'), SMRDescription)

		WebUI.waitForPageLoad(10)

		WebUI.waitForElementClickable(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link']), 5, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', taskName, 'Link Task', 'workOrder/taskAndAssetID')

		WebUI.click(findTestObject('workOrder/replace'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link Additional Asset']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', assetName, 'Link Additional Asset', 'workOrder/taskAndAssetID')

		WebUI.click(findTestObject('workOrder/replace'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link Additional Inventory']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', inventoryName, 'Link Inventory', 'workOrder/inventoryID')

		WebUI.click(findTestObject('workOrder/replace'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)

		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :2]))

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'LK_WKOTYPE', 'Event Setup', 'workOrder/groupAndType')

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'LK_WKOGROUP', 'Maintenance', 'workOrder/groupAndType')

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'LK_GENPRIOR', 'High', 'workOrder/groupAndType')

		int recurrance_day = 2



		try {
			WebUI.click(findTestObject('SMR/radio_fixedschtype'))
			WebUI.delay(3)
			WebUI.click(findTestObject('SMR/fixedcalendar'))
			WebUI.delay(3)
			commonDatepicker.calendarDateSelect()
			WebUI.delay(3)
			WebUI.sendKeys(findTestObject('SMR/recurrance_pattern'), Keys.chord(Keys.BACK_SPACE))
			WebUI.sendKeys(findTestObject('SMR/recurrance_pattern'), recurrance_day.toString())
		} catch (Exception e) {
			WebUI.click(findTestObject('SMR/radio_fixedschtype'))
			WebUI.delay(3)
			WebUI.click(findTestObject('SMR/fixedcalendar'))
			WebUI.delay(3)
			commonDatepicker.calendarDateSelect()
			WebUI.delay(3)
			WebUI.sendKeys(findTestObject('SMR/recurrance_pattern'), Keys.chord(Keys.BACK_SPACE))
			WebUI.sendKeys(findTestObject('SMR/recurrance_pattern'), recurrance_day.toString())
			WebUI.delay(3)
		}


		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :4]))

		commonWOInfo_Sel.enterValueInTextField('workOrder/estAndOtherCost', 'EstCost')
		commonWOInfo_Sel.enterValueInTextField('workOrder/estAndOtherCost', 'OtherCost')
		WebUI.click(findTestObject('workOrder/save'))

		//WebUI.waitForPageLoad(10)
		//WebUI.waitForAngularLoad(10)
		WebUI.delay(5)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		WebUI.waitForPageLoad(15)
		String WO_ID= WebUI.getText(findTestObject('workOrder/WO_ID'))
		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :SMRDescription]), 3)
	}

	@Keyword
	def SMRCreationFloating(String SMRDescription, String taskName, String assetName, String inventoryName){

		Common URLNavigate = new Common()
		Common login = new Common()
		Common commonDatepicker = new Common()

		String env = findTestData('Environment').getValue(2, 1)

		String userName = findTestData('Login/Login_fields').getValue(1, 1)

		String password = findTestData('Login/Login_fields').getValue(2, 1)

		String dbName = findTestData('Login/Login_fields').getValue(3, 1)

		URLNavigate.navigateToURL(env)

		login.login(userName, password, dbName)

		Common commonWOInfo_Sel = new Common()

		scheduled_Maintenance_Records.SMR_Redirection redirection = new scheduled_Maintenance_Records.SMR_Redirection ()
		work_Order.WO_FormLayout_Redirection formRedirect = new work_Order.WO_FormLayout_Redirection()
		redirection.SMRRedirection()
		formRedirect.workOrderFormLayoutRedirection()

		try {
			WebUI.waitForPageLoad(30)
			WebUI.waitForAngularLoad(4)
			WebUI.waitForElementClickable(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		} catch (Exception e) {

			WebUI.waitForElementPresent(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5)
			WebUI.waitForAngularLoad(4)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		}
		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(12)


		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		WebUI.sendKeys(findTestObject('SMR/description'), SMRDescription)

		WebUI.waitForPageLoad(10)

		WebUI.waitForElementClickable(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link']), 5, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', taskName, 'Link Task', 'workOrder/taskAndAssetID')

		WebUI.click(findTestObject('workOrder/replace'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link Additional Asset']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', assetName, 'Link Additional Asset', 'workOrder/taskAndAssetID')

		WebUI.click(findTestObject('workOrder/replace'))
		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link Additional Inventory']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', inventoryName, 'Link Inventory', 'workOrder/inventoryID')

		WebUI.click(findTestObject('workOrder/replace'))
		WebUI.waitForPageLoad(12)
		WebUI.waitForAngularLoad(12)

		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :2]))

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'LK_WKOTYPE', 'Event Setup', 'workOrder/groupAndType')

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'LK_WKOGROUP', 'Maintenance', 'workOrder/groupAndType')

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'LK_GENPRIOR', 'High', 'workOrder/groupAndType')

		int recurrance_day = 2



		try {
			WebUI.click(findTestObject('SMR/floatcalendar'))
			WebUI.delay(3)
			commonDatepicker.calendarDateSelect()
			WebUI.sendKeys(findTestObject('SMR/recurrance_pattern'), Keys.chord(Keys.BACK_SPACE))
			WebUI.sendKeys(findTestObject('SMR/recurrance_pattern'), recurrance_day.toString())
		} catch (Exception e) {
			WebUI.click(findTestObject('SMR/floatcalendar'))
			WebUI.delay(3)
			commonDatepicker.calendarDateSelect()
			WebUI.sendKeys(findTestObject('SMR/recurrance_pattern'), Keys.chord(Keys.BACK_SPACE))
			WebUI.sendKeys(findTestObject('SMR/recurrance_pattern'), recurrance_day.toString())
			WebUI.delay(3)
		}

		WebUI.waitForPageLoad(10)
		WebUI.delay(3)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :4]))

		commonWOInfo_Sel.enterValueInTextField('workOrder/estAndOtherCost', 'EstCost')
		commonWOInfo_Sel.enterValueInTextField('workOrder/estAndOtherCost', 'OtherCost')

		WebUI.click(findTestObject('workOrder/save'))

		WebUI.delay(10)
		//WebUI.waitForAngularLoad(20)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		WebUI.waitForPageLoad(15)
		String WO_ID= WebUI.getText(findTestObject('workOrder/WO_ID'))
		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :SMRDescription]), 3)
	}

	@Keyword
	def SMRCreationMeterBased(String SMRDescription, String taskName, String assetName, String inventoryName){

		Common URLNavigate = new Common()
		Common login = new Common()
		Common commonDatepicker = new Common()

		String env = findTestData('Environment').getValue(2, 1)

		String userName = findTestData('Login/Login_fields').getValue(1, 1)

		String password = findTestData('Login/Login_fields').getValue(2, 1)

		String dbName = findTestData('Login/Login_fields').getValue(3, 1)

		URLNavigate.navigateToURL(env)

		login.login(userName, password, dbName)

		Common commonWOInfo_Sel = new Common()

		scheduled_Maintenance_Records.SMR_Redirection redirection = new scheduled_Maintenance_Records.SMR_Redirection ()
		work_Order.WO_FormLayout_Redirection formRedirect = new work_Order.WO_FormLayout_Redirection()
		redirection.SMRRedirection()
		formRedirect.workOrderFormLayoutRedirection()

		try {
			WebUI.waitForPageLoad(30)
			WebUI.waitForAngularLoad(4)
			WebUI.waitForElementClickable(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		} catch (Exception e) {
			WebUI.waitForElementPresent(findTestObject('workOrder/cancel'), 3)
			WebUI.click(findTestObject('workOrder/cancel'))
			WebUI.waitForElementPresent(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']), 5)
			WebUI.waitForAngularLoad(4)
			WebUI.click(findTestObject('workOrder/addAndEdit', [('name') :'Add new record']))
		}

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)

		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		WebUI.sendKeys(findTestObject('SMR/description'), SMRDescription)

		WebUI.waitForPageLoad(10)

		WebUI.waitForElementClickable(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link']), 5, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', taskName, 'Link Task', 'workOrder/taskAndAssetID')
		WebUI.click(findTestObject('workOrder/replace'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link Additional Asset']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', assetName, 'Link Additional Asset', 'workOrder/taskAndAssetID')

		WebUI.click(findTestObject('workOrder/replace'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)
		WebUI.click(findTestObject('workOrder/link_Asset_Task_Inventory', [('name') :'Link Additional Inventory']))

		commonWOInfo_Sel.woInfoLinkSearch('workOrder/infoLink_Search', inventoryName, 'Link Inventory', 'workOrder/inventoryID')

		WebUI.click(findTestObject('workOrder/replace'))

		WebUI.waitForPageLoad(10)
		WebUI.waitForAngularLoad(10)

		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :2]))

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'LK_WKOTYPE', 'Event Setup', 'workOrder/groupAndType')

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'LK_WKOGROUP', 'Maintenance', 'workOrder/groupAndType')

		commonWOInfo_Sel.selectValueFromDrop('workOrder/woTypeAndGroup', 'LK_GENPRIOR', 'High', 'workOrder/groupAndType')

		WebUI.click(findTestObject('SMR/timebased'))
		WebUI.waitForElementClickable(findTestObject('SMR/timebasedcheck'), 5)
		WebUI.click(findTestObject('SMR/timebasedcheck'))
		WebUI.delay(3)
		WebUI.waitForElementClickable(findTestObject('SMR/meterbased'), 5)
		WebUI.click(findTestObject('SMR/meterbased'))
		try {
			WebUI.waitForElementClickable(findTestObject('SMR/meterbasedcheck'), 5)
			WebUI.click(findTestObject('SMR/meterbasedcheck'))
		} catch (Exception e) {
			WebUI.waitForAngularLoad(5)
			WebUI.waitForElementClickable(findTestObject('SMR/meterbasedcheck'), 5)
			WebUI.click(findTestObject('SMR/meterbasedcheck'))
		}

		int recurrance_day = 2

		commonWOInfo_Sel.selectValueFromDrop('SMR/assettotrigger', 'configAssetToUse', assetName, 'SMR/assetselect')
		WebUI.waitForAngularLoad(5)
		commonWOInfo_Sel.selectValueFromDrop('SMR/assettotrigger', 'configAssetMeter', 'Air Temp - In', 'SMR/meterselect')
		WebUI.waitForAngularLoad(5)
		commonWOInfo_Sel.enterValueInTextField('SMR/unitsbtw', 'configUnitsBetweenMaintenanceTextBox')

		WebUI.waitForAngularLoad(5)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :4]))

		commonWOInfo_Sel.enterValueInTextField('workOrder/estAndOtherCost', 'EstCost')
		commonWOInfo_Sel.enterValueInTextField('workOrder/estAndOtherCost', 'OtherCost')

		WebUI.click(findTestObject('workOrder/save'))

		//WebUI.waitForPageLoad(10)
		//WebUI.waitForAngularLoad(10)
		WebUI.delay(30)
		WebUI.click(findTestObject('workOrder/workOrderTabs', [('value') :1]))

		WebUI.waitForPageLoad(15)
		String WO_ID= WebUI.getText(findTestObject('workOrder/WO_ID'))
		WebUI.verifyElementPresent(findTestObject('workOrder/WO_description', [('name') :SMRDescription]), 3)
	}
}
