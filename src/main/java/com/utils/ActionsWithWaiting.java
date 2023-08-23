package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseTest;

public class ActionsWithWaiting extends BaseTest {

	public ActionsWithWaiting(WebDriver driver) {
		this.driver = driver;
	}

	public void waitingForElement(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(ele));
	}

	public void mouseActions(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();

	}

}
