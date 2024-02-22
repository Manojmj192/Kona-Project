package org.test;

import java.io.IOException;

import org.base.BaseClass;
import org.kona.pageobjectclass.House_account_module;
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

public class house_account_module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("houseaccount.html");
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
	public void house_account_module() throws IOException {
		extentTest = extentReports.createTest("Verify the page navigates to house account page");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_module = house_account_page.house_account_module();
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_module);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("House_acc_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_module.equals(getPropertyValue("House_acc_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}

	}

	@Test(priority = 3)
	private void create_form() throws IOException {
		extentTest = extentReports.createTest("Verify the user landing on the create house account form");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String create_house_account_form = house_account_page.create_house_account_form();
		extentTest.log(Status.INFO, "Actual Result is -" + create_house_account_form);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("create_house_account"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (create_house_account_form.equals(getPropertyValue("create_house_account"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 4)
	private void business_name_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for business name");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("business_name_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("business_name_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("business_name_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 5)
	private void billing_contact_first_name_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for billing contact first name");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("billing_contact_first_name_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("billing_contact_first_name_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("billing_contact_first_name_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 6)
	private void billing_contact_last_name_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for billing contact last name");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("billing_contact_last_name_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("billing_contact_last_name_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("billing_contact_last_name_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 7)
	private void contact_email_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for contact email");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("contact_email_validation");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("contact_email_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("contact_email_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}

	}

	@Test(priority = 8)
	private void contact_phone_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for contact phone number");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("contact_phone_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("contact_phone_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("contact_phone_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 9)
	private void billing_address_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for billing address");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("billing_add_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("billing_add_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("billing_add_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}

	}

	@Test(priority = 10)
	private void monthly_invice_date_emtpy_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for monthly invoice date");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("monthly_invoice_date_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("monthly_invoice_date_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("monthly_invoice_date_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 11)
	private void monthly_autopay_date_empty_validaiton() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for monthly autopay date");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("monthly_auto_pay_date_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("monthly_autopay_date_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("monthly_autopay_date_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 12)
	private void payment_due_date_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for payment due date");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("payment_due_date_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("payment_due_date_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("payment_due_date_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 13)
	private void hub_empty_validaiton() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for hub");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("hub_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("hub_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("hub_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 14)
	private void store_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validation for store");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("store_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("store_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("store_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 15)
	public void monthly_auto_pay_lesserdate_validaiton() throws Exception {
		extentTest = extentReports
				.createTest("Verify if the user select the date lesser than the monthly invoice date");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String monthly_auto_pay_lesser_date = house_account_page.monthly_auto_pay_lesser_date();
		extentTest.log(Status.INFO, "Actual Result is -" + monthly_auto_pay_lesser_date);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("monthly_autopay_lesser_date_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (monthly_auto_pay_lesser_date.equals(getPropertyValue("monthly_autopay_lesser_date_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 16)
	public void payment_due_lesserdate_validaiton() throws Exception {
		extentTest = extentReports
				.createTest("Verify if the user select the date lesser than the monthly invoice date");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String payment_due_lesser_date = house_account_page.payment_due_lesser_date();
		extentTest.log(Status.INFO, "Actual Result is -" + payment_due_lesser_date);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("payment_due_lesser_date_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (payment_due_lesser_date.equals(getPropertyValue("payment_due_lesser_date_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}
	
	@Test(priority = 17)
	private void invalid_email_validation() throws IOException {
		extentTest = extentReports
				.createTest("Verify if the user select the date lesser than the monthly invoice date");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page.house_account_create_empty_validation("invalid_email_err");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("invalid_email_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("invalid_email_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}

	}

	@Test(priority = 18)
	private void create_house_account() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the user create the house account");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String valid_inputs = house_account_page.create_house_account();
		extentTest.log(Status.INFO, "Actual Result is -" + valid_inputs);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("house_account_create_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (valid_inputs.equals(getPropertyValue("house_account_create_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 19)
	private void add_card_details() throws IOException {
		extentTest = extentReports.createTest("Verify the user create the house account");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String add_card_details_form = house_account_page.add_card_details_form();
		extentTest.log(Status.INFO, "Actual Result is -" + add_card_details_form);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("add_card_details_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (add_card_details_form.equals(getPropertyValue("add_card_details_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 20)
	private void name_on_card_empty_validaiton() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validaiton for name on card");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("name_on_card_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("name_on_card_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("name_on_card_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 21)
	private void card_number_empty_validaiton() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validaiton for card number");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("card_num_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("card_num_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("card_num_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 22)
	private void expiry_month_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validaiton for expiry month ");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("expiry_date_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("expiry_date_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("expiry_date_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 23)
	private void expiry_year_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validaiton for expiry year ");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("expiry_year_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("expiry_year_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("expiry_year_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 24)
	private void cvv_empty_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the empty validaiton for cvv ");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_account_create_empty_validation = house_account_page
				.house_account_create_empty_validation("cvv_err_msg");
		extentTest.log(Status.INFO, "Actual Result is -" + house_account_create_empty_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("cvv_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_account_create_empty_validation.equals(getPropertyValue("cvv_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 25)
	private void card_number_maximum_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the maximum validaiton for card number ");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String card_num_max_validation = house_account_page.card_num_max_validation();
		extentTest.log(Status.INFO, "Actual Result is -" + card_num_max_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("card_no_max_validation"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (card_num_max_validation.equals(getPropertyValue("card_no_max_validation"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 26)
	private void cvv_number_maximum_validation() throws IOException {
		extentTest = extentReports.createTest("Verify the maximum validaiton for CVV number ");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String cvv_num_max_validation = house_account_page.cvv_num_max_validation();
		extentTest.log(Status.INFO, "Actual Result is -" + cvv_num_max_validation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("cvv_no_max_validation"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (cvv_num_max_validation.equals(getPropertyValue("cvv_no_max_validation"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 27)
	private void added_card_details() throws IOException {
		extentTest = extentReports.createTest("Verify the maximum validaiton for card number ");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String add_card_details = house_account_page.add_card_details();
		extentTest.log(Status.INFO, "Actual Result is -" + add_card_details);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("card_information_save_label"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (add_card_details.equals(getPropertyValue("card_information_save_label"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 28)
	private void view_action() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the maximum validaiton for card number ");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_acc_name_view_action = house_account_page.house_acc_name_view_action();
		extentTest.log(Status.INFO, "Actual Result is -" + house_acc_name_view_action);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("view_payment_details"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_acc_name_view_action.equals(getPropertyValue("view_payment_details"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 29)
	private void edit_house_account_page() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the page landing on the edit house account page");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String house_acc_edit_action = house_account_page.house_acc_edit_action();
		extentTest.log(Status.INFO, "Actual Result is -" + house_acc_edit_action);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("edit_house_acc"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (house_acc_edit_action.equals(getPropertyValue("edit_house_acc"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}

	}

	@Test(priority = 30)
	private void edit_house_account_business_name() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the page landing on the edit house account page");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String update_business_name = house_account_page.update_business_name();
		extentTest.log(Status.INFO, "Actual Result is -" + update_business_name);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("house_acc_updated"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (update_business_name.equals(getPropertyValue("house_acc_updated"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}
	

	@Test(priority = 31)
	private void validate_edited_house_account_name() throws IOException {
		extentTest = extentReports.createTest("Verify the updated house account name has been changed in list");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String validate_edited_house_acc_name = house_account_page.validate_edited_house_acc_name();
		extentTest.log(Status.INFO, "Actual Result is -" + validate_edited_house_acc_name);
		extentTest.log(Status.INFO, "Expected Result is -" + House_account_module.busiz_name);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (validate_edited_house_acc_name.equals(House_account_module.busiz_name)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 32)
	private void house_account_delete() throws IOException, InterruptedException {
		extentTest = extentReports.createTest("Verify the updated house account name has been changed in list");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String delete_house_acc = house_account_page.delete_house_acc();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_house_acc);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("delete_house_acc"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_house_acc.equals(getPropertyValue("delete_house_acc"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}

	@Test(priority = 33)
	private void house_account_delete_confirmation() throws IOException {
		extentTest = extentReports.createTest("Verify the updated house account name has been changed in list");
		House_account_module house_account_page = PageFactory.initElements(driver, House_account_module.class);
		String delete_confirm_house_acc = house_account_page.delete_confirm_house_acc();
		extentTest.log(Status.INFO, "Actual Result is -" + delete_confirm_house_acc);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("delete_confirm_lable"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (delete_confirm_house_acc.equals(getPropertyValue("delete_confirm_lable"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("houseaccount.png");
			extentTest.addScreenCaptureFromPath("houseaccount.png");
		}
	}
}
