package utilities;

public class TestDataReader {

      
	public static String getData(ExcelReader excel, String key) {
		return excel.getCellValueAsString(1, excel.findStringInRow(0, key));
	}
	
	
}
