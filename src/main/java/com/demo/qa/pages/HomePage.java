/**
 * 
 */
package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.base.TestBase;

/**
 * @author sajalmohanta
 *
 */
public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'User:Sajal M)']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//Initializing Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	public boolean verifyUserName() {
		 return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle() { 
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	 
	
}
