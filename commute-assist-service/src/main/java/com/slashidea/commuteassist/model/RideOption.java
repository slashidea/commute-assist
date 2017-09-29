package com.slashidea.commuteassist.model;

public class RideOption {

    private VehicleTypeEnum vehicleType;
    private Long timestamp;
    private LatLon latLon;
    
    public RideOption(VehicleTypeEnum vehicleType, Long timestamp, LatLon latLon) {
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
    public String toString() {
        return "RideOption [vehicleType=" + vehicleType + ", timestamp=" + timestamp + ", latLon=" + latLon + "]";
    }

}
