package org.test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_create {

	WebDriver driver;
	String attribute;
	WebElement findElement;

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

		// Settings create button
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/nav/div/div/div[2]/div/a")).click();
		Thread.sleep(10000);

		String text1 = driver.findElement(By.xpath("//*[@id='base-content-page']/nav/div/div/div/h4/a")).getText();
		System.out.println(text1);
	}

	@Test(priority = 3)
	private void validateMandatoryName() throws InterruptedException {
		findElement = driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div[2]/div/div/span[1]/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", findElement);
		Thread.sleep(5000);

		String text2 = driver.findElement(By.xpath("//*[@id='apiForm']/div[1]/div/div[2]/strong")).getText();
		System.out.println(text2);
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	private void validateType() throws InterruptedException {
		String text3 = driver.findElement(By.xpath("//*[@id='apiForm']/div[2]/div/div[2]/strong")).getText();
		System.out.println(text3);
		Thread.sleep(5000);
	}

	@Test(priority = 5)
	private void validateAccountSSID() throws InterruptedException {
		String text4 = driver.findElement(By.xpath("//*[@id='apiForm']/div[3]/div[1]/div[2]/strong")).getText();
		System.out.println(text4);
		Thread.sleep(5000);
	}

	@Test(priority = 6)
	private void validateAuthToken() throws InterruptedException {
		String text5 = driver.findElement(By.xpath("//*[@id='apiForm']/div[3]/div[2]/div[2]/strong")).getText();
		System.out.println(text5);
		Thread.sleep(5000);
	}

	@Test(priority = 7)
	private void validatePhNo() throws InterruptedException {
		String text6 = driver.findElement(By.xpath("//*[@id='apiForm']/div[3]/div[3]/div[2]/strong")).getText();
		System.out.println(text6);
		Thread.sleep(5000);
	}

	@Test(priority = 8)
	private void Settingscreation() throws InterruptedException {
		WebElement apiname = driver.findElement(By.xpath("//*[@id='apiForm']/div[1]/div/div[1]/input"));
		apiname.sendKeys("SMS");
		attribute = apiname.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//select[@id='type']")).click();
		driver.findElement(By.xpath("//*[@id='type']/option[1]")).click();
		Thread.sleep(10000);

		WebElement accountSSID = driver.findElement(By.xpath("//*[@id='apiForm']/div[3]/div[1]/div[1]/input"));
		accountSSID.sendKeys("AC7aa3e5995e9716ef3ab1b6086e672d68");
		attribute = accountSSID.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);

		WebElement authtoken = driver.findElement(By.xpath("//*[@id='apiForm']/div[3]/div[2]/div[1]/input"));
		authtoken.sendKeys("2a1bbc7f15d69b758dd0693e2586235d");
		attribute = authtoken.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);

		WebElement phnumber = driver.findElement(By.xpath("//*[@id='apiForm']/div[3]/div[3]/div[1]/input"));
		phnumber.sendKeys("4097109163");
		attribute = phnumber.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);

		// Create button validation
		WebElement findElement1 = driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div[2]/div/div/span[1]/button"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", findElement1);
		Thread.sleep(10000);
		

		// House settings creation successfully message
		String text7 = driver.findElement(By.xpath("//*[@id='popup-api-save']/div/div/div/div/div/h2")).getText();
		System.out.println(text7);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='popup-api-save']/div/div/div/div/div/p/a/button")).click();
		Thread.sleep(5000);

		assertEquals(text7, "API Created Successfully");

	}

}
