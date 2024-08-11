package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_07_Browser_Element3 {
	// Khai bao bien driver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	 By textboxEmailBy = By.xpath("//input[@id='mail']");
	 By ageRadioBy = By.xpath("//input[@id='under_18']");
	 By textboxNumberBy = By.xpath("//input[@id='number']");
	 By user5By = By.xpath("//h5[text()='Name: User5']");
	 By textboxPasswordBy = By.xpath("//input[@id='disable_password']");
	 By singleDropdownBy = By.xpath("//select[@id='job1']");
	 By disableDropdownBy = By.xpath("//select[@id='job3']");
	 By checkboxDevelopmentBy = By.xpath("//input[@id='development']");
	 By checkboxDisableBy = By.xpath("//input[@id='check-disbaled']");
	 By checkboxJavaBy = By.xpath("//input[@id='java']");
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS );
	 
//	 driver.get("https://automationfc.github.io/basic-form/index.html");
	}
	
//	 @Test
//	 public void TC_01_Isdisplay() {
//		 
//		 WebElement textboxEmail = driver.findElement(By.xpath("//input[@id='mail']"));
//		 if (textboxEmail.isDisplayed()) {
//			 textboxEmail.sendKeys("phamxuanle833@gmail.com");
//			 System.out.println("text box email is displayed");
//		 } else {
//			 System.out.println("text box email is not displayed");
//		 }
//		 
//		 WebElement textboxNumber = driver.findElement(By.xpath("//input[@id='number']"));
//		 if (textboxNumber.isDisplayed()) {
//			 textboxNumber.sendKeys("0849034241");
//			 System.out.println("text box number is displayed");
//		 } else {
//			 System.out.println("text box number is not displayed");
//		 }
//		 
//		 WebElement ageCheckbox = driver.findElement(By.xpath("//input[@id='under_18']"));
//		 if (ageCheckbox.isDisplayed()) {
//			 ageCheckbox.click();
//			 System.out.println("check box đã được chọn");
//		 }else {
//			 System.out.println("check box chưa được chọn");
//		 }
//		 WebElement textboxEducation = driver.findElement(By.xpath("//textarea[@id='edu']"));
//		 if (textboxEducation.isDisplayed()) {
//			 textboxEducation.sendKeys("Cao thang Techniacal");
//			 System.out.println("text box number is displayed");
//		 }else {
//			 System.out.println("text box number is not displayed");
//		 }
//		 WebElement user5 = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
//		 if (user5.isDisplayed()) {
//			 System.out.println("user 5 is displayed");
//		 }else {
//			 System.out.println("user 5 is not displayed");
//		 }
//	 }
//	@Test
//	public void TC_02_Isenable() {
//		
//		driver.navigate().refresh();
//		
//		 WebElement textboxEmail = driver.findElement(By.xpath("//input[@id='mail']"));
//		 if (textboxEmail.isEnabled()) {
//			 textboxEmail.sendKeys("phamxuanle833@gmail.com");
//			 System.out.println("text box email is enable");
//		 } else {
//			 System.out.println("text box email is disable");
//		 }
//		 
//		 WebElement textboxNumber = driver.findElement(By.xpath("//input[@id='number']"));
//		 if (textboxNumber.isEnabled()) {
//			 textboxNumber.sendKeys("0849034241");
//			 System.out.println("text box number is enable");
//		 } else {
//			 System.out.println("text box number is not enable");
//		 }
//		
//		WebElement textboxPassword = driver.findElement(By.xpath("//input[@id='disable_password']"));
//		 if (textboxPassword.isEnabled()) {
//			 textboxPassword.sendKeys("123456");
//			 System.out.println("text box password is enable");
//		 } else {
//			 String placeholderText = textboxPassword.getAttribute("placeholder");
//			 System.out.println(placeholderText);
//			 System.out.println("text box password is disable");
//		 }
//	}
	
	@Test
	public void TC_03_Is_Displayed_Refactor() {
		 driver.get("https://automationfc.github.io/basic-form/index.html");
		 
			 
		 if (isElenemtDisplayed(textboxEmailBy)) {
			 sendkeytoElement(textboxEmailBy,"automationtest");
		 }
		 if (isElenemtDisplayed(ageRadioBy)) {
			 clicktoElement(ageRadioBy);
		 }
		 if (isElenemtDisplayed(textboxNumberBy)) {
			 sendkeytoElement(textboxNumberBy,"0849034241");
		 }
		 Assert.assertFalse(isElenemtDisplayed(user5By));
	}
	
	@Test
	public void TC_04_Is_Enable_Refactor() {
		 driver.get("https://automationfc.github.io/basic-form/index.html");
		 
		 Assert.assertTrue(isElenemtEnable(textboxEmailBy));
		 Assert.assertTrue(isElenemtEnable(singleDropdownBy));
		 Assert.assertFalse(isElenemtEnable(textboxPasswordBy));
		 Assert.assertFalse(isElenemtEnable(disableDropdownBy));
	}
	@Test
	public void TC_05_Is_Select_Refactor() {
		 driver.get("https://automationfc.github.io/basic-form/index.html");
		 	
		 	clicktoElement(ageRadioBy);
			clicktoElement(checkboxDevelopmentBy);
			
			Assert.assertTrue(isElenemtSelect(ageRadioBy));
			Assert.assertTrue(isElenemtSelect(checkboxDevelopmentBy));
			Assert.assertFalse(isElenemtSelect(checkboxJavaBy));
			
			clicktoElement(ageRadioBy);
			clicktoElement(checkboxDevelopmentBy);
		
			Assert.assertTrue(isElenemtSelect(ageRadioBy));
			Assert.assertFalse(isElenemtSelect(checkboxDevelopmentBy));
	}
	
	
	public boolean isElenemtSelect(By by) {
		WebElement element = driver.findElement(by);
		if (element.isSelected()) {
			System.out.println("Element"+by+"] is select");
			return true;
		}else {
			System.out.println("Element"+by+"] is not select");
			return false;
		}
		
	}
	public boolean isElenemtEnable(By by) {
		WebElement element = driver.findElement(by);
		if (element.isEnabled()) {
			System.out.println("Element"+by+"] is enable");
			return true;
		}else {
			System.out.println("Element"+by+"] is disable");
			return false;
		}
		
	}
	public boolean isElenemtDisplayed(By by) {
		WebElement element = driver.findElement(by);
		if (element.isDisplayed()) {
			System.out.println("Element"+by+"] is display");
			return true;
		}else {
			System.out.println("Element"+by+"] is not display");
			return false;
		}
		
	}
	public void sendkeytoElement(By by, String value) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(value);
	}
	public void clicktoElement(By by) {
		WebElement element = driver.findElement(by);
		element.click();
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
