package hcmiu.iot.parkingmap.conn;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionUtils {
	
	private static DataSource dataSource;
	
	public void setDataSource(DataSource ds) {
		this.dataSource=ds;
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
//		return MySQLConnUtils.getConnection();
		return dataSource.getConnection();
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
