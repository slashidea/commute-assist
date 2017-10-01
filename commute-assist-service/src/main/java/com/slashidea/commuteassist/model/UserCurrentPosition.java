package com.slashidea.commuteassist.model;

public class UserCurrentPosition {
	private Trackpoint trackpoint;
	private Long timeToParkingSeconds;
	private String message;
	private String employeeName; //just for mockup
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public UserCurrentPosition(Trackpoint trackpoint,
			Long timeToParkingSeconds, String message) {
		super();
		this.trackpoint = trackpoint;
		this.timeToParkingSeconds = timeToParkingSeconds;
		this.message = message;
	}
	
	public UserCurrentPosition(Trackpoint trackpoint,
			Long timeToParkingSeconds, String message, String employeeName) {
		super();
		this.trackpoint = trackpoint;
		this.timeToParkingSeconds = timeToParkingSeconds;
		this.message = message;
		this.employeeName = employeeName;
	}
	public Trackpoint getTrackpoint() {
		return trackpoint;
	}
	public void setTrackpoint(Trackpoint trackpoint) {
		this.trackpoint = trackpoint;
	}
	public Long getTimeToParkingSeconds() {
		return timeToParkingSeconds;
	}
	public void setTimeToParkingSeconds(Long timeToParkingSeconds) {
		this.timeToParkingSeconds = timeToParkingSeconds;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
