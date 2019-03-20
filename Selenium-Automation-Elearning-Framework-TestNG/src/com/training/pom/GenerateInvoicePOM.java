package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateInvoicePOM {
	private WebDriver driver;

	public GenerateInvoicePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-shopping-cart fa-fw']")
	private WebElement cart;

	@FindBy(xpath = "//a[contains(text(),'Orders')]")
	private WebElement orders;

	@FindBy(xpath = "//tbody/tr[2]/td[1]/following-sibling::td//i[@class='fa fa-eye']")
	private WebElement viewbutton;

	@FindBy(xpath = "//td[@id='invoice']/following-sibling::*")
	private WebElement generateinvoicebutton;

	@FindBy(id = "invoice")
	private WebElement invoicenumber;

	public void clickOrders() {
		this.cart.click();
		this.orders.click();
	}

	public void generateInvoice() {
		this.viewbutton.click();
		this.generateinvoicebutton.click();

	}

	public String actualResult() {
		String ActualResult = invoicenumber.getText();
		System.out.println(ActualResult);

		return ActualResult;

	}
}
