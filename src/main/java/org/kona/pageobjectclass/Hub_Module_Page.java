package org.kona.pageobjectclass;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hub_Module_Page extends BaseClass {
	public static String hubName;
	public static String address1;
	public static String zipcode;
	public static String city;
	public static String state;
	public static String phoneNumber;
	public static String assignStore;
	public static String deliverySchedule;
	public static String pickupSchedule;
	public static String printerName;
	public static String printerIP;
	public static String chatNumber;
	public static String login;
	public static String transactionKey;
	public static String viewRecord;
	public static String dateRange;
	public static String selectEvent;
	public static String startDate;
	public static String endDate;
	public static String catalogueName;
	public static String date;
	public static String discount;
	public static String description;
	public static String eventName;
	public static String eventDate;
	public static String eventThreeDots;
	public static String eventEdit;
	public static String eventDelete;

	String num = "1";

	@SuppressWarnings("static-access")
	public Hub_Module_Page(WebDriver driver) {
		this.driver = driver;
	}

//	Navigation Path
	By Hub_Module = By.id("hub_side_bar");
	@FindAll({ @FindBy(xpath = "//*[text()='Hub Management']"), @FindBy(xpath = "//*[text()=' Create Hub']"),
			@FindBy(xpath = "//*[text()='Edit Hub']"), @FindBy(xpath = "//*[text()='View All Stores']"),
			@FindBy(xpath = "//*[text()='CSR Chat Numbers']"), @FindBy(xpath = "//*[text()='Create Chat Numbers']"),
			@FindBy(xpath = "//*[text()='Catalogue Date Override Management']"),
			@FindBy(xpath = "//*[text()='Create Catalogue Date Override']"),
			@FindBy(xpath = "//*[text()='Edit Catalogue Date Override']"), @FindBy(xpath = "//*[text()='Hub View']"),
			@FindBy(xpath = "//*[text()='Discount or Markup']"),
			@FindBy(xpath = "//*[text()='Create Discount or Markup']"),
			@FindBy(xpath = "//*[text()='Edit Discount or Markup']"), @FindBy(xpath = "//*[text()='Event Manager']"),
			@FindBy(xpath = "//*[text()=' Create Event ']"), @FindBy(xpath = "//*[text()='Edit Event']") })
	public static WebElement Form_Label;
	By Create_Hub = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/nav/div/div/div[3]/div/a");
	@FindAll({ @FindBy(xpath = "//*[@id='base-content-page']/div/nav/div/div/div[2]/div/a"),
			@FindBy(xpath = "//*[@id='base-content-page']/div[1]/div[1]/nav/div/div/div[2]/div/a") })
	WebElement Catalogue_Date_Override;
	By Create_Discount_Markup = By.xpath("//*[@id='base-content-page']/div[1]/nav/div/div/div[3]/a/button");
	By Add_Discount_Markup = By.xpath("//*[@id='hubview']/nav/div/div/div[2]/span[2]/a");
	By Event_Manager = By.xpath("//*[@id='hubview']/nav/div/div/div[2]/span[4]/a");
	By Add_Events = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/h5/a");

//	Event
	By Select_Event = By.name("event_name");
	By From_Date = By.name("from_date");
	By To_Date = By.name("to_date");
	By Description = By.name("description");

//	Discount or Markup
	By Date = By.name("rows[0][date]");
	By Bulk_Price = By.name("rows[0][type]");
	By Discount = By.name("rows[0][price]");

// Catalog 
	By Catlogue_Select_Date_Range = By.name("date");
	By Catlogue_Hub_List_Field = By.xpath("//*[@id='rows0']/div[2]/div[1]/div/button");
	By Catlogue_Hub_List_Visible = By
			.xpath("//*[@id='hubDropdownList']//following-sibling::div[contains(@class,'open')]");
	By Catlogue_Hub_CheckBox = By.xpath("//*[@id='rows0']/div[2]/div[1]/div/ul/li[2]/a/label/input");
	By Catlogue_Select_Type = By.name("catalogue");
	By Select_Catlogue = By.xpath("//*[@id='catalogue-hide']/div[1]/div/button");
	By Select_DropDown_Catlogue = By
			.xpath("//*[@id='catalogueListDateDropdown']//following-sibling::div//ul//li//label[text()=' " + viewRecord
					+ "']");
	By Visible_Catalogue_Dropdown = By
			.xpath("//*[@id='catalogueListDateDropdown']//following-sibling::div[contains(@class,'open')]");
	By Catelogue_Visible = By.xpath("//*[@id='accordionExample' and contains(@style,'none')]");
	By Catalogue_Already_Existed = By
			.xpath("//*[@id='popup-priority-check' and contains(@style,'block')]/div/div/div/div[2]/div[2]/a/button");
	By Invisible_Catalogue_Already_Exists = By
			.xpath("//*[@id='popup-priority-check' and contains(@style,'none')]/div/div/div/div[2]/div[2]/a/button");

// 	Error Discount or Markup
	By Error_Date = By.xpath("//*[contains(@name,'rows[0][date]')]//parent::div//p//strong");
	By Error_Bulk_Price = By.xpath("//*[contains(@name,'rows[0][type]')]//parent::div//p//strong");
	By Error_Discount = By.xpath("//*[contains(@name,'rows[0][price]')]//parent::div//p");
	By Visible_Discount = By
			.xpath("//*[contains(@name,'rows[0][price]')]//parent::div[contains(@style,'none')]//strong");

	// Error Add Event
	By Error_Select_Event = By.xpath("//*[contains(@class,'event_name_form_error')]");
	By Error_Select_From_Date = By.xpath("//*[contains(@class,'from_date_form_error')]");
	By Error_Select_To_Date = By.xpath("//*[contains(@class,'to_date_form_error')]");

//  Error Catalog
	By Error_Catlogue_Select_Date = By.xpath("//*[contains(@class,'date_form_error')]");
	By Error_Catlogue_Hub = By.xpath("//*[contains(@class,'hub_details_form_error')]");
	By Error_Catlogue_Select_Type = By.xpath("//*[contains(@class,'type_form_error')]");
	By Error_Catlogue_Select_Catlogue = By.xpath("//*[contains(@class,'catalogue_id_form_error')]");
	By Error_Catlogue_Product_Field = By.xpath("//*[contains(@class,'product_id_form_error')]");

//	Form Path
	By Hub_Name = By.name("name");
	By State = By.xpath("//*[@id='hubForm']/div[1]/div[2]/div/div[1]/button");
	By Search_State = By.xpath("//*[@id='hubForm']/div[1]/div[2]/div/div[1]/ul/li[1]/div/input");
	By State_CheckBox = By.xpath("//*[@id='hubForm']/div[1]/div[2]/div/div[1]/ul/li[47]/a/label/input");
	By City = By.xpath("//*[@id='hubForm']/div[2]/div/div[1]/span/span[1]/span/ul/li/input");
	By Select_City = By.xpath("//ul[@id='select2-city_namess-results']//child::*[text()='Salt Lake City - UT']");
	By Address1 = By.name("address");
	By DropDownAddress = By.xpath("//*[contains(text(),'Salt Lake City')]//parent::div");
	By Zipcode = By.name("hub_zipcode");
	@FindAll({ @FindBy(xpath = "//*[@id='hub-label']/div[1]/div"),
			@FindBy(xpath = "//*[@id='hubForm']/div[4]/div[2]/div[1]/div") })
	WebElement Hub_City;
	By Hub_State = By.name("hub_state");
	By Phone_Number = By.name("phone_number");
	By Assign_Search_Store = By.xpath("//*[@id='hubForm']/div[6]/div/div[1]/div/ul/li[1]/div/input");
	By Assign_Store = By.xpath("//*[@id='hubForm']/div[6]/div/div[1]/div/button");
	By Assig_Checkbox_Store = By.xpath("//*[@id='hubForm']/div[6]/div/div[1]/div/ul/li[2]/a/label/input");
	By Select_delivery_Schedule = By.xpath("//*[@id='delivery_div_id']/div/div/div/button");
	By Select_First_DS = By.xpath("//*[@id='delivery_div_id']/div/div/div/ul/li[3]/a/label/input");
	By Printer_Name = By.name("printer_name");
	By Printer_IP_Address = By.name("printer");
	By Login = By.name("login_id");
	By Transaction_Key = By.name("transaction_key");
	By Chat_Number = By.id("chat_number_0");
	By Pickup_Schedule = By.id("pickup_anchor");
	By Select_Pickup_Schedule = By.xpath("//*[@id='pickup_div_id']/div/div/div/button");
	By Select_First_PS = By.xpath("//*[@id='pickup_div_id']/div/div/div/ul/li[3]/a/label/input");
	@FindAll({ @FindBy(xpath = "//*[@id='saveDatePriceForm']//div[5]//span[1]//button"),
			@FindBy(xpath = "//*[@id='save-hub']"),
			@FindBy(xpath = "//*[@id='hub_id']//parent::div//div//form//div[5]//span[1]//button"),
			@FindBy(xpath = "//*[@id='base-content-page']/div/div/div/div/form/div[5]/div/span[1]/button") })
	public static WebElement Save_Button;
	By Make_Default_CSR_Number = By.id("default_number_1");

//	field error path
	By Error_Assign_Store = By
			.xpath("//*[text()='Assign Store']//parent::div//child::div[contains(@class,'my_error-msg')]");
	By Error_Hub_Name = By.xpath("//*[contains(@class,'name_form_error') and contains(@style,'display: block;')]");
	By Error_Select_State = By
			.xpath("//*[contains(@class,'state_hub_form_error') and contains(@style,'display: block;')]");
	By Error_Select_City = By
			.xpath("//*[contains(@class,'city_id_form_error') and contains(@style,'display: block;')]");
	By Error_Address1 = By.xpath("//*[contains(@class,'address_form_error') and contains(@style,'display: block;')]");
	By Error_Zipcode = By
			.xpath("//*[contains(@class,'hub_zipcode_form_error') and contains(@style,'display: block;')]");
	By Error_City = By.xpath("//*[contains(@class,'hub_city_form_error') and contains(@style,'display: block;')]");
	By Error_State = By.xpath("//*[contains(@class,'hub_state_form_error') and contains(@style,'display: block;')]");
	By Error_Phone_Number = By
			.xpath("//*[contains(@class,'phone_number_form_error') and contains(@style,'display: block;')]");
	By Error_Delivery_Schedule = By
			.xpath("//*[contains(@class,'delivery_schedule_id_form_error') and contains(@style,'display: block;')]");
	By Error_Pick_Schedule = By
			.xpath("//*[contains(@class,'pickup_schedule_id_form_error') and contains(@style,'display: block;')]");
	By Error_Printer_Name = By
			.xpath("//*[contains(@class,'printer_name_form_error') and contains(@style,'display: block;')]");
	By Error_Printer_Id = By
			.xpath("//*[contains(@class,'printer_id_form_error') and contains(@style,'display: block;')]");
	By Error_Login_Id = By.xpath("//*[contains(@class,'login_id_form_error') and contains(@style,'display: block;')]");
	By Error_Transcation_Key = By
			.xpath("//*[contains(@class,'transaction_key_form_error') and contains(@style,'display: block;')]");
	By Error_Chat_Number = By.id("chat_number_exist_error_chat_number_0");

//	Successfully Message Path
	@FindAll({ @FindBy(xpath = "//*[@id='popup-event-save']/div/div/div/div/div/h2"),
			@FindBy(xpath = "//*[@id='popup-single-save']/div/div/div/h2"),
			@FindBy(xpath = "//*[@id='popup-save-chat']/div/div/div/h2") })
	WebElement CreateMessage;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-event-save']/div/div/div/div/div/p/a/button"),
			@FindBy(xpath = "//*[@id='popup-single-save']/div/div/div/a/button"),
			@FindBy(xpath = "//*[@id='popup-save-chat']/div/div/div/a/button") })
	WebElement CreateClose;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-update-chat']/div/div/div/h2"),
			@FindBy(xpath = "//*[@id='popup-hub-update']/div/div/div/div/div/h2"),
			@FindBy(xpath = "//*[@id='popup-event-update']/div/div/div/div/div/h2") })
	WebElement UpdateMessage;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-update-chat']/div/div/div/a/button"),
			@FindBy(xpath = "//*[@id='popup-hub-update']/div/div/div/div/div/p/a/button"),
			@FindBy(xpath = "//*[@id='popup-event-update']/div/div/div/div/div/p/a/button") })
	WebElement UpdateClose;
	@FindAll({ @FindBy(id = "delete_name"), @FindBy(xpath = "//*[@id='popup-delete-hub']/div/div/div/div/div/h2"),
			@FindBy(xpath = "//*[@id='popup-event-delete']/div/div/div/div/div/h2") })
	WebElement DeleteMessage;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-delete-date']/div/div/div/button"),
			@FindBy(xpath = "//*[@id='popup-delete-hub']/div/div/div/div/div/a/button"),
			@FindBy(xpath = "//*[@id='popup-price-house']/div/div/div/button"),
			@FindBy(xpath = "//*[@id='popup-event-delete']/div/div/div/div/div/p/a/button") })
	WebElement DeleteClose;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-date-delete']/div/div/div[2]/div/a/button"),
			@FindBy(xpath = "//*[@id='delpopup']/div/div/div[2]/div/p/a/button"),
			@FindBy(xpath = "//*[@id='popup-discount-delete']/div/div/div[2]/div/a/button"),
			@FindBy(xpath = "//*[@id='del-event-popup']/div/div/div[2]/div/p/a/button") })
	WebElement DeleteConfirmPopup;

