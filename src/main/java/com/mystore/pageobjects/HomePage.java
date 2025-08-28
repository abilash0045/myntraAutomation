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
public class HomePage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//span[contains(text(),'Wishlist')]")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[contains(text(),'Orders')]")
	private WebElement orderHistory;
	
	@FindBy(xpath = "//span[contains(text(),'Profile')]")
	private WebElement profileBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Bag')]")
	private WebElement cartBtn;
	
	@FindBy(xpath = "//div[contains(@class,'desktop-navLink')]//a[contains(text(),'Men')]")
	private WebElement menCategory;
	
	@FindBy(xpath = "//div[contains(@class,'desktop-navLink')]//a[contains(text(),'Women')]")
	private WebElement womenCategory;
	
	@FindBy(xpath = "//div[contains(@class,'desktop-navLink')]//a[contains(text(),'Kids')]")
	private WebElement kidsCategory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	
	public boolean validateMyWishList() throws Throwable {
		return action.isDisplayed(getDriver(), myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}
	
	public void clickOnProfile() throws Throwable {
		action.click(getDriver(), profileBtn);
	}
	
	public void clickOnCart() throws Throwable {
		action.click(getDriver(), cartBtn);
	}
	
	public void clickOnMenCategory() throws Throwable {
		action.click(getDriver(), menCategory);
	}
	
	public void clickOnWomenCategory() throws Throwable {
		action.click(getDriver(), womenCategory);
	}
	
	public void clickOnKidsCategory() throws Throwable {
		action.click(getDriver(), kidsCategory);
	}
}
