package org.kona.pageobjectclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPath;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Order_management_module extends BaseClass {
	static public Map<String, String> map = new HashMap<>();
	static String RecipientFirstName;
	static String RecipientLastName;
	static String RecipientEmail;
	static String RecipientPhoneNumber;
	static String CustomerFirstName;
	static String CustomerLastName;
	static String customer_phone_no;

	public Order_management_module(WebDriver driver) {
		this.driver = driver;
	}

// create order
	By order_management_menu = By.xpath("//span[text()='Order Management']");
	By order_management_label = By.xpath("//h4[text()='Order Management']");
	By create_order_btn = By.xpath("//button[text()='Create Order']");
// order screen house account
	By house_acc_radio_btn = By.xpath("//input[@id='featured-11']");
	By house_acc_phone_no_input = By.xpath("//input[@id='customer_search_phone_number']");
	By house_acc_search_btn = By.xpath("//*[@id='customerSearchForm']/div/div[5]/button");
	By house_acc_invalid_phn_no_err = By
			.xpath("//div[text()='No house account found. Please contact admin to create house accounts.']");
	By add_new_recipient_btn = By.xpath("//button[text()=' Add New Recipient']");
	By house_acc_first_name_input = By.xpath("//*[@id='customer_search_last_name']");
// order screen customer
	By order_screen_label = By.xpath("//a[text()='Order Screen']");
	By customer_radio_btn = By.xpath("//input[@id='featured-10']");
	By customer_choose_type_next_btn = By.xpath("//div[@id='house_account_type']//button[text()='Next']");
	By search_cus_details_label = By.xpath("//h5[text()='Search Customer Details']");
	By customer_first_name = By.xpath("//input[@id='customer_search_name']");
	By customer_last_name = By.xpath("//input[@id='customer_search_last_name']");
	By customer_phone_num = By.xpath("//input[@id='customer_search_phone_number']");
	By customer_search_btn = By.xpath("//button[text()='Search']");
	By customer_blacklisted_label = By.xpath("//h1[text()='Customer Blacklisted']");
	By customer_blacklisted_popup_cls = By.xpath("//*[@id=\"customer_blacklist_reason\"]/div/div/div/div/div[2]/a/button");
// bulk assign florist
	By bulk_assign_florist_btn = By.xpath("//*[@id='base-content-page']/div[1]/nav/div/div/div[3]/div/a/button");
	By bulk_assign_label = By.xpath("//a[text()='Bulk Assign']");
	By bulk_assign_hub_search = By.xpath("//*[@id='base-content-page']/div/div/div/div[1]/div/div/div/div/div[1]/div/div/div/div/button");
	By bulk_assign_hub_search_input = By.xpath("//*[@id='base-content-page']/div/div/div/div[1]/div/div/div/div/div[1]/div/div/div/div/ul/li[1]/div/input");
	By bulk_assign_hub_select = By.xpath("//*[@id=\"base-content-page\"]/div/div/div/div[1]/div/div/div/div/div[1]/div/div/div/div/ul/li[3]/a/label/input");
	By bulk_assign_view_btn = By.xpath("//*[@id='base-content-page']/div/div/div/div[1]/div/div/div/div/div[2]/a/button");
	By bulk_assign_selectall = By.xpath("//*[@id='checkAll']");
	By bulk_assign_assign_florist_btn = By.xpath("//*[@id='base-content-page']/div/div/div/div[1]/div/div/div/div/div[4]/a/button");
	By bulk_assign_empty_validation = By.xpath("//p[text()='Please select one or more order']");
	By bulk_assign_no_records_label = By.xpath("//*[@id='pagination-data-container']/tbody/tr/td[6]");
	
// order screen customer required err msg
	By choose_type_empty_err_msg = By.xpath("//p[text()='Please choose one type.']");
	By phone_num_err_msg = By.xpath("//div[@id='customer_err_msg']");
	By customer_not_found_label = By.xpath("//h4[text()='Customer not Found']");
	By customer_yes_confirm_popup_btn = By.xpath("//*[@id=\"customer_not_exist\"]/div/div/div[2]/div/a/button");
// order screen order type
	By choose_one_order_type_label = By.xpath("//div[text()='Choose one Order Type']");
// order types
	By phone_call_for_delivery_radio_btn = By.xpath("//input[@id='featured-2']");
	By phone_call_for_pickup_radio_btn = By.xpath("//input[@id='featured-1']");
	By walkin_for_pickup_radio_btn = By.xpath("//input[@id='featured-3']");
	By walkin_for_delivery_radio_btn = By.xpath("//input[@id='featured-4']");
// order types required err msg
	By order_type_required_err_msg = By.xpath("//p[text()='The order type is required']");

// Phone call for delivery type fields
	By customer_order_type_next_btn = By.xpath("//div[@id='order_create_type']//button[text()='Next']");
	By check_add_for_delivery_service_label = By.xpath("//label[text()='Check Address for delivery service']");
	By customer_add_line_1 = By.xpath("//textarea[@id='recipient_address']");
	By address_1st_row = By.xpath("//span[text()='Salt Lake City, UT, USA']//ancestor::div[1]");
	By customer_add_line_2 = By.xpath("//textarea[@id='second_address']");
	By delivery_zip_code = By.xpath("//input[@id='zip_code_search']");
	@FindAll({ @FindBy(xpath = "//div[@id='order_zipcode_check']//child::*[@id='orderSearchBack']") })
	WebElement customer_add_next_btn;
	By pls_enter_valid_address_err_msg = By.xpath("//div[text()='Please enter a valid address']");
// phone call for delivery 5step form
	By phone_call_for_deleiver_form_label = By.xpath("//div[text()='Phone Call For Delivery']");
// phone call for delivery customer details input
	@FindAll({
			@FindBy(xpath = "//*[contains(@value,'customer')]//ancestor::form[@id='customer_form']//span[text()='Select Lead Source']"),
			@FindBy(xpath = "//*[contains(@value,'house_account')]//ancestor::div[@id='customer_step']//following::*[@id='recipient_step']//span[text()='Select Lead Source']") })
//		@FindBy(xpath = "//*[@id='leadsource_dropdown']/div/div/div[1]/button")})
	WebElement cus_store_name_input;
	By cus_store_name_search = By.xpath("//*[@id='customer_form']/div[2]/div/div/div/ul/li[1]/div/input");
	By cus_store_input_select = By.xpath("//*[@id='leadsource_dropdown']/div/div/div[1]/ul/li[3]/a/label");
	By cus_email_address_input = By.xpath("//input[@id='customer_email']");
	By cus_sender_address_input = By.xpath("//textarea[@id=\"delivery_window\"]");
	By cus_zip_code_input = By.xpath("//input[@id=\"delivery_zipcode\"]");
	By customer_next_btn = By.xpath("//*[@id=\"customer_step\"]/div/div/div/span[2]/button");
// phone call for delivery customer form field errors
	By cus_store_name_err_msg = By.xpath("//strong[text()='The lead source field is required.']");
	By cus_first_name_err_msg = By.xpath("//strong[text()='The first name field is required']");
	By cus_last_name_err_msg = By.xpath("//strong[text()='The last name field is required']");
	By cus_email_add_err_msg = By.xpath("//strong[text()='The email address field is required']");
	By cus_invalid_email_err_msg = By.xpath("//strong[text()='The email address field format is invalid.']");
// phone call for delivery recipient details input
	By second_stepper_logo_active = By.xpath("//*[@id='step2-active' and contains(@class,'active')]");
	By recipient_select_delivery_date_input = By.xpath("//input[@id='deliveryDatePicker']");
	By recipient_first_name_input = By.xpath("//input[@id='recipient_name']");
	By recipient_last_name_input = By.xpath("//input[@id='recipient_last_name']");
	By recipient_email_input = By.xpath("//input[@id='email']");
	By recipient_phone_num_input = By.xpath("//input[@id='recipient_phone_number']");
	By recipient_business_input = By.xpath("//textarea[@id='venue_name']");
	By recipient_address_line1_input = By.xpath("//textarea[@id='address1']");
	By recipient_zip_code_input = By.xpath("//input[@id='recipient_delivery_zipcode']");
	By recipient_next_btn = By.xpath("//*[@id='recipient_step']/div/div/div/span[3]/button");
// phone call for delivery recipient form field errors
	By select_delivery_date_err_msg = By.xpath("//strong[text()='The delivery date field is required.']");
	By recipient_first_name_err_msg = By.xpath("//strong[text()='The first name field is required.']");
	By recipient_last_name_err_msg = By.xpath("//strong[text()='The last name field is required.']");
	By recipient_cell_no_err_msg = By.xpath("//strong[text()='The phone number field is required.']");
	By recipient_address_field_err_msg = By.xpath("//strong[text()='The address field is required.']");
	By recipient_invalid_phone_no_err_msg = By
			.xpath("//strong[text()='The phone number must be at least 10 numbers.']");
	By product_unavailable_for_zip = By.xpath("//div[text()='Products temporarily unavailable for this zip code']");
	By recipient_address_1_input = By.xpath("//textarea[@id='address1']");
// phone call for delivery product_input
	By third_stepper_logo_active = By.xpath("//*[@class='stepper-step step3 active']");
	By occasion_input = By.xpath("//select[@id='occasion']");
	By category_product_marriage = By.xpath("//button[text()=' Marriage ']");
	By at_the_ballet_product_view_details = By.xpath("//*[@id='collapse0']/div/div[1]/div[1]/div/p/button");
	By delivery_date_input = By.xpath("//*[@id=\"florist-delivery-dates\"]//span[1]");
	By delivery_time_input_1st = By
			.xpath("//*[@id='step-6']/div[1]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div[1]/span[1]");
	By delivery_time_input_2nd = By
			.xpath("//*[@id=\"step-6\"]/div[1]/div[2]/div/div/div/div[1]/div[2]/div[3]/div[2]/div[1]/span[2]");
	By add_product_btn = By.xpath("//button[text()=\"Add Product\"]");
	By delivery_date_err_msg = By.xpath("//p[text()='The delivery date is required']");
	By delivery_time_err_msg = By.xpath("//p[text()='The delivery time is required']");
	By make_your_loved_one_label = By.xpath("//h5[text()='Make your Loved ones Feels Special']");
	@FindAll({
			@FindBy(xpath = "//*[@id=\"base-content-page\"]/div/div/div/div/div[3]/div[4]/div[2]/div/div/div[5]/div/div/span[2]/button"),
			@FindBy(xpath = "//*[@id=\"base-content-page\"]/div/div/div/div/div[3]/div[5]/div[2]/div/div/div[5]/div/div/span[2]/button") })
	WebElement add_on_next_btn;
	// phone call for delivery message_input
	By fourth_stepper_logo_active = By.xpath("//div[@class='stepper-step step4 active']");
	By delivery_tip_input = By.xpath("//input[@id='delivery_tips']");
	By enter_card_msg_input = By.xpath("//textarea[@id='message']");
	By instruction_to_florist_input = By.xpath("//textarea[@id='instruction_to_florist']");
	By instruction_to_delivery_driver_input = By.xpath("//textarea[@id='instruction_to_delivery_driver']");
	@FindAll({
			@FindBy(xpath = "//*[contains(@class,'step-4')]//div[contains(@class,'footer')]//button[text()='Next']") })
	WebElement message_next_btn;
	// phone call for delivery preview order
	@FindAll({ @FindBy(xpath = "//*[contains(@class,'step-8')]//*[contains(@class,'footer')]//*[text()='Next']") })
	WebElement preview_order_next_btn;
	// phone call for delivery preview order
	By preview_order_label = By.xpath("//h4[text()=' Preview Order']");
	@FindAll({ @FindBy(xpath = "//*[@id='base-content-page']/div/div/div/div/div[3]/div[6]/div/div/div/span[2]/button"),
			@FindBy(xpath = "//*[@id='base-content-page']/div/div/div/div/div[3]/div[5]/div/div[2]/div/div/div[4]/div/div/span[2]/button") })

// phone call for delivery payment
	By fifth_stepper_logo_active = By.xpath("//div[@class='stepper-step step5 active']");
	By payment_billing_address_input = By.xpath("//textarea[@id='billing_address']");
	By payment_zip_code_input = By.xpath("//input[@id='billing_zipcode']");
	By payment_business_checkbox = By.xpath("//input[@id='billing_checkbox']");
	By payment_card_number_input = By.xpath("//input[@id='authorize-credit-card-number']");
	By payment_card_number_invalid = By.xpath("//strong[text()='Card number is invalid']");
	By payment_expiry_month = By.xpath("//select[@id='authorize-credit-card-month']");
	By payment_expiry_year = By.xpath("//select[@id='authorize-credit-card-year']");
	By payment_cvv_input = By.xpath("//input[@id='authorize-credit-card-cvv']");
	By payment_place_holder_btn = By.xpath("//button[@id='orderSaveBtn']");
	By payment_card_no_required_msg = By.xpath("//strong[text()='Card Number is required']");
	By payment_cvv_required_msg = By.xpath("//strong[text()='CVV is required']");
	By order_placed_succ_label = By.xpath("//h2[text()='Order Placed Successfully']");
	By order_placed_close_popup = By.xpath("//*[@id=\"popup-order-create\"]/div/div/div/div/div/p/a/button");
// phone call for delivery order edit
	By pcfd_order_action = By.xpath("//div[@id='pagination-data-container']//table//tbody//tr[1]//i");
	By pcfd_order_action_view = By
			.xpath("//*[@id='pagination-data-container']/table/tbody/tr[1]/td[20]/div/ul/li[1]/a");
	By pcfd_order_view_label = By.xpath("//a[text()='View Order']");
	By pcfd_order_view_edit_btn = By.xpath("//a[text()=' Edit Order ']");
	By pcfd_order_edit_order_label = By.xpath("//a[text()='Edit Order']");
	By pcfd_order_edit_rec_first_name = By.xpath("//input[@id='recipient_name']");
	By pcfd_order_edit_rec_last_name = By.xpath("//input[@id='recipient_last_name']");
	By pcfd_order_edit_rec_phone_no = By.xpath("//input[@id='recipient_phone_number']");
	By pcfd_update_btn = By.xpath("//*[@id='button_check']");
	By pcfd_order_updated_label = By.xpath("//h2[text()='Order Updated Successfully']");
	By pcfd_order_updated_popup_close = By
			.xpath("//*[@id='popup-order-update-current']/div/div/div/div/div/p/a/button");

// phone call for pickup type
	By store_name_select = By.xpath("//*[@id=\"customer_form\"]/div[2]/div/div/div/button");
	By store_name_first_row_select = By.xpath("//*[@id=\"customer_form\"]/div[2]/div/div/div/ul/li[3]/a/label/input");
	By pcfp_customer_next_btn = By.xpath("//*[@id='customer_step']/div/div/div/span[2]/button");
	By phone_call_by_pickup_label = By.xpath("//div[text()='Phone Call For Pickup']");
	By pickup_state_input = By.xpath("//span[text()='Select State']");
	By pickup_state_search = By.xpath("//*[@id='recipient-form']/div[2]/div[3]/div/div[2]/ul/li[1]/div/input");
	By utah_state = By.xpath("//*[@id=\"recipient-form\"]/div[2]/div[3]/div/div[2]/ul/li[48]/a/label/input");
	By first_row_hub = By.xpath("//*[@id=\"radio-button-id\"]");
	By pickup_next_btn = By.xpath("//*[@id='customer_city_zipcode']/div/div/div/span[2]/button");
// phone call for pickup edit
	By pickup_shedule_date_update = By.xpath("//*[@id='florist-delivery-dates']//span[2]");
	By pickup_shedule_time_update = By.xpath("//*[@id='delivery-details']/div[2]/div[2]/div/span[1]");
	By pickup_shedule_update_btn = By.xpath("//*[@id='button_check']");
// walk in for pickup
	By walkin_for_pickup_label = By.xpath("//div[text()='Walk In For Pickup']");
// walk in for delivery
	By wfd_order_type = By.xpath("//input[@id='featured-4']");
	By wfd_order_type_next_btn = By.xpath("//div[@id='order_type_hidden']//*[@id=\"orderSearchBack\"]");
	By wfd_form_label = By.xpath("//div[text()='Walk In For Delivery']");
// order table
	By order_table_1strow_first_name = By.xpath("//*[@id=\"pagination-data-container\"]/table/tbody/tr[1]/td[6]");
	By action_update_status_order_preparation = By
			.xpath("//*[@id='pagination-data-container']/table/tbody/tr[1]/td[20]/div/ul/li[3]/a");
	By action_update_status_order_packed = By
			.xpath("//*[@id='pagination-data-container']/table/tbody/tr[1]/td[20]/div/ul/li[2]/a");
	By update_status_popup_label = By.xpath("//h4[text()='Update Status']");
	By order_preparation_status = By.xpath("//strong[text()='Order Preparation']");
	By order_packed_status = By.xpath("//strong[text()='Packed']");
	By order_delivered_status = By.xpath("//strong[text()='Delivered']");
	By order_printed_status = By.xpath("//strong[text()='Printed']");
	By order_cancelled_status = By.xpath("//strong[text()='Cancelled']");
	By status_Change_update_btn = By.xpath("//*[@id='update_status_list']/div/div/span/button");
	By order_status_updated_succ_label = By.xpath("//h2[text()='Order Status Updated successfully']");
	By order_status_succ_popup_cls = By.xpath("//*[@id='popup-update-status-success']/div/div/div/div/div/p/a/button");
	By list_order_status = By.xpath("//*[@id='pagination-data-container']/table/tbody/tr[1]/td[5]");
// Assign florist
	By assign_florist_btn = By.xpath("//div[@id='pagination-data-container']//table//tbody//tr[1]//td[19]//input");	
	@FindAll({@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[3]/div/div/h4"), 
		@FindBy(xpath = "//div[@id='pagination-data-container']//table//tbody//tr[1]//td[19]//input")})
	WebElement assign_florist_popup_label;
	@FindAll({@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[3]/div/div/div[2]/div[1]/div"), 
		@FindBy(xpath = "/html/body/div[2]/div[2]/div[4]/div/div/div[2]/div[1]/div")})
	WebElement florist_name_1st_row;
	@FindAll({@FindBy(xpath = "//*[@id='assignflorist']/div/div/span/button"), 
		@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[3]/div/div/span/button")})
	WebElement assign_florist_popup_btn;
	By assign_florist_succ_label = By.xpath("//h2[text()='Florist Assigned Successfully']");
	By assign_florist_popup_cls = By.xpath("//*[@id='popup-florist-success']/div/div/div/div/div/p/a/button");
// PDf
	By view_order_PDF = By.xpath("//a[text()='View Order PDF']");
// Filter
	By city_filter = By.xpath("//button[text()='City Filter']");
	By filter_select_state = By.xpath("//*[@id='orderserchbar-show-hide']/div/div/div[1]/div/div/button");
	By filter_select_state_search_input = By
			.xpath("//*[@id='orderserchbar-show-hide']/div/div/div[1]/div/div/ul/li[1]/div/input");
	@FindAll({ @FindBy(xpath = "//*[@id='orderserchbar-show-hide']/div/div/div[1]/div/div/ul/li[47]/a/label/input") })
	WebElement filter_select_state_select;
	By filter_search_city_input = By.xpath("//*[@id='orderserchbar-show-hide']/div/div/div[2]/span/span[1]/span");
	@FindAll({ @FindBy(xpath = "//*[@id='select2-orderCity-results']/li[1]") })
	WebElement filter_select_city;
	By email_id_1st_position = By.xpath("//*[@id='pagination-data-container']/table/tbody/tr[1]/td[8]");
	By filter_view_btn = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[1]/div[1]/div/div[3]/p/a/button");
	By No_records_text = By.xpath("//*[@id='pagination-data-container']/table/tbody/tr/td[6]");
// sort
	By sort_by_hub = By
			.xpath("//*[@id='base-content-page']/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div[1]/div/button");
	By sort_by_delivery_schedule = By
			.xpath("//*[@id='base-content-page']/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div[2]/div/button");
	By sort_by_store = By
			.xpath("//*[@id='base-content-page']/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div[3]/div/button");
	By sort_by_date = By.xpath("//*[@id='dropdownMenuButton1']");
	By sort_by_delivery_time = By
			.xpath("//*[@id='base-content-page']/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div[5]/div/button");
// dispatch module
	By dispatch_menu = By.xpath("//*[@id='dispatch_side_bar']/span");
	By dispatch_label = By.xpath("//*[@id='base-content-page']/div[1]/nav/div/div/div[1]/h4");
	By assign_driver_list_btn = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[9]/input");
	By assign_driver_label = By.xpath("//*[@id='assigndriver']/div/div/h4");
	By assign_manivel = By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]/div[4]/div/div/div[2]/div[4]/div");
	By assign_driver_btn = By.xpath("//*[@id='assignDriverBut']");
	By driver_assigned_succ_label = By.xpath("//h2[text()='Delivery Driver Assigned Successfully']");
	By driver_assinged_popup_cls = By.xpath("//*[@id='popup-dispatch-driver']/div/div/div/div/div/p/a/button");
	By dispatch_status = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[10]");
// Customer blacklist
	By customer_blacklist_action = By
			.xpath("//*[@id=\"pagination-data-container\"]/table/tbody/tr[1]/td[20]/div/ul/li[3]/a");
	By customer_blacklist_popup_label = By.xpath("//h4[text()='Customer Blacklist']");
	By customer_blacklist_popup_reason = By.xpath("//*[@id='Reason']");
	By customer_blacklist_popup_yesbtn = By.xpath("//*[@id='popup-customer-backlist']/div/div/div/div[3]/a/button");
	By customer_blacklist_popup_empty_validation = By.xpath("//p[text()='The reason field is required']");
	By customer_blacklist_succ_lable = By.xpath("//h2[text()='Customer Blacklist Reason Saved Successfully']");
	By customer_blacklist_popup_clsbtn = By
			.xpath("//*[@id='popup-custoner-blacklist-success']/div/div/div/div/div/a/button");
// Track order
	By track_order_btn = By.xpath("//*[@id=\"base-content-page\"]/div[1]/nav/div/div/div[5]/a/button");
	By track_order_label = By.xpath("//a[text()='Track Order']");
	By track_order_no_input = By.xpath("//input[@id='search_order_number']");
	By track_order_search_btn = By.xpath("//*[@id='track_order_search_form']/div[2]/div/button");
	By track_order_edit = By.xpath("//*[@id='trackOrder']/div[2]/div[1]/a");
	By track_order_btn_by_phn_no = By.xpath("//*[@id='customerList']/tr[2]/td[10]/input");
	
	public String order_create_empty_validation(String value) {
		if (value == "choose_type_empty_validation") {
			if (this.conditionChecking(choose_type_empty_err_msg, 3)) {
			} else {
				do {
					this.clickButton(customer_choose_type_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(choose_type_empty_err_msg, 3));
			}
			String text = this.getText(choose_type_empty_err_msg, 10);
			return text;
		} else if (value == "phone_number_empty_validation") {
			if (this.conditionChecking(phone_num_err_msg, 3)) {
			} else {
				do {
					this.clickButton(customer_search_btn, 10, "JS Click");
				} while (!this.conditionChecking(phone_num_err_msg, 3));
			}
			String text = this.getText(phone_num_err_msg, 10);
			return text;
		} else if (value == "order_type_empty_validation") {
			if (!this.conditionChecking(order_type_required_err_msg, 3)) {
				do {
					this.clickButton(customer_order_type_next_btn, 10, "JS Click");
				} while (this.conditionChecking(order_type_required_err_msg, 3));
			}
			String text = this.getText(order_type_required_err_msg, 10);
			return text;
		} else if (value == "address_empty_validation") {
			if (!this.conditionChecking(pls_enter_valid_address_err_msg, 3)) {
				do {
					this.clickButton(customer_add_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(pls_enter_valid_address_err_msg, 3));
			}
			String text = this.getText(pls_enter_valid_address_err_msg, 10);
			return text;
		}
		return value;
	}

	public String Order_management_menu() {
		this.clickButton(order_management_menu, 10, "JS Click");
		String text = this.getText(order_management_label, 10);
		return text;
	}

	public String create_order() {
		this.clickButton(create_order_btn, 10, "JS Click");
		String text = this.getText(order_screen_label, 10);
		return text;
	}

	public String choose_customer_type() {
		this.clickButton(customer_radio_btn, 10, "JS Click");
		this.clickButton(customer_choose_type_next_btn, 10, "JS Click");
		this.clickButton(customer_search_btn, 10, "JS Click");
		String text = this.getText(search_cus_details_label, 10);
		return text;
	}

	public String choose_house_account_type() {
		this.clickButton(house_acc_radio_btn, 10, "JS Click");
		this.clickButton(customer_choose_type_next_btn, 10, "JS Click");
		String text = this.getText(search_cus_details_label, 10);
		return text;
	}

	public String invalid_house_acc_validation() {
		this.inputText(house_acc_phone_no_input, "8747848483", 10);
		this.mouseActionClicks(house_acc_search_btn, 10);
		if (!this.conditionChecking(house_acc_invalid_phn_no_err, 2)) {
			do {
				this.mouseActionClicks(house_acc_search_btn, 10);
			} while (!this.conditionChecking(house_acc_invalid_phn_no_err, 2));
		}
		String text = this.getText(house_acc_invalid_phn_no_err, 10);
		return text;
	}

	public String house_account_details_input() throws IOException {
		this.clearField(house_acc_phone_no_input, 10);
		this.inputText(house_acc_phone_no_input, getUpdatedPropertyFile("House_Page", "PhoneNumber"), 10);
		this.mouseActionClicks(house_acc_first_name_input, 10);
		this.clickButton(house_acc_search_btn, 10, "JS Click");
		if (!this.conditionChecking(choose_one_order_type_label, 3)) {
			do {
				this.clickButton(house_acc_search_btn, 10, "JS Click");
			} while (!this.conditionChecking(choose_one_order_type_label, 3));
		}
		String text = this.getText(choose_one_order_type_label, 10);
		return text;
	}

	public String customer_details_input() throws InterruptedException {
		this.inputText(customer_first_name, dummyData("First Name"), 10);
		CustomerFirstName = this.getTextAttribute(customer_first_name, 10);
		this.inputText(customer_last_name, dummyData("Last Name"), 10);
		CustomerLastName = this.getTextAttribute(customer_last_name, 10);
		this.inputText(customer_phone_num, dummyData("Phone Number"), 10);
		customer_phone_no = this.getTextAttribute(customer_phone_num, 10);
		this.clickButton(customer_search_btn, 10, "JS Click");
		String text = this.getText(customer_not_found_label, 10);
		Thread.sleep(2000);
		return text;
	}

	public String choose_one_order_type_field() throws InterruptedException {
		Thread.sleep(2000);
		this.clickButton(customer_yes_confirm_popup_btn, 10, "JS Click");
		String text = this.getText(choose_one_order_type_label, 10);
		return text;
	}

	public String select_order_type() {
		this.clickButton(phone_call_for_delivery_radio_btn, 10, "JS Click");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 0);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(customer_order_type_next_btn));
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		} catch (Exception e) {
			System.out.println(e);
		}
		this.clickButton(customer_order_type_next_btn, 10, "JS Click");
		String text = this.getText(check_add_for_delivery_service_label, 10);
		return text;
	}

	public String house_acc_order_type_select() {
		this.clickButton(phone_call_for_delivery_radio_btn, 10, "JS Click");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 0);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(add_new_recipient_btn));
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		} catch (Exception e) {
			System.out.println(e);
		}
		this.clickButton(add_new_recipient_btn, 10, "JS Click");
		String text = this.getText(check_add_for_delivery_service_label, 10);
		return text;

	}

	public String address_for_delivery() throws InterruptedException, AWTException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 0);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(customer_add_next_btn));
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		} catch (Exception e) {
			System.out.println(e);
		}
		this.inputText(customer_add_line_1, getUpdatedPropertyFile("Order_Management", "Address"), 10);
