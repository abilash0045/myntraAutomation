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
public class SearchResultPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//li[@class='product-base']")
	private WebElement productResult;
	
	@FindBy(xpath="//span[@class='results-count']")
	private WebElement productCount;
	
	@FindBy(xpath="//div[@class='filter-summary-filter']")
	private WebElement filterSection;
	
	@FindBy(xpath="//div[@class='sort-sortBy']")
	private WebElement sortByDropdown;
	
	@FindBy(xpath="//div[@class='price-range']")
	private WebElement priceRangeFilter;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
	public boolean validateFilterSection() throws Throwable {
		return action.isDisplayed(getDriver(), filterSection);
	}
	
	public void clickOnSortBy() throws Throwable {
		action.click(getDriver(), sortByDropdown);
	}
	
	public void clickOnPriceRange() throws Throwable {
		action.click(getDriver(), priceRangeFilter);
	}
	
}
