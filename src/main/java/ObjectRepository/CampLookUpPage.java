package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUpPage {
 
	public CampLookUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
	private WebElement lookUpImg;

	public WebElement getLookUpImg() {
		return lookUpImg;
	}
	
	public void clickLookUpImg()
	{
		lookUpImg.click();
	}
	
}
