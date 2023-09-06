package selfPractise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataIntoPropertiesFileTestScript {
	public static void main(String[] args) throws Exception {
		Properties obj=new Properties();
		obj.put("name", "sumukh gundi");
		obj.put("place", "davangere");
		String path=".\\src\\test\\resources\\TestYantraCredentials.properties";
    	FileOutputStream fos=new FileOutputStream(path);
    	obj.store(fos, "new update text");
	
	    Properties p1=new Properties();
	    p1.put("01", "fish");
	    p1.put("02", "dog");
	    FileOutputStream po=new FileOutputStream(path);
	    p1.store(po,"new update");
	    
	
	
	}
	

}
