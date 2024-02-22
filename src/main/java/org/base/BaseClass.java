package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class BaseClass {
	public WebDriverWait wait;
	public static WebDriver driver;
	WebElement element = null;
	List<WebElement> listElement = null;
	static String dummy;
	public static String invalid;

	public String inputText(Object elementOrLocator, String value, int num) {
		wait = new WebDriverWait(driver, num);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		element.sendKeys(value);
		return value;
	}

	public void jsInputText(Object elementOrLocator, String value) {
		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('" + elementOrLocator + "').value='" + value + "';");
	}

	public void mouseActionClicks(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public void mouseAction(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public Result listWebElement(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			listElement = wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			listElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) elementOrLocator));
		}
		return new Result(listElement.size(), listElement);
	}

	public static class Result {
		private int size;
		private List<WebElement> elements;

		public Result(int size, List<WebElement> elements) {
			this.size = size;
			this.elements = elements;
		}

		public int getSize() {
			return size;
		}

		public List<WebElement> getElements() {
			return elements;
		}
	}

	public void clickButton(Object elementOrLocator, int value, String event) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		if (event.equals("Click")) {
			element.click();
		} else if (event.equals("JS Click")) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void clearField(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		element.clear();
	}

	public String getText(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		return element.getText();
	}

	public String getTextAttribute(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		return element.getAttribute("value");
	}

	public void invisible(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			wait.until(ExpectedConditions.invisibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated((By) elementOrLocator));
		}
	}

	public Boolean conditionChecking(Object elementOrLocator, int value) {
		Boolean text = false;
		wait = new WebDriverWait(driver, value);
		try {
			if (elementOrLocator instanceof WebElement) {
				element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
			} else if (elementOrLocator instanceof By) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
			}
			text = element.isEnabled();
		} catch (Exception e) {
			return text;
		}
		return text;
	}

	public Boolean invisibleConditionChecking(Object elementOrLocator, int value) {
		Boolean text = false;
		wait = new WebDriverWait(driver, value);
		try {
			if (elementOrLocator instanceof WebElement) {
				text = wait.until(ExpectedConditions.invisibilityOf((WebElement) elementOrLocator));
			} else if (elementOrLocator instanceof By) {
				text = wait.until(ExpectedConditions.invisibilityOfElementLocated((By) elementOrLocator));
			}
		} catch (Exception e) {
			return text;
		}
		return text;
	}

	public Boolean valuePresentCondition(Object elementOrLocator, int value, String data) {
		Boolean text = false;
		wait = new WebDriverWait(driver, value);
		try {
			if (elementOrLocator instanceof WebElement) {
				text = wait
						.until(ExpectedConditions.textToBePresentInElementValue(((WebElement) elementOrLocator), data));
			} else if (elementOrLocator instanceof By) {
				text = wait.until(ExpectedConditions.textToBePresentInElementValue(((By) elementOrLocator), data));
			}
		} catch (Exception e) {
			return text;
		}
		return text;
	}

	public void dropDownByIndex(Object elementOrLocator, int value, int num) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		Select select = new Select(element);
		select.selectByIndex(num);
	}

	public String dummyData(String value) {
		Faker faker = new Faker();
		switch (value) {
		case "First Name":
			dummy = faker.name().firstName();
			break;
		case "Last Name":
			dummy = faker.name().lastName();
			break;
		case "Email":
			dummy = faker.internet().safeEmailAddress();
			break;
		case "Phone Number":
			dummy = faker.phoneNumber().phoneNumber();
			break;
		case "Address1":
			dummy = faker.address().buildingNumber();
			break;
		case "Address2":
			dummy = faker.address().streetName();
			break;
		case "City":
			dummy = faker.address().city();
			break;
		case "State":
			dummy = faker.address().state();
			break;
		case "Zipcode":
			dummy = faker.address().zipCode();
			break;
		case "Job Tittle":
			dummy = faker.name().title();
			break;
		case "category Name":
			dummy = faker.book().publisher().replaceAll("[^a-zA-Z0-9 ]", "");
			dummy = dummy + " " + RandomStringUtils.randomAlphabetic(6);
			break;
		case "Website URL":
			dummy = faker.internet().url();
			dummy = dummy.replace("-", "");
			break;
		case "Heading":
			dummy = faker.book().title();
			break;
		case "Business Name":
			dummy = faker.company().name();
			break;
		default:
			break;
		}
		return dummy;
	}

	public static String getPropertyValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream stream = new FileInputStream(
				System.getProperty("user.dir") + "\\Reusable Records\\config.properties");
		properties.load(stream);
		String value = (String) properties.get(key);
		return value;
	}

	public String randomCharacters(String value) {
		switch (value) {
		case "Max 256 Characters":
			dummy = RandomStringUtils.randomAlphabetic(257);
			break;
		case "Max 512 Characters":
			dummy = RandomStringUtils.randomAlphabetic(512);
			break;
		case "Max 2048 Characters":
			dummy = RandomStringUtils.randomAlphabetic(2048);
			break;
		case "Max 10 Characters":
			dummy = RandomStringUtils.randomNumeric(10);
			break;
		case "Max 69 Characters":
			dummy = RandomStringUtils.randomAlphabetic(69);
			break;
		case "Max 16 Characters":
			dummy = RandomStringUtils.randomNumeric(16);
			break;
		case "Max 4 Characters":
			dummy = RandomStringUtils.randomNumeric(4);
			break;
		case "Max 2 Characters":
			dummy = RandomStringUtils.randomNumeric(2);
			break;
		case "Dummy Description":
			int numberOfWords = 10;
			dummy = generateDummyDescription(numberOfWords);
			break;
		case "Dummy Roles":
			dummy = generateRandomRole();
			invalid = RandomStringUtils.randomAlphabetic(7).toUpperCase();
			dummy = dummy + " " + invalid;
			break;
		case "Color Code":
			dummy = colorCode();
			break;
		case "Dummy Store":
			dummy = storeName();
			String upperStore = RandomStringUtils.randomAlphabetic(7).toUpperCase();
			dummy = dummy + " " + upperStore;
			break;
		case "Dummy Address":
			dummy = address();
			break;
		case "Dummy IP Address":
			dummy = generateRandomIPv4Address();
			break;
		case "Dummy Printer Name":
			dummy = generateRandomPrinterName();
			String upperCase = RandomStringUtils.randomAlphabetic(5).toUpperCase();
			dummy = dummy + " " + upperCase;
			break;
		case "Dummy Hub Name":
			dummy = generateRandomHubName();
			String upper_Case = RandomStringUtils.randomAlphabetic(5).toUpperCase();
			dummy = dummy + " " + upper_Case;
			break;
		case "1 Hour Timing":
			dummy = timeFormat("1 Hour Timing");
			break;
		case "3 Hour Timing":
			dummy = timeFormat("4 Hour Timing");
			break;
		case "Invalid Timing":
			dummy = timeFormat("Invalid Time");
			break;
		case "Past Timing":
			dummy = timeFormat("Past Timing");
			break;
		case "Dummy Delivery Schedule Name":
			dummy = deliveryScheduleName();
			break;
		default:
			break;
		}
		return dummy;

	}

	public static void attachmentFile(String location) throws AWTException {
		StringSelection selection = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void ScreenShots(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileHandler.copy(screenshotAs, file);
	}

	public WebElement visible(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, value);
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		return element;
	}

	public static String generateDummyDescription(int numberOfWords) {
		String[] loremIpsum = { "Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit", "sed",
				"do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et", "dolore", "magna", "aliqua", "Ut",
				"enim", "ad", "minim", "veniam", "quis", "nostrud", "exercitation", "ullamco", "laboris", "nisi", "ut",
				"aliquip", "ex", "ea", "commodo", "consequat", "Duis", "aute", "irure", "dolor", "in", "reprehenderit",
				"in", "voluptate", "velit", "esse", "cillum", "dolore", "eu", "fugiat", "nulla", "pariatur" };
		StringBuilder description = new StringBuilder();
		for (int i = 0; i < numberOfWords; i++) {
			int randomIndex = (int) (Math.random() * loremIpsum.length);
			description.append(loremIpsum[randomIndex]).append(" ");
		}
		return description.toString();
	}

	public static String generateRandomRole() {
		String[] roles = { "Administrator", "Manager", "User", "Guest", "Developer", "Supervisor", "Analyst", "Tester",
				"Support", "Operator" };
		int randomIndex = (int) (Math.random() * roles.length);
		return roles[randomIndex];
	}

	public String colorCode() {
		Random random = new Random();
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		return String.format("#%02X%02X%02X", red, green, blue);
	}

	public String storeName() {
		String[] adjectives = { "Vintage", "Groovy", "Eclectic", "Harmonious", "Charming" };
		String[] nouns = { "Vinyl", "Records", "Tunes", "Melodies", "Beats" };
		Random random = new Random();
		String randomAdjective = adjectives[random.nextInt(adjectives.length)];
		String randomNoun = nouns[random.nextInt(nouns.length)];
		return randomAdjective + " " + randomNoun;

	}

	public String address() {
		String[] streetNames = { dummyData("Address1"), dummyData("Address2") };
		String[] cities = { dummyData("City") };
		String[] states = { dummyData("State"), };
		String[] postalCodes = { dummyData("Zipcode") };
		Random random = new Random();
		String randomStreet = streetNames[random.nextInt(streetNames.length)];
		int randomStreetNumber = random.nextInt(1000) + 1; // Generate a number between 1 and 1000
		String randomCity = cities[random.nextInt(cities.length)];
		String randomState = states[random.nextInt(states.length)];
		String randomPostalCode = postalCodes[random.nextInt(postalCodes.length)];

		return randomStreetNumber + " " + randomStreet + ", " + randomCity + ", " + randomState + " "
				+ randomPostalCode;

	}

	static FileOutputStream fo;

