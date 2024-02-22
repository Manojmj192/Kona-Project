package org.kona.pageobjectclass;

import java.awt.AWTException;
import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Products_module extends BaseClass {
	@SuppressWarnings("static-access")
	public Products_module(WebDriver driver) {
		this.driver = driver;
	}

//Navigation
	By products_menu = By.xpath("//span[text()='Products']");
	@FindAll({ @FindBy(xpath = "//h4[text()='Products']"), @FindBy(xpath = "//a[text()='Create Category']"),
			@FindBy(xpath = "//h4[text()=' Products / Category']"),
			@FindBy(xpath = "//a[text()=' Create Sub-Category']"),
			@FindBy(xpath = "//h4[text()=' Products / Catalogue']"), @FindBy(xpath = "//a[text()='Create Catalogue']"),
			@FindBy(xpath = "//a[text()='Create Product']"),
			@FindBy(xpath = "//a[text()='Create Check Out Occasion']") })
	WebElement formLable;
	By list_product_btn = By.xpath("//label[text()='Products']");
	By list_Category_btn = By.xpath("//label//a[text()='Category']");
	By list_catelogue_btn = By.xpath("//label//a[text()='Catalogue']");
	By list_checkoutoccasion_btn = By.xpath("//label//a[text()='Check Out Occasion']");
	By create_btn = By.xpath("//button[@id='dropdownMenuButton2']");
	By dd_products_btn = By.xpath("//li//a[text()='Products']");
	By dd_category_btn = By.xpath("//ul//a[text()='Category']");
	By dd_sub_category_btn = By.xpath("//li//a[text()='Sub-Category']");
	By dd_catalogue_btn = By.xpath("//li//a[text()='Catalogue']");
	By dd_checkoutoccasion_btn = By.xpath("//li//a[text()='Check Out Occasion']");
//Category form
	By category_name = By.id("category_name");
	By category_alt_text = By.id("alt_text");
	By category_description = By.id("category_description");
	By category_products_btn = By.xpath("//*[@id=\"product_id_7\"]");
	By category_save_btn = By.xpath("//button[text()='Save']");
//Category Error fields
	By category_name_error_msg = By.xpath("//strong[text()='The category name field is required.']");
	By category_description_error_msg = By.xpath("//strong[text()='The category description field is required.']");
	By category_invalid_name_format = By.xpath("//strong[text()='The category name format is invalid.']");
	By category_Created_successfully_popup = By
			.xpath("//div[@id='category-save']//h2[text()='Category Created Successfully']");
	By category_name_already_exist_msg = By.xpath("//strong[text()='The category name has already been taken.']");
	By popup_close_btn = By.xpath("//div[@id='category-save']//button[text()='Close']");
// list validation
	By List_Category_Name = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[2]");
	By CategoryNameFilter = By.xpath("//*[text()=' " + categoryName + "']");
	By CategoryNameFilter_dd = By.xpath("//span[text()='Category']");
	By Filter_View_btn = By.xpath("//button[text()='View']");
	By Filter_status = By.xpath("//span[text()='Status']");
	By Filter_status_active = By.xpath("//label[text()=' Active']");
// Action (Edit)
	By action_btn = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[5]//i");
	By edit_btn = By.xpath("//*[@id='pagination-data-container']//tbody//tr[1]//td[5]//ul//li//a[text()='Edit']");
	By edit_category_label = By.xpath("//a[text()=' Edit Category']");
	By update_btn = By.xpath("//button[text()='Update']");
	By Update_success = By.xpath("//h2[text()='Category Updated Successfully']");
	By update_popup_close = By.xpath("//div[@id='popup-category-update']//button[text()='Close']");
// Action (Delete)
	By delete_btn = By.xpath("//div[@id='pagination-data-container']//tbody//tr[1]//td[5]//ul//li[2]//a");
	By delete_category_popuplabel = By.xpath("//div//h4[text()='Delete Category']");
	By delete_category_popuplabel_confirm_btn = By
			.xpath("//div[@id='popup-category-delete-confirm']//button[text()='Yes, Confirm']");
// Sub category
	By subcategory_btn_dd = By.xpath("//a[text()='Sub-Category']");
	By subcategory_list_name = By.xpath("//*[@id=\"sub_category_table\"]/table/tbody/tr[2]/td[2]");
// Sub category form fields
	By create_sc_label = By.xpath("//a[text()=' Create Sub-Category']");
	By select_main_category = By.xpath("//select[@id = 'categoryDropdown']");
	By sub_category_name = By.xpath("//input[@id = 'category_name']");
	By sc_description = By.xpath("//textarea[@id = 'category_description']");
	By product_btn = By.xpath("//span[@id='product_id_7']");
	By sc_save_btn = By.xpath("//button[text()='Save']");
	By sc_created_successfully = By.xpath("//h2[text()='Sub-Category Created Successfully']");
	By sc_created_successfully_Popupclose = By.xpath("//div[@id='sub-category-save']//button[text()='Close']");
// sub category edit
	By table_sc_click = By.xpath("//*[@id=\"pagination-data-container\"]/tbody/tr[1]/td[3]");
	By edit_sc_popup_icon = By.xpath("//*[@id=\"sub_category_table\"]/table/tbody/tr[2]/td[3]/a[1]/i");
	By edit_sub_category_lable = By.xpath("//a[text()='Edit Sub-Category ']");
	By sc_popup_edit = By
			.xpath("//div[@id='sub_category_table']//table//tbody//tr[2]//td[3]//a//i[@class='fas fa-edit']");
	By edit_sc_label = By.xpath("//*[@id=\"base-content-page\"]/nav/div/div/div/h4/a");
	By edit_sc_update_btn = By.xpath("//*[@id=\"base-content-page\"]/div/div/div/div/div[1]/div/div/span[1]/a/button");
	By sc_updated_success_popup_lable = By.xpath("//h2[text()='Sub-Category Updated Successfully']");
	By sc_updated_popup_close = By.xpath("//*[@id=\"popup-sub-category-update\"]/div/div/div/div/div/a/button");
// sub category error fields
	By select_main_category_error = By.xpath(" //strong[text()='The main category field is required.']");
	By select_sc_name_error = By.xpath(" //strong[text()='The sub category field is required.']");
	By sc_description_error = By.xpath(" //strong[text()='The sub category description is required.']");
	By sc_name_invalid_error = By.xpath(" //strong[text()='The category name format is invalid.']");

	By Side_Loader = By.xpath("//*[contains(@class,'file-loader') and contains(@style,'display: none;')]");
// sub category delete fields
	By delete_action = By.xpath("//*[@id=\"sub_category_table\"]/table/tbody/tr[2]/td[3]/a[2]/i");
	By delete_sub_category__popup_label = By.xpath("//h4[text()='Delete Sub-Category']");
	By delete_sub_category_popup_yesbtn = By
			.xpath("//div[@id='popup-sub-category-delete-confirm']//button[text()='Yes, Confirm']");
	By delete_sc_success_label = By.xpath("//h2[text()='Sub-Category Deleted Successfully']");
	By delete_sc_close_popup = By.xpath("//div[@id='popup-sub-category-delete']//button[text()='Close']");

// Catalogue
	By catalogue_btn_dd = By.xpath("//*[@id=\"base-content-page\"]/div/nav/div/div/div[2]/div/ul/li[4]/a");
	By create_catalogue_label = By.xpath("//a[text()='Create Catalogue']");
	By catalouge_name_input = By.xpath("//*[@id=\"catalogue_input\"]");
	By select_catalogue_dd = By.xpath("//*[@id=\"CatalogueForm\"]/div[2]/div[1]/div");
	By view_product_btn = By.xpath("//button[@id='getCategoryProduct']");
	By view_product_list = By.xpath("//h2[@id='headingfour1']");
	By view_product_list_btn = By.xpath("//*[@id=\"collapse0\"]/div/div/div/div/div/div[2]/div/div[2]/label/span");
	By save_btn = By.xpath("//button[text()='Save']");
	By catelogue_created_succ_label = By.xpath("//h2[text()='Catalogue Created Successfully']");
	By catalogue_created_succ_label_close_pp = By.xpath("//div[@id='popup-catalogue-save']//button[text()='Close']");

// catalouge edit
	By table_catalogue_list = By.xpath("//*[@id=\"base-content-page\"]/div/div/div[1]/div[2]/div/label[3]/a");
	By catalogue_list_action = By.xpath("//*[@id=\"dropdownMenuButton3\"]/i");
	By catalogue_action_edit = By.xpath("//*[@id=\"pagination-data-container\"]/thead[2]/tr[1]/td[5]/div/ul/li[1]/a");
	By edit_catalogue_label = By.xpath("//a[text()='Edit Catalogue']");
	By edit_catalogue_update_btn = By.xpath("//*[@id=\"base-content-page\"]/div/div/div/div[2]/div/div/span[1]/button");
	By edit_cat_succ_label = By.xpath("//h2[text()='Catalogue Updated Successfully']");
	By edit_popup_close = By.xpath("//div[@id='popup-catalogue-update']//button[text()='Close']");

// delete catalogue
	By delete_catalogue = By.xpath("//*[@id=\"pagination-data-container\"]/thead[2]/tr[1]/td[5]/div/ul/li[2]/a");
	By delete_catalogue_label = By.xpath("//h4[text()='Delete Catalogue']");
	By delete_cat_confirm = By.xpath("//button[text()='Yes, Confirm']");
	By delete_cat_succ_label = By.xpath("//h2[text()='Catalogue Deleted Successfully']");
	By delete_cat_succ_close = By.xpath("//div[@id='popup-catalogue-delete']//button[text()='Close']");

// cataglogue error validaiton
	By catalogue_character_validation = By
			.xpath("//strong[text()='The catalogue name must be at least 3 characters.']");
	By catalogue_name_required_msg = By.xpath("//strong[text()='The catalogue name field is required.']");
	By select_category_required_msg = By.xpath("//strong[text()='The category field is required.']");
	By product_required_msg = By.xpath("//strong[text()='The product field is required.']");

// catalogue filter
	By catalouge_search = By.xpath("//input[@id='search']");
	By status_filter = By.xpath("//span[text()='Status']");
	By status_active = By
			.xpath("//*[@id=\"base-content-page\"]/div/div/div[1]/div/div/div[1]/div[2]/div/ul/li[1]/a/label/input");
	By filter_view_btn = By.xpath("//button[text()='View']");
	public static By catalogue_first_row = By.xpath("//*[@id=\"pagination-data-container\"]/thead[2]/tr/td[2]");
	By catalogue_first_row_status = By.xpath("//*[@id=\"pagination-data-container\"]/thead[2]/tr/td[4]");
// Product module
	By create_product_label = By.xpath("//a[text()='Create Product']");
	By upload_prod_img = By.xpath("//input[@id='files']");
	By product_name_input = By.xpath("//input[@id='product_name']");
	By description_input = By.xpath("//textarea[@id='exampleFormControlTextarea1']");
	By product_type_single = By.xpath("//input[@id='featured-1']");
	By product_price = By.xpath("//*[@id=\"sale_price\"]");
	By select_category = By.xpath("//span[text()='Select Category']");
	By select_sub_category = By.xpath("//span[text()='Select Sub Category']");
	By product_ID = By.xpath("//*[@id=\"skuCreate\"]/div[3]/div[1]/div[8]/div[1]/input");
	By receipe_input = By.xpath("//*[@id=\"hide-recipie\"]/div[1]/div/div[3]/div[2]");
	By product_save_btn = By.xpath("//*[@id=\"skuCreate\"]/div[3]/div[3]/div/span[1]/button");
	By invalid_format_err_msg = By.xpath("//strong[text()='The product name format is invalid.']");
	By product_created_succ_label = By.xpath("//h2[text()='Product Created Successfully']");
	By product_created_popup_close = By.xpath("//div[@id=\"popup-sku-save\"]/div/div/div/div/div/p/a/button");
// Product action
	By product_list_action_btn = By.xpath("//*[@id=\"dropdownMenuButton3\"]/i");
// product view	
	By product_view_action = By.xpath("//*[@id=\"pagination-data-container\"]/tbody/tr[1]/td[6]/div/ul/li[1]/a");
	By product_view_popup_label = By.xpath("//strong[text()='Products View']");
	By product_view_popup_close = By.xpath("//*[@id=\"productView\"]/a");
//product edit
	By product_edit_action = By.xpath("//*[@id=\"pagination-data-container\"]/tbody/tr[1]/td[6]/div/ul/li[2]/a");
	By edit_product_label = By.xpath("//a[text()='Edit Product']");
	By edit_product_update_btn = By.xpath("//button[text()='Update']");
	By product_updated_label = By.xpath("//h2[text()='Product Updated Successfully']");
	By product_update_popup_close = By.xpath("//*[@id=\"popup-sku-update\"]/div/div/div/div/div/p/a/button");
//product delete
	By product_delete_action = By.xpath("//*[@id=\"pagination-data-container\"]/tbody/tr[1]/td[6]/div/ul/li[3]/a");
	By delete_product_label = By.xpath("//h4[text()='Delete Product']");
	By delete_popup_yes_confirm = By.xpath("//button[text()='Yes, Confirm']");
	By product_delete_confirm_label = By.xpath("//h2[text()='Product Deleted Successfully']");
	By delete_popup_close = By.xpath("//*[@id=\"popup-sku-delete\"]/div/div/div/div/div/a/button");

//	Product errors
	By upload_product_image_required_msg = By.xpath("//strong[text()='The product image field is required.']");
	By product_name_required_msg = By.xpath("//strong[text()='The product name field is required.']");
	By description_required_msg = By.xpath("//strong[text()='The description field is required.']");
	By product_type_required_msg = By.xpath("//strong[text()='The product type field is required.']");
	By product_id_required_msg = By.xpath("//strong[text()='The product id field is required.']");
	By receipe_required_msg = By.xpath("//strong[text()='The receipe field is required.']");

// Product filter
	By search_product_name = By.xpath("//input[@id='search']");
	By product_filter_view_btn = By.xpath("//button[text()='View']");

	By product_name_1st_row = By.xpath("//*[@id=\"pagination-data-container\"]/tbody/tr[1]/td[2]");

// Checkout occasion create
	By dd_checkout_occasion = By.xpath("//*[@id=\"base-content-page\"]/div[1]/nav/div/div/div[2]/div/ul/li[5]/a");
	By create_checkout_occasion_label = By.xpath("//a[text()='Create Check Out Occasion']");
	By occasion_name_required_msg = By.xpath("//strong[text()='The occasion name field is required']");
	By occasion_name_input = By.xpath("//input[@id='occasion']");
	By occasion_description_input = By.xpath("//textarea[@id='description']");
	By create_occasion_save = By.xpath("//button[text()='Save']");
	By create_occasion_succ = By.xpath("//*[@id=\"popup-occasion-save\"]/div/div/div/div/div/h2");
	By create_succ_popup_close = By.xpath("//*[@id=\"popup-occasion-save\"]/div/div/div/div/div/h2");
// checkout occasion action
	By checkout_occ_action = By.xpath("//*[@id=\"dropdownMenuButton3\"]/i");
// checkout occasion edit
	By occation_edit_action = By.xpath("//*[@id=\"occasion-details\"]/tbody/tr[1]/td[4]/div/ul/li[1]/a");
	By edit_occasion_label = By.xpath("//a[text()='Edit Check Out Occasion']");
	By occation_update_btn = By.xpath("//button[text()='Update']");
	By occation_edit_succ = By.xpath("//*[@id=\"popup-occasion-update\"]/div/div/div/div/div/h2");
	By edit_succ_popup_close = By.xpath("//*[@id=\"popup-occasion-update\"]/div/div/div/div/div/a/button");
// checkout occasion delete
	By occation_delete_action = By.xpath("//*[@id=\"occasion-details\"]/tbody/tr[1]/td[4]/div/ul/li[2]/a");
	By delete_occasion_popup_label = By.xpath("//h4[text()='Delete Check Out Occasion']");
	By delete_occasion_yes_confirm = By.xpath("//button[text()='Yes, Confirm']");
	By delete_occasion_succ_label = By.xpath("//*[@id=\"popup-ocassion-delete\"]/div/div/div/div/div/h2");
	By delete_occasion_succ_close = By.xpath("//*[@id=\"popup-ocassion-delete\"]/div/div/div/div/div/a/button");
// checkout occasion filter
	By occasion_filter = By
			.xpath("//*[@id=\"base-content-page\"]/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/button");
	By occasion_search = By.xpath(
			"//*[@id=\"base-content-page\"]/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/ul/li[1]/div/input");
	By occasion_select_checkbox = By.xpath(
			"//*[@id=\"base-content-page\"]/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/ul/li[2]/a/label/input");
	// checkout occasion status
	By occasion_status = By
			.xpath("//*[@id=\"base-content-page\"]/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/button");
	By occasion_active_status = By
			.xpath("//*[@id=\"base-content-page\"]/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/button");
	By fitler_view_btn = By
			.xpath("//*[@id=\"base-content-page\"]/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/button");
	By occasion_name_first_row = By.xpath("//*[@id=\"occasion-details\"]/tbody/tr[1]/td[2]");
	By occasion_name_first_row_action = By.xpath("//*[@id=\"occasion-details\"]/tbody/tr[1]/td[3]");

	public String modulePage(String value) {
		if (value == "list_Category" || value == "list_Catalogue" || value == "list_Checkoutoccasion"
				|| value == "List_Product") {
			this.clickButton(products_menu, 10, "JS Click");
			if (value == "list_Category") {
				this.clickButton(list_Category_btn, 10, "JS Click");
			} else if (value == "list_Catalogue") {
				this.clickButton(list_catelogue_btn, 10, "JS Click");
			} else if (value == "list_Checkoutoccation") {
				this.clickButton(list_checkoutoccasion_btn, 10, "JS Click");
			}
		} else if (value == "create_Product" || value == "create_Category" || value == "create_Catalouge"
				|| value == "create_Checkoutoccasion" || value == "create_sub_category") {
			this.clickButton(create_btn, 10, "JS Click");
			if (value == "create_Product") {
				this.clickButton(dd_products_btn, 10, "JS Click");
			} else if (value == "create_Category") {
				this.clickButton(dd_category_btn, 10, "JS Click");
			} else if (value == "create_Catalouge") {
				this.clickButton(dd_catalogue_btn, 10, "JS Click");
			} else if (value == "create_Checkoutoccasion") {
				this.clickButton(dd_checkoutoccasion_btn, 10, "JS Click");
			} else if (value == "create_sub_category") {
				this.clickButton(dd_sub_category_btn, 10, "JS Click");
			}
		}
		String text = this.getText(formLable, 10);
		return text;
	}

	public String category_error_fields(String value) {
		if (value == "category_mandatory_validatoin") {
			if (this.conditionChecking(category_name_error_msg, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(category_name_error_msg, 2));
			}
			return this.getText(category_name_error_msg, 10);
		} else if (value == "category_invalid") {
			if (this.conditionChecking(category_invalid_name_format, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(category_invalid_name_format, 2));
			}
			String text = this.getText(category_invalid_name_format, 10);
			return text;
		} else if (value == "description_mandatory_validation") {
			if (this.conditionChecking(category_description_error_msg, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(category_description_error_msg, 2));
			}
			String text = this.getText(category_description_error_msg, 10);
			return text;
		}
		return value;
	}

	@FindAll({ @FindBy(xpath = "//strong[text()='The product name has already been taken.']"),
			@FindBy(xpath = "//strong[text()='The category name has already been taken.']"),
			@FindBy(xpath = "//strong[text()='The sub category name has already been taken.']"),
			@FindBy(xpath = "//strong[text()='The catalogue name has already been taken.']"),
			@FindBy(xpath = "//strong[text()='The occasion name has already been taken.']") })
	WebElement uniqe_validation_message;

	public String unique_validation(String value) {
		if (value.equals("Unique Product Name")) {
			String text = this.getText(product_name_1st_row, 10);
			this.modulePage("create_Product");
			this.inputText(product_name_input, text, 10);

		} else if (value.equals("Unique Category Name")) {
			String text = this.getText(List_Category_Name, 10);
			this.modulePage("create_Category");
			this.inputText(category_name, text, 10);

		} else if (value.equals("Uniqe Sub Category Name")) {
			String text = this.getText(subcategory_list_name, 10);
			this.modulePage("create_sub_category");
			this.inputText(sub_category_name, text, 10);

		} else if (value.equals("Uniqe Catalogue Name")) {
			String text = this.getText(catalogue_first_row, 10);
			this.modulePage("create_Catalouge");
			this.inputText(catalouge_name_input, text, 10);

		} else if (value.equals("Uniqe Occasion Name")) {
			String text = this.getText(occasion_name_first_row, 10);
			this.modulePage("create_Checkoutoccasion");
			this.inputText(occasion_name_input, text, 10);

		}
		this.clickButton(save_btn, 10, "JS Click");
		if (!this.conditionChecking(uniqe_validation_message, 2)) {
			do {
				this.clickButton(save_btn, 10, "JS Click");
			} while (!this.conditionChecking(uniqe_validation_message, 2));
		}
		String text = this.getText(uniqe_validation_message, 10);
		this.clickButton(formLable, 10, "JS Click");
		return text;

	}

	public void category_field_clear() {
		this.clearField(category_name, 10);
	}

	public void invalid_category() {
		this.inputText(category_name, "@#@#", 10);
		this.clickButton(category_save_btn, 10, "JS Click");
	}

	public void buttonClick() {
		this.clickButton(category_save_btn, 10, "JS Click");
	}

	public static String categoryName;

	public String valid_Record() {
		this.inputText(category_name, dummyData("category Name"), 10);
		categoryName = this.getTextAttribute(category_name, 10);
		this.inputText(category_description, randomCharacters("Dummy Description"), 10);
		this.clickButton(product_btn, 10, "JS Click");
		this.buttonClick();
		String text = this.getText(category_Created_successfully_popup, 10);
		this.clickButton(popup_close_btn, 10, "JS Click");
		return text;
	}

	public String Category_Edit() {
		this.clickButton(action_btn, 10, "JS Click");
		this.clickButton(edit_btn, 10, "JS Click");
		this.clickButton(product_btn, 10, "JS Click");
		if (!this.conditionChecking(By.xpath("//span[@id='product_id_7' and contains(@onclick,'Save')]"), 5)) {
			do {
				this.clickButton(product_btn, 10, "JS Click");
			} while (!this.conditionChecking(By.xpath("//span[@id='product_id_7' and contains(@onclick,'Save')]"), 5));
		}
		if (!this.conditionChecking(edit_category_label, 10)) {
			do {
				this.clickButton(edit_btn, 10, "JS Click");
			} while (!this.conditionChecking(edit_category_label, 10));
		}
		String text = this.getText(edit_category_label, 10);
		return text;
	}

	public String update_category() {
		this.inputText(category_name, dummyData("category Name") + BaseClass.invalid, 10);
		categoryName = this.getTextAttribute(category_name, 10);
		this.clickButton(update_btn, 10, "JS Click");
		if (!this.conditionChecking(Update_success, 10)) {
			do {
				this.clickButton(update_btn, 10, "JS Click");
			} while (!this.conditionChecking(Update_success, 10));
		}
		String text = this.getText(Update_success, 10);
		this.clickButton(update_popup_close, 10, "JS Click");
		return text;
	}

	public String list_by_category() {
		String text = this.getText(List_Category_Name, 10);
		return text;
	}

	public String list_by_status() {
		String text = this.getText(List_Category_Name, 10);
		return text;
	}

	public void filter_by_category_name() {
		this.clickButton(CategoryNameFilter_dd, 10, "JS Click");
		this.clickButton(CategoryNameFilter, 10, "JS Click");
		this.clickButton(Filter_View_btn, 10, "JS Click");
	}

	public void filter_by_status() {
		this.clickButton(Filter_status, 10, "JS Click");
		this.clickButton(Filter_status_active, 10, "JS Click");
		this.clickButton(Filter_View_btn, 10, "JS Click");
	}

	public String category_delete() {
		this.clickButton(action_btn, 10, "JS Click");
		this.clickButton(delete_btn, 10, "JS Click");
		String text = this.getText(delete_category_popuplabel, 10);
		this.clickButton(delete_category_popuplabel_confirm_btn, 10, "JS Click");
		return text;
	}

//sub category

	public void sub_category_field_clear() {
		this.clearField(sub_category_name, 10);
	}

	public void invalid_sub_category() {
		this.inputText(sub_category_name, "@#@#", 10);
		this.clickButton(sc_save_btn, 10, "JS Click");
	}

	public String sc_error_fields(String value) {
		if (value == "sc_mandatory_validation") {
			if (this.conditionChecking(select_main_category_error, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(select_main_category_error, 2));
			}
			return this.getText(select_main_category_error, 10);
		} else if (value == "sc_category_invalid") {
			if (this.conditionChecking(sc_name_invalid_error, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(sc_name_invalid_error, 2));
			}
			String text = this.getText(sc_name_invalid_error, 10);
			return text;
		} else if (value == "description_mandatory_validation") {
			if (this.conditionChecking(sc_description_error, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(sc_description_error, 2));
			}
			String text = this.getText(sc_description_error, 10);
			return text;
		}
		return value;
	}

	public static String subcategoryName;

	public String sub_category_input_text() {
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		int size = driverWait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='categoryDropdown']//option")))
				.size();
		int value = size - 1;
		this.dropDownByIndex(select_main_category, 10, value);
		this.inputText(sub_category_name, dummyData("category Name") + BaseClass.invalid, 10);
		subcategoryName = this.getTextAttribute(category_name, 10);
		this.inputText(category_description, randomCharacters("Dummy Description"), 10);
		this.clickButton(sc_save_btn, 10, "JS Click");
		String text = this.getText(sc_created_successfully, 10);
		this.clickButton(sc_created_successfully_Popupclose, 10, "JS Click");
		return text;
	}

	public void close_sc_created_succ_popup() {
		this.clickButton(CategoryNameFilter, 0, categoryName);
	}

	public String sub_category_edit() {
		this.clickButton(table_sc_click, 10, "JS Click");
		this.clickButton(sc_popup_edit, 10, "JS Click");
		String text = this.getText(edit_sc_label, 10);
		return text;
	}

	public String update_sub_category_form() throws InterruptedException {
		this.clearField(sub_category_name, 10);
		this.inputText(sub_category_name, dummyData("category Name") + BaseClass.invalid, 10);
		this.clickButton(edit_sc_update_btn, 10, "JS Click");
		if (!this.conditionChecking(sc_updated_success_popup_lable, 20)) {
			do {
				this.clickButton(edit_sc_update_btn, 10, "JS Click");
			} while (!this.conditionChecking(sc_updated_success_popup_lable, 20));
		}
		String text = this.getText(sc_updated_success_popup_lable, 10);
		Thread.sleep(2000);
		this.clickButton(sc_updated_popup_close, 10, "Click");

		if (!this.invisibleConditionChecking(Side_Loader, 5)) {
			do {
				this.clickButton(edit_sc_update_btn, 10, "Click");
			} while (!this.invisibleConditionChecking(Side_Loader, 5));
		}
		return text;
	}

	public String delete_sc_popup() {
		this.clickButton(table_sc_click, 10, "JS Click");
		this.clickButton(delete_action, 10, "JS Click");
		String text = this.getText(delete_sub_category__popup_label, 10);
		return text;
	}

	public String delete_sc_confirmation() {
		this.clickButton(delete_sub_category_popup_yesbtn, 10, "JS Click");
		String text = this.getText(delete_sc_success_label, 10);
		this.clickButton(delete_sc_close_popup, 10, "JS Click");

		return text;
	}

