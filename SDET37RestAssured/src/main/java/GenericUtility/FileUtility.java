package GenericUtility;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author nithin
 *
 */
public class FileUtility {
/**
 * to read common data from Properties file	
 * @param key
 * @return
 * @throws IOException
 */
	public String getThePropertiesFile(String key) throws IOException {
		FileInputStream fileInputStream = new  FileInputStream(IConstants.filepath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String value = properties.getProperty(key);
		return value;
	}
}
