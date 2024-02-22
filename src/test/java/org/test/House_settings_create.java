package org.test;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Window;

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

public class House_settings_create extends BaseClass {

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
	private void createHouseAccForm() throws InterruptedException {
		// House Account settings menu click event
		driver.findElement(By.xpath("//a[@id='house_account_setting_side_bar']/span")).click();
		Thread.sleep(5000);

		// House Acc Settings create button
		driver.findElement(By.xpath("//div[@id='setting_create']/a")).click();
		Thread.sleep(10000);

		String text1 = driver.findElement(By.xpath("//div[@id='base-content-page']/nav/div/div/div/h4/a")).getText();
		System.out.println(text1);

	}

	@Test(priority = 3)
	private void validateMandatoryHouseAccName() throws InterruptedException {
		WebElement findElement = driver
				.findElement(By.xpath("//div[@id='base-content-page']/div/div/div/div/div[4]/span[1]/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", findElement);
		Thread.sleep(5000);

		String text2 = driver.findElement(By.xpath("//*[@id='houseAccountSettingForm']/div[1]/div[1]/div[2]/strong"))
				.getText();
		System.out.println(text2);
		Thread.sleep(5000);

	}

	@Test(priority = 4)
	private void validateMandatoryPhoneno() throws InterruptedException {

		String text3 = driver.findElement(By.xpath("//form[@id='houseAccountSettingForm']/div[1]/div[2]/p/strong"))
				.getText();
		System.out.println(text3);

	}

	@Test(priority = 5)
	private void validateMandatoryEmailfield() throws InterruptedException {

		String text4 = driver.findElement(By.xpath("//form[@id='houseAccountSettingForm']/div[2]/div[1]/div[2]/strong"))
				.getText();
		System.out.println(text4);

	}

	@Test(priority = 6)
	private void validateMandatoryAutopayDatefield() throws InterruptedException {

		String text5 = driver.findElement(By.xpath("//form[@id='houseAccountSettingForm']/div[2]/div[2]/div[2]/strong"))
				.getText();
		System.out.println(text5);

	}

	@Test(priority = 7)
	private void validateMandatoryDeliveryChargefield() throws InterruptedException {

		String text6 = driver.findElement(By.xpath("//form[@id='houseAccountSettingForm']/div[3]/div[1]/div[2]/strong"))
				.getText();
		System.out.println(text6);

	}

	@Test(priority = 8)
	private void validateMandatoryCustomChargefield() throws InterruptedException {

		String text7 = driver.findElement(By.xpath("//form[@id='houseAccountSettingForm']/div[3]/div[2]/div[2]/strong"))
				.getText();
		System.out.println(text7);

	}

	@Test(priority = 9)
	private void validateMandatoryAddressfield() throws InterruptedException {

		String text8 = driver
				.findElement(By.xpath("//div[@id='base-content-page']/div/div/div/div/div[2]/div[1]/div/p/strong"))
				.getText();
		System.out.println(text8);

	}

	@Test(priority = 10)
	private void validateMandatoryZipcodefield() throws InterruptedException {

		String text8 = driver
				.findElement(By.xpath("//div[@id='base-content-page']/div/div/div/div/div[2]/div[2]/div[2]/strong"))
				.getText();
		System.out.println(text8);

	}

	@Test(priority = 11)
	private void validateMandatoryCityfield() throws InterruptedException {

		String text9 = driver
				.findElement(By.xpath("//div[@id='base-content-page']/div/div/div/div/div[2]/div[3]/div[2]/strong"))
				.getText();
		System.out.println(text9);

	}

	@Test(priority = 12)
	private void validateMandatoryStatefield() throws InterruptedException {

		String text10 = driver
				.findElement(By.xpath("//div[@id='base-content-page']/div/div/div/div/div[2]/div[4]/div[2]/strong"))
				.getText();
		System.out.println(text10);

	}

	@Test(priority = 13)
	private void validateMandatoryImagefield() throws InterruptedException {

		String text11 = driver
				.findElement(By.xpath("//div[@id='base-content-page']/div/div/div/div/div[3]/div[2]/p/strong"))
				.getText();
		System.out.println(text11);

	}

	@Test(priority = 14)
	private void HouseSettingscreation() throws InterruptedException, AWTException {
		WebElement house = driver.findElement(By.xpath("//input[@id='house_account_name']"));
		house.sendKeys("Zaigo");
		attribute = house.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);

		WebElement phoneno = driver.findElement(By.xpath("//input[@id='phone_number']"));
		phoneno.sendKeys("6575654654");
		attribute = phoneno.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);

		WebElement email = driver.findElement(By.xpath("//input[@id='email_address']"));
		email.sendKeys("manivel@mailinator.com");
		attribute = email.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//select[@id='monthly_autopay_date']")).click();
		driver.findElement(By.xpath("//select[@id='monthly_autopay_date']/option[3]")).click();
		Thread.sleep(10000);

		WebElement deliverycharge = driver.findElement(By.xpath("//input[@id='delivery_charge']"));
		deliverycharge.sendKeys("20");
		attribute = deliverycharge.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);

		WebElement customcharge = driver.findElement(By.xpath("//input[@id='custom_timeframe_charge']"));
		customcharge.sendKeys("50");
		attribute = customcharge.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(5000);

		WebElement address = driver.findElement(By.xpath("//textarea[@id='billing_address']"));
		address.sendKeys("615 S 300 E, Salt Lake City, UT 84111, United States");
		attribute = address.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[text()='South 300 East']")).click();
		Thread.sleep(10000);
		By Visible = By.xpath("//*[contains(@style,'display: block;')]//child::*[@id='xicon']");
		WebElement findElement = driver.findElement(By.xpath("//input[@id='readUrl']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Actions action = new Actions(driver);
		action.moveToElement(findElement).click().build().perform();

		Thread.sleep(5000);
		attachmentFile(System.getProperty("user.dir") + "\\Image_File\\Automate Image.jpg");
		if (!conditionChecking(Visible, 3)) {
			do {
				action.moveToElement(findElement).click().build().perform();
				Thread.sleep(5000);
				attachmentFile(System.getProperty("user.dir") + "\\Image_File\\Automate Image.jpg");
			} while (!conditionChecking(Visible, 3));
		}
		Thread.sleep(10000);

		// Create button validation
		WebElement findElement1 = driver
				.findElement(By.xpath("//div[@id='base-content-page']/div/div/div/div/div[4]/span[1]/button"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", findElement1);
		Thread.sleep(10000);

		// House settings creation successfully message
		String text12 = driver.findElement(By.xpath("//div[@id='pop-up-create-success']/div/div/div/div/div/h2"))
				.getText();
		System.out.println(text12);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@id='pop-up-create-success']/div/div/div/div/div/a/button")).click();
		Thread.sleep(5000);

		assertEquals(text12, "Setting Created Successfully");

	}

	public Boolean conditionChecking(Object elementOrLocator, int value) {
		Boolean text = false;
		WebElement element = null;
		wait = new WebDriverWait(driver, value);
		try {
			if (elementOrLocator instanceof WebElement) {
				element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
			} else if (elementOrLocator instanceof By) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
			}
			text = element.isEnabled();
		} catch (Exception e) {
			return text;
		}
		return text;
	}

}
