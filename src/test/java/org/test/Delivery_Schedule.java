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

public class Delivery_Schedule extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Delivery Schedule Module.html");
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
		LoginPage loginInPage = PageFactory.initElements(driver, LoginPage.class);
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
		String editContact = module.modulePage("CreatePage");
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

	@Test(priority = 5)
	private void selectHoursMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select Hours field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Select Hours");
		String errorContact = contactMandatory.errorField("Select Hours");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryHoursField"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryHoursField"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHoursField.png");
			extentTest.addScreenCaptureFromPath("MandatoryHoursField.png");
		}
	}

	@Test(priority = 6)
	private void timeSlotFromTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Time Slot[From Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Add Time Slot Fields");
		String errorContact = contactMandatory.errorField("From Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryFromTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryFromTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryFromTime.png");
			extentTest.addScreenCaptureFromPath("MandatoryFromTime.png");
		}
	}

	@Test(priority = 7)
	private void timeSlotToTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Time Slot[To Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryToTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryToTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryToTime.png");
			extentTest.addScreenCaptureFromPath("MandatoryToTime.png");
		}
	}

	@Test(priority = 8)
	private void timeSlotCutoffTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Time Slot[Cutoff Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("Cutoff Time");
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

	@Test(priority = 9)
	private void timeSlotDeliveryValueMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Time Slot[Delivery Value] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("Delivery Value");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryDeliveryValue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryDeliveryValue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryDeliveryValue.png");
			extentTest.addScreenCaptureFromPath("MandatoryDeliveryValue.png");
		}
	}

	@Test(priority = 10)
	private void toTimeExtendFromTime() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify error message is displayed, when to time is not greater than the From time");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("To Time Slot");
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ErrorBeforeToTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("ErrorBeforeToTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ErrorBeforeToTime.png");
			extentTest.addScreenCaptureFromPath("ErrorBeforeToTime.png");
		}
	}

	@Test(priority = 11)
	private void cutOffTimeLessThanFromTime()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify an error message is displayed, when the cutoff time should be more than the From time");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Cutoff Time");
		String errorContact = contactMandatory.errorField("Cutoff Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ErrorAfterCufOffTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("ErrorAfterCufOffTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ErrorAfterCufOffTime.png");
			extentTest.addScreenCaptureFromPath("ErrorAfterCufOffTime.png");
		}
	}

	@Test(priority = 12)
	private void deliveryValueZeroValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify an error message is displayed, when the delivery value should not be accepted as zero.");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Delivery Value 0");
		String errorContact = contactMandatory.errorField("Delivery Value");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("InvalidDeliveryValue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("InvalidDeliveryValue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("InvalidDeliveryValue.png");
			extentTest.addScreenCaptureFromPath("InvalidDeliveryValue.png");
		}
		contactMandatory.clearField("Delivery Value");
	}

	@Test(priority = 13)
	private void deliveryValueCharacter() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify an error message is displayed, when the delivery value should not be accepted alphabetic & special characters.");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Delivery Value 0 Character");
		String errorContact = contactMandatory.errorField("Delivery Value");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CharacterDeliveryValue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("CharacterDeliveryValue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CharacterDeliveryValue.png");
			extentTest.addScreenCaptureFromPath("CharacterDeliveryValue.png");
		}
		contactMandatory.clearField("Delivery Value");
	}

	@Test(priority = 14)
	private void timeSlotCreate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a new Time Slot is created successfully through [Delivery Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.validRecords("Time Slot Create");
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

	@Test(priority = 15)
	private void customerFromTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[From Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Add Custome Slot");
		String errorContact = contactMandatory.errorField("From Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCustomeFromTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCustomeFromTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryCustomeFromTime.png");
			extentTest.addScreenCaptureFromPath("MandatoryCustomeFromTime.png");
		}
	}

	@Test(priority = 16)
	private void customerToTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[To Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCustomeToTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCustomeToTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryCustomeToTime.png");
			extentTest.addScreenCaptureFromPath("MandatoryCustomeToTime.png");
		}
	}

	@Test(priority = 17)
	private void minDeliveryWindowMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[Add Minimum Delivery Window (Hours)] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("Minimum Delivery");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MinimumDeliveryWindowMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MinimumDeliveryWindowMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryCustomeToTime.png");
			extentTest.addScreenCaptureFromPath("MandatoryCustomeToTime.png");
		}
	}

	@Test(priority = 18)
	private void customeOrderValueMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[Order Value] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Delivery Charges Form");
		String errorContact = contactMandatory.errorField("Order Value");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryOrderValue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryOrderValue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHoursField.png");
			extentTest.addScreenCaptureFromPath("MandatoryHoursField.png");
		}
	}

	@Test(priority = 19)
	private void customeDeliveryPaymentValueMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[Delivery Payment Value] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("Delivery Value");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryDeliveryPaymentValue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryDeliveryPaymentValue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryDeliveryPaymentValue.png");
			extentTest.addScreenCaptureFromPath("MandatoryDeliveryPaymentValue.png");
		}
	}

	@Test(priority = 20)
	private void customeSelectHoursMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[Select Hours] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Custome Select Hours");
		String errorContact = contactMandatory.errorField("Select Hours");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryHoursField"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryHoursField"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHoursField.png");
			extentTest.addScreenCaptureFromPath("MandatoryHoursField.png");
		}
	}

	@Test(priority = 21)
	private void toLessThanValidation() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the error message is displayed, when the From Time is less than the To Time");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Custome To Time");
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ErrorBeforeToTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("ErrorBeforeToTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ErrorBeforeToTime.png");
			extentTest.addScreenCaptureFromPath("ErrorBeforeToTime.png");
		}
	}

	@Test(priority = 22)
	private void minDeliveryWindow() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify the error message is displayed, when the Minimum Delivery Window (Hours) more than the custome time frame");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Min Hours Error");
		String errorContact = contactMandatory.errorField("Minimum Delivery");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MinimumOrderDeliveryWindow"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MinimumOrderDeliveryWindow"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MinimumOrderDeliveryWindow.png");
			extentTest.addScreenCaptureFromPath("MinimumOrderDeliveryWindow.png");
		}
	}

	@Test(priority = 23)
	private void createCustomeTimeSlotCreate()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a new Custome Time Slot is created successfully through [Delivery Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.validRecords("Custome Time Slot Create");
		String errorContact = contactMandatory.submissionValidation("Time Slot Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("TimeSlotCreateMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("TimeSlotCreateMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CustomeTimeSlotCreateMessage.png");
			extentTest.addScreenCaptureFromPath("CustomeTimeSlotCreateMessage.png");
		}
	}

	@Test(priority = 24)
	private void createDeliverySchedule() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a new Delivery Schedule is created successfully through [Delivery Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.validRecords("Delivery Schedule Create");
		String errorContact = contactMandatory.submissionValidation("Delivery Schedule Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DeliveryScheduleCreateMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DeliveryScheduleCreateMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DeliveryScheduleCreateMessage.png");
			extentTest.addScreenCaptureFromPath("DeliveryScheduleCreateMessage.png");
		}
		contactMandatory.listValidation("List Schedule Name");
	}

	@Test(priority = 25)
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

	@Test(priority = 26)
	private void listFilterValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Verify Filter the Schedule Type:" + listRecord
				+ " in the Filter field, Delivery Schedule [Schedule Type] list retrived successfully");
		Delivery_Schedule_Page filter = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		filter.listValidation("Filter Schedule Type");
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

	@Test(priority = 27)
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

	@Test(priority = 28)
	private void alreadyExistedScheduleName() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify [Schedule Name Already Exists] Error is dispalyed when already existing Schedule Name is provided");
		Delivery_Schedule_Page alreadyExisted = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		alreadyExisted.modulePage("CreatePage");
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

	@Test(priority = 29)
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
		module.clearField("Time Slot");
		Thread.sleep(8000);
		module.valuePresentCondition(Delivery_Schedule_Page.Delivery_Schedule_Name, 10,
				Delivery_Schedule_Page.deliveryScheduleName);
		module.clearAllFields();
	}

	@Test(priority = 30)
	private void editdeliverySchdueleNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Delivery Schedule Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
