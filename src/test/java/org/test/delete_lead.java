package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class delete_lead {

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
		driver.findElement(By.xpath("//span[text()='Lead Source']")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	private void leadlist() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/nav/div/div/div[1]/h4")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	private void deletelist() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='pagination-data-container']//tbody//tr[1]//td[8]//button")).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[8]/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		
		// Delete confirm
	    String text1 = driver.findElement(By.xpath("//h4[text()='Delete VOIP Phone Number']")).getText();
		System.out.println(text1);
		driver.findElement(By.xpath("//*[@id='popup-voip-delete']/div/div/div[2]/div/p/a/button")).click();
		Thread.sleep(10000);

		// Delete successfully notification
		String text2 = driver.findElement(By.xpath("//h2[text()='VOIP Phone Number deleted successfully']")).getText();
		System.out.println(text2);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='popup-delete-voip']//button[text()='Close']")).click();
		Thread.sleep(5000);
	}
	
	@Test(priority = 5)
	private void Leadlist() throws InterruptedException {
		String text3 = driver.findElement(By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[2]")).getText();
		System.out.println(text3);
		Thread.sleep(10000);
	}

}
