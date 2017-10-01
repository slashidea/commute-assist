package com.slashidea.commuteassist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;







import com.slashidea.commuteassist.model.RidePoint;
import com.slashidea.commuteassist.model.RidePointIndex;
import com.slashidea.commuteassist.model.Trackpoint;
import com.slashidea.commuteassist.model.UserCurrentPosition;
import com.slashidea.commuteassist.store.InMemoryStore;

@Component
public class TrackService {
    
    private Logger LOG = LoggerFactory.getLogger(TrackService.class);
    
    @Autowired
    private InMemoryStore store;
    
    public void saveTrackpoint(Long userId, Trackpoint trackpoint) {
        LOG.debug("saveTrackpoint()");
        Assert.notNull(userId, "userId can not be null!"); 
        Assert.notNull(trackpoint, "trackpoint can not be null!"); 
        LOG.debug("userId: " + userId);
        LOG.debug("trackpoint: " + trackpoint);
        
        trackpoint.setUserId(userId); 
        if(!store.getTrackpoints().containsKey(userId)) {
        	store.getTrackpoints().put(userId, new ArrayList<Trackpoint>());
        }
        store.getTrackpoints().get(userId).add(trackpoint);
        
        //TODO With the use of Google Maps API check the estimated time to parking and store this time for current user and also his co-travelers
        Long timeToParkingSeconds = 10l; //this must be calculated with GMapsApi
        
        store.getUsersCurrentPositions().put(userId, new UserCurrentPosition(trackpoint, timeToParkingSeconds, null));
        
        //enhancement - check if there aren't 2 or more people who sent this same position so we don't need to obtain the est. time anymore
 
        //from store.ridePointGroups we know who is traveling with this user so we can assign this current position also to them - we are tracking the whole group 
        store.getRidePointGroups().forEach((k,v)-> {
        	//search for last point where he went through where we know who is traveling with
        	List<RidePoint> thisUserRidePoints = store.getEmployeeSelectedRides().get(userId);
        	Optional<RidePoint> lastRidePoint = thisUserRidePoints.stream()
        										.filter(findRidePointBeforeThisTime(trackpoint.getTimestamp()))
        										.reduce((first, second) -> second);
        	if(lastRidePoint.isPresent()) {
        		RidePointIndex rpi = lastRidePoint.get().toIndex();
        		//get the IDs of coTravellers
        		Set<Long> coTravelerIds = v.get(rpi);
        		coTravelerIds.stream()
        						.forEach(assignCurrentPositionToUser(trackpoint, timeToParkingSeconds));
        		
        	}        	
        });
    }
    
    private Predicate<? super RidePoint> findRidePointBeforeThisTime(Long timestamp) {
    	return rp -> rp.getTimestamp() <= timestamp;
    }
    
    private Consumer<? super Long> assignCurrentPositionToUser(Trackpoint trackpoint, Long timeToParkingSeconds) {
    	return userId -> store.getUsersCurrentPositions().put(userId, new UserCurrentPosition(trackpoint, timeToParkingSeconds, null));
    }
}
