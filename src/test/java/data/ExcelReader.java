package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


	public FileInputStream FIS = null;

	public FileInputStream getFileInputStream() {
		String FilePath = System.getProperty("user.dir")+"/src/test/java/data/inputData2.xlsx";
		File srcFile = new File(FilePath);

		try {
			FIS = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("error occured" + e.getMessage());
			System.exit(0);
		}

		return FIS;
	}

	public Object[][] getExcelData() throws IOException{
		FIS = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(FIS);
		XSSFSheet sheet = wb.getSheetAt(0);
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = sheet.getRow(0).getLastCellNum(); 

		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 

		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < TotalNumberOfCols; j++) {
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}

		wb.close();
		return arrayExcelData; 

	}
	
}