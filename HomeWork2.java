package MyTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeWork2 {
	WebDriver driver = new ChromeDriver();
	String websiteLink = "https://automationexercise.com/";
	
	String UserName = "Jana_Bluj";
	String email = "janablouj4@gmail.com";
	String Password = "XYZ$2017";
	String FirstName = "Jana";
	String LastName = "Bluj";
	String Address = "khalda-Alsaleheen neighborhood";
	String Country = "India";
	String State = "Newdelhi";
	String City = "Qila Rai Pithora";
	String ZipCode = "110003";
	String Phone = "+917428730894";
	
	@BeforeTest
	public void mySetUp() {
		driver.get(websiteLink);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test (priority = 1)
	public void signUp() {
		
		//These 3 methods below did the same job
		
		/*1- driver.navigate().to("https://automationexercise.com/login");
		  if I don't want to search about the element we can use this statement*/
		
		/*2- driver.findElement(By.partiallinkText("Signup")).click();   
		 top leftهاي بتاخد اول عنصر بتلاقيه في ال
		 We use it if we want part of text  */  
		
		driver.findElement(By.linkText("Signup / Login")).click();
		/*3- to get the tag a (with the text of Signup / Login full text)*/
		 
		//SignUp Info part 1
		WebElement name = driver.findElement(By.name("name"));
		WebElement Email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		WebElement signUpButton = driver.findElement(By.xpath("//button[normalize-space()='Signup']"));
		
		name.sendKeys(UserName);
		Email.sendKeys(email);
		signUpButton.click();
		
		//SignUp Info part 2
		WebElement title = driver.findElement(By.id("id_gender2"));
		WebElement password = driver.findElement(By.id("password"));
		
		//date of birth
		WebElement days = driver.findElement(By.id("days"));
		WebElement months = driver.findElement(By.id("months"));
		WebElement years = driver.findElement(By.id("years"));
		
		//name details
		WebElement firstName = driver.findElement(By.id("first_name"));
		WebElement lastName = driver.findElement(By.id("last_name"));
		
		//address
		WebElement address = driver.findElement(By.id("address1"));
		WebElement country = driver.findElement(By.id("country"));
		WebElement state = driver.findElement(By.id("state"));
		WebElement city = driver.findElement(By.id("city"));
		WebElement zipcode = driver.findElement(By.id("zipcode"));
		WebElement mobileNum = driver.findElement(By.id("mobile_number"));
		
		//click create account
		WebElement createAccount = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
		
		title.click();
		password.sendKeys(Password);
		
		days.sendKeys("28");
		months.sendKeys("4");
		years.sendKeys("2003");
		
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		
		address.sendKeys(Address);
		country.sendKeys(Country);
		state.sendKeys(State);
		city.sendKeys(City);
		zipcode.sendKeys(ZipCode);
		mobileNum.sendKeys(Phone);	
		
		createAccount.click();
		
		driver.navigate().to(websiteLink);
	}
	
	@Test (priority = 2)
	public void Login() {
		driver.navigate().to("https://automationexercise.com/login");
		
		WebElement userEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		WebElement userPassword = driver.findElement(By.name("password"));
		WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(Password);
		loginbutton.click();
	}
	
	@Test (priority = 3)
	public void DeleteAccount() {
		WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));
		deleteAccount.click();
	}
	
	@AfterTest
	public void AfterFinishingTheTest() {}

}
