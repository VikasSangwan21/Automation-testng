package utilities;

public class TestDataReader {

	public static  void main (String[] args) {
		String projectPath=System.getProperty("user.dir");

		ExcelReader excel = new ExcelReader(projectPath+"/src/test/resources/test-data/TestData.xlsx","sheet1");
            excel.getRowCount();
            excel.getcolcount();
            excel.getcelldataString(1, 0);
            excel.getcelldataNumber(1, 1);
            
	}
	public static String getData(String key) {
		
		return null;
	}
	
	
}
