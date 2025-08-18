package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Select category and first product
    public void selectCategory() throws InterruptedException {
    	WebElement category = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//input[contains(@data-test,'category-')]")));
		    category.click();

		   
		    WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//a[contains(@data-test,'product-')]")));
		    product.click();

		    
		    WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//button[contains(@data-test,'add-to-cart')]")));
		    addToCart.click();

		   
		    try {
		        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//div[contains(@class,'toast-message')]")));
		        wait.until(ExpectedConditions.invisibilityOf(toast));
		    } catch (Exception e) {
		        
		    }

		   
		    WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//a[contains(@data-test,'nav-cart')]")));
		    cart.click();

		  
		    WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//input[contains(@data-test,'product-quantity')]")));
		    quantity.clear();
		    quantity.sendKeys("2");

		   
		    WebElement proceed = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//button[contains(@data-test,'proceed-')]")));
		    proceed.click();
		    Thread.sleep(5000);
		    
		        
		    WebElement proceed2 = wait.until(ExpectedConditions.elementToBeClickable(
			        By.xpath("//button[@data-test='proceed-2']")));
			    proceed2.click();
			    Thread.sleep(5000);
			    
			    
			    WebElement proceed3 = wait.until(ExpectedConditions.elementToBeClickable(
				        By.xpath("//button[@data-test='proceed-3']")));
				    proceed3.click();
				    Thread.sleep(5000);
				    
				    WebElement drop = driver.findElement(By.xpath("//select[@data-test='payment-method']"));
				    Select down = new Select(drop);
				    down.selectByVisibleText("Cash on Delivery");

				    WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(
					        By.xpath("//button[@data-test='finish']")));
					    confirm.click();
					    Thread.sleep(5000);
					
					    WebElement successMsg = wait.until(
					        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='payment-success-message']"))
					    );

					  
					    String msgText = successMsg.getText();
					    System.out.println("Payment success message: " + msgText);

					    
					    Assert.assertTrue(successMsg.isDisplayed(), "Payment success message not visible!");
					   
					    Thread.sleep(5000);
					    WebElement click = driver.findElement(By.xpath("//a[@data-test='nav-home']"));
					    JavascriptExecutor js = (JavascriptExecutor) driver;
					    js.executeScript("arguments[0].click();", click);
					    Thread.sleep(5000);
					    
					    
    
					    
					    WebElement searchBox = driver.findElement(By.xpath("//input[@id='search-query']"));
						  searchBox.sendKeys("Wrench", Keys.ENTER);
						  Thread.sleep(6000);
						  
						  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

						  WebElement item = wait.until(ExpectedConditions.elementToBeClickable(
						      By.xpath("//a[contains(@class,'card') and contains(@href,'/product/')]")
						  ));
						  item.click();
						  System.out.println("Item clicked");

						  
						  
						  WebElement addToCart1 = wait.until(ExpectedConditions.elementToBeClickable(
							        By.xpath("//button[contains(@data-test,'add-to-cart')]")));
							    addToCart1.click();
							    

							    try {
							        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
							            By.xpath("//div[contains(@class,'toast-message')]")));
							        wait.until(ExpectedConditions.invisibilityOf(toast));
							    } catch (Exception e) {
							        
							    }

							   
							    WebElement cart1 = wait.until(ExpectedConditions.elementToBeClickable(
							        By.xpath("//a[contains(@data-test,'nav-cart')]")));
							    cart1.click();
							    Thread.sleep(6000);

							    WebElement quantityB = wait.until(ExpectedConditions.visibilityOfElementLocated(
							    	    By.xpath("//input[contains(@data-test,'quantity')]")
							    	));
							    	quantityB.clear();
							    	quantityB.sendKeys("2");

							   
							    WebElement proceedB = wait.until(ExpectedConditions.elementToBeClickable(
							        By.xpath("//button[contains(@data-test,'proceed-')]")));
							    proceedB.click();
							    Thread.sleep(5000);
							    
							        
							    WebElement proceed2B = wait.until(ExpectedConditions.elementToBeClickable(
								        By.xpath("//button[@data-test='proceed-2']")));
								    proceed2B.click();
								    Thread.sleep(5000);
								    
								    
								    WebElement proceed3B = wait.until(ExpectedConditions.elementToBeClickable(
									        By.xpath("//button[@data-test='proceed-3']")));
									    proceed3B.click();
									    Thread.sleep(5000);
									    
									    WebElement dropB = driver.findElement(By.xpath("//select[@data-test='payment-method']"));
									    Select downB = new Select(dropB);
									    downB.selectByVisibleText("Bank Transfer") ;
									    
									   driver.findElement(By.xpath("//input[@data-test='bank_name']")).sendKeys("Union Bank");
									   driver.findElement(By.xpath("//input[@placeholder='Account Name']")).sendKeys("Radhakrishna");
									   driver.findElement(By.xpath("//input[@placeholder='Account Number']")).sendKeys("0285101008307");
									   WebElement confirm1 = wait.until(ExpectedConditions.elementToBeClickable(
										        By.xpath("//button[@data-test='finish']")));
										    confirm1.click();
										    Thread.sleep(5000); 
										    WebElement successMsg1 = wait.until(
											        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='payment-success-message']"))
											    );

											  
											    String msgText1 = successMsg1.getText();
											    System.out.println("Payment success message: " + msgText1);

											    
											  
//									
    }
}




