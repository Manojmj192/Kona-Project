package org.test;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.base.BaseClass;
import org.kona.pageobjectclass.LoginPage;
import org.kona.pageobjectclass.Users_Roles_Module_Page;
import org.kono.browserSetUp.BrowserSetup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class User_Module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("User Module.html");
		extentReports.attachReporter(extentHtmlReporter);
		this.driver = BrowserSetup.startBrowser();

	}

	@AfterClass
	public void exitBrowser() {
		this.driver.quit();
		this.extentReports.flush();
	}

	@Test(priority = -2)
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

	@Test(priority = -1)
	public void Users_Roles_Module_Page() throws InterruptedException, IOException {
		extentTest = extentReports
				.createTest("Verify Users & Roles List Page is opened when clicking on Users & Roles");
		Users_Roles_Module_Page module = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String editContact = module.modulePage("Module");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ListPage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("ListPage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User&Role List.png");
			extentTest.addScreenCaptureFromPath("User&Role List.png");
		}
	}

	@Test(priority = 0)
	public void createUsers() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify Create Users page is opened from User & Roles-> Create Users");
		Users_Roles_Module_Page module = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String editContact = module.modulePage("UserCreatePage");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CreateUsers"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("CreateUsers"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User&Role List.png");
			extentTest.addScreenCaptureFromPath("User&Role List.png");
		}
	}

	@Test(priority = 1)
	private void firstNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify First Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryFirstName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryFirstName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("First Name.png");
			extentTest.addScreenCaptureFromPath("First Name.png");
		}
	}

	@Test(priority = 2)
	private void firstNameInvalid() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify Error Message is displayed, when the First Name is Invalid");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.firstName("Invalid");
		String errorContact = contactMandatory.errorMessage("First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("InvalidFirstName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("InvalidFirstName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Invalid First Name.png");
			extentTest.addScreenCaptureFromPath("Invalid First Name.png");
		}
		contactMandatory.clearField("First Name");
	}

	@Test(priority = 3)
	private void lastNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Last Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryLastName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryLastName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Last Name.png");
			extentTest.addScreenCaptureFromPath("Last Name.png");
		}
	}

	@Test(priority = 4)
	private void lastNameInvalid() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify Error Message is displayed, when the Last Name is Invalid");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.lastName("Invalid");
		String errorContact = contactMandatory.errorMessage("Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("InvalidLastName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("InvalidLastName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Invalid First Name.png");
			extentTest.addScreenCaptureFromPath("Invalid First Name.png");
		}
		contactMandatory.clearField("Last Name");
	}

	@Test(priority = 5)
	private void emailMandatoryValidation() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Email field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Email");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryEmail"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryEmail"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Email Name.png");
			extentTest.addScreenCaptureFromPath("Email Name.png");
		}
	}

	@Test(priority = 6)
	private void emailInvalid() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify Error Message is displayed, when the Email is Invalid");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.emailField("Invalid");
		String errorContact = contactMandatory.errorMessage("Email");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("InvalidEmail"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("InvalidEmail"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Invalid First Name.png");
			extentTest.addScreenCaptureFromPath("Invalid First Name.png");
		}
		contactMandatory.clearField("Email");
	}

	@Test(priority = 7)
	private void mobileNumberMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Mobile Number field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Mobile Number");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryMobileNumber"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryMobileNumber"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Mobile Number.png");
			extentTest.addScreenCaptureFromPath("Mobile Number.png");
		}
	}

	@Test(priority = 8)
	private void selectRoleMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select Role field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Select Role");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatorySelectRole"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatorySelectRole"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Select Role.png");
			extentTest.addScreenCaptureFromPath("Select Role.png");
		}
	}

	@Test(priority = 9)
	private void usercreate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a new User is created successfully through [Users & Roles]");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.validRecords("Create");
		String errorContact = contactMandatory.submissionValidation("Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("UserCreatedMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("UserCreatedMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User Create.png");
			extentTest.addScreenCaptureFromPath("User Create.png");
		}
		listRecord = contactMandatory.listValidation("First Name");
	}

	@Test(priority = 10)
	private void listFirstNameValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the First Name:" + listRecord
				+ " in the Search field, Roles & Users [First Name] list retrived successfully");
		Users_Roles_Module_Page filter = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		filter.clearField("Search");
		listRecord = filter.listValidation("Last Name");
	}

	@Test(priority = 11)
	private void listLastNameValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Last Name:" + listRecord
				+ " in the Search field, Roles & Users [Last Name] list retrived successfully");
		Users_Roles_Module_Page filter = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Last Name.png");
			extentTest.addScreenCaptureFromPath("List Last Name.png");
		}
		filter.clearField("Search");
		listRecord = filter.listValidation("Email");
	}

	@Test(priority = 12)
	private void listEmailValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Email:" + listRecord
				+ " in the Search field, Roles & Users [Email] list retrived successfully");
		Users_Roles_Module_Page filter = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Email");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Email.png");
			extentTest.addScreenCaptureFromPath("List Email.png");
		}
		filter.clearField("Search");
		listRecord = filter.listValidation("Mobile Number");
	}

	@Test(priority = 13)
	private void listPhoneNumberValidation() throws IOException {
		extentTest = extentReports.createTest("Enter the Phone Number:" + listRecord
				+ " in the Search field, Roles & Users [Phone Number] list retrived successfully");
		Users_Roles_Module_Page filter = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Mobile Number");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Phone Number.png");
			extentTest.addScreenCaptureFromPath("List Phone Number.png");
			filter.listValidation("Reset");
		}
		listRecord = filter.listValidation("Role");
	}

	@Test(priority = 14)
	private void listRoleValidation() throws IOException {
		extentTest = extentReports.createTest("Enter the Role:" + listRecord
				+ " in the Search field, Roles & Users [Role] list retrived successfully");
		Users_Roles_Module_Page filter = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		filter.listValidation("Filter Role");
		String listValidation = filter.listValidation("Role");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Role.png");
			extentTest.addScreenCaptureFromPath("List Role.png");
		}
		listRecord = filter.listValidation("Hub");
	}

	@Test(priority = 15)
	private void listHubValidation() throws IOException {
		extentTest = extentReports.createTest(
				"Enter the Hub:" + listRecord + " in the Search field, Roles & Users [Hub] list retrived successfully");
		Users_Roles_Module_Page filter = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		filter.listValidation("Filter Hub");
		String listValidation = filter.listValidation("Hub");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Hub.png");
			extentTest.addScreenCaptureFromPath("List Hub.png");
		}
		listRecord = filter.listValidation("Status");
	}

	@Test(priority = 16)
	private void listStatusValidation() throws IOException {
		extentTest = extentReports.createTest(
				"Enter the Hub:" + listRecord + " in the Search field, Roles & Users [Hub] list retrived successfully");
		Users_Roles_Module_Page filter = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		filter.listValidation("Filter Status");
		String listValidation = filter.listValidation("Status");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Status.png");
			extentTest.addScreenCaptureFromPath("List Status.png");
		}
		listRecord = filter.listValidation("List Invalid");
	}

	@Test(priority = 17)
	private void invalidValidation() throws IOException {
		extentTest = extentReports.createTest("Enter the Invalid data in the Search field - No Records is dispayed");
		Users_Roles_Module_Page filter = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Invalid");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("NoRecords"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(getPropertyValue("NoRecords"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Status.png");
			extentTest.addScreenCaptureFromPath("List Status.png");
		}
		filter.listValidation("Reset");
	}

	@Test(priority = 18)
	private void alreadyExistedMail() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify [Email Already Exists] Error is dispalyed when already existing mail ID is provided");
		Users_Roles_Module_Page alreadyExisted = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String responseMessageCreateContact = alreadyExisted.emailField("Unique Validation");
		extentTest.log(Status.INFO, "Actual Result is -" + responseMessageCreateContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("AlreadyExistedEmail"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (responseMessageCreateContact.equals(getPropertyValue("AlreadyExistedEmail"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Already Exist Email.png");
			extentTest.addScreenCaptureFromPath("Already Exist Email.png");
		}
	}

	@Test(priority = 19)
	public void editUsers() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest("Verify Edit Users page is opened from User & Roles-> Edit Users");
		Users_Roles_Module_Page module = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String editContact = module.modulePage("User Edit Page");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getPropertyValue("EditUsers") + "(" + Users_Roles_Module_Page.firstName + ")");
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("EditUsers") + "(" + Users_Roles_Module_Page.firstName + ")")) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User Edit Label.png");
			extentTest.addScreenCaptureFromPath("User Edit Label.png");
		}
	}

	@Test(priority = 20)
	public void firstNamePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the First Name:" + Users_Roles_Module_Page.firstName
				+ " is prepopulated in the user edit form page");
		Users_Roles_Module_Page edit = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.firstName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Users_Roles_Module_Page.firstName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("Edit Prepopulate First Name.png");
			FileHandler.copy(screenshotAs, file);
			extentTest.addScreenCaptureFromPath("Edit Prepopulate First Name.png");
		}
	}

	@Test(priority = 21)
	public void lastNamePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify the Last Name:" + Users_Roles_Module_Page.lastName + " is prepopulated in the user edit form page");
		Users_Roles_Module_Page edit = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.lastName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Users_Roles_Module_Page.lastName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("Edit Prepopulate Last Name.png");
			FileHandler.copy(screenshotAs, file);
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Last Name.png");
		}
	}

	@Test(priority = 23)
	public void emailPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify the Email:" + Users_Roles_Module_Page.email + " is prepopulated in the user edit form page");
		Users_Roles_Module_Page edit = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Email");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.email);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Users_Roles_Module_Page.email)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("Edit Prepopulate Email.png");
			FileHandler.copy(screenshotAs, file);
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Email.png");
		}
	}

	@Test(priority = 24)
	public void mobileNumberPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Phone Number:" + Users_Roles_Module_Page.phoneNumber
				+ " is prepopulated in the user edit form page");
		Users_Roles_Module_Page edit = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Mobile Number");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.phoneNumber);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Users_Roles_Module_Page.phoneNumber)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("Edit Prepopulate phoneNumber.png");
			FileHandler.copy(screenshotAs, file);
			extentTest.addScreenCaptureFromPath("Edit Prepopulate phoneNumber.png");
		}
	}

	@Test(priority = 25)
	public void selectRolePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Select Role:" + Users_Roles_Module_Page.selectRole
				+ " is prepopulated in the user edit form page");
		Users_Roles_Module_Page edit = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Select Role");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.selectRole);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Users_Roles_Module_Page.selectRole)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("Edit Prepopulate selectRole.png");
			FileHandler.copy(screenshotAs, file);
			extentTest.addScreenCaptureFromPath("Edit Prepopulate selectRole.png");
		}
	}

	@Test(priority = 26)
	public void jobTittlePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Job Tittle:" + Users_Roles_Module_Page.jobTittle
				+ " is prepopulated in the user edit form page");
		Users_Roles_Module_Page edit = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Job Tittle");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.jobTittle);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Users_Roles_Module_Page.jobTittle)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("Edit Prepopulate jobTittle.png");
			FileHandler.copy(screenshotAs, file);
			extentTest.addScreenCaptureFromPath("Edit Prepopulate jobTittle.png");
		}
	}

	@Test(priority = 28)
	public void selectHubPrepopulate() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest("Verify the Select Hub:" + Users_Roles_Module_Page.selectHub
				+ " is prepopulated in the user edit form page");
		Users_Roles_Module_Page edit = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Select Hub");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.selectHub);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Users_Roles_Module_Page.selectHub)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("Edit Prepopulate selectHub.png");
			FileHandler.copy(screenshotAs, file);
			extentTest.addScreenCaptureFromPath("Edit Prepopulate selectHub.png");
		}
		edit.clearAllFields();
	}

	@Test(priority = 29)
	private void editfirstNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify First Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryFirstName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryFirstName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit First Name.png");
			extentTest.addScreenCaptureFromPath("Edit First Name.png");
		}
		contactMandatory.clearAllFields();
	}

	@Test(priority = 30)
	private void editfirstNameInvalid() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify Error Message is displayed, when the First Name is Invalid");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.firstName("Invalid");
		String errorContact = contactMandatory.errorMessage("First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("InvalidFirstName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("InvalidFirstName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Invalid First Name.png");
			extentTest.addScreenCaptureFromPath("Invalid First Name.png");
		}
		contactMandatory.clearAllFields();
	}

	@Test(priority = 31)
	private void editlastNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Last Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryLastName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryLastName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Last Name.png");
			extentTest.addScreenCaptureFromPath("Edit Last Name.png");
		}
	}

	@Test(priority = 32)
	private void editlastNameInvalid() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify Error Message is displayed, when the Last Name is Invalid");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.lastName("Invalid");
		String errorContact = contactMandatory.errorMessage("Last Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("InvalidLastName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("InvalidLastName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Invalid First Name.png");
			extentTest.addScreenCaptureFromPath("Invalid First Name.png");
		}
		contactMandatory.clearAllFields();
	}

	@Test(priority = 33)
	private void editemailMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Email field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Email");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryEmail"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryEmail"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Email Name.png");
			extentTest.addScreenCaptureFromPath("Edit Email Name.png");
		}
	}

	@Test(priority = 34)
	private void editemailInvalid() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify Error Message is displayed, when the Email is Invalid");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.emailField("Invalid");
		String errorContact = contactMandatory.errorMessage("Email");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("InvalidEmail"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("InvalidEmail"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Invalid First Name.png");
			extentTest.addScreenCaptureFromPath("Invalid First Name.png");
		}
		contactMandatory.clearAllFields();
	}

	@Test(priority = 35)
	private void editmobileNumberMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Mobile Number field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Mobile Number");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryMobileNumber"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryMobileNumber"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Mobile Number.png");
			extentTest.addScreenCaptureFromPath("Edit Mobile Number.png");
		}
	}

	@Test(priority = 36)
	private void useredit() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a User edit is updated successfully through [Users & Roles]");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.validRecords("Users");
		String errorContact = contactMandatory.submissionValidation("Edit");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("UserUpdatedMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("UserUpdatedMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User Edit.png");
			extentTest.addScreenCaptureFromPath("User Edit.png");
		}
	}

	@Test(priority = 37)
	private void userdelete() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a User deleted successfully through [Users & Roles]");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.listValidation("Delete");
		String errorContact = contactMandatory.submissionValidation("Delete");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("UserDeletedMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("UserDeletedMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User Delete.png");
			extentTest.addScreenCaptureFromPath("User delete.png");
		}
	}
}