// Please use this format to store the string value
//	propertyInputValue("function",setName1,name1,setName2,name2)
	@SuppressWarnings("unchecked")
	public void propertyInputValue(String function, Object... input) throws IOException {
		Properties properties = new Properties();
		if (input.length == 1 && input[0] instanceof Map) {
			Map<String, String> mapInput = (Map<String, String>) input[0];
			for (Map.Entry<String, String> entry : mapInput.entrySet()) {
				properties.put(entry.getKey(), entry.getValue());
			}
		} else if (input.length % 2 == 0) {
			for (int i = 0; i < input.length; i += 2) {
				if (input[i] instanceof String && input[i + 1] instanceof String) {
					properties.put((String) input[i], (String) input[i + 1]);
				}
			}
		}
		if (function.equals("Store Property")) {
			fo = new FileOutputStream(System.getProperty("user.dir") + "\\Reusable Records\\Store.properties");
		} else if (function.equals("Hub Property")) {
			fo = new FileOutputStream(System.getProperty("user.dir") + "\\Reusable Records\\Hub.properties");
		} else if (function.equals("Catlogue Property")) {
			fo = new FileOutputStream(System.getProperty("user.dir") + "\\Reusable Records\\Catlogue.properties");
		} else if (function.equals("Dummy Property")) {
			fo = new FileOutputStream(System.getProperty("user.dir") + "\\Reusable Records\\Dummy.properties");
		} else if (function.equals("Phone Call Delivery Property")) {
			fo = new FileOutputStream(
					System.getProperty("user.dir") + "\\Reusable Records\\Phone Call Delivery.properties");
		} else if (function.equals("Customer Lookup")) {
			fo = new FileOutputStream(
					System.getProperty("user.dir") + "\\Reusable Records\\Customer Lookup.properties");
		} else if (function.equals("House Property")) {
			fo = new FileOutputStream(System.getProperty("user.dir") + "\\Reusable Records\\House_Account.properties");
		}
		properties.store(fo, "Update Value");
	}

	static FileInputStream stream;

	public String getUpdatedPropertyFile(String value, String key) throws IOException {
		Properties properties = new Properties();
		if (value.equals("Store Page")) {
			stream = new FileInputStream(System.getProperty("user.dir") + "\\Reusable Records\\Store.properties");
		} else if (value.equals("Hub Page")) {
			stream = new FileInputStream(System.getProperty("user.dir") + "\\Reusable Records\\Hub.properties");
		} else if (value.equals("Catlogue Page")) {
			stream = new FileInputStream(System.getProperty("user.dir") + "\\Reusable Records\\Catlogue.properties");
		} else if (value.equals("Dummy Page")) {
			stream = new FileInputStream(System.getProperty("user.dir") + "\\Reusable Records\\Dummy.properties");
		} else if (value.equals("House_Page")) {
			stream = new FileInputStream(
					System.getProperty("user.dir") + "\\Reusable Records\\House_Account.properties");
		} else if (value.equals("Order_Management")) {
			stream = new FileInputStream(
					System.getProperty("user.dir") + "\\Reusable Records\\Order_Management.properties");
		} else if (value.equals("Customer LookUp")) {
			stream = new FileInputStream(
					System.getProperty("user.dir") + "\\Reusable Records\\Customer Lookup.properties");
		}
		properties.load(stream);
		dummy = (String) properties.get(key);
		return dummy;
	}

	public String generateRandomIPv4Address() {
		Random rand = new Random();
		StringBuilder ipAddress = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			ipAddress.append(rand.nextInt(256)); // Generate a random number between 0 and 255
			if (i < 3) {
				ipAddress.append(".");
			}
		}
		return ipAddress.toString();
	}

	public static String generateRandomPrinterName() {
		String[] adjectives = { "Red", "Blue", "Green", "Yellow", "Fast", "Silent", "Smart" };
		String[] nouns = { "Printer", "Inkjet", "LaserJet", "Pro", "OfficeJet", "Pixma", "Epson" };

		Random rand = new Random();
		String adjective = adjectives[rand.nextInt(adjectives.length)];
		String noun = nouns[rand.nextInt(nouns.length)];

		return adjective + " " + noun;
	}

	public static String generateRandomHubName() {
		String[] adjectives = { "Tech", "Innovative", "Digital", "Smart", "Creative", "Connected" };
		String[] nouns = { "Hub", "Center", "Workspace", "Lab", "Zone", "Hubbub" };

		Random rand = new Random();
		String adjective = adjectives[rand.nextInt(adjectives.length)];
		String noun = nouns[rand.nextInt(nouns.length)];

		return adjective + " " + noun;
	}

	public String timeFormat(String value) {
		SimpleDateFormat sdfStopTime = new SimpleDateFormat("hh:mma", Locale.ENGLISH);
		Calendar c = Calendar.getInstance();
		if (value.equals("1 Hour Timing")) {
			c.add(Calendar.HOUR, 1);
		} else if (value.equals("4 Hour Timing")) {
			c.add(Calendar.HOUR, 4);
		} else if (value.equals("Invalid Time")) {
			c.add(Calendar.HOUR, 2);
		} else if (value.equals("Past Timing")) {
			c.add(Calendar.HOUR, 0);
		}
		Date d = c.getTime();
		return sdfStopTime.format(d);
	}

	public String deliveryScheduleName() {
		String[] scheduleNames = { "Morning Delivery", "Afternoon Delivery", "Evening Delivery", "Express Delivery",
				"Weekend Delivery", "Standard Delivery", "Next-Day Delivery" };
		// Create a Random object
		Random random = new Random();
		// Generate a random index to select a name from the array
		int randomIndex = random.nextInt(scheduleNames.length);
		// Get the random delivery schedule name
		String randomScheduleName = scheduleNames[randomIndex];
		String value = randomScheduleName + " " + RandomStringUtils.randomAlphabetic(7).toUpperCase();
		return value;
	}

	public String dateFormat(int num) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, num);
		return sdf.format(cal.getTime());
	}

	@SuppressWarnings("resource")
	public String excelRead(int sheetName, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\Reusable Records\\Automation Records.xlsx");
		XSSFSheet xsf = new XSSFWorkbook(fis).getSheetAt(sheetName);
		return xsf.getRow(row).getCell(cell).getStringCellValue();
	}

}
