package pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMutipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
	FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");
		
		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigates the particular sheet
		Sheet sheet = book.getSheet("Sheet1");

		int rowNum = sheet.getLastRowNum()+1;
		System.out.println(rowNum);
		
		for (int i = 0; i < rowNum; i++)
		{
			Row row = sheet.getRow(i);
			Cell cel = row.getCell(0);
			String link = cel.getStringCellValue();
			System.out.println(link);
		}
	}

}
