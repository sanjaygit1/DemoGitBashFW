package pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {
//Inserting data into properties file
		Properties pro = new Properties();
		pro.setProperty("browser", "edge");
		pro.setProperty("url", "http://localhost:8888");
		pro.setProperty("username", "admin");
		pro.setProperty("password", "admin");

		// Write mode
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Shobha\\Downloads\\File.properties");
		pro.store(fos, "CommonData");
		//------------------------------------------------------------------------------------------------
//Fetch data from Properties File
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\File.properties");

		// step2:- load all the keys
		Properties pro1 = new Properties();

		pro1.load(fis);
		String BROWSER = pro1.getProperty("browser");
		String URL = pro1.getProperty("url");
		String USERNAME = pro1.getProperty("username");
		String PASSWORD = pro1.getProperty("password");

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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

	}

}
