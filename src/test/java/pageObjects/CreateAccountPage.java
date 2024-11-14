package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
			}

	@FindBy(xpath="//input[@id='ap_customer_name']")
	WebElement txtYourName;
	
	@FindBy(xpath="//input[@id='ap_phone_number']")
	WebElement txtMobileNo;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement btnVerifyMobileNo;
	
	@FindBy(xpath="//span[normalize-space()='Sign Out']")
	WebElement linkSignOut;
	
	
	
	public void setYourName(String name)
	{
		txtYourName.sendKeys(name);
	}
	
	public void setMobileNo(String mobile)
	{
		txtMobileNo.sendKeys(mobile);
	}
	
	public void setPassword(String password)
	{
		txtpassword.sendKeys(password);	
	}
	
	public void clickVerifyMobileNo()
	{
		btnVerifyMobileNo.click();	
	}

	public void clickSignOut()
	{
		linkSignOut.click();	
	}
	
	
}