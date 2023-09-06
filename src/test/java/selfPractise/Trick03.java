package selfPractise;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Trick03 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DemoWorkBookForPractise.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		for(int i=3;i<5;i++) {
			Row r = sheet.createRow(i);
				for(int j=0;j<3;j++)
				{
			
		           r.createCell(j).setCellValue("joy");
		
		}
			}
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\DemoWorkBookForPractise.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
