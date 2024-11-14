package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement msgHeading;
	
	@FindBy(xpath="//span[normalize-space()='Sign Out']")
	WebElement linkSignOut;
	
	
	public String MyAccTitle = driver.getTitle();
	
	public void clickSignOut()
	{
		linkSignOut.click();
	}
	
}