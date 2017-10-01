package com.slashidea.commuteassist.model;

public class RidePointIndex {
	private VehicleTypeEnum vehicleType;
    private Long timestamp;
    private LatLon latLon;
    
	public RidePointIndex(VehicleTypeEnum vehicleType, Long timestamp,
			LatLon latLon) {
		super();
		this.vehicleType = vehicleType;
		this.timestamp = timestamp;
		this.latLon = latLon;
	}
	
	public VehicleTypeEnum getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleTypeEnum vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public LatLon getLatLon() {
		return latLon;
	}
	public void setLatLon(LatLon latLon) {
		this.latLon = latLon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((latLon == null) ? 0 : latLon.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result
				+ ((vehicleType == null) ? 0 : vehicleType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RidePointIndex other = (RidePointIndex) obj;
		if (latLon == null) {
			if (other.latLon != null)
				return false;
		} else if (!latLon.equals(other.latLon))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (vehicleType != other.vehicleType)
			return false;
		return true;
	}
	
	
}
