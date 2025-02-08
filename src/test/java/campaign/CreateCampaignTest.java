package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utilties.BaseClass;
import Generic_utilties.Excel_Utility;
import Generic_utilties.File_Utility;
import Generic_utilties.Java_Utility;
import Generic_utilties.WebDriver_Utility;
import ObjectRepository.CampLookUpPage;
import ObjectRepository.CreateCampPage;
import ObjectRepository.CreateOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgLookUpImgPage;
import ObjectRepository.ValidateCampaign;
import ObjectRepository.ValidateOrgPage;

//@Listeners(Generic_utilties.ExtentReportImp.class)
public class CreateCampaignTest extends BaseClass {

	//@Test(retryAnalyzer = Generic_utilties.RetryImp.class)
	@Test
	public void createCampaignTest() throws Throwable {

		HomePage home = new HomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		CampLookUpPage img = new CampLookUpPage(driver);
		img.clickLookUpImg();
	
//		Assert.fail("i am failing the test script");
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String CampName = elib.getExcelData("Campaigns", 0, 0) + ranNum;

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampDetails(CampName);
		campPage.clickSaveButton();

		ValidateCampaign validate = new ValidateCampaign(driver);
		String actData = validate.campValidate(driver);
		Assert.assertEquals(actData, CampName);
		System.out.println("Camp is validated");

	}
}
