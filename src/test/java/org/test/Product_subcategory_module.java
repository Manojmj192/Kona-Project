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

public class Product_subcategory_module extends BaseClass{
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
	
	@Test (priority = 2)
	
	public void category_Module() throws IOException {
		extentTest = extentReports.createTest(
				"Verify user land on the product category list page");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("list_Category");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("List_Product"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("List_Product"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
		
		}
	@Test (priority = 3)
	private void create_sc_form() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the page landing on the sub category form");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("create_sub_category");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("create_sub_category"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("List_Product"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}
	
	@Test (priority = 4)
	private void sc_main_category_errorvalidation() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the validation error messages for main category field");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		productsList.buttonClick();
		String modulePage = productsList.sc_error_fields("sc_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Main_category_mandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (modulePage.equals(getPropertyValue("Main_category_mandatory"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
		
	}
	
	@Test (priority = 5)
	private void sc_name_errorvalidation() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the validation error messages for sub category field");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		productsList.buttonClick();
		String sc_error_fields = productsList.sc_error_fields("sc_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + sc_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Sub_category_mandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (sc_error_fields.equals(getPropertyValue("Sub_category_mandatory"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}
	@Test (priority = 6)
	private void description_error_validation() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the validation error messages for Description field");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		productsList.buttonClick();
		String sc_error_fields = productsList.sc_error_fields("sc_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + sc_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Sub_category_mandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (sc_error_fields.equals(getPropertyValue("Sub_category_mandatory"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}
	
	@Test (priority = 7)
	private void invalid_validation() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the invalid data validation");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		productsList.invalid_sub_category();
		String error_Fields = productsList.sc_error_fields("sc_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + error_Fields );
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("sc_name_invalid_error"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (error_Fields.equals(getPropertyValue("sc_name_invalid_error"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
		productsList.category_field_clear();
	}
	
	@Test (priority = 8)
	private void create_sub_category() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the user can able to select the main category dropdown");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String sub_category_input_text = productsList.sub_category_input_text();
		extentTest.log(Status.INFO, "Actual Result is -" + sub_category_input_text );
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Createsubcategory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (sub_category_input_text.equals(getPropertyValue("Createsubcategory"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}
	
	@Test (priority = 9)
	private void edit_sub_category_label_verification() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the edit sub category label is present in the edit sub category form");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String sub_category_edit = productsList.sub_category_edit();
		extentTest.log(Status.INFO, "Actual Result is -" + sub_category_edit );
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Editsubcategory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (sub_category_edit.equals(getPropertyValue("Editsubcategory"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}
	
	@Test (priority = 10)
	private void update_sc_form() throws IOException, InterruptedException {
		extentTest = extentReports.createTest(
				"Verify the user can able to update the sub category edit form");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String update_sub_category_form = productsList.update_sub_category_form();
		extentTest.log(Status.INFO, "Actual Result is -" + update_sub_category_form );
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("sc_updated_success"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (update_sub_category_form.equals(getPropertyValue("sc_updated_success"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}
	}
	
	@Test (priority = 11)
	private void delete_sub_category_popup() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the user can able to view the delete popup");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String delete_sc = productsList.delete_sc_popup();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_sc );
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("Sub_category_delete"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_sc.equals(getPropertyValue("Sub_category_delete"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}	
	}
	
	@Test (priority = 12)
	private void delete_sub_category() throws IOException {
		extentTest = extentReports.createTest(
				"Verify the user can able to delete the category");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String delete_sc_confirmation = productsList.delete_sc_confirmation();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_sc_confirmation );
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("SC_deleted_successfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_sc_confirmation.equals(getPropertyValue("SC_deleted_successfully"))){
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		}else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Listcategorypage.png");
			extentTest.addScreenCaptureFromPath("Listcategorypage.png");
		}	
		
	}
	
}
