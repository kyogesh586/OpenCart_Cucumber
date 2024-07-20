package stepDefinitions;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

@SuppressWarnings("deprecation")
public class RegistrationSteps {
	
	Properties p;
	HomePage hp;
	AccountRegistrationPage regpage;
	
	@Given("the user navigate to Account Registration pages")
	public void the_user_navigate_to_account_registration_pages() throws IOException {
	    
		BaseClass.getLogger().info("Goto my account-->Click on Register..");
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();		
	}

	@When("the user enters the details")
	public void the_user_enters_the_details(DataTable dataTable) {
	    
		BaseClass.getLogger().info("Entering details..");
		Map<String, String> dataMap=dataTable.asMap(String.class, String.class);
		
		regpage= new AccountRegistrationPage(BaseClass.getDriver());
		regpage.setFirstName(dataMap.get("firstName"));
		regpage.setLastName(dataMap.get("lastName"));
		regpage.setEmail(BaseClass.randomAlphanumeric()+"@gmail.com");
		regpage.setTelephone(dataMap.get("telephone"));
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmationPassword(dataMap.get("password"));
				
	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() {
	    
		regpage.checkPrivacyPolicy();
		BaseClass.getLogger().info("Checked privacy policy...");
	}

	@When("the user clicks on continue button")
	public void the_user_clicks_on_continue_button() {
		
		regpage.clickContinue();
		BaseClass.getLogger().info("Clicked on continue button...");
	}

	@SuppressWarnings("deprecation")
	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {
	    
		String cnfmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals("Your Account Has Been Created!", cnfmsg);
	}

}
