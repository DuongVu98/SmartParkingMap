package hcmiu.iot.parkingmap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hcmiu.iot.parkingmap.conn.ConnectionUtils;
import hcmiu.iot.parkingmap.beans.Place;

public class PlacesDAO {
	public PlacesDAO() {
		
	}
	
	public Place getById(Connection conn, int id) {
		String sql="SELECT * FROM places WHERE idplaces=?";
		PreparedStatement ps = null;
		ResultSet rs= null;
		Place place = null;
		
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				place.setId(rs.getInt("id"));
				place.setName(rs.getString("placename"));
				place.setLatitude(rs.getDouble("latitude"));
				place.setLongitude(rs.getDouble("longitude"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return place;
	}
	
	public void savePlace(Connection conn, Place place) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO places (id, placename, latitude, longitude) VALUEs (?,?,?)";
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, place.getId());
			ps.setString(2, place.getName());
			ps.setDouble(3, place.getLatitude());
			ps.setDouble(4, place.getLongitude());
			
			int out=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void updatePlace(Connection conn, Place place) {
		// TODO Auto-generated method stub
		
	}
	
	public void deleteById(Connection conn, int id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM places WHERE id=?";
		PreparedStatement ps = null;
		Place place=null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int out=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Place> getAllPlaces(Connection conn) {
		// TODO Auto-generated method stub
		
		String sql="SELECT * FROM places";
		Place place;
		ArrayList<Place> pList=new ArrayList<Place>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=ConnectionUtils.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				place=new Place();
				place.setId(rs.getInt("id"));
				place.setName(rs.getString("placename"));
				place.setLatitude(rs.getDouble("latitude"));
				place.setLongitude(rs.getDouble("longitude"));
				
				pList.add(place);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pList;
	}
}
