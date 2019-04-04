package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddProductPOM;
import com.training.pom.FilterProductPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PlaceOrdersPOM;
import com.training.pom.ReturnOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_074_PlaceOrderTest {

	private WebDriver driver;
	private String uniformUrl;
	private String baseUrl;
	private LoginPOM loginPOM;
	private PlaceOrdersPOM placeOrdersPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		placeOrdersPOM = new PlaceOrdersPOM(driver);
		uniformUrl = properties.getProperty("uniformURL");
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(uniformUrl);

	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 1)
	public void PlaceOrder() {
		placeOrdersPOM.selectProductaddTocart();
		placeOrdersPOM.gotoCart();
		placeOrdersPOM.sendEmailId("a.b@gmail.com");
		placeOrdersPOM.sendPassword("abc@123");
		screenShot.captureScreenShot("UNF074_LoggedIn");
		placeOrdersPOM.clickLoginBtn();
		placeOrdersPOM.otherDetails();
		screenShot.captureScreenShot("UNF074_OrderPlaced");
		// Verifying Success message
		String Expected = "YOUR ORDER HAS BEEN PLACED!";
		String Actual = placeOrdersPOM.actualResult();
		System.out.println(Actual);
		assertEquals(Actual, Expected);

	}

	@Test(priority = 2)
	public void ChangeOrderStatus() {
		// open the browser
		driver.get(baseUrl);
		// Login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		placeOrdersPOM.changeOrderStatus();
		screenShot.captureScreenShot("UNF074_ChangeOrderStatus");
		// Verifying Success message
		String Expected1 = "Success: You have modified orders!";
		String Actual1 = placeOrdersPOM.actualResult1();
		System.out.println(Actual1);
		assertEquals(Actual1, Expected1);

	}

	@Test(priority = 3)
	public void ViewOrderHistory() {
		// open the browser
		driver.get(uniformUrl);
		placeOrdersPOM.viewOrderHistory();
		screenShot.captureScreenShot("UNF074_ViewOrderHistory");
		// Verifying Order Status
		String ExpectedOrderStatus = "Complete";
		String ActualOrderStatus = placeOrdersPOM.actualOrderStatus();
		System.out.println(ActualOrderStatus);
		assertEquals(ActualOrderStatus, ExpectedOrderStatus);

	}

}
