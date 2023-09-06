package selfPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.hopestar.GenericUtility.WebDriverUtility;

public class ReadAndWriteAtOnesFromExcel {
	public static void main(String[] args) throws Exception {
		WebDriverUtility wLib=new WebDriverUtility();
		File file=new File(".\\src\\test\\resources\\DemoWorkBookForPractise.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		for(int i=3;i<6;i++)
		{
			Row row = s.createRow(i);
			for(int j=0;j<3;j++)
			{
				row.createCell(j).setCellValue(j);
			}
		}
		
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\DemoWorkBookForPractise.xlsx");
	    wb.write(fos);
	    
	    DataFormatter df= new DataFormatter();
	    for(int i=3;i<6;i++)
		{
			Row row = s.getRow(i);
			for(int j=0;j<3;j++)
			{
				Cell c = row.getCell(j);
				String ans = df.formatCellValue(c);
				System.out.println(ans);
				
			}
		}
		
	    
         	
	
	}

}
