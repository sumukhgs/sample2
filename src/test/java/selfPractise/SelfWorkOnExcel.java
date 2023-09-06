package selfPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SelfWorkOnExcel {
	public static void main(String[] args) throws Exception {
		File file=new File(".\\src\\test\\resources\\DemoWorkBookForPractise.xlsx");
		FileInputStream fis=new FileInputStream(file);
	    Workbook wb=WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet("Sheet1");
	    for(int i=1;i<=6;i++)
	    {
	     Row row = sheet.getRow(i);
	     System.out.println();
	     for(int j=0;j<=4;j++)
	     {
	     String ans = row.getCell(j).getStringCellValue();
   	     System.out.print(ans+"\t");
	    }
	}

	}	
}

