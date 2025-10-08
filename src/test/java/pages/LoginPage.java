package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /* =============================== Locators ================================ */

    @FindBy(css = "input[id='email']")
    WebElement email;

    @FindBy(css = "input[id='password']")
    WebElement password;

    @FindBy(xpath = "//button[text()='Sign in']")
    WebElement signin;

    /* ================================ Actions ================================ */

    public void setEmailAddress(String mail) {
        wait.until(ExpectedConditions.visibilityOf(email));
        email.clear();
        email.sendKeys(mail);
    }

    public void setPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(pwd);
    }

    public void clickOnSigninBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(signin)).click();
    }
}
