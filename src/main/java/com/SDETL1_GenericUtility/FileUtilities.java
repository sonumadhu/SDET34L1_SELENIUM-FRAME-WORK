package com.SDETL1_GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**this class contains only Property file specific common methods
 *
 * @author Bhushana
 *
 */

public class FileUtilities {
	static Properties property;
	/**
	 * this method is used to open the property file
	 * @return 
	 * @throws IOException 
	 * 
	 */
	public static void openPropertyFile(String filePath) throws IOException {
	FileInputStream fis = new FileInputStream( filePath);
	property = new Properties();
	 property.load(fis);

}
	/**
	 * this method is used to fetch the data fromPropertyfile
	 * @param key
	 * @return 
	 * @return
	 * @throws IOException 
	 */

   public static String StringfetchDataFromPropertyFile(String key) throws IOException {

	  String value = property.getProperty(key);
	   return value;
   }
}
   
   
   
   
   
   
   
   
   
   
   
