package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PrdValidateUsingCamp {

	
	public PrdValidateUsingCamp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validatePrd(WebDriver driver, String PrdName )
	{
		String actPrdName = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
		if (actPrdName.contains(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product Name is not created");
		}
	}
}
