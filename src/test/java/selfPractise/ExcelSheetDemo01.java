package selfPractise;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetDemo01 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("src\\test\\resources\\student detail.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int num=sh.getLastRowNum();
		for(int i=1;i<=num;i++)
		{
			System.out.println(sh.getRow(i).getCell(2).getStringCellValue());
		}
		
		
	}

}
