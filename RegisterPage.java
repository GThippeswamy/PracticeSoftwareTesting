package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;

    By firstName = By.xpath("//input[@placeholder='First name *']");
    By loginEmail = By.xpath("//input[@placeholder='Your email']");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void registerUser(String fName, String lName, String dob, String street,
                             String postcode, String city, String state, String country,
                             String phone, String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        driver.findElement(By.xpath("//input[@placeholder='Your last name *']")).sendKeys(lName);
        driver.findElement(By.xpath("//input[@placeholder='YYYY-MM-DD']")).sendKeys(dob);
        driver.findElement(By.xpath("//input[@placeholder='Your Street *']")).sendKeys(street);
        driver.findElement(By.xpath("//input[@placeholder='Your Postcode *']")).sendKeys(postcode);
        driver.findElement(By.xpath("//input[@placeholder='Your City *']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@placeholder='Your State *']")).sendKeys(state);
        driver.findElement(By.xpath("//select[@id='country']")).click();
        driver.findElement(By.xpath("//option[text()='"+country+"']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Your phone *']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@placeholder='Your email *']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Your password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btnSubmit mb-3']")).click();
    }

   
    public boolean isLoginBoxVisible() {
        try {
            WebElement loginBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginEmail)
            );
            return loginBox.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
