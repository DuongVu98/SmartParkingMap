package hcmiu.iot.smartparking.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;

public class MyUtils {
	public static final String ATT_NAME_CONNECTION="MY_CONNECTION_ATTRIBUTE";
	
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}
	
	//Connection utilities
	public static Connection getStoredConnection(ServletRequest request) {
		return (Connection)request.getAttribute(ATT_NAME_CONNECTION);
	}
	
	
}
