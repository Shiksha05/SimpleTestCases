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
import com.training.pom.FilterProductPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_013_FilterProductTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterProductPOM filterProductPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		filterProductPOM = new FilterProductPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// Login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF013_Page1_LoggedIn");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void FilterProducts() throws InterruptedException {
		// Step1:Click on CatLog icon
		filterProductPOM.clickCalalog();
		// Step2: Click on Products link
		filterProductPOM.clickProducts();
		// Step3: Enter valid credentials in Product Name textbox & Click on Filter
		// button
		filterProductPOM.filterProducts();
		screenShot.captureScreenShot("UNF013_Page2__FilteredProduct");

		// Verifying Product Name
		String Expected = "Blazer-BoysNew";
		String Actual = driver.findElement(By.xpath("//body//tbody//td[3]")).getText();
		System.out.println(Actual);
		assertEquals(Actual, Expected);

	}

}