//Catalogue
	public void catalogue_name_field_clear() {
		this.clearField(catalouge_name_input, 10);
	}

	public void invalid_catalouge_name() {
		this.inputText(sub_category_name, "@#@#", 10);
		this.clickButton(sc_save_btn, 10, "JS Click");

	}

	public String catalogue_error_fields(String value) {
		if (value == "catalogue_mandatory_validation") {
			if (this.conditionChecking(catalogue_name_required_msg, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(catalogue_name_required_msg, 2));
			}
			String text = this.getText(catalogue_name_required_msg, 10);
			return text;
		} else if (value == "catagory_mandatory_validation") {
			if (this.conditionChecking(select_category_required_msg, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(select_category_required_msg, 2));
			}
			String text = this.getText(select_category_required_msg, 10);
			return text;
		} else if (value == "product_mandatory_validation") {
			if (!this.conditionChecking(product_required_msg, 2)) {
				do {
					this.buttonClick();
				} while (this.conditionChecking(product_required_msg, 2));
			}
			String text = this.getText(product_required_msg, 10);
			return text;
		}
		return value;
	}

	public String min_char_validation() {
		this.inputText(catalouge_name_input, "1a", 10);
		this.clickButton(save_btn, 10, "JS Click");
		String text = this.getText(catalogue_character_validation, 10);
		return text;
	}

	public static String catalogueName;

	public String create_catalogue() throws IOException {
		this.clearField(catalouge_name_input, 10);
		this.inputText(catalouge_name_input, dummyData("category Name"), 10);
		catalogueName = this.getTextAttribute(catalouge_name_input, 10);
		this.propertyInputValue("Catlogue Property", "CatlogueName", catalogueName);
		this.mouseActionClicks(select_catalogue_dd, 10);
		if (!this.conditionChecking(By.xpath("//*[@id='categoryDropdownCat']//following::div[contains(@class,'open')]"),
				2)) {
			do {
				this.mouseActionClicks(select_catalogue_dd, 10);
			} while (!this.conditionChecking(
					By.xpath("//*[@id='categoryDropdownCat']//following::div[contains(@class,'open')]"), 2));
		}
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		int size = driverWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"CatalogueForm\"]/div[2]/div[1]/div/div/ul/li/a")))
				.size();
		int value = size;
		this.clickButton(By.xpath("(//*[@type='checkbox'])[" + value + "]"), 10, "JS Click");
		this.clickButton(view_product_btn, 10, "JS Click");
		this.mouseActionClicks(view_product_list, 10);
		if (!this.conditionChecking(By.xpath("//*[@id='collapse0' and contains(@class,'show')]"), 2)) {
			do {
				this.mouseActionClicks(view_product_list, 10);
			} while (!this.conditionChecking(By.xpath("//*[@id='collapse0' and contains(@class,'show')]"), 2));
		}
		this.clickButton(view_product_list_btn, 10, "JS Click");
		this.buttonClick();
		String text = this.getText(catelogue_created_succ_label, 10);
		this.clickButton(catalogue_created_succ_label_close_pp, 10, "JS Click");
		return text;
	}

