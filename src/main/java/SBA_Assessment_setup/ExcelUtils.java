package SBA_Assessment_setup;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelUtils 
{
//	@DataProvider(name="customerValid")
	@Test
	public static Object[][] readExcelData(String sheetname) throws Exception
	{
		    //Parse data from Shipmentdetails.xlsx and return the 2-dimensional array
		          String path = System.getProperty("user.dir")+"/Excel.xlsx";
	                File filePath = new File(path);
	            FileInputStream ExcelFile = new FileInputStream(filePath);
	            XSSFWorkbook wb = new XSSFWorkbook(ExcelFile);
	            XSSFSheet sheet = wb.getSheet(sheetname);
				int rowCount = sheet.getLastRowNum()+1;
				int cellCount = sheet.getRow(0).getLastCellNum();
				Object[][] data = new Object[rowCount][cellCount];
				System.out.println(rowCount);
				System.out.println(cellCount);
				for (int i = 1; i <rowCount; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < cellCount; j++) {
					XSSFCell cell = row.getCell(j);
					DataFormatter format = new DataFormatter();
				    data[i-1][j] = format.formatCellValue(cell);
				}
			}
			return data;
	}
}
