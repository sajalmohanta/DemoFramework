/**
 * 
 */
package com.demo.qa.testCases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LoginPage;

/**
 * @author sajalmohanta
 *
 */
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	    loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Free CRM for Any Business");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
