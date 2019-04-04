package com.training.pom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	@FindBy(xpath = "//a[contains(text(),'Discount')]")
	private WebElement discounttab;
	
	@FindBy(xpath = "//table[@id='discount']//i[@class='fa fa-plus-circle']")
	private WebElement adddiscounticon;
	
	@FindBy(name ="product_discount[0][quantity]")
	private WebElement discountquantity;
	
	@FindBy(name ="product_discount[0][price]")
	private WebElement discountprice;
	
	@FindBy(name ="product_discount[0][date_start]")
	private WebElement startdatecal;
	
	@FindBy(name ="product_discount[0][date_end]")
	private WebElement enddatecal;
	
	
	//@FindBy(xpath = "//a[contains(text(),'Reward Points')]")
	@FindBy(xpath = "//a[@href='#tab-reward']")
	private WebElement rewardspointtab;
	
	@FindBy(id="input-points")
	private WebElement points;
	
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement savebutton;

	@FindBy(xpath = "//i[@class='fa fa-check-circle']/parent::*")
	private WebElement successmsg;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement errormsg;

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

	public void inputProductName(String productname) {
		this.productname.sendKeys(productname);
	}
	
	public void inputMetaTagTitle(String metatag) {
		this.metatagtitle.sendKeys(metatag);
	}
	
	public void clickDataTab() {
		this.datatab.click();
	}
	public void inputModel(String model) {
		this.model.sendKeys(model);
	}
	public void inputPrice(String price) {
		this.price.sendKeys(price);
	}
	public void inputQuantity(String quantity) {
		this.quantity.sendKeys(quantity);
	}
	
	public void clickLinkTab() {
		this.linkstab.click();
	}
	public void inputCategory(String category) {
		this.category.sendKeys(category);
	}
	public void clickDiscountTab() {
		this.discounttab.click();
		this.adddiscounticon.click();
	}
	public void inputDiscountPrice(String discountprice) {
		this.discountprice.sendKeys(discountprice);
	}
	public void inputDiscountQuantity(String discountquantity) {
		this.discountquantity.sendKeys(discountquantity);
	}
	public void selectStartEnddate() throws InterruptedException {
	
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		String modifiedDateToday = new SimpleDateFormat("yyyy-MM-dd").format(today);
		System.out.println(modifiedDateToday);
		calendar.add(calendar.DAY_OF_MONTH, 1);
		Date tomorrow = calendar.getTime();
		String modifiedDateTmrw = new SimpleDateFormat("yyyy-MM-dd").format(tomorrow);
		System.out.println(modifiedDateTmrw);
		
		this.startdatecal.sendKeys(modifiedDateToday);
		this.enddatecal.sendKeys(modifiedDateTmrw);
		
	}
	public void clickRewardPointTab() {
		this.rewardspointtab.click();
	}
	public void inputPoint(String points) {
		this.points.sendKeys(points);
	}
	
	
	public void saveProduct() {
		this.savebutton.click();
	}

	public String actualResult() {
		String actualresult = successmsg.getText().replace("\n", "").replaceAll("×", "");
		return actualresult;
	}
	
	public String actualResult1() {
		String actualresult = errormsg.getText().replace("\n", "").replaceAll("×", "");
		return actualresult;
	}

}
