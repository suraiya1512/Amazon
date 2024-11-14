package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
//import pageObjects.OrdersPage;
import pageObjects.PaymentPage;
import pageObjects.SearchPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC0010_EndT0EndTest extends BaseClass
{
@Test
public void verify_EndToEnd() throws InterruptedException
{
	try
	{
	//Login
		logger.info("**TC0010_EndToEnd Test Started ***");
	HomePage hp = new HomePage(driver);
	hp.AccountList();
	
	SignInPage sip = new SignInPage(driver);
	sip.SignIn(p.getProperty("mobile"));
	sip.ClickContinue();
	
	sip.SignInPWD(p.getProperty("password"));
	sip.ClickSignIn();
	
	//SearchingProduct
	hp.enterProductName("handbag");
	hp.clickSearch();
	
	//Adding Product
	SearchPage sp =new SearchPage(driver);
	sp.selectProduct("Women Hand/Sling bag");
	sp.selectQuantity("2");
	Thread.sleep(3000);
    sp.addToCart();
    
    //Checking Price
    CartPage cp = new CartPage(driver);
    cp.goToCart();
	
	String totprice=cp.amt();
	SoftAssert myassert=new SoftAssert();
	myassert.assertEquals(totprice, "₹2,538.00");
	Thread.sleep(3000);
	cp.ProceedToBuy();
	Thread.sleep(3000);
	cp.NewAddress();
	
	//Checking the Product
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

	//Paymenet Process
    PaymentPage pp = new PaymentPage(driver);
	pp.PayMethod();
	
	Thread.sleep(10000);
    Assert.assertTrue(pp.ArrivalDetails(), " Arival Confirmation is not Displayed " );    
	}
	catch(Exception e)
	{
		Assert.fail("Test failed due to: " + e.getMessage());
	}
	logger.info("**TC0010_EndToEnd Test Completed ***");
    
	/*//Placing Order
	pp.PlaceOrder();
	
    //Cancelling Order
	hp.AccountList();
	OrdersPage op = new OrdersPage(driver);
	op.orders();
	op.ViewOrEditorders();
	op.cancelOrder();
	op.selectreason("Order Created by Mistake");
	op.cancelItem();*/
	
}
}
