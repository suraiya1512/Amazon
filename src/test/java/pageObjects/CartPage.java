package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage
{

	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//a[@href='/cart?ref_=sw_gtc']")
	WebElement btncart;
	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	public WebElement btnproceed;
	
	@FindBy(xpath="//span[@id='sc-subtotal-amount-buybox']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	WebElement price;
	
	@FindBy(xpath="//h1[normalize-space()='Checkout']")
	WebElement CnfMsgCheckOut;
	
	@FindBy(xpath="//a[@id='add-new-address-popover-link']")
	WebElement newAdd;
	
	public void goToCart()
	{
		btncart.click();
	}

		public void ProceedToBuy()
	{
		btnproceed.click();
	}
	
	public String amt()
	{
		return price.getText();
	}

	public void NewAddress()
	{
		newAdd.click();
	}
	public boolean CheckOutConfirm()
	{
		return CnfMsgCheckOut.isDisplayed();
	}
}

/*public boolean checkConfMsg() {
    try {
        return cnfMsg.isDisplayed();
    } catch (Exception e) {
        return false;
    }
}*/