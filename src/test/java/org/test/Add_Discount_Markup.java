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

public class Add_Discount_Markup extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Add Discount or Markup Module.html");
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
	public void discount_Markup_Pages() throws InterruptedException, IOException {
		extentTest = extentReports
				.createTest("Verify Discount or Markup List Page is opened when clicking on Add Discount or Markup");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Discount or Markup");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ListDiscountorMarkup"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("ListDiscountorMarkup"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListDiscountorMarkup.png");
			extentTest.addScreenCaptureFromPath("ListDiscountorMarkup.png");
		}
	}

	@Test(priority = 4)
	public void create_discount_Markup_Pages() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify Create Discount or Markup Page is opened when clicking on Create Discount or Markup");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Create Discount or Markup");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CreateDiscountorMarkup"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("CreateDiscountorMarkup"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CreateDiscountorMarkup.png");
			extentTest.addScreenCaptureFromPath("CreateDiscountorMarkup.png");
		}
	}

	@Test(priority = 5)
	private void dateMandatoryValidation() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Date field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		this.clickButton(Hub_Module_Page.Save_Button, 10, "JS Click");
		String errorContact = contactMandatory.errorField("Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountMarkupMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountMarkupMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountMarkupMandatory.png");
			extentTest.addScreenCaptureFromPath("DiscountMarkupMandatory.png");
		}
	}

	@Test(priority = 6)
	private void bulkPriceMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Bulk Price field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Bulk Price");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountMarkupMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountMarkupMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountMarkupMandatory.png");
			extentTest.addScreenCaptureFromPath("DiscountMarkupMandatory.png");
		}
	}

	@Test(priority = 7)
	private void discoutMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Discount field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Discount");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountMarkupMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountMarkupMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountMarkupMandatory.png");
			extentTest.addScreenCaptureFromPath("DiscountMarkupMandatory.png");
		}
	}

	@Test(priority = 8)
	private void invaliddiscoutMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify Error Message is displayed when it is discount field enter zero");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.discountField("Zero Validation");
		String errorContact = contactMandatory.errorField("Discount");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountZeroValidation"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountZeroValidation"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountZeroValidation.png");
			extentTest.addScreenCaptureFromPath("DiscountZeroValidation.png");
		}
		contactMandatory.clearField("Discount");
	}

	@Test(priority = 9)
	private void discountorMarkupCreate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a new Discount or Markup is created successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.validRecords("Create Discount or Markup");
		String errorContact = contactMandatory.submissionValidation("Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountorMarkupSavedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountorMarkupSavedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountorMarkupSavedSuccessfully.png");
			extentTest.addScreenCaptureFromPath("DiscountorMarkupSavedSuccessfully.png");
		}
		contactMandatory.listValidation("Start Date Records");
	}

	@Test(priority = 10)
	private void listFromDate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a From Date:" + Hub_Module_Page.listRecord + "is listed in the Discount or Markup");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.listValidation("Catalogue From Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(Hub_Module_Page.listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListStartDate.png");
			extentTest.addScreenCaptureFromPath("ListStartDate.png");
		}
		contactMandatory.listValidation("End Date Records");
	}

	@Test(priority = 11)
	private void listToDate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a To Date:" + Hub_Module_Page.listRecord + "is listed in the Discount or Markup");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.listValidation("Catalogue To Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.listRecord);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(Hub_Module_Page.listRecord)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListEndDate.png");
			extentTest.addScreenCaptureFromPath("ListEndDate.png");
		}
	}

	@Test(priority = 12)
	private void listDiscount() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a Discount:" + Hub_Module_Page.discount + "is listed in the Discount or Markup");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.listValidation("Discount");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.discount);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(Hub_Module_Page.discount)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListDiscount.png");
			extentTest.addScreenCaptureFromPath("ListDiscount.png");
		}
	}

	@Test(priority = 13)
	public void editdiscountMarkup() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Edit Discount or Markup page is opened from Hub Management-> Edit Discount or Markup");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Edit Catalogue");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EditDiscountorMarkup"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("EditDiscountorMarkup"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditDiscountorMarkup.png");
			extentTest.addScreenCaptureFromPath("EditDiscountorMarkup.png");
		}
	}

	@Test(priority = 14)
	public void datePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Date:" + Hub_Module_Page.dateRange
				+ " is prepopulated in the Discount or Markup edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Date");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.dateRange);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.dateRange)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Date Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Date Name.png");
		}
	}

	@Test(priority = 15)
	public void dicountPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Discount Value:" + Hub_Module_Page.discount
				+ " is prepopulated in the Discount or Markup edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Discount");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.discount);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.discount)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Discount Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Discount Name.png");
		}
		edit.clearAllFields();
	}

	@Test(priority = 16)
	private void editdateMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Date field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		this.clickButton(Hub_Module_Page.Save_Button, 10, "JS Click");
		String errorContact = contactMandatory.errorField("Date");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountMarkupMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountMarkupMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountMarkupMandatory.png");
			extentTest.addScreenCaptureFromPath("DiscountMarkupMandatory.png");
		}
	}

	@Test(priority = 17)
	private void editdiscoutMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Discount field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Discount");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountMarkupMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountMarkupMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountMarkupMandatory.png");
			extentTest.addScreenCaptureFromPath("DiscountMarkupMandatory.png");
		}
	}

	@Test(priority = 18)
	private void editinvaliddiscoutMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify Error Message is displayed when it is discount field enter zero");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.discountField("Zero Validation");
		String errorContact = contactMandatory.errorField("Discount");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountZeroValidation"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountZeroValidation"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountZeroValidation.png");
			extentTest.addScreenCaptureFromPath("DiscountZeroValidation.png");
		}
		contactMandatory.clearField("Discount");
	}

	@Test(priority = 19)
	private void discountorMarkupUpdate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a exiting Discount or Markup is updated successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.validRecords("Create Discount or Markup");
		String errorContact = contactMandatory.submissionValidation("Edit");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountorMarkupUpdatedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountorMarkupUpdatedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountorMarkupUpdatedSuccessfully.png");
			extentTest.addScreenCaptureFromPath("DiscountorMarkupUpdatedSuccessfully.png");
		}
	}

	@Test(priority = 20)
	private void discountorMarkupdelete() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a exiting Discount or Markup is deleted successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.submissionValidation("Delete Discount or Markup");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DiscountDeletedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DiscountDeletedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("DiscountDeletedSuccessfully.png");
			extentTest.addScreenCaptureFromPath("DiscountDeletedSuccessfully.png");
		}
	}

}
