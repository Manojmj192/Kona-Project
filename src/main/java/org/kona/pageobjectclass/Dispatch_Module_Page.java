package org.kona.pageobjectclass;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dispatch_Module_Page extends BaseClass {
	@SuppressWarnings("static-access")
	public Dispatch_Module_Page(WebDriver driver) {
		this.driver = driver;
	}

	By Form_Label = By.xpath("//*[@id='base-content-page']/div[1]/nav/div/div/div[1]/h4");

	By Dispatch = By.id("dispatch_side_bar");
	By Search_Box = By.id("dispatchSearch");
	By Delivery_Driver = By
			.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div/button");
	By Delivery_Driver_List = By.xpath("//*[@id='deliveryDriver']//following-sibling::div//ul//li[2]");
	By Delivery_Route = By
			.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[2]/div/div/div[1]/div/div/div[2]/div/button");
//	By Delivery_Route_List = By.xpath("//*[@id='deliveryRoute']//following-sibling::div//ul//li[2]");
	By Date = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[2]/div/div/div[1]/div/div/div[3]/div/button");
	By Delivery_Date = By.xpath("delivery_date");
	By Select_Time_Range = By
			.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[2]/div/div/div[1]/div/div/div[4]/div/button");
//	By Select_Time_Range_List = By.xpath("//*[@id='time_range']//following-sibling::div//ul//li[2]");
	By Status = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[2]/div/div/div[1]/div/div/div[5]/div/button");
	By Packed_Status = By.xpath("//*[@id='dispatchStatus']//following-sibling::div//ul//li[2]");
	By Dispatch_Status = By.xpath("//*[@id='dispatchStatus']//following-sibling::div//ul//li[3]");
	By View = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[2]/div/div/div[2]/a/button");

//	list
	By List_Order_Number = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[3]");
	By List_Customer_Name = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[4]");
	By List_Driver_Assign = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[9]/input");
	By List_Status = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[10]");
//	By Three_Dots = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[11]//div//button//i");
	@FindAll({ @FindBy(xpath = "//*[@id='pagination-data-container']//tbody//tr[1]//td[20]//div//button"),
			@FindBy(xpath = "//*[@id='pagination-data-container']/tbody/tr[1]/td[11]//div//button//i") })
	WebElement Three_Dots;
	By UnAssign = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[11]//div//ul//li[3]");
	By List_Delivey_Route = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[6]");
	By List_Delivey_Schedule_Date = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[7]");
	By List_Delivey_Schedule_Time = By.xpath("//*[@id='pagination-data-container']/tbody/tr[1]/td[8]");

//	Oder List
	By List_Update = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[20]//div//ul//li[2]");

	public String modulePage(String value) {
		switch (value) {
		case "Module":
			this.clickButton(Dispatch, 10, "JS Click");
			break;
		default:
			return this.getText(Form_Label, 10);
		}
		return value;
	}

	static By Delivery_Route_List;
	static By Select_Time_Range_List;
	static String List_Delivery_Date_Input;
	static String listRecord;

	public void listValidation(String value) {
		switch (value) {
		case "Search Field":
			this.inputText(Search_Box, listRecord, 10);
			this.clickButton(View, 10, "JS Click");
			break;
		case "Order Number":
			listRecord = this.getText(List_Order_Number, 10);
			break;
		case "Customer Name":
			listRecord = this.getText(List_Customer_Name, 10);
			break;
		case "Delivery Schedule Date":
			listRecord = this.getText(List_Delivey_Schedule_Date, 10);
			break;
		case "Delivery Schedule Time":
			listRecord = this.getText(List_Delivey_Schedule_Time, 10);
			break;
		case "Delivery Route":
			listRecord = this.getText(List_Delivey_Route, 10);
			break;
		case "Update Status":
			this.clickButton(Three_Dots, 10, "JS Click");

			break;
		default:
			switch (value) {
			case "Delivery Route":
				Delivery_Route_List = By.xpath(
						"//*[@id='base-content-page']/div[1]/div[1]/div[2]/div/div/div[1]/div/div/div[2]/div/ul/li/a/label[contains(text(),'"
								+ listRecord + "')]");
				break;
			case "Delivery Schedule Time":
				Select_Time_Range_List = By
						.xpath("//*[@id='time_range']//following-sibling::div//ul//li//a//label[contains(text(),'')]");
				break;
			case "Delivery Schedule Date":
				List_Delivery_Date_Input = listRecord.replace("-", "/");
				break;
			default:
				break;
			}
			break;
		}
	}

	public String orderCreate() throws InterruptedException, AWTException, IOException {
		Order_management_module module = PageFactory.initElements(driver, Order_management_module.class);
		module.Order_management_menu();
		module.create_order();
		module.choose_customer_type();
		module.customer_details_input();
		module.choose_one_order_type_field();
		module.select_order_type();
		module.address_for_delivery();
		module.create_order_by_phonecall_delivery("customer");
		module.create_order_by_phonecall_delivery("recipient");
		module.create_order_by_phonecall_delivery("product");
		module.create_order_by_phonecall_delivery("messages");
		return module.create_order_by_phonecall_delivery("payment");
	}

}