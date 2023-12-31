package com.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.ActionsWithWaiting;

public class ProductsPage extends ActionsWithWaiting {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//ul[@id='menu-home-page-menu']/li/a)[1]")
	private WebElement professionalServices;

	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	private WebElement signInBtn;

	@FindBy(xpath = "//article[@class='sign-in__form']")
	private WebElement form;

	@FindBy(xpath = "//input[@id='user[email]']")
	private WebElement emailInputField;

	@FindBy(xpath = "//input[@id='user[password]']")
	private WebElement passInputField;

	@FindBy(xpath = "//li[@class='form-error__list-item']")
	private WebElement errorMsgText;

	@FindBy(xpath = "//button[@data-callback='onSubmit']")
	private WebElement submitBtn;

	public void navigatinBackToUrl() {
		driver.navigate().to("https://ultimateqa.com/consulting/");
		waitingForElement(professionalServices);
	}

	public void signInForm(String email, String password) {
		signInBtn.click();
		waitingForElement(form);

		waitingForElement(emailInputField);
		emailInputField.sendKeys(email);
		passInputField.sendKeys(password);
		submitBtn.click();
	}

	public String capturingErrorMsg() {
		waitingForElement(errorMsgText);
		return errorMsgText.getText();

	}
}
