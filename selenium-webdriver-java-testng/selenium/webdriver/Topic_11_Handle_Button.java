package webdriver;
import static org.testng.Assert.assertEquals;

import java.sql.DriverManager;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_11_Handle_Button {
	WebDriver driver;
	WebDriverWait expliciWait ;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	Select select;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		expliciWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS );
	}
	
	
	public void TC_01_Button() throws InterruptedException{
		driver.get("https://www.fahasa.com/customer/account/create");
		
		String loginButton ="//button[@class='fhs-btn-login']";
		
		clicktoElement("//li[@class='popup-login-tab-item popup-login-tab-login']");
		
		Assert.assertFalse(driver.findElement(By.xpath(loginButton)).isEnabled());
		Thread.sleep(1000);
		senkeytoElement("//input[@id='login_username']", "phamxuanle833@gmail.com");
		senkeytoElement("//input[@id='login_password']", "01635982872@Leex");	
		Thread.sleep(1000);
		
		Assert.assertTrue(driver.findElement(By.xpath(loginButton)).isEnabled());
		
		String rbgClolor = driver.findElement(By.xpath(loginButton)).getCssValue("background-color");
		System.out.println("RGBA =" + rbgClolor);
		
		String hexaColor = Color.fromString(rbgClolor).asHex().toUpperCase();
		Assert.assertEquals(hexaColor, "#C92127");
		
		
		driver.navigate().refresh();
		clicktoElement("//li[@class='popup-login-tab-item popup-login-tab-login']");
		
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", driver.findElement(By.xpath(loginButton)));
		Thread.sleep(1000);
		clicktoElement(loginButton);
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='popup-login-content']//label[contains(text(),'Số điện thoại/Email')]/following-sibling::div[@class='fhs-input-alert']")).getText(),"Thông tin này không thể để trống");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='popup-login-content']//label[contains(text(),'Mật khẩu')]/following-sibling::div[@class='fhs-input-alert']")).getText(),"Thông tin này không thể để trống");
		
	}
	
	public void TC_02_Radio_Default()  throws InterruptedException {
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='kd-loader']")));
		
		String petroltwo ="//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input";
		Assert.assertFalse(driver.findElement(By.xpath(petroltwo)).isSelected());
		
		clicktoElement(petroltwo);
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath(petroltwo)).isSelected());
		
		clicktoElement(petroltwo);
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath(petroltwo)).isSelected());
		
		String petrolone ="//label[text()='1.6 Diesel, 77kW']/preceding-sibling::span/input";
		
		clicktoElement(petrolone);
		Thread.sleep(1000);
		Assert.assertFalse(driver.findElement(By.xpath(petroltwo)).isSelected());
		
		Assert.assertTrue(driver.findElement(By.xpath(petrolone)).isSelected());
		
		String petrolthree ="//label[text()='3.6 Petrol, 191kW']/preceding-sibling::span/input";
		Assert.assertFalse(driver.findElement(By.xpath(petrolthree)).isEnabled());
	}
	
	public void TC_03_Checkbox_Default() throws InterruptedException {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='kd-loader']")));
		
		String rearsideCheckbox ="//label[text()='Rear side airbags']/preceding-sibling::span/input";
		checktoCheckbox(rearsideCheckbox);
		Assert.assertTrue(driver.findElement(By.xpath(rearsideCheckbox)).isSelected());
		
		unchecktoCheckbox(rearsideCheckbox);
		Assert.assertFalse(driver.findElement(By.xpath(rearsideCheckbox)).isSelected());
		
		String headtedfrontCheckbox ="//label[text()='Heated front and rear seats']/preceding-sibling::span/input";
		unchecktoCheckbox(headtedfrontCheckbox);
		Assert.assertFalse(driver.findElement(By.xpath(headtedfrontCheckbox)).isSelected());
		
		checktoCheckbox(headtedfrontCheckbox);
		Assert.assertTrue(driver.findElement(By.xpath(headtedfrontCheckbox)).isSelected());
	}
	
	
	public void TC_04_Custom_Radio() throws InterruptedException {
		driver.get("https://material.angular.io/components/radio/examples");
//		driver.get("https://login.ubuntu.com/");
		// Dùng thẻ Input nhưng không click được - có thể dùng để verify được.
//		String winterRadioButton = "//input[@id='id_returning_user']";
//		clicktoElement(winterRadioButton);
//		Thread.sleep(1000);
//		Assert.assertTrue(driver.findElement(By.xpath(winterRadioButton)).isSelected());
		Thread.sleep(2000);
//		String winterRadioButton = "//input[@id='id_returning_user']/preceding-sibling::label[contains(@class,'new-user')]";
//		clicktoElement(winterRadioButton);
//		Thread.sleep(2000);
//		Assert.assertTrue(driver.findElement(By.xpath(winterRadioButton)).isSelected());
//		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='id_returning_user']")).isSelected());
//		String winterRadioSpan ="//input[@id='mat-radio-2-input']/preceding-sibling::div[contains(@class,'mdc-radio')]";
		String winterRadioInput="//input[@id='mat-radio-2-input']";
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(winterRadioInput)));
		Assert.assertTrue(driver.findElement(By.xpath(winterRadioInput)).isSelected());
	}
	public void TC_05_Custom_Radio() throws InterruptedException {
		driver.get("https://login.ubuntu.com/");
		String idontRadioInput="//input[@id='id_new_user']";
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(idontRadioInput)));
		Assert.assertTrue(driver.findElement(By.xpath(idontRadioInput)).isSelected());
	}
	
	public void TC_06_Custom_Checkbox() throws InterruptedException {
		driver.get("https://login.ubuntu.com/");
		
		String checkCheckbox ="//label[text()='I have read and accept the ']/preceding-sibling::input";
		String idontRadioInput="//input[@id='id_new_user']";
		clicktoElemetnJS(idontRadioInput);
		Thread.sleep(1000);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",  driver.findElement(By.xpath(checkCheckbox)));
		checktoCheckboxJS(checkCheckbox);
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath(checkCheckbox)).isSelected());

	}
	
	@Test
	public void TC_07_Custom_Radio_Noinput() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Hà Nội' and @aria-checked='false']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Hà Nội']")).getAttribute("aria-checked"), "false");
		checktoRadiocheckbox("//div[@aria-label='Hà Nội']");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Hà Nội']")).getAttribute("aria-checked"), "true");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Hà Nội' and @aria-checked='true']")).isDisplayed());
	}
	
	
	
	
	
	
	public boolean elementIsDisplayed(String elementXpath) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		if(element.isDisplayed()) {
			return true;
		}else {
			return false;
		}
		
	}
	public boolean elementIsEnable(String elementXpath) { 
		WebElement element = driver.findElement(By.xpath(elementXpath));
		if(element.isEnabled()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean elementisSelected(String elementXpath) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		if(element.isSelected()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void clicktoElement(String elemenXpath) {
		WebElement element = driver.findElement(By.xpath(elemenXpath));
		element.click();
	}
	
	public void senkeytoElement(String elemenXpath, String value ) {
		WebElement element = driver.findElement(By.xpath(elemenXpath));
		element.clear();
		element.sendKeys(value);
	}
	
	public void selectInDropdownList(String xpathParent, String xpathChild, String expected) {
		expliciWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathParent))).click();
		List<WebElement> allelements = expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathChild)));
		for(WebElement item :allelements) {
			if(item.getText().equals(expected)) {
				if(item.isDisplayed()) {
					item.click();
				}else {
					jsExecutor.executeScript("argument[0].scrollIntoview(true);", item);
					item.click();
				}
				break;
			}
		}
	}
	public void selectEditedDropdownList (String xpathParent,String xpathChild,String expected) {
		driver.findElement(By.xpath(xpathParent)).clear();
		driver.findElement(By.xpath(xpathParent)).sendKeys(expected);
		List<WebElement> allelements = expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathChild)));
		for(WebElement item :allelements) {
			if(item.getText().endsWith(expected)) {
				if(item.isDisplayed()) {
					item.click();
				}else {
					jsExecutor.executeScript("argument[0].scrollIntoview(true);", item);
					item.click();
				}
				break;
			}
		}
	}
	public void selecttMutipleDropdownList (String xpathParent,String xpathChild,String[] expectedValue) {
		driver.findElement(By.xpath(xpathParent)).click();
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathChild)));
		List<WebElement> allelements = driver.findElements(By.xpath(xpathChild));
		for(WebElement childElement : allelements) {
			for(String item :expectedValue) {
				if(childElement.getText().equals(expectedValue)) {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);

					childElement.click();
					
					List <WebElement> itemSelected =driver.findElements(By.xpath("//li[@class='selected']"));
					System.out.println("item Selected="+itemSelected.size());
					if(expectedValue.length==itemSelected.size()) {
						break;
				}
				
			}
		}
		}
	}
	public void checktoCheckbox(String xpathCheckbox) {
		if(!driver.findElement(By.xpath(xpathCheckbox)).isSelected()) {
			driver.findElement(By.xpath(xpathCheckbox)).click();
			
		}
	}
	
	public void unchecktoCheckbox(String xpathCheckbox) {
		if(	driver.findElement(By.xpath(xpathCheckbox)).isSelected()) {
			driver.findElement(By.xpath(xpathCheckbox)).click();
			
		}
	}
	public void clicktoElemetnJS(String xpath) {

		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
	}
	public void checktoCheckboxJS(String xpath) {
		if(!driver.findElement(By.xpath(xpath)).isSelected()) {
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
		}
	}
	public void unchecktoCheckboxJS(String xpath) {
		if(driver.findElement(By.xpath(xpath)).isSelected()) {
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
		}
	}
	public void checktoRadiocheckbox(String xpath) {
		if(!driver.findElement(By.xpath(xpath)).isSelected()) {
			driver.findElement(By.xpath(xpath)).click();
		}
		
	}
	@AfterClass
	public void afterClass() {
		try {
		    Thread.sleep(5000); 
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		driver.quit();
	}
	
}
