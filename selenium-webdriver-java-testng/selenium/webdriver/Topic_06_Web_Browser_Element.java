package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
public class Topic_06_Web_Browser_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
//	@Test
	public void TC_01_VerifyUrl () {
		driver.get("https://www.facebook.com/");
		WebElement linkLangues = driver.findElement(By.xpath("//a[@title='Vietnamese']"));
		linkLangues.click();
		
//		WebElement linkLogin = driver.findElement(By.xpath("//a[@title='Đăng nhập Facebook']"));
//		linkLogin.click();
//		
//		String loginPage = driver.getCurrentUrl();
//		Assert.assertEquals(loginPage, "https://vi-vn.facebook.com/login/");
//		System.out.println(loginPage);
//		
	}
	
//	@Test
	public void TC_02_VerifyLogin () {
		driver.get("https://www.facebook.com/");
		
		
		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@title='Đăng nhập Facebook']"));
		linkLogin.click();
		String loginPage = driver.getTitle();
		Assert.assertEquals(loginPage, "Đăng nhập Facebook");
		System.out.println(loginPage);
		
		WebElement linkRegister = driver.findElement(By.xpath("//a[@class='_97w5']"));	
		linkRegister.click();
		String registerPage = driver.getTitle();
		Assert.assertEquals(registerPage, "Đăng ký Facebook");
		System.out.println(registerPage);
	}
//	@Test
	public void TC_03_Navigate_Function () {
		driver.get("https://www.facebook.com/");
		WebElement linkLangues = driver.findElement(By.xpath("//a[@title='Vietnamese']"));
		linkLangues.click();
		
		WebElement linkLogin = driver.findElement(By.xpath("//a[@title='Đăng nhập Facebook']"));
		linkLogin.click();
		String loginPage = driver.getCurrentUrl();
		Assert.assertEquals(loginPage, "https://vi-vn.facebook.com/login/");
		System.out.println(loginPage);
		
		WebElement linkRegister = driver.findElement(By.xpath("//a[@class='_97w5']"));	
		linkRegister.click();
		String registerPage = driver.getCurrentUrl();
		Assert.assertEquals(registerPage, "https://vi-vn.facebook.com/r.php?locale=vi_VN&display=page");
		System.out.println(registerPage);
		
		driver.navigate().back();
		Assert.assertEquals(loginPage, "https://vi-vn.facebook.com/login/");
		System.out.println(loginPage);
		driver.navigate().forward();
		Assert.assertEquals(registerPage, "https://vi-vn.facebook.com/r.php?locale=vi_VN&display=page");
		System.out.println(registerPage);
		driver.navigate().back();
		driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Đăng nhập Facebook");
	}
	@Test
	public void TC_04_Page_Source() {
		driver.get("https://www.facebook.com/");
		WebElement linkLangues = driver.findElement(By.xpath("//a[@title='Vietnamese']"));
		linkLangues.click();
		
		WebElement linkRegister = driver.findElement(By.xpath("//a[@title='Đăng ký Facebook']"));
		linkRegister.click();
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("Tạo tài khoản mới"));
		System.out.println(pageSource);
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
