package selfPractise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFilesEx01 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("src\\test\\resources\\TestYantraCredentials.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String url=pobj.getProperty("url");
		System.out.println(url);
		
		pobj.setProperty("url","sumukh");
		//is it possible to update the property files 
		String urla=pobj.getProperty("url");
		System.out.println(urla);
		
		
	}

}
