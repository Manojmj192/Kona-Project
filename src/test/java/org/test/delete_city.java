package org.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class delete_city {
//public static void main(String[]args) throws InterruptedException {

	WebDriver driver;

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
		driver.findElement(By.xpath("//span[text()='City | Town Management']")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	private void stateFilter() throws InterruptedException {
		// State filter
		driver.findElement(By.xpath("//button[@title='State']")).click();

		WebElement State_filter = driver.findElement(By.xpath(
				"//*[@id='base-content-page']/div[1]/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div/ul/li[1]/div//input"));
		State_filter.sendKeys("utah");
		driver.findElement(By.xpath(
				"//*[@id='base-content-page']/div[1]/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div/ul/li[47]/a/label/input"))
				.click();
		Thread.sleep(5000);

	}

	@Test(priority = 4)
	private void cityfilterList() throws InterruptedException {
		// City filter
		driver.findElement(By.xpath("//input[@id='justAnInputBox1']")).click();

		WebElement City_Filter = driver.findElement(By.xpath(
				"//*[@id=\'justAnInputBox1\']//parent::div//parent::div//child::div[2]//input[@placeholder='Search']"));
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

		driver.findElement(By.xpath("//td[text()='Test new Salt city']//parent::tr//child::td[7]//i")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 5)
	private void deleteList() throws InterruptedException {
		// Delete click
		driver.findElement(By.xpath("//td[text()='Test new Salt city']//parent::tr//child::td[7]//ul//li[2]//a")).click();
		Thread.sleep(5000);

		// Delete confirm
		String text1 = driver.findElement(By.xpath("//h4[text()='Delete City']")).getText();
		System.out.println(text1);
		driver.findElement(By.xpath("//*[@id='popup-city-remove']/div/div/div[2]/div/a/button")).click();
		Thread.sleep(10000);

		// Delete successfully notification
		String text2 = driver.findElement(By.xpath("//h2[text()='City Deleted Successfully']")).getText();
		System.out.println(text2);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='popup-delete-city']//button[text()='Close']")).click();
		Thread.sleep(10000);

	}

	@Test(priority = 6)
	private void Statefilter2() throws InterruptedException {
		// State filter
		driver.findElement(By.xpath("//button[@title='State']")).click();
		WebElement State_filter1 = driver.findElement(By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div/ul/li[1]/div//input"));
		State_filter1.sendKeys("utah");
		driver.findElement(By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div/ul/li[47]/a/label/input")).click();
		Thread.sleep(10000);

	}

	@Test(priority = 7)
	private void cityList() throws InterruptedException {
		// City filter
		driver.findElement(By.xpath("//input[@id='justAnInputBox1']")).click();
		WebElement City_Filter1 = driver.findElement(By.xpath("//*[@id='justAnInputBox1']//parent::div//parent::div//child::div[2]//input[@placeholder='Search']"));
		Thread.sleep(3000);
		City_Filter1.sendKeys("Salt lake city");
		driver.findElement(By.xpath("//span[text()='Salt Lake City']")).click();
		Thread.sleep(5000);

		// View button
		driver.findElement(By.xpath("//button[text()='View']")).click();
		Thread.sleep(10000);

		// list plus icon
		driver.findElement(By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[2]/i[1]")).click();
		Thread.sleep(5000);
		String text3 = driver.findElement(By.xpath("//div[@id='pagination-data-container']/tbody/tr[3]/th[2]")).getText();
		System.out.println(text3);
		Thread.sleep(10000);
	}

}
