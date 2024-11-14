package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_AddToCartTest extends BaseClass
{
	@Test
 public void addToCart()
 {
		logger.info(" Starting TC004_AddToCartPageTest ");
	try
	{
	HomePage hp=new HomePage(driver);
    hp.enterProductName("handbag");
    hp.clickSearch();
    
    SearchPage sp =new SearchPage(driver);
    if(sp.isProductExist("Women Hand/Sling bag"))
    {
        System.out.println("Product 'Women Hand/Sling bag' found in search results");

    	sp.selectProduct("Women Hand/Sling bag");
  
		sp.selectQuantity("2");
		Thread.sleep(3000);
	    sp.addToCart();
    }
    else
    {
        System.out.println("Product not found in search results");
    }
    Assert.assertTrue(sp.checkConfMsg(), "Confirmation message is not displayed.");
    
	} 
	catch (Exception e) {
        Assert.fail("Test failed due to: " + e.getMessage());
	}

	logger.info("**TC004_AddToCartPageTest Completed ***");

}
}