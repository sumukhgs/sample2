package selfPractise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class demoExcelTestScript {
	public static void main(String[] args) throws Exception {
		File file=new File("C:\\Users\\Sumukh g s\\Desktop\\testingpurpose.xlsx");
		Workbook wb=WorkbookFactory.create(file);
		Sheet sh=wb.getSheet("Sheet1");
		Row ro=sh.createRow(1);
		Cell cel=ro.createCell(4);
		cel.setCellValue("good");
		
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Sumukh g s\\Desktop\\testingpurpose.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