//		contactMandatory.valuePresentCondition(Delivery_Schedule_Page.Delivery_Schedule_Name, 10,
//				Delivery_Schedule_Page.deliveryScheduleName);
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
				Delivery_Schedule_Page.deliveryScheduleName, 10);
	}

	@Test(priority = 32)
	private void EditcustomerFromTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[From Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Add Custome Slot");
		String errorContact = contactMandatory.errorField("From Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCustomeFromTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCustomeFromTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryCustomeFromTime.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryCustomeFromTime.png");
		}
	}

	@Test(priority = 33)
	private void editcustomerToTimeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[To Time] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCustomeToTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCustomeToTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryCustomeToTime.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryCustomeToTime.png");
		}
	}

	@Test(priority = 34)
	private void editminDeliveryWindowMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[Add Minimum Delivery Window (Hours)] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("Minimum Delivery");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MinimumDeliveryWindowMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MinimumDeliveryWindowMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryCustomeToTime.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryCustomeToTime.png");
		}
	}

	@Test(priority = 35)
	private void editcustomeOrderValueMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[Order Value] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Delivery Charges Form");
		String errorContact = contactMandatory.errorField("Order Value");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryOrderValue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryOrderValue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryHoursField.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryHoursField.png");
		}
	}

	@Test(priority = 36)
	private void editcustomeDeliveryPaymentValueMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[Delivery Payment Value] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		String errorContact = contactMandatory.errorField("Delivery Value");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryDeliveryPaymentValue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryDeliveryPaymentValue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryDeliveryPaymentValue.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryDeliveryPaymentValue.png");
		}
	}

	@Test(priority = 37)
	private void editcustomeSelectHoursMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Custome Time Slot[Select Hours] field is set as Mandatory & Error Message is displayed when it is BLANK");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Custome Select Hours");
		String errorContact = contactMandatory.errorField("Select Hours");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryHoursField"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryHoursField"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryHoursField.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryHoursField.png");
		}
	}

	@Test(priority = 38)
	private void edittoLessThanValidation() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the error message is displayed, when the From Time is less than the To Time");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Custome To Time");
		String errorContact = contactMandatory.errorField("To Time");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ErrorBeforeToTime"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("ErrorBeforeToTime"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditErrorBeforeToTime.png");
			extentTest.addScreenCaptureFromPath("EditErrorBeforeToTime.png");
		}
	}

	@Test(priority = 39)
	private void editminDeliveryWindow() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify the error message is displayed, when the Minimum Delivery Window (Hours) more than the custome time frame");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.mandatoryValidation("Min Hours Error");
		String errorContact = contactMandatory.errorField("Minimum Delivery");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MinimumOrderDeliveryWindow"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MinimumOrderDeliveryWindow"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMinimumOrderDeliveryWindow.png");
			extentTest.addScreenCaptureFromPath("EditMinimumOrderDeliveryWindow.png");
		}
	}

	@Test(priority = 40)
	private void editcreateCustomeTimeSlotCreate()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a new Custome Time Slot is created successfully through [Delivery Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.validRecords("Custome Time Slot Create");
		String errorContact = contactMandatory.submissionValidation("Time Slot Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("TimeSlotCreateMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("TimeSlotCreateMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditCustomeTimeSlotCreateMessage.png");
			extentTest.addScreenCaptureFromPath("EditCustomeTimeSlotCreateMessage.png");
		}
	}

	@Test(priority = 41)
	private void updateDeliverySchedule() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a Exiting Delivery Schedule is updated successfully through [Delivery Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.validRecords("Delivery Schedule Update");
		String errorContact = contactMandatory.submissionValidation("Delivery Schedule Update");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DeliveryScheduleUpdateMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DeliveryScheduleUpdateMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DeliveryScheduleUpdateMessage.png");
			extentTest.addScreenCaptureFromPath("DeliveryScheduleUpdateMessage.png");
		}
		contactMandatory.listValidation("List Schedule Name");
	}

	@Test(priority = 42)
	private void deleteDeliverySchedule() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a Exiting Delivery Schedule is updated successfully through [Delivery Schedule]");
		Delivery_Schedule_Page contactMandatory = PageFactory.initElements(driver, Delivery_Schedule_Page.class);
		contactMandatory.listValidation("Delete Validation");
		String errorContact = contactMandatory.submissionValidation("Delivery Schedule Delete");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DeliveryScheduleDeleteMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DeliveryScheduleDeleteMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DeliveryScheduleUpdateMessage.png");
			extentTest.addScreenCaptureFromPath("DeliveryScheduleUpdateMessage.png");
		}
	}

}
