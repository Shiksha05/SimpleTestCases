package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPOM {
	private WebDriver driver;

	public CategoriesPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "catalog")
	private WebElement catalog;

	@FindBy(xpath = "//a[contains(text(),'Categories')]")
	private WebElement categories;

	public void clickCalalog() {
		this.catalog.click();
	}

	public void clickCategories() {
		this.categories.click();

	}
}
