package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends BasePage {

    private By firstName = By.xpath("//input[@placeholder='Your first name *']");
    private By lastName = By.xpath("//input[@placeholder='Your last name *']");
    private By email = By.xpath("//input[@placeholder='Your email *']");
    private By subject = By.id("subject");
    private By message = By.id("message");
    private By attachment = By.id("attachment");
    private By submit = By.xpath("//input[@data-test='contact-submit']");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(String fName, String lName, String emailAddr,
                                int subjectIndex, String msg, String filePath) {
        type(driver.findElement(firstName), fName);
        type(driver.findElement(lastName), lName);
        type(driver.findElement(email), emailAddr);
        new Select(driver.findElement(subject)).selectByIndex(subjectIndex);
        type(driver.findElement(message), msg);
        driver.findElement(attachment).sendKeys(filePath);
        click(driver.findElement(submit));
    }
}
