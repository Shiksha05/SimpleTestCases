package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(id = "input-price")
	private WebElement price;

	@FindBy(id = "input-status")
	private WebElement status;

	@FindBy(id = "input-model")
	private WebElement model;

	@FindBy(id = "input-quantity")
	private WebElement quantity;

	@FindBy(id = "button-filter")
	private WebElement filterButton;

	public void clickCalalog() {
		this.catalog.click();
	}

	public void clickProducts() {
		this.products.click();

	}

	public void filterProductName() {
		this.productName.sendKeys("Blazer-Boys");
		this.filterButton.click();

	}

	public void filterPrice() {
		this.price.sendKeys("1000");
		this.filterButton.click();

	}

	public void filterStatus() {
		this.status.click();
		Select StatusValue = new Select(status);
		StatusValue.selectByVisibleText("Enabled");
		this.filterButton.click();
	}

	public void filterModel() {
		this.model.sendKeys("Blazer-BoysNew");
		this.filterButton.click();
	}

	public void filterQuantity() {
		this.quantity.sendKeys("100");
		this.filterButton.click();
	}

}
