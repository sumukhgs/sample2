package Basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTestScript {
     public static void main(String[] args) throws EncryptedDocumentException, IOException {
    	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\student detail.xlsx");
    	 Workbook wb=WorkbookFactory.create(fis);
    	 Sheet sh = wb.getSheet("Sheet1");
    	 sh.createRow(3).createCell(6).setCellValue("ayyappa");
    	 FileOutputStream fout=new FileOutputStream(".\\src\\test\\resources\\student detail.xlsx");
    	 wb.write(fout);
    	 wb.close();
    	 
    	 
    	 
	
}
}
