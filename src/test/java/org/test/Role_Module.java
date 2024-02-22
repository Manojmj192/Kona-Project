package org.test;

import java.awt.AWTException;
import java.io.IOException;
import org.base.BaseClass;
import org.kona.pageobjectclass.LoginPage;
import org.kona.pageobjectclass.Users_Roles_Module_Page;
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

public class Role_Module extends BaseClass {
	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;
	static String listRecord;

	@BeforeClass
	public void setup() throws IOException {
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Role Module.html");
		extentReports.attachReporter(extentHtmlReporter);
		this.driver = BrowserSetup.startBrowser();

	}

	@AfterClass
	public void exitBrowser() {
		this.driver.quit();
		this.extentReports.flush();
	}

	@Test(priority = -1)
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

	@Test(priority = 0)
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

	@Test(priority = 1)
	public void createRoles() throws InterruptedException, IOException {
		extentTest = extentReports.createTest("Verify Create Roles page is opened from User & Roles-> Create Roles");
		Users_Roles_Module_Page module = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String editContact = module.modulePage("RoleCreatePage");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("CreateRoles"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("CreateRoles"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User&Role List.png");
			extentTest.addScreenCaptureFromPath("User&Role List.png");
		}
	}

	@Test(priority = 2)
	private void roleNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Role Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Role Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryRole"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryRole"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Role Name.png");
			extentTest.addScreenCaptureFromPath("Role Name.png");
		}
	}

	@Test(priority = 3)
	private void descriptionMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Description field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Role Description");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryDescription"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryDescription"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Description.png");
			extentTest.addScreenCaptureFromPath("Description.png");
		}
	}

	@Test(priority = 4)
	private void descriptionMaxCharacter() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Error Message is displayed when [Role] Description Field exceed its max-150 limit");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.descriptionField("Max Character");
		String errorContact = contactMandatory.errorMessage("Role Description");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MaxRoleDescription"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MaxRoleDescription"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("descriptionMaxCharacter.png");
			extentTest.addScreenCaptureFromPath("descriptionMaxCharacter.png");
		}
		contactMandatory.clearField("Role Description");
	}

	@Test(priority = 5)
	private void permissionMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Permission field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Permission");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryPermission"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryPermission"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryPermission.png");
			extentTest.addScreenCaptureFromPath("MandatoryPermission.png");
		}
	}

	@Test(priority = 6)
	private void usercreate() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a new User is created successfully through [Users & Roles]");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.validRecords("Roles");
		String errorContact = contactMandatory.submissionValidation("Roles Create");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("RoleCreatedMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("RoleCreatedMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User Create.png");
			extentTest.addScreenCaptureFromPath("Role Create.png");
		}
		listRecord = contactMandatory.listValidation("First Name");
	}

	@Test(priority = 7)
	private void listRoleValidation() throws IOException, AWTException {
		extentTest = extentReports.createTest("Verify to Pick the Filter field & select Role Name is:" + listRecord);
		Users_Roles_Module_Page filter = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		filter.listValidation("Filter Roles");
		String listValidation = filter.listValidation("First Name");
		extentTest.log(Status.INFO, "Actual Result is -" + listValidation);
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.roleName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (listValidation.equals(Users_Roles_Module_Page.roleName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("List First Name.png");
			extentTest.addScreenCaptureFromPath("List First Name.png");
		}
		listRecord = filter.listValidation("Status");
	}

	@Test(priority = 8)
	private void listStatusValidation() throws IOException {
		extentTest = extentReports.createTest("Verify to Pick the Filter field & select Role Status is:" + listRecord);
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
	}

	@Test(priority = 9)
	private void alreadyExistedRoleName() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest(
				"Verify [Role Name Already Exists] Error is dispalyed when already existing role name is provided");
		Users_Roles_Module_Page alreadyExisted = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String responseMessageCreateContact = alreadyExisted.roleName("Unique");
		extentTest.log(Status.INFO, "Actual Result is -" + responseMessageCreateContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("RoleExistingName"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (responseMessageCreateContact.equals(getPropertyValue("RoleExistingName"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Role Already Exist Email.png");
			extentTest.addScreenCaptureFromPath("Role Already Exist Email.png");
		}
	}

	@Test(priority = 10)
	public void editUsers() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest("Verify Edit Roles page is opened from User & Roles-> Edit Roles");
		Users_Roles_Module_Page module = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String editContact = module.modulePage("Role Edit Page");
		extentTest.log(Status.INFO, "Actual Result is -" + editContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("EditRoles"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (editContact.equals(getPropertyValue("EditRoles"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User Edit Label.png");
			extentTest.addScreenCaptureFromPath("User Edit Label.png");
		}
	}

	@Test(priority = 11)
	public void firstNamePrepopulate() throws InterruptedException, IOException {
		extentTest = extentReports.createTest(
				"Verify the Role Name:" + Users_Roles_Module_Page.roleName + " is prepopulated in the user edit form page");
		Users_Roles_Module_Page edit = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Role Name");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage);
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.roleName);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (assertionMessage.equals(Users_Roles_Module_Page.roleName)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate First Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate First Name.png");
		}
	}

	@Test(priority = 12)
	public void roleDescriptionPrepopulate() throws InterruptedException, IOException, AWTException {
		extentTest = extentReports.createTest("Verify the Role Description:" + Users_Roles_Module_Page.roleDescription
				+ " is prepopulated in the user edit form page");
		Users_Roles_Module_Page edit = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String assertionMessage = edit.editPrepopulate("Role Description");
		extentTest.log(Status.INFO, "Actual Result is -" + assertionMessage + " ");
		extentTest.log(Status.INFO, "Expected Result is -" + Users_Roles_Module_Page.roleDescription);
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if ((assertionMessage + " ").equals(Users_Roles_Module_Page.roleDescription)) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Edit Prepopulate Last Name.png");
			extentTest.addScreenCaptureFromPath("Edit Prepopulate Last Name.png");
		}
		edit.clearAllFields();
	}

	@Test(priority = 13)
	private void editroleNameMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Role Name field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Role Name");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryRole"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryRole"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Role Name.png");
			extentTest.addScreenCaptureFromPath("Role Name.png");
		}
	}

	@Test(priority = 14)
	private void editdescriptionMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Description field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Role Description");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryDescription"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryDescription"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("Description.png");
			extentTest.addScreenCaptureFromPath("Description.png");
		}
	}
	
	@Test(priority = 15)
	private void editdescriptionMaxCharacter() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports
				.createTest("Verify Error Message is displayed when [Role] Description Field exceed its max-150 limit");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.descriptionField("Max Character");
		String errorContact = contactMandatory.errorMessage("Role Description");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MaxRoleDescription"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MaxRoleDescription"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("descriptionMaxCharacter.png");
			extentTest.addScreenCaptureFromPath("descriptionMaxCharacter.png");
		}
		contactMandatory.clearField("Role Description");
	}

	@Test(priority = 16)
	private void editpermissionMandatoryValidation()
			throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest(
				"Verify Permission field is set as Mandatory & Error Message is displayed when it is BLANK");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		String errorContact = contactMandatory.errorMessage("Permission");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("MandatoryPermission"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("MandatoryPermission"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("MandatoryPermission.png");
			extentTest.addScreenCaptureFromPath("MandatoryPermission.png");
		}
	}

	@Test(priority = 17)
	private void userEdit() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a Role is updated successfully through [Users & Roles]");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.validRecords("Roles");
		String errorContact = contactMandatory.submissionValidation("Role Edit");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("RoleUpdatedMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("RoleUpdatedMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User Create.png");
			extentTest.addScreenCaptureFromPath("Role Create.png");
		}
	}

	@Test(priority = 18)
	private void roledelete() throws WebDriverException, IOException, InterruptedException, AWTException {
		extentTest = extentReports.createTest("Verify a Role deleted successfully through [Users & Roles]");
		Users_Roles_Module_Page contactMandatory = PageFactory.initElements(driver, Users_Roles_Module_Page.class);
		contactMandatory.listValidation("Delete");
		String errorContact = contactMandatory.submissionValidation("Delete");
		extentTest.log(Status.INFO, "Actual Result is -" + errorContact);
		extentTest.log(Status.INFO, "Expected Result is -" + getPropertyValue("RoleDeletedMessage"));
		extentTest.log(Status.INFO, "Verification of Actual & Expected Validation");
		if (errorContact.equals(getPropertyValue("RoleDeletedMessage"))) {
			extentTest.log(Status.PASS, "Actual & Expected Validation are Equal");
		} else {
			extentTest.log(Status.FAIL, "Actual & Expected Validation are Not are Equal");
			ScreenShots("User Delete.png");
			extentTest.addScreenCaptureFromPath("User delete.png");
		}
	}

}
