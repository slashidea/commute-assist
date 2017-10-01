package com.slashidea.commuteassist.model;

import java.util.List;

public class Ride {
	
	private Long id; //unique ride ID, not used right now
	private Integer priority;
    private List<RidePoint> rideOptions;
    
    public Ride(Integer priority, List<RidePoint> rideOptions) {
        this.priority = priority;
        this.rideOptions = rideOptions;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<RidePoint> getRideOptions() {
        return rideOptions;
    }

    public void setRideOptions(List<RidePoint> rideOptions) {
        this.rideOptions = rideOptions;
    }    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return "Ride [id = " + id + ", priority=" + priority + ", rideOptions=" + rideOptions + "]";
    }

}
