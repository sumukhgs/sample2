//Data Provider to add payment test script
package testNGScripts;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.hopestar.GenericUtility.ExcelUtility;
import com.hopestar.GenericUtility.IPathConstants;

public class HopeStarDataProviderTestScript {
	
	ExcelUtility e=new ExcelUtility();
	@DataProvider
	public Object[][] data1() throws Exception
	{
		//Object[][] obj=new Object[5][2];
		File file=new File(IPathConstants.excelpath);
		FileInputStream fis=new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Add paymentclient");
		int rowcount=sh.getLastRowNum();
		int cellcount=sh.getRow(1).getLastCellNum();
		System.out.println(rowcount);
		System.out.println(cellcount);
		
		Object[][] obj=new Object[rowcount+1][cellcount];
		for(int i=0;i<=rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

}
