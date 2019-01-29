package hcmiu.iot.parkingmap.rest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hcmiu.iot.parkingmap.beans.Place;
import hcmiu.iot.parkingmap.conn.ConnectionUtils;
import hcmiu.iot.parkingmap.dao.PlacesDAO;

@Path("/place")
public class PlaceREST {
	
	PlacesDAO pdao = new PlacesDAO();
	
	private Connection getConnection() {
		Connection conn=null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ConnectionUtils.rollbackQuietly(conn);
			try {
				throw new ServletException();
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			ConnectionUtils.closeQuietly(conn);
		}
		return conn;
	}
	
	@GET
	@Path("/all-places")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Place> getAllPlaces(){
//		System.out.println(pdao.getAllPlaces(this.getConnection()));
		return pdao.getAllPlaces(this.getConnection());
	}
	
}
