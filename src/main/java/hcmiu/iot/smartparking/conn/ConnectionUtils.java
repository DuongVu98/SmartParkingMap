package hcmiu.iot.smartparking.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return MySQLConnUtils.getConnection();
	}
	
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
