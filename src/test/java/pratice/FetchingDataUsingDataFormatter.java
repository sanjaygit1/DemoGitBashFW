package pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataUsingDataFormatter {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigates the particular sheet
		Sheet sheet = book.getSheet("Sheet2");

		// step4:- Navigates the particular row
		Row row = sheet.getRow(0);

		// step5:- Navigates the particular cell
		Cell cell = row.getCell(0);

//		String excelData = cell.getStringCellValue();
//		System.out.println(excelData);

		DataFormatter format = new DataFormatter();
		String excelData = format.formatCellValue(cell);
		System.out.println(excelData);

	}

	
}
