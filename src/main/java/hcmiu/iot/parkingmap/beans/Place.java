package hcmiu.iot.parkingmap.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="place")
public class Place {
	
	@XmlElement(name="id")
	private int id;
	@XmlElement(name="name")
	private String name;
	@XmlElement(name="lat")
	private Double latitude;
	@XmlElement(name="lng")
	private Double longitude;
	
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
