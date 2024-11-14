package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

	public PaymentPage(WebDriver driver)
	{
		super(driver);
		
	}

	@FindBy(xpath="//input[@id='pp-tcIjds-145']")
	WebElement cod;
	
	@FindBy(xpath="//span[@class='a-button-inner']//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")
	WebElement btnPayMethod;
	
	@FindBy(xpath="//span[contains(text(),'Arriving 19 Nov 2024')]")
	WebElement arrivalMsg;
	
	@FindBy(xpath="//input[@aria-labelledby='bottomSubmitOrderButtonId-announce']")
	WebElement btnPlaceOrder;
	
	@FindBy(xpath="//h4[@class='a-alert-heading']")
	public WebElement OrderConMsg;
	
	public void cashonD()
	{
		cod.click();
	}
	
	public void PayMethod()
	{
		btnPayMethod.click();
	}
	
	public boolean ArrivalDetails()
	{
		return arrivalMsg.isDisplayed();
	}
	public void PlaceOrder()
	{
		btnPlaceOrder.click();
	}
	
	public boolean OrderConfm()
	{
		return OrderConMsg.isDisplayed();
	}
}