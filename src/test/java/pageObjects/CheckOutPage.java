package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage
{

	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressFullName']")
	WebElement txtFName;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	WebElement txtmobileno;
	
	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")
	WebElement txtPincode;

	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']")
	WebElement txtStreet;

	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']")
	WebElement txtArea;

	@FindBy(xpath="//input[@id='address-ui-widgets-landmark']")
	WebElement txtLandmark;

	@FindBy(xpath="//input[@id='address-ui-widgets-enterAddressCity']")
	WebElement txtCity ;

	@FindBy(xpath="//select[@name='address-ui-widgets-enterAddressStateOrRegion']")
	WebElement drpState;

	@FindBy(xpath="//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
	WebElement btbUseAdd;
	
	@FindBy(xpath="//*//ul[@class='displayAddressUL']")
	WebElement addConf;
	
	@FindBy(xpath="//a[@id='add-new-address-popover-link']")
	WebElement newAdd;
	
	@FindBy(xpath="//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
	WebElement addNewAdd;

	public void fullName(String name)
	{
		txtFName.sendKeys(name);
	}
	
	public void mobile(String no)
	{
		txtmobileno.sendKeys(no);
	}
	
	public void pincode(String pin)
	{
		txtPincode.sendKeys(pin);
	}
	
	public void streetname(String street)
	{
		txtStreet.sendKeys(street);
	}
	
	public void areaname(String area)
	{
		txtArea.sendKeys(area);
	}
	
	public void landmark(String lm)
	{
		txtLandmark.sendKeys(lm);
	}
	
	public void cityname(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void selectstate(String state) {
        Select select = new Select(drpState);
        select.selectByValue(state);  
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.RETURN).perform();
    }
		
	public void UseAddress()
	{
		newAdd.click();
	}
	
	public void NewAddress()
	{
		btbUseAdd.click();
	}
	
	public void AddNewAddress()
	{
		addNewAdd.click();
	}
	
	public boolean addConfMsg()
	{
		return addConf.isDisplayed();
	}
}