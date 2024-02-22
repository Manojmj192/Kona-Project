package org.test;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.kona.pageobjectclass.Dispatch_Module_Page;
import org.kona.pageobjectclass.Hub_Module_Page;
import org.kona.pageobjectclass.LoginPage;
import org.kono.browserSetUp.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Dispatch_Module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Dispatch Module.html");
		extentReports.attachReporter(extentHtmlReporter);
		this.driver = BrowserSetup.startBrowser();

	}

	@AfterClass
	public void exitBrowser() {
		this.driver.quit();
		this.extentReports.flush();
	}

	@Test(priority = 0)
	public void verify() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the Kona Login Page to Validate the Valid Email & Valid Password and Land on the Kona Home Page");
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials(getPropertyValue("UserName"), getPropertyValue("Password"));
		String nameerr = loginInPage.validateDashBoard();
		extentTest.log(Status.INFO, "Actual Result is -" + nameerr);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Dashboard"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (nameerr.equals(getPropertyValue("Dashboard"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ValidCredentials.png");
			extentTest.addScreenCaptureFromPath("ValidCredentials.png");
		}
	}

	@Test(priority = 1)
	public void dispatch_Module_Pages() throws InterruptedException, IOException {
		extentTest = extentReports
				.createTest("Verify Disptach Management List Page is opened when clicking on Dispatch");
		Dispatch_Module_Page module = PageFactory.initElements(driver, Dispatch_Module_Page.class);
		String editContact = module.modulePage("Module");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubListPage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("HubListPage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Hub List.png");
			extentTest.addScreenCaptureFromPath("Hub List.png");
		}
	}

	@Test(priority = 2)
	public void create_Order() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest("Verify the Order is created in the Order Management");
		Dispatch_Module_Page module = PageFactory.initElements(driver, Dispatch_Module_Page.class);
		String editContact = module.orderCreate();
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_create_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("order_create_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Hub List.png");
			extentTest.addScreenCaptureFromPath("Hub List.png");
		}
	}

}
