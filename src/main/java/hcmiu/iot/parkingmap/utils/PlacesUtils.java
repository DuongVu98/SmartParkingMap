package hcmiu.iot.parkingmap.utils;

import java.sql.Connection;
import java.util.List;

import hcmiu.iot.parkingmap.beans.Place;

public interface PlacesUtils {
	public Place getById(Connection conn, int id);
	public void savePlace(Connection conn, Place place);
	public void updatePlace(Connection conn, Place place);
	public void delete(Connection conn, int id);
	public List<Place> getAllPlaces(Connection conn);
}
