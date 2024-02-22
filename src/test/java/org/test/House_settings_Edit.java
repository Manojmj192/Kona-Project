package org.test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class House_settings_Edit {

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
	private void editlist() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//table[@id='setting_list']/tbody/tr/td[10]/div/button/i")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='setting_list']/tbody/tr/td[10]/div/ul/li[1]")).click();
		Thread.sleep(5000);
		
		WebElement house = driver.findElement(By.xpath("//input[@id='house_account_name']"));
		house.clear();
		house.sendKeys("Kona");
		
		WebElement phoneno = driver.findElement(By.xpath("//input[@id='phone_number']"));
		phoneno.clear();
		phoneno.sendKeys("7888752674");
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email_address']"));
		email.clear();
		email.sendKeys("berlin@mailinator.com");
		
		driver.findElement(By.xpath("//select[@id='monthly_autopay_date']")).click();
		driver.findElement(By.xpath("//select[@id='monthly_autopay_date']/option[5]")).click();
		
		WebElement deliverycharge = driver.findElement(By.xpath("//input[@id='delivery_charge']"));
		deliverycharge.clear();
		deliverycharge.sendKeys("15");
		
		WebElement customcharge = driver.findElement(By.xpath("//input[@id='custom_timeframe_charge']"));
		customcharge.clear();
		customcharge.sendKeys("35");
		
		WebElement address = driver.findElement(By.xpath("//textarea[@id='billing_address']"));
		address.clear();
		address.sendKeys("1495 E 100 S, Salt Lake City, UT 84112, United States");
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//*[text()='East 100 South']")).click();
		Thread.sleep(10000);
		
//		driver.findElement(By.xpath("//*[@id='houseAccountSettingEditForm']/div[5]/div/div[2]/div[2]/a/i")).click();
//		Thread.sleep(10000);
//		
//		By Visible = By.xpath("//*[contains(@style,'display: block;')]//child::*[@id='xicon']");
//		WebElement findElement = driver.findElement(By.xpath("//input[@id='readUrl']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		Actions action = new Actions(driver);
//		action.moveToElement(findElement).click().build().perform();
//
//		Thread.sleep(5000);
//		attachmentFile("D:\\Dazio Files\\User Images\\Automate Image.JPG");
//		if (!conditionChecking(Visible, 3)) {
//			do {
//				action.moveToElement(findElement).click().build().perform();
//				Thread.sleep(5000);
//				attachmentFile("D:\\Dazio Files\\User Images\\Automate Image.JPG");
//			} while (!conditionChecking(Visible, 3));
//		}
//		Thread.sleep(10000);
//
//
//		Thread.sleep(5000);
//
//		BaseClass baseClass = new BaseClass();
//		baseClass.attachmentFile("D:\\Dazio Files\\User Images\\Automate Image.JPG");
//		Thread.sleep(5000);
		
		// Update button validation
	    WebElement findElement1 = driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div/div/span[1]/button"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", findElement1);
		Thread.sleep(10000);

		// House settings updation successfully message
		String text1 = driver.findElement(By.xpath("//*[@id='pop-up-update-success']/div/div/div/div/div/h2")).getText();
		System.out.println(text1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='pop-up-update-success']/div/div/div/div/div/a/button")).click();
		Thread.sleep(10000);

		assertEquals(text1, "Setting Updated Successfully");
		
	}


//	public Boolean conditionChecking(Object elementOrLocator, int value) {
//		Boolean text = false;
//		WebElement element = null;
//		WebDriverWait wait = new WebDriverWait(driver, value);
//		try {
//			if (elementOrLocator instanceof WebElement) {
//				element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
//			} else if (elementOrLocator instanceof By) {
//				element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
//			}
//			text = element.isEnabled();
//		} catch (Exception e) {
//			return text;
//		}
//		return text;
//	}	

}
