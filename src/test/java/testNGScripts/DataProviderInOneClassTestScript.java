// the data is provided within the same class and fetching in the same class only
package testNGScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderInOneClassTestScript {
	
	@Test(dataProvider="Data")
	public void ReadTheData(String city,String refname)
	{
		System.out.println(city+"---also called as---"+refname);
	}
	
	@DataProvider
	public Object[][] Data()
	{
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="bangalore";
		obj[0][1]="garden city";
		
		obj[1][0]="davangere";
		obj[1][1]="Benne nagari";
		return obj;
	}

}
