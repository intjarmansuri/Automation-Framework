package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	/* =============================== Locators ================================ */
	
	// Logo
	@FindBy(xpath ="//img[contains(@alt, 'logo')]")
	WebElement logo;
	
	// My Account 
	@FindBy(css = "button[id = 'myAccount']")
	WebElement myAccount;
	
	// Create an account link
	@FindBy(xpath = "//button[text() = 'Create an account']")
	WebElement createAnAcoount;
	
	// Welcome message
	@FindBy(xpath = "//div[contains(@class, 'Header-Welcome')]")
	WebElement welcomeMessage;
	
	// Logout Button
	@FindBy(xpath = "//button[text() = 'Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//div[text() = 'Got it']")
	WebElement cookiesAccept;
	
	@FindBy(xpath ="(//li[@class = 'Menu-Item'])[1]")
	WebElement smartphonesAndGadegts;
	
	@FindBy(xpath = "//a[@id ='842']")
	WebElement smartphonesLink;

	
	/* ================================ Actions ================================ */
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	
	public void clickOnCreateAccount() {
		createAnAcoount.click();
	}
	
	public String getWelcomeMessage() {
	    return welcomeMessage.getText();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
	public void setCookies() {
		cookiesAccept.click();
	}
	
	public void moveSmartphonesAndGadegts() {
		action.moveToElement(smartphonesAndGadegts).perform();
	}
	
	public void clickOnSmartPhones() {
		smartphonesLink.click();
	}
}
