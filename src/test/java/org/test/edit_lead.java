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


public class edit_lead {
	
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
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/nav/div/div/div[1]/h4")).getText();
		Thread.sleep(5000);
	}
	
	@Test(priority = 4)
	private void editlist() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='pagination-data-container']//tbody//tr[1]//td[8]//button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[8]/div/ul/li[1]/a")).click();
		Thread.sleep(5000);
		
		WebElement lead = driver.findElement(By.xpath("//input[@id='ed_lead_name']"));
		lead.clear();
		lead.sendKeys("Testing lead");
		
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div[2]/div/div/div/button/span")).click();
		WebElement search = driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div[2]/div/div/div/ul/li[1]/div/input"));
		search.sendKeys("buncha flowers"); 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div[2]/div/div/div/ul/li[4]/a/label/input")).click();
		Thread.sleep(5000);
		
		WebElement voipno = driver.findElement(By.xpath("//input[@id='ed_voip_number']"));
		voipno.clear();
		voipno.sendKeys("6748239489");
		
		WebElement leadsource = driver.findElement(By.xpath("//input[@id='ed_lead_name']"));
		leadsource.clear();
		leadsource.sendKeys("Lead Test");
		
		driver.findElement(By.xpath("//*[@id='base-content-page']/div/div/div/div/div[7]/div/span[1]/button")).click();
		Thread.sleep(10000);

		String text1 = driver.findElement(By.xpath("//h2[text()='VOIP Phone Number updated successfully']")).getText();
		System.out.println(text1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='popup-voip-update']//button[text()='Close']")).click();
		Thread.sleep(5000);

		assertEquals(text1, "VOIP Phone Number updated successfully");

	}
	
}
