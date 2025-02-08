package Generic_utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	/**
	 * This method is used to read data from properties_file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getKeyAndValuePair(String key) throws Throwable {
		// step1:-get the java representation of the physical file/path setting
	//	FileInputStream fis = new FileInputStream("./src/test/resources/File.properties");
		FileInputStream fis = new FileInputStream(IpathConstant.filePath);
		
		// step2:- load all the keys
		Properties pro = new Properties();

		pro.load(fis);
		
		
		String value = pro.getProperty(key);
		return value;
	}
}
