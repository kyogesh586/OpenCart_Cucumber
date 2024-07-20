Feature: Logout

  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes

  Scenario: Logout User Account
    Given the user redirects to the login page
    When the user provides the details
    | email     | yogeshqa23@gmail.com  	 	 |
    | password	| 123456        				 		 |
    And the user clicks on the login page
    And the user click on the logout link
    Then the user should logout successfully

