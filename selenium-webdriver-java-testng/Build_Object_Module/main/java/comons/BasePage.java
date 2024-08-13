package main.java.comons;
// BasePage chứa các hàm cơ bản dùng chung.

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.pageOjects.admin.AdminHomePageObject;
import main.java.pageOjects.admin.AdminLoginPageObject;
import main.java.pageOjects.usermanager.UserManagerPageObject;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BasePage {
	public AdminHomePageObject goToAdminHomePage( ) {
		AdminLoginPageObject loginPage = new AdminLoginPageObject();//địa chỉ trang web trong ()
		 AdminHomePageObject homePage;
		 
		 homePage = loginPage.loginW	ebsite();//địa chỉ trang web trong ();
				 
		//Trả về một đối tượng AdminHomePageObject
		return new AdminHomePageObject();
		
	}
	public static BasePage getBasePageObject() {
        return new BasePage();
    }
	
	public void openPageUrl(String pageUrl) {
		
	}
}
