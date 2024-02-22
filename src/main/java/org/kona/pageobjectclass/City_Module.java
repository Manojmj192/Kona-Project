package org.kona.pageobjectclass;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class City_Module extends BaseClass {
	public City_Module(WebDriver driver) {
		this.driver=driver;
	}
By city_management = By.id("city_side_bar");
}
