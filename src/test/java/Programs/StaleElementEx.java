package Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utilties.Excel_Utility;
import Generic_utilties.File_Utility;
import Generic_utilties.WebDriver_Utility;

public class StaleElementEx {

	public static void main(String[] args) throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();

		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		WebElement login = driver.findElement(By.id("submitButton"));
		driver.navigate().refresh();
		login.click();
	}

}
