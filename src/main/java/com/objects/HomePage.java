package com.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.ActionsWithWaiting;

public class HomePage extends ActionsWithWaiting {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//ul[@id='menu-home-page-menu']/li/a)[1]")
	private WebElement professionalServices;

	@FindBy(xpath = "//a[normalize-space()='Get a free consultation']")
	private WebElement consultantBtn;

	@FindBy(xpath = "//ul[@id='menu-home-page-menu']/li[3]/a")
	private WebElement learningMenu;

	@FindBy(xpath = "(//a[normalize-space()='Free Courses'])[1]")
	private WebElement freeCourses;

	public void clickPservices() {
		professionalServices.click();
	}

	public FormPage consultantBtnClick() {
		consultantBtn.click();
		return new FormPage(driver);
	}

	public void mouseActions(WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();

	}

	public ProductsPage movingToLearningMenu() {
		waitingForElement(learningMenu);
		mouseActions(learningMenu);
		waitingForElement(freeCourses);
		freeCourses.click();
		return new ProductsPage(driver);
	}

}
