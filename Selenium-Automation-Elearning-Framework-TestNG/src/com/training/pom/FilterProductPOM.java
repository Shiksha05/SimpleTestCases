package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterProductPOM {
	private WebDriver driver;

	public FilterProductPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "catalog")
	private WebElement catalog;

	@FindBy(xpath = "//a[contains(text(),'Products')]")
	private WebElement products;

	@FindBy(id = "input-name")
	private WebElement productName;

	@FindBy(id = "button-filter")
	private WebElement filterButton;

	public void clickCalalog() {
		this.catalog.click();
	}

	public void clickProducts() {
		this.products.click();

	}

	public void filterProducts() {
		this.productName.sendKeys("Blazer-Boys");
		this.filterButton.click();

	}
}
