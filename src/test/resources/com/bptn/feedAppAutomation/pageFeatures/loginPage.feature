Feature: Login Page
  
  # LoginPageSteps
  @WebTest 
  Scenario: Failure - User Login - Email Not Verified
    Given User is on the login page "/user/login"
     When User logs into the application with username "iyuvraajsingh" and password "Hello@123"
      And User clicks 'Submit' on the login page
     Then User should see the message "Email requires verification, me@iyuvraajsingh.com" on the login page