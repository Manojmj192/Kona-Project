package org.test;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.kona.pageobjectclass.Delivery_Schedule_Page;
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

public class Pickup_Schedule extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Pickup Schedule Module.html");
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

	@Test(priority = 1)
	public void delivery_Schedule_Module_Pages() throws InterruptedException, IOException {
		extentTest = extentReports
				.createTest("Verify Delivery Schedule List Page is opened when clicking on Delivery Schedule");
		Delivery_Schedule_Page module = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String editContact = module.modulePage("Module");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DeliveryScheduleListPage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("DeliveryScheduleListPage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DeliveryScheduleListPage.png");
			extentTest.addScreenCaptureFromPath("DeliveryScheduleListPage.png");
		}
	}

	@Test(priority = 2)
	public void DeliveryScheduleCreatePage() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify Create Delivery Schedule page is opened from Delivery Schedule-> Create Delivery Schedule");
		Delivery_Schedule_Page module = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String editContact = module.modulePage("Pick Up Page");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DeliveryScheduleCreatePage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("DeliveryScheduleCreatePage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DeliveryScheduleCreatePage.png");
			extentTest.addScreenCaptureFromPath("DeliveryScheduleCreatePage.png");
		}
	}

	@Test(priority = 3)
	private void deliverySchdueleNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Delivery Schduele Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("");
		String errorContact = contactMandatory.errorField("Delivery Schedule");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryDeliveryScheduleField"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryDeliveryScheduleField"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryDeliveryScheduleField.png");
			extentTest.addScreenCaptureFromPath("MandatoryDeliveryScheduleField.png");
		}
	}

	@Test(priority = 4)
	private void timeSlotMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Delivery Schduele Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Time Slot");
		String errorContact = contactMandatory.errorField("Time Slot");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryTimeSlotField"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryTimeSlotField"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryDeliveryScheduleField.png");
			extentTest.addScreenCaptureFromPath("MandatoryDeliveryScheduleField.png");
		}
	}

	@Test(priority = 6)
	private void timeSlotFromTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Time Slot[ReadBy Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Add Time Slot Fields");
		String errorContact = contactMandatory.errorField("From Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryReadByTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryReadByTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryReadByTime.png");
			extentTest.addScreenCaptureFromPath("MandatoryReadByTime.png");
		}
	}

	@Test(priority = 7)
	private void timeSlotToTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Time Slot[Cutoff Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCutoffTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCutoffTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryCutoffTime.png");
			extentTest.addScreenCaptureFromPath("MandatoryCutoffTime.png");
		}
	}

	@Test(priority = 8)
	private void toTimeExtendFromTime() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify error message is displayed, when cutoff time is not greater than the ReadBy Time");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.inputText(Delivery_Schedule_Page.From_Time, randomCharacters("1 Hour Timing"), 10);
		contactMandatory.mandatoryValidation("Cutoff Time");
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CutoffTimeMoreThan"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("CutoffTimeMoreThan"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CutoffTimeMoreThan.png");
			extentTest.addScreenCaptureFromPath("CutoffTimeMoreThan.png");
		}
	}

	@Test(priority = 9)
	private void timeSlotCreate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a new Time Slot is created successfully through [Pickup Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.validRecords("Pickup Time Slot");
		String errorContact = contactMandatory.submissionValidation("Time Slot Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("TimeSlotCreateMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("TimeSlotCreateMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("TimeSlotCreateMessage.png");
			extentTest.addScreenCaptureFromPath("TimeSlotCreateMessage.png");
		}
	}

	@Test(priority = 10)
	private void createDeliverySchedule() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a new Pickup Schedule is created successfully through [Pickup Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.validRecords("Pickup Schedule Create");
		String errorContact = contactMandatory.submissionValidation("Delivery Schedule Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("PickupScheduleCreateMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("PickupScheduleCreateMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("PickupScheduleCreateMessage.png");
			extentTest.addScreenCaptureFromPath("PickupScheduleCreateMessage.png");
		}
		contactMandatory.listValidation("List Schedule Name");
	}

	@Test(priority = 11)
	private void listStoreNameValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Schedule Name:" + Delivery_Schedule_Page.deliveryScheduleName
				+ " in the Search field, Delivery Schedule [Schedule Name] list retrived successfully");
		Delivery_Schedule_Page filter = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("List Schedule Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Delivery_Schedule_Page.deliveryScheduleName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Delivery_Schedule_Page.deliveryScheduleName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Schedule Name.png");
			extentTest.addScreenCaptureFromPath("List Schedule Name.png");
		}
		filter.clearField("Search");
		listRecord = filter.listValidation("List Schedule Type");
	}

	@Test(priority = 12)
	private void listFilterValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Verify Filter the Schedule Type:" + listRecord
				+ " in the Filter field, Delivery Schedule [Schedule Type] list retrived successfully");
		Delivery_Schedule_Page filter = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		filter.listValidation("Filter Pickup Type");
		String listValidation = filter.listValidation("List Schedule Type");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Schedule Name.png");
			extentTest.addScreenCaptureFromPath("List Schedule Name.png");
		}
		filter.clearField("Search");
		filter.listValidation("Invalid Record");
	}

	@Test(priority = 13)
	private void invalidValidation() throws IOException {
		extentTest = extentReports.createTest("Enter the Invalid data in the Search field - No Records is dispayed");
		Delivery_Schedule_Page filter = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("Invalid");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("NoRecordsFound"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(getPropertyValue("NoRecordsFound"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Invalid.png");
			extentTest.addScreenCaptureFromPath("List Invalid.png");
		}
		filter.listValidation("Reset");
	}

	@Test(priority = 14)
	private void alreadyExistedScheduleName() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify [Schedule Name Already Exists] Error is dispalyed when already existing Schedule Name is provided");
		Delivery_Schedule_Page alreadyExisted = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		alreadyExisted.modulePage("Pick Up Page");
		alreadyExisted.mandatoryValidation("Schedule Name Unique Validation");
		String responseMessageCreateContact = alreadyExisted.errorField("Delivery Schedule");
		extentTest.log(Status.INFO, "Actual Result is -" + responseMessageCreateContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("AlreadyExistsDeliverySchedule"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (responseMessageCreateContact.equals(getPropertyValue("AlreadyExistsDeliverySchedule"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("AlreadyExistsDeliverySchedule.png");
			extentTest.addScreenCaptureFromPath("AlreadyExistsDeliverySchedule.png");
		}
		alreadyExisted.clickButton(Delivery_Schedule_Page.Form_Label, 10, "JS Click");
	}

	@Test(priority = 15)
	public void editDeliverySchedule() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports
				.createTest("Verify Edit Delivery Schedule page is opened from Store Management-> Edit Store");
		Delivery_Schedule_Page module = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String editContact = module.modulePage("EditPage");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DeliveryScheduleUpdatePage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("DeliveryScheduleUpdatePage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Delivery Schedule Label.png");
			extentTest.addScreenCaptureFromPath("Edit Delivery Schedule Label.png");
		}
		module.clearAllFields();
	}

	@Test(priority = 16)
	private void editdeliverySchdueleNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Delivery Schedule Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("");
		String errorContact = contactMandatory.errorField("Delivery Schedule");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryDeliveryScheduleField"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryDeliveryScheduleField"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryDeliveryScheduleField.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryDeliveryScheduleField.png");
		}
		contactMandatory.inputText(Delivery_Schedule_Page.Delivery_Schedule_Name,
				randomCharacters("Dummy Delivery Schedule Name"), 10);
	}

	@Test(priority = 18)
	private void edittimeSlotFromTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Time Slot[ReadBy Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Add Time Slot Fields");
		String errorContact = contactMandatory.errorField("From Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryReadByTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryReadByTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryReadByTime.png");
			extentTest.addScreenCaptureFromPath("MandatoryReadByTime.png");
		}
	}

	@Test(priority = 19)
	private void edittimeSlotToTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Time Slot[Cutoff Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCutoffTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCutoffTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryCutoffTime.png");
			extentTest.addScreenCaptureFromPath("MandatoryCutoffTime.png");
		}
	}

	@Test(priority = 20)
	private void edittoTimeExtendFromTime() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify error message is displayed, when cutoff time is not greater than the ReadBy Time");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.inputText(Delivery_Schedule_Page.From_Time, randomCharacters("1 Hour Timing"), 10);
		contactMandatory.mandatoryValidation("Cutoff Time");
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CutoffTimeMoreThan"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("CutoffTimeMoreThan"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CutoffTimeMoreThan.png");
			extentTest.addScreenCaptureFromPath("CutoffTimeMoreThan.png");
		}
		contactMandatory.clickButton(Delivery_Schedule_Page.Form_Label, 10, "JS Click");
	}

	@Test(priority = 22)
	private void updateDeliverySchedule() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a Exiting Pickup Schedule is updated successfully through [Pickup Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.validRecords("Pickup Schedule Create");
		String errorContact = contactMandatory.submissionValidation("Delivery Schedule Update");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("PickupScheduleUpdateMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("PickupScheduleUpdateMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("PickupScheduleUpdateMessage.png");
			extentTest.addScreenCaptureFromPath("PickupScheduleUpdateMessage.png");
		}
		contactMandatory.listValidation("List Schedule Name");
	}

	@Test(priority = 23)
	private void deleteDeliverySchedule() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a Exiting Pickup Schedule is updated successfully through [Pickup Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.listValidation("Delete Validation");
		String errorContact = contactMandatory.submissionValidation("Delivery Schedule Delete");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("PickupScheduleDeleteMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("PickupScheduleDeleteMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("PickupScheduleDeleteMessage.png");
			extentTest.addScreenCaptureFromPath("PickupScheduleDeleteMessage.png");
		}
	}

}
