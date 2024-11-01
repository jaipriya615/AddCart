package TestCase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import WebElement.LoginPage;

public class head_page {
WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","os"})
	public void setup(String br,String os) {
	
		switch(br.toLowerCase()) {
		case "chrome" :
			driver=new ChromeDriver();
			break;
		case "edge" :
			driver=new EdgeDriver();
			break;
		default:
			System.out.println("not support browser");
			return;
		}
		
		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		LoginPage LP=new LoginPage(driver);
		LP.getusername("standard_user");
		LP.getpassword("secret_sauce");
		LP.getclick(); 

	}	
	
	@AfterClass
	public void close() {
		driver.close();
		
	}
	public String randomchar() {
		String random=RandomStringUtils.randomAlphabetic(6);
		return random;
	}
	public String randomnumber() {
		String randomnum=RandomStringUtils.randomNumeric(5);
		return randomnum;
	}
    public String ScreenShot(String fname) {
    	
    	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	
    	TakesScreenshot tacksScreenshot = (TakesScreenshot) driver;
    	File soure = tacksScreenshot.getScreenshotAs(OutputType.FILE);
    	
    	String targetfilepath=System.getProperty("user.dir")+"\\Screenshorts\\" +fname+ "_"+ timeStamp +".png";
    	File targetFile=new File(targetfilepath);
    	
    	soure.renameTo(targetFile);
    	return targetfilepath;
    	
    	
    	
    }
	

}
