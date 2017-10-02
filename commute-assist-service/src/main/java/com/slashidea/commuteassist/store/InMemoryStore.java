package com.slashidea.commuteassist.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.slashidea.commuteassist.model.RidePoint;
import com.slashidea.commuteassist.model.RidePointIndex;
import com.slashidea.commuteassist.model.Trackpoint;
import com.slashidea.commuteassist.model.User;
import com.slashidea.commuteassist.model.UserCurrentPosition;

/**
 * This is just an in memory store and can be then connect to any datasource (database)
 * 
 *
 */
@Component
public class InMemoryStore {

    private Map<Long, User> users = new HashMap<>();
    private Map<Long, List<RidePoint>> driveShareGroups = new HashMap<>(); //key = driverId, value = list with points where he should stop and pickup employee
    private Map<Long, List<Trackpoint>> trackpoints = new HashMap<>(); //key = userId, value list of stored trackpoints
    private Map<Long, List<RidePoint>> employeeSelectedRides = new HashMap<>(); //key = employeeId, his selected trip points
    private Map<Long, Map<RidePointIndex, Set<Long>>> ridePointGroups = new HashMap<Long, Map<RidePointIndex, Set<Long>>>(); //key = userId, value = <Index for point, list of users who ride with him at that point>
    private Map<Long, UserCurrentPosition> usersCurrentPositions = new HashMap<>();
    
    private int callId = 0;
    
    public int getCallId() {
		return callId;
	}

	public void setCallId(int callId) {
		this.callId = callId;
	}

	public Map<Long, User> getUsers() {
        return users;
    }

    public Map<Long, List<Trackpoint>> getTrackpoints() {
        return trackpoints;
    }

	public Map<Long, List<RidePoint>> getEmployeeSelectedRides() {
		return employeeSelectedRides;
	}

	public Map<Long, List<RidePoint>> getDriveShareGroups() {
		return driveShareGroups;
	}

	public Map<Long, Map<RidePointIndex, Set<Long>>> getRidePointGroups() {
		return ridePointGroups;
	}

	public Map<Long, UserCurrentPosition> getUsersCurrentPositions() {
		return usersCurrentPositions;
	}

}
