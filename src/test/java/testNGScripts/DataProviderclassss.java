//this class is providing the data to classss class (they are example for getting data from different class)
//we also import the data from excel utility just by creating an object of the utility class
package testNGScripts;

import org.testng.annotations.DataProvider;

import com.hopestar.GenericUtility.ExcelUtility;

public class DataProviderclassss {
	ExcelUtility e=new ExcelUtility();
	@DataProvider
	public Object[][] data1()
	{
		Object[][] obj=new Object[2][3];
		obj[0][0]="davangere";
		obj[0][1]="goa";
		obj[0][2]=1000;
		
		obj[1][0]="davangere";
		obj[1][1]="bangalore";
		obj[1][2]=600;
		
		return obj;	
	}
	
	@DataProvider
	public Object[][] data2()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="davangere";
		obj[0][1]=1000;
		
		obj[1][0]="davangere";
		obj[1][1]=600;
		
		obj[2][0]="leo";
		obj[2][1]=56;
		
		return obj;
	}
	
	@DataProvider
	public Object[][] data3() throws Throwable
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]=e.readDataFromExcel("sheet1", 1, 0);
		obj[0][1]=e.readDataFromExcel("sheet1", 1, 1);
		
		obj[1][0]=e.readDataFromExcel("sheet1", 2, 0);
		obj[1][1]=e.readDataFromExcel("sheet1", 2, 1);
		return obj;
	}

}
