package selfPractise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Trick01 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DemoWorkBookForPractise.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("sheet1");
		
		for(int i=1;i<=6;i++)
		{
			Row row=s.getRow(i);
			System.out.println();
			for(int j=0;j<=4;j++)
			{
				String ans = row.getCell(j).getStringCellValue();
			    if(ans.length()>3)
			    {
			    	System.out.print(ans+"\t");
			    }
	                		
			
			
			}
			
		}
	}

}
