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
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_08_HandleTextBox_TextArea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String loginPage = "http://demo.guru99.com/v4";
	String loginPageUrl,username,pasword,customerID;
	String name,gender,dateofbirthinput,dateofbirthoutput,addressinput,addressoutput,city,state,pin,moblienumber,email,passwordnew;
	String editAddressInput,editAddressOutput,editCity,editState,editPin,editPhone,editEmail;
	By userID = By.xpath("//input[@name='uid']");
	By passwrodId =By.xpath("//input[@name='password']");
	By buttonLogin = By.xpath("//input[@name='btnLogin']");
	By titleManager = By.xpath("//marquee[@class='heading3' and text()=\"Welcome To Manager's Page of Guru99 Bank\"]");
	By titleRegisterSuccess = By.xpath("//p[@class='heading3' and text()='Customer Registered Successfully!!!']");
	By buttonNewcustomer = By.xpath("//a[text()='New Customer']");
	By radiobuttonGender = By.xpath("//input[@value='m']");
	By textboxGender =By.xpath("//input[@name='gender']");
	By textboxCustomerName = By.xpath("//input[@name='name']");
	By textboxDateofbirth = By.xpath("//input[@name='dob']");
	By textareaAdrees = By.xpath("//textarea[@name='addr']");
	By textboxCity = By.xpath("//input[@name='city']");
	By textboxState = By.xpath("//input[@name='state']");
	By textboxPin = By.xpath("//input[@name='pinno']");
	By textboxMobileNumber = By.xpath("//input[@name='telephoneno']");
	By textboxEmail = By.xpath("//input[@name='emailid']");
	By textboxPassword = By.xpath("//input[@name='password']");
	By buttonSubmit = By.xpath("//input[@name='sub']");
	By buttonReset = By.xpath("//input[@name='res']");
	By buttonEditcustomer = By.xpath("//a[text()='Edit Customer']");
	By textboxCustomerId = By.xpath("//input[@name='cusid']");
	By buttonSubmitEdit = By.xpath("//input[@name='AccSubmit']");
	
	
	@BeforeClass
	public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	name ="LeexPham";
	gender="male";
	dateofbirthinput="05/22/2000";
	dateofbirthoutput="2000-05-22";
	addressinput="441 Le Van Luong\nDistrict 7 ";
	addressoutput="441 Le Van Luong District 7";
	city="Ho Chi Minh";
	state="Ho Chi Minh";
	pin="220520";
	moblienumber="0849034241";
	email="phamxuanle"+ getRandomNumber()+"@gmail.com";
	passwordnew="01635982872@Leex";
	
	editAddressInput="441 Le Van Luong \nHCM";
	editAddressOutput="441 Le Van Luong HCM";
	editCity="HCM";
	editState="HCM";
	editPin="220500";
	editPhone="01635982872";
	editEmail="phamxuanle"+ getRandomNumber()+"@gmail.com";
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS );
	 driver.get(loginPage);
	 
	 
	}
	
	@Test
	public void TC_01_Register() {
		loginPageUrl = driver.getCurrentUrl();
		WebElement visitHere = driver.findElement(By.xpath("//a[text()='here']"));
		visitHere.click();
		
		WebElement emailId = driver.findElement(By.xpath("//input[@name='emailid']"));
		emailId.sendKeys(email);
		
		WebElement submitButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		submitButton.click();
		
		
		
		 username = driver.findElement(By.xpath("//td[contains(text(),'User ID :')]/following-sibling::td")).getText();
		 pasword = driver.findElement(By.xpath("//td[contains(text(),'Password ')]/following-sibling::td")).getText();
		
	}
	
	@Test
	public void TC_02_Login() throws InterruptedException {
		driver.get(loginPageUrl);
		senkeytoElement(userID, username);
		senkeytoElement(passwrodId, pasword);
		clicktoElement(buttonLogin);
		Assert.assertTrue(isdisplayedElement(titleManager));
		Thread.sleep(500);
		
		
		
	}
	
	@Test
	public void TC_03_New_Customer() throws InterruptedException {
		clicktoElement(buttonNewcustomer);
		Thread.sleep(500);
		senkeytoElement(textboxCustomerName,name);
		senkeytoElement(textboxDateofbirth, dateofbirthinput);
		senkeytoElement(textareaAdrees, addressinput);
		senkeytoElement(textboxCity, city);
		senkeytoElement(textboxState, state);
		senkeytoElement(textboxPin, pin);
		senkeytoElement(textboxMobileNumber, moblienumber);
		senkeytoElement(textboxEmail, email);
		senkeytoElement(textboxPassword, passwordnew);
		clicktoElement(buttonSubmit);
		Thread.sleep(500);
		customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
		
		Assert.assertTrue(isdisplayedElement(titleRegisterSuccess));
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(),name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(),gender);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(),dateofbirthoutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), addressoutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), moblienumber);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), email);
	}
	
	
	@Test
	public void TC_04_Edit() {
		clicktoElement(buttonEditcustomer);
		senkeytoElement(textboxCustomerId,customerID);
		clicktoElement(buttonSubmitEdit);
		
		Assert.assertEquals(driver.findElement(textboxCustomerName).getAttribute("value"), name);
		Assert.assertEquals(driver.findElement(textboxGender).getAttribute("value"), gender);
		Assert.assertEquals(driver.findElement(textboxDateofbirth).getAttribute("value"), dateofbirthoutput);
		Assert.assertEquals(driver.findElement(textareaAdrees).getAttribute("value"), addressinput);
		Assert.assertEquals(driver.findElement(textboxCity).getAttribute("value"), city);
		Assert.assertEquals(driver.findElement(textboxState).getAttribute("value"), state);
		Assert.assertEquals(driver.findElement(textboxPin).getAttribute("value"), pin);
		Assert.assertEquals(driver.findElement(textboxMobileNumber).getAttribute("value"), moblienumber);
		Assert.assertEquals(driver.findElement(textboxEmail).getAttribute("value"), email);
		
		
		senkeytoElement(textareaAdrees, editAddressInput);
		senkeytoElement(textboxCity, editCity);
		senkeytoElement(textboxState, editState);
		senkeytoElement(textboxPin, editPin);
		senkeytoElement(textboxMobileNumber, editPhone);
		senkeytoElement(textboxEmail, editEmail);
		clicktoElement(buttonSubmit);
		
		
		
		
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

