package org.kona.pageobjectclass;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Customer_Lookup_Page extends BaseClass {
	public static String FirstName;
	public static String LastName;
	public static String Email;
	public static String PhoneNumber;

	@SuppressWarnings("static-access")
	public Customer_Lookup_Page(WebDriver driver) {
		this.driver = driver;
	}

	By Customer_Lookup = By.id("customer_lookup_side_bar");
	By Module_Label = By.xpath("//*[@id='base-content-page']/nav/div[2]/div/div/h4/a");
	By Edit_Label = By.xpath("//*[@id='popup-customer-edit']/div/div/div[1]/h4");
	By Search_Customer_Name = By
			.xpath("//*[@id='customer_lookup_screen']/div[1]/div/div[2]/div[1]/div/div/div[1]/span/span[1]/span");
	By List_Customer_Name = By.xpath("//*[@id='select2-selUser-results']//li");
	By Search_Box = By.id("customerSearchDetails");
	By View = By.xpath("//*[@id='customer_lookup_screen']/div[1]/div/div[2]/div[2]/a/button");
	By Reset = By.xpath("//*[@id='customer_lookup_screen']/div[1]/div/div[2]/div[3]/a/button");
	public static By Order_Tab = By.xpath("//*[@id='customer_details']/div[4]/label[2]");

//	Customer Dashboard
	By Customer_Dashboard_PhoneNumber = By.id("customer_phone_number");
	By Customer_Dashboard_Name = By.id("customer_first_last_name");
	By Customer_Dashboard_Email = By.id("customer_email");
	By Customer_Search_Field = By.id("recipientDashboardSearch");
	By Customer_View = By.xpath("//*[@id='viewCustomerDashboard']/a/button[text()='View']");
	By Customer_Reset = By.xpath("//*[@id='viewCustomerDashboard']/a/button[text()='Reset']");

//	List
	By List_Recipient_First_Name = By.xpath("//*[@id='customer_dashboard_recipient_details']//tr[2]//td[2]");
	By List_Recipient_Last_Name = By.xpath("//*[@id='customer_dashboard_recipient_details']//tr[2]//td[3]");
	By List_Recipient_Phone_Number = By.xpath("//*[@id='customer_dashboard_recipient_details']//tr[2]//td[4]");
	By List_Recipient_Email = By.xpath("//*[@id='customer_dashboard_recipient_details']//tr[2]//td[5]");
	By List_Order_Status = By.xpath("//*[@id='customer_dashboard_order_details']//tr[2]//td[2]");
	By List_Order_Number = By.xpath("//*[@id='customer_dashboard_order_details']//tr[2]//td[3]");
	By List_Order_Recipient_Name = By.xpath("//*[@id='customer_dashboard_order_details']//tr[2]//td[5]");
	By List_Order_Recipient_Email = By.xpath("//*[@id='customer_dashboard_order_details']//tr[2]//td[6]");
	By List_Order_Delivery_Pickup_Date = By.xpath("//*[@id='customer_dashboard_order_details']//tr[2]//td[7]");
	By List_Order_Delivery_Pickup_Time = By.xpath("//*[@id='customer_dashboard_order_details']//tr[2]//td[8]");
	By List_Order_Lead_Source = By.xpath("//*[@id='customer_dashboard_order_details']//tr[2]//td[9]");

//	Edit Customer Dashboard
	By Edit = By.xpath("//*[@id='customer_details']/div[2]/p[1]/a/i");
	By Popup = By.xpath("//*[@id='popup-customer-edit' and contains(@style,'none')]//div[1]//div[1]//h4");
	public static By Sender_First_Name = By.id("edit_customer_first_name");
	By Sender_Last_Name = By.id("edit_customer_last_name");
	By Sender_Email = By.id("edit_customer_email");
	By Sender_Phone_Number = By.id("edit_customer_phone_number");

//	Error Field
	By Error_Sender_First_Name = By.xpath("//*[contains(@class,'customer_name_form_error')]");
	By Error_Sender_Last_Name = By.xpath("//*[contains(@class,'customer_last_name_form_error')]");
	By Error_Sender_Email = By.xpath("//*[contains(@class,'customer_email_form_error')]");
	By Error_Sender_Phone_Number = By.xpath("//*[contains(@class,'customer_phone_number_form_error')]");
	public static By Submit_Button = By.xpath("//*[@id='popup-customer-edit']/div/div/div[2]/div/div[11]/button");
	By Message = By.xpath("//*[contains(@class,'toast-message')]");

	public String modulePage(String value) {
		switch (value) {
		case "Module":
			this.clickButton(Customer_Lookup, 10, "JS Click");
			return this.getText(Module_Label, 10);
		case "Edit":
			this.clickButton(Edit, 10, "JS Click");
			this.invisible(Popup, 10);
			return this.getText(Edit_Label, 10);
		default:
			break;
		}
		return value;
	}

	public String filterValidation(String value) throws IOException {
		if (value.equals("Customer Filter Lookup") || value.equals("Get Value")) {
			if (value.equals("Get Value")) {
				this.mouseActionClicks(Search_Customer_Name, 10);
				String text = this.getText(By.xpath("//*[@id='select2-selUser-results']//li[contains(text(),'"
						+ getUpdatedPropertyFile("Customer LookUp", "SenderFirstName") + " "
						+ getUpdatedPropertyFile("Customer LookUp", "SenderLastName") + "')]"), 10);
				this.mouseActionClicks(By.xpath("//*[@id='select2-selUser-results']//li[contains(text(),'"
						+ getUpdatedPropertyFile("Customer LookUp", "SenderFirstName") + " "
						+ getUpdatedPropertyFile("Customer LookUp", "SenderLastName") + "')]"), 10);
				String[] split = text.split(" - ");
				FirstName = split[0];
				Email = split[1];
				PhoneNumber = split[2];
			}
			this.clickButton(View, 10, "JS Click");
		}
		switch (value) {
		case "First Name":
			return this.getText(Customer_Dashboard_Name, 10);
		case "Email":
			return this.getText(Customer_Dashboard_Email, 10);
		case "Phone Number":
			return this.getText(Customer_Dashboard_PhoneNumber, 10);
		case "Recipient First Name":
			return this.getText(List_Recipient_First_Name, 10);
		case "Recipient Last Name":
			return this.getText(List_Recipient_Last_Name, 10);
		case "Recipient Phone Number":
			return this.getText(List_Recipient_Phone_Number, 10);
		case "Recipient Email Address":
			return this.getText(List_Recipient_Email, 10);
		case "Order Status":
			return this.getText(List_Order_Status, 10);
		case "Order Number":
			return this.getText(List_Order_Number, 10);
		case "Order Recipient Name":
			return this.getText(List_Order_Recipient_Name, 10);
		case "Order Recipient Email":
			return this.getText(List_Order_Recipient_Email, 10);
		case "Order Recipient Pickup Date":
			return this.getText(List_Order_Delivery_Pickup_Date, 10);
		case "Order Recipient Pickup Time":
			return this.getText(List_Order_Delivery_Pickup_Time, 10);
		case "Order Lead Source":
			return this.getText(List_Order_Lead_Source, 10);
		default:
			break;
		}
		return value;
	}

	public String editPrepopulate(String value) {
		switch (value) {
		case "Sender First Name":
			return this.getTextAttribute(Sender_First_Name, 10);
		case "Sender Last Name":
			return this.getTextAttribute(Sender_Last_Name, 10);
		case "Sender Phone Number":
			return this.getTextAttribute(Sender_Phone_Number, 10);
		case "Sender Email":
			return this.getTextAttribute(Sender_Email, 10);
		default:
			break;
		}
		return value;
	}

	public void clearField(String value) {
		switch (value) {
		case "Sender First Name":
			this.clearField(Sender_First_Name, 10);
			break;
		case "Sender Last Name":
			this.clearField(Sender_Last_Name, 10);
			break;
		case "Sender Email":
			this.clearField(Sender_Email, 10);
			break;
		case "Sender Phone Number":
			this.clearField(Sender_Phone_Number, 10);
			break;
		default:
			break;
		}
	}

	public String checkError(Object element) {
		int i = 0;
		if (!this.conditionChecking(element, 2)) {
			do {
				this.clickButton(Submit_Button, 10, "JS Click");
				i++;
			} while ((!this.conditionChecking(element, 2)) && i < 5);
		}
		if (i == 5) {
			return "null";
		} else {
			return this.getText(element, 10);
		}
	}

	public String errorField(String value) {
		switch (value) {
		case "Sender First Name":
			return this.checkError(Error_Sender_First_Name);
		case "Sender Last Name":
			return this.checkError(Error_Sender_Last_Name);
		case "Sender Phone Number":
			return this.checkError(Error_Sender_Phone_Number);
		case "Sender Email":
			return this.checkError(Error_Sender_Email);
		default:
			break;
		}
		return value;
	}

	public void customerNameSplit() {
		String[] split = FirstName.split(" ");
		FirstName = split[0];
		LastName = split[1];
	}

	public void clearAllFields() {
		List<String> asList = Arrays.asList("Sender First Name", "Sender Last Name", "Sender Email");
		for (int i = 0; i < asList.size(); i++) {
			this.clearField(asList.get(i));
		}
	}

	public void emailField(String value) throws IOException {
		switch (value) {
		case "Invalid":
			this.inputText(Sender_Email, "fdssfsdds", 10);
			this.clickButton(Submit_Button, 10, "JS Click");
			this.invisible(By.xpath("//*[text()='" + getPropertyValue("email_add_required_err") + "']"), 10);
			break;
		default:
			break;
		}
	}

	public void validRecords() throws IOException {
		this.inputText(Sender_First_Name, getUpdatedPropertyFile("Customer LookUp", "SenderFirstName"), 10);
		this.inputText(Sender_Last_Name, getUpdatedPropertyFile("Customer LookUp", "SenderLastName"), 10);
		this.inputText(Sender_Email, dummyData("Email"), 10);
		this.clickButton(Submit_Button, 10, "JS Click");
	}

	public String submissionValidation() throws IOException {
		if (this.conditionChecking(Message, 10)) {
		} else {
			do {
				if (this.conditionChecking(Error_Sender_Email, 2)) {
					if (this.getText(Error_Sender_Email, 10).equals(getPropertyValue("CustomerLookupAlreadyEmail"))) {
						this.clearField("Sender Email");
						this.inputText(Sender_Email, dummyData("Email"), 10);
					}
					if (this.conditionChecking(Submit_Button, 2)) {
						this.clickButton(Submit_Button, 10, "JS Click");
					}
				}
			} while (!this.conditionChecking(Message, 10));
		}
		return this.getText(Message, 10);
	}

}
