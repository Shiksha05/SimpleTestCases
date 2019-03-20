package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteProductPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_044_DeleteMultipleProductsTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private DeleteProductPOM deleteProductPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		deleteProductPOM = new DeleteProductPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// Login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF044_Page1_LoggedIn");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void DeleteProducts() throws Exception {
		// Step1: Click on CatLog icon
		deleteProductPOM.clickCalalog();
		// Step2:Click on Products link
		deleteProductPOM.clickProducts();
		screenShot.captureScreenShot("UNF044_Page2_Products");
		// Step3:Click on Check box of the products to delete & Click on Delete Icon
		deleteProductPOM.selectMultipleCheckboxs();
		// Step4: click on Ok button of pop up window
		deleteProductPOM.acceptAlert();
		screenShot.captureScreenShot("UNF044_Page3_AfterDeletion");

		// Verifying Success message
		String Expected = "Success: You have modified products!×";
		String Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText().replaceAll("\n",
				"");
		System.out.println(Actual);
		assertEquals(Actual, Expected);
	}

}
