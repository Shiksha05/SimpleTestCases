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
import com.training.pom.CategoriesPOM;
import com.training.pom.GenerateInvoicePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_045_GenerateInvoiceTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private GenerateInvoicePOM generateInvoicePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		generateInvoicePOM = new GenerateInvoicePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// Login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF045_Page1_LoggedIn");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void GenerateInvoice() throws Exception {
		// Click on Cart Icon>>click on Orders link
		generateInvoicePOM.clickOrders();
		screenShot.captureScreenShot("UNF045_Page2_SelectOrder");
		Thread.sleep(2000);
		// Click on View icon beside the ordered product >>>click on Generate icon of
		// invoice tab
		generateInvoicePOM.generateInvoice();
		screenShot.captureScreenShot("UNF045_Page3_GenerateInvoice");

		// Verifying Invoice Number
		String ExpectedInvoiceNum = "INV-201";
		String ActualInvoiceNum = generateInvoicePOM.actualResult();
		boolean expected = ActualInvoiceNum.contains(ExpectedInvoiceNum);
		assertEquals(expected, true);

	}

}
