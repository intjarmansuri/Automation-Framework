package tests;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.ProductPage;

public class ProductSearchTest extends BaseTest {
	ProductPage productpage;
	
//@Test(priority = 1)
	public void verifyProductSearch() {
		HomePage homepage = new HomePage(driver);
		homepage.setCookies();
		
		productpage = new ProductPage(driver);
		String searchTerm = "iphone";
		productpage.searchProduct(searchTerm);
		
		if(productpage.getProductResults().size() > 0) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("No results found!");
		}
	}
	
//@Test(priority = 2, dependsOnMethods = "verifyProductSearch")
	public void sortLowToHighTest() {
		productpage.sortLowToHigh();
		System.out.println("Products sorted Low to High");
	}
	
//@Test(priority = 3, dependsOnMethods = "verifyProductSearch")
	public void sortHighToLow() {
		productpage.sortHighToLow();
		System.out.println("Products sorted High to Low");
	}
	
//	@Test(priority = 4)
	public void verifyInvalidSearch() {
		productpage = new ProductPage(driver);
		String searchTerm = "abcdxyz123";
		productpage.searchProduct(searchTerm);
		
		if(productpage.isNoResultDisplayed()) {
			String actualMsg= productpage.getNoResultsText();
			
			if(actualMsg.toLowerCase().contains("no products found")) {
				Assert.assertTrue(true , actualMsg);
			} else {
				Assert.fail("Wrong message displayed");
			}
			
		} else {
			Assert.fail("No results message was not displayed at all.");
		}
	}
 }
 