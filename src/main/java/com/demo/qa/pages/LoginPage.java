/**
 * 
 */
package com.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.base.TestBase;
/**
 * @author sajalmohanta
 *
 */
public class LoginPage extends TestBase {
	
	//Page Factory -- OR(Object Repository)
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	public LoginPage() {
		
	// Initializing the Page Objects
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateImage() {
		return logo.isDisplayed();
		
	}
	// Below method will return HomePage as after login HomePage comes
	public HomePage login(String un , String pwd) {
		username.sendKeys(un);
		username.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
	
}
 