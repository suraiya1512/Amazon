package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage extends BasePage {

	public OrdersPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='& Orders']")
	WebElement orders;
	
	@FindBy(xpath="//a[@id='View-or-edit-order_2']")
	WebElement viewOrEdit;
	
	@FindBy(xpath="//a[@id='Cancel-items_1']")
	WebElement cancel;
	
	@FindBy(xpath="//select[@name='cancel.reason']")
	WebElement drpreason;
	
	@FindBy(xpath="//input[@name='cq.submit']")
	WebElement cancelitem;
	
	@FindBy(xpath="//span[@class='a-size-medium a-text-bold']")
	WebElement ConfMsg;
	
	public void orders()
	{
		orders.click();
	}
	
	public void ViewOrEditorders()
	{
		viewOrEdit.click();
	}
	
	public void cancelOrder()
	{
		cancel.click();
	}

	public void selectreason(String reason) {
        Select select = new Select(drpreason);
        select.selectByValue(reason);  
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.RETURN).perform();
        
    }
	public void cancelItem()
	{
		cancelitem.click();
	}
	
	public boolean CancelledMsg()
	{
		return ConfMsg.isDisplayed();
	}
}
