package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {
	
//	@Test
	public void signup() {
		HomePage homepage = new HomePage(driver);
        homepage.clickOnMyAccount();
        homepage.clickOnCreateAccount();
		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Intjar");
		register.setLastName("Mansuri");
		register.setEmail("intjar@gmail.com");
		register.setPassword("intjar@123");
		register.setConfirmPassword("intjar@123");
		register.clickOnSignup();
		
		String welcomeMsg = homepage.getWelcomeMessage();
		if(welcomeMsg.equals("Welcome, Intjar!")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
}
