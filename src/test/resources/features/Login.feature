
@Login @smoke
Feature: Testing Login Feature on SauceDemo

  @ui @smoke
  Scenario Outline: verify user is able or not to login with given username and Password
    Given user has credentials "<user_category>" from "<input_json>"
    When user enters name and password 
    And user clicks to submit button
    Then user should be "<access_flag>" see the dashboard page
    Examples:
      | input_json 				| user_category | access_flag |
      | credentials.json 	|   standard    | 		true 		|