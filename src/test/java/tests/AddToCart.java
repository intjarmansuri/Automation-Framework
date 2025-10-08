package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductViewPage;

public class AddToCart extends BaseTest {
	
	@Test
	public void verifyAddToCartTest() throws InterruptedException {
		 logger.info("========== Starting verifyAddToCartTest ==========");

	        // Step 1: Login
	        logger.debug("Initializing HomePage and LoginPage objects");
	        HomePage hp = new HomePage(driver);
	        hp.clickOnMyAccount();
	        logger.info("Clicked on 'My Account'");

	        LoginPage lp = new LoginPage(driver);
	        lp.setEmailAddress("intjar@gmail.com");
	        lp.setPassword("intjar@123");
	        lp.clickOnSigninBtn();
	        logger.info("Successfully entered credentials and clicked on Sign In");
	        
	        Thread.sleep(5000);

	        // Step 2: Navigate to Smartphones section
	        logger.info("Navigating to 'Smartphones and Gadgets' category");
	        hp.moveSmartphonesAndGadegts();
	        hp.clickOnSmartPhones();
	        logger.info("Successfully navigated to Smartphones section");
	        
	        Thread.sleep(5000);

	        // Step 3: Select product details
	        logger.debug("Initializing ProductViewPage object");
	        ProductViewPage pvp = new ProductViewPage(driver);
	        pvp.clickOnBlackColor();
	        logger.info("Selected product color: Black");

	        pvp.selectVolume("64 GB");
	        logger.info("Selected storage volume: 64 GB");

	        // Step 4: Click on Add to Cart
	        pvp.clickOnAddToCart();
	        logger.info("Clicked on 'Add to Cart' button");
	        
	        Thread.sleep(5000);

	        // Step 5: Validation — check confirmation message or cart count
	        logger.debug("Fetching confirmation message after adding to cart");
	        String actualMessage = pvp.getAddToCartConfirmationMsg(); // Example method
	        String expectedMessage = "Product successfully added to your shopping cart";

	        Assert.assertEquals(actualMessage, expectedMessage,
	            "Add to Cart failed! Expected: " + expectedMessage + " but found: " + actualMessage);
	        logger.info("Add to Cart validation successful — product added successfully!");

//	        // Optional: Validate cart count
//	        int cartCount = hp.getCartItemCount(); // Example method
//	        Assert.assertTrue(cartCount > 0, "Cart is empty after adding product!");
//	        logger.debug("Cart item count after adding product: " + cartCount);

	        logger.info("========== Finished verifyAddToCartTest ==========");
	}

}
