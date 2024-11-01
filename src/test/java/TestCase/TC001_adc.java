package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import WebElement.Add_cart;

public class TC001_adc extends head_page{
	
	@Test
	public void ad_card() {
		Add_cart ADC=new Add_cart(driver);
		ADC.getclkfilter();
		ADC.getaddcard();
		ADC.getshapping();
		ADC.getcheckout();
		ADC.getFirstName(randomchar().toUpperCase());
		ADC.getLastName(randomchar().toUpperCase());
		ADC.getpostalcode(randomnumber());
		ADC.getcontinue();
		ADC.getFinish();
		
		String conformMessage=ADC.getcomformMessage();
		if(conformMessage.equals("Thank you for your order!")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		 ADC.getgotohome();
		 ADC.getClickMenuBar();
		 ADC.getlogout();
		 
		
	}

}
