package stepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import factory.BaseClass;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import utilities.DataReader;
import utilities.DataReader1;

public class RegistrationDDTExcelSteps {
	
	HomePage hmpage;
	Properties p;
	AccountRegistrationPage regpage;
	MyAccountPage macc;

	List<HashMap<String, String>> dataMap;
	
	@Given("the user navigate to Account Registration page")
	public void the_user_navigate_to_account_registration_page() {
		
		BaseClass.getLogger().info("Go to My Account--> Click on Register...");
		hmpage= new HomePage(BaseClass.getDriver());
		hmpage.clickMyAccount();
		hmpage.clickRegister();
	}
	

	@Then("the account should be created by providing mandatory details, select Privacy Policy and click on continue button with excel row {string}")
	public void the_account_should_be_created_by_providing_mandatory_details_with_excel_row_select_privacy_policy_and_click_on_continue_button(String rows) {
	   
		BaseClass.getLogger().info("Entering details...");
		
		try {
			
			dataMap = DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_TestData3.xlsx", "Sheet2");	
		
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		int index = Integer.parseInt(rows)-1;
		String fName = dataMap.get(index).get("firstName");
		String lName = dataMap.get(index).get("lastName");
		String email = dataMap.get(index).get("email");
		String telephone = dataMap.get(index).get("telephone");
		String password = dataMap.get(index).get("password");
		String exp_res = dataMap.get(index).get("res");
		
		
		regpage = new AccountRegistrationPage(BaseClass.getDriver());
		
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		regpage.setFirstName(fName);
		regpage.setLastName(lName);
		regpage.setEmail(email);
		regpage.setTelephone(telephone);
		regpage.setPassword(password);
		regpage.setConfirmationPassword(password);
		regpage.checkPrivacyPolicy();
		regpage.clickContinue();
			
			try {
				
				boolean accountCreated = regpage.isAccountCreated();
				
				if(exp_res.equalsIgnoreCase("valid")) {
					
					if(accountCreated==true) {
						
						String cnfmsg = regpage.getConfirmationMsg();
						
						Assert.assertEquals("Your Account Has Been Created!", cnfmsg);
					}
					
					else {
						
						Assert.assertTrue(false);
					}
				}
				
				if(exp_res.equalsIgnoreCase("invalid")) {
					
					if(accountCreated==false) {
						
						Assert.assertTrue(true);
					}
					
					else {
						
						Assert.assertTrue(false);
					}
				}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
	
	}

}
