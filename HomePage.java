package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By signInLink = By.xpath("//a[contains(text(),'Sign in')]");
    By registerLink = By.xpath("//a[@aria-label='Register your account']");
    By menu = By.id("menu");
    By languageButton = By.id("language");
    By contactLink = By.xpath("//a[text()='Contact']");
    By homeNav = By.xpath("//a[@data-test='nav-home']");

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Go to Sign In page
    public void goToSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }

    // Go to Register page
    public void goToRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    // Go to Home page
    public void goToHome() {
        wait.until(ExpectedConditions.elementToBeClickable(homeNav)).click();
    }

    // Go to Contact page
    public void goToContact() {
        wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
    }

    // Change language by index
    public void changeLanguage(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(languageButton)).click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//ul[@role='menu']//li)[" + index + "]")));
        option.click();
    }

    // Check if menu is displayed (used after login)
    public boolean isMenuDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).isDisplayed();
    }
}
