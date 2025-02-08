package Generic_utilties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void BS() {
		System.out.println("DataBase Connection");
	}

	@BeforeTest(groups = { "smokeTest", "regressionTest" })
	public void BT() {
		System.out.println("Parallel Execution start");
	}

//	@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
//	public void BC(String BROWSER)
//	{
	public void BC() throws Throwable {
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		sdriver = driver;
		System.out.println("Launch the Browser");
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void BM() throws Throwable {
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);

		driver.get(URL);

		// Business Logics
		LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login into App");
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void AM() {
		HomePage home = new HomePage(driver);
		home.logOut();
		System.out.println("Logout from APp");
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void AC() {
		driver.quit();
		System.out.println("CLose the Browser");
	}

	@AfterTest(groups = { "smokeTest", "regressionTest" })
	public void AT() {
		System.out.println("Parallel Execution close");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void AS() {
		System.out.println("DataBase connection close");
	}
}
