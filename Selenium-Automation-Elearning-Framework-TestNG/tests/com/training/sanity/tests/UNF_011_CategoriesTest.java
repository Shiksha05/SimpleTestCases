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
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_011_CategoriesTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CategoriesPOM categoriesPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		categoriesPOM = new CategoriesPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// Login as admin
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("UNF011_Page1_LoggedIn");
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void DisplayCategories() {
		// Step1:Click on CatLog icon
		categoriesPOM.clickCalalog();
		// Step2:Click on Categories link
		categoriesPOM.clickCategories();
		screenShot.captureScreenShot("UNF011_Page2_Categories");

		// Verifying Page Title
		String Expected = "Categories";
		String Actual = driver.getTitle();
		System.out.println("Result by driver.getTitle is : "+ Actual);
		
		//Trying to get title by tagname
		String Actual1 = driver.findElement(By.tagName("title")).getText();
		System.out.println("Result by by.tagName is : " + Actual1);
		
		assertEquals(Actual, Expected);

	}

}
