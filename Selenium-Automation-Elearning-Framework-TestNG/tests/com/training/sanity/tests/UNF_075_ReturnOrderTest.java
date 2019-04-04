package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddProductPOM;
import com.training.pom.FilterProductPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ReturnOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_075_ReturnOrderTest {

	private WebDriver driver;
	private String baseUrl;
	private ReturnOrderPOM returnOrderPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		returnOrderPOM = new ReturnOrderPOM(driver);
		baseUrl = properties.getProperty("uniformURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// login as User
		returnOrderPOM.goToLoginPage();
		returnOrderPOM.sendEmailId("a.b@gmail.com");
		returnOrderPOM.sendPassword("abc@123");
		returnOrderPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF075_LoggedIn");

	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs3", dataProviderClass = LoginDataProviders.class)
	public void returnProduct(String userComment) {
		returnOrderPOM.goToProductReturnPage();
		returnOrderPOM.selectReasonForReturn();
		returnOrderPOM.selectProductIsOpened();
		returnOrderPOM.enterDetails(userComment);
		returnOrderPOM.submitReturn();
		screenShot.captureScreenShot("UNF075_ReturnProduct");
		
		// Verifying Success message
		String Expected = "PRODUCT RETURNS";
		String Actual = returnOrderPOM.actualResult();

		System.out.println(Actual);
		assertEquals(Actual, Expected);

	}

}
