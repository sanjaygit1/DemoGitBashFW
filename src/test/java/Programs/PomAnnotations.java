package Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.PomEx;

public class PomAnnotations {

	public static void main(String[] args) {

WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com");

PomEx page = new PomEx(driver);
//page.getSearchIcon().sendKeys("puma");
//page.getSearchIcon();

page.enterValue("Nike");
page.clickSearchIcon();
	
	
	}

}
