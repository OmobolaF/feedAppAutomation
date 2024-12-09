Feature: Register a New User

  # RegisterPageSteps
  @WebTest
  Scenario: Success - Create a new User Account on the FeedApp
    Given User is on the register page "/user/register"
     When User registers to the application with the following user details:
       | firstName | Yuvraj               |
       | lastName  | Singh                |
       | username  | iyuvraajsingh        |
       | password  | Hello@123            |
       | phone     | 6471234567           |
       | email     | me@iyuvraajsingh.com |
      And User clicks 'Submit' on the register page
     Then User should see the message "Registration successful. Please verify your email to continue." on the register page