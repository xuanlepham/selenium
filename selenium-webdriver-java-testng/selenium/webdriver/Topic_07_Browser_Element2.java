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
public class Topic_07_Browser_Element2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS );
	 
	 driver.get("https://www.facebook.com/");
	}
	
	 @Test
	 public void TC_01_Element() {
		 
		 // Đặt tên biến element
		 WebElement element = driver.findElement(By.xpath(""));
		 
		 // Lấy giá trị của Attribute
		 element.getAttribute("placeholder");//**
		 
		 // Lấy thuộc tính của element color/font size/font style /size..
		 element.getCssValue("background-color");//**
		 // sau khi lấy dữ liệu CSS trả ra mã grba phải convert sang hexa mới verify được.
		
		 //GUI ( Giao diện)
		 element.getLocation();
		 element.getRect();
		 element.getSize();	
		 
		 // dùng để take screenshot -> attach to HTML report
		 element.getScreenshotAs(OutputType.FILE);//**
		 element.getScreenshotAs(OutputType.BASE64);
		 element.getScreenshotAs(OutputType.BYTES);
		 
		 // Tên thẻ HTML
		 // Dùng By.id /class/name
		 // Đầu ra của step này -> đầu vào của step kia.
		 element = driver.findElement(By.cssSelector(""));
		 String saveButtonTagname = element.getTagName();
		 driver.findElement(By.xpath("//"+saveButtonTagname+"[@name='email']"));
		 
		 element.getTagName();
		 
		 // Lấy text của header/link/label/error/success
		 element.getText();//**
		 
		 // Verify dữ liệu dùng để kiểm tra 1 cái element có hiển thị hay không
		 // Người dùng nhìn thấy được và thao tác được
		 // Mong muốn hiển thị dùng true , không mong muốn hiện thị dùng false
		 element.isDisplayed();//*
		 Assert.assertTrue(element.isDisplayed());
		 
		 // Kiểm tra 1 elment có thể thao tác được hay không (không bị disable/không phải là readonly filed
		 // Mong muốn enable dùng true , không mong muốn enable dùng false
		 element.isEnabled();//*
		 Assert.assertTrue(element.isEnabled());
		 
		 // Kiểm tra 1 element đã được chọn hay chưa (radio/checkbox/dropdown)
		 element.isSelected(); //**
		 Assert.assertTrue(element.isSelected());
		 
		 // Hành động submit vào 1 form
		 element.submit();
	 }
	
	 @AfterClass
	 public void afterClass() {
		 
		 driver.quit();
	 }
}
