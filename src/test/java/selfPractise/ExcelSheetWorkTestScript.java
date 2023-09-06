package selfPractise;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelSheetWorkTestScript {
	public static void main(String[] args) throws Exception {
		File file=new File(".\\src\\test\\resources\\student detail.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int size = sh.getPhysicalNumberOfRows();
		System.out.println();
		Row ro = sh.getRow(0);
		int num=ro.getPhysicalNumberOfCells();
		System.out.println(num);
		
		System.out.println("************************************");
		
		for(int i=0;i<size;i++) 
		{
		     System.out.println(" "+"\n");
			for(int j=0;j<num;j++)
			{
				System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
				
				
			}
			
		}
		
	}

}
