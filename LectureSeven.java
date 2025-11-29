//This code is the solve of H.W2
package MyTestCases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LectureSeven {
	WebDriver driver = new ChromeDriver();
	String TheWebsite = "https://automationexercise.com/";
	String TheLoginPage = "https://automationexercise.com/login";

	//عرفتهم global لانه رح استخدمهم باكتر من مكان زي تسجيل الدخول و السيناب
	Random rand = new Random();
	int myRandomNumberForTheEmail = rand.nextInt(5477110);

	String email = "ahmad" + myRandomNumberForTheEmail + "@gmail.com";
	String password = "asdASD123!@#";

	@BeforeTest

	public void mySetup() {
		driver.get(TheWebsite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1)
	public void signup() throws InterruptedException {
		
		driver.navigate().to(TheLoginPage);
//		System.out.println(email);

		WebElement NameSignUp = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		WebElement EmailSignUp = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		
		NameSignUp.sendKeys("ahmad");
		EmailSignUp.sendKeys(email);

		WebElement SignupButton = driver.findElement(By.xpath("//button[normalize-space()='Signup']"));
		SignupButton.click();

		WebElement Gender = driver.findElement(By.cssSelector("#id_gender2"));
		Gender.click();

		
		/*driver.findElement(By.xpath("//input[@id='password']")); 
		 * I go to chatgpt and write the following please add each one of them to a variable of type WebElement 
		  and give the name that is related to each one for that variable once you done give me random data
		  to send*/
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement daysDropdown = driver.findElement(By.xpath("//select[@id='days']"));
		WebElement monthsDropdown = driver.findElement(By.xpath("//select[@id='months']"));
		WebElement yearsDropdown = driver.findElement(By.xpath("//select[@id='years']"));
		WebElement firstNameField = driver.findElement(By.xpath("//input[@id='first_name']"));
		WebElement lastNameField = driver.findElement(By.xpath("//input[@id='last_name']"));
		WebElement addressField = driver.findElement(By.xpath("//input[@id='address1']"));
		WebElement stateField = driver.findElement(By.xpath("//input[@id='state']"));
		WebElement cityField = driver.findElement(By.xpath("//input[@id='city']"));
		WebElement zipcodeField = driver.findElement(By.xpath("//input[@id='zipcode']"));
		WebElement mobileNumberField = driver.findElement(By.xpath("//input[@id='mobile_number']"));

		/* بعملية ال sign up 
		   هل في وحدة من هدول يلي تحت رح تاثر علي؟
		   لا طبعا الاشي الوحيد يلي بهمني هو الايميل يلي اله معاملة خاصة انه لازم ما يتكرر*/
		passwordField.sendKeys(password);
		daysDropdown.sendKeys("15");
		monthsDropdown.sendKeys("March");
		yearsDropdown.sendKeys("1996");
		firstNameField.sendKeys("Liam");
		lastNameField.sendKeys("Johnson");
		addressField.sendKeys("42 Maple Street");
		stateField.sendKeys("California");
		cityField.sendKeys("Los Angeles");
		zipcodeField.sendKeys("90017");
		mobileNumberField.sendKeys("3105559823");

		WebElement createAccountButton = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
		createAccountButton.click();

		WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		continueButton.click();
	}

	@Test(priority = 2)
	public void Logout() {
		driver.navigate().to("https://automationexercise.com/logout");
	}

	@Test(priority = 3)
	public void Login() {
		WebElement loginEmailField = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		WebElement loginPasswordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));

		loginEmailField.sendKeys(email);
		loginPasswordField.sendKeys(password);
		
		WebElement LoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']")); 
		LoginButton.click(); 
	}
	
	@Test(priority = 4)
	public void DeleteAccount() {
		
		driver.navigate().to("https://automationexercise.com/delete_account");
		
		WebElement Countinue = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
		Countinue.click(); 
	}

	@AfterTest

	public void AfterMyTest() {
	}

}
