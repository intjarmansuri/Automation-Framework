package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage  {
		WebDriver driver;
		WebDriverWait wait;
		JavascriptExecutor js;
		
		public ProductPage(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			this.js = (JavascriptExecutor) driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css = "input[id='search-field']")
		WebElement searchBox;
		
		@FindBy(css = "p.ProductCard-Name")
		List<WebElement> productTitles;
		
		@FindBy(css = "div[id = 'category-sort_wrapper']")
		WebElement sortDropdown;
		
		@FindBy(xpath = "//li[text()='Price: Low to High']")
		WebElement LowToHighOption;
		
		@FindBy(xpath = "//li[text()='Price: High to Low']")
		WebElement HighToLowOption;
		
		@FindBy(xpath = "//div[@class = 'ProductList-ProductsMissing']//h3")
		WebElement noResultsMessage;
		
		@FindBy(xpath = "//ul[contains(@class, 'ProductListPage ')]//li[1]")
		WebElement firstProduct;
		
		public void searchProduct(String productName) {
			wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(productName, Keys.ENTER);
		}
		
		public List<WebElement> getProductResults() {
			return wait.until(ExpectedConditions.visibilityOfAllElements(productTitles));
		}
		
		public boolean validateResults(String expectedText) {
			boolean allMatch = true;
			for(WebElement title : getProductResults()) {
				js.executeScript("arguments[0].scrollIntoView(true);", title);
				String text = title.getText().toLowerCase();
				System.out.println("Product: " + text);
				
				if (!text.contains(expectedText.toLowerCase())) {
	                allMatch = false;
	                System.out.println("Not matching: " + text);
	            }
			}
			return allMatch;
		}
		
		public void sortLowToHigh() {
			wait.until(ExpectedConditions.elementToBeClickable(sortDropdown)).click();
			wait.until(ExpectedConditions.elementToBeClickable(LowToHighOption)).click();
		}
		
		public void sortHighToLow() {
			wait.until(ExpectedConditions.elementToBeClickable(sortDropdown)).click();
			wait.until(ExpectedConditions.elementToBeClickable(HighToLowOption)).click();
		}
		
		public boolean isNoResultDisplayed() {
			try {
				return wait.until(ExpectedConditions.visibilityOf(noResultsMessage)).isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}
		
		public String getNoResultsText() {
			return wait.until(ExpectedConditions.visibilityOf(noResultsMessage)).getText();
		}
		
		public void clickOnFirstProduct() {
			wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
		}
}
