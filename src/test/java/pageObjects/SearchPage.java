package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[@class='a-size-base-plus a-color-base a-text-normal']")
	List<WebElement> searchProducts; 
	
    //@FindBy(xpath="//div//span[@class='a-size-medium a-color-success']")
    //WebElement stock;
	
	@FindBy(xpath="//select[@id='quantity']")
	WebElement drpdownqty ;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement btncart;
	
	@FindBy(xpath="//div//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	WebElement cnfMsg;
	
	public boolean isProductExist(String productName) {
        boolean flag = false;
        for (WebElement product : searchProducts) {
            String productText = product.getText();
            if (productText != null && productText.trim().equalsIgnoreCase(productName)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void selectProduct(String productName) {
        // Store the current window handle
        String currentWindowHandle = driver.getWindowHandle();

        // Click on the product to open the new window
        for (WebElement product : searchProducts) {
            String productText = product.getText();
            if (productText.trim().equalsIgnoreCase(productName)) {
                product.click();
                break;
            }
        }

        // Wait for the new window to open
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void selectQuantity(String quantity) {
        Select select = new Select(drpdownqty);
        select.selectByValue(quantity);  
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.RETURN).perform();
        
    }

    public void addToCart() {
        btncart.click();
    }

    public boolean checkConfMsg() {
        try {
            return cnfMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void switchToOriginalWindow(String originalWindowHandle) {
        // Switch back to the original window if needed
        driver.switchTo().window(originalWindowHandle);
    }
}