package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProductPOM {
	private WebDriver driver;

	public AddProductPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "catalog")
	private WebElement catalog;

	@FindBy(xpath = "//a[contains(text(),'Products')]")
	private WebElement products;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	private WebElement addbutton;

	@FindBy(id = "input-name1")
	private WebElement productname;

	@FindBy(id = "input-meta-title1")
	private WebElement metatagtitle;

	@FindBy(xpath = "//a[contains(text(),'Data')]")
	private WebElement datatab;

	@FindBy(id = "input-model")
	private WebElement model;

	@FindBy(id = "input-price")
	private WebElement price;

	@FindBy(id = "input-quantity")
	private WebElement quantity;

	@FindBy(xpath = "//a[contains(text(),'Links')]")
	private WebElement linkstab;

	@FindBy(id = "input-category")
	private WebElement category;

	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement savebutton;

	@FindBy(xpath = "//i[@class='fa fa-check-circle']/parent::*")
	private WebElement successmsg;

	public void addNewProduct() {
		this.catalog.click();
		this.products.click();
		this.addbutton.click();

	}

	public void fillGeneralTab() {
		this.productname.sendKeys("Shirt");
		this.metatagtitle.sendKeys("Shirt for girls");

	}

	public void fillDataTab() {
		this.datatab.click();
		this.model.sendKeys("SHG-010");
		this.price.sendKeys("750");
		this.quantity.sendKeys("50");

	}

	public void fillLinksTab() {
		this.linkstab.click();
		this.category.sendKeys("Shirt");

	}

	public void saveProduct() {
		this.savebutton.click();
	}

	public String actualResult() {
		String actualresult = successmsg.getText().replace("\n", "").replaceAll("×", "");
		return actualresult;
	}

}
