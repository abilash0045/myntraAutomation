package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//span[contains(text(),'Profile')]") 
	private WebElement profileBtn;
	
	@FindBy(xpath = "//a[contains(@class,'myntraweb-sprite') and contains(@class,'logo')]")
	private WebElement myntraLogo;
	
	@FindBy(xpath = "//input[@class='desktop-searchBar']")
	private WebElement searchProductBox;
	
	@FindBy(xpath = "//a[@class='desktop-submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//span[contains(text(),'Bag')]")
	private WebElement cartBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Wishlist')]")
	private WebElement wishlistBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnProfile() throws Throwable {
		action.fluentWait(getDriver(), profileBtn, 10);
		action.click(getDriver(), profileBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), myntraLogo);
	}
	
	public String getMyntraTitle() {
		String myntraTitle=getDriver().getTitle();
		return myntraTitle;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	
	public void clickOnCart() throws Throwable {
		action.click(getDriver(), cartBtn);
	}
	
	public void clickOnWishlist() throws Throwable {
		action.click(getDriver(), wishlistBtn);
	}
}
