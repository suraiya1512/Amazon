package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.OrdersPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC009_CancelOrderTest extends BaseClass
{

	@Test
	public void Verify_CancelOrder()
	{
		
		HomePage hp = new HomePage(driver);
		hp.AccountList();
		
		//SignIn page
		SignInPage sip = new SignInPage(driver);
		sip.SignIn(p.getProperty("mobile"));
		sip.ClickContinue();
		
		sip.SignInPWD(p.getProperty("password"));
		sip.ClickSignIn();
		logger.info("**TC009_OrderCancellation Started*");
		try
		{
		OrdersPage op = new OrdersPage(driver);
		op.orders();
		op.ViewOrEditorders();
		op.cancelOrder();
		op.selectreason("Order Created by Mistake");
		op.cancelItem();
		
		Assert.assertTrue(op.CancelledMsg(), " Confirmation Message received for Cancellation");
	}
	catch(Exception e)
	{
		Assert.fail("Test Failed Due to : "+ e.getMessage());
		
	}
	logger.info("**TC009_OrderCancellation Completed ***");
}
}