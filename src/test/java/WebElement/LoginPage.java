package WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement click;
	
	public void getusername(String Username) {
		username.sendKeys(Username);
	}
	
	public void getpassword(String Pwd) {
		Password.sendKeys(Pwd);
	}
	public void getclick() {
		click.click();
	}



}
