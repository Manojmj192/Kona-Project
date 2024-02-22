package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_delivery_route {

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
		String text1 = driver.findElement(By.xpath("//div[@id='pagination-data-container']/tr[2]/td[2]")).getText();
		System.out.println(text1);
	}
	
	@Test(priority = 4)
	private void deletelist() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='pagination-data-container']/tr[2]/td[6]/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='pagination-data-container']/tr[2]/td[6]/div/ul/li[3]/a")).click();
		Thread.sleep(5000);
		
		// Delete confirm
	    String text1 = driver.findElement(By.xpath("//div[@id='popup-voip-delete']/div/h4")).getText();
		System.out.println(text1);
		driver.findElement(By.xpath("//div[@id='popup-voip-delete']/div/div/div[2]/div/p/a/button")).click();
		Thread.sleep(10000);

		// Delete successfully notification
		String text2 = driver.findElement(By.xpath("//div[@id='popup-delete-voip']/div/div/div/div/div/h2")).getText();
		System.out.println(text2);
		Thread.sleep(10000);
		WebElement findElement = driver.findElement(By.xpath("//*[@id='popup-delete-voip']/div/div/div/div/div/p/a/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", findElement);
		Thread.sleep(5000);
	}
	
	@Test(priority = 5)
	private void deliveryroutelist() throws InterruptedException {
		String text3 = driver.findElement(By.xpath("//label[@id='table_label_id']")).getText();
		System.out.println(text3);
		Thread.sleep(10000);
	}	
}
