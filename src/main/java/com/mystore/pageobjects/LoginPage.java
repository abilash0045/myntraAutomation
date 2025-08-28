/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Hitendra
 *  
 */
public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//input[@class='login-user-input-email login-user-input']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@class='login-user-input-password login-user-input']")
	private WebElement password;

	@FindBy(xpath = "//button[@class='login-login-button']")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Sign up')]")
	private WebElement signUpBtn;
	
	@FindBy(xpath = "//input[@class='register-user-input-email register-user-input']")
	private WebElement emailForNewAccount;
	
	@FindBy(xpath = "//button[@class='register-register-button']")
	private WebElement createNewAccountBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Login with Password')]")
	private WebElement loginWithPasswordBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
		action.fluentWait(getDriver(), loginWithPasswordBtn, 10);
		action.click(getDriver(), loginWithPasswordBtn);
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), signInBtn);
		Thread.sleep(2000);
		homePage=new HomePage();
		return homePage;
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.fluentWait(getDriver(), loginWithPasswordBtn, 10);
		action.click(getDriver(), loginWithPasswordBtn);
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.click(getDriver(), signUpBtn);
		action.type(emailForNewAccount, newEmail);
		action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	
}






