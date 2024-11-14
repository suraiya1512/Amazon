package testCase;

//import java.time.Duration;

//import org.openqa.selenium.Alert;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC006_CheckOutTest extends BaseClass
{
@Test
public void Verify_CheckOut() throws InterruptedException
{
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	try
	{
	HomePage hp=new HomePage(driver);
	hp.AccountList();
	
	
	SignInPage sip = new SignInPage(driver);
	sip.SignIn(p.getProperty("mobile"));
	sip.ClickContinue();
	
	sip.SignInPWD(p.getProperty("password"));
	sip.ClickSignIn();
	
	/*hp.AccountList();
	hp.YourAccount();
	
	hp.YourAdd();
	hp.RemoveAdd();
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.accept();  // Accept the alert
	hp.ClickYes();*/
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
	Thread.sleep(3000);
	cp.NewAddress();

	logger.info("**TC006_CheckOutTest Started ***"); 
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
    
    Assert.assertTrue(cop.addConfMsg(), " Address Confirmation is not Displayed " );
	}
	catch(Exception e)
	{
		Assert.fail("Test failed due to: " + e.getMessage());
	}
	logger.info("**TC006_CheckOutTest Completed ***");  

}
	
}