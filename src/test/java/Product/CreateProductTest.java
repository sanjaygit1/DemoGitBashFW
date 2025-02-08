package Product;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utilties.BaseClass;
import Generic_utilties.Excel_Utility;
import Generic_utilties.File_Utility;
import Generic_utilties.Java_Utility;
import Generic_utilties.WebDriver_Utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.PrdLookUpImg;
import ObjectRepository.PrdValidateUsingCamp;
import ObjectRepository.ValidateProduct;

@Listeners(Generic_utilties.Listeners.class)
public class CreateProductTest extends BaseClass {

	@Test(retryAnalyzer = Generic_utilties.RetryImp.class)
	public void CreateProductTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();

		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		PrdLookUpImg lookUp = new PrdLookUpImg(driver);
		lookUp.clickPrdLooUp();
		int ranNum = jlib.getRandomNum();

		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
//Assert.fail();		
		prdPage.clickSaveButton();

		ValidateProduct validate = new ValidateProduct(driver);
		validate.prdValidate(driver, PrdName);

	}

}