//update catalogue
	public String catalogue_edit_page() throws InterruptedException {
		this.clickButton(catalogue_list_action, 10, "JS Click");
		this.clickButton(catalogue_action_edit, 10, "JS Click");
		Thread.sleep(2000);
		String text = this.getText(edit_catalogue_label, 10);
		return text;
	}

	public String update_catalogue() {
		this.clearField(catalouge_name_input, 10);
		this.inputText(catalouge_name_input, dummyData("category Name"), 10);
		this.clickButton(edit_catalogue_update_btn, 10, "JS Click");
		if (!this.conditionChecking(edit_cat_succ_label, 10)) {
			do {
				this.clickButton(edit_catalogue_update_btn, 10, "JS Click");
			} while (!this.conditionChecking(edit_cat_succ_label, 10));
		}
		String text = this.getText(edit_cat_succ_label, 10);
		this.clickButton(edit_popup_close, 10, "JS Click");
		return text;
	}

// delete catalogue
	public String delete_catalgoue() {
		this.clickButton(catalogue_list_action, 10, "JS Click");
		this.clickButton(delete_catalogue, 10, "JS Click");
		String text = this.getText(delete_catalogue_label, 10);
		this.clickButton(delete_cat_confirm, 10, "JS Click");
		return text;
	}

	public String delete_catalouge_confirm() {
		String text = this.getText(delete_cat_succ_label, 10);
		this.clickButton(delete_cat_succ_close, 10, "JS Click");
		return text;
	}

