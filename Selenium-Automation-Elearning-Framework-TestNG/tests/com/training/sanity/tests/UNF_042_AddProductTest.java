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
import com.training.pom.AddProductPOM;
import com.training.pom.FilterProductPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_042_AddProductTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddProductPOM addProductPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		addProductPOM = new AddProductPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// Login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF042_Page1_LoggedIn");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void AddProduct() {
		// Catalog>>Product>>Click on Add New icon under
		addProductPOM.addNewProduct();
		screenShot.captureScreenShot("UNF042_Page2_AddNewProduct");
		// Enter details in General tab.
		addProductPOM.fillGeneralTab();
		screenShot.captureScreenShot("UNF042_Page3_GeneralTab");
		// Enter details in data tab.
		addProductPOM.fillDataTab();
		screenShot.captureScreenShot("UNF042_Page4_DataTab");
		// Enter details in links tab.
		addProductPOM.fillLinksTab();
		screenShot.captureScreenShot("UNF042_Page5_LinkTab");
		// Click on Save Button
		addProductPOM.saveProduct();
		screenShot.captureScreenShot("UNF042_Page6_ProductAdded");

		// Verifying Success message
		String Expected = "Success: You have modified products!";
		String Actual = addProductPOM.actualResult();

		System.out.println(Actual);
		assertEquals(Actual, Expected);
	}

}
