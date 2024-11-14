package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage
{

	public SignInPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement txtSignIn;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement btnSignIn;
	
	public void SignIn(String mobile)
	{
		txtSignIn.sendKeys(mobile);
	}
	
	public void ClickContinue()
	{
		btnContinue.click();
	}
	
	public void SignInPWD(String password)
	{
		txtpwd.sendKeys(password);
	}
	
	public void ClickSignIn()
	{
		btnSignIn.click();
	}

	}