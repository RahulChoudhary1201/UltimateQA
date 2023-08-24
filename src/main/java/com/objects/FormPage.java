package com.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.ActionsWithWaiting;

public class FormPage extends ActionsWithWaiting{

	WebDriver driver;

	public FormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//iframe[@title='reCAPTCHA'])[1]")
	private WebElement reCaptcheIframe;

	@FindBy(xpath = "//input[@id='control-0']")
	private WebElement nameField;

	@FindBy(xpath = "//input[@id='control-1']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@id='control-2']")
	private WebElement jobTitleField;

	@FindBy(xpath = "//input[@id='control-3']")
	private WebElement companyNameField;

	@FindBy(xpath = "(//textarea[@id='control-4'])[1]")
	private WebElement msgField;

	@FindBy(xpath = "//button[@data-test='form__submit-btn']")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	private WebElement reCaptchaCheckBox;
	
	public void enteringCredentials(String name, String email, String jobTitle, String companyName, String msg) {
		waitingForElement(reCaptcheIframe);
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		jobTitleField.sendKeys(jobTitle);
		companyNameField.sendKeys(companyName);
		msgField.sendKeys(msg);
		driver.switchTo().frame(reCaptcheIframe);
		reCaptchaCheckBox.click();
		driver.switchTo().parentFrame();
		submitBtn.click();

		driver.navigate().back();
	}

}
