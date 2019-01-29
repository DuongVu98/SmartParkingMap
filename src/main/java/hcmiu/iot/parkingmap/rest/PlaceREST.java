package hcmiu.iot.parkingmap.rest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
		}
		return conn;
	}
	
	@GET
	@Path("/all-places")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Place> getAllPlaces(){
		return pdao.getAllPlaces(this.getConnection());
	}
	
}
