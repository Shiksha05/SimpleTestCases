package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PlaceOrdersPOM {
	private WebDriver driver;

	public PlaceOrdersPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='http://uniform.upskills.in/index.php?route=product/product&product_id=179']//img[@title='SPORTS T-SHIRTS']")
	private WebElement BlueTshirt;

	@FindBy(id = "input-option368")
	private WebElement ChestSize;

	@FindBy(id = "button-cart")
	private WebElement AddToCart;

	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement CartIcon;

	@FindBy(xpath = "//strong[contains(text(),'View Cart')]")
	private WebElement viewCart;

	@FindBy(xpath = "//strong[contains(text(),'Checkout')]")
	private WebElement Checkout;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//input[@id='button-payment-address']")
	private WebElement BillingContiueBtn;

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	private WebElement shippingContiueBtn;

	@FindBy(xpath = "//textarea[@name='comment']")
	private WebElement textarea;

	@FindBy(xpath = "//input[@id='button-shipping-method']")
	private WebElement shippingContiueBtn1;

	@FindBy(xpath = "//input[@value='1']")
	private WebElement checkbox;

	@FindBy(xpath = "//input[@id='button-payment-method']")
	private WebElement paymentContiueBtn1;

	@FindBy(xpath = "//input[@id='button-confirm']")
	private WebElement confirmOrderBtn;

	@FindBy(xpath = "//h1[contains(text(),'Your order has been placed!')]")
	private WebElement successmsgForPlacingOrder;

	@FindBy(xpath = "//i[@class='fa fa-shopping-cart fa-fw']")
	private WebElement shoppingCart;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[1]/a[1]")
	private WebElement orders;

	@FindBy(xpath = "//tr[1]//td[8]//a[1]//i[1]")
	private WebElement viewOrder;

	@FindBy(xpath = "//select[@id='input-order-status']")
	private WebElement orderStatus;

	@FindBy(xpath = "//button[@id='button-history']")
	private WebElement addHistoryBtn;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement successmsgforStatusChange;

	@FindBy(xpath = "//span[contains(text(),'shiksha patle')]")
	private WebElement myAccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[contains(text(),'Order History')]")
	private WebElement OrderHistory;

	@FindBy(xpath = "//tbody//tr[1]//td[4]")
	private WebElement verifyOrderStatus;

	public void selectProductaddTocart() {
		this.BlueTshirt.click();
		this.ChestSize.click();
		Select ChestsizeValue = new Select(ChestSize);
		ChestsizeValue.selectByVisibleText("26");
		this.AddToCart.click();

	}

	public void gotoCart() {
		this.CartIcon.click();
		this.Checkout.click();
	}

	public void sendEmailId(String emailId) {
		this.email.clear();
		this.email.sendKeys(emailId);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginButton.click();
	}

	public void otherDetails() {
		this.BillingContiueBtn.click();
		this.shippingContiueBtn.click();
		this.textarea.sendKeys("Test Order");
		this.shippingContiueBtn1.click();
		this.checkbox.click();
		this.paymentContiueBtn1.click();
		this.confirmOrderBtn.click();
	}

	public String actualResult() {
		String actualResult = this.successmsgForPlacingOrder.getText();
		return actualResult;
	}

	public void changeOrderStatus() {
		this.shoppingCart.click();
		this.orders.click();
		this.viewOrder.click();
		this.orderStatus.click();
		Select orderStatusValue = new Select(orderStatus);
		orderStatusValue.selectByVisibleText("Complete");
		this.addHistoryBtn.click();

	}

	public String actualResult1() {
		String actualResult = this.successmsgforStatusChange.getText().replace("\n", "").replaceAll("×", "");
		return actualResult;
	}

	public void viewOrderHistory() {
		this.myAccount.click();
		this.OrderHistory.click();

	}

	public String actualOrderStatus() {
		String actualResult = this.verifyOrderStatus.getText();
		return actualResult;
	}

}
