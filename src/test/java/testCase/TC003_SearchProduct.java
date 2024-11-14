package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC003_SearchProduct extends BaseClass
{
    @Test
	public void verify_ProductSearch()
  {
    	logger.info(" ******Starting TC_004_SearchProductTest****** ");
    	try
    	{
    		
       	HomePage hp=new HomePage(driver);
    	hp.enterProductName("handbag");
    	hp.clickSearch();
    	
    	SearchPage sp =new SearchPage(driver);
    		sp.isProductExist("Women Hand/Sling bag"); 	
            boolean isProductFound = sp.isProductExist("Women Hand/Sling bag");  // Check if the product exists
            Assert.assertTrue(isProductFound, "Product 'Women Hand/Sling bag' not found in search results.");

        } catch (Exception e)
    	{
            // If any error occurs, fail the test
            logger.error("Test failed due to: " + e.getMessage());
            Assert.fail();
        }
        logger.info(" Finished TC_004_SearchProductTest ");
        
  }
}