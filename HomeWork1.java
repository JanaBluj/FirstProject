package MyTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeWork1 {
	
	WebDriver driver = new EdgeDriver();
	String WebsiteLink = "https://www.saucedemo.com/";
	
	String theUserName = "standard_user"; 
	String thePassword = "secret_sauce";
	
	String theFirstName = "Sama";
	String theLastName = "Ahmad";
	String thePostalCode = "11953";
	
	
	@BeforeTest
	public void mySetUp() {
		driver.get(WebsiteLink);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1)
    public void BuyItem() {
		WebElement userNameInputField = driver.findElement(By.id("user-name"));
		WebElement passwordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		
		userNameInputField.sendKeys(theUserName);
		passwordInputField.sendKeys(thePassword);
		LoginButton.click();	
	}
	
	@Test (priority = 2)
	public void addItemsToCart() {
		//add elements to cart
				WebElement addFirstElementToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
				WebElement addSecondElementToCart = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
				WebElement addThirdElementToCart = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
				WebElement addFourthElementToCart = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
				WebElement addFifthElementToCart = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
				WebElement addsixthElementToCart = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
				
				addFirstElementToCart.click();
				addSecondElementToCart.click();
				addThirdElementToCart.click();
				addFourthElementToCart.click();
				addFifthElementToCart.click();
				addsixthElementToCart.click();	
	}
	
	@Test (priority = 3)
	public void checkout() {
		//Checkout
		
				//click Add To Cart Button
		        driver.navigate().to("https://www.saucedemo.com/cart.html");
				
				//click checkout
				WebElement checkoutButton = driver.findElement(By.id("checkout"));
				checkoutButton.click();	
						
				//Fill the fields
				WebElement firstName = driver.findElement(By.id("first-name"));
				WebElement lastName = driver.findElement(By.id("last-name"));
				WebElement postalCode = driver.findElement(By.id("postal-code"));
				
				firstName.sendKeys(theFirstName);
				lastName.sendKeys(theLastName);
				postalCode.sendKeys(thePostalCode);
				
				//Continue the checkout process
				WebElement continueButton = driver.findElement(By.id("continue"));
				continueButton.click();
				
				//Finish the checkout
				WebElement finishCheckout = driver.findElement(By.id("finish"));
				finishCheckout.click();
	}
	
	@AfterTest
	public void AfterFinishingTheTest() {}

}
