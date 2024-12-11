Feature: Basic Profile Page

 @WebTest
  Scenario: Update Basic Profile
  	Given User "iyuvraajsingh" has a valid JWT token
    When User opens the basic profile page "/app/profile"
    Then User should see the following values:
       | firstName | Yuvraj               |
       | lastName  | Singh                |
       | phone     | 6471234567           |
       | email     | me@iyuvraajsingh.com |
    When User fills in the basic profile with the following values:
       | firstName | newFistname          |
       | lastName  | newLastName          |
       | phone     | 9999999999           |       
       | password  | new@Pass123          |
       | email     | new@email.com        |
    And User clicks 'Save' on the basic profile page
    Then User should see the message "Basic profile saved." on the basic profile page
    
    @WebTest
  Scenario: Failure Basic Profile
  	Given User "iyuvraajsingh" has a valid JWT token
    When User opens the basic profile page "/app/profile"
    When User fills in the basic profile with the following values:
       | firstName | newerFistname          |
       | lastName  | newerLastName          |
       | phone     | 9999999999           	|       
       | password  | newer@Pass123          |
       | email     | me@johndoe.com        	|
    And User clicks 'Save' on the basic profile page
    Then User should see the message "Email already exists, me@johndoe.com" on the basic profile page