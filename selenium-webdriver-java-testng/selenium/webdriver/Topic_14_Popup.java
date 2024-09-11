package webdriver;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
public class Topic_14_Popup {
	WebDriver driver;
	WebDriverWait expliciWait;
	JavascriptExecutor jsExecutor;
	Alert alert;
	Select select;
	String projectPath = System.getProperty("user.dir");
	String authenChromeAutoIt = projectPath + "\\autoit\\authen_chrome.exe";
	String authenFrieFoxAutoIt = projectPath + "\\autoit\\authen_firefox.exe";
	String osName = System.getProperty("os.name");
	Actions action;
	Keys key;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		ChromeOptions chromeoption = new ChromeOptions();
//		chromeoption.addExtensions(new File(projectPath+""));
		driver = new ChromeDriver();
		
		expliciWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS );
		
		if(osName.contains("Windows")) {
			key =Keys.CONTROL;
		}else {
			key =Keys.COMMAND;
		}
	}
	
	@Test
	public void TC_01_Fixed_Popup() throws InterruptedException{
		driver.get("https://ngoaingu24h.vn/");

		clicktoElement("//button[contains(text(),'Đăng nhập')]");
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='custom-dialog']")).isDisplayed());
		Thread.sleep(1000);
		senkeytoElement("//input[contains(@placeholder,'Tài khoản đăng nhập')]", "phamxuanle2205");
		
		senkeytoElement("//input[contains(@placeholder,'Mật khẩu')]", "phamxuanle2205");
		clicktoElement("//div[@style='display: inline-grid; margin-top: 20px;']//button[contains(text(),'Đăng nhập')]");
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Bạn đã nhập sai tài khoản hoặc mật khẩu!')]")).isDisplayed());
		
		
	}
	public void TC_02_Random_Popup_In_DOM()throws InterruptedException {
		driver.get("https://blog.testproject.io/");
		By mailpopup = By.xpath("");
		if(driver.findElement(mailpopup).isDisplayed()){
			clicktoElement("");
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElement(mailpopup).isDisplayed());
		}
	}
	public void TC_02_Random_Popup_NotIn_DOM()throws InterruptedException {
		
	}
	
	public void clicktoElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
	}
	public void senkeytoElement(String xpath, String value) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(value);
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
