package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC002_SignInTest extends BaseClass{
	
	@Test
	public void Verify_SignIn()
	{
	
	logger.info("**** Starting TC002_SignInTest ****");
	logger.debug("capturing application debug logs....");
	
	//Home Page
	HomePage hp = new HomePage(driver);
	hp.AccountList();
	
	//SignIn page
	SignInPage sip = new SignInPage(driver);
	sip.SignIn(p.getProperty("mobile"));
	sip.ClickContinue();
	
	sip.SignInPWD(p.getProperty("password"));
	sip.ClickSignIn();
	
	MyAccountPage macp = new MyAccountPage(driver);

	Assert.assertEquals(driver.getTitle(),macp.MyAccTitle);
	logger.info("**** Finished TC002_SignInTest  ****");
	}

}