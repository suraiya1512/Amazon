package pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement accountList ;
	
	@FindBy(xpath="//a[@id='createAccountSubmit']")
	WebElement createAccount ; 
	
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement linkSignIn;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement txtSearchbox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement btnSearch;
	public void AccountList()
	{
		accountList.click();
	}	
	
	public void CreateAccount()
	{
		createAccount.click();
	}
	
	public void ClickSignIn()
	{
		linkSignIn.click();
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}

	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}


}