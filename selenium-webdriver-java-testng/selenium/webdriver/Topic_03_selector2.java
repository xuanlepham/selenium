package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageLoadHelper.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_selector2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	
	@BeforeClass
	public void beforeClass() {
	
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
//		PageLoadHelper.waitForPageLoad(driver);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS );
		
	}
	@Test(priority = 1)
	public void TC_01_Email() {
		
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("phamxuanle");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("123@345@789");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("123@345@789");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("01635982872");
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		WebElement emailErrotLabel = driver.findElement(By.xpath("//label[@id='txtEmail-error']"));
		Assert.assertTrue(emailErrotLabel.isDisplayed());
		System.out.println(emailErrotLabel.getText());
		WebElement cemailErrotLabel = driver.findElement(By.xpath("//label[@id='txtCEmail-error']"));
		Assert.assertTrue(cemailErrotLabel.isDisplayed());
		System.out.println(cemailErrotLabel.getText());
	}
	@Test(priority = 2)
	public void TC_02_Email() {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("phamxuanle");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("xuanle2205@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("phamxuanle833@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("01635982872");
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		WebElement cemailErrotLabel = driver.findElement(By.xpath("//label[@id='txtCEmail-error']"));
		Assert.assertTrue(cemailErrotLabel.isDisplayed());
		System.out.println(cemailErrotLabel.getText());
		
	}
	@Test(priority = 3)
	public void TC_03_Password() {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("phamxuanle");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("xuanle2205@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("xuanle2205@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("01635982872");
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		WebElement password = driver.findElement(By.xpath("//label[@id='txtPassword-error']"));
		Assert.assertTrue(password.isDisplayed());
		System.out.println(password.getText());
		WebElement cpassword = driver.findElement(By.xpath("//label[@id='txtCPassword-error']"));
		Assert.assertTrue(cpassword.isDisplayed());
		System.out.println(cpassword.getText());
	}
	@Test(priority = 4)
	public void TC_04_Cpassword() {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("phamxuanle");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("xuanle2205@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("xuanle2205@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123789");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("01635982872");
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		WebElement cpassword = driver.findElement(By.xpath("//label[@id='txtCPassword-error']"));
		Assert.assertTrue(cpassword.isDisplayed());
		System.out.println(cpassword.getText());
		
	}
	@Test(priority = 5)
	public void TC_05_Phone() {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("phamxuanle");
		driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("xuanle2205@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("xuanle2205@gmail.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("016359828");
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		WebElement phone = driver.findElement(By.xpath("//label[@id='txtPhone-error']"));
		Assert.assertTrue(phone.isDisplayed());
		System.out.println(phone.getText());
		driver.findElement(By.xpath("//input[@id='txtPhone']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		Assert.assertTrue(phone.isDisplayed());
		System.out.println(phone.getText());
	}
	
	@AfterClass
	public void afterClass() {
		try {
		    Thread.sleep(10000); 
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		driver.quit();
	}
}
