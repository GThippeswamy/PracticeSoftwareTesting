package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

import java.time.Duration;

public class project {

    WebDriver driver;
    WebDriverWait wait;
    String uniqueEmail;
    String password = "Thippi46@";

    HomePage home;
    RegisterPage registerPage;
    LoginPage loginPage;
    ContactPage contactPage;
    ProductPage productPage;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://practicesoftwaretesting.com/");

        home = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        contactPage = new ContactPage(driver);
        productPage = new ProductPage(driver);
    }

    // ---------------- Register -----------------
    @Test(priority = 1)
    void registerUser() {
        home.goToSignIn();
        home.goToRegister();

        uniqueEmail = "radhakrishna" + System.currentTimeMillis() + "@gmail.com";

        registerPage.registerUser(
                "Radha",
                "Krishna",
                "2002-08-16",
                "BC colony",
                "515767",
                "Brahmasamudram",
                "Andhra Pradesh",
                "India",
                "9398473184",
                uniqueEmail,
                password
        );

        Assert.assertTrue(registerPage.isLoginBoxVisible(), "❌ Registration failed!");
    }

    // ---------------- Login -----------------
    @Test(priority = 2, dependsOnMethods = "registerUser")
    void loginUser() {
        loginPage.login(uniqueEmail, password);
        Assert.assertTrue(home.isMenuDisplayed(), "❌ Login failed!");
    }

    // ---------------- Change Language -----------------
    @Test(priority = 3, dependsOnMethods = "loginUser")
    void changeLanguage() {
        home.changeLanguage(2); // Example: French
    }

    // ---------------- Contact Form -----------------
    @Test(priority = 4, dependsOnMethods = "loginUser")
    void contactForm() {
        home.goToContact();
        contactPage.fillContactForm(
                "Radha",
                "Krishna",
                "radhakrishna1432@gmail.com",
                5,
                "Automation testing helps to find defects quickly and efficiently.",
                "C:\\Users\\Dell\\Downloads\\G-Thippeswamy-FlowCV-Resume-20250812.pdf"
        );
    }

    // ---------------- Category & Checkout -----------------
    @Test(priority = 5, dependsOnMethods = "loginUser")
    void addToCartAndCheckout() throws InterruptedException {

        // Go to Home
        home.goToHome();

        // --- First product: Cash on Delivery ---
        productPage.selectCategory(); // select first category
       
    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
