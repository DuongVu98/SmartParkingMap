package hcmiu.iot.parkingmap.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hcmiu.iot.parkingmap.conn.ConnectionUtils;

@WebFilter(urlPatterns= {"/*"})
public class JDBCFilter implements Filter{
//	private DataSource dataSource;
//	
//	public void setDataSource(DataSource ds) {
//		this.dataSource = ds;
//	}
	
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("jdbc-beans.xml");
	ConnectionUtils connUtils= context.getBean("connection",ConnectionUtils.class);
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)request;
		String servletPath= req.getServletPath();
		
		if(servletPath.contains("/initmap")) {
			Connection conn=null;
			
			try {
				conn=ConnectionUtils.getConnection();
//				conn=dataSource.getConnection();
				conn.setAutoCommit(false);
				MyUtils.storeConnection(request, conn);
				chain.doFilter(request, response);
				conn.commit();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ConnectionUtils.rollbackQuietly(conn);
				throw new ServletException();
			}finally {
				ConnectionUtils.closeQuietly(conn);
			}
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
