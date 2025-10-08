package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductViewPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public ProductViewPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@title = 'The black']")
	WebElement selectBlackColor;
	
	@FindBy(xpath = "//select[@id = 'volume']")
	WebElement selectVolume;
	
	@FindBy(xpath = "//button[contains(@class, 'ProductActions-AddToCart')]")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//*[@class = 'Notification-Text']")
	WebElement successMsg;
	
	
	// ==================== Actions =======================
	public void clickOnBlackColor() {
		wait.until(ExpectedConditions.elementToBeClickable(selectBlackColor)).click();
	}
	
	public void selectVolume(String user) {
		 Select select = new Select(selectVolume);
		 select.selectByVisibleText(user);
	}
	
	public void clickOnAddToCart() {
		js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	}
	
	public String getAddToCartConfirmationMsg() {
		wait.until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.getText().trim();
	}
	
	
}
