package org.test;

import static org.testng.Assert.assertEquals;

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class city_createandlist {
//	public static void main(String[] args) throws InterruptedException{
	WebDriver driver; 
	String attribute;
	// Launch Kona URL in Browser 
	@BeforeClass
	public void browserLaunch() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://konaapi.zaiportal.com/login");
		driver.manage().window().maximize();
	}

	@AfterClass
	private void quit() {
		driver.quit();

	}
	

	// Login Validations
	@Test(priority = 1)
	private void login() throws InterruptedException {
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter your Email Address']"));
		email.sendKeys("admin@townflower.com");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter your Password']"));
		password.sendKeys("Password@123");
		WebElement login = driver.findElement(By.xpath("//button[@id= 'ajaxSubmit']"));
		login.click();
		Thread.sleep(10000);

		// Dash board text validation
		String text = driver.findElement(By.xpath("//h1[text()='Welcome Back ']")).getText();
		System.out.println(text);

	}

	@Test(priority = 2)
	private void createCityForm() throws InterruptedException {
		// City menu click event
		driver.findElement(By.xpath("//span[text()='City | Town Management']")).click();
		Thread.sleep(5000);

		// City create button
		driver.findElement(By.xpath("//a[text()='Create City']")).click();
		Thread.sleep(10000);

		String text1 = driver.findElement(By.xpath("//a[text()='Create City']")).getText();
		System.out.println(text1);

	}

	@Test(priority = 3)
	private void validateMandatoryTownName() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='city_single_create']")).click();
		Thread.sleep(5000);

		String text2 = driver.findElement(By.xpath("//strong[text()='The town name field is required.']")).getText();
		System.out.println(text2);

	}
	// Required field validations

	@Test(priority = 4)
	private void validateMandatoryCityName() {
		String text3 = driver.findElement(By.xpath("//strong[text()='The city name field is required.']")).getText();
		System.out.println(text3);

	}

	@Test(priority = 5)
	private void validateMandatoryStateName() {
		String text4 = driver.findElement(By.xpath("//strong[text()='The state name field is required.']")).getText();
		System.out.println(text4);
	}

	@Test(priority = 6)
	private void validateMandatoryTimeZone() throws InterruptedException {
		String text5 = driver.findElement(By.xpath("//strong[text()='The time zone field is required.']")).getText();
		System.out.println(text5);
		Thread.sleep(10000);
	}

	// Unique validations
	@Test(priority = 7)
	private void validateUniqueNames() throws InterruptedException {
		WebElement city = driver.findElement(By.xpath("//input[@id='name']"));
		city.sendKeys("Test city");
		driver.findElement(By.xpath("//button[@id='city_single_create']")).click();
		Thread.sleep(3000);
		String text6 = driver.findElement(By.xpath("//strong[text()='The town name has already been taken.']")).getText();
		System.out.println(text6);
		city.clear();
		Thread.sleep(5000);

	}

	// City creation
	@Test(priority = 8)
	private void citycreation() throws InterruptedException {
		WebElement city2 = driver.findElement(By.xpath("//input[@id='name']"));
		city2.sendKeys("Test salt lake city");
		attribute = city2.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Search City...']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("salt lake city");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//li[text()='Salt Lake City - UT']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@id='city_single_create']")).click();
		Thread.sleep(10000);

		// City creation successfully message
		String text7 = driver.findElement(By.xpath("//h2[text()='City Created Successfully']")).getText();
		System.out.println(text7);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@id='popup-city-save']//button[text()='Close']")).click();
		Thread.sleep(5000);

		assertEquals(text7, "City Created Successfully");

	}

	@Test(priority = 9)
	private void statefilter() throws InterruptedException {
		// State filter
		driver.findElement(By.xpath("//button[@title='State']")).click();
		WebElement State_filter = driver.findElement(By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div/ul/li[1]/div//input"));
		State_filter.sendKeys("utah");
		driver.findElement(By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div/ul/li[47]/a/label/input")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 10)
	private void cityfilter() throws InterruptedException {
		// City filter
		driver.findElement(By.xpath("//input[@id='justAnInputBox1']")).click();
		WebElement City_Filter = driver.findElement(By.xpath("//*[@id=\'justAnInputBox1\']//parent::div//parent::div//child::div[2]//input[@placeholder='Search']"));
		Thread.sleep(3000);
		City_Filter.sendKeys("Salt lake city");
		driver.findElement(By.xpath("//span[text()='Salt Lake City']")).click();
		Thread.sleep(5000);
		
		// View button
		driver.findElement(By.xpath("//button[text()='View']")).click();
		Thread.sleep(10000);

		// list plus icon
		driver.findElement(By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[2]/i[1]")).click();
		Thread.sleep(5000);

	}
	

	@Test(priority = 11)
	private void citylist() {
		// list page
		String text8 = driver.findElement(By.xpath("//*[@id='pagination-data-container']//tbody//tr[6]//td[2]")).getText();
		System.out.println(text8);

		assertEquals(text8,attribute);
	}
       
        

}
