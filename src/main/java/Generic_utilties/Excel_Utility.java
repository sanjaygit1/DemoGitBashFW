package Generic_utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;

public class Excel_Utility {

	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
	//	FileInputStream fis1 = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");
		FileInputStream fis1 = new FileInputStream(IpathConstant.excelPath);
		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigates the particular sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- Navigates the particular row
		Row row = sheet.getRow(rowNum);

		// step5:- Navigates the particular cell
		Cell cell = row.getCell(cellNum);

		String excelData = cell.getStringCellValue();
		System.out.println(excelData);
		return excelData;
	}

	public String readExcelDataUsingFormatter(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis1 = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigates the particular sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- Navigates the particular row
		Row row = sheet.getRow(rowNum);

		// step5:- Navigates the particular cell
		Cell cell = row.getCell(cellNum);

		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		
		System.out.println(ExcelData);

		return ExcelData;
	}
	
	public Object[][] getDataProviderData(String sheetName) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigates the particular sheet
		Sheet sheet = book.getSheet(sheetName);
	
		int LastRow = sheet.getLastRowNum()+1;
		int LastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[LastRow][LastCell];
	
		for (int i = 0; i < LastRow; i++)
		{
		for (int j = 0; j <LastCell; j++)
		{
			obj[i][j]=sheet.getRow(i).getCell(j).toString();
		}	
		}
		
		return obj;
	}
}
