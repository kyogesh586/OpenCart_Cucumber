Feature: Account Registration

  Scenario: Successful Account Registration
    Given the user navigate to Account Registration page
    When the user enters the details
    	| firstName | John  	 	 |
    	| lastName	| Still 		 |
    	| telephone	| 1234567890 |
    	| password 	| test@123 	 |
    And the user selects Privacy Policy	
    And the user clicks on continue button
    Then the user account should get created successfully