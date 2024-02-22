package org.test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_edit extends BaseClass {

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
	private void createSettingsForm() throws InterruptedException {
		// settings menu click event
		driver.findElement(By.xpath("//a[@id='setting_side_bar']/span")).click();
		Thread.sleep(5000);

	}

	@Test(priority = 3)
	private void settingslist() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='api_list']/tr[2]/td[2]")).getText();
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	private void editlist() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='api_list']/tr[2]/td[7]/div/button/i")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='api_list']/tr[2]/td[7]/div/ul/li/a")).click();
		Thread.sleep(5000);

		WebElement name = driver.findElement(By.xpath("//*[@id='apiForm']/div[1]/div/div[1]/input"));
		name.clear();
		name.sendKeys("SMS");

		WebElement accountSSID = driver.findElement(By.xpath("//*[@id='apiForm']/div[3]/div[1]/div[1]/input"));
		accountSSID.clear();
		accountSSID.sendKeys("AC7aa3e5995e9716ef3ab1b6086e672d68");

		WebElement authtoken = driver.findElement(By.xpath("//*[@id='apiForm']/div[3]/div[2]/div[1]/input"));
		authtoken.clear();
		authtoken.sendKeys("2a1bbc7f15d69b758dd0693e2586235d");

		WebElement phno = driver.findElement(By.xpath("//*[@id='apiForm']/div[3]/div[3]/div[1]/input"));
		phno.clear();
		phno.sendKeys("4097109163");

		// Update button validation
		WebElement findElement1 = driver
				.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div[2]/div/div/span[1]/button"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", findElement1);
		Thread.sleep(10000);

		// House settings updation successfully message
		String text1 = driver.findElement(By.xpath("//*[@id='popup-update-setting']/div/div/div/div/div/h2")).getText();
		System.out.println(text1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='popup-update-setting']/div/div/div/div/div/p/a/button")).click();
		Thread.sleep(10000);

		assertEquals(text1, "API Updated Successfully");

	}

}
