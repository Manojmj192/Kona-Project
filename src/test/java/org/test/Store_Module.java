package org.test;

import java.awt.AWTException;
import java.io.IOException;
import org.base.BaseClass;
import org.kona.pageobjectclass.LoginPage;
import org.kona.pageobjectclass.Store_Module_Page;
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

public class Store_Module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Store Module.html");
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
	public void Store_Module_Pages() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify Store Role List Page is opened when clicking on Store");
		Store_Module_Page module = PageFactory.initElements(driver, Store_Module_Page.class);
		String editContact = module.modulePage("Module");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("StoreListPage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("StoreListPage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Store List.png");
			extentTest.addScreenCaptureFromPath("Store List.png");
		}
	}

	@Test(priority = 2)
	public void createStore() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify Create Store page is opened from Store-> Create Users");
		Store_Module_Page module = PageFactory.initElements(driver, Store_Module_Page.class);
		String editContact = module.modulePage("CreateStorePage");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CreateStore"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("CreateStore"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Create Store.png");
			extentTest.addScreenCaptureFromPath("Create Store.png");
		}
	}

	@Test(priority = 3)
	private void storeImageMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Store Image field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Store Image");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryStoreImage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryStoreImage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryStoreImage.png");
			extentTest.addScreenCaptureFromPath("MandatoryStoreImage.png");
		}
	}

	@Test(priority = 4)
	private void StoreLogoMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Store Logo field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Store Logo");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryStoreLogo"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryStoreLogo"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryStoreLogo.png");
			extentTest.addScreenCaptureFromPath("MandatoryStoreLogo.png");
		}
	}

	@Test(priority = 5)
	private void BannerImageMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Banner Image field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Banner Image");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryBannerImage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryBannerImage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryBannerImage.png");
			extentTest.addScreenCaptureFromPath("MandatoryBannerImage.png");
		}
	}

	@Test(priority = 6)
	private void PrimaryColorMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Primary Color field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Primary Color");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryPrimaryColor"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryPrimaryColor"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryPrimaryColor.png");
			extentTest.addScreenCaptureFromPath("MandatoryPrimaryColor.png");
		}
	}

	@Test(priority = 7)
	private void SecondaryColorMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Secondary Color field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Secondary Color");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatorySecondaryColor"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatorySecondaryColor"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatorySecondaryColor.png");
			extentTest.addScreenCaptureFromPath("MandatorySecondaryColor.png");
		}
	}

	@Test(priority = 8)
	private void WithBackGroundColorMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify With Background Text Color field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Secondary Color");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatorySecondaryColor"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatorySecondaryColor"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatorySecondaryColor.png");
			extentTest.addScreenCaptureFromPath("MandatorySecondaryColor.png");
		}
	}

	@Test(priority = 9)
	private void Header_FooterColorMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Header_Footer Color field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Header/Footer Text Color");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryHeader_FooterColor"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryHeader_FooterColor"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryHeader_FooterColor.png");
			extentTest.addScreenCaptureFromPath("MandatoryHeader_FooterColor.png");
		}
	}

	@Test(priority = 10)
	private void SelectedBoxColorMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Selected Box Color field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Selected Box Color");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatorySelectedBoxColor"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatorySelectedBoxColor"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatorySelectedBoxColor.png");
			extentTest.addScreenCaptureFromPath("MandatorySelectedBoxColor.png");
		}
	}

	@Test(priority = 11)
	private void BannerHeadingColorMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Banner Heading Color field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Banner Heading Color");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryBannerHeadingColor"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryBannerHeadingColor"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryBannerHeadingColor.png");
			extentTest.addScreenCaptureFromPath("MandatoryBannerHeadingColor.png");
		}
	}

	@Test(priority = 11)
	private void StoreNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Store Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Store Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryStoreName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryStoreName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryStoreName.png");
			extentTest.addScreenCaptureFromPath("MandatoryStoreName.png");
		}
	}

	@Test(priority = 12)
	private void WebSiteURLMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify WebSite URL field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Website URL");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryWebSiteURL"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryWebSiteURL"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryWebSiteURL.png");
			extentTest.addScreenCaptureFromPath("MandatoryWebSiteURL.png");
		}
	}

	@Test(priority = 13)
	private void ZipcodeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Zipcode field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
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

	@Test(priority = 14)
	private void CityMandatoryValidation() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify City field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("City");
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

	@Test(priority = 15)
	private void StateMandatoryValidation() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify State field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("State");
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

	@Test(priority = 16)
	private void ReviewLinkMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Review Link field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Review Link");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryReviewLink"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryReviewLink"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryReviewLink.png");
			extentTest.addScreenCaptureFromPath("MandatoryReviewLink.png");
		}
	}

	@Test(priority = 17)
	private void BannerHeadingMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Banner Heading field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Banner Heading");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryBannerHeading"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryBannerHeading"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryBannerHeading.png");
			extentTest.addScreenCaptureFromPath("MandatoryBannerHeading.png");
		}
	}

	@Test(priority = 18)
	private void BannerTextMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Banner Text field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Banner Text");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryBannerText"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryBannerText"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryBannerText.png");
			extentTest.addScreenCaptureFromPath("MandatoryBannerText.png");
		}
	}

	@Test(priority = 19)
	private void BannerButtonTextMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Banner Button Text field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Banner Button Text");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryBannerButtonText"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryBannerButtonText"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryBannerButtonText.png");
			extentTest.addScreenCaptureFromPath("MandatoryBannerButtonText.png");
		}
	}

	@Test(priority = 19)
	private void OrderPickupTextMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Order Pickup Text field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Order Pickup Text");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryOrderPickupText"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryOrderPickupText"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryOrderPickupText.png");
			extentTest.addScreenCaptureFromPath("MandatoryOrderPickupText.png");
		}
	}

	@Test(priority = 20)
	private void storeCreate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a new Store is created successfully through [Users & Roles]");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		contactMandatory.validRecords("Create");
		String errorContact = contactMandatory.submissionValidation("Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("StoreCreatedMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("StoreCreatedMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Store Create.png");
			extentTest.addScreenCaptureFromPath("Store Create.png");
		}
		contactMandatory.listValidation("List Store Name");
	}

	@Test(priority = 21)
	private void listStoreNameValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Store Name:" + Store_Module_Page.storeName
				+ " in the Search field, Store Management [Store Name] list retrived successfully");
		Store_Module_Page filter = PageFactory.initElements(driver, Store_Module_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("List Store Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.storeName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Store_Module_Page.storeName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		filter.clearField("Search");
		filter.listValidation("List Zipcode");
	}

	@Test(priority = 22)
	private void listZipcodeValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Enter the Zipcode:" + Store_Module_Page.zipcode
				+ " in the Search field, Store Management [Store Name] list retrived successfully");
		Store_Module_Page filter = PageFactory.initElements(driver, Store_Module_Page.class);
		filter.listValidation("Search Box");
		String listValidation = filter.listValidation("List Zipcode");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.zipcode);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Store_Module_Page.zipcode)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List Zipcode.png");
			extentTest.addScreenCaptureFromPath("List Zipcode.png");
		}
		filter.clearField("Search");
		filter.listValidation("Invalid");
	}

	@Test(priority = 23)
	private void invalidValidation() throws IOException {
		extentTest = extentReports.createTest("Enter the Invalid data in the Search field - No Records is dispayed");
		Store_Module_Page filter = PageFactory.initElements(driver, Store_Module_Page.class);
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

	@Test(priority = 24)
	private void alreadyExistedWebsiteURL() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify [Website Url Already Exists] Error is dispalyed when already existing Website URL is provided");
		Store_Module_Page alreadyExisted = PageFactory.initElements(driver, Store_Module_Page.class);
		String responseMessageCreateContact = alreadyExisted.wesiteURLField("Unique Validation");
		extentTest.log(Status.INFO, "Actual Result is -" + responseMessageCreateContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("AlreadyWebisteURL"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (responseMessageCreateContact.equals(getPropertyValue("AlreadyWebisteURL"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("WebSite URL Exist Email.png");
			extentTest.addScreenCaptureFromPath("WebSite URL Exist Email.png");
		}
	}

	@Test(priority = 25)
	private void alreadyExistedReviewURL() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify [Review Url Already Exists] Error is dispalyed when already existing Review URL is provided");
		Store_Module_Page alreadyExisted = PageFactory.initElements(driver, Store_Module_Page.class);
		String responseMessageCreateContact = alreadyExisted.reviewLinkField("Unique Validation");
		extentTest.log(Status.INFO, "Actual Result is -" + responseMessageCreateContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("AlreadyReviewLink"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (responseMessageCreateContact.equals(getPropertyValue("AlreadyReviewLink"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Review URL Exist Email.png");
			extentTest.addScreenCaptureFromPath("Review URL Exist Email.png");
		}
	}

	@Test(priority = 26)
	public void editStore() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest("Verify Edit Store page is opened from Store Management-> Edit Store");
		Store_Module_Page module = PageFactory.initElements(driver, Store_Module_Page.class);
		String editContact = module.modulePage("EditStorePage");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EditStore"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("EditStore"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User Store Label.png");
			extentTest.addScreenCaptureFromPath("User Store Label.png");
		}
	}

	@Test(priority = 27)
	public void storeNamePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Store Name:" + Store_Module_Page.storeName
				+ " is prepopulated in the store edit form page");
		Store_Module_Page edit = PageFactory.initElements(driver, Store_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Store Name");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.storeName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Store_Module_Page.storeName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Store Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Store Name.png");
		}
	}

	@Test(priority = 28)
	public void websiteURLPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Website URL:" + Store_Module_Page.websiteURL
				+ " is prepopulated in the store edit form page");
		Store_Module_Page edit = PageFactory.initElements(driver, Store_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Website URL");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.websiteURL);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Store_Module_Page.websiteURL)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Website URL.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Website URL.png");
		}
	}

	@Test(priority = 29)
	public void emailPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify the Email:" + Store_Module_Page.email + " is prepopulated in the store edit form page");
		Store_Module_Page edit = PageFactory.initElements(driver, Store_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Email");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.email);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Store_Module_Page.email)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Email.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Email.png");
		}
	}

	@Test(priority = 30)
	public void phoneNumberPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Phone Number:" + Store_Module_Page.phoneNumber
				+ " is prepopulated in the store edit form page");
		Store_Module_Page edit = PageFactory.initElements(driver, Store_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Phone Number");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.phoneNumber);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Store_Module_Page.phoneNumber)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Phone Number.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Phone Number.png");
		}
	}

	@Test(priority = 31)
	public void reviewLinkPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Review Link:" + Store_Module_Page.reviewLink
				+ " is prepopulated in the store edit form page");
		Store_Module_Page edit = PageFactory.initElements(driver, Store_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Review Link");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.reviewLink);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Store_Module_Page.reviewLink)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Review Link.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Review Link.png");
		}
	}

	@Test(priority = 32)
	public void bannerHeadingPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Banner Heading:" + Store_Module_Page.bannerHeading
				+ " is prepopulated in the store edit form page");
		Store_Module_Page edit = PageFactory.initElements(driver, Store_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Banner Heading");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.bannerHeading);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Store_Module_Page.bannerHeading)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Banner Heading.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Banner Heading.png");
		}
	}

	@Test(priority = 33)
	public void bannerTextPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Banner Text:" + Store_Module_Page.bannerText
				+ " is prepopulated in the store edit form page");
		Store_Module_Page edit = PageFactory.initElements(driver, Store_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Banner Text");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.bannerText);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Store_Module_Page.bannerText)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Banner Text.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Banner Text.png");
		}
	}

	@Test(priority = 34)
	public void bannerButtonPrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify the Banner Button Text:" + Store_Module_Page.bannerButton
				+ " is prepopulated in the store edit form page");
		Store_Module_Page edit = PageFactory.initElements(driver, Store_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Banner Button Text");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Store_Module_Page.bannerButton);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Store_Module_Page.bannerButton)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Banner Button Text.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Banner Button Text.png");
		}
		edit.clearAllFields();
	}

	@Test(priority = 35)
	private void editStoreNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Store Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		contactMandatory.clickButton(Store_Module_Page.Save_Button, 5, "JS Click");
		String errorContact = contactMandatory.errorField("Store Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryStoreName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryStoreName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryStoreName.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryStoreName.png");
		}
	}

	@Test(priority = 36)
	private void EditWebSiteURLMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify WebSite URL field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Website URL");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryWebSiteURL"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryWebSiteURL"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryWebSiteURL.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryWebSiteURL.png");
		}
	}

	@Test(priority = 37)
	private void EditZipcodeMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Zipcode field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Zipcode");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryZipcode"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryZipcode"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryZipcode.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryZipcode.png");
		}
	}

	@Test(priority = 38)
	private void EditCityMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify City field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("City");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryCity"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryCity"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryCity.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryCity.png");
		}
	}

	@Test(priority = 39)
	private void EditStateMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify State field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("State");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryState"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryState"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryState.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryState.png");
		}
	}

	@Test(priority = 40)
	private void EditReviewLinkMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Review Link field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Review Link");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryReviewLink"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryReviewLink"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryReviewLink.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryReviewLink.png");
		}
	}

	@Test(priority = 41)
	private void EditBannerHeadingMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Banner Heading field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Banner Heading");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryBannerHeading"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryBannerHeading"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryBannerHeading.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryBannerHeading.png");
		}
	}

	@Test(priority = 42)
	private void EditBannerTextMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Banner Text field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Banner Text");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryBannerText"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryBannerText"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryBannerText.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryBannerText.png");
		}
	}

	@Test(priority = 43)
	private void EditBannerButtonTextMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Banner Button Text field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Banner Button Text");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryBannerButtonText"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryBannerButtonText"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryBannerButtonText.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryBannerButtonText.png");
		}
	}

	@Test(priority = 43)
	private void EditOrderPickupTextMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Order Pickup Text field is set as Mandatory & Error Message is displayed when it is BLANK");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.errorField("Order Pickup Text");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryOrderPickupText"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryOrderPickupText"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("EditMandatoryOrderPickupText.png");
			extentTest.addScreenCaptureFromPath("EditMandatoryOrderPickupText.png");
		}
	}

	@Test(priority = 44)
	private void storeEdit() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify a Exiting Store is updated successfully through [Store Management]");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		contactMandatory.validRecords("Edit");
		String errorContact = contactMandatory.submissionValidation("Edit");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("StoreUpdatedMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("StoreUpdatedMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Store Edit.png");
			extentTest.addScreenCaptureFromPath("Store Edit.png");
		}
	}

	@Test(priority = 45)
	private void storeDelete() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a Store deleted successfully through [Store Management]");
		Store_Module_Page contactMandatory = PageFactory.initElements(driver, Store_Module_Page.class);
		String errorContact = contactMandatory.submissionValidation("Delete");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("StoreDeletedMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("StoreDeletedMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Store Delete.png");
			extentTest.addScreenCaptureFromPath("Store Delete.png");
		}
		contactMandatory.createNewStore();

	}
}
