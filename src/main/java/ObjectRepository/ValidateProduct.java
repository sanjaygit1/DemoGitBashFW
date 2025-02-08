package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateProduct {

	public ValidateProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void prdValidate(WebDriver driver,String PrdName )
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.contains(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product Name is Not Created");
		}
	}
}
