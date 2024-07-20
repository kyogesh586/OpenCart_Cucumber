Feature: Login with Valid Credentials
  

  #Scenario: Successfull Login with Valid Credentials
    #Given the user navigates to the login page
    #When user enters email as "yogeshqa23@gmail.com" and password as "123456"
    #And the user clicks on the login page
    #Then the user should be redirected to the MyAccount Page
    
    Scenario Outline: Datadriven Login
			Given the user navigates to the login page
			When the user enters email as "<email>" and password as "<password>"
			And the user clicks on the login page
			Then the user should be redirected to the MyAccount Page
			
			Examples:
			| email                | password |
			| yogeshqa23@gmail.com | 123456   |
			| admin@gmail.com      | 123456   |

