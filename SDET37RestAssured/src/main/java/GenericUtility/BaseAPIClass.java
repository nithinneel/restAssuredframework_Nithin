package GenericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;
/**
 * 
 * @author nithin
 *
 */
public class BaseAPIClass {
	


	public BaseClass baseLib=new BaseClass();
	
	/**
	 * this method will connect to the database
	 * @throws SQLException
	 */
	@BeforeSuite
	public void dbConfig() throws SQLException {
		baseLib.dLib.ConnectToDatabase("projects");
		baseURI="http:localhost";
		port=8040;
	}
	/**
	 * this method will close the database connection
	 */
	@AfterSuite
	public void afterconfig() {
		baseLib.dLib.closeDb();
	}
}
