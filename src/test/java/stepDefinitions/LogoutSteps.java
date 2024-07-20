package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;

public class LogoutSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	LogoutPage lgp;
	
	
	@Given("the user redirects to the login page")
	public void the_user_redirects_to_the_login_page() {
	    
		BaseClass.getLogger().info("Goto my account-->Click on Login..");
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogin();
		
	}
	
	@When("the user provides the details")
	public void the_user_provides_the_details(DataTable dataTable) {
	    
		BaseClass.getLogger().info("Entering email and password...");
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(dataMap.get("email"));
		lp.setPassword(dataMap.get("password"));
	}

	@When("the user clicks on the login page")
	public void the_user_clicks_on_the_login_page() {
	    
		BaseClass.getLogger().info("Clicking on login button");
		lp.clickLogin();
	}

	@When("the user click on the logout link")
	public void the_user_click_on_the_logout_link() {
	    
		BaseClass.getLogger().info("Clicking on logout link in the MyAccount DD...");
		hp.clickMyAccount();
		
		lgp = new LogoutPage(BaseClass.getDriver());
		lgp.clickLogout();
		
	}

	@Then("the user should logout successfully")
	public void the_user_should_logout_successfully() {
	    
		hp.clickMyAccount();
		
		if(hp.isLinkLoginDisplay()) {
			
			Assert.assertTrue(true);
		}
		
		else {
			
			Assert.assertTrue(false);
		}
		
		lgp.isBtnContinueDisplay();
		
		if(hp.isLogoDisplayed()) {
			
			Assert.assertTrue(true);
		}
		
		else {
			
			Assert.assertTrue(false);
		}
		
	}
}
