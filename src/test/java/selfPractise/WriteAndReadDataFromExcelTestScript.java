package selfPractise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteAndReadDataFromExcelTestScript {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DemoWorkBookForPractise.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet3");
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<3;i++) {
			Row row = sheet.createRow(i);
			for(int j=0;j<3;j++) {
				Cell cell = row.createCell(j);
				System.out.println("enter the text:");
				String s=sc.next();
				cell.setCellValue(s);
				}
	    }
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\DemoWorkBookForPractise.xlsx");
		wb.write(fos);
		
		Thread.sleep(3000);
	    
		
		
	
		
		
		
		
	}

}
