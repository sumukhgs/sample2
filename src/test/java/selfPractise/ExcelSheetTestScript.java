package selfPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetTestScript {
	public static void main(String[] args) throws Exception {
		File file=new File(".\\src\\test\\resources\\clientPageInput.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		Row ro=sh.getRow(1);
		int count=ro.getLastCellNum();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			System.out.println(ro.getCell(i).getStringCellValue());
		}
		
		
	}

}
