
Feature: Registeration Data Driven with Excel

  Scenario Outline: Registeration Data Driver Excel
    Given the user navigate to Account Registration page
    Then the account should be created by providing mandatory details, select Privacy Policy and click on continue button with excel row "<row_index>"
   
    Examples: 
      | row_index  |
      | 1					 |
      | 2					 |
      | 3					 |
      | 4					 |
