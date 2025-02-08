package pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelData {

	public static void main(String[] args) throws Throwable {

		// step1:-* path connection
	//	FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Documents\\ExcelTestData7pm.xlsx");

		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");
		
		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigates the particular sheet
		Sheet sheet = book.getSheet("Sheet1");
		

		// step4:- Navigates the particular row
		Row row = sheet.getRow(4);

        //step5:- Navigates the particular cell
		Cell cell = row.getCell(4);

		String excelData = cell.getStringCellValue();
		System.out.println(excelData);
	}

}
