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
import com.training.pom.EditProductQuantityPOM;
import com.training.pom.FilterProductPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_043_EditProductQuantityTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private EditProductQuantityPOM editProductQuantityPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		editProductQuantityPOM = new EditProductQuantityPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// Login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF043_Page1_LoggedIn");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void AddProduct() {
		// Catalog>>Product>>Click on EditButton
		editProductQuantityPOM.EditProduct();
		screenShot.captureScreenShot("UNF043_Page2_EditProduct");
		// Edit Quantity
		editProductQuantityPOM.EditQuantity();
		screenShot.captureScreenShot("UNF043_Page3_QuantityEdited");

		// Verifying Success message
		String Expected = "Success: You have modified products!";
		String Actual = editProductQuantityPOM.actualResult();

		System.out.println(Actual);
		assertEquals(Actual, Expected);
	}

}
