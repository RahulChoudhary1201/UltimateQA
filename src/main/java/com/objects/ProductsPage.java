package com.objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
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

	// li[@class='form-error__list-item']
	@FindBy(xpath = "//li[@class='form-error__list-item']")
	private WebElement errorMsgText;

	// button[@data-callback='onSubmit']
	@FindBy(xpath = "//button[@data-callback='onSubmit']")
	private WebElement submitBtn;

	public void waitingForElement(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOf(ele));
	}

	public void navigatinBackToUrl() {
		driver.navigate().to("https://ultimateqa.com/consulting/");
		waitingForElement(professionalServices);
	}

//	ActionsWithWaiting acw = new ActionsWithWaiting(driver);

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
