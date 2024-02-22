package org.kona.pageobjectclass;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Users_Roles_Module_Page extends BaseClass {

	@SuppressWarnings("static-access")
	public Users_Roles_Module_Page(WebDriver driver) {
		this.driver = driver;
	}

	// Navigate form path
	By Users_Roles = By.id("user_side_bar");
	@FindAll({ @FindBy(xpath = "//*[@id='base-content-page']/div/nav/div/div/div[1]/h4"),
			@FindBy(xpath = "//*[@id='base-content-page']/nav/div/div/div/h4/a") })
	WebElement Form_Label;
	By Create_Button = By.id("dropdownMenuButton2");
	By Create_User_Button = By.xpath("//*[@id='base-content-page']/div/nav/div/div/div[2]/div/ul/li[1]/a");
	By Create_Role_Button = By.xpath("//*[@id='base-content-page']/div/nav/div/div/div[2]/div/ul/li[2]/a");

	// Field Path
	By First_Name = By.xpath("//*[@id='myForm']/div[1]/div[1]/div[1]/input");
	By Last_Name = By.xpath("//*[@id='myForm']/div[1]/div[2]/div[1]/input");
	@FindAll({ @FindBy(id = "email-address"), @FindBy(id = "edit_email") })
	WebElement Email;
	By Mobile_Number = By.xpath("//*[@id='myForm']/div[2]/div[2]/div[1]/input");
	By Select_Role = By.xpath("//*[@id='myForm']/div[3]/div[1]/div[2]/div/button");
	By Select_First_Role = By.xpath("//*[@id='myForm']/div[3]/div[1]/div[2]/div/ul/li[2]/a/label/input");
	@FindAll({ @FindBy(id = "job_title"), @FindBy(xpath = "//*[@id='myForm']/div[3]/div[4]/div[1]/input") })
	WebElement Job_Tittle;
	By Select_Hub = By.xpath("//*[@id='hub-hide-create']/div[1]/div/div/button");
	By Select_Zero_Hub = By.xpath("//*[@id='hub-hide-create']/div[1]/div/div/ul/li[2]/a/label/input");
	By Select_First_Hub = By.xpath("//*[@id='hub-hide-create']//child::div[contains(@class,'open')]//li[3]//input");
	By Attachment = By.id("readUrl");
	@FindAll({ @FindBy(xpath = "//*[text()='Save']"), @FindBy(xpath = "//*[text()='Update']") })
	WebElement Save_Button;
	By Permission = By.xpath("//*[text()='Permissions']//parent::div[contains(@style,'display')]");
	By Role_Name = By.xpath("//*[@name='name']");
	By Role_Description = By.xpath("//*[@name='description']");
	By Permission_Select = By.id("checkall");
	By Permission_Deselect = By.id("removeall");

	// Field Error Path
	By Error_First_Name = By.xpath("//*[contains(@class,'first_name_form_error')]");
	By Error_Role_Name = By.xpath("//*[contains(@class,'role_form_error')]");
	By Error_Last_Name = By.xpath("//*[contains(@class,'last_name_form_error')]");
	By Error_Description = By.xpath("//*[contains(@class,'description_form_error')]");
	By Error_Email_Name = By.xpath("//*[contains(@class,'email_form_error')]");
	By Error_Permission = By.xpath("//*[contains(@class,'permission_form_error')]");
	By Error_Mobile_Number = By.xpath("//*[contains(@class,'mobile_number_form_error')]");
	By Error_Select_Role = By.xpath("//*[contains(@class,'type_form_error')]");

	// Field Error Invisible
	By Invisible_Error_First_Name = By.xpath("//*[contains(text(),'The first name field is required.')]");
	By Invisible_Error_Last_Name = By.xpath("//*[contains(text(),'The last name field is required.')]");
	By Invisible_Error_Email_Name = By.xpath("//*[contains(text(),'The email address field is required.')]");
	By Invisible_Existing_Email_Name = By.xpath("//*[contains(text(),'The email has already been taken.')]");
	By Invisible_Existing_Role_Name = By.xpath("//*[contains(text(),'The role name has already been taken.')]");
	By Invisible_Role_Description = By
			.xpath("//*[contains(text(),'The description may not be greater than 150 characters.')]");

	// Successfully Message Path
	@FindAll({ @FindBy(xpath = "//*[@id='popup-role-save']/div/div/div/div/div/h2"),
			@FindBy(xpath = "//*[@id='popup-save']/div/div/div/div/div/h2") })
	WebElement CreateMessage;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-role-save']/div/div/div/div/div/a/button"),
			@FindBy(xpath = "//*[@id='popup-save']/div/div/div/div/div/a/button") })
	WebElement CreateClose;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-update-role']/div/div/div/div/div/h2"),
			@FindBy(xpath = "//*[@id='popup-update']/div/div/div/div/div/h2") })
	WebElement UpdateMessage;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-update-role']/div/div/div/div/div/h2"),
			@FindBy(xpath = "//*[@id='popup-update']/div/div/div/div/div/a/button") })
	WebElement UpdateClose;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-delete-role']/div/div/div/div/div/h2"),
			@FindBy(xpath = "//*[@id='popup-delete-user']/div/div/div/div/div/h2") })
	WebElement DeleteMessage;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-delete-role']/div/div/div/div/div/a/button"),
			@FindBy(xpath = "//*[@id='popup-delete-user']/div/div/div/div/div/a/button") })
	WebElement DeleteClose;
	By Side_Loader = By.xpath("//*[contains(@class,'file-loader') and contains(@style,'display: none;')]");

	// List path
	// Filter Path
	By Searc_Box = By.id("userSearch");
	By Role = By.xpath("//*[@id='base-content-page']/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/button");
	By First_Role = By.xpath(
			"//*[@id='base-content-page']/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/ul/li[2]/a/label/input");
	By Hub = By.xpath("//*[@id='base-content-page']/div/div/div[1]/div/div/div[1]/div/div/div[3]/div/button");
	By First_Hub = By.xpath(
			"//*[@id='base-content-page']/div/div/div[1]/div/div/div[1]/div/div/div[3]/div/ul/li[2]/a/label/input");
	@FindAll({
			@FindBy(xpath = "//*[@id='base-content-page']/div/div[1]/div[1]/div/div/div/div/div[1]/div/div/div[2]/div/button"),
			@FindBy(xpath = "//*[@id='base-content-page']/div/div/div[1]/div/div/div[1]/div/div/div[4]/div/button") })
	WebElement Status;
	@FindAll({
			@FindBy(xpath = "//*[@id='base-content-page']/div/div[1]/div[1]/div/div/div/div/div[1]/div/div/div[2]/div/ul/li[1]/a/label"),
			@FindBy(xpath = "//*[@id='base-content-page']/div/div/div[1]/div/div/div[1]/div/div/div[4]/div/ul/li[1]/a/label/input") })
	WebElement Active;
	@FindAll({ @FindBy(xpath = "//*[@id='base-content-page']/div/div[1]/div[1]/div/div/div/div/div[2]/a/button"),
			@FindBy(xpath = "//*[@id='base-content-page']/div/div/div[1]/div/div/div[2]/a/button") })
	WebElement View;

	// List Record path
	@FindAll({ @FindBy(xpath = "//*[text()='No Records']"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/tbody/tr[1]/td[2]") })
	WebElement List_First_Name;
	@FindAll({ @FindBy(xpath = "//*[text()='No Records']"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/tbody/tr[1]/td[3]") })
	WebElement List_Last_Name;
	@FindAll({ @FindBy(xpath = "//*[text()='No Records']"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/tbody/tr[1]/td[4]") })
	WebElement List_Email;
	@FindAll({ @FindBy(xpath = "//*[text()='No Records']"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/tbody/tr[1]/td[5]") })
	WebElement List_Mobile_Number;
	@FindAll({ @FindBy(xpath = "//*[text()='No Records']"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/tbody/tr[1]/td[6]") })
	WebElement List_Role;
	@FindAll({ @FindBy(xpath = "//*[text()='No Records']"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/tbody/tr[1]/td[7]") })
	WebElement List_Hub;
	@FindAll({ @FindBy(xpath = "//*[text()='No Records']"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/tbody/tr[1]/td[8]"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/tbody/tr[1]/td[6]//div") })
	WebElement List_Active_Status;
	@FindAll({ @FindBy(xpath = "//*[@id='pagination-data-container']//tbody//tr[1]//td[7]//i"),
			@FindBy(xpath = "//*[@id='pagination-data-container']//tbody//tr[1]//td[9]//i") })
	WebElement Three_Dots;
	@FindAll({ @FindBy(xpath = "//*[@id='pagination-data-container']//tbody//tr[1]//td[7]//ul//li[1]//a"),
			@FindBy(xpath = "//*[@id='pagination-data-container']//tbody//tr[1]//td[9]//ul//li[2]//a") })
	WebElement Edit;
	@FindAll({ @FindBy(xpath = "//*[@id='pagination-data-container']//tbody//tr[1]//td[7]//ul//li[2]//a"),
			@FindBy(xpath = "//*[@id='pagination-data-container']//tbody//tr[1]//td[9]//ul//li[3]//a") })
	WebElement Delete;
	By Invalid_List = By.xpath("//*[text()='No Records']");
	By Reset = By.xpath("//*[@id='base-content-page']/div/div/div[1]/div/div/div[3]/a/button");
	@FindAll({ @FindBy(xpath = "//*[@id='popup-role-remove']/div/div/div[2]/div/p/a/button"),
			@FindBy(xpath = "//*[@id='popup-user-delete']/div/div/div[2]/div/a/button") })
	WebElement Delete_Cofm_Popup;
	By Role_List_Filter = By
			.xpath("//*[@id='base-content-page']/div/div[1]/div[1]/div/div/div/div/div[1]/div/div/div[1]/div/button");
	By Dynamic_Role_List = By.xpath("//*[text()=' " + roleName + "']");

	public String modulePage(String value) throws InterruptedException {
		if (value.equals("Module")) {
			this.clickButton(Users_Roles, 10, "JS Click");
		} else if (value.equals("UserCreatePage") || value.equals("RoleCreatePage")) {
			this.clickButton(Create_Button, 10, "JS Click");
			switch (value) {
			case "UserCreatePage":
				this.clickButton(Create_User_Button, 10, "JS Click");
				break;
			case "RoleCreatePage":
				this.clickButton(Create_Role_Button, 10, "JS Click");
				break;
			default:
				break;
			}
		} else if (value.equals("User Edit Page") || value.equals("Role Edit Page")) {
			String text = this.getText(List_First_Name, 10);
			this.clickButton(Three_Dots, 10, "JS Click");
			this.clickButton(Edit, 10, "JS Click");
			if (value.equals("User Edit Page")) {
				this.visible(First_Name, 10);
				this.invisible(Permission, 10);
				this.valuePresentCondition(First_Name, 10, text);
			} else if (value.equals("Role Edit Page")) {
				this.visible(Role_Name, 10);
				this.valuePresentCondition(Role_Name, 10, text);
			}
		}
		return this.getText(Form_Label, 10);
	}

	public String errorMessage(String value) throws AWTException {
		if (value.equals("First Name")) {
			this.clickButton(Save_Button, 10, "JS Click");
			if (!this.conditionChecking(Error_First_Name, 5)) {
				do {
					this.clickButton(Save_Button, 10, "JS Click");
				} while (!this.conditionChecking(Error_First_Name, 5));
			}
			return this.getText(Error_First_Name, 10);
		} else if (value.equals("Last Name")) {
			this.clickButton(Save_Button, 10, "JS Click");
			if (!this.conditionChecking(Error_Last_Name, 5)) {
				do {
					this.clickButton(Save_Button, 10, "JS Click");
				} while (!this.conditionChecking(Error_Last_Name, 5));
			}
			return this.getText(Error_Last_Name, 10);
		} else if (value.equals("Email")) {
			if (!this.conditionChecking(Error_Email_Name, 5)) {
				do {
					this.clickButton(Save_Button, 10, "JS Click");
				} while (!this.conditionChecking(Error_Email_Name, 5));
			}
			return this.getText(Error_Email_Name, 10);
		} else if (value.equals("Mobile Number")) {
			this.clickButton(Save_Button, 10, "JS Click");
			if (!this.conditionChecking(Error_Mobile_Number, 5)) {
				do {
					this.clickButton(Save_Button, 10, "JS Click");
				} while (!this.conditionChecking(Error_Mobile_Number, 5));
			}
			return this.getText(Error_Mobile_Number, 10);
		} else if (value.equals("Select Role")) {
			return this.getText(Error_Select_Role, 10);
		} else if (value.equals("Role Name")) {
			this.clickButton(Save_Button, 10, "JS Click");
			if (!this.conditionChecking(Error_Role_Name, 10)) {
				do {
					this.clickButton(Save_Button, 10, "JS Click");
				} while (!this.conditionChecking(Error_Role_Name, 10));
			}
			return this.getText(Error_Role_Name, 10);
		} else if (value.equals("Role Description")) {
			if (!this.conditionChecking(Error_Description, 10)) {
				do {
					this.clickButton(Save_Button, 10, "JS Click");
				} while (!this.conditionChecking(Error_Description, 10));
			}
			return this.getText(Error_Description, 10);
		} else if (value.equals("Permission")) {
			if (!this.conditionChecking(Error_Permission, 10)) {
				do {
					this.clickButton(Save_Button, 10, "JS Click");
				} while (!this.conditionChecking(Error_Permission, 10));
			}
			return this.getText(Error_Permission, 10);
		}
		return value;
	}

	public static String firstName;
	public static String lastName;
	public static String email;
	public static String phoneNumber;
	public static String selectRole;
	public static String jobTittle;
	public static String selectHub;
	public static String roleName;
	public static String roleDescription;

	public void validRecords(String value) throws AWTException, InterruptedException {
		if (value.equals("Users") || value.equals("Create")) {
			this.inputText(First_Name, dummyData("First Name"), 10);
			firstName = this.getTextAttribute(First_Name, 10);
			this.inputText(Last_Name, dummyData("Last Name"), 10);
			lastName = this.getTextAttribute(Last_Name, 10);
			this.inputText(Email, dummyData("Email"), 10);
			email = this.getTextAttribute(Email, 10);
			this.inputText(Mobile_Number, randomCharacters("Max 10 Characters"), 10);
			phoneNumber = this.getTextAttribute(Mobile_Number, 10);
			if (value.equals("Create")) {
				this.inputText(Job_Tittle, dummyData("Job Tittle"), 10);
				jobTittle = this.getTextAttribute(Job_Tittle, 10);
				this.clickButton(Select_Role, 10, "JS Click");
				this.clickButton(Select_First_Role, 10, "JS Click");
				selectRole = this.getTextAttribute(Select_Role, 10);
				this.invisible(Permission, 10);
				this.clickButton(Select_Hub, 10, "JS Click");
				if (!this.conditionChecking(Select_First_Hub, 2)) {
					do {
						this.clickButton(Select_Hub, 10, "JS Click");
					} while (!this.conditionChecking(Select_First_Hub, 2));
				}
				this.clickButton(Select_First_Hub, 10, "JS Click");
				this.invisible(Select_First_Hub, 10);
				selectHub = this.getTextAttribute(Select_Hub, 10);
			}
		} else if (value.equals("Roles")) {
			this.inputText(Role_Name, randomCharacters("Dummy Roles"), 10);
			roleName = this.getTextAttribute(Role_Name, 10);
			this.inputText(Role_Description, randomCharacters("Dummy Description"), 10);
			roleDescription = this.getTextAttribute(Role_Description, 10);
			this.clickButton(Permission_Select, 10, "JS Click");
		}
		this.clickButton(Save_Button, 5, "JS Click");
	}

	public String submissionValidation(String value) throws IOException {
		Boolean conditionCheck = true;
		if (value.equals("Create") || value.equals("Edit") || value.equals("Roles Create")
				|| value.equals("Role Edit")) {
			if (value.equals("Create") || value.equals("Edit")) {
				if (this.conditionChecking(Invisible_Existing_Email_Name, 5)) {
					if (this.getText(Invisible_Existing_Email_Name, 10)
							.equals(getPropertyValue("AlreadyExistedEmail"))) {
						do {
							this.clearField(Email, 10);
							this.inputText(Email, dummyData("Email"), 10);
							this.clickButton(Save_Button, 10, "JS Click");
							if (!this.conditionChecking(Invisible_Existing_Email_Name, 5)) {
								conditionCheck = false;
							}
						} while (conditionCheck);
					}
				}
			} else if (value.equals("Roles Create") || value.equals("Role Edit")) {
				if (this.conditionChecking(Error_Role_Name, 5)) {
					if (this.getText(Error_Role_Name, 10).equals(getPropertyValue("RoleExistingName"))) {
						do {
							this.clearField(Role_Name, 10);
							this.inputText(Role_Name, randomCharacters("Dummy Roles"), 10);
							this.clickButton(Save_Button, 10, "JS Click");
							if (!this.conditionChecking(Error_Role_Name, 5)) {
								conditionCheck = false;
							}
						} while (conditionCheck);
					}
				}
			}
		}
		if (value.equals("Create") || value.equals("Roles Create")) {
			if (!this.conditionChecking(CreateMessage, 20)) {
				do {
					this.clickButton(Save_Button, 10, "JS Click");
				} while (!this.conditionChecking(CreateMessage, 20));
			}
			String create = this.getText(CreateMessage, 10);
			this.clickButton(CreateClose, 10, "JS Click");
			return create;
		} else if (value.equals("Edit") || value.equals("Role Edit")) {
			if (!this.conditionChecking(UpdateMessage, 10)) {
				do {
					this.clickButton(Save_Button, 10, "JS Click");
				} while (!this.conditionChecking(UpdateMessage, 10));
			}
			String update = this.getText(UpdateMessage, 10);
			this.clickButton(UpdateClose, 10, "JS Click");
			if (!this.invisibleConditionChecking(Side_Loader, 5)) {
				do {
					this.clickButton(UpdateClose, 10, "JS Click");
				} while (!this.invisibleConditionChecking(Side_Loader, 5));
			}
			return update;
		} else if (value.equals("Delete")) {
			String delete = this.getText(DeleteMessage, 10);
			this.clickButton(DeleteClose, 10, "JS Click");
			return delete;
		}
		return value;
	}

	public String editPrepopulate(String value) {
		if (value.equals("First Name")) {
			return this.getTextAttribute(First_Name, 10);
		} else if (value.equals("Last Name")) {
			return this.getTextAttribute(Last_Name, 10);
		} else if (value.equals("Email")) {
			return this.getTextAttribute(Email, 10);
		} else if (value.equals("Mobile Number")) {
			return this.getTextAttribute(Mobile_Number, 10);
		} else if (value.equals("Select Role")) {
			return this.getTextAttribute(Select_Role, 10);
		} else if (value.equals("Job Tittle")) {
			return this.getTextAttribute(Job_Tittle, 10);
		} else if (value.equals("Select Hub")) {
			return this.getTextAttribute(Select_Hub, 10);
		} else if (value.equals("Role Name")) {
			return this.getTextAttribute(Role_Name, 10);
		} else if (value.equals("Role Description")) {
			return this.getTextAttribute(Role_Description, 10);
		}
		return value;
	}

	public void clearField(String value) throws AWTException {
		if (value.equals("First Name")) {
			this.clearField(First_Name, 10);
		} else if (value.equals("Last Name")) {
			this.clearField(Last_Name, 10);
		} else if (value.equals("Email")) {
			this.clearField(Email, 10);
		} else if (value.equals("Mobile Number")) {
			this.clearField(Mobile_Number, 10);
		} else if (value.equals("Select Role")) {
			this.clickButton(Select_First_Role, 10, "JS Click");
			this.clickButton(Select_Role, 10, "JS Click");
		} else if (value.equals("Job Tittle")) {
			this.clearField(Job_Tittle, 10);
		} else if (value.equals("Select Hub")) {
			this.clickButton(Select_Hub, 10, "JS Click");
			if (!this.conditionChecking(Select_Zero_Hub, 3)) {
				do {
					this.clickButton(Select_Hub, 10, "JS Click");
				} while (!this.conditionChecking(Select_Zero_Hub, 3));
			}
			this.clickButton(Select_Zero_Hub, 10, "JS Click");
		} else if (value.equals("Search")) {
			this.clearField(Searc_Box, 10);
		} else if (value.equals("Role Name")) {
			this.clearField(Role_Name, 10);
		} else if (value.equals("Role Description")) {
			this.clearField(Role_Description, 10);
		} else if (value.equals("Permission Clear")) {
			this.clickButton(Permission_Select, 10, "JS Click");
			this.clickButton(Permission_Deselect, 10, "JS Click");
		}
	}

	public void clearAllFields() throws AWTException {
		if (this.conditionChecking(First_Name, 5)) {
			this.visible(By.xpath("//*[text()=' Users']"), 10);
			List<String> asList = Arrays.asList("First Name", "Last Name", "Email", "Mobile Number", "Job Tittle");
			for (int i = 0; i < asList.size(); i++) {
				this.clearField(asList.get(i));
			}
		} else {
			List<String> asList = Arrays.asList("Role Name", "Role Description", "Permission Clear");
			for (int i = 0; i < asList.size(); i++) {
				this.clearField(asList.get(i));
			}
		}
	}

	static String listRecord;

	public String listValidation(String value) {
		if (value.equals("Search Box")) {
			this.inputText(Searc_Box, listRecord, 10);
			this.clickButton(View, 10, "JS Click");
		} else if (value.equals("First Name")) {
			listRecord = this.getText(List_First_Name, 10);
		} else if (value.equals("Last Name")) {
			listRecord = this.getText(List_Last_Name, 10);
		} else if (value.equals("Email")) {
			listRecord = this.getText(List_Email, 10);
		} else if (value.equals("Mobile Number")) {
			listRecord = this.getText(List_Mobile_Number, 10);
			listRecord = listRecord.replace("-", "");
		} else if (value.equals("Role")) {
			listRecord = this.getText(List_Role, 10);
		} else if (value.equals("Hub")) {
			listRecord = this.getText(List_Hub, 10);
		} else if (value.equals("Status")) {
			listRecord = this.getText(List_Active_Status, 10);
		} else if (value.equals("Reset")) {
			this.clickButton(Reset, 10, "JS Click");
		} else if (value.equals("List Invalid")) {
			listRecord = this.inputText(Searc_Box, "jdsfjhfsfskhfsfh", 10);
		}
		if (value.equals("Filter Role") || value.equals("Filter Hub") || value.equals("Filter Status")) {
			if (value.equals("Filter Role")) {
				this.clickButton(Role, 10, "JS Click");
				this.clickButton(First_Role, 10, "JS Click");
			} else if (value.equals("Filter Hub")) {
				this.clickButton(Hub, 10, "JS Click");
				this.clickButton(First_Hub, 10, "JS Click");
			} else if (value.equals("Filter Status")) {
				this.clickButton(Status, 10, "JS Click");
				this.clickButton(Active, 10, "JS Click");
			}
			this.clickButton(View, 10, "JS Click");
		} else if (value.equals("Invalid")) {
			return this.getText(Invalid_List, 10);
		} else if (value.equals("Delete")) {
			this.clickButton(Three_Dots, 10, "JS Click");
			this.clickButton(Delete, 10, "JS Click");
			this.clickButton(Delete_Cofm_Popup, 10, "JS Click");
		} else if (value.equals("Filter Roles")) {
			this.clickButton(Role_List_Filter, 10, "JS Click");
			this.clickButton(Dynamic_Role_List, 10, "JS Click");
			this.clickButton(View, 10, "JS Click");
		}
		return listRecord;
	}

	public String emailField(String value) throws InterruptedException, AWTException {
		if (value.equals("Unique Validation")) {
			String text = this.getText(List_Email, 10);
			this.modulePage("UserCreatePage");
			this.inputText(Email, text, 10);
			this.clickButton(Save_Button, 10, "JS Click");
			String errorEmail = this.errorMessage("Email");
			this.clickButton(Form_Label, 10, "JS Click");
			return errorEmail;
		} else if (value.equals("Invalid")) {
			this.inputText(Email, dummyData("Email"), 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisible(Invisible_Error_Email_Name, 10);
			this.clearField("Email");
			this.inputText(Email, "fkjjhkdsfhkfhds", 10);
			this.clickButton(Save_Button, 10, "JS Click");
		}
		return value;
	}

	public void firstName(String value) throws AWTException, InterruptedException {
		this.inputText(First_Name, dummyData("First Name"), 10);
		this.clickButton(Save_Button, 10, "JS Click");
		this.invisible(Invisible_Error_First_Name, 10);
		this.clearField("First Name");
		if (value == "Invalid") {
			this.inputText(First_Name, "(*&^%$#$%^&", 10);
		}
	}

	public void lastName(String value) throws AWTException {
		this.inputText(Last_Name, dummyData("Last Name"), 10);
		this.clickButton(Save_Button, 10, "JS Click");
		this.invisible(Invisible_Error_Last_Name, 10);
		this.clearField("Last Name");
		if (value == "Invalid") {
			this.inputText(Last_Name, "(*&^%$#$%^&", 10);
		}
		this.clickButton(Save_Button, 10, "JS Click");
	}

	public String roleName(String value) throws AWTException {
		if (value.equals("Unique")) {
			String text = this.getText(List_First_Name, 10);
			this.clickButton(Create_Button, 10, "JS Click");
			this.clickButton(Create_Role_Button, 10, "JS Click");
			this.inputText(Role_Name, text, 10);
			this.clickButton(Save_Button, 10, "JS Click");
			String errorMessage = errorMessage("Role Name");
			this.clickButton(Form_Label, 10, "JS Click");
			return errorMessage;
		}
		return value;

	}

	public void descriptionField(String value) {
		if (value.equals("Max Character")) {
			this.inputText(Role_Description, randomCharacters("Max 256 Characters"), 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.visible(Invisible_Role_Description, 10);
		}
	}
}
