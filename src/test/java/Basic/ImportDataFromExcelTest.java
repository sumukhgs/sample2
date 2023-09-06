package Basic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ImportDataFromExcelTest {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\student detail.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int num = sh.getLastRowNum();
		for(int i=1;i<=num;i++)
		{
		Row ro = sh.getRow(i);
		
		Cell ce=ro.getCell(1);
		
		DataFormatter df = new DataFormatter();
		String s=df.formatCellValue(ce);
		System.out.println(s);
		}
	}

}
