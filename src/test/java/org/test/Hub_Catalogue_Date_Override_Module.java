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

public class Hub_Catalogue_Date_Override_Module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Catalogue Date Override Module.html");
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
	public void Catlogue_List_Page() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify Hub Management > Catalogue Date Override Management List Page is opened when clicking on Hub");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Catlogue Date Override List Page");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CatalogueDateOverrideManagement"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("CatalogueDateOverrideManagement"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CatalogueDateOverrideManagement.png");
			extentTest.addScreenCaptureFromPath("CatalogueDateOverrideManagement.png");
		}
	}

	@Test(priority = 3)
	public void catloge_override_create_Page() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify Create Catalogue Date Override page is opened from Hub Management-> Create Catalogue Date Override");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Create Catlogue Date Override List Page");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CreateCatalogueDateOverride"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("CreateCatalogueDateOverride"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CreateCatalogueDateOverride.png");
			extentTest.addScreenCaptureFromPath("CreateCatalogueDateOverride.png");
		}
	}

	@Test(priority = 5)
	private void ErrorSelectDateFieldMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select Date Range field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Select Date Range");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ErrorSelectDateField"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("ErrorSelectDateField"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ErrorSelectDateField.png");
			extentTest.addScreenCaptureFromPath("ErrorSelectDateField.png");
		}
	}

	@Test(priority = 4)
	private void ErrorHubMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Hub field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Catlogue Hub");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("hub_err"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("hub_err"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("hub_err.png");
			extentTest.addScreenCaptureFromPath("hub_err.png");
		}
	}

	@Test(priority = 6)
	private void ErrorSelectTypeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select Type field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Catlogue Select Type");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ErrorHubSelectTypeField"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("ErrorHubSelectTypeField"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ErrorHubSelectTypeField.png");
			extentTest.addScreenCaptureFromPath("ErrorHubSelectTypeField.png");
		}
	}

	@Test(priority = 7)
	private void ErrorSelectCatelogueMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select Catalogue field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Select Catlogue");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ErrorSelectCatlogue"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("ErrorSelectCatlogue"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ErrorSelectCatlogue.png");
			extentTest.addScreenCaptureFromPath("ErrorSelectCatlogue.png");
		}
	}

	@Test(priority = 8)
	private void ErrorProductMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Product field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Catlogue Product");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("product_mandatory"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("product_mandatory"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("product_mandatory.png");
			extentTest.addScreenCaptureFromPath("product_mandatory.png");
		}
	}

	@Test(priority = 9)
	private void hubCatlogueCreate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a new Catalogue Date Override is created successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.validRecords("Catlogue Create");
		String errorContact = contactMandatory.submissionValidation("Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getPropertyValue("CatalogueDateOverrideAddedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("CatalogueDateOverrideAddedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CatalogueDateOverrideAddedSuccessfully.png");
			extentTest.addScreenCaptureFromPath("CatalogueDateOverrideAddedSuccessfully.png");
		}
		contactMandatory.listValidation("Start Date Records");
	}

	@Test(priority = 10)
	private void listFromDate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a From Date:" + Hub_Module_Page.listRecord
				+ "is listed in the Catalogue Date Override Management");
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
		extentTest = extentReports.createTest("Verify a To Date:" + Hub_Module_Page.listRecord
				+ "is listed in the Catalogue Date Override Management");
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
	private void listCatalogueName() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a Catalogue Name:" + getUpdatedPropertyFile("Catlogue Page", "CatlogueName")
						+ "is listed in the Catalogue Date Override Management");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.listValidation("Catalogue Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getUpdatedPropertyFile("Catlogue Page", "CatlogueName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getUpdatedPropertyFile("Catlogue Page", "CatlogueName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("ListCatelogueName.png");
			extentTest.addScreenCaptureFromPath("ListCatelogueName.png");
		}
	}

	@Test(priority = 13)
	public void editCatalogue() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Edit Catalogue Date Override Management page is opened from Hub Management-> Edit Catalogue Date Override Management");
		Hub_Module_Page module = PageFactory.initElements(driver, Hub_Module_Page.class);
		String editContact = module.modulePage("Edit Catalogue");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EditCatalogueDateOverride"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("EditCatalogueDateOverride"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditCatalogueDateOverride.png");
			extentTest.addScreenCaptureFromPath("EditCatalogueDateOverride.png");
		}
	}

	@Test(priority = 29)
	public void daterangePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Select Date Range:" + Hub_Module_Page.dateRange
				+ " is prepopulated in the Catalogue Date Override edit form page");
		Hub_Module_Page edit = PageFactory.initElements(driver, Hub_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Select Date Range");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Hub_Module_Page.dateRange);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Hub_Module_Page.dateRange)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Select Date Range.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Select Date Range.png");
		}
		edit.clearField("Select Date Range");
	}

	@Test(priority = 30)
	private void EditErrorSelectDateFieldMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Select Date Range field is set as Mandatory & Error Message is displayed when it is BLANK");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.errorField("Select Date Range");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("ErrorSelectDateField"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("ErrorSelectDateField"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditErrorSelectDateField.png");
			extentTest.addScreenCaptureFromPath("EditErrorSelectDateField.png");
		}
	}

	@Test(priority = 31)
	private void hubCatlogueUpdate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify a exiting Catalogue Date Override is updated successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		contactMandatory.validRecords("Catalogue Update");
		String errorContact = contactMandatory.submissionValidation("Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getPropertyValue("CatalogueDateOverrideUpdatedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("CatalogueDateOverrideUpdatedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CatalogueDateOverrideUpdatedSuccessfully.png");
			extentTest.addScreenCaptureFromPath("CatalogueDateOverrideUpdatedSuccessfully.png");
		}
	}

	@Test(priority = 32)
	private void hubCatalogueDelete() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a Catalogue Date Override deleted successfully through [Hub Management]");
		Hub_Module_Page contactMandatory = PageFactory.initElements(driver, Hub_Module_Page.class);
		String errorContact = contactMandatory.submissionValidation("Delete Catalogue");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO,
				"Expected Result is -" + getPropertyValue("CatalogueDateOverrideDeletedSuccessfully"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("CatalogueDateOverrideDeletedSuccessfully"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("CatalogueDateOverrideDeletedSuccessfully.png");
			extentTest.addScreenCaptureFromPath("CatalogueDateOverrideDeletedSuccessfully.png");
		}
	}

}