//		this.mouseActionClicks(address_1st_row, 10);
		int listWebElement = this.listWebElement(By.xpath("(//div[contains(@class,'pac-item')])[1]"), 10).getSize();
		this.mouseActionClicks(By.xpath("(//div[contains(@class,'pac-item')])[" + listWebElement + "]"), 10);
		this.clickButton(customer_add_next_btn, 10, "JS Click");
		if (!this.conditionChecking(phone_call_for_deleiver_form_label, 10)) {
			do {
				this.clickButton(customer_add_next_btn, 10, "JS Click");
			} while (!this.conditionChecking(phone_call_for_deleiver_form_label, 10));
		}
		String text = this.getText(phone_call_for_deleiver_form_label, 10);
		return text;
	}

	public String customer_form_empty_validation(String value) {
		if (value == "store_name_empty_validation") {
			if (this.conditionChecking(cus_store_name_err_msg, 3)) {
			} else {
				do {
					this.clickButton(customer_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(cus_store_name_err_msg, 3));
			}
			String text = this.getText(cus_store_name_err_msg, 10);
			return text;
		} else if (value == "first_name_empty_validation") {
			if (this.conditionChecking(cus_first_name_err_msg, 3)) {
			} else {
				do {
					this.clickButton(customer_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(cus_first_name_err_msg, 3));
			}
			String text = this.getText(cus_first_name_err_msg, 10);
			return text;
		} else if (value == "last_name_empty_validation") {
			if (!this.conditionChecking(cus_last_name_err_msg, 3)) {
				do {
					this.clickButton(customer_next_btn, 10, "JS Click");
				} while (this.conditionChecking(cus_last_name_err_msg, 3));
			}
			String text = this.getText(cus_last_name_err_msg, 10);
			return text;
		} else if (value == "email_address_empty_validation") {
			if (!this.conditionChecking(cus_email_add_err_msg, 3)) {
				do {
					this.clickButton(customer_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(cus_email_add_err_msg, 3));
			}
			String text = this.getText(cus_email_add_err_msg, 10);
			return text;
		} else if (value == "email_address_invalid_validation") {
			this.inputText(cus_email_address_input, "abcdefgh", 10);
			if (!this.conditionChecking(cus_invalid_email_err_msg, 3)) {
				do {
					this.clickButton(customer_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(cus_invalid_email_err_msg, 3));
			}
			String text = this.getText(cus_invalid_email_err_msg, 10);
			return text;
		}
		return value;
	}

	public String recipient_form_empty_validation(String value) {
		if (value == "delivery_date_empty_validation") {
			if (this.conditionChecking(select_delivery_date_err_msg, 3)) {
			} else {
				do {
					this.clickButton(recipient_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(select_delivery_date_err_msg, 3));
			}
			String text = this.getText(select_delivery_date_err_msg, 10);
			return text;
		} else if (value == "first_name_empty_validation") {
			if (this.conditionChecking(recipient_first_name_err_msg, 3)) {
			} else {
				do {
					this.clickButton(recipient_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(recipient_first_name_err_msg, 3));
			}
			String text = this.getText(recipient_first_name_err_msg, 10);
			return text;
		} else if (value == "last_name_empty_validation") {
			if (!this.conditionChecking(recipient_last_name_err_msg, 3)) {
				do {
					this.clickButton(recipient_next_btn, 10, "JS Click");
				} while (this.conditionChecking(recipient_last_name_err_msg, 3));
			}
			String text = this.getText(recipient_last_name_err_msg, 10);
			return text;
		} else if (value == "phone_no_empty_validation") {
			if (!this.conditionChecking(recipient_cell_no_err_msg, 3)) {
				do {
					this.clickButton(recipient_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(recipient_cell_no_err_msg, 3));
			}
			String text = this.getText(recipient_cell_no_err_msg, 10);
			return text;
		} else if (value == "phone_no_invalid_validation") {
			this.inputText(recipient_phone_num_input, "8349", 10);
			this.clickButton(recipient_next_btn, 10, "JS Click");
			if (!this.conditionChecking(recipient_invalid_phone_no_err_msg, 3)) {
				do {
					this.clickButton(recipient_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(recipient_invalid_phone_no_err_msg, 3));
			}
			String text = this.getText(recipient_invalid_phone_no_err_msg, 10);
			return text;
		}
		return value;
	}

	public String payment_form_empty_validation(String value) {
		if (value == "card_number_empty_validation") {
			if (this.conditionChecking(payment_card_no_required_msg, 3)) {
			} else {
				do {
					this.clickButton(payment_place_holder_btn, 10, "JS Click");
				} while (!this.conditionChecking(payment_card_no_required_msg, 3));
			}
			String text = this.getText(payment_card_no_required_msg, 10);
			return text;
		}
		return value;
	}

	static String errorZipcode;

	public String create_order_by_phonecall_delivery(String value) throws IOException {
		if (value == "customer") {
			this.clickButton(cus_store_name_input, 10, "JS Click");
//			this.inputText(cus_store_name_search, getUpdatedPropertyFile("Order_Management", "LeadSource"), 10);
			this.clickButton(By.xpath("//*[@id=\"customer_form\"]/div[2]/div/div/div/ul/li/a/label[contains(text(),'"
					+ getUpdatedPropertyFile("Order_Management", "LeadSource") + "')]"), 10, "JS Click");
			this.inputText(cus_email_address_input, dummyData("Email"), 10);
			this.inputText(cus_sender_address_input, dummyData("Address1"), 10);
			this.inputText(cus_zip_code_input, "84111", 10);
			this.clickButton(customer_next_btn, 10, "JS Click");
			if (!this.conditionChecking(second_stepper_logo_active, 10)) {
				do {
					this.clickButton(customer_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(second_stepper_logo_active, 10));
			}
		} else if (value == "recipient") {
			if (this.conditionChecking(cus_store_name_input, 5)) {
				this.clickButton(cus_store_name_input, 10, "JS Click");
				this.clickButton(cus_store_input_select, 10, "JS Click");
			}
			if (!(this.getTextAttribute(recipient_first_name_input, 10).length() > 0)) {
				this.inputText(recipient_first_name_input, dummyData("First Name"), 10);
				RecipientFirstName = this.getTextAttribute(recipient_first_name_input, 10);
				map.put("RecipientFirstName", RecipientFirstName);
			}
			this.mouseActionClicks(recipient_last_name_input, 10);
			if (!(this.getTextAttribute(recipient_last_name_input, 10).length() > 0)) {
				this.inputText(recipient_last_name_input, dummyData("Last Name"), 10);
				RecipientLastName = this.getTextAttribute(recipient_last_name_input, 10);
				map.put("RecipientLastName", RecipientLastName);
			}
			if (!(this.getTextAttribute(recipient_email_input, 10).length() > 0)) {
				this.inputText(recipient_email_input, dummyData("Email"), 10);
				RecipientEmail = this.getTextAttribute(recipient_email_input, 10);
				map.put("RecipientEmail", RecipientEmail);
			}
//			if (!(this.getTextAttribute(recipient_phone_num_input, 10).length() > 0)) {
			this.inputText(recipient_phone_num_input, dummyData("Phone Number"), 10);
			RecipientPhoneNumber = this.getTextAttribute(recipient_phone_num_input, 10);
			map.put("RecipientPhoneNumber", RecipientPhoneNumber);
//			}

			this.inputText(recipient_select_delivery_date_input, dateFormat(0), 10);
//			this.inputText(recipient_select_delivery_date_input,
//					getUpdatedPropertyFile("Order_Management", "DeliveryDate"), 10);
			this.inputText(recipient_business_input, dummyData("Business Name"), 10);
			this.clickButton(recipient_next_btn, 10, "JS Click");
			if (this.conditionChecking(product_unavailable_for_zip, 5)) {
				errorZipcode = this.getText(product_unavailable_for_zip, 10);
				this.clearField(recipient_address_1_input, 10);
				this.clickButton(recipient_address_1_input, 10, getUpdatedPropertyFile("Order_Management", "Address"));
				int listWebElement = this.listWebElement(By.xpath("(//div[contains(@class,'pac-item')])[1]"), 10)
						.getSize();
				this.mouseActionClicks(By.xpath("(//div[contains(@class,'pac-item')])[" + listWebElement + "]"), 10);
				this.clickButton(recipient_next_btn, 10, "JS Click");
			}
			if (!this.conditionChecking(third_stepper_logo_active, 10)) {
				do {
					this.clickButton(recipient_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(third_stepper_logo_active, 10));
			}
		} else if (value == "product") {
			this.dropDownByIndex(occasion_input, 10, 1);
			this.clickButton(category_product_marriage, 10, "JS Click");
			this.clickButton(at_the_ballet_product_view_details, 10, "JS Click");
			this.clickButton(add_product_btn, 10, "JS Click");
			this.clickButton(delivery_date_input, 10, "JS Click");
			this.clickButton(add_product_btn, 10, "JS Click");
			int count = this.listWebElement(
					By.xpath("//*[@id='florist-delivery-dates']//following-sibling::div//div//span"), 10).getSize();
			for (int i = 0; i <= count;) {
				do {
					i++;
					this.clickButton(
							By.xpath("//*[@id='florist-delivery-dates']//following-sibling::div//div//span[" + i + "]"),
							10, "JS Click");
				} while (!this.conditionChecking(
						By.xpath("//*[@id='florist-delivery-dates']//following-sibling::div//div//span[" + i
								+ "][contains(@class,'active')]"),
						2));
				break;
			}
			this.clickButton(add_product_btn, 10, "JS Click");
			this.clickButton(add_on_next_btn, 10, "JS Click");
			if (!this.conditionChecking(fourth_stepper_logo_active, 10)) {
				do {
					this.clickButton(add_on_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(fourth_stepper_logo_active, 10));
			}

		} else if (value == "messages") {
			this.inputText(delivery_tip_input, randomCharacters("Max 2 Characters"), 10);
			if (this.getTextAttribute(delivery_tip_input, 10).equals("00")) {
				do {
					this.clearField(delivery_tip_input, 10);
					this.inputText(delivery_tip_input, randomCharacters("Max 2 Characters"), 10);
				} while (this.getTextAttribute(delivery_tip_input, 10).equals("00"));
			}
			this.inputText(enter_card_msg_input, randomCharacters("Dummy Description"), 10);
			this.inputText(instruction_to_florist_input, randomCharacters("Max 69 Characters"), 10);
			if (this.conditionChecking(instruction_to_delivery_driver_input, 2)) {
				this.inputText(instruction_to_delivery_driver_input, randomCharacters("Max 69 Characters"), 10);
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 0);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(message_next_btn));
			try {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			} catch (Exception e) {
				System.out.println(e);
			}

			this.clickButton(message_next_btn, 10, "JS Click");
			if (!this.conditionChecking(third_stepper_logo_active, 10)) {
				do {
					this.mouseActionClicks(message_next_btn, 10);
				} while (!this.conditionChecking(third_stepper_logo_active, 10));
			}
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			WebDriverWait wait1 = new WebDriverWait(driver, 0);
			WebElement element1 = wait1.until(ExpectedConditions.visibilityOf(preview_order_next_btn));
			try {
				js1.executeScript("arguments[0].scrollIntoView(true);", element1);
			} catch (Exception e) {
				System.out.println(e);
			}
			this.clickButton(preview_order_next_btn, 10, "JS Click");
			if (!this.conditionChecking(fifth_stepper_logo_active, 10)) {
				do {
					this.clickButton(preview_order_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(fifth_stepper_logo_active, 10));
			}
		} else if (value == "payment") {
			this.clickButton(payment_business_checkbox, 10, "JS Click");
			this.inputText(payment_card_number_input, getUpdatedPropertyFile("Order_Management", "CardNumber"), 10);
			this.inputText(payment_expiry_month, getUpdatedPropertyFile("Order_Management", "ExpiryMonth"), 10);
			this.inputText(payment_expiry_year, getUpdatedPropertyFile("Order_Management", "ExpiryYear"), 10);
			this.inputText(payment_cvv_input, getUpdatedPropertyFile("Order_Management", "CVV"), 10);
			this.clickButton(payment_place_holder_btn, 10, "JS Click");
			String text = this.getText(order_placed_succ_label, 10);
			this.clickButton(order_placed_close_popup, 10, "JS Click");
			return text;
		}
		return value;
	}

	public String order_type(String value) {
		if (value == "phone_call_for_pickup") {
			this.clickButton(phone_call_for_pickup_radio_btn, 10, "JS Click");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 0);
			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(customer_order_type_next_btn));
			try {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			} catch (Exception e) {
				System.out.println(e);
			}
			this.clickButton(customer_order_type_next_btn, 10, "JS Click");
			if (!this.conditionChecking(phone_call_by_pickup_label, 3)) {
				do {
					this.clickButton(customer_add_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(phone_call_by_pickup_label, 3));
			}
			String text = this.getText(phone_call_by_pickup_label, 10);
			return text;
		} else if (value == "walkin_for_pickup") {
			this.clickButton(walkin_for_pickup_radio_btn, 10, "JS Click");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 0);
			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(customer_order_type_next_btn));
			try {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			} catch (Exception e) {
				System.out.println(e);
			}
			this.clickButton(customer_order_type_next_btn, 10, "JS Click");
			String text = this.getText(walkin_for_pickup_label, 10);
			return text;
		}
		return value;
	}

	public String pcfd_order_view() {
		this.clickButton(pcfd_order_action, 10, "JS Click");
		this.clickButton(pcfd_order_action_view, 10, "JS Click");
		String text = this.getText(pcfd_order_view_label, 10);
		return text;
	}

	public String pcfd_order_edit() {
		this.clickButton(pcfd_order_view_edit_btn, 10, "JS Click");
		String text = this.getText(pcfd_order_edit_order_label, 10);
		return text;
	}

	public String pcfd_order_edit_confirm() throws InterruptedException {
		Thread.sleep(2000);
		this.clearField(pcfd_order_edit_rec_first_name, 10);
		this.inputText(pcfd_order_edit_rec_first_name, dummyData("First Name"), 10);
		this.clearField(pcfd_order_edit_rec_last_name, 10);
		this.inputText(pcfd_order_edit_rec_last_name, dummyData("Last Name"), 10);
		this.clearField(pcfd_order_edit_rec_phone_no, 10);
		this.inputText(pcfd_order_edit_rec_phone_no, dummyData("Phone Number"), 10);

		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		} catch (Exception e) {
			System.out.println(e);
		}
		this.clickButton(pcfd_update_btn, 10, "JS Click");
		if (!this.conditionChecking(pcfd_order_updated_label, 3)) {
			do {
				if (this.conditionChecking(pcfd_update_btn, 3)) {
					this.clickButton(pcfd_update_btn, 10, "JS Click");
				}
			} while (!this.conditionChecking(pcfd_order_updated_label, 3));
		}
		String text = this.getText(pcfd_order_updated_label, 15);
		this.mouseActionClicks(pcfd_order_updated_popup_close, 10);
		this.clickButton(pcfd_order_view_label, 10, "JS Click");
		return text;
	}

	public String pfcp_order_edit_confirm() {
		this.clickButton(pickup_shedule_date_update, 10, "JS Click");
		this.clickButton(pickup_shedule_time_update, 10, "JS Click");
		this.clickButton(pickup_shedule_update_btn, 10, "JS Click");
		String text = this.getText(pcfd_order_updated_label, 10);
		this.clickButton(pcfd_order_updated_popup_close, 10, "JS Click");
		this.clickButton(pcfd_order_view_label, 10, "JS Click");
		return text;

	}

	public void create_order_by_walk_in_pickup(String value) throws InterruptedException {
		if (value == "customer") {
			this.clickButton(store_name_select, 10, "JS Click");
			this.clickButton(store_name_first_row_select, 10, "JS Click");
			this.inputText(recipient_select_delivery_date_input, dateFormat(0), 10);
			this.clickButton(walkin_for_pickup_label, 10, "JS Click");
			this.inputText(cus_email_address_input, dummyData("Email"), 10);
			this.inputText(cus_sender_address_input, dummyData("Address1"), 10);
			this.inputText(cus_zip_code_input, "84111", 10);
			Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			this.clickButton(pcfp_customer_next_btn, 10, "JS Click");
			if (!this.conditionChecking(third_stepper_logo_active, 10)) {
				do {
					this.clickButton(pcfp_customer_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(third_stepper_logo_active, 10));
			} else if (value == "messages") {
				this.inputText(delivery_tip_input, randomCharacters("Max 2 Characters"), 10);
				if (this.getTextAttribute(delivery_tip_input, 10).equals("00")) {
					do {
						this.clearField(delivery_tip_input, 10);
						this.inputText(delivery_tip_input, randomCharacters("Max 2 Characters"), 10);
					} while (this.getTextAttribute(delivery_tip_input, 10).equals("00"));
				}
				this.inputText(enter_card_msg_input, randomCharacters("Dummy Description"), 10);
				this.inputText(instruction_to_florist_input, randomCharacters("Dummy Description"), 10);
				if (this.conditionChecking(instruction_to_delivery_driver_input, 2)) {
					this.inputText(instruction_to_delivery_driver_input, randomCharacters("Dummy Description"), 10);
				}
				this.mouseActionClicks(message_next_btn, 10);
				if (!this.conditionChecking(third_stepper_logo_active, 10)) {
					do {
						this.mouseActionClicks(message_next_btn, 10);
					} while (!this.conditionChecking(third_stepper_logo_active, 10));
				}
				this.clickButton(preview_order_next_btn, 10, "JS Click");
				if (!this.conditionChecking(fifth_stepper_logo_active, 10)) {
					do {
						this.clickButton(preview_order_next_btn, 10, "JS Click");
					} while (!this.conditionChecking(fifth_stepper_logo_active, 10));
				}
			}
		}
	}

	public void create_order_by_phone_call_pickup(String value) throws InterruptedException {
		if (value == "customer") {
			this.clickButton(store_name_select, 10, "JS Click");
			this.clickButton(store_name_first_row_select, 10, "JS Click");
			this.inputText(recipient_select_delivery_date_input, dateFormat(0), 10);
//			this.clickButton(walkin_for_pickup_label, 10, "JS Click");
			this.inputText(cus_email_address_input, dummyData("Email"), 10);
			this.inputText(cus_sender_address_input, dummyData("Address1"), 10);
			this.inputText(cus_zip_code_input, "84111", 10);
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			this.clickButton(pcfp_customer_next_btn, 10, "JS Click");
			if (!this.conditionChecking(second_stepper_logo_active, 5)) {
				do {
					this.clickButton(pcfp_customer_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(second_stepper_logo_active, 5));
			}
		} else if (value == "pickup") {
			this.mouseActionClicks(pickup_state_input, 10);
			this.inputText(pickup_state_search, "utah", 10);
			this.clickButton(utah_state, 10, "JS Click");
			this.clickButton(first_row_hub, 10, "JS Click");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 0);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(pickup_next_btn));
			try {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			} catch (Exception e) {
				System.out.println(e);
			}
			this.clickButton(pickup_next_btn, 10, "JS Click");
			if (!this.conditionChecking(third_stepper_logo_active, 10)) {
				do {
					this.clickButton(pickup_next_btn, 10, "JS Click");
				} while (!this.conditionChecking(third_stepper_logo_active, 10));
			}
		}
	}

	public String walkin_for_deliver_order_type() {
		this.clickButton(wfd_order_type, 10, "JS Click");
		this.clickButton(wfd_order_type_next_btn, 10, "JS Click");
		String text = this.getText(check_add_for_delivery_service_label, 10);
		return text;
	}

	public String wfd_address_for_delivery() throws InterruptedException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 0);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(customer_add_next_btn));
//		try {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//		} catch (Exception e) {
		Thread.sleep(3000);
		this.inputText(customer_add_line_1, "Salt Lake City Canal Sewage", 10);
		this.mouseActionClicks(address_1st_row, 10);
		this.clickButton(customer_add_next_btn, 10, "JS Click");
//		this.inputText(customer_add_line_1, "Salt Lake City Canal Sewage", 10);
//		this.clickButton(address_1st_row, 10, "JS Click");
//		if (!this.conditionChecking(customer_add_next_btn, 5)) {
//			do {
//				this.clickButton(address_1st_row, 10, "JS Click");
//			} while (!this.conditionChecking(customer_add_next_btn, 5));
//		}
//		this.clickButton(customer_add_next_btn, 10, "JS Click");
		if (!this.conditionChecking(wfd_form_label, 10)) {
			do {
				this.clickButton(customer_add_next_btn, 10, "JS Click");
			} while (!this.conditionChecking(wfd_form_label, 10));
		}
//		}
		String text = this.getText(wfd_form_label, 10);
		return text;
	}

	public String assign_florist_popup() throws InterruptedException {
		this.mouseActionClicks(assign_florist_btn, 10);
		if (this.conditionChecking(assign_florist_popup_label, 5)) {
			System.out.println("pass");
		} else {
			System.out.println("false");
		}
		String text = this.getText(assign_florist_popup_label, 10);
		return text;
	}

	public String assign_florist() {
		this.mouseActionClicks(florist_name_1st_row, 10);
		if (!this.conditionChecking(assign_florist_popup_btn, 0)) {
			do {
				this.mouseActionClicks(florist_name_1st_row, 10);
			} while (!this.conditionChecking(assign_florist_popup_btn, 0));
		}
		this.clickButton(assign_florist_popup_btn, 10, "JS Click");
		String text = this.getText(assign_florist_succ_label, 10);
		this.clickButton(assign_florist_popup_cls, 10, "JS Click");
		return text;
	}

	public void order_pdf() {
		this.clickButton(pcfd_order_action, 10, "JS Click");
		this.clickButton(pcfd_order_action_view, 10, "JS Click");
		this.clickButton(view_order_PDF, 10, "JS Click");
//		this.clickButton(pcfd_order_view_label, 10, "JS Click");
//		String text = this.getText(order_management_label, 10);
//		return text;
	}

	public String city_filter_invalid_search() throws InterruptedException {
		this.clickButton(filter_select_state, 10, "JS Click");
		this.clearField(filter_select_state_search_input, 10);
		this.inputText(filter_select_state_search_input, "california", 10);
		this.mouseActionClicks(filter_select_state_select, 10);
		Thread.sleep(3000);
		this.inputText(filter_search_city_input, "florida", 10);
		this.mouseActionClicks(filter_select_city, 10);
		this.clickButton(filter_view_btn, 10, "JS Click");
		String text = this.getText(No_records_text, 10);
		return text;
	}

	public String city_filter_valid() throws InterruptedException {
		this.clickButton(city_filter, 10, "JS Click");
		this.clickButton(filter_select_state, 10, "JS Click");
//		this.clearField(filter_select_state_search_input, 10);
		this.inputText(filter_select_state_search_input, "utah", 10);
		this.mouseActionClicks(filter_select_state_select, 10);
		Thread.sleep(3000);
//		this.clearField(filter_search_city_input, 10);
		this.inputText(filter_search_city_input, "salt lake city", 10);
		this.mouseActionClicks(filter_select_city, 10);
		this.clickButton(filter_view_btn, 10, "JS Click");
		String text = this.getText(email_id_1st_position, 10);
		return text;
	}

//Berlin

//Order status change - Order preparation
	public String order_preparation_status_change_popup() throws InterruptedException {
		this.clickButton(pcfd_order_action, 10, "JS Click");
		Thread.sleep(2000);
		this.mouseActionClicks(action_update_status_order_preparation, 10);
		String text = this.getText(update_status_popup_label, 10);
		return text;
	}

	public String status_change_confirm_order_preparation() {
		this.clickButton(order_preparation_status, 10, "JS Click");
		this.clickButton(status_Change_update_btn, 10, "JS Click");
		String text = this.getText(order_status_updated_succ_label, 10);
		this.clickButton(order_status_succ_popup_cls, 10, "JS Click");
		return text;
	}

	public String updated_status() {
		String text = this.getText(list_order_status, 10);
		return text;
	}

//order status change - order packed
	public String order_packed_status_change_popup() throws InterruptedException {
		this.clickButton(pcfd_order_action, 10, "JS Click");
		Thread.sleep(2000);
		this.mouseActionClicks(action_update_status_order_packed, 10);
		String text = this.getText(update_status_popup_label, 10);
		return text;
	}

	public String status_change_confirm_order_packed() {
		this.clickButton(order_packed_status, 10, "JS Click");
		this.clickButton(status_Change_update_btn, 10, "JS Click");
		String text = this.getText(order_status_updated_succ_label, 10);
		this.clickButton(order_status_succ_popup_cls, 10, "JS Click");
		return text;
	}

//Order status change - printed
	public String status_change_confirm_order_printed() {
		this.clickButton(order_printed_status, 10, "JS Click");
		this.clickButton(status_Change_update_btn, 10, "JS Click");
		String text = this.getText(order_status_updated_succ_label, 10);
		this.clickButton(order_status_succ_popup_cls, 10, "JS Click");
		return text;
	}

//Order status change - cancelled
	public String status_change_confirm_order_cancelled() {
		this.clickButton(order_cancelled_status, 10, "JS Click");
		this.clickButton(status_Change_update_btn, 10, "JS Click");
		String text = this.getText(order_status_updated_succ_label, 10);
		this.clickButton(order_status_succ_popup_cls, 10, "JS Click");
		return text;
	}

// order status change for deliver
	public String status_change_confirm_order_delivery() {
		this.clickButton(order_delivered_status, 10, "JS Click");
		this.clickButton(status_Change_update_btn, 10, "JS Click");
		String text = this.getText(order_status_updated_succ_label, 10);
		this.clickButton(order_status_succ_popup_cls, 10, "JS Click");
		return text;
	}

//order status change - order dispatch
	public String dispatch_module() {
		this.clickButton(dispatch_menu, 10, "JS Click");
		String text = this.getText(dispatch_label, 10);
		return text;
	}

	public String assign_driver() {
		this.clickButton(assign_driver_list_btn, 10, "JS Click");
		String text = this.getText(assign_driver_label, 10);
		return text;
	}

	public String select_driver() {
		this.clickButton(assign_manivel, 10, "JS Click");
		this.clickButton(assign_driver_btn, 10, "JS Click");
		String text = this.getText(driver_assigned_succ_label, 10);
		return text;
	}

	public String assign_driver_success() {
		this.clickButton(driver_assinged_popup_cls, 10, "JS Click");
		String text = this.getText(dispatch_status, 10);
		return text;
	}

//customer Blacklist
	public String customer_blacklist_popup() {
		this.clickButton(pcfd_order_action, 10, "JS Click");
		this.clickButton(customer_blacklist_action, 10, "JS Click");
		String text = this.getText(customer_blacklist_popup_label, 10);
		return text;
	}

	public String customer_blacklist_reason() throws InterruptedException {
		Thread.sleep(3000);
		this.inputText(customer_blacklist_popup_reason, "Unauthorized customer", 10);
		this.clickButton(customer_blacklist_popup_yesbtn, 10, "JS Click");
		String text = this.getText(customer_blacklist_succ_lable, 10);
		this.clickButton(customer_blacklist_popup_clsbtn, 10, "JS Click");
		return text;
	}

	public String blacked_user_login() {
		this.create_order();
		this.choose_customer_type();
		this.inputText(customer_phone_num,customer_phone_no, 10);
		this.clickButton(customer_search_btn, 10, "JS Click");
		String text = this.getText(customer_blacklisted_label, 10);
		this.clickButton(customer_blacklisted_popup_cls, 10, "JS Click");
		return text;
	}
// Bulk assign florist
	
	public String bulk_assign_florist() {
		this.clickButton(bulk_assign_florist_btn, 10, "JS Click");
		String text = this.getText(bulk_assign_label, 10);
		return text;
	}
	
	public String search_invalid_hub() {
		this.clickButton(bulk_assign_hub_search, 10, "JS Click");
		this.inputText(bulk_assign_hub_search,"Florida Hub", 10);
		this.clickButton(bulk_assign_hub_select, 10, "JS Click");
		this.clickButton(bulk_assign_view_btn, 10, "JS Click");
		String text = this.getText(bulk_assign_empty_validation, 10);
		return text;
	}
	static String text;
	public String search_valid_hub() throws InterruptedException, AWTException, IOException {
		this.clickButton(bulk_assign_hub_search, 10, "JS Click");
		this.inputText(bulk_assign_hub_search_input,"Salt Lake Hub", 10);
		this.clickButton(bulk_assign_hub_select, 10, "JS Click");
		this.clickButton(bulk_assign_view_btn, 10, "JS Click");
		if (this.getText(By.xpath("//*[@id='pagination-data-container']/tbody/tr/td[2]"), 10).equals("1")) {
			this.clickButton(bulk_assign_selectall, 10, "JS Click");
			this.clickButton(bulk_assign_assign_florist_btn, 10, "JS Click");
			text = this.getText(assign_florist_popup_label, 10);
			Thread.sleep(2000);
			this.assign_florist();
		}else {
			//1st order
			this.clickButton(order_management_menu, 10, "JS Click");
			this.create_order();
			this.choose_customer_type();
			this.customer_details_input();
			this.choose_one_order_type_field();
			this.select_order_type();
			this.address_for_delivery();
			this.create_order_by_phonecall_delivery("customer");
			this.create_order_by_phonecall_delivery("recipient");
			this.create_order_by_phonecall_delivery("product");
			this.create_order_by_phonecall_delivery("messages");
			this.create_order_by_phonecall_delivery("payment");
			//2nd order
			this.clickButton(order_management_menu, 10, "JS Click");
			this.create_order();
			this.choose_customer_type();
			this.customer_details_input();
			this.choose_one_order_type_field();
			this.select_order_type();
			Thread.sleep(2000);
			this.address_for_delivery();
			this.create_order_by_phonecall_delivery("customer");
			this.create_order_by_phonecall_delivery("recipient");
			this.create_order_by_phonecall_delivery("product");
			this.create_order_by_phonecall_delivery("messages");
			this.create_order_by_phonecall_delivery("payment");
			//3rd order
			this.clickButton(order_management_menu, 10, "JS Click");
			this.create_order();
			this.choose_customer_type();
			this.customer_details_input();
			this.choose_one_order_type_field();
			this.select_order_type();
			Thread.sleep(2000);
			this.address_for_delivery();
			this.create_order_by_phonecall_delivery("customer");
			this.create_order_by_phonecall_delivery("recipient");
			this.create_order_by_phonecall_delivery("product");
			this.create_order_by_phonecall_delivery("messages");
			this.create_order_by_phonecall_delivery("payment");
			this.bulk_assign_florist();
			this.clickButton(bulk_assign_hub_search, 10, "JS Click");
			this.inputText(bulk_assign_hub_search_input,"Salt Lake Hub", 10);
			this.clickButton(bulk_assign_hub_select, 10, "JS Click");
			this.clickButton(bulk_assign_view_btn, 10, "JS Click");
			this.clickButton(bulk_assign_selectall, 10, "JS Click");
			this.clickButton(bulk_assign_assign_florist_btn, 10, "JS Click");
			text = this.getText(assign_florist_popup_label, 10);
			this.assign_florist();
		}
		return text;
	}
	
// Track order
	
	public String track_order_page() {
		orderNo = this.getText(Order_Number, 10);
		phoneNO = this.getText(Sender_Phone_Number, 10);
		this.clickButton(track_order_btn,10, "JS Click");
		String text = this.getText(track_order_label, 10);
		return text;
	}
	static String orderNo;
	static String phoneNO;
	public String track_order_edit (String value) throws InterruptedException {
		if (value == "track by order no") {
			this.inputText(track_order_no_input, orderNo, 10);
			this.clickButton(track_order_search_btn, 10, "JS Click");
			this.clickButton(track_order_edit, 10, "JS Click");
			text = this.pcfd_order_edit_confirm();
		}else if (value == "track by phone no") {
			this.inputText(track_order_no_input, phoneNO, 10);
			this.clickButton(track_order_search_btn, 10, "JS Click");
			this.clickButton(track_order_btn_by_phn_no, 10, "JS Click");
			this.clickButton(track_order_edit, 10, "JS Click");
			text = this.pcfd_order_edit_confirm();
		}
		return text;
	}
	

//	Hari harans
	public static By Reset = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[1]/div[1]/div/div[4]/a/button/i");
	By Order_Number = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[2]");
	By Delivery_Pickup_Date = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[3]");
	By Delivery_Pickup_Time = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[4]");
	By Status = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[5]");
	By Sender_First_Name = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[6]");
	By Sender_Last_Name = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[7]");
	By Sender_Phone_Number = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[9]");
	By Recipient_First_Name = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[10]");
	By Recipient_Last_Name = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[11]");
	By Recipient_Zip_Code = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[12]");
	public static By SearchBox = By.id("orderSearch");
	By View = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[1]/div[1]/div/div[3]/p/a/button");
	By Order_Lead_Source = By.xpath("//*[@id='pagination-data-container']/table/tbody/tr[1]/td[17]");
	public static String listRecord;

	public String listValidation(String value) throws IOException {
		if (value.equals("Search Box")) {
			this.inputText(SearchBox, listRecord, 10);
			this.invisible(By.xpath("//*[@id='pagination-data-container' and contains(@style,'none')]"), 10);
		} else if (value.equals("Order Number")) {
			listRecord = this.getText(Order_Number, 10);
			map.put("OrderNumber", listRecord);
		} else if (value.equals("Delivery / Pickup Date")) {
			listRecord = this.getText(Delivery_Pickup_Date, 10);
			map.put("DeliveryPickupDate", listRecord);
		} else if (value.equals("Delivery / Pickup Time")) {
			listRecord = this.getText(Delivery_Pickup_Time, 10);
			map.put("DeliveryPickupTime", listRecord);
		} else if (value.equals("Status")) {
			listRecord = this.getText(Status, 10);
			map.put("Status", listRecord);
		} else if (value.equals("Sender First Name")) {
			listRecord = this.getText(Sender_First_Name, 10);
			map.put("SenderFirstName", listRecord);
		} else if (value.equals("Sender Last Name")) {
			listRecord = this.getText(Sender_Last_Name, 10);
			map.put("SenderLastName", listRecord);
		} else if (value.equals("Sender Phone Number")) {
			listRecord = this.getText(Sender_Phone_Number, 10);
			map.put("SenderPhoneNumber", listRecord);
		} else if (value.equals("Recipient First Name")) {
			listRecord = this.getText(Recipient_First_Name, 10);
		} else if (value.equals("Recipient Last Name")) {
			listRecord = this.getText(Recipient_Last_Name, 10);
		} else if (value.equals("Lead Source")) {
			listRecord = this.getText(Order_Lead_Source, 10);
			map.put("LeadSource", listRecord);
		}
		return listRecord;
	}

	public void storeValue() throws IOException {
		this.listValidation("Delivery / Pickup Date");
		this.listValidation("Delivery / Pickup Time");
		this.listValidation("Status");
		this.listValidation("Lead Source");
		map.put("CustomerFirstName", CustomerFirstName);
		map.put("CustomerLastName", CustomerLastName);
		this.propertyInputValue("Customer Lookup", map);
	}
}
