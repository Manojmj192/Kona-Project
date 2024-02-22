package org.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_delivery_route {
	
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
		driver.findElement(By.xpath("//a[@id='delivery_route_side_bar']/span")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 3)
	private void routelist() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='base-content-page']/div/nav/div/div/div[1]/h4")).getText();
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	private void editlist() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='pagination-data-container']//tr[2]//td[6]//div//button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='pagination-data-container']//tr[2]//td[6]//div//ul//li[2]")).click();
		Thread.sleep(5000);
		
		WebElement route = driver.findElement(By.xpath("//input[@id='delivery_route']"));
		route.clear();
		route.sendKeys("Testing 666");
		
		WebElement findElement = driver.findElement(By.xpath("//button[@id='delivery_single_update']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", findElement);
		Thread.sleep(10000);

		String text1 = driver.findElement(By.xpath("//div[@id='popup-delivery-edit']/div/div/div/div/div/h2")).getText();
		System.out.println(text1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='popup-delivery-edit']/div/div/div/div/div/p/a/button"));
		Thread.sleep(5000);

		assertEquals(text1, "Delivery Route Updated Successfully");

	}

}
