//we complete the code in lecture Eleven
package MyTestCases;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LectureTen {
    WebDriver driver = new ChromeDriver(); 
	String website = "https://codenboxautomationlab.com/practice/"; 
	
	//عرفتها هون لانه استخدمتها باكثر من فنكشن
	Random rand = new Random();

	
	@BeforeTest
	public void mySetup() {
		driver.get(website);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 
	}
	
	
	@Test(enabled = false) /*لانه حطيت هاد يلي بين الاقواس يعني هاد التست مارح يتنفذ لانه حطيتهى فولس كانه بقله تجاهله و لا تشوفه*/
	//Test Radio Button
	public void RadioButton() {
		/* بدي اياه يدور جوا 
		 div 
		 محددة مو بكل الصفحة عشان هيك عطيته 
		 id */
		WebElement DivRadio = driver.findElement(By.id("radio-btn-example")); 
		List<WebElement> AllRadioButtons = DivRadio.findElements(By.name("radioButton"));	
		
		//يختار اي وحدة عشوائية من الخيارات
		int randomInput = rand.nextInt(DivRadio.findElements(By.name("radioButton")).size());
		AllRadioButtons.get(randomInput).click();	
	}
	
	@Test
	public void  Dynamic_Dropdown_Example() {
		String [] countries = {"jo","united"}; 
		//length cause it is array if it was list we use size
		int randomCountry = rand.nextInt(countries.length);

		//Take a random country
		driver.findElement(By.id("autocomplete")).sendKeys(countries[randomCountry]);
		//ينزل بالاسهم بعدها يختار الخيار
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER));	
	}
	
	@AfterTest
	public void AfterMyTest() {}
}
