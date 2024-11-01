package WebElement;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_cart extends BasePage {
	public Add_cart(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement setclkfilter;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addcard;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement shapping;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkout;
	
	@FindBy(xpath="//input[@id='first-name']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement postal_code;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continue_click;
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement Finish;
	
	@FindBy(xpath="//h2[normalize-space()='Thank you for your order!']")
	WebElement conformtxt;
	
	@FindBy(xpath="//button[@id='back-to-products']")
	WebElement GoToHome;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement clickMenu;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logout;
	
	
	public void getclkfilter() {
	   setclkfilter.click();
	   WebElement dropdown = driver.findElement(By.className("product_sort_container"));
	    
	    // Scroll into view if necessary
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
	    dropdown.click();

	    // Explicitly wait for the dropdown option to become visible and clickable
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Name (Z to A)']")));

	    // Use JavaScript click if direct click doesn't work
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
	} 
	public void getaddcard() {
		addcard.click();
	}
	public void getshapping() {
		shapping.click();
	}
	public void getcheckout() {
		checkout.click();	
	}
	public void getFirstName(String name) {
		Firstname.sendKeys(name);
	}
	public void getLastName(String lastname) {
		LastName.sendKeys(lastname);
	}
	public void getpostalcode(String code) {
		postal_code.sendKeys(code);
	}
	public void getcontinue() {
		continue_click.click();
	}
	
	public void getFinish() {
		Finish.click();
	}
	public String getcomformMessage() {
		return(conformtxt.getText());
	}
	public void getgotohome() {
		GoToHome.click();
	}
	public void getClickMenuBar() {
		clickMenu.click();
	   
	}
	public void getlogout() {
		logout.click();
	}

}	
	
		 


