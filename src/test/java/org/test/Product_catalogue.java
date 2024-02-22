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

public class Product_catalogue extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Product catalogue Module.html");
		extentReports.attachReporter(extentHtmlReporter);
		this.driver = BrowserSetup.startBrowser();
	}

	@AfterClass
	public void exitBrowser() {
		this.driver.quit();
		this.extentReports.flush();
	}

	@Test(priority = 1)
	public void login() throws IOException {
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
	public void catalogue_list() throws IOException {
		extentTest = extentReports.createTest("Verify user land on the product catalogue list page");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("list_Catalogue");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("List_Catalogue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("List_Catalogue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcataloguepage.png");
			extentTest.addScreenCaptureFromPath("Listcataloguepage.png");
		}
	}

	@Test(priority = 3)
	private void select_catalouge_module() throws IOException {
		extentTest = extentReports.createTest("Verify the page landing on the create catalogue form");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("create_Catalouge");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("create_cataglogue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("create_cataglogue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 4)
	public void catalogue_name_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the catalouge name field empty validaiton error is displayed");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		productsList.buttonClick();
		String catalogue_error_fields = productsList.catalogue_error_fields("catalogue_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + catalogue_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("catalogue_name_mandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (catalogue_error_fields.equals(getPropertyValue("catalogue_name_mandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 5)
	private void select_category_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the select category field empty validaiton error is displayed");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String catalogue_error_fields = productsList.catalogue_error_fields("catagory_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + catalogue_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("select_category_mandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (catalogue_error_fields.equals(getPropertyValue("select_category_mandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 6)
	private void select_product_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the select product field empty validaiton error is displayed");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String catalogue_error_fields = productsList.catalogue_error_fields("product_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + catalogue_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_mandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (catalogue_error_fields.equals(getPropertyValue("product_mandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

//	@Test(priority = 7)
	private void min_character_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify if user enters minium character, error message should be displayed");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String min_char_validation = productsList.min_char_validation();
		extentTest.log(Status.INFO, "Actual Result is -" + min_char_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("min_validation_error"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (min_char_validation.equals(getPropertyValue("min_validation_error"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}
	
	@Test(priority = 8)
	private void create_catalogue() throws IOException {
		extentTest = extentReports.createTest("Verify user can able to create the catalogue");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String create_catalogue = productsList.create_catalogue();
		extentTest.log(Status.INFO, "Actual Result is -" + create_catalogue);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("catalouge_create_success_lable"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (create_catalogue.equals(getPropertyValue("catalouge_create_success_lable"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}
	
//	@Test (priority = 9)
	private void unique_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify if user enters the existing catalogue name");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String unique_validation = productsList.unique_validation("Uniqe Catalogue Name");
		extentTest.log(Status.INFO, "Actual Result is -" + unique_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("catalogue_name_unique_msg"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (unique_validation.equals(getPropertyValue("catalogue_name_unique_msg"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 10)
	private void catalogue_filter() throws IOException {
		extentTest = extentReports.createTest("Verify user can able to filter by catalogue");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String filter_by_catalogue_name = productsList.filter_by_catalogue_name();
		extentTest.log(Status.INFO, "Actual Result is -" + filter_by_catalogue_name);
		extentTest.log(Status.INFO, "Expected Result is -" + Products_module.catalogueName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (filter_by_catalogue_name.equals(Products_module.catalogueName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 11)
	private void catalogue_status() throws IOException {
		extentTest = extentReports.createTest("Verify user can cable to filter by status");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String filter_by_cat_status = productsList.filter_by_cat_status();
		extentTest.log(Status.INFO, "Actual Result is -" + filter_by_cat_status);
		extentTest.log(Status.INFO, "Expected Result is -" + "Active");
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (filter_by_cat_status.equals("Active")) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 12)
	private void verify_edit_catalogue_label() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the page landing on the edit catalogue page");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String catalogue_edit = productsList.catalogue_edit_page();
		extentTest.log(Status.INFO, "Actual Result is -" + catalogue_edit);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("edit_catalogue_lable"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (catalogue_edit.equals(getPropertyValue("edit_catalogue_lable"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 13)
	private void update_catalgoue() throws IOException {
		extentTest = extentReports.createTest("Verify the user updates the catalogue name ");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String update_catalogue = productsList.update_catalogue();
		extentTest.log(Status.INFO, "Actual Result is -" + update_catalogue);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("update_popup"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (update_catalogue.equals(getPropertyValue("update_popup"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 14)
	private void delete_catalogue_confirm() throws IOException {
		extentTest = extentReports.createTest("Verify user can delete the catalouge");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String delete_catalgoue = productsList.delete_catalgoue();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_catalgoue);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("delete_catalouge_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_catalgoue.equals(getPropertyValue("delete_catalouge_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 15)
	private void confirm_delete() throws IOException {
		extentTest = extentReports.createTest("Verify user can view the delete success popup");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String delete_catalouge_confirm = productsList.delete_catalouge_confirm();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_catalouge_confirm);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("catalogue_delete_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_catalouge_confirm.equals(getPropertyValue("catalogue_delete_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
		productsList.modulePage("create_Catalouge");
		productsList.create_catalogue();
	}

}
