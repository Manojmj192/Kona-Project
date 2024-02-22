
package org.test;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.kona.pageobjectclass.Order_management_module;
import org.kona.pageobjectclass.LoginPage;
import org.kona.pageobjectclass.Order_management_module;
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

public class create_order_by_phone_call_delivery extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("create order by phone call delivery.html");
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
	private void select_order_type() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can able to select the order type");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String select_order_type = order_management.select_order_type();
		extentTest.log(Status.INFO, "Actual Result is -" + select_order_type);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("address_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (select_order_type.equals(getPropertyValue("address_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 10)
	private void empty_validation_for_address_field() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the validation error message is displayed in the address field.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String order_create_empty_validation = order_management
				.order_create_empty_validation("address_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + order_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("customer_address_err_msg"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (order_create_empty_validation.equals(getPropertyValue("customer_address_err_msg"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 11)
	private void address_for_delivery_service() throws IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify user can able to enter the address details");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String address_for_delivery = order_management.address_for_delivery();
		extentTest.log(Status.INFO, "Actual Result is -" + address_for_delivery);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("phone_call_for_delivery"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (address_for_delivery.equals(getPropertyValue("phone_call_for_delivery"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 12)
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

//	@Test(priority = 13)
	private void customer_first_name_emtpy_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the empty validation error message is displayed in the first name field.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String customer_form_empty_validation = order_management
				.customer_form_empty_validation("first_name_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + customer_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("first_name_required_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (customer_form_empty_validation.equals(getPropertyValue("first_name_required_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

//	@Test(priority = 14)
	private void customer_last_name_emtpy_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the empty validation error message is displayed in the last name field.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String customer_form_empty_validation = order_management
				.customer_form_empty_validation("last_name_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + customer_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("last_name_required_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (customer_form_empty_validation.equals(getPropertyValue("last_name_required_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 15)
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

	@Test(priority = 16)
	private void customer_email_invalid_validation() throws IOException {
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
		order_management.create_order_by_phonecall_delivery("customer");
	}

	@Test(priority = 17)
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

	@Test(priority = 18)
	private void recipient_first_name_empty_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the empty validation error message is displayed in the recipient first name field");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String recipient_form_empty_validation = order_management
				.recipient_form_empty_validation("first_name_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + recipient_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("recipient_first_name_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (recipient_form_empty_validation.equals(getPropertyValue("recipient_first_name_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 19)
	private void recipient_last_name_empty_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the empty validation error message is displayed in the recipient last name field");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String recipient_form_empty_validation = order_management
				.recipient_form_empty_validation("last_name_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + recipient_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("recipient_last_name_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (recipient_form_empty_validation.equals(getPropertyValue("recipient_last_name_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 20)
	private void recipient_phone_no_empty_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify the empty validation error message is displayed in the phone no field");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String recipient_form_empty_validation = order_management
				.recipient_form_empty_validation("phone_no_empty_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + recipient_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("recipient_phone_no_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (recipient_form_empty_validation.equals(getPropertyValue("recipient_phone_no_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 21)
	private void order_create_by_phone_call_for_delivery() throws IOException {
		extentTest = extentReports.createTest("Verify the user can create the order by phone call for delivery");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String recipient_form_empty_validation = order_management
				.recipient_form_empty_validation("phone_no_invalid_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + recipient_form_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("recipient_phone_no_invalid_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (recipient_form_empty_validation.equals(getPropertyValue("recipient_phone_no_invalid_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
		order_management.create_order_by_phonecall_delivery("recipient");
		order_management.create_order_by_phonecall_delivery("product");
		order_management.create_order_by_phonecall_delivery("messages");
		order_management.create_order_by_phonecall_delivery("payment");
	}

	@Test(priority = 22)
	private void track_order_page() throws IOException {
		extentTest = extentReports.createTest("Verify the user land on the track order page");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String track_order_page = order_management.track_order_page();
		extentTest.log(Status.INFO, "Actual Result is -" + track_order_page);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("track_order"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (track_order_page.equals(getPropertyValue("track_order"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 23)
	private void track_order_edit_by_order_no() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can track the order by order no");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String track_order_edit = order_management.track_order_edit("track by order no");
		extentTest.log(Status.INFO, "Actual Result is -" + track_order_edit);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_update_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (track_order_edit.equals(getPropertyValue("order_update_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
		order_management.track_order_page();
	}

	@Test(priority = 24)

	private void track_order_edit_by_phone_no() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the user can track the order by phone no");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String track_order_edit = order_management.track_order_edit("track by phone no");
		extentTest.log(Status.INFO, "Actual Result is -" + track_order_edit);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_update_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (track_order_edit.equals(getPropertyValue("order_update_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 25)
	private void pcfd_order_view() throws IOException {
		extentTest = extentReports.createTest("Verify the user land on the order view page");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String pcfd_order_view = order_management.pcfd_order_view();
		extentTest.log(Status.INFO, "Actual Result is -" + pcfd_order_view);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("view_order"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (pcfd_order_view.equals(getPropertyValue("view_order"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 26)
	private void pcfd_order_edit() throws IOException {
		extentTest = extentReports.createTest("Verify the user land on the order edit page");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String pcfd_order_edit = order_management.pcfd_order_edit();
		extentTest.log(Status.INFO, "Actual Result is -" + pcfd_order_edit);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("edit_order"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (pcfd_order_edit.equals(getPropertyValue("edit_order"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 27)
	private void pcfd_edit_order_update() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can able to edit the form fields");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String pcfd_order_edit_confirm = order_management.pcfd_order_edit_confirm();
		extentTest.log(Status.INFO, "Actual Result is -" + pcfd_order_edit_confirm);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_update_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (pcfd_order_edit_confirm.equals(getPropertyValue("order_update_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
		order_management.order_preparation_status_change_popup();
	}

	@Test(priority = 28)
	private void printed_status_change() throws IOException {
		extentTest = extentReports.createTest("Verify the user can change the status to printed");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String status_change_confirm_order_printed = order_management.status_change_confirm_order_printed();
		extentTest.log(Status.INFO, "Actual Result is -" + status_change_confirm_order_printed);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_status_updated_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (status_change_confirm_order_printed.equals(getPropertyValue("order_status_updated_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 29)
	private void printed_status_changed_confirm() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the status is changed in the list page");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String updated_status = order_management.updated_status();
		extentTest.log(Status.INFO, "Actual Result is -" + updated_status);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("printed_status"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (updated_status.equals(getPropertyValue("printed_status"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 30)
	private void assign_florist() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can able to view the assign florist popup");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String assign_florist_popup = order_management.assign_florist_popup();
		extentTest.log(Status.INFO, "Actual Result is -" + assign_florist_popup);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("assign_florist_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assign_florist_popup.equals(getPropertyValue("assign_florist_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 31)
	private void assign_florist_confirm() throws IOException {
		extentTest = extentReports.createTest("Verify the user can able to assign florist");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String assign_florist = order_management.assign_florist();
		extentTest.log(Status.INFO, "Actual Result is -" + assign_florist);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("florist_assign_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assign_florist.equals(getPropertyValue("florist_assign_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 32)
	private void status_change_popup() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can view the update status popup");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String status_change_popup = order_management.order_preparation_status_change_popup();
		extentTest.log(Status.INFO, "Actual Result is -" + status_change_popup);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("update_status_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (status_change_popup.equals(getPropertyValue("update_status_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 33)
	private void change_status_order_preperation() throws IOException {
		extentTest = extentReports.createTest("Verify the user can change the status to order preparation");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String status_change_confirm = order_management.status_change_confirm_order_preparation();
		extentTest.log(Status.INFO, "Actual Result is -" + status_change_confirm);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_status_updated_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (status_change_confirm.equals(getPropertyValue("order_status_updated_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 34)
	private void order_preparation_status_changed_confirm() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the status is changed to Order preparation");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String updated_status = order_management.updated_status();
		extentTest.log(Status.INFO, "Actual Result is -" + updated_status);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_preparation_status"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (updated_status.equals(getPropertyValue("order_preparation_status"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 35)
	private void order_packed_status_change_popup() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can view the update status popup");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String order_packed_status_change_popup = order_management.order_packed_status_change_popup();
		extentTest.log(Status.INFO, "Actual Result is -" + order_packed_status_change_popup);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("update_status_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (order_packed_status_change_popup.equals(getPropertyValue("update_status_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 36)
	private void status_change_to_order_packed() throws IOException {
		extentTest = extentReports.createTest("Verify the user can change the stauts to order packed");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String updated_status = order_management.status_change_confirm_order_packed();
		extentTest.log(Status.INFO, "Actual Result is -" + updated_status);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_status_updated_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (updated_status.equals(getPropertyValue("order_status_updated_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 37)
	private void order_packed_status_changed_confirm() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the order status is changed to Packed");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String updated_status = order_management.updated_status();
		extentTest.log(Status.INFO, "Actual Result is -" + updated_status);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_packed_status"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (updated_status.equals(getPropertyValue("order_packed_status"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 38)
	private void dispatch_module() throws IOException {
		extentTest = extentReports.createTest("Verify the user on the dispatch module");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String dispatch_module = order_management.dispatch_module();
		extentTest.log(Status.INFO, "Actual Result is -" + dispatch_module);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("dispatch"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (dispatch_module.equals(getPropertyValue("dispatch"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 39)
	private void assign_driver_popup() throws IOException {
		extentTest = extentReports.createTest("Verify the user can view the assign driver popup");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String assign_driver = order_management.assign_driver();
		extentTest.log(Status.INFO, "Actual Result is -" + assign_driver);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("assign_driver_popup_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assign_driver.equals(getPropertyValue("assign_driver_popup_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 40)
	private void select_driver() throws IOException {
		extentTest = extentReports.createTest("Verify the user can able to select the driver in dispatch module");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String select_driver = order_management.select_driver();
		extentTest.log(Status.INFO, "Actual Result is -" + select_driver);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("assign_driver_succ"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (select_driver.equals(getPropertyValue("assign_driver_succ"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 41)
	private void validate_dispatched_status() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify one the driver is assigned to the order, then the order status is changed to dispatched");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String assign_driver_success = order_management.assign_driver_success();
		extentTest.log(Status.INFO, "Actual Result is -" + assign_driver_success);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("dispatched_status"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assign_driver_success.equals(getPropertyValue("dispatched_status"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
		order_management.Order_management_menu();
		order_management.order_packed_status_change_popup();
	}

	@Test(priority = 42)
	private void delivered_status_change() throws IOException {
		extentTest = extentReports.createTest("Verify the user can change the order status to delivered");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String status_change_confirm_order_delivery = order_management.status_change_confirm_order_delivery();
		extentTest.log(Status.INFO, "Actual Result is -" + status_change_confirm_order_delivery);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_status_updated_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (status_change_confirm_order_delivery.equals(getPropertyValue("order_status_updated_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 43)
	private void order_deliverd_status_changed_confirm() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the order status is changed to delivered");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String updated_status = order_management.updated_status();
		extentTest.log(Status.INFO, "Actual Result is -" + updated_status);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("delivered_status"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (updated_status.equals(getPropertyValue("delivered_status"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
		order_management.order_packed_status_change_popup();
	}

	@Test(priority = 44)
	private void status_change_to_cancelled() throws IOException {
		extentTest = extentReports.createTest("Verify the user can able to view the update status popup");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String status_change_confirm_order_cancelled = order_management.status_change_confirm_order_cancelled();
		extentTest.log(Status.INFO, "Actual Result is -" + status_change_confirm_order_cancelled);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_status_updated_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (status_change_confirm_order_cancelled.equals(getPropertyValue("order_status_updated_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 45)
	private void order_cancelled_status_changed_confirm() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can able to cancel the order");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String updated_status = order_management.updated_status();
		extentTest.log(Status.INFO, "Actual Result is -" + updated_status);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("order_packed_status"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (updated_status.equals(getPropertyValue("order_packed_status"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 46)
	private void customer_blacklist() throws IOException {
		extentTest = extentReports.createTest("Verify the user can able to black the customer");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String customer_blacklist_popup = order_management.customer_blacklist_popup();
		extentTest.log(Status.INFO, "Actual Result is -" + customer_blacklist_popup);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("customer_blacklist"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (customer_blacklist_popup.equals(getPropertyValue("customer_blacklist"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 47)
	private void customer_blacklist_confirm() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can confirm the customer is black listed.");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String customer_blacklist_reason = order_management.customer_blacklist_reason();
		extentTest.log(Status.INFO, "Actual Result is -" + customer_blacklist_reason);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("customer_blacklist_confirm"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (customer_blacklist_reason.equals(getPropertyValue("customer_blacklist_confirm"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
		order_management.listValidation("Order Number");
	}

	@Test(priority = 48)
	private void blacklisted_user_login() throws IOException {
		extentTest = extentReports.createTest("Verify if the blacked customer is create the order, while the popup alert message is displayed");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String blacked_user_login = order_management.blacked_user_login();
		extentTest.log(Status.INFO, "Actual Result is -" + blacked_user_login);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("customer_blacklisted_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (blacked_user_login.equals(getPropertyValue("customer_blacklisted_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

//	@Test(priority = 29)
	private void city_filter_invalid() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can search the unordered city");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String city_filter_invalid_search = order_management.city_filter_invalid_search();
		extentTest.log(Status.INFO, "Actual Result is -" + city_filter_invalid_search);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("No_records"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (city_filter_invalid_search.equals(getPropertyValue("No_records"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

//	@Test(priority = 28)
	private void city_filter_valid() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user can search the city");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String city_filter_valid = order_management.city_filter_valid();
		extentTest.log(Status.INFO, "Actual Result is -" + city_filter_valid);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("No_records"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (city_filter_valid.equals(getPropertyValue("No_records"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 49)
	private void listOrderNumberValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Order Number:" + Order_management_module.listRecord
				+ " in the Search field, Order Management [Order Number] list retrived successfully");
		Order_management_module filter = PageFactory.initElements(driver, Order_management_module.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Order Number");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Order_management_module.listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Order_management_module.listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		filter.listValidation("Sender First Name");
		this.clearField(Order_management_module.SearchBox, 10);
	}

	@Test(priority = 50)
	private void listSenderFirstNameValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Sender First Name:" + Order_management_module.listRecord
				+ " in the Search field, Order Management [Sender First Name] list retrived successfully");
		Order_management_module filter = PageFactory.initElements(driver, Order_management_module.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Sender First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Order_management_module.listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Order_management_module.listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		filter.listValidation("Sender Last Name");
		this.clearField(Order_management_module.SearchBox, 10);
	}

	@Test(priority = 51)
	private void listSenderLastNameValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Sender Last Name:" + Order_management_module.listRecord
				+ " in the Search field, Order Management [Sender Last Name] list retrived successfully");
		Order_management_module filter = PageFactory.initElements(driver, Order_management_module.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Sender Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Order_management_module.listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Order_management_module.listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		filter.listValidation("Sender Phone Number");
		this.clearField(Order_management_module.SearchBox, 10);
	}

	@Test(priority = 52)
	private void listSenderPhoneNumberValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Sender Phone Number:" + Order_management_module.listRecord
				+ " in the Search field, Order Management [Sender Phone Number] list retrived successfully");
		Order_management_module filter = PageFactory.initElements(driver, Order_management_module.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Sender Phone Number");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Order_management_module.listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Order_management_module.listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		filter.listValidation("Recipient First Name");
		this.clearField(Order_management_module.SearchBox, 10);
	}

	@Test(priority = 53)
	private void listRecipientFirstNameValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Recipient First Name:" + Order_management_module.listRecord
				+ " in the Search field, Order Management [Recipient First Name] list retrived successfully");
		Order_management_module filter = PageFactory.initElements(driver, Order_management_module.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Recipient First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Order_management_module.listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Order_management_module.listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		filter.listValidation("Recipient Last Name");
		this.clearField(Order_management_module.SearchBox, 10);
	}

	@Test(priority = 54)
	private void listRecipientLastNameValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Recipient Last Name:" + Order_management_module.listRecord
				+ " in the Search field, Order Management [Recipient Last Name] list retrived successfully");
		Order_management_module filter = PageFactory.initElements(driver, Order_management_module.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Recipient Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Order_management_module.listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Order_management_module.listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		filter.storeValue();
	}

}
