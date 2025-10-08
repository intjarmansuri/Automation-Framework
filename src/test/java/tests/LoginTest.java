package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

//    @Test
    public void verifyLoginTest() {
        logger.info("========== Starting verifyLoginTest ==========");

        logger.debug("Creating HomePage object");
        HomePage hp = new HomePage(driver);

        hp.clickOnMyAccount();
        logger.info("Clicked on 'My Account' successfully");

        logger.debug("Creating LoginPage object");
        LoginPage lp = new LoginPage(driver);

        lp.setEmailAddress("intjar@gmail.com");
        lp.setPassword("intjar@123");
        logger.info("Entered email and password");

        lp.clickOnSigninBtn();
        logger.info("Clicked on Sign In button");

        logger.debug("Fetching welcome message from HomePage");
        String actualMsg = hp.getWelcomeMessage();
        String expectedMsg = "Welcome, Intjar!";

        logger.debug("Expected message: " + expectedMsg + " | Actual message: " + actualMsg);

        Assert.assertEquals(actualMsg, expectedMsg,
            "Login failed! Expected message: " + expectedMsg + " but found: " + actualMsg);

        logger.info("Login test passed successfully!");
        logger.info("========== Finished verifyLoginTest ==========");
    }
}
