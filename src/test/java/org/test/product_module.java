package org.test;

import java.awt.AWTException;
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

public class product_module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Product Module.html");
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
	public void Product_Module() throws IOException {
		extentTest = extentReports.createTest("Verify user land on the product list page");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("List_Product");
		extentTest.log(Status.INFO, "Actual Result is -" + modulePage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("" + ""));
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
	public void create_Product_Form() throws IOException {
		extentTest = extentReports.createTest("Verify user create the product");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String modulePage = productsList.modulePage("create_Product");

	}

	@Test(priority = 4)

	private void upload_product_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify user click on save button without upload image ");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String product_error_fields = productsList.product_error_fields("upload_product_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + product_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("upload_product_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (product_error_fields.equals(getPropertyValue("upload_product_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_Category_Form.png");
			extentTest.addScreenCaptureFromPath("create_Category_Form.png");
		}
	}

	@Test(priority = 5)
	private void product_name_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify user click on save button without enter product name ");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String product_error_fields = productsList.product_error_fields("product_name_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + product_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_name_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (product_error_fields.equals(getPropertyValue("product_name_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_Category_Form.png");
			extentTest.addScreenCaptureFromPath("create_Category_Form.png");
		}
	}

	@Test(priority = 6)
	private void description_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify user click on save button without enter description");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String product_error_fields = productsList.product_error_fields("description_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + product_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("description_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (product_error_fields.equals(getPropertyValue("description_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_Category_Form.png");
			extentTest.addScreenCaptureFromPath("create_Category_Form.png");
		}
	}

	@Test(priority = 7)
	private void product_type_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify user click on save button without select product type");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String product_error_fields = productsList.product_error_fields("product_type_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + product_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_type_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (product_error_fields.equals(getPropertyValue("product_type_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_Category_Form.png");
			extentTest.addScreenCaptureFromPath("create_Category_Form.png");
		}
	}

	@Test(priority = 8)
	private void product_id_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify user click on save button without enter product id");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String product_error_fields = productsList.product_error_fields("product_id_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + product_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_id_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (product_error_fields.equals(getPropertyValue("product_id_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_Category_Form.png");
			extentTest.addScreenCaptureFromPath("create_Category_Form.png");
		}
	}

	@Test(priority = 9)
	private void receipe_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify user click on save button without enter receipe");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String product_error_fields = productsList.product_error_fields("receipe_mandatory_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + product_error_fields);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("receipe_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (product_error_fields.equals(getPropertyValue("receipe_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png");
		}
	}

	@Test(priority = 10)
	private void product_name_invalid_validation() throws IOException {
		extentTest = extentReports.createTest("Verify user tried with invalidation data in product name field");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String invalid_product_name = productsList.invalid_product_name();
		extentTest.log(Status.INFO, "Actual Result is -" + invalid_product_name);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("invalid_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (invalid_product_name.equals(getPropertyValue("invalid_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png");
		}
	}

	@Test(priority = 11)
	private void create_product() throws IOException, AWTException, InterruptedException {
		extentTest = extentReports.createTest("Verify user can able to create the product");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String create_product = productsList.create_product();
		extentTest.log(Status.INFO, "Actual Result is -" + create_product);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_created_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (create_product.equals(getPropertyValue("product_created_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png");
		}
	}
	
	@Test (priority = 12)
	private void unique_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify if user enters the existing occasion name");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String unique_validation = productsList.unique_validation("Unique Product Name");
		extentTest.log(Status.INFO, "Actual Result is -" + unique_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_name_unique_msg"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (unique_validation.equals(getPropertyValue("product_name_unique_msg"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("product.png");
			extentTest.addScreenCaptureFromPath("product.png");
		}
	}


	@Test(priority = 13)
	private void search_by_product() throws IOException {
		extentTest = extentReports.createTest("Verify user can able to search the product");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String search_by_product_name = productsList.search_by_product_name();
		extentTest.log(Status.INFO, "Actual Result is -" + search_by_product_name);
		extentTest.log(Status.INFO, "Expected Result is -" + Products_module.productname);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (search_by_product_name.equals(Products_module.productname)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png");
		}
	}

	@Test(priority = 14)
	private void search_by_status() throws IOException {
		extentTest = extentReports.createTest("Verify user can able to select the active status");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String filter_by_product_status = productsList.filter_by_product_status();
		extentTest.log(Status.INFO, "Actual Result is -" + filter_by_product_status);
		extentTest.log(Status.INFO, "Expected Result is -" + Products_module.productname);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (filter_by_product_status.equals(Products_module.productname)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png");
		}
	}

	@Test(priority = 15)

	private void view_product() throws IOException {
		extentTest = extentReports
				.createTest("Verify user can able to click the view action and they can view the product view popup");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String product_action_view = productsList.product_action_view();
		extentTest.log(Status.INFO, "Actual Result is -" + product_action_view);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_view"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (product_action_view.equals(getPropertyValue("product_view"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png")	;
		}
	}

	@Test(priority = 16)
	private void verify_edit_label() throws IOException {
		extentTest = extentReports.createTest("Verify user is landing on the edit product form");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String product_action_edit = productsList.product_action_edit();
		extentTest.log(Status.INFO, "Actual Result is -" + product_action_edit);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("edit_product"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (product_action_edit.equals(getPropertyValue("edit_product"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png");
		}
	}

	@Test(priority = 17)
	private void update_product_name() throws IOException {
		extentTest = extentReports.createTest("Verify user can able to update the product name");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String update_product = productsList.update_product();
		extentTest.log(Status.INFO, "Actual Result is -" + update_product);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_update_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (update_product.equals(getPropertyValue("product_update_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png");
		}
	}

	@Test(priority = 18)
	private void delete_product() throws IOException {
		extentTest = extentReports.createTest("Verify user can able to delete the product");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String delete_product = productsList.delete_product();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_product);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("delete_product"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_product.equals(getPropertyValue("delete_product"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png");
		}
	}

	@Test(priority = 19)
	private void delete_confirmation() throws IOException {
		extentTest = extentReports.createTest("Verify user can view the delete confirmation popup");
		Products_module productsList = PageFactory.initElements(driver, Products_module.class);
		String delete_confirmation = productsList.delete_confirmation();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_confirmation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_delete_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_confirmation.equals(getPropertyValue("product_delete_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_product_Form.png");
			extentTest.addScreenCaptureFromPath("create_product_Form.png");
		}
	}

}
