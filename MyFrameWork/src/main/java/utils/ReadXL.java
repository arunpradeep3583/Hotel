package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXL {
	
	
	public String [][] readExcel (String xlFile) throws IOException{
		
		String[][] data= null;
		FileInputStream locate = new FileInputStream(xlFile);
		XSSFWorkbook book = new XSSFWorkbook(locate);
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		data = new String[rowCount][cellCount];
		
		for (int i=1;i<rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			
			for (int j=0;j<cellCount;j++) {
				
				String value = row.getCell(j).getStringCellValue();
				data[i-1][j]= value;
			}
		}
		
		return data;
		
	}

}
