package com.bptn.feedAppAutomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.springframework.stereotype.Component;

@Component
public class BasicProfilePage extends BasePage {

	By txtFirstName = By.name("firstName");
	By txtLastName = By.name("lastName");
	By txtEmailId = By.name("emailId");
	By txtPhone = By.name("phone");
	By txtPassword = By.name("password");

	// By xPathSaveBtn = By.xpath("//input[@type='submit' and @value='Save' and
	// @fdprocessedid='lsizut']");
	// By xPathSaveBtn =
	// By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/form[1]/footer[1]/input[1]");
	By xPathSaveBtn = By.xpath("//footer/input[@type='submit' and @value='Save']");

	By cssMessageBadge = By.cssSelector("div[id='messageBadge'] div");

	public void openBasicProfilePage(String basicProfilePageRoute) {
		this.driverManager.getDriver().get(this.provider.getFrontEndUrl() + basicProfilePageRoute);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getFirstName() {
		return this.driverManager.getDriver().findElement(this.txtFirstName).getDomAttribute("value");
	}

	public String getLastName() {
		return this.driverManager.getDriver().findElement(this.txtLastName).getDomAttribute("value");
	}

	public String getEmailId() {
		return this.driverManager.getDriver().findElement(this.txtEmailId).getDomAttribute("value");
	}

	public String getPhone() {
		return this.driverManager.getDriver().findElement(this.txtPhone).getDomAttribute("value");
	}

	public String getPassword() {
		return this.driverManager.getDriver().findElement(this.txtPassword).getDomAttribute("value");
	}

	public void setFirstName(String firstName) {
		while (!this.getFirstName().equals("")) {
			this.driverManager.getDriver().findElement(this.txtFirstName).sendKeys(Keys.BACK_SPACE);
		}
		this.driverManager.getDriver().findElement(this.txtFirstName).sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		while (!this.getLastName().equals("")) {
			this.driverManager.getDriver().findElement(this.txtLastName).sendKeys(Keys.BACK_SPACE);
		}
		this.driverManager.getDriver().findElement(this.txtLastName).sendKeys(lastName);
	}

	public void setEmailId(String emailId) {
		while (!this.getEmailId().equals("")) {
			this.driverManager.getDriver().findElement(this.txtEmailId).sendKeys(Keys.BACK_SPACE);
		}
		this.driverManager.getDriver().findElement(this.txtEmailId).sendKeys(emailId);
	}

	public void setPhone(String phone) {
		while (!this.getPhone().equals("")) {
			this.driverManager.getDriver().findElement(this.txtPhone).sendKeys(Keys.BACK_SPACE);
		}
		this.driverManager.getDriver().findElement(this.txtPhone).sendKeys(phone);
	}

	public void setPassword(String password) {
		while (!this.getPassword().equals("")) {
			this.driverManager.getDriver().findElement(this.txtPassword).sendKeys(Keys.BACK_SPACE);
		}
		this.driverManager.getDriver().findElement(this.txtPassword).sendKeys(password);
	}

	public void clickSave() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.driverManager.getDriver().findElement(this.xPathSaveBtn).click();
	}

	public String getMessage() {
		return this.getMessage(this.cssMessageBadge);
	}

}