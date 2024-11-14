package testCase;

import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_CreateAccount extends BaseClass
{
	
	@Test
	public void account_registration ()
	{
	logger.info("**** starting TC001_AccountCreationTest  *****"); 
	HomePage hp = new HomePage(driver);
	
	  hp.AccountList();
	  hp.CreateAccount();
	  
	  CreateAccountPage cap = new CreateAccountPage(driver);
	 cap.setYourName(p.getProperty("name"));
	  cap.setMobileNo(p.getProperty("mobile"));
	  cap.setPassword(p.getProperty("password"));
	  cap.clickVerifyMobileNo();
	
	  
	  hp.AccountList();
	  cap.clickSignOut();
	  logger.info("**** TC001_AccountCreationTest Completed *****");
	}
}