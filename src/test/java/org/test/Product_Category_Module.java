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

public class Product_Category_Module extends BaseClass {

	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Product category Module.html");
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
	public void category_Module() throws IOException {
		extentTest = extentReports.createTest("Verify user land on the product category list page");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("list_Category");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("List_Product"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("List_Product"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}

	@Test(priority = 3)
	public void create_Category_Form() throws IOException {
		extentTest = extentReports.createTest("Verify user create the category validation");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("create_Category");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Create_category"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("Create_category"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_Category_Form.png");
			extentTest.addScreenCaptureFromPath("create_Category_Form.png");
		}
	}

	@Test(priority = 4)
	private void create_Categoryfrom_errorvalidation() throws IOException {
		extentTest = extentReports.createTest("Verify the validation error messages for category");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		productsList.buttonClick();
		String modulePage = productsList.category_error_fields("category_mandatory_validatoin");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CategoryMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("CategoryMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("category_mandatory_validatoin.png");
			extentTest.addScreenCaptureFromPath("category_mandatory_validatoin.png");
		}
	}

	@Test(priority = 5)
	private void create_Categoryfrom_descriptionerrorvalidation() throws IOException {
		extentTest = extentReports.createTest("Verify the validation error messages for description");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.category_error_fields("description_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DescriptionMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("DescriptionMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("category_mandatory_validatoin.png");
			extentTest.addScreenCaptureFromPath("category_mandatory_validatoin.png");
		}
	}

	@Test(priority = 6)
	private void invalid_validation_test() throws IOException {
		extentTest = extentReports.createTest("Verify the invalid data validation");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		productsList.invalid_category();
		String error_Fields = productsList.category_error_fields("category_invalid");
		extentTest.log(Status.INFO, "Actual Result is -" + error_Fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CategoryInvalid"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (error_Fields.equals(getPropertyValue("CategoryInvalid"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("category_mandatory_validatoin.png");
			extentTest.addScreenCaptureFromPath("category_mandatory_validatoin.png");
		}
		productsList.category_field_clear();
	}

	@Test(priority = 7)
	private void create_category() throws IOException {
		extentTest = extentReports.createTest("Verify the category creation with valid data");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String valid_Record = productsList.valid_Record();
		extentTest.log(Status.INFO, "Actual Result is -" + valid_Record);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Createcategory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (valid_Record.equals(getPropertyValue("Createcategory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("category_mandatory_validatoin.png");
			extentTest.addScreenCaptureFromPath("category_mandatory_validatoin.png");
		}
	}

	@Test(priority = 8)
	private void category_edit() throws IOException {
		extentTest = extentReports.createTest("Verify the user can be able to edit the category");
		Products_module productslist = PageFactory.initElements(driver, Products_module.class);
		String category_Edit = productslist.Category_Edit();
		extentTest.log(Status.INFO, "Actual Result is -" + category_Edit);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Editcategory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (category_Edit.equals(getPropertyValue("Editcategory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("category_mandatory_validatoin.png");
			extentTest.addScreenCaptureFromPath("category_mandatory_validatoin.png");
		}
		productslist.category_field_clear();
	}

	@Test(priority = 9)
	private void update_success() throws IOException {
		extentTest = extentReports.createTest("Verify the update success popup is displayed");
		Products_module productslist = PageFactory.initElements(driver, Products_module.class);
		String update_category = productslist.update_category();
		extentTest.log(Status.INFO, "Actual Result is -" + update_category);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Updatedcategory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (update_category.equals(getPropertyValue("Updatedcategory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("category_mandatory_validatoin.png");
			extentTest.addScreenCaptureFromPath("category_mandatory_validatoin.png");
		}
	}

	@Test(priority = 10)
	private void filter_by_categoryname() throws IOException {
		extentTest = extentReports.createTest("Verify the updated categories are listed in the category table");
		Products_module productslist = PageFactory.initElements(driver, Products_module.class);
		productslist.filter_by_category_name();
		String list_by_category = productslist.list_by_category();
		extentTest.log(Status.INFO, "Actual Result is -" + list_by_category);
		extentTest.log(Status.INFO, "Expected Result is -" + Products_module.categoryName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (list_by_category.equals(Products_module.categoryName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("category_mandatory_validatoin.png");
			extentTest.addScreenCaptureFromPath("category_mandatory_validatoin.png");
		}
	}

	@Test(priority = 11)
	private void category_delete() throws IOException {
		extentTest = extentReports.createTest("Verify the user can be able to delete the category");
		Products_module productslist = PageFactory.initElements(driver, Products_module.class);
		String category_delete = productslist.category_delete();
		extentTest.log(Status.INFO, "Actual Result is -" + category_delete);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Deletecategory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (category_delete.equals(getPropertyValue("Deletecategory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("category_mandatory_validatoin.png");
			extentTest.addScreenCaptureFromPath("category_mandatory_validatoin.png");
		}
		productslist.modulePage("create_Category");
		productslist.valid_Record();
	}
}
