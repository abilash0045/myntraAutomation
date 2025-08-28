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
public class OrderPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//div[@class='priceDetail-base-row']//span[@class='priceDetail-base-value']")
	private WebElement unitPrice;
	
	@FindBy(xpath="//div[@class='priceDetail-base-row totalRow']//span[@class='priceDetail-base-value']")
	private WebElement totalPrice;
	
	@FindBy(xpath="//button[contains(text(),'PLACE ORDER')]")
	private WebElement placeOrderBtn;
	
	@FindBy(xpath="//div[@class='itemComponents-base-quantity']//button[contains(@class,'increment')]")
	private WebElement incrementQuantity;
	
	@FindBy(xpath="//div[@class='itemComponents-base-quantity']//button[contains(@class,'decrement')]")
	private WebElement decrementQuantity;
	
	@FindBy(xpath="//span[contains(text(),'REMOVE')]")
	private WebElement removeItemBtn;
	
	@FindBy(xpath="//div[@class='itemComponents-base-size']")
	private WebElement itemSize;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double getUnitPrice() {
		String unitPrice1=action.getText(getDriver(), unitPrice);
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=action.getText(getDriver(), totalPrice);
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public AddressPage clickOnPlaceOrder() throws Throwable {
		action.click(getDriver(), placeOrderBtn);
		return new AddressPage();
	}
	
	public void incrementItemQuantity() throws Throwable {
		action.click(getDriver(), incrementQuantity);
	}
	
	public void decrementItemQuantity() throws Throwable {
		action.click(getDriver(), decrementQuantity);
	}
	
	public void removeItem() throws Throwable {
		action.click(getDriver(), removeItemBtn);
	}
	
	public String getItemSize() throws Throwable {
		return action.getText(getDriver(), itemSize);
	}
	
}
