package com.demo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demo.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contact')]")
	WebElement contactsLabel;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement surName;
	
	@FindBy(id = "last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@type=''submit' ans @value = 'Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("")).click();
	}
	public void createNewContact(String title,String fName, String sName, String lName) {
		Select select = new Select(driver.findElement(By.name("title"))); // we can create using PageFactory
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		firstName.sendKeys(sName);
		firstName.sendKeys(lName);
		saveBtn.click();
	}
}
