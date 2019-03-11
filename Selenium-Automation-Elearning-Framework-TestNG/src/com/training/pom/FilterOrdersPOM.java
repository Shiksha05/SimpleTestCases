package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterOrdersPOM {
	private WebDriver driver;

	public FilterOrdersPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-bar-chart-o fa-fw']")
	private WebElement reports;

	@FindBy(xpath = "//a[contains(text(),'Sales')]")
	private WebElement sales;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[9]/ul[1]/li[1]/ul[1]/li[1]/a[1]")
	private WebElement orders;

	@FindBy(xpath = "//div[@class='col-sm-6']//div[1]//div[1]//span[1]//button[1]//i[1]")
	private WebElement startDateCal;

	@FindBy(xpath = "//td[@class='day old'][contains(text(),'25')]")
	private WebElement startDate;

	@FindBy(xpath = "//div[@class='panel-body']//div[2]//div[1]//span[1]//button[1]//i[1]")
	private WebElement endDateCal;

	@FindBy(xpath = "//td[@class='day active today']")
	private WebElement endDate;

	@FindBy(xpath = "//select[@id='input-group']")
	private WebElement groupBy;

	@FindBy(xpath = "//select[@id='input-status']")
	private WebElement orderStatus;

	@FindBy(id = "button-filter")
	private WebElement filterButton;

	public void clickOrders() {
		this.reports.click();
		this.sales.click();
		this.orders.click();
	}

	public void selectStartDate() {
		this.startDateCal.click();
		this.startDate.click();
	}

	public void selectEndDate() {
		this.endDateCal.click();
		this.endDate.click();
	}

	public void selectGroupByValue(String groupvalue) {
		this.groupBy.click();
		Select groupByValue = new Select(groupBy);
		// List<WebElement> groupByOptions = groupByValue.getOptions();
		groupByValue.selectByVisibleText(groupvalue);

	}

	public void selectOrderStatusValue(String orderstatus) {
		this.orderStatus.click();
		Select orderStatusValue = new Select(orderStatus);
		// List<WebElement> orderStatusOptions = orderStatusValue.getOptions();
		orderStatusValue.selectByVisibleText(orderstatus);

	}

	public void clickFilterButton() {
		this.filterButton.click();

	}
}