// catalouge filter
	public String filter_by_catalogue_name() {
		this.clickButton(list_catelogue_btn, 10, "JS Click");
		this.clickButton(catalouge_search, 10, "JS Click");
		this.inputText(catalouge_search, catalogueName, 10);
		this.clickButton(filter_view_btn, 10, "JS Click");
		String text = this.getText(catalogue_first_row, 10);
		return text;
	}

	public String filter_by_cat_status() {
		this.clickButton(status_filter, 10, "JS Click");
		this.clickButton(Filter_status_active, 10, "JS Click");
		this.clickButton(Filter_View_btn, 10, "JS Click");
		String text = this.getText(catalogue_first_row_status, 10);
		return text;
	}

// Product
	public String create_product_label_validation() {
		String text = this.getText(create_product_label, 10);
		return text;
	}

	public void product_name_field_clear() {
		this.clearField(product_name_input, 10);
	}

	public String product_error_fields(String value) {
		if (value == "upload_product_mandatory_validation") {
			if (this.conditionChecking(upload_product_image_required_msg, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(upload_product_image_required_msg, 2));
			}
			String text = this.getText(upload_product_image_required_msg, 10);
			return text;
		} else if (value == "product_name_mandatory_validation") {
			if (this.conditionChecking(product_name_required_msg, 2)) {
			} else {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(product_name_required_msg, 2));
			}
			String text = this.getText(product_name_required_msg, 10);
			return text;
		} else if (value == "description_mandatory_validation") {
			if (!this.conditionChecking(description_required_msg, 2)) {
				do {
					this.buttonClick();
				} while (this.conditionChecking(description_required_msg, 2));
			}
			String text = this.getText(description_required_msg, 10);
			return text;
		} else if (value == "product_type_mandatory_validation") {
			if (!this.conditionChecking(product_type_required_msg, 2)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(product_type_required_msg, 2));
			}
			String text = this.getText(product_type_required_msg, 10);
			return text;
		} else if (value == "product_id_mandatory_validation") {
			if (!this.conditionChecking(product_id_required_msg, 2)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(product_id_required_msg, 2));
			}
			String text = this.getText(product_id_required_msg, 10);
			return text;
		} else if (value == "receipe_mandatory_validation") {
			if (!this.conditionChecking(receipe_required_msg, 2)) {
				do {
					this.buttonClick();
				} while (!this.conditionChecking(receipe_required_msg, 2));
			}
			String text = this.getText(receipe_required_msg, 10);
			return text;
		}

		return value;
	}

	public String invalid_product_name() {
		this.inputText(product_name_input, "@#@#", 10);
		this.clickButton(product_save_btn, 10, "JS Click");
		if (!this.conditionChecking(invalid_format_err_msg, 4)) {
			do {
				this.clickButton(product_save_btn, 10, "JS Click");
			} while (!this.conditionChecking(invalid_format_err_msg, 4));
		}
		String text = this.getText(invalid_format_err_msg, 10);
		return text;
	}

	public static String productname;

	public String create_product() throws AWTException, InterruptedException {
		this.product_name_field_clear();
		this.clickButton(upload_prod_img, 10, "JS Click");
		Thread.sleep(3000);
		this.attachmentFile(System.getProperty("user.dir") + "\\Image_File\\DSC_7356.jpg");
		this.inputText(product_name_input, dummyData("category Name"), 10);
		productname = this.getTextAttribute(product_name_input, 10);
		this.inputText(description_input, dummyData("category Name"), 10);
		this.clickButton(product_type_single, 10, "JS Click");
		this.inputText(product_price, "2222", 10);
		this.inputText(product_ID, randomCharacters("Max 10 Characters"), 10);
		this.inputText(receipe_input, dummyData("category Name"), 10);
		this.clickButton(product_save_btn, 10, "JS Click");
		String text = this.getText(product_created_succ_label, 50);
		this.mouseActionClicks(product_created_popup_close, 10);
		return text;
	}

	public String product_action_view() {
		this.clickButton(product_list_action_btn, 10, "JS Click");
		this.clickButton(product_view_action, 10, "JS Click");
		String text = this.getText(product_view_popup_label, 10);
		this.clickButton(product_view_popup_close, 10, "JS Click");
		return text;
	}

	public String product_action_edit() {
		this.clickButton(product_list_action_btn, 10, "JS Click");
		this.clickButton(product_edit_action, 10, "JS Click");
		String text = this.getText(edit_product_label, 10);
		return text;
	}

	public String update_product() {
		this.clearField(product_name_input, 20);
		this.inputText(product_name_input, dummyData("category Name"), 10);
		this.clickButton(edit_product_update_btn, 10, "JS Click");
		if (!this.conditionChecking(product_updated_label, 10)) {
			do {
				this.clickButton(edit_product_update_btn, 10, "JS Click");
			} while (!this.conditionChecking(product_updated_label, 10));
		}
		String text = this.getText(product_updated_label, 10);
		this.clickButton(product_update_popup_close, 10, "JS Click");
		return text;
	}

	public String delete_product() {
		this.clickButton(product_list_action_btn, 10, "JS Click");
		this.clickButton(product_delete_action, 10, "JS Click");
		String text = this.getText(delete_product_label, 10);
		this.clickButton(delete_popup_yes_confirm, 10, "JS Click");
		return text;
	}

	public String delete_confirmation() {
		String text = this.getText(product_delete_confirm_label, 10);
		this.mouseAction(delete_popup_close, 10);
		return text;
	}

