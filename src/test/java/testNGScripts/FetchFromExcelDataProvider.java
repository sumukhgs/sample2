package testNGScripts;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hopestar.GenericUtility.IPathConstants;

public class FetchFromExcelDataProvider {
	
	@Test(dataProvider="getDatafromExcel")
	public void read(String stuname,String age,String loc)
	{
		System.out.println(stuname+" is  of age "+age+" and from place called  :"+loc);
	}

	
	@DataProvider
	public Object[][] getDatafromExcel() throws Exception
	{
		File file=new File(IPathConstants.excelpath);
		FileInputStream fis=new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		int rowcount=sh.getLastRowNum();
		int cellcount=sh.getRow(1).getLastCellNum();
		System.out.println(rowcount);
		System.out.println(cellcount);
		
		Object[][] obj=new Object[rowcount][cellcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				obj[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}

}
