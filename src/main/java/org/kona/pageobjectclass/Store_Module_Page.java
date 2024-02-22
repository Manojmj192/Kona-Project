package org.kona.pageobjectclass;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Store_Module_Page extends BaseClass {
	Map<String, String> map = new HashMap<>();

	@SuppressWarnings("static-access")
	public Store_Module_Page(WebDriver driver) {
		this.driver = driver;
	}

//	navigate function
	By Store = By.id("store_side_bar");
	By Create_Store = By.xpath("//*[@id='base-content-page']/div[1]/nav/div/div/div[2]/div/a");
	@FindAll({ @FindBy(xpath = "//*[text()=' Create Store']"), @FindBy(xpath = "//*[text()='Store Management']"),
			@FindBy(xpath = "//a[text()='Edit Store']"), })
	WebElement Form_Label;

//	form field
	By Store_Image = By.id("storeImage");
	By Store_Logo = By.id("logoImage");
	By Banner_Image = By.id("logoImageBanner");
	By Remove_Store_Image = By.xpath("//*[contains(@style,'display: block;') and @id='upImage']//a//i");
	By Remove_Store_Logo = By.xpath("//*[contains(@style,'display: block;') and @id='upImagelogo']//a//i");
	By Remove_Banner_Image = By.xpath("//*[contains(@style,'display: block;') and @id='upImagelogoBanner']//a//i");
	By Primary_Color = By.id("primary_color");
	By Secondary_Color = By.id("secondary_color");
	By White_Background_Color = By.id("white_background_text_color");
	By Header_Footer_Color = By.id("header_footer_text_color");
	By Selected_Box_Color = By.id("selected_box_color");
	By Banner_Heading_Color = By.id("banner_box_color");
	@FindAll({ @FindBy(id = "edit_store_name"), @FindBy(id = "store_name") })
	WebElement Store_Name;
	By WebSite_URL = By.name("url");
	By Address = By.name("address");
	By Zipcode = By.id("zipcode");
	By City = By.xpath("//*[@id='storeForm']/div[4]/div[2]/div[1]/div/button");
	By City_DD_Visible = By.xpath("//*[@id='city_id']//following::*[contains(@class,'open')]");
	By Select_City = By.xpath("//*[@id='storeForm']/div[4]/div[2]/div[1]/div/ul/li[4]/a/label/input");
	By Email = By.name("email");
	By Phone_Number = By.name("phone_number");
	By Review_Link = By.name("review_link");
	By Banner_Heading = By.name("banner_heading");
	By Banner_Text = By.name("banner_text");
	By Banner_Button = By.name("banner_button");
	By Order_PickUp_Text = By.name("order_pickup_text");
	@FindAll({ @FindBy(xpath = "//*[text()='Save']"), @FindBy(xpath = "//*[text()='Update']") })
	public static WebElement Save_Button;

//	field error path
	By Error_Store_Image = By.xpath("//*[contains(@class,'logo_form_error')]");
	By Error_Store_Logo_Image = By.xpath("//*[contains(@class,'logo_image_form_error')]");
	By Error_Banner_Image = By.xpath("//*[contains(@class,'banner_image_form_error')]");
	By Error_Primary_Color = By.xpath("//*[contains(@class,'primary_color_form_error')]");
	By Error_Secondary_Color = By.xpath("//*[contains(@class,'secondary_color_form_error')]");
	By Error_White_Backgroung_Color = By.xpath("//*[contains(@class,'white_background_text_color_form_error')]");
	By Error_Header_Footer_Text_Color = By.xpath("//*[contains(@class,'header_footer_text_color_form_error')]");
	By Error_Selected_Box_Color = By.xpath("//*[contains(@class,'selected_box_color_form_error')]");
	By Error_Banner_Heading_Color = By.xpath("//*[contains(@class,'banner_box_color_form_error')]");
	By Error_Store_Name = By.xpath("//*[contains(@class,'name_form_error')]");
	By Error_Website_URL = By.xpath("//*[contains(@class,'url_form_error')]");
	By Error_Zipcode = By.xpath("//*[contains(@class,'zipcode_form_error')]");
	By Error_City = By.xpath("//*[contains(@class,'city_form_error')]");
	By Error_State = By.xpath("//*[contains(@class,'state_form_error')]");
	By Error_Email = By.xpath("//*[contains(@class,'email_form_error')]");
	By Error_Phone_Number = By.xpath("//*[contains(@class,'phone_number_form_error')]");
	By Error_Review_Link = By.xpath("//*[contains(@class,'review_link_form_error')]");
	By Error_Banner_Heading = By.xpath("//*[contains(@class,'banner_heading_form_error')]");
	By Error_Banner_Text = By.xpath("//*[contains(@class,'banner_text_form_error')]");
	By Error_Banner_Button_Text = By.xpath("//*[contains(@class,'banner_button_form_error')]");
	By Error_Order_PickUp_Text = By.xpath("//*[contains(@class,'order_pickup_text_form_error')]");

//	Successfully Message Path
	By CreateMessage = By.xpath("//*[@id='popup-store-save']/div/div/div/div/div/h2");
	By CreateClose = By.xpath("//*[@id='popup-store-save']/div/div/div/div/div/a/button");
	By UpdateMessage = By.xpath("//*[@id='popup-store-update']/div/div/div/div/div/h2");
	By UpdateClose = By.xpath("//*[@id='popup-store-update']/div/div/div/div/div/a");
	By DeleteMessage = By.xpath("//*[@id='popup-store-remove']/div/div/div/div/div/h2");
	By DeleteClose = By.xpath("//*[@id='popup-store-remove']/div/div/div/div/div/a/button");
	By DeleteConfirmPopup = By.xpath("//*[@id='popup-store-delete']/div/div/div[2]/div/a/button");

//	List path
	By Three_Dots = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[8]//i");
	By Edit = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[8]//div//ul//li[2]//a");
	By Delete = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[8]//div//ul//li[3]//a");
	By List_Store_Name = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[2]");
	By List_Zipcode = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[4]");
	By List_Website_URL = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[3]");
	By Search_Box = By.id("storeSearch");
	By View = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[1]/div/div/div[3]/a/button");
	By Reset = By.xpath("//*[@id='base-content-page']/div[1]/div[1]/div[1]/div/div/div[4]/a/button");
	By Side_Loader = By.xpath("//*[contains(@class,'file-loader') and contains(@style,'display: none;')]");

	public String modulePage(String value) {
		if (value.equals("Module")) {
			this.clickButton(Store, 10, "JS Click");
		} else if (value.equals("CreateStorePage")) {
			this.clickButton(Create_Store, 10, "JS Click");
		} else if (value.equals("EditStorePage")) {
			this.clickButton(Three_Dots, 10, "JS Click");
			this.clickButton(Edit, 10, "JS Click");
			this.valuePresentCondition(Store_Name, 10, storeName);
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
		if (value.equals("Store Image")) {
			this.clickButton(Save_Button, 5, "JS Click");
			return checkError(Error_Store_Image);
		} else if (value.equals("Store Logo")) {
			return checkError(Error_Store_Logo_Image);
		} else if (value.equals("Banner Image")) {
			return checkError(Error_Banner_Image);
		} else if (value.equals("Primary Color")) {
			return checkError(Error_Primary_Color);
		} else if (value.equals("Secondary Color")) {
			return checkError(Error_Secondary_Color);
		} else if (value.equals("White Background Text Color")) {
			return checkError(Error_White_Backgroung_Color);
		} else if (value.equals("Header/Footer Text Color")) {
			return checkError(Error_Header_Footer_Text_Color);
		} else if (value.equals("Selected Box Color")) {
			return checkError(Error_Selected_Box_Color);
		} else if (value.equals("Banner Heading Color")) {
			return checkError(Error_Banner_Heading_Color);
		} else if (value.equals("Store Name")) {
			return checkError(Error_Store_Name);
		} else if (value.equals("Website URL")) {
			return checkError(Error_Website_URL);
		} else if (value.equals("Zipcode")) {
			return checkError(Error_Zipcode);
		} else if (value.equals("City")) {
			return checkError(Error_City);
		} else if (value.equals("State")) {
			return checkError(Error_State);
		} else if (value.equals("Email")) {
			return checkError(Error_Email);
		} else if (value.equals("Phone Number")) {
			return checkError(Error_Phone_Number);
		} else if (value.equals("Review Link")) {
			return checkError(Error_Review_Link);
		} else if (value.equals("Banner Heading")) {
			return checkError(Error_Banner_Heading);
		} else if (value.equals("Banner Text")) {
			return checkError(Error_Banner_Text);
		} else if (value.equals("Banner Button Text")) {
			return checkError(Error_Banner_Button_Text);
		} else if (value.equals("Order Pickup Text")) {
			return checkError(Error_Order_PickUp_Text);
		}
		return value;
	}

	public String clearField(String value) {
		if (value.equals("Store Name")) {
			this.clearField(Store_Name, 10);
		} else if (value.equals("Website URL")) {
			this.clearField(WebSite_URL, 10);
		} else if (value.equals("Email")) {
			this.clearField(Email, 10);
		} else if (value.equals("Phone Number")) {
			this.clearField(Phone_Number, 10);
		} else if (value.equals("Review Link")) {
			this.clearField(Review_Link, 10);
		} else if (value.equals("Banner Heading")) {
			this.clearField(Banner_Heading, 10);
		} else if (value.equals("Banner Text")) {
			this.clearField(Banner_Text, 10);
		} else if (value.equals("Banner Button Text")) {
			this.clearField(Banner_Button, 10);
		} else if (value.equals("Search")) {
			this.clearField(Search_Box, 10);
		} else if (value.equals("Zipcode")) {
			this.clearField(Zipcode, 10);
		} else if (value.equals("Address")) {
			this.clearField(Address, 10);
		} else if (value.equals("Order Pickup Text")) {
			this.clearField(Order_PickUp_Text, 10);
		}
		return value;
	}

	public void emailField(String value) {
		if (value.equals("Invalid")) {
			this.inputText(Email, "fjdslkfjsfl", 10);
			this.clickButton(Save_Button, 5, "JS Click");
		}
	}

	public String wesiteURLField(String value) {
		if (value.equals("Invalid")) {
			this.inputText(WebSite_URL, dummyData("Website URL"), 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisibleConditionChecking(By.xpath("//*[text()='The website URL field is required.']"), 10);
			this.inputText(WebSite_URL, "fjdslkfjsfl", 10);
			this.clickButton(Save_Button, 5, "JS Click");
		} else if (value.equals("Unique Validation")) {
			this.modulePage("CreateStorePage");
			this.inputText(WebSite_URL, websiteURL, 10);
			this.inputText(Review_Link, reviewLink, 10);
			this.clickButton(Save_Button, 10, "JS Click");
			String errorEmail = this.errorField("Website URL");
			return errorEmail;
		}
		return value;
	}

	public String reviewLinkField(String value) {
		if (value.equals("Invalid")) {
			this.inputText(Review_Link, dummyData("Website URL"), 10);
			this.clickButton(Save_Button, 10, "JS Click");
			this.invisibleConditionChecking(By.xpath("//*[text()='The review link field is required.']"), 10);
			this.inputText(Review_Link, "fjdslkfjsfl", 10);
			this.clickButton(Save_Button, 5, "JS Click");
		} else if (value.equals("Unique Validation")) {
			String errorEmail = this.errorField("Review Link");
			this.clickButton(Form_Label, 5, "JS Click");
			return errorEmail;
		}
		return value;
	}

	public static String primaryColor;
	public static String secondaryColor;
	public static String whiteBackgroundColor;
	public static String headerFooterColor;
	public static String selectBoxColor;
	public static String bannerHeadingColor;
	public static String storeName;
	public static String websiteURL;
	public static String address;
	public static String zipcode;
	public static String email;
	public static String phoneNumber;
	public static String reviewLink;
	public static String bannerHeading;
	public static String bannerText;
	public static String bannerButton;
	public static String orderPickupText;

	public void validRecords(String value) throws AWTException, InterruptedException, IOException {
		if (value.equals("Create") || value.equals("Edit")) {
			if (value.equals("Create")) {
				this.mouseActionClicks(Store_Image, 10);
				Thread.sleep(2000);
				BaseClass.attachmentFile(System.getProperty("user.dir") + "\\Image_File\\download (2).jpg");
				if (!this.conditionChecking(Remove_Store_Image, 5)) {
					do {
						this.mouseActionClicks(Store_Image, 10);
						Thread.sleep(2000);
						BaseClass.attachmentFile(System.getProperty("user.dir") + "\\Image_File\\download (2).jpg");
					} while (!this.conditionChecking(Remove_Store_Image, 5));
				}
				this.mouseActionClicks(Store_Logo, 10);
				Thread.sleep(2000);
				BaseClass.attachmentFile(System.getProperty("user.dir") + "\\Image_File\\UT-SLC-Springville FD.jpg");
				if (!this.conditionChecking(Remove_Store_Logo, 5)) {
					do {
						this.mouseActionClicks(Store_Logo, 10);
						Thread.sleep(2000);
						BaseClass.attachmentFile(
								System.getProperty("user.dir") + "\\Image_File\\UT-SLC-Springville FD.jpg");
					} while (!this.conditionChecking(Remove_Store_Logo, 5));
				}
				this.mouseActionClicks(Banner_Image, 10);
				Thread.sleep(2000);
				BaseClass.attachmentFile(
						System.getProperty("user.dir") + "\\Image_File\\2023_07_19_06_26_52_490114.webp");
				if (!this.conditionChecking(Remove_Banner_Image, 5)) {
					do {
						this.mouseActionClicks(Banner_Image, 10);
						Thread.sleep(2000);
						BaseClass.attachmentFile(
								System.getProperty("user.dir") + "\\Image_File\\2023_07_19_06_26_52_490114.webp");
					} while (!this.conditionChecking(Remove_Banner_Image, 5));
				}
				((JavascriptExecutor) driver).executeScript(
						"document.getElementById('primary_color').value='" + randomCharacters("Color Code") + "';");
				((JavascriptExecutor) driver).executeScript(
						"document.getElementById('secondary_color').value='" + randomCharacters("Color Code") + "';");
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('white_background_text_color').value='"
								+ randomCharacters("Color Code") + "';");
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('header_footer_text_color').value='"
								+ randomCharacters("Color Code") + "';");
				((JavascriptExecutor) driver).executeScript("document.getElementById('selected_box_color').value='"
						+ randomCharacters("Color Code") + "';");
				((JavascriptExecutor) driver).executeScript(
						"document.getElementById('banner_box_color').value='" + randomCharacters("Color Code") + "';");
			}
			this.inputText(Store_Name, randomCharacters("Dummy Store"), 10);
			storeName = this.getTextAttribute(Store_Name, 10);
			this.inputText(WebSite_URL, "https://" + dummyData("Website URL"), 10);
			websiteURL = this.getTextAttribute(WebSite_URL, 10);
			this.inputText(Address, randomCharacters("Dummy Address"), 10);
			address = this.getTextAttribute(Address, 10);
			this.inputText(Zipcode, "84113", 10);
			zipcode = this.getTextAttribute(Zipcode, 10);
			this.inputText(Email, dummyData("Email"), 10);
			email = this.getTextAttribute(Email, 10);
			this.inputText(Phone_Number, randomCharacters("Max 10 Characters"), 10);
			phoneNumber = this.getTextAttribute(Phone_Number, 10);
			map.put("StoreName", storeName);
			map.put("Address", address);
			map.put("WebSiteURL", websiteURL);
			map.put("PhoneNumber", phoneNumber);
			this.propertyInputValue("Store Property", map);
			this.inputText(Review_Link, "https://" + dummyData("Website URL"), 10);
			reviewLink = this.getTextAttribute(Review_Link, 10);
			this.inputText(Banner_Heading, dummyData("Heading"), 10);
			bannerHeading = this.getTextAttribute(Banner_Heading, 10);
			this.inputText(Banner_Text, randomCharacters("Dummy Description"), 10);
			bannerText = this.getTextAttribute(Banner_Text, 10);
			this.inputText(Banner_Button, dummyData("category Name"), 10);
			bannerButton = this.getTextAttribute(Banner_Button, 10);
			this.inputText(Order_PickUp_Text, dummyData("City"), 10);
			orderPickupText = this.getTextAttribute(Order_PickUp_Text, 10);
			this.clickButton(City, 10, "JS Click");
			if (!this.conditionChecking(City_DD_Visible, 2)) {
				do {
					this.clickButton(City, 10, "JS Click");
				} while (!this.conditionChecking(City_DD_Visible, 2));
			}
			this.clickButton(Select_City, 10, "JS Click");
			this.clickButton(Save_Button, 10, "JS Click");
		}
	}

	public String submissionValidation(String value) throws IOException {
		Boolean conditionCheck = true;
		if (value.equals("Create") || value.equals("Edit")) {
			if (this.conditionChecking(CreateMessage, 15) || this.conditionChecking(UpdateMessage, 15)) {
			} else {
				do {
					if (this.conditionChecking(Error_Store_Name, 3) || this.conditionChecking(Error_Website_URL, 3)
							|| this.conditionChecking(Error_Review_Link, 3)) {
						if (this.getText(Error_Store_Name, 5).equals(getPropertyValue("StoreNameAlreadyTaken"))) {
							this.clearField("Store Name");
							this.inputText(Store, randomCharacters("Dummy Store"), 10);
							storeName = this.getTextAttribute(Store, 10);
						} else if (this.getText(Error_Website_URL, 5).equals(getPropertyValue("AlreadyWebisteURL"))) {
							this.clearField("Website URL");
							this.inputText(WebSite_URL, dummyData("Website URL"), 10);
							websiteURL = this.getTextAttribute(WebSite_URL, 10);
						} else if (this.getText(Error_Review_Link, 5).equals(getPropertyValue("AlreadyReviewLink"))) {
							this.clearField("Review Link");
							this.inputText(Review_Link, dummyData("Website URL"), 10);
							reviewLink = this.getTextAttribute(Review_Link, 10);
						}
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
		} else if (value.equals("Delete")) {
			this.clickButton(Three_Dots, 10, "JS Click");
			this.clickButton(Delete, 10, "JS Click");
			this.clickButton(DeleteConfirmPopup, 10, "JS Click");
			String text = this.getText(DeleteMessage, 10);
			this.clickButton(DeleteClose, 10, "JS Click");
			return text;
		}
		return value;
	}

	static String listRecord;

	public String listValidation(String value) {
		if (value.equals("Search Box")) {
			this.inputText(Search_Box, listRecord, 10);
			this.clickButton(View, 10, "JS Click");
		} else if (value.equals("List Store Name")) {
			listRecord = this.getText(List_Store_Name, 10);
		} else if (value.equals("List Zipcode")) {
			listRecord = this.getText(List_Zipcode, 10);
		} else if (value.equals("Invalid")) {
			listRecord = "jdsfhfsdhfdks";
		} else if (value.equals("Reset")) {
			this.clickButton(Reset, 10, "JS Click");
		} else if (value.equals("ListInvalid")) {
			listRecord = this.getText(By.xpath("//*[text()='No Records']"), 10);
		}
		return listRecord;
	}

	public String editPrepopulate(String value) {
		if (value.equals("Store Name")) {
			return this.getTextAttribute(Store_Name, 10);
		} else if (value.equals("Website URL")) {
			return this.getTextAttribute(WebSite_URL, 10);
		} else if (value.equals("Email")) {
			return this.getTextAttribute(Email, 10);
		} else if (value.equals("Phone Number")) {
			return this.getTextAttribute(Phone_Number, 10);
		} else if (value.equals("Review Link")) {
			return this.getTextAttribute(Review_Link, 10);
		} else if (value.equals("Banner Heading")) {
			return this.getTextAttribute(Banner_Heading, 10);
		} else if (value.equals("Banner Text")) {
			return this.getTextAttribute(Banner_Text, 10);
		} else if (value.equals("Banner Button Text")) {
			return this.getTextAttribute(Banner_Button, 10);
		}
		return value;
	}

	public void clearAllFields() {
		List<String> asList = Arrays.asList("Store Name", "Website URL", "Email", "Zipcode", "Address", "Phone Number",
				"Review Link", "Banner Heading", "Banner Text", "Banner Button Text", "Order Pickup Text");
		for (int i = 0; i < asList.size(); i++) {
			this.clearField(asList.get(i));
		}
	}

	public void createNewStore() throws AWTException, InterruptedException, IOException {
		this.clickButton(Create_Store, 10, "JS Click");
		this.validRecords("Create");
		this.submissionValidation("Create");
	}

}
