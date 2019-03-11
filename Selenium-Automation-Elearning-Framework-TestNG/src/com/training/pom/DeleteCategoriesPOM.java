package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCategoriesPOM {
	private WebDriver driver;

	public DeleteCategoriesPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "catalog")
	private WebElement catalog;

	@FindBy(xpath = "//a[contains(text(),'Categories')]")
	private WebElement categories;

	@FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	private WebElement categoryName;

	@FindBy(xpath = "//i[@class='fa fa-trash-o']")
	private WebElement deleteButton;

	public void clickCalalog() {
		this.catalog.click();
	}

	public void clickCategories() {
		this.categories.click();
	}

	public void selectCategoryName() {
		this.categoryName.click();
	}

	public void deleteCategories() {
		this.deleteButton.click();

	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
}
