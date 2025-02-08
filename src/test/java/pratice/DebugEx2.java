package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.methods;

public class DebugEx2 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		methods ele = new methods();
		ele.maximizeWindow(driver);
		
		driver.get("https://www.flipkart.com");
		
		driver.findElement(By.name("q")).sendKeys("Puma");
	}

}