//	List path
	By Three_Dots = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[11]//i");
	@FindAll({ @FindBy(xpath = "//*[@id='date_range_list']//tbody//tr[1]//td[9]//span//a"),
			@FindBy(xpath = "//*[@id='pagination-data-container']//tbody//tr[1]//td[11]//ul[contains(@class,'show')]//li[2]"),
			@FindBy(xpath = "//*[@id='hide-edit-discount']/a/button") })
	WebElement Edit;
	@FindAll({ @FindBy(xpath = "//*[@id='date_range_list']//tbody//tr[1]//td[9]//div//div//a[2]//img"),
			@FindBy(xpath = "//*[@id='pagination-data-container']//tbody//tr[1]//td[11]//ul[contains(@class,'show')]//li[3]"),
			@FindBy(xpath = "//*[@id='csr_customer_chat_list']//tbody//tr[1]//td[6]//div//div//a//img") })
	WebElement Delete;
	public static By List_Hub_Name = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[2]");
	By Search_Box = By.id("searchHub");
	By View = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div/div[1]/div/div/div/div[2]/a/button");
	By Reset = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div/div[1]/div/div/div/div[3]/a/button");
	By Side_Loader = By.xpath("//*[contains(@class,'file-loader') and contains(@style,'display: none;')]");
	By List_No_of_Store = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[4]");
	By List_Chat_Number = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[5]");
	@FindAll({ @FindBy(xpath = "//*[@id='csr_customer_chat_list']//tbody//tr[1]//td[2]"),
			@FindBy(xpath = "//*[@id='date_range_list']//tbody//tr[1]//td[2]") })
	WebElement List_From_Date;
	@FindAll({ @FindBy(xpath = "//*[@id='date_range_list']//tbody//tr[1]//td[3]"),
			@FindBy(xpath = "//*[@id='csr_customer_chat_list']//tbody//tr[1]//td[3]") })
	WebElement List_To_Date;
	By List_Catlogue_Name = By.xpath("//*[@id='date_range_list']//tbody//tr[1]//td[6]");
	By List_Address = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[6]");
	By List_Bulk_Price = By.xpath("//*[@id='csr_customer_chat_list']//tbody//tr[1]//td[4]");
	By List_Discount_Markup = By.xpath("//*[@id='csr_customer_chat_list']//tbody//tr[1]//td[5]");
	By Event_Three_Dots = By
			.xpath("//*[@id='event_list_details']//td//parent::tr[" + eventThreeDots + "]//td[2]//div//i");
	By Event_Edit = By.xpath("//*[@id='event_list_details']//td//parent::tr[" + eventEdit + "]//td[2]//ul//li[1]");
	By Event_Delete = By.xpath("//*[@id='event_list_details']//td//parent::tr[" + eventDelete + "]//td[2]//ul//li[2]");
	By Event_List_Date = By.xpath("//*[@id='event_list_details']//td//parent::tr[" + listRecord + "]//td");
	By Event_List_Name = By.xpath("//*[@id='event_list_details']//td//parent::tr[" + listRecord + "]//td[1]//strong");
	By Event_All_List_Name = By.xpath("//*[@id='event_list_details']//tr");

