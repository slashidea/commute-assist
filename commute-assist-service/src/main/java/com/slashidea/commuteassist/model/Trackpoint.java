package com.slashidea.commuteassist.model;

public class Trackpoint {

    private Long userId;
    private Long timestamp;
    private Double speed;
    private Double altitude;
    private LatLon latLon;

    public Trackpoint() {
    }

    public Trackpoint(Long userId, Long timestamp, Double speed, Double altitude, LatLon latLon) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.speed = speed;
        this.altitude = altitude;
        this.latLon = latLon;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public LatLon getLatLon() {
        return latLon;
    }

    public void setLatLon(LatLon latLon) {
        this.latLon = latLon;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Trackpoint [timestamp=" + timestamp + ", speed=" + speed + ", altitude=" + altitude + ", latLon=" + latLon + "]";
    }

}
