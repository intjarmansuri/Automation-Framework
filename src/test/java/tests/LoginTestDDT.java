package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTestDDT extends BaseTest {
	
//	@Test(dataProvider = "LoginData")
	public void loginTest(String email, String pwd) {
		HomePage homepage = new HomePage(driver);
		
		homepage.clickOnMyAccount();
		
		LoginPage login = new LoginPage(driver);
		
		login.setEmailAddress(email);
		login.setPassword(pwd);
		login.clickOnSigninBtn();
		
		String exptectedMsg = homepage.getWelcomeMessage();
		if(exptectedMsg.equals("Welcome, Intjar!")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Login failed for email: " + email);
		}
		
		homepage.clickOnMyAccount();
		homepage.clickOnLogout();
	}
	
	@DataProvider(name="LoginData")
	Object[][]  loginData() {
		Object data[][] = {
				{"intjar@gmail.com", "intjar@123"},
				{"intjar@gmail.com", "wrongpass"},
		        {"wronguser@gmail.com", "intjar@123"},
		        {"wronguser@gmail.com", "wrongpass"},
		        {" ", "intjar@123"},
		        {"intjar@gmail.com", " "} 
		};
		return data;
	}
}
