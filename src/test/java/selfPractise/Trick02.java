package selfPractise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Trick02 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestYantraCredentials.properties");
		Properties obj=new Properties();
		obj.load(fis);
		String x=obj.getProperty("place");
		String y=obj.getProperty("name");
		System.out.println(x+"  "+y);
	}

}