//	View Page
	By View_Store_Name = By.xpath("//*[@id='hub-store-list']//tbody//tr[1]//td[2]");
	By View_Website_URL = By.xpath("//*[@id='hub-store-list']//tbody//tr[1]//td[3]");
	By View_Phone_Number = By.xpath("//*[@id='hub-store-list']//tbody//tr[1]//td[4]");
	By View_Address = By.xpath("//*[@id='hub-store-list']//tbody//tr[1]//td[5]");
	By View_Chat_Number = By.xpath("//*[@id='csr_customer_chat_list']//tbody//tr[1]//td[2]");

	public String modulePage(String value) throws InterruptedException {
		if (value.equals("Module")) {
			this.clickButton(Hub_Module, 10, "JS Click");
		} else if (value.equals("CreateHubPage")) {
			this.clickButton(Create_Hub, 10, "JS Click");
		} else if (value.equals("EditHubPage") || value.equals("Edit Catalogue")) {
			if (value.equals("EditHubPage")) {
				this.mouseActionClicks(Three_Dots, 10);
			}
			this.mouseActionClicks(Edit, 10);
			if (value.equals("EditHubPage")) {
				this.valuePresentCondition(Hub_Name, 10, hubName);
			} else if (value.equals("Edit Catalogue")) {
				this.valuePresentCondition(Catlogue_Select_Date_Range, 10, dateRange);
			}
		} else if (value.equals("View Store")) {
			this.clickButton(List_No_of_Store, 10, "JS Click");
			this.visible(View_Store_Name, 10);
		} else if (value.equals("View Chat Number")) {
			this.clickButton(List_Chat_Number, 10, "JS Click");
			this.visible(View_Chat_Number, 10);
		} else if (value.equals("Catlogue Date Override List Page")
				|| value.equals("Create Catlogue Date Override List Page")) {
			this.clickButton(Catalogue_Date_Override, 10, "JS Click");
			if (value.equals("Catlogue Date Override List Page")) {
				this.visible(List_From_Date, 10);
			} else if (value.equals("Create Catlogue Date Override List Page")) {
				this.visible(Catlogue_Select_Date_Range, 10);
			}
		} else if (value.equals("Hub View")) {
			this.mouseActionClicks(List_Address, 10);
			this.visible(Add_Discount_Markup, 10);
		} else if (value.equals("Discount or Markup")) {
			this.mouseActionClicks(Add_Discount_Markup, 10);
			this.visible(List_From_Date, 10);
		} else if (value.equals("Create Discount or Markup")) {
			this.mouseActionClicks(Create_Discount_Markup, 10);
			this.visible(Date, 10);
		} else if (value.equals("List Event Management")) {
			this.mouseActionClicks(Event_Manager, 10);
			this.visible(Add_Events, 10);
		} else if (value.equals("Create Add Event")) {
			this.mouseActionClicks(Add_Events, 10);
			this.visible(Select_Event, 10);
		} else if (value.equals("Edit Add Event")) {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			eventThreeDots = Integer.toString(this.listWebElement(Event_All_List_Name, 10).getSize(), -1);
			this.mouseActionClicks(By.xpath("//*[@id='event_list_details']//tr[" + eventThreeDots + "]//td[2]//div//i"),
					10);
			if (!this.conditionChecking(By.xpath(
					"//*[@id='event_list_details']//tr[" + eventThreeDots + "]//td[2]//ul[contains(@class,'show')]"),
					2)) {
				do {
					this.mouseActionClicks(
							By.xpath("//*[@id='event_list_details']//tr[" + eventThreeDots + "]//td[2]//div//i"), 10);
				} while (!this.conditionChecking(By.xpath("//*[@id='event_list_details']//tr[" + eventThreeDots
						+ "]//td[2]//ul[contains(@class,'show')]"), 2));
			}
			this.mouseActionClicks(
					By.xpath("//*[@id='event_list_details']//tr[" + eventThreeDots + "]//td[2]//ul//li[1]"), 10);
			this.visible(Select_Event, 10);
			this.valuePresentCondition(From_Date, 10, startDate);
		}
		return this.getText(Form_Label, 10);
	}

	static String text;

	public String checkError(Object element) {
		int i = 0;
		if (!this.conditionChecking(element, 3)) {
			do {
				this.clickButton(Save_Button, 5, "JS Click");
				i++;
			} while ((!this.conditionChecking(element, 3)) && i < 5);
		}
		if (i == 5) {
			text = "null";
		} else {
			text = this.getText(element, 10);
		}
		return text;
	}

	public String errorField(String value) {
		if (value.equals("Hub Name")) {
			return this.checkError(Error_Hub_Name);
		} else if (value.equals("Select State")) {
			return this.checkError(Error_Select_State);
		} else if (value.equals("Select City")) {
			return this.checkError(Error_Select_City);
		} else if (value.equals("Select State")) {
			return this.checkError(Error_Select_State);
		} else if (value.equals("Address1")) {
			return this.checkError(Error_Address1);
		} else if (value.equals("Zipcode")) {
			return this.checkError(Error_Zipcode);
		} else if (value.equals("City")) {
			return this.checkError(Error_City);
		} else if (value.equals("State")) {
			return this.checkError(Error_State);
		} else if (value.equals("Phone Number")) {
			return this.checkError(Error_Phone_Number);
		} else if (value.equals("Delivery Schedule")) {
			return this.checkError(Error_Delivery_Schedule);
		} else if (value.equals("Pickup Schedule")) {
			return this.checkError(Error_Pick_Schedule);
		} else if (value.equals("Printer Name")) {
			return this.checkError(Error_Printer_Name);
		} else if (value.equals("Printer Id")) {
			return this.checkError(Error_Printer_Id);
		} else if (value.equals("Login Id")) {
			return this.checkError(Error_Login_Id);
		} else if (value.equals("Transcation Key")) {
			return this.checkError(Error_Transcation_Key);
		} else if (value.equals("Select Date Range")) {
			this.clickButton(Save_Button, 10, "JS Click");
			return this.checkError(Error_Catlogue_Select_Date);
		} else if (value.equals("Catlogue Hub")) {
			return this.checkError(Error_Catlogue_Hub);
		} else if (value.equals("Catlogue Select Type")) {
			return this.checkError(Error_Catlogue_Select_Type);
		} else if (value.equals("Select Catlogue")) {
			this.clickButton(Catlogue_Select_Type, 10, "JS Click");
			return this.checkError(Error_Catlogue_Select_Catlogue);
		} else if (value.equals("Catlogue Product")) {
			return this.checkError(Error_Catlogue_Product_Field);
		} else if (value.equals("Date")) {
			return this.checkError(Error_Date);
		} else if (value.equals("Bulk Price")) {
			return this.checkError(Error_Bulk_Price);
		} else if (value.equals("Discount")) {
			this.dropDownByIndex(Bulk_Price, 10, 1);
			this.invisible(Visible_Discount, 10);
			this.clickButton(Save_Button, 5, "JS Click");
			return this.checkError(Error_Discount);
		} else if (value.equals("Select Event")) {
			return this.checkError(Error_Select_Event);
		} else if (value.equals("Select From Date")) {
			return this.checkError(Error_Select_From_Date);
		} else if (value.equals("Select To Date")) {
			return this.checkError(Error_Select_To_Date);
		}
		return value;
	}

	public void clearField(String value) {
		if (value.equals("Hub Name")) {
			this.clearField(Hub_Name, 10);
		} else if (value.equals("Address1")) {
			this.clearField(Address1, 10);
		} else if (value.equals("Zipcode")) {
			this.clearField(Zipcode, 10);
		} else if (value.equals("Address1")) {
			this.clearField(Address1, 10);
		} else if (value.equals("State")) {
			this.clearField(State, 10);
		} else if (value.equals("Phone Number")) {
			this.clearField(Phone_Number, 10);
		} else if (value.equals("Printer Name")) {
			this.clearField(Printer_Name, 10);
		} else if (value.equals("Printer ID")) {
			this.clearField(Printer_IP_Address, 10);
		} else if (value.equals("Login")) {
			this.clearField(Login, 10);
		} else if (value.equals("Transcation Key")) {
			this.clearField(Transaction_Key, 10);
		} else if (value.equals("Chat Number")) {
			this.clearField(Chat_Number, 10);
		} else if (value.equals("Select Date Range")) {
			this.clearField(Catlogue_Select_Date_Range, 10);
		} else if (value.equals("Date")) {
			this.clearField(Date, 10);
		} else if (value.equals("Discount")) {
			this.clearField(Discount, 10);
		} else if (value.equals("Select Event")) {
			this.dropDownByIndex(Select_Event, 10, 0);
		} else if (value.equals("Select From Date")) {
			this.clearField(From_Date, 10);
		} else if (value.equals("Select To Date")) {
			this.clearField(To_Date, 10);
		} else if (value.equals("Description")) {
			this.clearField(Description, 10);
		}
	}

	public String editPrepopulate(String value) {
		if (value.equals("Hub Name")) {
			return this.getTextAttribute(Hub_Name, 10);
		} else if (value.equals("Address1")) {
			return this.getTextAttribute(Address1, 10);
		} else if (value.equals("Zipcode")) {
			return this.getTextAttribute(Zipcode, 10);
		} else if (value.equals("City")) {
			return this.getTextAttribute(City, 10);
		} else if (value.equals("State")) {
			return this.getTextAttribute(State, 10);
		} else if (value.equals("Phone Number")) {
			return this.getTextAttribute(Phone_Number, 10);
		} else if (value.equals("Printer Name")) {
			return this.getTextAttribute(Printer_Name, 10);
		} else if (value.equals("Printer IP Address")) {
			return this.getTextAttribute(Printer_IP_Address, 10);
		} else if (value.equals("Login ID")) {
			return this.getTextAttribute(Login, 10);
		} else if (value.equals("Transcation Key")) {
			return this.getTextAttribute(Transaction_Key, 10);
		} else if (value.equals("Select Date Range")) {
			return this.getTextAttribute(Catlogue_Select_Date_Range, 10);
		} else if (value.equals("Date")) {
			return this.getTextAttribute(Date, 10);
		} else if (value.equals("Discount")) {
			return this.getTextAttribute(Discount, 10);
		} else if (value.equals("Select Event")) {
			return this.getTextAttribute(Select_Event, 10);
		} else if (value.equals("Select From Date")) {
			return this.getTextAttribute(From_Date, 10);
		} else if (value.equals("Select To Date")) {
			return this.getTextAttribute(To_Date, 10);
		} else if (value.equals("Description")) {
			return this.getTextAttribute(Description, 10);
		}
		return value;
	}

	static int integerValue;

	public String validRecords(String value) throws IOException, InterruptedException {
		if (value.equals("Create") || value.equals("Edit")) {
			this.inputText(Hub_Name, randomCharacters("Dummy Hub Name"), 10);
			hubName = this.getTextAttribute(Hub_Name, 10);
			if (value.equals("Create")) {
				this.clickButton(State, 10, "JS Click");
				this.inputText(Search_State, "utah", 10);
				this.clickButton(State_CheckBox, 10, "JS Click");
				this.inputText(City, "Salt Lake City", 10);
				this.mouseActionClicks(Select_City, 10);
			}
			this.inputText(Address1, "salt lake city", 10);
			if (!this.conditionChecking(DropDownAddress, 5)) {
				do {
					this.clearField("Address1");
					this.inputText(Address1, "salt lake", 10);
				} while (!this.conditionChecking(DropDownAddress, 5));
			}
			this.mouseActionClicks(DropDownAddress, 10);
			Thread.sleep(2000);
			address1 = this.getTextAttribute(Address1, 10);
			Thread.sleep(2000);
			if (!(this.getTextAttribute(Zipcode, 10).length() > 1)) {
				this.inputText(Zipcode, "84112", 10);
			}
			zipcode = this.getTextAttribute(Zipcode, 10);
			city = this.getTextAttribute(Hub_City, 10);
			state = this.getTextAttribute(Hub_State, 10);
			this.inputText(Phone_Number, dummyData("Phone Number"), 10);
			phoneNumber = this.getTextAttribute(Phone_Number, 10);
			if (value.equals("Create")) {
				this.clickButton(Assign_Store, 10, "JS Click");
				this.inputText(Assign_Search_Store, getUpdatedPropertyFile("Store Page", "StoreName"), 10);
				this.clickButton(Assig_Checkbox_Store, 10, "JS Click");
				assignStore = this.getTextAttribute(Assign_Store, 10);
				this.clickButton(Select_delivery_Schedule, 10, "JS Click");
				this.clickButton(Select_First_DS, 10, "JS Click");
				deliverySchedule = this.getTextAttribute(Select_delivery_Schedule, 10);
				this.clickButton(Pickup_Schedule, 10, "JS Click");
				this.clickButton(Select_Pickup_Schedule, 10, "JS Click");
				this.clickButton(Select_First_PS, 10, "JS Click");
				pickupSchedule = this.getTextAttribute(Select_Pickup_Schedule, 10);
			}
			this.inputText(Printer_Name, randomCharacters("Dummy Printer Name"), 10);
			printerName = this.getTextAttribute(Printer_Name, 10);
			this.inputText(Printer_IP_Address, randomCharacters("Dummy IP Address"), 10);
			printerIP = this.getTextAttribute(Printer_IP_Address, 10);
			this.inputText(Login, getPropertyValue("LoginID"), 10);
			this.inputText(Transaction_Key, getPropertyValue("TranscationKey"), 10);
			if (value.equals("Create")) {
				this.inputText(Chat_Number, randomCharacters("Max 10 Characters"), 10);
				chatNumber = this.getTextAttribute(Chat_Number, 10);
				this.propertyInputValue("Hub Property", "ChatNumber", chatNumber);
				this.clickButton(Make_Default_CSR_Number, 10, "JS Click");
			}
		} else if (value.equals("Catlogue Create") || value.equals("Catalogue Update")) {
			if (value.equals("Catlogue Create")) {
				viewRecord = getUpdatedPropertyFile("Catlogue Page", "CatlogueName");
				String dummyRecords = this.getUpdatedPropertyFile("Dummy Page", "RandomNumber");
				if (dummyRecords == null) {
					return num;
				} else {
					num = dummyRecords;
				}
				integerValue = Integer.parseInt(num);
			}
			this.inputText(Catlogue_Select_Date_Range, dateFormat(integerValue) + " to " + dateFormat(integerValue + 1),
					10);
			if (value.equals("Catlogue Create")) {
				dateRange = this.getTextAttribute(Catlogue_Select_Date_Range, 10);
				this.clickButton(Catlogue_Hub_List_Field, 10, "JS Click");
				if (!this.conditionChecking(Catlogue_Hub_List_Visible, 3)) {
					do {
						this.clickButton(Catlogue_Hub_List_Field, 10, "JS Click");
					} while (!this.conditionChecking(Catlogue_Hub_List_Visible, 3));
				}
				this.clickButton(Catlogue_Hub_CheckBox, 10, "JS Click");
				this.clickButton(Select_Catlogue, 10, "JS Click");
				if (!this.conditionChecking(Visible_Catalogue_Dropdown, 3)) {
					do {
						this.clickButton(Select_Catlogue, 10, "JS Click");
					} while (!this.conditionChecking(Visible_Catalogue_Dropdown, 3));
				}
				String num = Integer.toString(integerValue + 1);
				this.propertyInputValue("Dummy Property", "RandomNumber", num);
				int listWebElement = this.listWebElement(
						By.xpath("//*[@id='catalogueListDateDropdown']//following-sibling::div//ul//li//label"), 10)
						.getSize();
				int path = listWebElement + 1;
				catalogueName = this.getText(
						By.xpath("//*[@id='catalogueListDateDropdown']//following-sibling::div//ul//li[" + path + "]"),
						10);
				this.mouseActionClicks(
						By.xpath("//*[@id='catalogueListDateDropdown']//following-sibling::div//ul//li[" + path + "]"),
						10);
				this.invisible(Catelogue_Visible, 10);
			}
		} else if (value.equals("Create Discount or Markup")) {
			this.inputText(Date, dateFormat(0) + " to " + dateFormat(1), 10);
			dateRange = this.getTextAttribute(Date, 10);
			this.inputText(Discount, randomCharacters("Max 2 Characters"), 10);
			discount = this.getTextAttribute(Discount, 10);
			if (this.getTextAttribute(Discount, 10).equals("00")) {
				do {
					this.clearField("Discount");
					this.inputText(Discount, randomCharacters("Max 2 Characters"), 10);
					discount = this.getTextAttribute(Discount, 10);
				} while (this.getTextAttribute(Discount, 10).equals("00"));
			}
		} else if (value.equals("Create Event")) {
			this.dropDownByIndex(Select_Event, 10, 1);
			String dummyRecords = this.getUpdatedPropertyFile("Dummy Page", "RandomNumber");
			if (dummyRecords == null) {
				return num;
			} else {
				num = dummyRecords;
			}
			integerValue = Integer.parseInt(num);
			selectEvent = this.getTextAttribute(Select_Event, 10);
			this.inputText(From_Date, dateFormat(integerValue + 1).replace("/", "-"), 10);
			startDate = this.getTextAttribute(From_Date, 10);
			this.inputText(To_Date, dateFormat(integerValue + 1).replace("/", "-"), 10);
			endDate = this.getTextAttribute(To_Date, 10);
			this.inputText(Description, randomCharacters("Dummy Description").trim(), 10);
			description = this.getTextAttribute(Description, 10);
			String num = Integer.toString(integerValue + 1);
			this.propertyInputValue("Dummy Property", "RandomNumber", num);
		}
		this.clickButton(Save_Button, 10, "JS Click");
		return value;
	}

	public String submissionValidation(String value) throws IOException {
		Boolean conditionCheck = true;
		if (value.equals("Create") || value.equals("Edit")) {
			if (this.conditionChecking(CreateMessage, 10) || this.conditionChecking(UpdateMessage, 10)) {
			} else {
				do {
					if (this.conditionChecking(Error_Hub_Name, 2) || this.conditionChecking(Error_Printer_Id, 2)
							|| this.conditionChecking(Error_Chat_Number, 2)
							|| this.conditionChecking(Error_Select_State, 2)) {
						if (this.getText(Error_Hub_Name, 5).equals(getPropertyValue("ExistingHubName"))) {
							this.clearField("Hub Name");
							this.inputText(Hub_Name, randomCharacters("Dummy Hub Name"), 10);
							hubName = this.getTextAttribute(Hub_Name, 10);
						} else if (this.getText(Error_Printer_Id, 5).equals(getPropertyValue("ExistingPrinterID"))) {
							this.clearField("Printer ID");
							this.inputText(Printer_IP_Address, randomCharacters("Dummy IP Address"), 10);
							printerIP = this.getTextAttribute(Printer_IP_Address, 10);
						} else if (this.getText(Error_Chat_Number, 5).equals(getPropertyValue("ExistingChatNumber"))) {
							this.clearField("Chat Number");
							this.inputText(Chat_Number, randomCharacters("Max 10 Characters"), 10);
						} else if (this.getText(Error_Select_State, 5).equals(getPropertyValue("MandatoryState"))) {
							this.clickButton(State, 10, "JS Click");
							this.inputText(Search_State, "utah", 10);
							this.clickButton(State_CheckBox, 10, "JS Click");
						}
					} else if (this.conditionChecking(Catalogue_Already_Existed, 5)) {
						do {
							this.clickButton(Catalogue_Already_Existed, 10, "JS Click");
						} while (!this.invisibleConditionChecking(Catalogue_Already_Existed, 5));
					}
					if (this.conditionChecking(Save_Button, 3)) {
						this.clickButton(Save_Button, 10, "JS Click");
					}
					if (this.conditionChecking(CreateMessage, 10) || this.conditionChecking(UpdateMessage, 10)) {
						conditionCheck = false;
					}
				} while (conditionCheck);
			}
			if (value.equals("Create")) {
				String text = this.getText(CreateMessage, 10);
				this.clickButton(CreateClose, 10, "JS Click");
				return text;
			} else if (value.equals("Edit")) {
				String text = this.getText(UpdateMessage, 10);
				this.clickButton(UpdateClose, 10, "JS Click");
				return text;
			}
		} else if (value.equals("Delete") || value.equals("Delete Catalogue")
				|| value.equals("Delete Discount or Markup") || value.equals("Event Manager Delete")) {
			if (value.equals("Delete")) {
				this.mouseActionClicks(Three_Dots, 10);
			} else if (value.equals("Event Manager Delete")) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				eventThreeDots = Integer.toString(this.listWebElement(Event_All_List_Name, 10).getSize() - 1);
				this.mouseActionClicks(
						By.xpath("//*[@id='event_list_details']//tr[" + eventThreeDots + "]//td[2]//div//i"), 10);
				if (!this.conditionChecking(By.xpath("//*[@id='event_list_details']//tr[" + eventThreeDots
						+ "]//td[2]//ul[contains(@class,'show')]"), 2)) {
					do {
						this.mouseActionClicks(
								By.xpath("//*[@id='event_list_details']//tr[" + eventThreeDots + "]//td[2]//div//i"),
								10);
					} while (!this.conditionChecking(By.xpath("//*[@id='event_list_details']//tr[" + eventThreeDots
							+ "]//td[2]//ul[contains(@class,'show')]"), 2));
				}
				this.mouseActionClicks(
						By.xpath("//*[@id='event_list_details']//tr[" + eventThreeDots + "]//td[2]//ul//li[2]"), 10);
			}
			if (value.equals("Delete") || value.equals("Delete Catalogue")
					|| value.equals("Delete Discount or Markup")) {
				this.mouseActionClicks(Delete, 10);
			}
			this.mouseActionClicks(DeleteConfirmPopup, 10);
			String text = this.getText(DeleteMessage, 10);
			this.mouseActionClicks(DeleteClose, 10);
			return text;

		}
		return value;
	}

	public static String listRecord;
	static String[] split;

	public String listValidation(String value) {
		if (value.equals("Search Box")) {
			this.inputText(Search_Box, listRecord, 10);
			this.clickButton(View, 10, "JS Click");
		} else if (value.equals("List Hub Name")) {
			listRecord = this.getText(List_Hub_Name, 10);
		} else if (value.equals("Invalid Record")) {
			listRecord = "dflkjdsflkjfsd";
		} else if (value.equals("Search")) {
			this.clearField(Search_Box, 10);
		} else if (value.equals("ListInvalid")) {
			if (this.conditionChecking(By.xpath("//*[text()='No Records']"), 10)) {
				listRecord = this.getText(By.xpath("//*[text()='No Records']"), 10);
			} else {
				listRecord = "null";
			}
		} else if (value.equals("Reset")) {
			this.clickButton(Reset, 10, "JS Click");
		} else if (value.equals("Back")) {
			this.clickButton(Form_Label, 10, "JS Click");
		} else if (value.equals("Catalogue From Date")) {
			listRecord = this.getText(List_From_Date, 10);
		} else if (value.equals("Catalogue To Date")) {
			listRecord = this.getText(List_To_Date, 10);
		} else if (value.equals("Catalogue Name")) {
			listRecord = this.getText(List_Catlogue_Name, 10);
		} else if (value.equals("Start Date Records")) {
			split = dateRange.split(" to ");
			listRecord = split[0];
		} else if (value.equals("End Date Records")) {
			listRecord = split[1];
		} else if (value.equals("Discount")) {
			listRecord = this.getText(List_Discount_Markup, 10);
		} else if (value.equals("Event")) {
			listRecord = Integer.toString(this.listWebElement(Event_All_List_Name, 10).getSize() - 1);
			listRecord = this.getText(By.xpath("//*[@id='event_list_details']//tr[" + listRecord + "]//td//strong"),
					10);
		} else if (value.equals("Date")) {
			int date = this.listWebElement(Event_All_List_Name, 10).getSize();
			listRecord = Integer.toString(date);
			listRecord = this.getText(By.xpath("//*[@id='event_list_details']//tr[" + listRecord + "]//td"), 10);
		}
		return listRecord;
	}

	public String hubNameField(String value) throws InterruptedException {
		if (value.equals("Unique Validation")) {
			String text = this.getText(List_Hub_Name, 10);
			this.modulePage("CreateHubPage");
			this.inputText(Hub_Name, text, 10);
			this.inputText(Printer_IP_Address, printerIP, 10);
			this.clickButton(Save_Button, 10, "JS Click");
			return this.getText(Error_Hub_Name, 10);
		}
		return value;
	}

	public String printerIDField(String value) {
		if (value.equals("Unique Validation")) {
			return this.getText(Error_Printer_Id, 10);
		}
		return value;
	}

	public void discountField(String value) throws IOException {
		if (value.equals("Zero Validation")) {
			this.inputText(Discount, "10", 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisible(Error_Discount, 10);
			this.clearField("Discount");
			this.inputText(Discount, "00", 10);
			this.clickButton(Save_Button, 10, "JS Click");
		}
	}

	public void eventUniqueValidation() throws InterruptedException {
		this.modulePage("Create Add Event");
		this.dropDownByIndex(Select_Event, 10, 1);
		this.inputText(From_Date, startDate, 10);
		this.inputText(To_Date, endDate, 10);
		this.clickButton(Save_Button, 10, "JS Click");
	}

	public void selectToDateEvent(String value) {
		if (value.equals("Invalid")) {
			this.dropDownByIndex(Select_Event, 10, 1);
			this.inputText(From_Date, dateFormat(0).replace("/", "-"), 10);
			this.inputText(To_Date, dateFormat(-1).replace("/", "-"), 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisible(By.xpath("//*[text()='The to date field is required.']"), 10);
		}
	}

	static List<String> asList;

	public void clearAllFields() {
		if (this.conditionChecking(Phone_Number, 1)) {
			this.mouseActionClicks(Phone_Number, 10);
			asList = Arrays.asList("Hub Name", "Address1", "Zipcode", "Phone Number", "Printer Name", "Printer ID",
					"Login", "Transcation Key");
		} else if (this.conditionChecking(Date, 1)) {
			asList = Arrays.asList("Date", "Discount");
		} else if (this.conditionChecking(Select_Event, 1)) {
			asList = Arrays.asList("Select Event", "Select From Date", "Select To Date", "Description");
		}
		for (int i = 0; i < asList.size(); i++) {
			this.clearField(asList.get(i));
		}
	}

	public String viewAllStore(String value) {
		switch (value) {
		case "Store Name":
			viewRecord = this.getText(View_Store_Name, 10);
			break;
		case "Website URL":
			viewRecord = this.getText(View_Website_URL, 10);
			break;
		case "Phone Number":
			viewRecord = this.getText(View_Phone_Number, 10);
			break;
		case "Adress":
			viewRecord = this.getText(View_Address, 10);
			break;
		case "CSR Chat Number":
			viewRecord = this.getText(View_Chat_Number, 10);
			break;
		default:
			break;
		}
		return viewRecord;
	}

}
