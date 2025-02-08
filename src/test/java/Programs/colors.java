package Programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class colors {

	public static void main(String[] args)
	{
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("[id='twotabsearchtextbox']")).sendKeys("iphone",Keys.ENTER);
		
	//	List<WebElement> allColors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']/../../../..//div[@class='a-section s-color-swatch-container s-quick-view-text-align-start']//a"));
		
		 List<WebElement> allcolors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Blue']/../../../..//div[@class='a-section s-color-swatch-container s-quick-view-text-align-start']//a"));
		
		for ( WebElement color : allcolors)
		{
			String values = color.getAttribute("aria-label");
			System.out.println(values);
		}
	}

}
