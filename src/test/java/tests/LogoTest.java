package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;

public class LogoTest extends BaseTest {
	
//	@Test
	public void verifyLogoDisplayed() {
		HomePage homepage = new HomePage(driver);
		
		boolean displayed = homepage.isLogoDisplayed();
		Assert.assertTrue(displayed, "Logo not displayed on homepage");
	}
	
}
