package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By email = By.xpath("//input[@placeholder='Your email']");
    private By password = By.xpath("//input[@placeholder='Your password']");
    private By loginBtn = By.xpath("//input[@value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userEmail, String userPassword) {
        type(driver.findElement(email), userEmail);
        type(driver.findElement(password), userPassword);
        click(driver.findElement(loginBtn));
    }
}
