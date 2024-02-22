package org.test;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.junit.AfterClass;
import org.kona.pageobjectclass.LoginPage;
import org.kona.pageobjectclass.Order_management_module;
import org.kono.browserSetUp.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class order_bulk_assign_florist extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("create order by phone call pickup.html");
		extentReports.attachReporter(extentHtmlReporter);
		this.driver = BrowserSetup.startBrowser();
	}

	@AfterClass
	public void exitBrowser() {
		this.driver.quit();
		this.extentReports.flush();
	}

	@Test(priority = 1)
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

	@Test(priority = 2)
	private void Order_management_module() throws IOException {
		extentTest = extentReports.createTest("Verify the page land on the order management page");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String order_management_menu = order_management.Order_management_menu();
		extentTest.log(Status.INFO, "Actual Result is -" + order_management_menu);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_management_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (order_management_menu.equals(getPropertyValue("order_management_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 3)
	public void bulk_assign_florist() throws IOException {
		extentTest = extentReports.createTest("Verify the page land on the bulk assign page");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String bulk_assign_florist = order_management.bulk_assign_florist();
		extentTest.log(Status.INFO, "Actual Result is -" + bulk_assign_florist);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("bulk_assign_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (bulk_assign_florist.equals(getPropertyValue("bulk_assign_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}
	
	@Test(priority = 4)
	private void select_hub() throws IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify the user can bulk assign the order to florist");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String search_valid_hub = order_management.search_valid_hub();
		extentTest.log(Status.INFO, "Actual Result is -" + search_valid_hub);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("assign_florist_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (search_valid_hub.equals(getPropertyValue("assign_florist_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}	
}
