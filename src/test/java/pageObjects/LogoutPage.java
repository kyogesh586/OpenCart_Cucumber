package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
	WebElement btnLogout;
	
	@FindBy(xpath = "//*[@id=\"content\"]/p[1]")
	WebElement txtLogoutSuccessfully;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
	WebElement btnContinue;
	
	public void clickLogout() {
		
		btnLogout.click();
	}
	
	public String getTextLogoutSuccessfully() {
		
		return txtLogoutSuccessfully.getText();
	} 
	
	public boolean isBtnContinueDisplay() {
		
		return btnContinue.isDisplayed();
	}
	
	public void clickBtnContinue() {
		
		btnContinue.click();
	}
}
