package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC005_ShoppingCartTest extends BaseClass
{

@Test
public void shoppingCart() throws InterruptedException
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
	sp.selectQuantity("2");
	Thread.sleep(3000);
    sp.addToCart();
	
    logger.info("**TC005_ShoppingCartTest Started ***");
	CartPage cp = new CartPage(driver);
	cp.goToCart();
		
	String totprice=cp.amt();
	System.out.println("total price is shopping cart: "+totprice);
	SoftAssert myassert=new SoftAssert();
	myassert.assertEquals(totprice, "₹2,538.00");
	Thread.sleep(3000);
	cp.ProceedToBuy();
	
	Assert.assertTrue(cp.CheckOutConfirm(), "Confirmation message is not displayed.");
	}
	catch (Exception e) {
        Assert.fail("Test failed due to: " + e.getMessage());
	}
	logger.info("**TC005_ShoppingCartTest Completed ***");
}
}