package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_utilties.BaseClass;
import Generic_utilties.Excel_Utility;
import Generic_utilties.File_Utility;
import Generic_utilties.Java_Utility;
import Generic_utilties.WebDriver_Utility;
import ObjectRepository.CreateOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgLookUpImgPage;
import ObjectRepository.ValidateOrgPage;

public class CreateOrganizationTest extends BaseClass {
//Gud evng
	//Hi im FrameWork
	@Test(groups = {"regressionTest","smokeTest"})
	public void CreateOrganizationTest() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();

		HomePage home = new HomePage(driver);
		home.clickOrgLink();

		OrgLookUpImgPage img = new OrgLookUpImgPage(driver);
		img.clickOrgLookUp();

		int ranNum = jlib.getRandomNum();

		String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		String phnNum = elib.readExcelDataUsingFormatter("Organization", 1, 0);
		String email = elib.readExcelDataUsingFormatter("Organization", 2, 0);

		CreateOrgPage page = new CreateOrgPage(driver);
		page.enterOrgDetails(OrgName, phnNum, email);
		page.clickSaveButton();

		ValidateOrgPage validate = new ValidateOrgPage(driver);
		validate.validateOrgDetails(driver, OrgName);

	}
	
//	@Test
	public void m2()
	{
		System.out.println("I am method2");
	}

}
