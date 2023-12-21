package Redbus;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Homepage {

		//step 1: formulate a test domain url and driver path
		String siteUrl = "https://www.redbus.in/";
		String driverPath = "drivers/windows/chromedriver.exe";	
		WebDriver driver;
		
		@BeforeMethod
		public void setUp() {
			//step 2: set system properties for selenium driver
			System.setProperty("webdriver.chrome.driver", driverPath);
		
			//step 3: Instantiate selenium web driver
			driver = new ChromeDriver();
							
			//step 4: launch browser
			driver.get(siteUrl);
		}
		
		@AfterMethod
		public void cleanUp() {
			driver.quit();  // the quit() method closes all browser windows and ends the WebDriver session.
			// driver.close(); // the close() closes only the current window on which Selenium is running automated tests.The WebDriver session, however, remains active. 
		}
		
		@Test(description = "Redbus Home Page Title Check- Valid Match")
		public void amazonHomePageTitle1() {
			String expectedTitle = "Online Bus Ticket Booking with Best Offers and Lowest Price - redBus";
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle,expectedTitle);
		}
		
		@Test(description = "Redbus Home Page Title Check- Invalid Match")
		public void amazonHomePageTitle2() {
			String expectedTitle = "OOnline Bus Ticket Booking with Best Offers and Lowest Price - redBus";
			String actualTitle = driver.getTitle();
			assertNotEquals(actualTitle,expectedTitle);
		}
		
		@Test(description = "Amazon Home Page URL Check- Valid Match")
		public void amazonSourceURL1() {
			assertEquals(siteUrl, driver.getCurrentUrl());
		}

	}
