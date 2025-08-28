/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author Modified for Myntra
 *
 */
public class MyntraSpecificTest extends BaseClass {
	
	private IndexPage indexPage;
	private HomePage homePage;
	private SearchResultPage searchResultPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void testMenCategoryNavigation() throws Throwable {
		Log.startTestCase("testMenCategoryNavigation");
		indexPage = new IndexPage();
		homePage = new HomePage();
		homePage.clickOnMenCategory();
		Thread.sleep(2000);
		String currentUrl = getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("men"), "Men category page not loaded");
		Log.endTestCase("testMenCategoryNavigation");
	}
	
	@Test(groups = "Smoke")
	public void testWomenCategoryNavigation() throws Throwable {
		Log.startTestCase("testWomenCategoryNavigation");
		indexPage = new IndexPage();
		homePage = new HomePage();
		homePage.clickOnWomenCategory();
		Thread.sleep(2000);
		String currentUrl = getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("women"), "Women category page not loaded");
		Log.endTestCase("testWomenCategoryNavigation");
	}
	
	@Test(groups = "Smoke")
	public void testKidsCategoryNavigation() throws Throwable {
		Log.startTestCase("testKidsCategoryNavigation");
		indexPage = new IndexPage();
		homePage = new HomePage();
		homePage.clickOnKidsCategory();
		Thread.sleep(2000);
		String currentUrl = getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("kids"), "Kids category page not loaded");
		Log.endTestCase("testKidsCategoryNavigation");
	}
	
	@Test(groups = "Sanity")
	public void testSearchWithFilters() throws Throwable {
		Log.startTestCase("testSearchWithFilters");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("shirts");
		Thread.sleep(2000);
		boolean filterSection = searchResultPage.validateFilterSection();
		Assert.assertTrue(filterSection, "Filter section not displayed");
		Log.endTestCase("testSearchWithFilters");
	}
	
	@Test(groups = "Sanity")
	public void testWishlistFunctionality() throws Throwable {
		Log.startTestCase("testWishlistFunctionality");
		indexPage = new IndexPage();
		indexPage.clickOnWishlist();
		Thread.sleep(2000);
		String currentUrl = getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("wishlist"), "Wishlist page not loaded");
		Log.endTestCase("testWishlistFunctionality");
	}
	
	@Test(groups = "Sanity")
	public void testCartFunctionality() throws Throwable {
		Log.startTestCase("testCartFunctionality");
		indexPage = new IndexPage();
		indexPage.clickOnCart();
		Thread.sleep(2000);
		String currentUrl = getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("bag"), "Cart page not loaded");
		Log.endTestCase("testCartFunctionality");
	}
}
