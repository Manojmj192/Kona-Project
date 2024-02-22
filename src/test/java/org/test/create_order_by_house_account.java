package org.test;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
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

public class create_order_by_house_account extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("create order by walk in for delivery.html");
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
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("choose_one_order_type_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (order_create_empty_validation.equals(getPropertyValue("choose_one_order_type_label"))) {
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
		String choose_house_account_type = order_management.choose_house_account_type();
		extentTest.log(Status.INFO, "Actual Result is -" + choose_house_account_type);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("search_cus_details_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (choose_house_account_type.equals(getPropertyValue("search_cus_details_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 6)
	private void invalid_house_account_num_validation() throws IOException {
		extentTest = extentReports.createTest("Verify if user enters the invalid house account number");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String invalid_house_acc_validation = order_management.invalid_house_acc_validation();
		extentTest.log(Status.INFO, "Actual Result is -" + invalid_house_acc_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("no_house_acc_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (invalid_house_acc_validation.equals(getPropertyValue("no_house_acc_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 7)
	private void search_customer() throws IOException {
		extentTest = extentReports
				.createTest("Verify the user can able to search the house account by using mobile number");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String house_account_details_input = order_management.house_account_details_input();
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_details_input);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("choose_one_order_type_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_details_input.equals(getPropertyValue("choose_one_order_type_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("create_order.png");
			extentTest.addScreenCaptureFromPath("create_order.png");
		}
	}

	@Test(priority = 8)
	private void phone_call_for_pickup_order_type() throws IOException {
		extentTest = extentReports.createTest("Verify the user can choose the phone call by delivery order type field");
		Order_management_module order_management = PageFactory.initElements(driver, Order_management_module.class);
		String select_order_type = order_management.house_acc_order_type_select();
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

	@Test(priority = 9)
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

	@Test(priority = 10)
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
		order_management.create_order_by_phonecall_delivery("recipient");
		order_management.create_order_by_phonecall_delivery("product");
		order_management.create_order_by_phonecall_delivery("messages");
		order_management.create_order_by_phonecall_delivery("payment");
	}

	@Test(priority = 11)
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

	@Test(priority = 12)
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
		order_management.order_pdf();
	}
}
