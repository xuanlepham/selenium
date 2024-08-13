package webdriver;

import java.sql.DriverManager;
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
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_07_Browser_Element5 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS );
	 
	 
	}
	
	 @Test
	 public void TC_01_Element() throws InterruptedException {
		 driver.get("https://login.mailchimp.com/signup/");
		 WebElement businessemail = driver.findElement(By.xpath("//input[@id='email']"));
		 businessemail.sendKeys("phamxuanle833@gmail.com");
		 
//		 WebElement username = driver.findElement(By.xpath("//input[@id='new_username']"));
//		 username.sendKeys("phamxuanle");
		 
		 // Lowcase
		 WebElement password = driver.findElement(By.xpath("//input[@id='new_password']"));
		 password.sendKeys("abc");
		 Thread.sleep(2000);
//		 Assert.assertTrue(isValidationRulePassed(driver, "//li[@class='lowercase-char completed']"));
		 WebElement lowercaseRequirement = driver.findElement(By.xpath("//*[@id=\"passwordHint\"]/div/div/ul/li[1]"));
		 String color =lowercaseRequirement.getCssValue("color");
		 System.out.println(color);
		 String hexColor = Color.fromString(color).asHex();
		 String expectedColor ="#008547";
		 if (hexColor.equals(expectedColor)) {
	            System.out.println("Yêu cầu chữ thường đã được đáp ứng.");
	        } else {		
	            System.out.println("Yêu cầu chữ thường chưa được đáp ứng.");
	        }
		 lowercaseRequirement.getCssValue("color");
		 System.out.println(hexColor);
//		 WebElement buttonPassword = driver.findElement(By.xpath("//button[@id='create-account-enabled']"));
//		 buttonPassword.click();
		 // Uppercase
//		 password.clear();
//		 password.sendKeys("Abc");
//		 Assert.assertTrue(isValidationRulePassed(driver, "//span[contains(text(),'One uppercase character')]"));
//		 
		 // Number
//		 password.clear();
//		 password.sendKeys("123");
//		 Assert.assertTrue(isValidationRulePassed(driver, "//span[contains(text(),'One number')]"));
		 // Speical
//		 password.clear();
//		 password.sendKeys("@bc");
//		 Assert.assertTrue(isValidationRulePassed(driver, "//span[contains(text(),'One special character')]"));
//		 // >=8 character
//		 password.clear();
//		 password.sendKeys("phamxuan");
//		 Assert.assertTrue(isValidationRulePassed(driver, "//span[contains(text(),'8 characters minimum')]"));
//		 
//		 // Full valid data
//		 password.clear();
//		 password.sendKeys("phamxuanle@2205");
//		 Assert.assertTrue(isValidationRulePassed(driver, "//span[contains(text(),'One lowercase character')]"));
//	 }
//	 public static boolean isValidationRulePassed (WebDriver driver, String ruleSelector) {
//		 WebElement ruleElement =driver.findElement(By.xpath(ruleSelector));
//		 String color = ruleElement.getCssValue("color");
//		// String hexColor = Color.fromString(color).asHex();
////	return color.equalsIgnoreCase(color);
//		if(color.equals("")) {
//			return true;
//		}else {
//			return false;
//		}
		 }
	 
	 @AfterClass
	 public void afterClass() {
//		 try {
//			    Thread.sleep(5000); 
//			} catch (InterruptedException e) {
//			    e.printStackTrace();
//			}
		 driver.quit();
	 }
}
