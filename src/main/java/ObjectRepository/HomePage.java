package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Products")
	private WebElement prdLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	//getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}
	
	//business logics
	public void clickMoreLink()
	{
		moreLink.click();
	}
	
	public void clickCampLink()
	{
		campLink.click();
	}
	
	public void clickOrgLink()
	{
		orgLink.click();
	}
	
	public void clickPrdLink()
	{
		prdLink.click();
	}
	
	public void logOut()
	
	{
		adminLink.click();
		signOutLink.click();
	}
}
