package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPOM {
	private WebDriver driver;

	public DeleteProductPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "catalog")
	private WebElement catalog;

	@FindBy(xpath = "//a[contains(text(),'Products')]")
	private WebElement products;

	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	// @FindBy(css = "//input[@value^='2']")
	private WebElement productName;

	@FindBy(xpath = "//i[@class='fa fa-trash-o']")
	private WebElement deleteButton;

	public void clickCalalog() {
		this.catalog.click();
	}

	public void clickProducts() {
		this.products.click();

	}

	public void deleteProducts() {
		this.productName.click();
		this.deleteButton.click();

	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
}
