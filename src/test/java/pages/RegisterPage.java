package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* =============================== Locators ================================ */
	
	@FindBy(xpath = "//input[@id = 'firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id = 'lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id = 'email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id = 'password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id = 'confirm_password']")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//button[text() = 'Sign up']")
	WebElement signup;
	
	@FindBy(xpath = "//p[@class = 'Notification-Text']")
	WebElement errorMessage;
	
	/* ================================ Actions ================================ */
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		confirmPassword.sendKeys(pwd);
	}
	
	public void clickOnSignup() {
		signup.click();
	}
}
