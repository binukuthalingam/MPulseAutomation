package commonUtils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.eclipse.persistence.internal.oxm.record.json.JSONParser.value_return

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.By as By
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
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.Keys as Keys
import java.awt.Robot
import java.awt.Toolkit
import java.util.concurrent.TimeUnit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.util.NoSuchElementException;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import internal.GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import java.util.Date;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver as WebDriver

public class Common {

	@Keyword
	def navigateToURL(String url){
		WebUI.openBrowser('')

		WebUI.maximizeWindow()

		WebUI.navigateToUrl(url)
	}

	@Keyword
	def redirectToMA(){

		WebUI.delay(3)
		WebUI.click(findTestObject('homePage/MA'))
		WebUI.delay(3)
	}



	@Keyword
	def login(String userName, String password, String databaseName){

		WebUI.waitForElementClickable(findTestObject('loginPage/username'), 2)

		WebUI.setText(findTestObject('loginPage/username'), userName)

		WebUI.setText(findTestObject('loginPage/password'), password)

		WebUI.sendKeys(findTestObject('loginPage/database_name'), databaseName)

		WebUI.click(findTestObject('loginPage/Login_btn'))
	}

	@Keyword
	def woInfoLinkSearch(String object, String value,String xpathvalue, String object1 ){

		WebUI.delay(6)
		WebUI.sendKeys(findTestObject(object, [('name') :xpathvalue]),value)

		WebUI.delay(6)
		WebUI.click(findTestObject(object1, [('name') :value]))
	}

	@Keyword
	def selectValueFromDrop(String object, String value,String value2, String object1 ){

		WebUI.delay(3)
		WebUI.click(findTestObject(object, [('name') :value]))

		WebUI.delay(3)
		WebUI.click(findTestObject(object1, [('name') :value2]))
	}
	@Keyword
	def selectValueFromDrop1(String object,String value,String value2,String object1,String value3){
		WebUI.delay(3)
		WebUI.click(findTestObject(object, [('name') :value]))

		WebUI.delay(3)
		WebUI.click(findTestObject(object1, [('name') :value2,('number'): value3]))
	}
	@Keyword
	def editandsave(String object,String value,String value2){
		WebUI.delay(3)
		WebUI.click(findTestObject(object, [('name') :value,('number'): value2]))
	}
	@Keyword
	def enterValueInTextField(String object, String value ){

		WebUI.delay(3)
		WebUI.sendKeys(findTestObject(object, [('name') :value]), Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject(object, [('name') :value]), '15')
	}

	@Keyword
	def enterValueInTextField1(String object,String value,String text){

		WebUI.delay(3)
		WebUI.sendKeys(findTestObject(object, [('name') :value]), text)
	}
	@Keyword
	def tabswitch(String object,String value){
		WebUI.delay(3)
		WebUI.click(findTestObject(object, [('name') :value]))
	}
	@Keyword
	def linkandreplace(String object,String value) {
		WebUI.delay(3)
		WebUI.click(findTestObject(object, [('name') :value]))
	}
	@Keyword
	def req_status(String object,String value) {
		WebUI.delay(3)
		WebUI.click(findTestObject(object, [('name') :value]))
	}
	@Keyword
	def calendarDateSelect1(String var){

		Calendar calendar = Calendar.getInstance()
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/d")
		calendar.add(Calendar.DAY_OF_YEAR, 1)
		Date tomorrow = calendar.getTime()
		String t= sdf.format(tomorrow)
		WebUI.click(findTestObject('POR/date_tmrw',[('date'):t,('value'):var]))
	}
	@Keyword
	def calendarDateSelect(){

		Calendar calendar = Calendar.getInstance()
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/d")
		calendar.add(Calendar.DAY_OF_YEAR, 1)
		Date tomorrow = calendar.getTime()
		String t= sdf.format(tomorrow)
		WebUI.click(findTestObject('workOrder/calendar_tom',[('date'):t,('value'):'1']))
		//WebUI.click(findTestObject('workOrder/calendar_OK'))
	}

	@Keyword
	def uploadFile(TestObject to, String filePath) {
		WebUI.click(to)
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@Keyword
	def layoutSelectionList(String layoutName){


		WebUI.waitForAngularLoad(10)
		WebUI.delay(5)
		//WebUI.waitForElementClickable(findTestObject('workOrder/layoutlist'), 5)
		WebUI.click(findTestObject('workOrder/layoutlist'))
		WebUI.delay(5)
		for(int i=1;i<38;i++){
			WebDriver driver = DriverFactory.getWebDriver()
			Actions actions = new Actions(driver)
			actions.sendKeys(Keys.ARROW_DOWN).build().perform()
		}

		WebUI.waitForAngularLoad(10)
		WebUI.scrollToElement(findTestObject('workOrder/sellay',[('name') : layoutName]), 3)
		WebUI.click(findTestObject('workOrder/sellay',[('name') : layoutName]))
	}

	@Keyword
	def WaitForElementPresent(String locator, String locatedBy) {
		WebDriver driver = DriverFactory.getWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		switch (locatedBy) {
			case "ClassName":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
				break;
			case "CssSelector":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
				break;
			case "Id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				break;
			case "LinkText":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
				break;
			case "Name":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
				break;
			case "PartialLinkText":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
				break;
			case "TagName":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
				break;
			case "XPath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
				break;
		}
	}

	@Keyword
	def logoutAndCloseBrowser(){
		WebUI.delay(5)
		try {
			WebUI.click(findTestObject('homePage/settings'))
		} catch (Exception e) {
			WebUI.delay(6)
			WebUI.waitForElementPresent(findTestObject('homePage/settings'), 10)
			WebUI.click(findTestObject('homePage/settings'))
		}
		WebUI.click(findTestObject('workOrder/WORecords', [('name') :'Logout']))
		WebUI.waitForElementPresent(findTestObject('loginPage/username'), 2)
		WebUI.closeBrowser()
	}


	@Keyword
	def getTotalCountOfElement(String xPath){
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> xpath = driver.findElements(By.xpath(xPath));
		int xpathCount = xpath.size();
		return xpathCount
	}
}

