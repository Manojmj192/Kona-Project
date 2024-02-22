package org.test;

import java.io.IOException;

import org.base.BaseClass;
import org.kona.pageobjectclass.LoginPage;
import org.kona.pageobjectclass.Products_module;
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

public class checkout_occation_module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("checkout occasion Module.html");
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
		loginInPage.setUserCredentials("admin@townflower.com", "Password@123");
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
	public void checkout_occasion_Module() throws IOException {
		extentTest = extentReports.createTest("Verify user land on the checkout occasion list page");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("list_Checkoutoccasion");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("list_Checkoutoccation"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("List_Product"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}

	@Test(priority = 3)
	public void create_Checkout_occasion_Form() throws IOException {
		extentTest = extentReports.createTest("Verify the user land on the create checkout occasion form");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("create_Checkoutoccasion");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("formLable"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("create_occasion"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}

	@Test(priority = 4)
	private void empty_field_validation() throws IOException {
		extentTest = extentReports.createTest("Verify if user click on save button, whithout filling the form");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String checkout_occasion_creation_error_validation = productsList.checkout_occasion_creation_error_validation();
		extentTest.log(Status.INFO, "Actual Result is -" + checkout_occasion_creation_error_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("occasion_name_required_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (checkout_occasion_creation_error_validation.equals(getPropertyValue("occasion_name_required_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}

	@Test(priority = 5)
	private void create_checkout_occasion() throws IOException {
		extentTest = extentReports.createTest("Verify the user can able to create the new occasion.");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String create_occasion = productsList.create_occasion();
		extentTest.log(Status.INFO, "Actual Result is -" + create_occasion);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("create_occasion_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (create_occasion.equals(getPropertyValue("create_occasion_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}
	
//	@Test (priority = 6)
	private void unique_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify if user enters the existing occasion name");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String unique_validation = productsList.unique_validation("Uniqe Occasion Name");
		extentTest.log(Status.INFO, "Actual Result is -" + unique_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("occasion_name_unique_msg"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (unique_validation.equals(getPropertyValue("occasion_name_unique_msg"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("occasion.png");
			extentTest.addScreenCaptureFromPath("occasion.png");
		}
	}

	@Test(priority = 7)
	private void occasion_filter_search() throws IOException {
		extentTest = extentReports.createTest("Verify the user can able to filter the occasion name");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String search_by_occasion_name = productsList.search_by_occasion_name();
		extentTest.log(Status.INFO, "Actual Result is -" + search_by_occasion_name);
		extentTest.log(Status.INFO, "Expected Result is -" + Products_module.occasionname);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (search_by_occasion_name.equals(Products_module.occasionname)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}

	@Test(priority = 8)

	private void occasion_status_filter() throws IOException {
		extentTest = extentReports.createTest("Verify the user can able to filter by status");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String filter_by_occasion_status = productsList.filter_by_occasion_status();
		extentTest.log(Status.INFO, "Actual Result is -" + filter_by_occasion_status);
		extentTest.log(Status.INFO, "Expected Result is -" + ("Active"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (filter_by_occasion_status.equals(("Active"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}

	@Test(priority = 9)
	private void edit_checkout_occasion_page() throws IOException {
		extentTest = extentReports.createTest("Verify the user land on edit occasion page.");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String edit_occation_page = productsList.edit_occation_page();
		extentTest.log(Status.INFO, "Actual Result is -" + edit_occation_page);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("edit_occasion"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (edit_occation_page.equals(getPropertyValue("edit_occasion"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}

	@Test(priority = 10)
	private void edit_occasion_confirm() throws IOException {
		extentTest = extentReports.createTest("Verify the can able to update the occason.");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String update_occasion = productsList.update_occasion();
		extentTest.log(Status.INFO, "Actual Result is -" + update_occasion);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("edit_occasion_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (update_occasion.equals(getPropertyValue("edit_occasion_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}

	@Test(priority = 11)
	private void delete_occasion() throws IOException {
		extentTest = extentReports.createTest("Verify the user can able to delete the occason.");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String delete_occation = productsList.delete_occation();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_occation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("delete_occasion"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_occation.equals(getPropertyValue("delete_occasion"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}

	@Test(priority = 12)
	private void delete_occasion_confirm() throws IOException {
		extentTest = extentReports.createTest("Verify the user can able to view the delete confirmation popup");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String delete_occasion_success = productsList.delete_occasion_success();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_occasion_success);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("delete_occasion_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_occasion_success.equals(getPropertyValue("delete_occasion_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcheckoutoccasionpage.png");
			extentTest.addScreenCaptureFromPath("Listcheckoutoccasionpage.png");
		}
	}
}