// product filter
	public String search_by_product_name() {
		this.inputText(search_product_name, productname, 10);
		this.clickButton(product_filter_view_btn, 10, "JS Click");
		String text = this.getText(product_name_1st_row, 10);
		return text;
	}

	public String filter_by_product_status() {
		this.clickButton(status_filter, 10, "JS Click");
		this.clickButton(Filter_status_active, 10, "JS Click");
		this.clickButton(product_filter_view_btn, 10, "JS Click");
		String text = this.getText(product_name_1st_row, 10);
		return text;
	}

// checkout occasion

	public String checkout_occasion_creation_error_validation() {
		this.clickButton(create_occasion_save, 10, "JS Click");
		String text = this.getText(occasion_name_required_msg, 10);
		return text;
	}

	public static String occasionname;

	public String create_occasion() {
		this.inputText(occasion_name_input, dummyData("category Name"), 10);
		occasionname = this.getTextAttribute(occasion_name_input, 10);
		this.inputText(occasion_description_input, dummyData("category Name"), 10);
		this.clickButton(create_occasion_save, 10, "JS Click");
		String text = this.getText(create_occasion_succ, 10);
		return text;
	}

	public String edit_occation_page() {
		this.clickButton(checkout_occ_action, 10, "JS Click");
		this.clickButton(occation_edit_action, 10, "JS Click");
		String text = this.getText(edit_occasion_label, 10);
		return text;
	}

	public String update_occasion() {
		this.clearField(occasion_name_input, 10);
		this.inputText(occasion_name_input, dummyData("category Name"), 10);
		this.clickButton(occation_update_btn, 10, "JS Click");
		String text = this.getText(occation_edit_succ, 10);
		return text;
	}

	public String delete_occation() {
		this.clickButton(checkout_occ_action, 10, "JS Click");
		this.clickButton(occation_delete_action, 10, "JS Click");
		String text = this.getText(delete_occasion_popup_label, 10);
		return text;
	}

	public String delete_occasion_success() {
		this.clickButton(delete_occasion_yes_confirm, 10, "JS Click");
		String text = this.getText(delete_occasion_succ_label, 10);
		this.clickButton(delete_occasion_succ_close, 10, "JS Click");
		return text;
	}

	public void search_occasion() {
		this.clickButton(occasion_filter, 10, "JS Click");
		this.inputText(occasion_search, occasionname, 10);
		this.clickButton(occasion_select_checkbox, 10, "JS Click");
		this.clickButton(fitler_view_btn, 10, "JS Click");
	}

	public String search_by_occasion_name() {
		this.clickButton(occasion_filter, 10, "JS Click");
		this.inputText(occasion_search, occasionname, 10);
		this.clickButton(occasion_select_checkbox, 10, "JS Click");
		this.clickButton(fitler_view_btn, 10, "JS Click");
		String occ_name_text = this.getText(occasion_name_first_row, 10);
		return occ_name_text;
	}

	public String filter_by_occasion_status() {
		this.clickButton(occasion_status, 10, "JS Click");
		this.clickButton(occasion_active_status, 10, "JS Click");
		this.clickButton(fitler_view_btn, 10, "JS Click");
		String occ_name_text = this.getText(occasion_name_first_row_action, 10);
		return occ_name_text;
	}
}
