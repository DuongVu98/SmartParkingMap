package hcmiu.iot.smartparking.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String userName="root";
		String password="1234";
		String dbName="parkingmap";
		String url="jdbc:mysql:/localhost:3306/"+dbName;
		
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url,userName,password);
	}
}
