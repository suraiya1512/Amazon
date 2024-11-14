package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;
import pageObjects.SearchPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC008_PlaceOrderTest extends BaseClass
{
@Test
public void Verify_PlaceOrder()
{
	
	try
	{
	HomePage hp=new HomePage(driver);
	hp.AccountList();
	
	
	SignInPage sip = new SignInPage(driver);
	sip.SignIn(p.getProperty("mobile"));
	sip.ClickContinue();
	
	sip.SignInPWD(p.getProperty("password"));
	sip.ClickSignIn();
	
	hp.enterProductName("handbag");
	hp.clickSearch();
	
	SearchPage sp =new SearchPage(driver);
	sp.selectProduct("Women Hand/Sling bag");
	Thread.sleep(3000);
	sp.selectQuantity("2");
	Thread.sleep(3000);
    sp.addToCart();
	
	
	CartPage cp = new CartPage(driver);
	cp.goToCart();
	cp.ProceedToBuy();
	cp.NewAddress();
	CheckOutPage cop = new CheckOutPage(driver);
	cop.fullName(p.getProperty("name"));
	cop.mobile(p.getProperty("mobile"));
	cop.pincode(p.getProperty("pincode"));
	Thread.sleep(3000);
	cop.streetname(p.getProperty("street"));
	Thread.sleep(3000);
	cop.areaname(p.getProperty("area"));
	Thread.sleep(3000);
	cop.landmark(p.getProperty("landMark"));
	Thread.sleep(3000);
	cop.cityname(p.getProperty("city"));
	Thread.sleep(3000);
    cop.selectstate("TAMIL NADU");
    Thread.sleep(3000);
    cop.AddNewAddress();
    
    logger.info("**TC008_PlaceOrderTest Started ***"); 
	PaymentPage pp = new PaymentPage(driver);
	pp.PayMethod();
	logger.info("Placing order...");
	pp.PlaceOrder(); 
	logger.info("Placing order  clicked...");
	 Thread.sleep(5000);
	 System.out.println(pp.OrderConMsg);
	 logger.info(pp.OrderConMsg);
	 
	    Assert.assertTrue(pp.OrderConfm(), " Order Confirmation is not Displayed " );    
		}
		catch(Exception e)
		{
			Assert.fail("Test failed due to: " + e.getMessage());
		}
		logger.info("**TC008_PlaceOrderTest Completed ***"); 
	
}
}