package webdriver;

import org.openqa.selenium.WebDriver;
import PageLoadHelper.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_selector {
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
		PageLoadHelper.waitForPageLoad(driver);
		
	}
	@Test(priority = 1)
	public void TC_01_Name() {
//		driver.navigate().refresh();
//		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập họ tên')]")).getText(),"Vui lòng nhập họ tên");
		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập họ tên')]")));
//		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập email')]")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập lại địa chỉ email')]")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập mật khẩu')]")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập lại mật khẩu')]")).isDisplayed());
//		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập số điện thoại.')]")).isDisplayed());
	}
	@Test(priority = 3)
	public void TC_02_Click() {
	
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).click();
		driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("pham xuan le");
	
	}
	@Test(priority = 2)
	public void TC_03_Click() {
	
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập lại địa chỉ email')]")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Vui lòng nhập lại địa chỉ email')]")));
		
		
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
