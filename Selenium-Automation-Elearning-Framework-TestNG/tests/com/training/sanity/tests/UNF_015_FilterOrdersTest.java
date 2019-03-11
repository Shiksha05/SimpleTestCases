package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FilterOrdersPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_015_FilterOrdersTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterOrdersPOM filterOrdersPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		filterOrdersPOM = new FilterOrdersPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// Login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF015_Page1_LoggedIn");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void FilterOrders() {
		// Step1:Click on Sales Report icon & Click on Orders link
		filterOrdersPOM.clickOrders();
		screenShot.captureScreenShot("UNF015_Page2_Orders");
		// Step2: Select Date Start and Date End
		filterOrdersPOM.selectStartDate();
		filterOrdersPOM.selectEndDate();
		screenShot.captureScreenShot("UNF015_Page3_DateSelected");
		// Step3: Click on Filter button
		filterOrdersPOM.clickFilterButton();
		screenShot.captureScreenShot("UNF015_Page4_AfterFilter1");
		// Step4: Select Group by and Order Status
		filterOrdersPOM.selectGroupByValue("Days");
		filterOrdersPOM.selectOrderStatusValue("Pending");
		screenShot.captureScreenShot("UNF015_Page5_SelectOrderStatus&GroupBy");
		// Step5: Click on Filter button
		filterOrdersPOM.clickFilterButton();
		screenShot.captureScreenShot("UNF015_Page6_AfterFilter2");

		// Verifying Product Name
		String Expected = "5";
		String Actual = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
		System.out.println(Actual);
		assertEquals(Actual, Expected);

	}

}
