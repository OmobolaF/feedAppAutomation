package com.bptn.feedAppAutomation.stepPageDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import com.bptn.feedAppAutomation.provider.ResourceProvider;
import com.bptn.feedAppAutomation.web.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterPageSteps {

	@Autowired
	DriverManager driverManager;

	@Autowired
	ResourceProvider provider;

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	By txtFirstName = By.id("firstName");
	By txtLastName = By.id("lastName");
	By txtUsername = By.id("username");
	By txtEmail = By.id("emailId");
	By txtPassword = By.id("password");
	By txtPhone = By.id("phone");

	By xPathRegisterBtn = By.xpath("//input[@type='submit' and @value='Register']");
	By xPathMessageBadge = By.xpath("//*[@id='messageBadge']");

	@Given("User is on the register page {string}")
	public void user_is_on_the_register_page(String registerPageRoute) {
		// Write code here that turns the phrase above into concrete actions
		this.driverManager.getDriver().get(this.provider.getFrontEndUrl() + registerPageRoute);
	}

	@When("User registers to the application with the following user details:")
	public void user_registers_to_the_application_with_the_following_user_details(DataTable data) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		this.driverManager.getDriver().findElement(this.txtFirstName).sendKeys(data.asMap().get("firstName"));
		this.driverManager.getDriver().findElement(this.txtLastName).sendKeys(data.asMap().get("lastName"));
		this.driverManager.getDriver().findElement(this.txtUsername).sendKeys(data.asMap().get("username"));
		this.driverManager.getDriver().findElement(this.txtPassword).sendKeys(data.asMap().get("password"));
		this.driverManager.getDriver().findElement(this.txtPhone).sendKeys(data.asMap().get("phone"));
		this.driverManager.getDriver().findElement(this.txtEmail).sendKeys(data.asMap().get("email"));
	}

	@And("User clicks 'Submit' on the register page")
	public void user_clicks_on_the_register_page() {
		this.driverManager.getDriver().findElement(this.xPathRegisterBtn).click();
	}

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

	@Then("User should see the message {string} on the register page")
	public void user_should_see_the_message_on_the_register_page(String message) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(message, this.getMessage(this.xPathMessageBadge));
	}
}