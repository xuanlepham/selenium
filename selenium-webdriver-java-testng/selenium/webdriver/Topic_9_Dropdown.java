package webdriver;
import java.sql.DriverManager;
import java.util.List;
import java.util.Random;
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
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_9_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String loginPage = "";
	String loginPageUrl;
	String fristname,lastname,email,password,confrimpassword,day,month,year,country;
	Select select;
	
	
	By linkRegister = By.xpath("//a[@class='ico-register']");
	By buttonRegister =By.xpath("//button[@id='register-button']");
	By radioMale = By.xpath("//input[@value='M']");
	By radioFemale = By.xpath("//input[@value='F']");
	By textboxFristname = By.xpath("//input[@id='FirstName']");
	By textboxLastName = By.xpath("//input[@id='LastName']");
	By textboxEmail = By.xpath("//input[@id='Email']");
	By textboxPassword = By.xpath("//input[@id='Password']");
	By textboxConfrimPasswrod = By.xpath("//input[@id='ConfirmPassword']");
	
	@BeforeClass
	public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	fristname = "Leex";
	lastname = "Pham";
	password ="01635982872@Leex";
	confrimpassword ="01635982872@Leex";
	day ="22";
	month="May";
	year ="2000";
	country ="Vietnam";

	email="phamxuanle"+ getRandomNumber()+"@gmail.com";
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS );
	 
	 
	}
	
	@Test
	public void TC_01_Nopcommerce() throws InterruptedException {
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F/");
		Thread.sleep(5000);
//		clicktoElement(buttonRegister);
//		Thread.sleep(1000);
		clicktoElement(radioMale);
		senkeytoElement(textboxFristname, fristname);
		senkeytoElement(textboxLastName, lastname);
		
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		// chọn 1 item
		select.selectByVisibleText(day);
		// bỏ chọn 1 item
//		select.deselectByVisibleText("15");
		// kiểm tra dropdown này có phải là multiple select hay khong
		Assert.assertFalse(select.isMultiple());
		// kiểm tra đã chọn đúng item hay chưa
		Assert.assertEquals(select.getFirstSelectedOption().getText(), day);
		// lấy ra tổng số item trong dropdown
		Assert.assertEquals(select.getOptions().size(),32);
		
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText(month);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText(year);
		
		senkeytoElement(textboxEmail, email);
		senkeytoElement(textboxPassword, password);
		senkeytoElement(textboxConfrimPasswrod, confrimpassword);
//		clicktoElement(buttonRegister);
		
//		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")), "Your registration completed");
		
	}
	
	@Test
	public void TC_02_Rode() throws InterruptedException {
		driver.get("https://www.rode.com/wheretobuy");
		select = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		select.selectByVisibleText(country);
		
		
		
	}
	
	@Test
	public void TC_03_New_Customer() throws InterruptedException {
		
	}
	
	@Test
	public void TC_04_Edit() {
		
		
		
		
		
	}
	
	public void senkeytoElement (By by, String value) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(value);
	}
	
	public void clicktoElement (By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}
	
	public boolean isdisplayedElement (By by) {
		WebElement element = driver.findElement(by);
		if(element.isDisplayed()) {
			System.out.println("Text dang duoc hien thi");
			return true;
		}else {
			System.out.println("Text chua duoc hien thi");
			return false;
		}
	}
	public int getRandomNumber() {
		Random rand =new Random();
		return rand.nextInt(999999);
		
	}
	@AfterClass
	public void afterClass() {
		try {
		    Thread.sleep(5000); 
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
//		driver.quit();
	}
	
}

