// it is receving the data from dataproviderclassss and running
package testNGScripts;

import org.testng.annotations.Test;

@Test(dataProviderClass = DataProviderclassss.class, dataProvider="data1")
public class Classss {
	public void cooik(String src,String dest,int price)
	{
		System.out.println(src+" to "+ dest+" the cost price is "+ price);
	}

}
