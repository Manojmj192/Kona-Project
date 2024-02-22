package org.test;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
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

public class Add_Event_Module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Add Event Manager Module.html");
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
	public void Hub_Module_Pages() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify Hub Management List Page is opened when clicking on Hub");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Module");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubListPage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("HubListPage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Hub List.png");
			extentTest.addScreenCaptureFromPath("Hub List.png");
		}
	}

	@Test(priority = 2)
	public void Hub_view_Pages() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify Hub View Page is opened when clicking on Address List");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Hub View");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubView"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("HubView"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("HubView.png");
			extentTest.addScreenCaptureFromPath("HubView.png");
		}
	}

	@Test(priority = 3)
	public void ListEventManager() throws InterruptedException, IOException {
		extentTest = extentReports
				.createTest("Verify Event Manager List Page is opened when clicking on Add Event Manager");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("List Event Management");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ListEventManager"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("ListEventManager"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListEventManager.png");
			extentTest.addScreenCaptureFromPath("ListEventManager.png");
		}
	}

	@Test(priority = 4)
	public void CreateAddEvent() throws InterruptedException, IOException {
		extentTest = extentReports
				.createTest("Verify Create Event Manager Page is opened when clicking on Create Event Manager");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Create Add Event");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CreateAddEvent"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("CreateAddEvent"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CreateAddEvent.png");
			extentTest.addScreenCaptureFromPath("CreateAddEvent.png");
		}
	}

	@Test(priority = 5)
	private void selectEventMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select Event field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		this.clickButton(Hub_Module_Page.Save_Button, 10, "JS Click");
		String errorContact = contactMandatory.errorField("Select Event");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatorySelectEvent"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatorySelectEvent"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatorySelectEvent.png");
			extentTest.addScreenCaptureFromPath("MandatorySelectEvent.png");
		}
	}

	@Test(priority = 6)
	private void selectFromDateMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select From Date field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Select From Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryFromDate"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryFromDate"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryFromDate.png");
			extentTest.addScreenCaptureFromPath("MandatoryFromDate.png");
		}
	}

	@Test(priority = 7)
	private void selectToDateMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select To Date field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Select To Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryToDate"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryToDate"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryToDate.png");
			extentTest.addScreenCaptureFromPath("MandatoryToDate.png");
		}
	}

	@Test(priority = 8)
	private void selectToDateLesserThan() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the error message is displayed, when the From Date is less than the To Date");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.selectToDateEvent("Invalid");
		String errorContact = contactMandatory.errorField("Select To Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EventInvalidToDate"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("EventInvalidToDate"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EventInvalidToDate.png");
			extentTest.addScreenCaptureFromPath("EventInvalidToDate.png");
		}
		contactMandatory.clearAllFields();
	}

	@Test(priority = 9)
	private void addEventCreate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a new Add Event is created successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.validRecords("Create Event");
		String errorContact = contactMandatory.submissionValidation("Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EventCreatedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("EventCreatedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EventCreatedSuccessfully.png");
			extentTest.addScreenCaptureFromPath("EventCreatedSuccessfully.png");
		}
	}

	@Test(priority = 9)
	private void alreadyExists() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify [Florist Choice Day Already Exists] Error is dispalyed when already existing Add Event Date is provided");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.eventUniqueValidation();
		String errorContact = contactMandatory.errorField("Select To Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("FloristAlreadyExists"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("FloristAlreadyExists"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("FloristAlreadyExists.png");
			extentTest.addScreenCaptureFromPath("FloristAlreadyExists.png");
		}
		contactMandatory.clickButton(Hub_Module_Page.Form_Label, 10, "JS Click");
		contactMandatory.listValidation("Event");
	}

	@Test(priority = 10)
	private void listEventName() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a " + Hub_Module_Page.listRecord + "is listed in the Event Manager");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.listValidation("Event");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ListEventName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("ListEventName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListEventName.png");
			extentTest.addScreenCaptureFromPath("ListEventName.png");
		}
		contactMandatory.listValidation("Date");
	}

	@Test(priority = 11)
	private void listEventDate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a Event Date: " + Hub_Module_Page.listRecord + "is listed in the Event Manager");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.listValidation("Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + Hub_Module_Page.startDate + " to " + Hub_Module_Page.endDate);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(Hub_Module_Page.startDate + " to " + Hub_Module_Page.endDate)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListEventDate.png");
			extentTest.addScreenCaptureFromPath("ListEventDate.png");
		}
	}

	@Test(priority = 12)
	public void editEventManager() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports
				.createTest("Verify Edit Event Manager page is opened from Hub Management-> Edit Event Manager");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Edit Add Event");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EditAddEvent"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("EditAddEvent"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditAddEvent.png");
			extentTest.addScreenCaptureFromPath("EditAddEvent.png");
		}
	}

	@Test(priority = 13)
	public void eventNamePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Event Name: " + Hub_Module_Page.selectEvent
				+ " is prepopulated in the Event Manager edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Select Event");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.selectEvent);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.selectEvent)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Event Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Event Name.png");
		}
	}

	@Test(priority = 14)
	public void fromdatePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Select From Date: " + Hub_Module_Page.startDate
				+ " is prepopulated in the Discount or Markup edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Select From Date");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.startDate);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.startDate)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Select From Date Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Select From Date Name.png");
		}
	}

	@Test(priority = 14)
	public void todatePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Select From Date: " + Hub_Module_Page.endDate
				+ " is prepopulated in the Event Manager edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Select To Date");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.endDate);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.endDate)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Select To Date Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Select To Date Name.png");
		}
	}

	@Test(priority = 15)
	public void descriptionPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Description: " + Hub_Module_Page.description
				+ " is prepopulated in the Event Manager edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Description");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.description);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.description)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Description Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Description Name.png");
		}
		edit.clearAllFields();
	}

	@Test(priority = 16)
	private void editselectEventMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select Event field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		this.clickButton(Hub_Module_Page.Save_Button, 10, "JS Click");
		String errorContact = contactMandatory.errorField("Select Event");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatorySelectEvent"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatorySelectEvent"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatorySelectEvent.png");
			extentTest.addScreenCaptureFromPath("MandatorySelectEvent.png");
		}
	}

	@Test(priority = 17)
	private void editselectFromDateMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select From Date field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Select From Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryFromDate"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryFromDate"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryFromDate.png");
			extentTest.addScreenCaptureFromPath("MandatoryFromDate.png");
		}
	}

	@Test(priority = 18)
	private void editselectToDateMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select To Date field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Select To Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryToDate"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryToDate"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryToDate.png");
			extentTest.addScreenCaptureFromPath("MandatoryToDate.png");
		}
	}

	@Test(priority = 19)
	private void editselectToDateLesserThan()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the error message is displayed, when the From Date is less than the To Date");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.selectToDateEvent("Invalid");
		String errorContact = contactMandatory.errorField("Select To Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EventInvalidToDate"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("EventInvalidToDate"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EventInvalidToDate.png");
			extentTest.addScreenCaptureFromPath("EventInvalidToDate.png");
		}
		contactMandatory.clearAllFields();
	}

	@Test(priority = 20)
	private void addEventUpdate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a exiting Event Manager is updated successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.validRecords("Create Event");
		String errorContact = contactMandatory.submissionValidation("Edit");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EventUpdatedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("EventUpdatedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EventUpdatedSuccessfully.png");
			extentTest.addScreenCaptureFromPath("EventUpdatedSuccessfully.png");
		}
		contactMandatory.listValidation("Event");
	}

	@Test(priority = 21)
	private void discountorMarkupdelete() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a exiting Event Manager is deleted successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.submissionValidation("Event Manager Delete");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EventDeletedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("EventDeletedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EventDeletedSuccessfully.png");
			extentTest.addScreenCaptureFromPath("EventDeletedSuccessfully.png");
		}
	}

}
