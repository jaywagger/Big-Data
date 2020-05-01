package kr.multi.bigdataShop.member.fcm;

public class LocationDTO {
	String latitudes; //위도
	String longitude; //경도
	public LocationDTO() {
		
	}
	
	public LocationDTO(String latitudes, String longitude) {
		super();
		this.latitudes = latitudes;
		this.longitude = longitude;
	}
	
	
	public String getLatitudes() {
		return latitudes;
	}

	public void setLatitudes(String latitudes) {
		this.latitudes = latitudes;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "LocationDTO [latitudes=" + latitudes + ", longitude=" + longitude + "]";
	}

	
	
}
