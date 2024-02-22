package org.kona.pageobjectclass;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class House_account_module extends BaseClass {

	public House_account_module(WebDriver driver) {
		this.driver = driver;
	}

//house account menu
	By house_account_menu = By.xpath("//a[@id='house_account_side_bar']");
	By house_account_lable = By.xpath("//h4[text()='House Account']");
//house account create errors
	By business_name_err_msg = By.xpath("//strong[text()='The business name field is required.']");
	By Billing_contact_first_name_err_msg = By
			.xpath("//strong[text()='The billing contact first name field is required.']");
	By Billing_contact_last_name_err_msg = By
			.xpath("//strong[text()='The billing contact last name field is required.']");
	By contact_mail_err_msg = By.xpath("//strong[text()='The contact email field is required.']");
	By contact_phone_err_msg = By.xpath("//strong[text()='The contact phone field is required.']");
	By billing_address_err_msg = By.xpath("//strong[text()='The billing address field is required.']");
	By monthly_invoice_date_err_msg = By.xpath("//strong[text()='The monthly invoice date field is required.']");
	By monthly_autopay_date_err_msg = By.xpath("//strong[text()='The monthly autopay date field is required.']");
	By payment_due_date_err_msg = By.xpath("//strong[text()='The payment due date field is required.']");
	By hub_err_msg = By.xpath("//strong[text()='The hub field is required.']");
	By store_err_msg = By.xpath("//strong[text()='The store field is required.']");
	By monthly_auto_pay_lesser_date = By
			.xpath("//strong[text()='The monthly autopay date must be greater than or equal 13.']");
	By invalid_email_err = By.xpath("//strong[text()='The contact email format is invalid.']");
	// card details error msg
	By name_on_card_err_msg = By.xpath("//strong[text()='The name on card field is required']");
	By card_num_err_msg = By.xpath("//strong[text()='The card number field is required']");
	By expiry_date_err_msg = By.xpath("//strong[text()='The expiry month field is required.']");
	By expiry_year_err_msg = By.xpath("//strong[text()='The expiry year field is required']");
	By cvv_err_msg = By.xpath("//strong[text()='The cvv field is required']");
	By card_number_16char_validation = By
			.xpath("//strong[text()='The card number may not be greater than 16 numbers.']");
	By cvv_4char_validation = By.xpath("//strong[text()='The cvv field may not be greater than 4 numbers']");
//house account create
	By create_house_account_btn = By.xpath("//*[@id=\"base-content-page\"]/div[1]/nav/div/div/div[2]/div/a");
	By create_house_account_label = By.xpath("//a[text()=' Create House Account']");
	By business_name_input = By.xpath("//input[@id='business_name']");
	By billing_contact_first_name_input = By.xpath("//input[@id='billing_contact']");
	By billing_contact_last_name_input = By.xpath("//input[@id='billing_last_contact']");
	By contact_email_input = By.xpath("//input[@id='contact_email']");
	By contact_phone_no_input = By.xpath("//input[@id='contact_phone']");
	By billing_add_input = By.xpath("//textarea[@id='billing_address']");
	By billing_add_dd = By.xpath("/html/body/div[3]/div[1]");
	By zip_code_input = By.xpath("//input[@id='zip_code_search']");
//	By city_dd_input = By.xpath("//*[@id=\"houseAccountForm\"]/div[3]/div[3]/div[1]/div");
//	By city_dd_2nd_index = By.xpath("")
	By monthly_invoice_date_dd = By.xpath("//select[@id='monthly_invoice_date']");
	By monthly_autopay_date_dd = By.xpath("//select[@id='monthly_autopay_date']");
	By payment_due_date = By.xpath("//select[@id='payment_due_date']");
	By hub_dd = By.xpath("//*[@id=\"hide-hub\"]/div/div/button");
	By hub_dd_2nd_index = By.xpath("//*[@id=\"hide-hub\"]/div/div/ul/li[3]/a/label/input");

	By store_dd = By.xpath("//*[@id=\"hide-store\"]/div/div/button");
	By store_dd_2nd_index = By.xpath("//*[@id=\"hide-store\"]/div/div/ul/li[3]/a/label");
	By house_account_save_btn = By.xpath("//*[@id=\"base-content-page\"]/div[1]/div/div/div/div[4]/div/span[1]/button");
//house account create popup
	By house_accout_created_lable = By
			.xpath("//h2[text()='House Account Created Successfully. Please add the card details']");
	By house_accout_created_popup_close = By.xpath("//*[@id=\"popup-save\"]/div/div/div/div/div/a/button");
//create card details
	By add_card_details_label = By.xpath("//h5[text()='Add Card Details:']");
	By name_on_card_input = By.xpath("//input[@id='name_on_card_1']");
	By card_number_input = By.xpath("//input[@id='card_number_1']");
	By expiry_month_dd = By.xpath("//select[@id='expiry_date_1']");
	By expiry_year_dd = By.xpath("//select[@id='expiry_year_1']");
	By cvv_input = By.xpath("//input[@id='cvv_1']");
	By card_details_save_btn = By.xpath("//*[@id=\"base-content-page\"]/div[1]/div/div/div/div[5]/div/span[1]/button");
	By card_info_added_label = By.xpath("//h3[text()='Your card information have been succesfully added']");
	By card_info_added_popup_close = By.xpath("//*[@id=\"popup-add-card\"]/div[1]/div/div/div[2]/div[2]/a/button");
//search
	By house_acc_name_search = By.xpath("//input[@id='houseSearch']");
	By search_view_btn = By.xpath("//*[@id=\"base-content-page\"]/div[1]/div/div[1]/div/div[1]/div[2]/a/button");
//View action
	By account_1st_position_view_action = By.xpath("//*[@id=\"house_account_list1\"]/tbody/tr[1]/td[9]/div/span/a/img");
	By view_payment_details_label = By.xpath("//a[text()='View Payment Details']");
//edit action
	By account_1st_position_edit_action = By.xpath("//*[@id=\"house_account_list1\"]/tbody/tr[1]/td[9]/div/a[5]/img");
	By edit_house_acc_label = By.xpath("//a[text()=' Edit House Account']");
	By house_acc_update_btn = By.xpath("//button[text()='Update']");
	By house_acc_update_succ_label = By.xpath("//h2[text()='House Account Updated Successfully']");
	By house_acc_update_succ_popup_cls = By.xpath("//*[@id=\"popup-update\"]/div/div/div/div/div/a/button");
	By list_house_acc_1st_name = By.xpath("//*[@id=\"house_account_list1\"]/tbody/tr/td[3]");
//delete action
	By account_1st_delete_action = By.xpath("//*[@id=\"house_account_list1\"]/tbody/tr[1]/td[9]/div/a[6]/img");
	By yes_confirm_btn = By.xpath("//button[text()='Yes, Confirm']");
	By delete_house_acc_label = By.xpath("//h4[text()='Delete House Account']");
	By delete_house_acc_confirm = By.xpath("//h2[text()='House Account Deleted Successfully']");
	By delete_confirm_popup_close = By.xpath("//*[@id=\"popup-delete-house\"]/div/div/div/div/div/a/button");
//download
	By download = By.xpath("//*[@id=\"house_account_list1\"]/tbody/tr[1]/td[9]/div/a[1]/img");

	public String house_account_module() {
		this.clickButton(house_account_menu, 10, "JS Click");
		String text = this.getText(house_account_lable, 10);
		return text;
	}

	public void buttonClick() {
		this.clickButton(house_account_save_btn, 10, "JS Click");
	}

	public String create_house_account_form() {
		this.clickButton(create_house_account_btn, 10, "JS Click");
		String text = this.getText(create_house_account_label, 10);
		return text;
	}

	public String house_account_create_empty_validation(String value) {
		if (value == "business_name_validation") {
			if (this.conditionChecking(business_name_err_msg, 3)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(business_name_err_msg, 3));
			}
			String text = this.getText(business_name_err_msg, 10);
			return text;
		} else if (value == "billing_contact_first_name_validation") {
			if (this.conditionChecking(Billing_contact_first_name_err_msg, 3)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(Billing_contact_first_name_err_msg, 3));
			}
			String text = this.getText(Billing_contact_first_name_err_msg, 10);
			return text;
		} else if (value == "billing_contact_last_name_validation") {
			if (!this.conditionChecking(Billing_contact_last_name_err_msg, 3)) {
				do {
					this.buttonClick();
				} while (this.conditionChecking(Billing_contact_last_name_err_msg, 3));
			}
			String text = this.getText(Billing_contact_last_name_err_msg, 10);
			return text;
		} else if (value == "contact_email_validation") {
			if (!this.conditionChecking(contact_mail_err_msg, 3)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(contact_mail_err_msg, 3));
			}
			String text = this.getText(contact_mail_err_msg, 10);
			return text;
		} else if (value == "contact_phone_err_msg") {
			if (!this.conditionChecking(contact_phone_err_msg, 3)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(contact_phone_err_msg, 3));
			}
			String text = this.getText(contact_phone_err_msg, 10);
			return text;
		} else if (value == "billing_add_err_msg") {
			if (!this.conditionChecking(billing_address_err_msg, 3)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(billing_address_err_msg, 3));
			}
			String text = this.getText(billing_address_err_msg, 10);
			return text;
		} else if (value == "monthly_invoice_date_err_msg") {
			if (!this.conditionChecking(monthly_invoice_date_err_msg, 3)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(monthly_invoice_date_err_msg, 3));
			}
			String text = this.getText(monthly_invoice_date_err_msg, 10);
			return text;
		} else if (value == "monthly_auto_pay_date_err_msg") {
			if (!this.conditionChecking(monthly_autopay_date_err_msg, 3)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(monthly_autopay_date_err_msg, 3));
			}
			String text = this.getText(monthly_autopay_date_err_msg, 10);
			return text;
		} else if (value == "payment_due_date_err_msg") {
			if (!this.conditionChecking(payment_due_date_err_msg, 3)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(payment_due_date_err_msg, 3));
			}
			String text = this.getText(payment_due_date_err_msg, 10);
			return text;
		} else if (value == "hub_err_msg") {
			if (!this.conditionChecking(hub_err_msg, 3)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(hub_err_msg, 3));
			}
			String text = this.getText(hub_err_msg, 10);
			return text;
		} else if (value == "store_err_msg") {
			if (!this.conditionChecking(store_err_msg, 3)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(store_err_msg, 3));
			}
			String text = this.getText(store_err_msg, 10);
			return text;
		} else if (value == "name_on_card_err_msg") {
			if (!this.conditionChecking(name_on_card_err_msg, 3)) {
				do {
					this.clickButton(card_details_save_btn, 10, "JS Click");
				} while (!this.conditionChecking(name_on_card_err_msg, 3));
			}
			String text = this.getText(name_on_card_err_msg, 10);
			return text;
		} else if (value == "card_num_err_msg") {
			if (!this.conditionChecking(card_num_err_msg, 3)) {
				do {
					this.clickButton(card_details_save_btn, 10, "JS Click");
				} while (!this.conditionChecking(card_num_err_msg, 3));
			}
			String text = this.getText(card_num_err_msg, 10);
			return text;
		} else if (value == "expiry_date_err_msg") {
			if (!this.conditionChecking(expiry_date_err_msg, 3)) {
				do {
					this.clickButton(card_details_save_btn, 10, "JS Click");
				} while (!this.conditionChecking(expiry_date_err_msg, 3));
			}
			String text = this.getText(expiry_date_err_msg, 10);
			return text;
		} else if (value == "expiry_year_err_msg") {
			if (!this.conditionChecking(expiry_year_err_msg, 3)) {
				do {
					this.clickButton(card_details_save_btn, 10, "JS Click");
				} while (!this.conditionChecking(expiry_year_err_msg, 3));
			}
			String text = this.getText(expiry_year_err_msg, 10);
			return text;
		} else if (value == "cvv_err_msg") {
			if (!this.conditionChecking(cvv_err_msg, 3)) {
				do {
					this.clickButton(card_details_save_btn, 10, "JS Click");
				} while (!this.conditionChecking(cvv_err_msg, 3));
			}
			String text = this.getText(cvv_err_msg, 10);
			return text;
		} else if (value == "invalid_email_err") {
			this.inputText(contact_email_input, "a1", 10);
			this.buttonClick();
			if (!this.conditionChecking(invalid_email_err, 3)) {
				do {
					this.clickButton(card_details_save_btn, 10, "JS Click");
				} while (!this.conditionChecking(invalid_email_err, 3));
			}
			String text = this.getText(invalid_email_err, 10);
			return text;
		}
		return value;
	}

	public String monthly_auto_pay_lesser_date() {
		this.dropDownByIndex(monthly_invoice_date_dd, 10, 10);
		this.dropDownByIndex(monthly_autopay_date_dd, 10, 6);
		String text = this.getText(monthly_autopay_date_err_msg, 10);
		this.buttonClick();
		return text;
	}

	public String payment_due_lesser_date() {
		this.dropDownByIndex(monthly_invoice_date_dd, 10, 10);
		this.dropDownByIndex(monthly_autopay_date_dd, 10, 12);
		this.dropDownByIndex(payment_due_date, 10, 5);
		String text = this.getText(payment_due_date_err_msg, 10);
		this.buttonClick();
		return text;
	}

	public static String house_account_name;

	public String create_house_account() throws InterruptedException {
		this.inputText(business_name_input, dummyData("Business Name"), 10);
		house_account_name = this.getTextAttribute(business_name_input, 10);
		this.inputText(billing_contact_first_name_input, dummyData("First Name"), 10);
		this.inputText(billing_contact_last_name_input, dummyData("Last Name"), 10);
		this.inputText(contact_email_input, dummyData("Email"), 10);
		this.inputText(contact_phone_no_input, dummyData("Phone Number"), 10);
		this.inputText(billing_add_input, "Saltlake Dr", 10);
		this.mouseActionClicks(billing_add_dd, 10);
		Thread.sleep(2500);
		if (!(this.getTextAttribute(zip_code_input, 10).length() > 0)) {
			this.inputText(zip_code_input, "84115", 10);
		}
		this.dropDownByIndex(monthly_invoice_date_dd, 10, 10);
		this.dropDownByIndex(monthly_autopay_date_dd, 10, 12);
		this.dropDownByIndex(payment_due_date, 10, 15);
		this.clickButton(hub_dd, 10, "JS Click");
		this.clickButton(hub_dd_2nd_index, 10, "JS Click");
		this.clickButton(store_dd, 10, "JS Click");
		this.clickButton(store_dd_2nd_index, 10, "JS Click");
		this.buttonClick();
		String text = this.getText(house_accout_created_lable, 10);
		return text;
	}

	public String add_card_details_form() {
		this.clickButton(house_accout_created_popup_close, 10, "JS Click");
		String text = this.getText(add_card_details_label, 10);
		return text;
	}

	public String card_num_max_validation() {
		this.inputText(card_number_input, "8738778723827232323", 10);
		this.clickButton(card_details_save_btn, 10, "JS Click");
		String text = this.getText(card_number_16char_validation, 10);
		return text;
	}

	public String cvv_num_max_validation() {
		this.inputText(cvv_input, "3748347", 10);
		this.clickButton(card_details_save_btn, 10, "JS Click");
		String text = this.getText(cvv_4char_validation, 10);
		return text;
	}

	public String add_card_details() {
		this.inputText(name_on_card_input, dummyData("First Name"), 10);
		this.clearField(card_number_input, 10);
		this.inputText(card_number_input, randomCharacters("Max 16 Characters"), 10);
		this.dropDownByIndex(expiry_month_dd, 10, 10);
		this.dropDownByIndex(expiry_year_dd, 10, 5);
		this.clearField(cvv_input, 10);
		this.inputText(cvv_input, randomCharacters("Max 4 Characters"), 10);
		this.clickButton(card_details_save_btn, 10, "JS Click");
		String text = this.getText(card_info_added_label, 10);
		this.clickButton(card_info_added_popup_close, 10, "JS Click");
		return text;
	}

	public String house_acc_name_view_action() throws InterruptedException {
		this.clickButton(house_acc_name_search, 10, "JS Click");
		this.inputText(house_acc_name_search, house_account_name, 10);
		this.clickButton(search_view_btn, 10, "JS Click");
//		this.clickButton(download, 10, "JS Click");
		Thread.sleep(2000);
		this.clickButton(account_1st_position_view_action, 10, "JS Click");
		String text = this.getText(view_payment_details_label, 10);
		this.clickButton(view_payment_details_label, 10, "JS Click");
		return text;
	}

	private void download() {
		this.clickButton(house_acc_name_search, 10, "JS Click");
		this.inputText(house_acc_name_search, house_account_name, 10);
		this.clickButton(search_view_btn, 10, "JS Click");
		this.clickButton(download, 10, "JS Click");

	}

	public String house_acc_edit_action() throws InterruptedException {
		this.clickButton(house_acc_name_search, 10, "JS Click");
		this.inputText(house_acc_name_search, house_account_name, 10);
		if (!this.conditionChecking(search_view_btn, 10)) {
			do {
				this.inputText(house_acc_name_search, house_account_name, 10);
			} while (!this.conditionChecking(search_view_btn, 10));
		}
		this.clickButton(search_view_btn, 10, "JS Click");
		Thread.sleep(2000);
		this.visible(list_house_acc_1st_name, 10);
		this.clickButton(account_1st_position_edit_action, 10, "JS Click");
		if (!this.conditionChecking(edit_house_acc_label, 10)) {
			do {
				this.clickButton(account_1st_position_edit_action, 10, "JS Click");
			} while (!this.conditionChecking(edit_house_acc_label, 10));
		}
		String text = this.getText(edit_house_acc_label, 10);
		return text;
	}

	public static String busiz_name;

	public String update_business_name() throws InterruptedException {
		this.valuePresentCondition(business_name_input, 10, house_account_name);
		Thread.sleep(5000);
		this.clearField(business_name_input, 10);
		this.inputText(business_name_input, dummyData("Business Name"), 10);
		busiz_name = this.getTextAttribute(business_name_input, 10);
		this.clickButton(house_acc_update_btn, 10, "JS Click");
		String text = this.getText(house_acc_update_succ_label, 10);
		this.clickButton(house_acc_update_succ_popup_cls, 10, "JS Click");
		return text;
	}

	public String validate_edited_house_acc_name() {
		this.clickButton(house_acc_name_search, 10, "JS Click");
		this.inputText(house_acc_name_search, busiz_name, 10);
		this.clickButton(search_view_btn, 10, "JS Click");
		if (!this.conditionChecking(list_house_acc_1st_name, 10)) {
			do {
				this.clickButton(search_view_btn, 10, "JS Click");
			} while (!this.conditionChecking(list_house_acc_1st_name, 10));
		}
		String text = this.getText(list_house_acc_1st_name, 10);
		return text;
	}

	public String delete_house_acc() throws InterruptedException {
		Thread.sleep(2500);
		this.clickButton(account_1st_delete_action, 10, "JS Click");
		String text = this.getText(delete_house_acc_label, 10);
		return text;
	}

	public String delete_confirm_house_acc() {
		this.clickButton(yes_confirm_btn, 10, "JS Click");
		if (!this.conditionChecking(delete_house_acc_confirm, 3)) {
			do {
				this.clickButton(yes_confirm_btn, 10, "JS Click");
			} while (!this.conditionChecking(delete_house_acc_confirm, 3));
		}
		String text = this.getText(delete_house_acc_confirm, 10);
		this.clickButton(delete_confirm_popup_close, 10, "JS Click");
		return text;
	}

}
