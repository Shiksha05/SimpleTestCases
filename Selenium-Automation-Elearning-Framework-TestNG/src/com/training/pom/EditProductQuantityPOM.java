package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditProductQuantityPOM {
	private WebDriver driver;

	public EditProductQuantityPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "catalog")
	private WebElement catalog;

	@FindBy(xpath = "//a[contains(text(),'Products')]")
	private WebElement products;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/following-sibling::td//i")
	private WebElement editbutton;

	@FindBy(linkText = "Data")
	private WebElement datatab;

	@FindBy(id = "input-quantity")
	private WebElement quantity;

	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement savebutton;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement successmsg;

	public void EditProduct() {
		this.catalog.click();
		this.products.click();
		this.editbutton.click();

	}

	public void EditQuantity() {
		this.datatab.click();
		this.quantity.clear();
		this.quantity.sendKeys("100");
		this.savebutton.click();

	}

	public String actualResult() {
		String actualresult = successmsg.getText().replace("\n", "").replaceAll("×", "");
		return actualresult;
	}

}
