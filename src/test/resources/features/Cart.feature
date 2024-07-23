
@cart
Feature: Testing Cart Feature on SauceDemo
	
	Background: create an session
    Given user is logged in using below credentials
    | user_category     | input_json |
    | standard          | credentials.json   |
    
  @ui @e2e @sanity
  Scenario Outline: verify user is able to add items to cart
  	Given user clicks on "<item_name>"
    When user cliks on add to cart button
    Then user should be able to see item in cart "<item_count>"
    Examples:
    	 | item_name              | item_count |
       | Sauce Labs Backpack 		|     1      |
