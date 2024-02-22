package org.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class create_lead {

	WebDriver driver;
	String attribute;

	@BeforeClass
	private void launchURL() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://konaapi.zaiportal.com/login");
		driver.manage().window().maximize();
	}

	@AfterClass
	private void quit() {
		driver.quit();

	}

	@Test(priority = 1)
	private void Login() throws InterruptedException {
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter your Email Address']"));
		email.sendKeys("admin@townflower.com");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter your Password']"));
		password.sendKeys("Password@123");
		WebElement Login = driver.findElement(By.xpath("//button[@id= 'ajaxSubmit']"));
		Login.click();
		Thread.sleep(10000);

		String text = driver.findElement(By.xpath("//h1[text()='Welcome Back ']")).getText();
		System.out.println(text);
	}

	@Test(priority = 2)
	private void menuClick() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Lead Source']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()='Create Lead Source']")).click();
		Thread.sleep(10000);

		String text1 = driver.findElement(By.xpath("//a[text()=' Create Lead Source']")).getText();
		System.out.println(text1);
	}

	@Test(priority = 3)
	private void validateMandatoryLeadname() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div[7]/div/span[1]/button")).click();
		Thread.sleep(5000);

		String text2 = driver.findElement(By.xpath("//strong[text()='The lead name field is required.']")).getText();
		System.out.println(text2);
	}

	@Test(priority = 4)
	private void validateMandatoryStorefield() {
		String text3 = driver.findElement(By.xpath("//strong[text()='The store field is required']")).getText();
		System.out.println(text3);
	}

	@Test(priority = 5)
	private void validateMandatoryVoipnumber() {
		String text4 = driver.findElement(By.xpath("//strong[text()='The voip number field is required.']")).getText();
		System.out.println(text4);
	}

	@Test(priority = 6)
	private void validateMandatoryLeadsource() {
		String text5 = driver.findElement(By.xpath("//strong[text()='The lead source field is required.']")).getText();
		System.out.println(text5);
	}

	// Unique validations
	@Test(priority = 7)
	private void leadcreation() throws InterruptedException {
		WebElement leadname = driver.findElement(By.xpath("//input[@id='lead_name']"));
		leadname.sendKeys("Test lead");
		attribute = leadname.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div[2]/div/div/div/button/span")).click();
		WebElement search = driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div[2]/div/div/div/ul/li[1]/div/input"));
		search.sendKeys("lehi flower delivery");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div[2]/div/div/div/ul/li[3]")).click();
		Thread.sleep(5000);

		WebElement voipnumber = driver.findElement(By.xpath("//input[@id='voip_number']"));
		voipnumber.sendKeys("3674753786");
		WebElement leadsource = driver.findElement(By.xpath("//input[@id='lead_source']"));
		leadsource.sendKeys("Test lead source");
 
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div[7]/div/span[1]/button")).click();
		Thread.sleep(10000);

		String text6 = driver.findElement(By.xpath("//h2[text()='VOIP Phone Number created successfully']")).getText();
		System.out.println(text6);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='popup-voip-save']//button[text()='Close']")).click();
		Thread.sleep(5000);

		assertEquals(text6, "VOIP Phone Number created successfully");

	}

	// Lead source List validation
	@Test(priority = 8)
	private void citylist() {

		String text7 = driver.findElement(By.xpath("//div[@id='pagination-data-container']/tbody/tr[1]/td[2]")).getText();
		System.out.println(text7);

		assertEquals(text7, attribute);
	}

}
