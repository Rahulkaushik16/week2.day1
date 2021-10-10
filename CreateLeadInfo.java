package week2.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadInfo {

	public static void main(String[] args) throws InterruptedException {
		// Setup Chrome Driver
		WebDriverManager.chromedriver().setup();

		// Disable info-bars
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.addArguments("Start-Maximized"); // Maximize the browser on open

		// InitiatingChromeBrowser
		WebDriver driver = new ChromeDriver(options);

		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");

		String loginWidgetText = driver.findElement(By.tagName("h2")).getText();
		System.out.println("Login Widget Title is : " + loginWidgetText);

		// Enter UserName and Password
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();

		// Click on create Lead Button
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter all the text fields in CreateLead page
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TVS SI");
		WebElement ele = driver.findElement(By.id("createLeadForm_firstName"));
		ele.sendKeys("Kaushik");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sudhir");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("K");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("S");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Hello!!");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("2/11/90");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Mr");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("BTS-DEX");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("125000");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("10-100");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("00701");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("b2b");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test Desc");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Test Ref Note");

		Thread.sleep(1000);

		// Enter all the text fields in contact information
		WebElement eleNum = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		eleNum.clear();
		Thread.sleep(1000);
		eleNum.sendKeys("+91");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("0");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9876543210");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("2448");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Test Name");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("tester@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.testleaf.com");

		// Enter all the text fields in primary address
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Rahul");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("SRK");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("No# 1001");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("7th Lane");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");

		Select state = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		state.selectByIndex(1);

		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600088");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("088");

		// Get the Firstname and print it
		System.out.println(ele.getAttribute("value"));

		// Click on create Lead Button
		driver.findElement(By.name("submitButton")).click();

		// Get and Verify the Title of the resulting Page(View Lead)
		if (driver.getTitle().equalsIgnoreCase("VIEW LEAD | OPENTAPS CRM")) {
			System.out.println("Title is Matched");
		} else {
			System.err.println("Title is Not Matched");
		}

		// Logout
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(1000);

		// Close the Browser
		driver.close();
	}

}
