package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.testing.framework.EmailUtils;

public class ExcelReader {

	static String projectPath;
	static XSSFWorkbook workbook ;
	static XSSFSheet sheet;
	
public ExcelReader(String excelPath,String sheetName) {
		
		try {
			projectPath=System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelPath);
			sheet= workbook.getSheet(sheetName);
		}
		catch (Exception exp ) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		getRowCount();
////		getcolcount();
////		getcelldataString(1,0);
////		getcelldataNumber(1,1);
//
//	}



	//*Main function to call all excel related functions

	

	//* Function to fetch the row count from excel in which data is present
	public static int getRowCount()  {

		try {
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows : "+rowCount);
			return rowCount;
		} catch (Exception exp ) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		return 0;
	}

	//* Function to fetch the row count from excel in which data is present
	public static int getcolcount()  {

		try {

			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of cols : "+colCount);
			return colCount;
		} catch (Exception exp ) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}
		return 0;
	}

	//* Function to fetch the String data from the Cell of excel

	public static String getcelldataString(int rowNum, int colNum)  {

		try {

			String CellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(CellData);
			return CellData;
		} catch (Exception exp ) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return null;
	}
	//* Function to fetch the  Numeric data from the Cell of excel

	public static double getcelldataNumber(int rowNum, int colNum)  {	
		try {

			double CellData= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(CellData);
			return CellData;

		} catch (Exception exp ) {
			System.out.println(exp.getMessage());;
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return 0;

	}


}

