package hcmiu.iot.smartparking.servlets;

public class Place {
	private int id;
	private String name;
	private Double latitude, longitude;
	
	public Place() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public String toString() {
		return "place infomation: "+this.id+"  "+this.name+"  "+this.latitude+"  "+this.longitude;
	}
}
