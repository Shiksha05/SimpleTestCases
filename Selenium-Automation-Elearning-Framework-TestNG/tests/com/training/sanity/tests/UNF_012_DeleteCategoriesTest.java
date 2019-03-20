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
import com.training.pom.DeleteCategoriesPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_012_DeleteCategoriesTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private DeleteCategoriesPOM deleteCategoriesPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		deleteCategoriesPOM = new DeleteCategoriesPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// Login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF012_Page1_LoggedIn");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void DeleteCategories() throws InterruptedException {
		// Step1:Click on CatLog icon
		deleteCategoriesPOM.clickCalalog();
		// Step2:. Click on Categories
		deleteCategoriesPOM.clickCategories();
		// Step3:Click on checkbox of the category you to want to delete from categories
		// list
		deleteCategoriesPOM.selectCategoryName();
		screenShot.captureScreenShot("UNF012_Page2_SelectCategories");
		// Step4:Click on Delete Icon
		deleteCategoriesPOM.deleteCategories();
		// Step5: click on Ok button of pop up window
		deleteCategoriesPOM.acceptAlert();
		screenShot.captureScreenShot("UNF012_Page3_AcceptAlert");

		// Verifying Success message
		String Expected = "Success: You have modified categories!x";
		String Actual = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText().replace("\n", "");
		
		System.out.println(Actual);
		assertEquals(Actual, Expected);

	}

}
