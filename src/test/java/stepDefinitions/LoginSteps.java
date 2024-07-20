package stepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	
	List<HashMap<String, String>> dataMap;
	
	@Given("the user navigates to the login page")
	public void the_user_navigates_to_the_login_page() {
	    
		BaseClass.getLogger().info("Goto my account-->Click on Login..");
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogin();
		
	}

	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row(String rows) {
	    
		try {
			
			dataMap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_TestData1.xlsx", "Sheet1");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		 
		int index = Integer.parseInt(rows)-1;
		String email = dataMap.get(index).get("username");
		String pass = dataMap.get(index).get("password");
		String exp_res = dataMap.get(index).get("res");
		
		lp = new LoginPage(BaseClass.getDriver());
		
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		lp.setEmail(email);
		lp.setPassword(pass);
		lp.clickLogin();
		
		macc=new MyAccountPage(BaseClass.getDriver());
		try {
			
			boolean targetpage = macc.isMyAccountPageExists();
			
			if(exp_res.equalsIgnoreCase("valid")) {
				
				if(targetpage==true) {
					
					MyAccountPage myaccpage = new MyAccountPage(BaseClass.getDriver());
					myaccpage.clickLogout();
					Assert.assertTrue(true);
				}
				
				else {
					
					Assert.assertTrue(false);
				}
			}
			
			if(exp_res.equalsIgnoreCase("invalid")) {
				
				if(targetpage==true) {
					
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				
				else {
					
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
	}
	
}
