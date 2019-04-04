package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnOrderPOM {
	private WebDriver driver;
	
	public ReturnOrderPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-user']")
	private WebElement usericon;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement login;
	
	@FindBy(id = "input-email")
	private WebElement emailId;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[@class='list-group-item'][contains(text(),'Order History')]")
	private WebElement orderHistory;
	
	@FindBy(xpath = "//tr[1]//td[7]//a[1]//i[1]")
	private WebElement viewIcon;
	
	@FindBy(xpath = "//div[@id='content']//a[2]")
	private WebElement returnIcon;
	
	@FindBy(xpath = "//input[@value='4']")
	private WebElement reasonForReturnRadioBtn;

	@FindBy(xpath = "//label[@class='radio-inline']//input[@value='1']")
	private WebElement productIsopenRadioBtn;
	
	@FindBy(xpath = "//textarea[@id='input-comment']")
	private WebElement inputComment;
	
	@FindBy(xpath = "//div[@class='pull-right']//input[@value='1']")
	private WebElement iAgreeCheckBox;
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//h1[contains(text(),'Product Returns')]")
	private WebElement successMsg;
	
	
	public void goToLoginPage(){
		this.usericon.click();
		this.login.click();
		}
	
	public void sendEmailId(String emailId) {
		this.emailId.clear();
		this.emailId.sendKeys(emailId);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void goToProductReturnPage() {
		this.orderHistory.click();
		this.viewIcon.click();
		this.returnIcon.click();
	}
	
		
	public void selectReasonForReturn() {
		this.reasonForReturnRadioBtn.click();
	}
	public void selectProductIsOpened() {
		this.productIsopenRadioBtn.click();
	}
	
	public void enterDetails(String userComment) {
		this.inputComment.sendKeys(userComment);
	}
	public void submitReturn() {
		this.iAgreeCheckBox.click();
		this.submitBtn.click();
	}
	public String actualResult() {
		String actualResult = this.successMsg.getText();
		return actualResult;
	}
	
	
	
	
	
	
	
	
}
