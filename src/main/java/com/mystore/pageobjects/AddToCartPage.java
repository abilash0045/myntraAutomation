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
public class AddToCartPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//select[@class='size-dropdown']")
	private WebElement size;
	
	@FindBy(xpath="//span[contains(text(),'ADD TO BAG')]")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@class='notify-badge']")
	private WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'GO TO BAG')]")
	private WebElement goToBagBtn;
	
	@FindBy(xpath="//span[contains(text(),'WISHLIST')]")
	private WebElement wishlistBtn;
	
	@FindBy(xpath="//div[@class='pdp-product-price']")
	private WebElement productPrice;
	
	@FindBy(xpath="//h1[@class='pdp-title']")
	private WebElement productTitle;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectSize(String size1) throws Throwable {
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		action.fluentWait(getDriver(), addToCartMessage, 10);
		return action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public OrderPage clickOnGoToBag() throws Throwable {
		action.fluentWait(getDriver(), goToBagBtn, 10);
		action.JSClick(getDriver(), goToBagBtn);
		return new OrderPage();
	}
	
	public void clickOnWishlist() throws Throwable {
		action.click(getDriver(), wishlistBtn);
	}
	
	public String getProductPrice() throws Throwable {
		return action.getText(getDriver(), productPrice);
	}
	
	public String getProductTitle() throws Throwable {
		return action.getText(getDriver(), productTitle);
	}
	
}
