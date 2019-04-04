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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_072_AddProductWithInvalidDataTest {

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
		screenShot.captureScreenShot("UNF072_Page1_LoggedIn");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void AddProduct(String productname, String metatag, String model, String price, String quantity,
			String category, String discountquantity, String discountprice, String points) throws InterruptedException {
		addProductPOM.addNewProduct();
		addProductPOM.inputProductName(productname);
		addProductPOM.inputMetaTagTitle(metatag);
		addProductPOM.clickDataTab();
		addProductPOM.inputModel(model);
		addProductPOM.inputPrice(price);
		addProductPOM.inputQuantity(quantity);
		addProductPOM.clickLinkTab();
		addProductPOM.inputCategory(category);
		addProductPOM.clickDiscountTab();
		addProductPOM.inputDiscountQuantity(discountquantity);
		addProductPOM.inputDiscountPrice(discountprice);
		addProductPOM.selectStartEnddate();
		addProductPOM.clickRewardPointTab();
		addProductPOM.inputPoint(points);
		addProductPOM.saveProduct();
		screenShot.captureScreenShot("UNF072_Productadded");
		
		// Verifying Error message
				String Expected = "Warning: Please check the form carefully for errors!";
				String Actual = addProductPOM.actualResult1();

				System.out.println(Actual);
				assertEquals(Actual, Expected);

	}

}
