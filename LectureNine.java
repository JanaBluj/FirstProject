package MyTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LectureNine {
WebDriver driver = new EdgeDriver(); 
	
	String website = "https://www.saucedemo.com/";
	
	
	
	@BeforeTest
	
	public void mySetup() {
	}
	
	
	
	@Test(invocationCount = 10)
	
	public void AddAndRemove() {
		/*we put these 2 lines here not in the setup 
		 because we will repeat the test 10 times so it will every time start a new test*/
        driver.get(website);
		driver.manage().window().maximize();
		
		//call functions
		login();
		removeItems (); 
	}
	
	public void login() {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");;
		driver.findElement(By.id("password")).sendKeys("secret_sauce");;
		driver.findElement(By.id("login-button")).click();
		
		
	    List<WebElement> addtoCartButtons = 
	    		driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
	    System.out.println(addtoCartButtons.size());
	    
	    for (int i = 0 ; i<addtoCartButtons.size();i++) {
			addtoCartButtons.get(i).click();
		}
	
	
   }
	
	public void removeItems () {
		List<WebElement> removeCartButtons = driver.findElements(By.className("btn_secondary")); 
		
		for (int i = 0 ; i<removeCartButtons.size();i++) {
			
			removeCartButtons.get(i).click();
		}
	}
	
	@AfterTest
	public void AfterMyTest() {}
}
