package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateCampaign {

	
	public ValidateCampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String campValidate(WebDriver driver)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
//		if (actData.contains(CampName)) {
//			System.out.println("Campaign name is created");
//		} else {
//			System.out.println("Campaign name is not created");
//		}
		return actData;
		
	}
}
