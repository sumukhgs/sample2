package testNGScripts;

import org.testng.annotations.Test;

public class FetchingMultipledataProviderTestScript {
	
	@Test(dataProviderClass = DataProviderclassss.class,dataProvider="data3",dependsOnMethods = "CostOfTravelling")
	public  void CostOfTravelling(String key,String val)
	{
		System.out.println(key+"------>"+val);
	}
	
	@Test(dataProviderClass = DataProviderclassss.class,dataProvider="data2")
	public void ReadAll(String place,int rate)
	{
		System.out.println(place+" and travelling rate is :"+rate);
	}
	
	@Test(dataProviderClass = DataProviderclassss.class,dataProvider="data1")
	public  void CostOfTravelling(String src,String dest,int price)
	{
		System.out.println(src+" to "+dest+" the cost price is ="+price);
	}
	
	

}
