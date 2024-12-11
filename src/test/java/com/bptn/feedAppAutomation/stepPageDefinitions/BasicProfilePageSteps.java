package com.bptn.feedAppAutomation.stepPageDefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.bptn.feedAppAutomation.jwt.JwtService;
import com.bptn.feedAppAutomation.pageObjects.BasicProfilePage;
import com.bptn.feedAppAutomation.provider.ResourceProvider;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasicProfilePageSteps {
	@Autowired
	ResourceProvider resourceProvider;

	@Autowired
	BasicProfilePage basicProfilePage;

	@Autowired
	JwtService jwtService;

	String jwtToken;

	@Given("User {string} has a valid JWT token")
	public void user_has_a_valid_JWT_token(String username) {

		this.jwtToken = this.jwtService.generateJwtToken(username, this.resourceProvider.getJwtExpiration());
	}

	@When("User opens the basic profile page {string}")
	public void user_opens_the_basic_profile_page(String basicProfilePageRoute) {

		String basicProfilePageRouteWithToken = basicProfilePageRoute + "?token=" + this.jwtToken;
		this.basicProfilePage.openBasicProfilePage(basicProfilePageRouteWithToken);
	}

	@Then("User should see the following values:")
	public void user_should_see_the_following_values(DataTable data) {
		assertEquals(data.asMap().get("firstName"), this.basicProfilePage.getFirstName());
		assertEquals(data.asMap().get("lastName"), this.basicProfilePage.getLastName());
		assertEquals("", this.basicProfilePage.getPassword());
		assertEquals(data.asMap().get("phone"), this.basicProfilePage.getPhone());
		assertEquals(data.asMap().get("email"), this.basicProfilePage.getEmailId());
	}

	@When("User fills in the basic profile with the following values:")
	public void user_fills_in_the_basic_profile_with_the_following_values(DataTable data) {

		this.basicProfilePage.setFirstName(data.asMap().get("firstName"));
		this.basicProfilePage.setLastName(data.asMap().get("lastName"));
		this.basicProfilePage.setPassword(data.asMap().get("password"));
		this.basicProfilePage.setPhone(data.asMap().get("phone"));
		this.basicProfilePage.setEmailId(data.asMap().get("email"));
	}

	@When("User clicks 'Save' on the basic profile page")
	public void user_clicks_on_the_basic_profile_page() {
		this.basicProfilePage.clickSave();

	}

	@Then("User should see the message {string} on the basic profile page")
	public void user_should_see_the_message_on_the_basic_profile_page(String message) {
		assertEquals(message, this.basicProfilePage.getMessage());

	}

}
