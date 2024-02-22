package org.kona.pageobjectclass;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Delivery_Schedule_Page extends BaseClass {
	public static String records;
	public static String deliveryScheduleName;
	public static String description;
	public static String fromTime;
	public static String toTime;
	public static String cuttoffTime;
	public static String deliveryValue;

	@SuppressWarnings("static-access")
	public Delivery_Schedule_Page(WebDriver driver) {
		this.driver = driver;
	}

//	Navigation Form
	By DeliverySchedule = By.id("delivery_schedule_side_bar");
	@FindAll({ @FindBy(xpath = "//h4[text()='Delivery Schedule']"), @FindBy(xpath = "//*[text()=' Create Schedule']"),
			@FindBy(xpath = "//a[text()=' Edit schedule']"), @FindBy(xpath = "//a[text()='Add Time Slot']") })
	public static WebElement Form_Label;
	By CreateSchedule = By.xpath("//div[@id='base-content-page']//div//nav//div//div//div[2]//div");
	By Radio_Button = By.xpath("//*[@id='check-box-one']/label[2]/span");

//	Navigation for Delivery schedule
	By AddTimeSlot = By.xpath("//button[text()='Add Time Slot']");

//	TimeSlotForm
	@FindAll({ @FindBy(name = "ready_by_time"), @FindBy(name = "from_time") })
	public static WebElement From_Time;
	@FindAll({ @FindBy(name = "to_time") })
	WebElement To_Time;
	@FindAll({ @FindBy(name = "ready_by_cut_off_time"), @FindBy(name = "cut_off_time") })
	WebElement Cut_Off_Time;
	@FindAll({ @FindBy(name = "rows[0][delivery_value]"), @FindBy(name = "delivery_value") })
	WebElement Delivery_Value_Pay;

//	Custom Delivery Time Frame
	By Add_Custom_Deliver_TimeFrame = By.xpath("//*[@id='base-content-page']/div/div/div/div/div[3]/button[2]");
	By Custome_Select_Days = By.name("days");
	By Custome_Select_Hours = By.name("advanced_hours");
	By Custome_Miniumum_Select_Hours = By.name("minimum_delivery_window");
	By Custome_Order_Value = By.name("rows[0][order_value]");

//	Form Schedule Page
	public static By Delivery_Schedule_Name = By.name("delivery_name");
	By Description = By.name("description");
	By State_Select = By.xpath("//*[@id='zipcode_states_list']//div[17]//div//input");
	By Invisible_State = By.xpath("//*[@id='zipcode_cities_list_name_id'and contains(@style,'none')]");
	By City_Select = By.xpath(
			"//*[@id='delivery_zipcode']//div[@id='zipcode_cities_list']//span[text()='S']//parent::div//div[text()='Salt Lake City']//input");
	By Invisible_City = By.xpath("//*[@id='zipcode_zip_list_name_id' and contains(@style,'none')]");
	By Zipcode_Select = By.xpath("//*[text()='84112']//input");
	By State_Field = By.id("zipcode_states_select");
	By City_Field = By.id("zipcode_cities_select");
	By Zipcode_Field = By.id("zipcode_zips_select");
	By Select_Product = By.xpath("//*[@id='product_delivery_schedule_hide']/div[1]/div/div/button");
	By Product_List_Show = By.xpath("//*[@id='getDelivery']//following::div[contains(@class,'open')]");
	By Select_Product_Checkbox = By
			.xpath("//*[@id='product_delivery_schedule_hide']/div[1]/div/div/ul/li[2]/a/label/input");
	By Select_Day = By.id("product_days");
	@FindAll({ @FindBy(name = "advanced_hours"), @FindBy(id = "product_hours") })
	WebElement Select_Hours;
	@FindAll({ @FindBy(xpath = "//*[text()='Save ']"), @FindBy(xpath = "//*[text()='Update ']"),
			@FindBy(xpath = "//*[text()='Add ']") })
	public static WebElement Save_Button;

//	Error Field
	By Error_Delivery_Schedule = By.xpath("//*[contains(@class,'delivery_name_form_error')]");
	@FindAll({ @FindBy(xpath = "//*[text()='The hours field is required.']"),
			@FindBy(xpath = "//*[contains(@class,'product_hours_form_error')]") })
	WebElement Error_Select_Hours;
	By Error_Time_Slot = By.xpath("//*[contains(@class,'time_slot_form_error')]");
	@FindAll({ @FindBy(xpath = "//*[@id='sunday']/div[1]/div[1]/div[2]/strong"),
			@FindBy(xpath = "//*[contains(@class,'from_time_form_error')]") })
	WebElement Error_From_Time;
	@FindAll({ @FindBy(xpath = "//*[contains(@class,'to_time_form_error')]"),
			@FindBy(xpath = "//*[contains(@class,'ready_by_cut_off_time_form_error') and contains(@style,'block')]") })
	WebElement Error_To_Time;
	By Error_TimeSlot_Cutoff_Time = By.xpath("//*[contains(@class,'cut_off_time_form_error')]");
	By Error_TimeSlot_Delivery_Type = By.xpath("//*[contains(@class,'delivery_value_form_error')]");
	@FindAll({ @FindBy(xpath = "//*[contains(@class,'delivery_value_form_error')]"),
			@FindBy(xpath = "//*[@name='rows[0][delivery_value]']//parent::div//strong") })
	WebElement Error_Delivery_Value;
	By Error_Hours = By.xpath("//*[contains(@class,'product_hours_form_error')]");
	@FindAll({
			@FindBy(xpath = "//*[contains(@class,'minimum_delivery_window_form_error') and contains(@style,'block')]"),
			@FindBy(xpath = "//*[text()='Minimum order delivery window should be 05 hrs 00 mins']") })
	WebElement Error_Min_Delivery_Window;
	By Error_Order_Value = By.xpath("//*[@id='order_value_1']//parent::div//strong");

//	List Page
	By Search_Box = By.id("userSearch");
	By List_Schedule_Type_Filter = By.xpath("//*[@id='schedule_type_filter']//following-sibling::div");
	By Check_Box_Delivery_Schedule = By.xpath(
			"//*[@id='base-content-page']/div[1]/div/div[1]/div/div/div/div/div[1]/div/div/div[2]/div/ul/li[2]/a/label/input");
	By Check_Box_PickUp_Schedule = By.xpath(
			"//*[@id='base-content-page']/div[1]/div/div[1]/div/div/div/div/div[1]/div/div/div[2]/div/ul/li[3]/a/label/input");
	By View = By.xpath("//*[@id='base-content-page']/div[1]/div/div[1]/div/div/div/div/div[2]/a/button");
	By List_Schedule_Name = By.xpath("//*[@id='pagination-data-container']/thead/tr[2]/td[2]");
	By List_Schedule_Type = By.xpath("//*[@id='pagination-data-container']/thead/tr[2]/td[3]");
	By Reset = By.xpath("//*[@id='base-content-page']/div[1]/div/div[1]/div/div/div/div/div[3]/a/button");
	@FindAll({ @FindBy(xpath = "//*[@id='sunday_row_id']/div[1]/div/div/div[3]/button/i"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/thead/tr[2]//td[6]//i") })
	WebElement ThreeDots;
	By Edit = By.xpath("//*[@id='pagination-data-container']/thead/tr[2]/td[6]/div/ul/li[1]");
	@FindAll({ @FindBy(xpath = "//*[@id='sunday_row_id']/div[1]/div/div/div[3]/div/ul/a[2]"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/thead/tr[2]/td[6]/div/ul/li[2]") })
	WebElement Delete;
	@FindAll({ @FindBy(xpath = "//*[@id='popup-time-slot-delete']/div/div/div[2]/div/a/button"),
			@FindBy(xpath = "//*[@id='popup-delivery-schedule-delete']/div/div/div[2]/div/a/button") })
	WebElement DeleteConfirm;
	By Side_Loader = By.xpath("//*[contains(@class,'file-loader') and contains(@style,'display: none;')]");

//	Successful Message
	By Delivery_Schedule_Create_Message = By.xpath("//*[@id='save_schedule_id']");
	By Delivery_Close_Create = By.xpath("//*[@id='popup-save']/div/div/div/div/div/a/button");
	By Delivery_Schedule_Update_Message = By.xpath("//*[@id='edit_schedule_id']");
	By Delivery_Close_Update = By.xpath("//*[@id='popup-update']/div/div/div/div/div/a/button");
	By Delivery_Schedule_Delete_Message = By.xpath("//*[@id='deleted_schedule_id']");
	By Delivery_Close_Delete = By.xpath("//*[@id='popup-delete-user']/div/div/div/div/div/a/button");
	By Create_Time_Slot_Message = By.xpath("//*[@id='popup-time-slot-save']/div/div/div/div/div/h2");
	By Close_Time_Slot = By.xpath("//*[@id='popup-time-slot-save']/div/div/div/div/div/a/button");

	public String modulePage(String value) throws InterruptedException {
		if (value.equals("Module")) {
			this.clickButton(DeliverySchedule, 10, "JS Click");
		} else if (value.equals("CreatePage") || value.equals("Pick Up Page")) {
			this.mouseActionClicks(CreateSchedule, 10);
			if (!this.conditionChecking(Delivery_Schedule_Name, 3)) {
				do {
					this.clickButton(CreateSchedule, 10, "JS Click");
				} while (!this.conditionChecking(Delivery_Schedule_Name, 3));
			}
			if (value.equals("Pick Up Page")) {
				this.clickButton(Radio_Button, 10, "JS Click");
			}
		} else if (value.equals("EditPage")) {
			this.mouseActionClicks(ThreeDots, 10);
			this.mouseActionClicks(Edit, 10);
			this.visible(Delivery_Schedule_Name, 10);
			this.valuePresentCondition(Delivery_Schedule_Name, 10, deliveryScheduleName);
			Thread.sleep(3000);
			if (!(this.getTextAttribute(Delivery_Schedule_Name, 10).length() > 0)) {
				do {
					this.clearField("Delivery Schedule Name");
					Thread.sleep(3000);
				} while (!(this.getTextAttribute(Delivery_Schedule_Name, 10).length() > 0));
			}
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
		if (value.equals("Delivery Schedule")) {
			return this.checkError(Error_Delivery_Schedule);
		} else if (value.equals("Time Slot")) {
			return this.checkError(Error_Time_Slot);
		} else if (value.equals("Select Hours")) {
			return this.checkError(Error_Select_Hours);
		} else if (value.equals("From Time")) {
			return this.checkError(Error_From_Time);
		} else if (value.equals("To Time")) {
			return this.checkError(Error_To_Time);
		} else if (value.equals("Cutoff Time")) {
			return this.checkError(Error_TimeSlot_Cutoff_Time);
		} else if (value.equals("Delivery Value")) {
			return this.checkError(Error_Delivery_Value);
		} else if (value.equals("Minimum Delivery")) {
			return this.checkError(Error_Min_Delivery_Window);
		} else if (value.equals("Order Value")) {
			return this.checkError(Error_Order_Value);
		}
		return value;
	}

	public void clearField(String value) {
		switch (value) {
		case "From Time":
			this.clearField(From_Time, 10);
			break;
		case "To Time":
			this.clearField(To_Time, 10);
			break;
		case "Cutoff Time":
			this.clearField(Cut_Off_Time, 10);
			break;
		case "Delivery Value":
			this.clearField(Delivery_Value_Pay, 10);
			break;
		case "Delivery Schedule Name":
			this.clearField(Delivery_Schedule_Name, 10);
			break;
		case "Description":
			this.clearField(Description, 10);
			break;
		case "Order Value":
			this.clearField(Custome_Order_Value, 10);
			break;
		case "Search Box":
			this.clearField(Search_Box, 10);
			break;
		case "Time Slot":
			this.mouseAction(ThreeDots, 10);
			this.clickButton(Delete, 10, "JS Click");
			this.clickButton(DeleteConfirm, 10, "JS Click");
			break;
		case "Select Hours":
			this.dropDownByIndex(Select_Hours, 10, 0);
			break;
		default:
			break;
		}
	}

	public String valuePrepopulate(String value) {
		switch (value) {
		case "Delivery Schedule Name":
			deliveryScheduleName = this.getTextAttribute(Delivery_Schedule_Name, 10);
			break;
		case "Description":
			description = this.getTextAttribute(Description, 10);
			break;
		case "From Time":
			fromTime = this.getTextAttribute(From_Time, 10);
			break;
		case "To Time":
			toTime = this.getTextAttribute(To_Time, 10);
			break;
		case "Cutoff Time":
			cuttoffTime = this.getTextAttribute(Cut_Off_Time, 10);
			break;
		case "Delivery Value":
			deliveryValue = this.getTextAttribute(Delivery_Value_Pay, 10);
			break;
		default:
			break;
		}
		return records;
	}

	public void mandatoryValidation(String value) throws IOException, InterruptedException {
		switch (value) {
		case "Time Slot":
			this.inputText(Delivery_Schedule_Name, randomCharacters("Dummy Delivery Schedule Name"), 10);
			deliveryScheduleName = this.getTextAttribute(Delivery_Schedule_Name, 10);
			this.clickButton(Save_Button, 10, "JS Click");
			break;
		case "Select Hours":
			this.clickButton(Select_Product, 10, "JS Click");
			if (!this.conditionChecking(Product_List_Show, 3)) {
				do {
					this.clickButton(Select_Product, 10, "JS Click");
				} while (!this.conditionChecking(Product_List_Show, 3));
			}
			this.clickButton(Select_Product_Checkbox, 10, "JS Click");
			this.dropDownByIndex(Select_Day, 10, 3);
			break;
		case "Add Time Slot Fields":
			this.clickButton(AddTimeSlot, 10, "JS Click");
			if (!this.conditionChecking(From_Time, 3)) {
				do {
					this.clickButton(AddTimeSlot, 10, "JS Click");
				} while (!this.conditionChecking(From_Time, 3));
			}
			this.visible(From_Time, 10);
			break;
		case "To Time Slot":
			this.inputText(From_Time, randomCharacters("1 Hour Timing"), 10);
			this.inputText(To_Time, randomCharacters("Past Timing"), 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisible(By.xpath("//*[text()='The to time field is required.']"), 10);
			break;
		case "Cutoff Time":
			this.inputText(Cut_Off_Time, randomCharacters("Invalid Timing"), 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisible(By.xpath("//*[text()='The cut off time field is required.']"), 10);
			break;
		case "Delivery Value 0":
			this.inputText(Delivery_Value_Pay, "00", 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisible(By.xpath("//*[text()='The delivery value field is required.']"), 10);
			break;
		case "Delivery Value 0 Character":
			this.inputText(Delivery_Value_Pay, "dsfsdfdsf", 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisible(By.xpath("//*[text()='The delivery value must be greater than 0.']"), 10);
			break;
		case "Add Custome Slot":
			this.clickButton(Add_Custom_Deliver_TimeFrame, 10, "JS Click");
			if (!this.conditionChecking(From_Time, 3)) {
				do {
					this.clickButton(Add_Custom_Deliver_TimeFrame, 10, "JS Click");
				} while (!this.conditionChecking(From_Time, 3));
			}
			this.visible(From_Time, 10);
			break;
		case "Custome To Time":
			this.dropDownByIndex(To_Time, 10, 3);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisible(By.xpath("//*[text()='" + getPropertyValue("MandatoryToTime") + "']"), 10);
			break;
		case "Delivery Charges Form":
			this.dropDownByIndex(From_Time, 10, 5);
			this.dropDownByIndex(To_Time, 10, 10);
			this.dropDownByIndex(Custome_Miniumum_Select_Hours, 10, 4);
			break;
		case "Custome Select Hours":
			this.inputText(Custome_Order_Value, randomCharacters("Max 2 Characters"), 10);
			this.inputText(Delivery_Value_Pay, randomCharacters("Max 2 Characters"), 10);
			break;
		case "Min Hours Error":
			this.dropDownByIndex(To_Time, 10, 10);
			this.dropDownByIndex(Custome_Miniumum_Select_Hours, 10, 11);
			break;
		case "Schedule Name Unique Validation":
			this.inputText(Delivery_Schedule_Name, deliveryScheduleName, 10);
			break;
		default:
			break;
		}
		this.clickButton(Save_Button, 10, "JS Click");
	}

	public void validRecords(String value) throws IOException, InterruptedException {
		if (value.equals("Time Slot Create") || value.equals("Pickup Time Slot")) {
			this.inputText(From_Time, randomCharacters("1 Hour Timing"), 10);
			if (value.equals("Time Slot Create")) {
				this.inputText(To_Time, randomCharacters("3 Hour Timing"), 10);
			}
			this.inputText(Cut_Off_Time, randomCharacters("Past Timing"), 10);
			if (value.equals("Time Slot Create")) {
				this.inputText(Delivery_Value_Pay, randomCharacters("Max 2 Characters"), 10);
				if (!this.conditionChecking(Error_Delivery_Value, 2)) {
					do {
						this.clearField("Delivery Value");
						this.inputText(Delivery_Value_Pay, randomCharacters("Max 2 Characters"), 10);
					} while (!this.conditionChecking(Error_Delivery_Value, 2));
				}
			}
		} else if (value.equals("Custome Time Slot Create")) {
			this.dropDownByIndex(Custome_Select_Days, 10, 3);
			this.dropDownByIndex(Select_Hours, 10, 5);
			this.dropDownByIndex(Custome_Miniumum_Select_Hours, 10, 3);
			Thread.sleep(2000);
			if (this.getTextAttribute(Custome_Order_Value, 10).equals("00")) {
				do {
					this.clearField("Order Value");
					this.inputText(Custome_Order_Value, randomCharacters("Max 2 Characters"), 10);
				} while (this.getTextAttribute(Custome_Order_Value, 10).equals("00"));
			} else if (this.getTextAttribute(Delivery_Value_Pay, 10).equals("00")) {
				do {
					this.clearField("Delivery Value");
					this.inputText(Delivery_Value_Pay, randomCharacters("Max 2 Characters"), 10);
				} while (this.getTextAttribute(Delivery_Value_Pay, 10).equals("00"));
			}
		} else if (value.equals("Delivery Schedule Create") || value.equals("Delivery Schedule Update")
				|| value.equals("Pickup Schedule Create")) {
			this.valuePresentCondition(Delivery_Schedule_Name, 10, deliveryScheduleName);
			this.inputText(Description, randomCharacters("Dummy Description").trim(), 10);
			if (value.equals("Delivery Schedule Create")) {
				this.clickButton(State_Select, 10, "JS Click");
				this.clickButton(City_Field, 10, "JS Click");
				this.invisible(Invisible_State, 10);
				this.clickButton(City_Select, 10, "JS Click");
				this.clickButton(Zipcode_Field, 10, "JS Click");
				this.invisible(Invisible_City, 10);
				this.clickButton(Zipcode_Select, 10, "JS Click");
				this.mandatoryValidation("Select Hours");
				this.dropDownByIndex(Select_Hours, 10, 5);
			}
		}
		this.clickButton(Save_Button, 10, "JS Click");
	}

	public String submissionValidation(String value) throws IOException {
		Boolean conditionCheck = true;
		if (value.equals("Time Slot Create")) {
			if (!this.conditionChecking(Create_Time_Slot_Message, 10)) {
				do {
					if (this.conditionChecking(Save_Button, 10)) {
						this.clickButton(Save_Button, 10, "JS Click");
					}
				} while (!this.conditionChecking(Create_Time_Slot_Message, 10));
			}
			records = this.getText(Create_Time_Slot_Message, 10);
			this.clickButton(Close_Time_Slot, 10, "JS Click");
		} else if (value.equals("Delivery Schedule Create") || value.equals("Delivery Schedule Update")) {
			if (this.conditionChecking(Delivery_Schedule_Create_Message, 10)
					|| this.conditionChecking(Delivery_Schedule_Update_Message, 10)) {
			} else {
				do {
					if (this.conditionChecking(Error_Delivery_Schedule, 10)) {
						if (this.getText(Error_Delivery_Schedule, 5)
								.equals(getPropertyValue("AlreadyExistDeliveryScheduleName"))) {
							this.clearField("Delivery Schedule Name");
							this.inputText(Delivery_Schedule_Name, randomCharacters("Dummy Delivery Schedule Name"),
									10);
						}
					}
					if (this.conditionChecking(Save_Button, 3)) {
						this.clickButton(Save_Button, 10, "JS Click");
					}
					if (value.equals("Delivery Schedule Create")) {
						if (this.conditionChecking(Delivery_Schedule_Create_Message, 10)) {
							conditionCheck = false;
						}
					} else if (value.equals("Delivery Schedule Update")) {
						if (this.conditionChecking(Delivery_Schedule_Update_Message, 10)) {
							conditionCheck = false;
						}
					}
				} while (conditionCheck);
			}
			if (value.equals("Delivery Schedule Create")) {
				String text = this.getText(Delivery_Schedule_Create_Message, 10);
				this.clickButton(Delivery_Close_Create, 10, "JS Click");
				return text;
			} else if (value.equals("Delivery Schedule Update")) {
				String text = this.getText(Delivery_Schedule_Update_Message, 10);
				this.clickButton(Delivery_Close_Update, 10, "JS Click");
				return text;
			}
		} else if (value.equals("Delivery Schedule Delete")) {
			String text = this.getText(Delivery_Schedule_Delete_Message, 10);
			this.clickButton(Delivery_Close_Delete, 10, "JS Click");
			return text;
		}
		return records;
	}

	public String listValidation(String value) {
		if (value.equals("Search Box")) {
			this.inputText(Search_Box, records, 10);
			this.clickButton(View, 10, "JS Click");
		} else if (value.equals("List Schedule Name")) {
			records = this.getText(List_Schedule_Name, 10);
		} else if (value.equals("List Schedule Type")) {
			records = this.getText(List_Schedule_Type, 10);
		} else if (value.equals("Filter Schedule Type")) {
			this.mouseActionClicks(List_Schedule_Type_Filter, 10);
			this.clickButton(Check_Box_Delivery_Schedule, 10, "JS Click");
			this.clickButton(View, 10, "JS Click");
		} else if (value.equals("Filter Pickup Type")) {
			this.mouseActionClicks(List_Schedule_Type_Filter, 10);
			this.clickButton(Check_Box_PickUp_Schedule, 10, "JS Click");
			this.clickButton(View, 10, "JS Click");
		} else if (value.equals("Invalid")) {
			records = this.getText(By.xpath("//*[text()='No Records Found']"), 10);
		} else if (value.equals("Invalid Record")) {
			records = "fsfdfsfdfsd";
		} else if (value.equals("Delete Validation")) {
			this.mouseActionClicks(ThreeDots, 10);
			this.mouseActionClicks(Delete, 10);
			this.mouseActionClicks(DeleteConfirm, 10);
		}
		return records;
	}

	public void clearAllFields() {
		List<String> asList = Arrays.asList("Delivery Schedule Name", "Description");
		for (int i = 0; i < asList.size(); i++) {
			this.clearField(asList.get(i));
		}
	}

	public void lassyLoader() {
		this.visible(By.xpath("//*[@id='sidebar']"), 10);
		this.invisible(By.xpath("//*[@id='sidebar']"), 20);
		this.visible(By.xpath("//*[@id='sidebar']"), 10);
	}
}
