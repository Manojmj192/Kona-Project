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

public class Hub_Module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Hub Module.html");
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
	public void createStore() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify Create Hub page is opened from Hub Management-> Create Hub");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("CreateHubPage");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CreateHubPage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("CreateHubPage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Create Hub.png");
			extentTest.addScreenCaptureFromPath("Create Hub.png");
		}
	}

	@Test(priority = 3)
	private void hubNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Hub Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Hub Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubNameMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("HubNameMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubName.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubName.png");
		}
	}

	@Test(priority = 4)
	private void stateMandatoryValidation() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify State field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Select State");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryState"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryState"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryState.png");
			extentTest.addScreenCaptureFromPath("MandatoryState.png");
		}
	}

	@Test(priority = 5)
	private void CityMandatoryValidation() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify City field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Select City");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCity"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCity"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryCity.png");
			extentTest.addScreenCaptureFromPath("MandatoryCity.png");
		}
	}

	@Test(priority = 6)
	private void AddressMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Address field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Address1");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("AddressMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("AddressMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryAddress.png");
			extentTest.addScreenCaptureFromPath("MandatoryAddress.png");
		}
	}

	@Test(priority = 7)
	private void ZipcodeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Zipcode field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Zipcode");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryZipcode"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryZipcode"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryZipcode.png");
			extentTest.addScreenCaptureFromPath("MandatoryZipcode.png");
		}
	}

	@Test(priority = 8)
	private void hubstateMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Hub State field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("State");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryState"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryState"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubState.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubState.png");
		}
	}

	@Test(priority = 9)
	private void hubCityMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Hub City field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("City");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCity"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCity"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubCity.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubCity.png");
		}
	}

	@Test(priority = 10)
	private void phoneNumberMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Hub City field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("City");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCity"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCity"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubCity.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubCity.png");
		}
	}

	@Test(priority = 11)
	private void deleviryScheduleMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Delivery Schedule field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Delivery Schedule");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("DeliveryScheduleMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("DeliveryScheduleMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryDeliverySchedule.png");
			extentTest.addScreenCaptureFromPath("MandatoryDeliverySchedule.png");
		}
	}

	@Test(priority = 12)
	private void pickupScheduleMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify PickUp Schedule field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Pickup Schedule");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("PickupScdeduleMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("PickupScdeduleMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryPickupSchedule.png");
			extentTest.addScreenCaptureFromPath("MandatoryPickupSchedule.png");
		}
	}

	@Test(priority = 13)
	private void printerNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Printer Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Printer Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("PrinterNameMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("PrinterNameMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryPrinterName.png");
			extentTest.addScreenCaptureFromPath("MandatoryPrinterName.png");
		}
	}

	@Test(priority = 14)
	private void printerIPMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Printer IP field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Printer Id");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("PrinterIdMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("PrinterIdMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryPrinterID.png");
			extentTest.addScreenCaptureFromPath("MandatoryPrinterID.png");
		}
	}

	@Test(priority = 15)
	private void loginIDMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Login ID field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Login Id");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("LoginIDMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("LoginIDMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryLoginID.png");
			extentTest.addScreenCaptureFromPath("MandatoryLoginID.png");
		}
	}

	@Test(priority = 16)
	private void transcationKeyMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Transaction Key field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Transcation Key");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("TransactionKeyMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("TransactionKeyMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("TransactionKeyMandatory.png");
			extentTest.addScreenCaptureFromPath("TransactionKeyMandatory.png");
		}
	}

	@Test(priority = 17)
	private void hubCreate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a new Hub is created successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.validRecords("Create");
		String errorContact = contactMandatory.submissionValidation("Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubCreateMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("HubCreateMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Hub Create.png");
			extentTest.addScreenCaptureFromPath("Hub Create.png");
		}
	}

	@Test(priority = 18)
	private void hubStoreView() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Hub > View All Store page is opened from Hub Management-> View All Store");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.modulePage("View Store");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubStoreView"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("HubStoreView"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("HubStoreView.png");
			extentTest.addScreenCaptureFromPath("HubStoreView.png");
		}
	}

	@Test(priority = 19)
	private void hubStoreView_StoreName() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify the Store Name:"
				+ getUpdatedPropertyFile("Store Page", "StoreName") + " is displayed in the View All Store List page");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.viewAllStore("Store Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getUpdatedPropertyFile("Store Page", "StoreName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Store Page", "StoreName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ViewStoreName.png");
			extentTest.addScreenCaptureFromPath("ViewStoreName.png");
		}
	}

	@Test(priority = 20)
	private void hubStoreView_WebsiteURL() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify the Website URL:"
				+ getUpdatedPropertyFile("Store Page", "WebSiteURL") + " is displayed in the View All Store List page");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.viewAllStore("Website URL");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getUpdatedPropertyFile("Store Page", "WebSiteURL"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Store Page", "WebSiteURL"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ViewWebsiteURL.png");
			extentTest.addScreenCaptureFromPath("ViewWebsiteURL.png");
		}
	}

	@Test(priority = 21)
	private void hubStoreView_PhoneNumber() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify the Phone Number:" + getUpdatedPropertyFile("Store Page", "PhoneNumber")
						+ " is displayed in the View All Store List page");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.viewAllStore("Phone Number");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getUpdatedPropertyFile("Store Page", "PhoneNumber"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Store Page", "PhoneNumber"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ViewPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("ViewPhoneNumber.png");
		}
	}

	@Test(priority = 22)
	private void hubStoreView_Address() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify the Address:" + getUpdatedPropertyFile("Store Page", "Address")
				+ " is displayed in the View All Store List page");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.viewAllStore("Adress");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getUpdatedPropertyFile("Store Page", "Address"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Store Page", "Address"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ViewAddress.png");
			extentTest.addScreenCaptureFromPath("ViewAddress.png");
		}
		contactMandatory.listValidation("Back");
		contactMandatory.listValidation("List Hub Name");
	}

	@Test(priority = 23)
	private void hubChatNumberPage() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Hub > CSR Chat Numbers page is opened from Hub Management-> CSR Chat Numbers");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.modulePage("View Chat Number");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubCRSChatNumber"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("HubCRSChatNumber"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("HubCRSChatNumber.png");
			extentTest.addScreenCaptureFromPath("HubCRSChatNumber.png");
		}
	}

	@Test(priority = 24)
	private void hubChatNumberList() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify the CSR Chat Number:"
				+ getUpdatedPropertyFile("Hub Page", "ChatNumber") + " is displayed in the View All Store List page");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.viewAllStore("CSR Chat Number");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getUpdatedPropertyFile("Hub Page", "ChatNumber"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Hub Page", "ChatNumber"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("HubChatNumber.png");
			extentTest.addScreenCaptureFromPath("HubChatNumber.png");
		}

		contactMandatory.listValidation("Back");
		contactMandatory.listValidation("List Hub Name");
	}

	@Test(priority = 25)
	private void listHubNameValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Hub Name:" + Hub_Module_Page.hubName
				+ " in the Search field, Store Management [Store Name] list retrived successfully");
		Hub_Module_Page filter = PageFactory.initElements(driver, Hub_Module_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("List Hub Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.hubName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Hub_Module_Page.hubName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		filter.listValidation("Search");
		filter.listValidation("Invalid Record");
	}

	@Test(priority = 26)
	private void invalidValidation() throws IOException {
		extentTest = extentReports.createTest("Enter the Invalid data in the Search field - No Records is dispayed");
		Hub_Module_Page filter = PageFactory.initElements(driver, Hub_Module_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("ListInvalid");
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

	@Test(priority = 27)
	private void alreadyExistedHubName() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify [Hub Name Already Exists] Error is dispalyed when already existing Hub Name is provided");
		Hub_Module_Page alreadyExisted = PageFactory.initElements(driver, Hub_Module_Page.class);
		String responseMessageCreateContact = alreadyExisted.hubNameField("Unique Validation");
		extentTest.log(Status.INFO, "Actual Result is -" + responseMessageCreateContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ExistingHubName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (responseMessageCreateContact.equals(getPropertyValue("ExistingHubName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Hub Name Exist Email.png");
			extentTest.addScreenCaptureFromPath("Hub Name Exist Email.png");
		}
	}

	@Test(priority = 28)
	private void alreadyExistedPrinterID() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify [Printer IP Address Already Exists] Error is dispalyed when already existing Printer IP Address is provided");
		Hub_Module_Page alreadyExisted = PageFactory.initElements(driver, Hub_Module_Page.class);
		String responseMessageCreateContact = alreadyExisted.printerIDField("Unique Validation");
		extentTest.log(Status.INFO, "Actual Result is -" + responseMessageCreateContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ExistingPrinterID"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (responseMessageCreateContact.equals(getPropertyValue("ExistingPrinterID"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Printer IP Address Exist Email.png");
			extentTest.addScreenCaptureFromPath("Printer IP Address Exist Email.png");
		}
		this.clickButton(Hub_Module_Page.Form_Label, 10, "JS Click");
		this.visible(Hub_Module_Page.List_Hub_Name, 10);
	}

	@Test(priority = 28)
	public void editHub() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest("Verify Edit Hub page is opened from Hub Management-> Edit Hub");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("EditHubPage");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EditHubPage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("EditHubPage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Hub Label.png");
			extentTest.addScreenCaptureFromPath("Edit Hub Label.png");
		}
	}

	@Test(priority = 29)
	public void hubNamePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify the Hub Name:" + Hub_Module_Page.hubName + " is prepopulated in the store edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Hub Name");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.hubName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.hubName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Name.png");
		}
	}

	@Test(priority = 30)
	public void address1Prepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Hub Address 1:" + Hub_Module_Page.address1
				+ " is prepopulated in the store edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Address1");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.address1);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.address1)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Name.png");
		}
	}

	@Test(priority = 31)
	public void zipcodePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify the Hub Zipcode:" + Hub_Module_Page.zipcode + " is prepopulated in the store edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Zipcode");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.zipcode);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.zipcode)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Zipcode.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Zipcode.png");
		}
	}

	@Test(priority = 32)
	public void phoneNumberPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Hub Phone Number:" + Hub_Module_Page.phoneNumber
				+ " is prepopulated in the store edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Phone Number");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.phoneNumber);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.phoneNumber)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Phone Number.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Phone Number.png");
		}
	}

	@Test(priority = 33)
	public void printerNamePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Hub Printer Name:" + Hub_Module_Page.printerName
				+ " is prepopulated in the store edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Printer Name");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.printerName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.printerName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Printer Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Printer Name.png");
		}
	}

	@Test(priority = 34)
	public void printerIPPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Hub Printer IP Address:" + Hub_Module_Page.printerIP
				+ " is prepopulated in the store edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Printer IP Address");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.printerIP);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.printerIP)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Printer IP Address.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Printer IP Address.png");
		}
	}

	@Test(priority = 35)
	public void loginIdPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Hub Login ID:" + getPropertyValue("LoginID")
				+ " is prepopulated in the store edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Login ID");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("LoginID"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(getPropertyValue("LoginID"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Login ID.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Login ID.png");
		}
	}

	@Test(priority = 36)
	public void transcationPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Hub Transcation Key:" + getPropertyValue("TranscationKey")
				+ " is prepopulated in the store edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Transcation Key");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("TranscationKey"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(getPropertyValue("TranscationKey"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Hub Transcation Key.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Hub Transcation Key.png");
		}
		edit.clearAllFields();
	}

	@Test(priority = 37)
	private void edithubNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Hub Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.clickButton(Hub_Module_Page.Save_Button, 10, "JS Click");
		String errorContact = contactMandatory.errorField("Hub Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubNameMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("HubNameMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubName.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubName.png");
		}
	}

	@Test(priority = 38)
	private void editAddressMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Address field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Address1");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("AddressMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("AddressMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryAddress.png");
			extentTest.addScreenCaptureFromPath("MandatoryAddress.png");
		}
	}

	@Test(priority = 39)
	private void editZipcodeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Zipcode field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Zipcode");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryZipcode"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryZipcode"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryZipcode.png");
			extentTest.addScreenCaptureFromPath("MandatoryZipcode.png");
		}
	}

	@Test(priority = 40)
	private void edithubstateMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Hub State field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("State");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryState"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryState"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubState.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubState.png");
		}
	}

