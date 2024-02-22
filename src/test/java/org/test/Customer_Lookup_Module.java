package org.test;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.kona.pageobjectclass.Customer_Lookup_Page;
import org.kona.pageobjectclass.Hub_Module_Page;
import org.kona.pageobjectclass.LoginPage;
import org.kono.browserSetUp.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Customer_Lookup_Module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Customer Lookup.html");
		extentReports.attachReporter(extentHtmlReporter);
		this.driver = BrowserSetup.startBrowser();

	}

	@AfterClass
	public void exitBrowser() {
		this.driver.quit();
		this.extentReports.flush();
	}

	@Test(priority = 0)
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

	@Test(priority = 1)
	public void Customer_Lookup_Pages() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify Hub Management List Page is opened when clicking on Hub");
		Customer_Lookup_Page module = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String editContact = module.modulePage("Module");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ListCustomerLookup"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("ListCustomerLookup"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListCustomerLookup.png");
			extentTest.addScreenCaptureFromPath("ListCustomerLookup.png");
		}
		module.filterValidation("Get Value");
	}

	@Test(priority = 2)
	private void firstNameCustomerLookup() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify the First Name:" + Customer_Lookup_Page.FirstName
				+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		contactMandatory.filterValidation("Customer Filter Lookup");
		String errorContact = contactMandatory.filterValidation("First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + Customer_Lookup_Page.FirstName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(Customer_Lookup_Page.FirstName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListFirstName.png");
			extentTest.addScreenCaptureFromPath("ListFirstName.png");
		}
	}

	@Test(priority = 3)
	private void emailCustomerLookup() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify the Email:" + Customer_Lookup_Page.Email + " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Email");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + Customer_Lookup_Page.Email);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(Customer_Lookup_Page.Email)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListEmail.png");
			extentTest.addScreenCaptureFromPath("ListEmail.png");
		}
	}

	@Test(priority = 4)
	private void phoneNumberCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify the Phone Number:" + Customer_Lookup_Page.PhoneNumber
				+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Phone Number");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + Customer_Lookup_Page.PhoneNumber);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(Customer_Lookup_Page.PhoneNumber)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 5)
	private void recipientFirstNameCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify the Recipient First Name:" + getUpdatedPropertyFile("Customer LookUp", "RecipientFirstName")
						+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Recipient First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "RecipientFirstName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "RecipientFirstName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 6)
	private void recipientLastNameCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify the Recipient Last Name:" + getUpdatedPropertyFile("Customer LookUp", "RecipientLastName")
						+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Recipient Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "RecipientLastName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "RecipientLastName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 7)
	private void recipientPhoneNumberCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify the Recipient Phone Number:" + getUpdatedPropertyFile("Customer LookUp", "RecipientPhoneNumber")
						+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Recipient Phone Number");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "RecipientPhoneNumber"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "RecipientPhoneNumber"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 8)
	private void recipientEmailCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the Recipient Email:" + getUpdatedPropertyFile("Customer LookUp", "RecipientEmail")
						+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Recipient Email Address");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "RecipientEmail"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "RecipientEmail"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
		contactMandatory.clickButton(Customer_Lookup_Page.Order_Tab, 10, "JS Click");
	}

	@Test(priority = 9)
	private void OrderStatusCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the Order Status:" + getUpdatedPropertyFile("Customer LookUp", "Status")
						+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Order Status");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "Status"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "Status"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 10)
	private void OrderNumberCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the Order Number:" + getUpdatedPropertyFile("Customer LookUp", "OrderNumber")
						+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Order Number");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "OrderNumber"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "OrderNumber"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 11)
	private void OrderRecipientNameCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify the Order Recipient Name:" + getUpdatedPropertyFile("Customer LookUp", "RecipientFirstName")
						+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Order Recipient Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "RecipientFirstName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "RecipientFirstName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 12)
	private void orderrecipientEmailCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify the Order Recipient Email:" + getUpdatedPropertyFile("Customer LookUp", "RecipientEmail")
						+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Order Recipient Email");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "RecipientEmail"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "RecipientEmail"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 12)
	private void orderrecipientPickupDateCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify the Order Recipient Pickup Date:"
				+ getUpdatedPropertyFile("Customer LookUp", "DeliveryPickupDate")
				+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Order Recipient Pickup Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "DeliveryPickupDate"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "DeliveryPickupDate"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 13)
	private void orderrecipientPickupTimeCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify the Order Recipient Pickup Time:"
				+ getUpdatedPropertyFile("Customer LookUp", "DeliveryPickupTime")
				+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Order Recipient Pickup Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "DeliveryPickupTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "DeliveryPickupTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 14)
	private void orderrecipientLeadSourceCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the Order Lead Source:" + getUpdatedPropertyFile("Customer LookUp", "LeadSource")
						+ " is displayed in the Customer Lookup List page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.filterValidation("Order Lead Source");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getUpdatedPropertyFile("Customer LookUp", "LeadSource"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Customer LookUp", "LeadSource"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 15)
	private void editPageCustomerLookup() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the user land on the Edit Customer Details page in the Customer Lookup page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.modulePage("Edit");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EditCustomerDetails"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("EditCustomerDetails"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
	}

	@Test(priority = 16)
	private void editFirstNamePrepopulateCustomerLookup()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the user land on the Edit Customer Details page in the Customer Lookup page");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.modulePage("Edit");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EditCustomerDetails"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("EditCustomerDetails"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ListPhoneNumber.png");
		}
		contactMandatory.customerNameSplit();
		contactMandatory.valuePresentCondition(Customer_Lookup_Page.Sender_First_Name, 10,
				Customer_Lookup_Page.FirstName);
	}

	@Test(priority = 17)
	public void senderFirstNamePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Sender First Name:" + Customer_Lookup_Page.FirstName
				+ " is prepopulated in the Customer Lookup edit form page");
		Thread.sleep(2500);
		Customer_Lookup_Page edit = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String assertionMessage = edit.editPrepopulate("Sender First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Customer_Lookup_Page.FirstName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Customer_Lookup_Page.FirstName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Name.png");
		}
	}

	@Test(priority = 18)
	public void senderLastNamePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Sender Last Name:" + Customer_Lookup_Page.LastName
				+ " is prepopulated in the Customer Lookup edit form page");
		Customer_Lookup_Page edit = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String assertionMessage = edit.editPrepopulate("Sender Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Customer_Lookup_Page.LastName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Customer_Lookup_Page.LastName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Name.png");
		}
	}

	@Test(priority = 19)
	public void senderEmailPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Sender Email:" + Customer_Lookup_Page.Email
				+ " is prepopulated in the Customer Lookup edit form page");
		Customer_Lookup_Page edit = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String assertionMessage = edit.editPrepopulate("Sender Email");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Customer_Lookup_Page.Email);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Customer_Lookup_Page.Email)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Name.png");
		}
		edit.clearAllFields();
	}

	@Test(priority = 21)
	private void senderFirstNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Sender First Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		contactMandatory.clickButton(Customer_Lookup_Page.Submit_Button, 10, "JS Click");
		String errorContact = contactMandatory.errorField("Sender First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("first_name_required_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("first_name_required_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubName.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubName.png");
		}
	}

	@Test(priority = 22)
	private void senderLastNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Sender Last Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.errorField("Sender Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("last_name_required_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("last_name_required_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubName.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubName.png");
		}
	}

	@Test(priority = 23)
	private void senderEmailMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Sender Email Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		String errorContact = contactMandatory.errorField("Sender Email");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("email_add_required_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("email_add_required_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubName.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubName.png");
		}
	}

	@Test(priority = 24)
	private void senderInvalidEmailMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the error message is displayed if the user enter the Invalid mailid is entered");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		contactMandatory.emailField("Invalid");
		String errorContact = contactMandatory.errorField("Sender Email");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("email_add_required_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("email_add_required_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubName.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubName.png");
		}
	}

	@Test(priority = 25)
	private void customerlookupedit() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a exiting Customer Dashboard is updated successfully through [Customer Lookup]");
		Customer_Lookup_Page contactMandatory = PageFactory.initElements(driver, Customer_Lookup_Page.class);
		contactMandatory.validRecords();
		String errorContact = contactMandatory.submissionValidation();
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CustomerDetailsUpdatedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("CustomerDetailsUpdatedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Hub Update.png");
			extentTest.addScreenCaptureFromPath("Hub Update.png");
		}
	}

}
