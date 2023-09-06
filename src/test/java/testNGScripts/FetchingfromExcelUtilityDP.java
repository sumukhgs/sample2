package testNGScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hopestar.GenericUtility.ExcelUtility;

public class FetchingfromExcelUtilityDP {
	@Test(dataProvider="getDataGeneric")
	public void read(String stuname,String age,String loc)
	{
		System.out.println(stuname+" is  of age "+age+" and from place called  :"+loc);
	}
	
	@DataProvider
	public Object[][] getDataGeneric() throws Throwable
	{
		ExcelUtility e=new ExcelUtility();
		Object[][] value = e.DPMultipleSetOfData("DP");
		return value;
	}

}