//	@Test(priority = 41)
//	private void edithubCityMandatoryValidation()
//			throws WebDriverException, IOException, InterruptedException, AWTException {
//		extentTest = extentReports
//				.createTest("Verify Hub City field is set as Mandatory & Error Message is displayed when it is BLANK");
//		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
//		String errorContact = contactMandatory.errorField("City");
//		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
//		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCity"));
//		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
//		if (errorContact.equals(getPropertyValue("MandatoryCity"))) {
//			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
//		} else {
//			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
//			ScreenShots("MandatoryHubCity.png");
//			extentTest.addScreenCaptureFromPath("MandatoryHubCity.png");
//		}
//	}

	@Test(priority = 42)
	private void editphoneNumberMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Hub Phone Number field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Phone Number");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("PhoneNumberMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("PhoneNumberMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHubPhoneNumber.png");
			extentTest.addScreenCaptureFromPath("MandatoryHubPhoneNumber.png");
		}
	}

	@Test(priority = 43)
	private void editprinterNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Printer Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Printer Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("PrinterNameMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("PrinterNameMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryPrinterName.png");
			extentTest.addScreenCaptureFromPath("MandatoryPrinterName.png");
		}
	}

	@Test(priority = 44)
	private void editprinterIPMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Printer IP field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Printer Id");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("PrinterIdMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("PrinterIdMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryPrinterID.png");
			extentTest.addScreenCaptureFromPath("MandatoryPrinterID.png");
		}
	}

	@Test(priority = 45)
	private void editloginIDMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Login ID field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Login Id");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("LoginIDMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("LoginIDMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryLoginID.png");
			extentTest.addScreenCaptureFromPath("MandatoryLoginID.png");
		}
	}

	@Test(priority = 46)
	private void edittranscationKeyMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Transaction Key field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Transcation Key");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("TransactionKeyMandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("TransactionKeyMandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("TransactionKeyMandatory.png");
			extentTest.addScreenCaptureFromPath("TransactionKeyMandatory.png");
		}
	}

	@Test(priority = 47)
	private void hubedit() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a exiting Hub is updated successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.validRecords("Edit");
		String errorContact = contactMandatory.submissionValidation("Edit");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubUpdateMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("HubUpdateMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Hub Update.png");
			extentTest.addScreenCaptureFromPath("Hub Update.png");
		}
	}

	@Test(priority = 48)
	private void hubDelete() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a Hub deleted successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.submissionValidation("Delete");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("HubDeleteMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("HubDeleteMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Hub Delete.png");
			extentTest.addScreenCaptureFromPath("Hub Delete.png");
		}
//		contactMandatory.modulePage("CreateHubPage");
//		contactMandatory.validRecords("Create");
//		contactMandatory.submissionValidation("Create");
	}

}
