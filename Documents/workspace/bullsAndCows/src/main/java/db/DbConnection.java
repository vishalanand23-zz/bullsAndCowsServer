package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DbConnection {
 
	private static final String USER = "root";
	private static final String DATABASE_NAME = "bullsAndCows";
	private static final String PASSWORD = null;
	private static final String PORT = "3306";

	public Connection getConnection() throws Exception {
	     try {
			 String connectionURL = "jdbc:mysql://localhost:" + PORT + "/" + DATABASE_NAME;
			 Connection connection = null;
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 connection = DriverManager.getConnection(connectionURL, USER, PASSWORD);
			 System.out.println("Connection to db successful.");
			 return connection;
	     } catch (SQLException e) {
			 throw e;
	     } catch (Exception e) {
			 throw e;
	     }
	 }
}
