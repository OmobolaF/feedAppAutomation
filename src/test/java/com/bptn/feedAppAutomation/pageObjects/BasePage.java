package com.bptn.feedAppAutomation.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.feedAppAutomation.provider.ResourceProvider;
import com.bptn.feedAppAutomation.web.DriverManager;

public class BasePage {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DriverManager driverManager;

	@Autowired
	ResourceProvider provider;

	public String getMessage(By xPathMessage) {
		try {
			WebDriverWait wait = new WebDriverWait(this.driverManager.getDriver(), Duration.ofSeconds(10));
			WebElement messageBadgeElement = wait.until(ExpectedConditions.presenceOfElementLocated(xPathMessage));

			Thread.sleep(2000);

			return messageBadgeElement.getText();
		} catch (Exception ex) {
			this.logger.error(ex.getMessage(), ex);
		}

		return null;
	}

}