package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

	@FindBy(xpath = " //tbody[1]/tr[1]/td[1]/input")
	// @FindBy(css = "//input[@value^='2']")
	private WebElement productName;

	@FindBy(xpath = " //tbody[1]/tr[2]/td[1]/input")
	// @FindBy(css = "//input[@value^='2']")
	private WebElement productName1;

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

	public void selectMultipleCheckboxs() throws Exception {
		this.productName.click();
		this.productName1.click();
		Thread.sleep(3000);
		this.deleteButton.click();
	}

	public void acceptAlert() throws Exception {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();

	}
}
