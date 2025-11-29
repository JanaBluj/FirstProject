package MyTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemo {
	
	WebDriver driver = new EdgeDriver();
	String TheWebsite = "https://www.saucedemo.com/";
	String TheWebsite2 = "https://www.google.com/";
	
	String theUserName = "standard_user"; 
	String thePassword = "secret_sauce";
	
	@BeforeTest
	public void mySetUp() throws InterruptedException {
		/*the usage of this method is to open the web site
		void org.openqa.selenium.WebDriver.get(String url)
		get method needs a string which is the web site name that I put in TheWebsite variable*/
		driver.get(TheWebsite); 
		
		/*1- the usage of this method is to display the website page at maximum size
		  2- we can also display in minimum: which will display the website screen in a minimum size 
		  3- we can also display in Fullscreen: which will display the website screen in a full screen
		  4- we can also display in minimize: which will display the website screen then minimize it*/
		driver.manage().window().maximize();	
		
		/*the usage of this method is to navigate to google after opening the saucedemo website*/
//		driver.navigate().to(TheWebsite2);
		
		/*This method will stop the system for 3 seconds
		 we use a throws with it to ignore InterruptedException which mean 
		 that this thread will interrupt the process and stop it for 3sec*/
//		Thread.sleep(3000);
		
		/*Will return to the first website which is saucedemo*/
//		driver.navigate().back();
	
//		Thread.sleep(3000);
		
		/*Will return to the second website which is google*/
//		driver.navigate().forward();
		
		//will refresh the website page (last website opened
//		driver.navigate().refresh();
	}
	
	
	@Test
	public void Login() {
		
		WebElement userNameInputField = driver.findElement(By.id("user-name"));
		
		WebElement passwordInputField = driver.findElement(By.id("password"));
		
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		
		userNameInputField.sendKeys(theUserName);
		passwordInputField.sendKeys(thePassword);
		LoginButton.click();
	}
	
	
	@AfterTest
	public void AfterFinishingTheTest() {}
	

}


/* Importanat Notes:
   1- الكود يتم تنفيذه سطر سطر 
   2- Navigate and get methods are the same 
   but the best practise is to put get method first then the navigate metod 
   3- sendKeys بتعبي النص او الفراغ يلي موجود عندي
   4- 
 */ 
