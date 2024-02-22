package org.test;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.kona.pageobjectclass.Hub_Module_Page;
import org.kona.pageobjectclass.LoginPage;
import org.kona.pageobjectclass.Order_management_module;
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

public class create_order_by_walkin_for_pickup extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("create order by walk in for pickup.html");
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
	public void create_order_module() throws IOException {
		extentTest = extentReports.createTest("Verify the page land on the order screen page");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String create_order = order_management.create_order();
		extentTest.log(Status.INFO, "Actual Result is -" + create_order);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_screen_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (create_order.equals(getPropertyValue("order_screen_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 4)
	private void choose_type_empty_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the validation error message is displayed in the choose type field.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String order_create_empty_validation = order_management
				.order_create_empty_validation("choose_type_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + order_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("choose_type_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (order_create_empty_validation.equals(getPropertyValue("choose_type_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}

	}

	@Test(priority = 5)
	private void choose_customer_type() throws IOException {
		extentTest = extentReports.createTest("Verify the search customer details form is displayed");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String choose_customer_type = order_management.choose_customer_type();
		extentTest.log(Status.INFO, "Actual Result is -" + choose_customer_type);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("search_cus_details_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (choose_customer_type.equals(getPropertyValue("search_cus_details_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 6)
	private void phone_no_empty_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the validation error message is displayed in the phone number field.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String order_create_empty_validation = order_management
				.order_create_empty_validation("phone_number_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + order_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("customer_phn_no_required_err_msg"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (order_create_empty_validation.equals(getPropertyValue("customer_phn_no_required_err_msg"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 7)
	private void search_customer() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can able to search the customer by using mobile number");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String customer_details_input = order_management.customer_details_input();
		extentTest.log(Status.INFO, "Actual Result is -" + customer_details_input);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("customer_not_fount_popup_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (customer_details_input.equals(getPropertyValue("customer_not_fount_popup_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 8)
	private void choose_one_order_type_field() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can view the choose one order type field");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String choose_one_order_type_field = order_management.choose_one_order_type_field();
		extentTest.log(Status.INFO, "Actual Result is -" + choose_one_order_type_field);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("choose_one_order_type_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (choose_one_order_type_field.equals(getPropertyValue("choose_one_order_type_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 9)
	private void walkin_for_pickup_type() throws IOException {
		extentTest = extentReports.createTest("Verify the user can choose the walkin for pickup order type field");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String order_type = order_management.order_type("walkin_for_pickup");
		extentTest.log(Status.INFO, "Actual Result is -" + order_type);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("walkin_pickup"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (order_type.equals(getPropertyValue("walkin_pickup"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 10)
	private void customer_store_name_emtpy_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the empty validation error message is displayed in the store name field.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String customer_form_empty_validation = order_management
				.customer_form_empty_validation("store_name_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + customer_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("store_name_required_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (customer_form_empty_validation.equals(getPropertyValue("store_name_required_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 11)
	private void recipient_delivery_date_empty_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the empty validation error message is displayed in the delivery date field");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String recipient_form_empty_validation = order_management
				.recipient_form_empty_validation("delivery_date_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + recipient_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("delivery_date_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (recipient_form_empty_validation.equals(getPropertyValue("delivery_date_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 12)
	private void customer_email_emtpy_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the empty validation error message is displayed in the email address field.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String customer_form_empty_validation = order_management
				.customer_form_empty_validation("email_address_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + customer_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("email_add_required_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (customer_form_empty_validation.equals(getPropertyValue("email_add_required_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 13)
	private void customer_email_invalid_validation() throws IOException, InterruptedException {
		extentTest = extentReports
				.createTest("Verify the invalid validation error message is displayed in the email address field.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String customer_form_empty_validation = order_management
				.customer_form_empty_validation("email_address_invalid_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + customer_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("invalid_email_add_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (customer_form_empty_validation.equals(getPropertyValue("invalid_email_add_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
		order_management.create_order_by_walk_in_pickup("customer");
		order_management.create_order_by_phonecall_delivery("product");
		order_management.create_order_by_phonecall_delivery("messages");
	}

	@Test(priority = 14)
	private void order_create_by_phone_call_pickup_success() throws IOException {
		extentTest = extentReports
				.createTest("Verify the invalid validation error message is displayed in the email address field.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String create_order_by_phonecall_delivery = order_management.create_order_by_phonecall_delivery("payment");
		extentTest.log(Status.INFO, "Actual Result is -" + create_order_by_phonecall_delivery);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_create_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (create_order_by_phonecall_delivery.equals(getPropertyValue("order_create_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
		order_management.order_pdf();
	}
}
