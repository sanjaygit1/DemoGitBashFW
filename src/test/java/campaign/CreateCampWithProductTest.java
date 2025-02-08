package campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.testng.annotations.Test;

import Generic_utilties.BaseClass;
import Generic_utilties.Excel_Utility;
import Generic_utilties.File_Utility;
import Generic_utilties.Java_Utility;
import Generic_utilties.WebDriver_Utility;
import ObjectRepository.CampLookUpPage;
import ObjectRepository.CreateCampPage;

import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.PrdLookUpImg;
import ObjectRepository.PrdValidateUsingCamp;
import ObjectRepository.SwitchingWindow;
import ObjectRepository.ValidateCampaign;

public class CreateCampWithProductTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createCampWithProductTest() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		PrdLookUpImg lookUp = new PrdLookUpImg(driver);
		lookUp.clickPrdLooUp();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();
//-------------------------------------------------------------------------------------------------------------

		home.clickMoreLink();
		home.clickCampLink();

		CampLookUpPage lookUpPage = new CampLookUpPage(driver);
		lookUpPage.clickLookUpImg();

		String CampName = elib.getExcelData("Campaigns", 0, 0) + ranNum;

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampDetails(CampName);

		SwitchingWindow windowSwitch = new SwitchingWindow(driver);
		windowSwitch.clickPrdPlus();
		wlib.windowSwitching(driver, "Products&action");
		Thread.sleep(1000);
		windowSwitch.enterPrdName(PrdName);
		windowSwitch.searchPrdName();
		windowSwitch.dynamicPath(driver, PrdName);

		wlib.windowSwitching(driver, "Campaigns&action");

		campPage.clickSaveButton();

		ValidateCampaign validateCamp = new ValidateCampaign(driver);
		String actData = validateCamp.campValidate(driver);
		Assert.assertEquals(actData, CampName);
		System.out.println("Camp is validated");

		PrdValidateUsingCamp prdValidate = new PrdValidateUsingCamp(driver);
		prdValidate.validatePrd(driver, PrdName);

	}

}
