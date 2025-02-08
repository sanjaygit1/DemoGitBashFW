package pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertMultipleDataIntoExcel {

	public static void main(String[] args) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet1");
		 WebDriver driver=new ChromeDriver();

		 driver.get("https://www.flipkart.com");
		 driver.manage().window().maximize();
		 
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	
	for (int i = 0; i < allLinks.size(); i++)
	{
		Row row = sheet.createRow(i);
		Cell cel = row.createCell(0);
		cel.setCellValue(allLinks.get(i).getAttribute("href"));
	}
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/ExcelTestData7pm.xlsx");
	book.write(fos);
	book.close();
	
	}

}
