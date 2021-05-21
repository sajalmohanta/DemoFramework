/**
 * 
 */
package com.demo.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.demo.qa.base.TestBase;
import com.demo.qa.pages.ContactsPage;
import com.demo.qa.pages.HomePage;
import com.demo.qa.pages.LoginPage;
import com.demo.qa.util.TestUtil;

/**
 * @author sajalmohanta
 *
 */
public class ContactsPageTest extends TestBase{
	TestUtil testUtil;
	ContactsPage contactsPage;
	HomePage homePage;
	LoginPage loginPage;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),"password");
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact Label is missing frm contacts page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String surName,String lastName) {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title,firstName,surName,lastName);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
