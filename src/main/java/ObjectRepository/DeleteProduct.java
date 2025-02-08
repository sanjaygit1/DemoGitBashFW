package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct {

	
	public DeleteProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value=\"Delete\"]")
	private WebElement selectDelete;
	
	
	public void selectPrd(WebDriver driver,String PrdName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	public void clickDeleteButton()
	{
		selectDelete.click();
	}
	
	public void validatePrdDeleted(WebDriver driver,String PrdName)
	{
		List<WebElement> prdList = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));

		boolean flag = false;

		for (WebElement prdName : prdList) {
			String actPrd = prdName.getText();
			if (actPrd.contains(PrdName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Product is deleted");
		}

		else {
			System.out.println("Product is not deleted");
		}
	}
}
