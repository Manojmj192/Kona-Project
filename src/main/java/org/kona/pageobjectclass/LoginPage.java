package org.kona.pageobjectclass;

import java.io.IOException;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {
	static String value;

	@SuppressWarnings("static-access")
	public LoginPage(WebDriver driver) throws IOException {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
		String APP_URL = null;
		if (APP_URL == null) {
			APP_URL = getPropertyValue("URL");
		}
		driver.get(APP_URL);
	}

	By Email = By.xpath("//*[@name='email']");
	By Password = By.xpath("//*[@name='password']");
	By Login = By.id("ajaxSubmit");
	By Dashboard = By.xpath("//*[@id='base-content-page']//div//div//div[1]//div//div//h1");
	By InvalidEmail_Password = By.xpath("//*[@id='myForm']//div[2]//p[2]");

	public void setUserCredentials(String username, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
		this.clearField(Email, 10);
		this.clearField(Password, 10);
		if (username != null) {
			this.inputText(Email, username, 10);
		}
		if (password != null) {
			this.inputText(Password, password, 10);
		}
		this.clickButton(Login, 10, "JS Click");
	}

	public String errorMessage() {
		if (!this.conditionChecking(InvalidEmail_Password, 3)) {
			do {
				this.clickButton(Login, 3, "JS Click");
			} while (!this.conditionChecking(InvalidEmail_Password, 10));
		}
		return this.getText(InvalidEmail_Password, 10);
	}

	public String validateDashBoard() throws IOException {
		Boolean conditionCheck = true;
		if (!this.conditionChecking(Dashboard, 10)) {
			do {
				if (this.conditionChecking(Email, 3)) {
					this.setUserCredentials(getPropertyValue("UserName"), getPropertyValue("Password"));
					this.clickButton(Login, 3, "JS Click");
					if (!this.conditionChecking(Dashboard, 10)) {
						value = this.getText(Dashboard, 10);
						conditionCheck = false;
					}
				} else {
					if (!this.conditionChecking(Dashboard, 1)) {
						value = "Page Loading more than 20 sec";
						conditionCheck = false;
					}
				}
			} while (conditionCheck);
		} else {
			value = this.getText(Dashboard, 10);
		}
		return value;
	}
}
