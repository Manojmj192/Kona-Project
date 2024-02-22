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

public class Create_delivery_route {

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
		driver.findElement(By.xpath("//a[@id='delivery_route_side_bar']/span")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Create Delivery Area']")).click();
		Thread.sleep(10000);

		String text1 = driver.findElement(By.xpath("//a[text()='Create Delivery Route ']")).getText();
		System.out.println(text1);
		
	}
	
	@Test(priority = 3)
	private void validateMandatoryRoutename() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='delivery_single_create']")).click();
		Thread.sleep(5000);

		String text2 = driver.findElement(By.xpath("//form[@id='delivery_form']/div[1]/div/div[2]/strong")).getText();
		System.out.println(text2);
	}

	@Test(priority = 4)
	private void validateMandatoryHubfield() {
		String text3 = driver.findElement(By.xpath("//form[@id='delivery_form']/div[2]/p/strong")).getText();
		System.out.println(text3);
	}
	
	@Test(priority = 5)
	private void validateUniqueNames() throws InterruptedException {
		WebElement route = driver.findElement(By.xpath("//input[@id='delivery_route']"));
		route.sendKeys("Florida route 1");
		driver.findElement(By.xpath("//button[@id='delivery_single_create']")).click();
		Thread.sleep(3000);
		String text4 = driver.findElement(By.xpath("//form[@id='delivery_form']/div[1]/div/div[2]/strong")).getText();
		System.out.println(text4);
		route.clear();
		Thread.sleep(5000);

	}
	
	@Test(priority = 6)
	private void routecreation() throws InterruptedException {
		WebElement routename = driver.findElement(By.xpath("//input[@id='delivery_route']"));
		routename.sendKeys("Test Route");
		attribute = routename.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//form[@id='delivery_form']/div[2]/div/div/div/button")).click();
		WebElement search = driver.findElement(By.xpath("//form[@id='delivery_form']/div[2]/div/div/div/ul/li[1]/div/input"));
		search.sendKeys("florida hub");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//form[@id='delivery_form']/div[2]/div/div/div/ul/li[4]/a/label")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@id='delivery_single_create']")).click();
		Thread.sleep(10000);

		String text5 = driver.findElement(By.xpath("//div[@id='popup-delivery-save']/div/div/div/div/div/h2")).getText();
		System.out.println(text5);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='popup-delivery-save']/div/div/div/div/div/p/a/button")).click();
		Thread.sleep(5000);

		assertEquals(text5, "Delivery Route Created Successfully");
	}
	
	@Test(priority = 7)
	private void routelist() {

		String text6 = driver.findElement(By.xpath("//div[@id='pagination-data-container']/tr[2]/td[2]")).getText();
		System.out.println(text6);

		assertEquals(text6, attribute);
	}

}
