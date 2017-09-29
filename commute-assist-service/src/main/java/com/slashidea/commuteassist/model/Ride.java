package com.slashidea.commuteassist.model;

import java.util.List;

public class Ride {

    private Integer priority;
    private List<RideOption> rideOptions;
    
    public Ride(Integer priority, List<RideOption> rideOptions) {
        this.priority = priority;
        this.rideOptions = rideOptions;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<RideOption> getRideOptions() {
        return rideOptions;
    }

    public void setRideOptions(List<RideOption> rideOptions) {
        this.rideOptions = rideOptions;
    }    

    @Override
    public String toString() {
        return "Ride [priority=" + priority + ", rideOptions=" + rideOptions + "]";
    }

}
