package GenericUtility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	static Driver driverRef;
	static Connection connection;
	static ResultSet result;
	static int res;
	/**
	 * this method is used to connect to the data base
	 * @param DbName
	 * @throws SQLException
	 */
	public void ConnectToDatabase(String DbName) throws SQLException {
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		connection = DriverManager.getConnection(IConstants.DbUrl+DbName, IConstants.DbUserName, IConstants.DbPassword);
	}
	/**
	 *this method is used to close the database
	 */
	public void closeDb() {
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * this method is used to execute the query
	 * @param query
	 * @param columnNum
	 * @param expectedData
	 * @throws SQLException
	 */
	public void executeQuery(String query, int columnNum, String expectedData) throws SQLException {
		int count=0;
		ResultSet result = connection.createStatement().executeQuery(query);
		while (result.next()) {
			//System.out.println(result.getString(columnNum));
			if(result.getString(columnNum).equals(expectedData)){
				count=1;
				break;
			}
			}
		if (count==1) {
			System.out.println("data is present");}
		else {
			System.out.println("data is not present");}
	}
	/**
	 * this method is used to perform the execute update
	 * @param query
	 * @throws SQLException
	 */
	public void executeUpdate(String query) throws SQLException {
		res=connection.createStatement().executeUpdate(query);
		if (res==1) {
			System.out.println("data is updated");
		}
		else {
			System.out.println("data is not updated");
		}
	}
}
