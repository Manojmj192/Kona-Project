package org.test;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class House_settings_delete {
	
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
	private void HouseAccMenu() throws InterruptedException {
		// House Account settings menu click event
		driver.findElement(By.xpath("//a[@id='house_account_setting_side_bar']/span")).click();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	private void Housesettingslist() throws InterruptedException {
		driver.findElement(By.xpath("//table[@id='setting_list']/tbody/tr/td[3]")).getText();
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	private void deletelist() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//table[@id='setting_list']/tbody/tr/td[10]/div/button/i")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='setting_list']/tbody/tr/td[10]/div/ul/li[2]")).click();
		Thread.sleep(5000);
		
		// Delete confirm
	    String text1 = driver.findElement(By.xpath("//div[@id='popup-setting-delete']/div/h4")).getText();
		System.out.println(text1);
		driver.findElement(By.xpath("//div[@id='popup-setting-delete']/div/div/div[2]/div/a/button")).click();
		Thread.sleep(10000);

		// Delete successfully notification
		String text2 = driver.findElement(By.xpath("//div[@id='pop-up-delete-success']/div/div/div/div/div/h2")).getText();
		System.out.println(text2);
		Thread.sleep(10000);
		WebElement findElement = driver.findElement(By.xpath("//div[@id='pop-up-delete-success']/div/div/div/div/div/a/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", findElement);
		Thread.sleep(5000);
		
	}

}
