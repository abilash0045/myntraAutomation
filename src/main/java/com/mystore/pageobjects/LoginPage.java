/**
 * 
 */
package com.mystore.pageobjects;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	// Mobile OTP flow elements (selectors are intentionally flexible)
	@FindBy(xpath = "//input[contains(@class,'mobile') or (@type='tel' and contains(@class,'login-user-input')) or contains(@placeholder,'mobile')]")
	private WebElement mobileNumberInput;

	@FindBy(xpath = "//div[normalize-space()='Continue' or normalize-space()='CONTINUE' or contains(@class,'submitBottomOption')] | //button[normalize-space()='Continue' or normalize-space()='CONTINUE']")
	private WebElement continueBtn;
	
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

	// Interactive mobile-OTP login for resume demos
	public HomePage loginWithMobileOtp(String mobileNumber) throws Throwable {
		// Type mobile and continue
		action.scrollByVisibilityOfElement(getDriver(), mobileNumberInput);
		action.type(mobileNumberInput, mobileNumber);
		action.JSClick(getDriver(), continueBtn);

		// Prompt for OTP
		String otp = JOptionPane.showInputDialog(null, "Enter OTP received on mobile", "OTP Verification", JOptionPane.QUESTION_MESSAGE);
		if (otp == null || otp.trim().isEmpty()) {
			throw new RuntimeException("OTP entry cancelled or empty");
		}
		otp = otp.trim();

		// Find OTP input boxes (commonly 4-6 tel inputs)
		List<WebElement> otpInputs = getDriver().findElements(By.xpath("//input[@type='tel' or @type='number' or contains(@class,'otp') or contains(@aria-label,'OTP')]"));
		if (otpInputs.isEmpty()) {
			// fallback: type into focused element
			for (char c : otp.toCharArray()) {
				getDriver().switchTo().activeElement().sendKeys(String.valueOf(c));
			}
		} else {
			int i = 0;
			for (char c : otp.toCharArray()) {
				if (i >= otpInputs.size()) break;
				otpInputs.get(i).sendKeys(String.valueOf(c));
				i++;
			}
			// Submit with ENTER on last box
			otpInputs.get(Math.min(i, otpInputs.size()-1)).sendKeys(Keys.ENTER);
		}

		Thread.sleep(2000);
		return new HomePage();
	}
	
}






