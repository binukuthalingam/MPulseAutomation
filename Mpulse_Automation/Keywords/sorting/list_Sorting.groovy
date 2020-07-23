package sorting

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
import java.awt.event.KeyEvent
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.testng.Assert

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import commonUtils.Common

public class list_Sorting {

	@Keyword
	def listViewSort_Desc(){
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

		WebDriver driver = DriverFactory.getWebDriver()


		WebElement Table = driver.findElement(By.xpath('//div[@class=\'dx-datagrid\']'))


		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))

		int rows_count = rows_table.size()

		String[] celltext = new String[rows_count]

		for (int row = 0; row < rows_count; row++) {

			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))

			String celltext_1 = Columns_row.get(0).getText()

			celltext[row] = celltext_1
		}
		String[] celltextBefore = celltext;

		Arrays.sort(celltext, Collections.reverseOrder());

		if(Arrays.equals(celltextBefore, celltext)) {
			System.out.println("Celltext is in descending order");
		}
		else{
			System.out.println("Celltext is not in descending order");
		}
	}
}
