package com.slashidea.commuteassist.model;

import java.beans.Transient;
import java.util.Optional;

import org.springframework.util.Assert;

/**
 * Represents one point in the whole ride
 * 
 */
public class RidePoint {

    private VehicleTypeEnum vehicleType;
    private Long timestamp;
    private LatLon latLon;
    private Long driverId; //if this RidePoint is of type DRIVE_SHARE we need to enter drivers id
    private Long employeeId; //if this RidePoint is of type DRIVE_SHARE we need to enter employee id
    
    public RidePoint(VehicleTypeEnum vehicleType, Long timestamp, LatLon latLon) {
    	Assert.isTrue(!VehicleTypeEnum.DRIVE_SHARE.equals(vehicleType), "You cannot create drive share without driver and employee id!"); 
        this.vehicleType = vehicleType;
        this.timestamp = timestamp;
        this.latLon = latLon;
        this.driverId = null;
        this.employeeId = null;
    }

    public RidePoint(VehicleTypeEnum vehicleType, Long timestamp,
			LatLon latLon, Long driverId, Long employeeId) {
		this.vehicleType = vehicleType;
		this.timestamp = timestamp;
		this.latLon = latLon;
		this.driverId = driverId;
		this.employeeId = employeeId;
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

	public Long getDriverId() {
		return driverId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	@Transient
	public RidePointIndex toIndex() {
		return new RidePointIndex(vehicleType, timestamp, latLon);
	}
}
