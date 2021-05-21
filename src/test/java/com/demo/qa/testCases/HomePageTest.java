/**
 * 
 */
package com.demo.qa.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.ContactsPage;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LoginPage;
import com.demo.qa.util.TestUtil;

/**
 * @author sajalmohanta
 *
 */
public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	//Test Cases should be separated -- independent with each other
	// before every testcase launch the browser and login
	//@test-- execute test case
	//after each testcase close the browser
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		AssertJUnit.assertEquals(homePageTitle,"CRMPRO","HomePage Title is not matched");
	}
	@Test(priority=2)
	public void verifyUserNametest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	@Test(priority=3)
	public void verifyContactsLink() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
