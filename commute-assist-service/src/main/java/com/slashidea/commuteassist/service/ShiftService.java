package com.slashidea.commuteassist.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.slashidea.commuteassist.model.LatLon;
import com.slashidea.commuteassist.model.ShiftMessage;
import com.slashidea.commuteassist.model.Trackpoint;
import com.slashidea.commuteassist.model.UserCurrentPosition;
import com.slashidea.commuteassist.store.InMemoryStore;

@Component
public class ShiftService {
    
    private Logger LOG = LoggerFactory.getLogger(ShiftService.class);
    
    @Autowired
    private InMemoryStore store;
    
    public void saveShiftMessage(Long userId, ShiftMessage shiftMessage) {
        LOG.debug("saveShiftMessage()");
        Assert.notNull(userId, "userId can not be null!"); 
        Assert.notNull(shiftMessage, "shiftMessage can not be null!"); 
        LOG.debug("userId: " + userId);
        LOG.debug("shiftMessage: " + shiftMessage);
        //take last known position
        Trackpoint trackpoint = store.getUsersCurrentPositions().containsKey(userId) ?  store.getUsersCurrentPositions().get(userId).getTrackpoint() : null;
       
        store.getUsersCurrentPositions().put(userId, new UserCurrentPosition(trackpoint, shiftMessage.getDelayInMillis()/1000, shiftMessage.getMessage()));
    }

    /**
     * MOCK that returns different data on each call.
     * @return
     */
	public List<UserCurrentPosition> getShiftUsers() {
		List<UserCurrentPosition> shiftUsers = new ArrayList<>();
		store.setCallId(store.getCallId() + 1);
		if(store.getCallId() > 7) store.setCallId(1);
		if(store.getCallId() <= 1) {
			shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 720l, null, "Jon Snow "));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 710l, null, "Tyrion Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 680l, null, "Cersei Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 890l, null, "Daenerys Targaryen"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 580l, null, "Sansa Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 395l, null, "Arya Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 456l, null, "Jaime Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 789l, null, "Jorah Mormont"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 534l, null, "Theon Greyjoy"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 302l, null, "Samwell Tarly"));
		} 
//		if(store.getCallId() == 2) {
//			shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 720l, null, "Jon Snow "));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 680l, null, "Tyrion Lannister"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 640l, null, "Cersei Lannister"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 790l, null, "Daenerys Targaryen"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 550l, null, "Sansa Stark"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 375l, null, "Arya Stark"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 436l, null, "Jaime Lannister"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 769l, null, "Jorah Mormont"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 514l, null, "Theon Greyjoy"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 292l, null, "Samwell Tarly"));
//		}
//		if(store.getCallId() == 3) {
//			shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 700l, null, "Jon Snow "));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 652l, null, "Tyrion Lannister"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 635l, null, "Cersei Lannister"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 790l, null, "Daenerys Targaryen"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 550l, null, "Sansa Stark"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 355l, null, "Arya Stark"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 416l, null, "Jaime Lannister"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 749l, null, "Jorah Mormont"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 514l, null, "Theon Greyjoy"));
//	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 212l, null, "Samwell Tarly"));
//		}
    	
    	if(store.getCallId() == 2) {
    		shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 650l, null, "Jon Snow "));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 612l, null, "Tyrion Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 535l, null, "Cersei Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 690l, null, "Daenerys Targaryen"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 650l, null, "Sansa Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 455l, null, "Arya Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 416l, null, "Jaime Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 709l, null, "Jorah Mormont"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 524l, null, "Theon Greyjoy"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 182l, null, "Samwell Tarly"));
    	}
    	if(store.getCallId() == 3) {
    		shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 650l, null, "Jon Snow "));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 612l, null, "Tyrion Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 535l, null, "Cersei Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 690l, null, "Daenerys Targaryen"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 50l, null, "Sansa Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 455l, null, "Arya Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 46l, null, "Jaime Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 709l, null, "Jorah Mormont"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 524l, null, "Theon Greyjoy"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 182l, null, "Samwell Tarly"));
		}
    	
    	if(store.getCallId() == 4) {
    		shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 650l, null, "Jon Snow "));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 612l, null, "Tyrion Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 535l, null, "Cersei Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), -720l, "My Dragon was hit by a sword, I am currently in a BUS.", "Daenerys Targaryen"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 50l, null, "Sansa Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 455l, null, "Arya Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 46l, null, "Jaime Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 709l, null, "Jorah Mormont"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 524l, null, "Theon Greyjoy"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 182l, null, "Samwell Tarly"));
		}
    	if(store.getCallId() == 5) {
    		shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 650l, null, "Jon Snow "));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 612l, null, "Tyrion Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 535l, null, "Cersei Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), -620l, "My Dragon was hit by a sword, I am currently in a BUS.", "Daenerys Targaryen"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 50l, null, "Sansa Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 455l, null, "Arya Stark"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 46l, null, "Jaime Lannister"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 709l, null, "Jorah Mormont"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 524l, null, "Theon Greyjoy"));
	    	shiftUsers.add(new UserCurrentPosition(new Trackpoint(1l, 1l, 56.0, 10.0, new LatLon(0.23, 0.23)), 182l, null, "Samwell Tarly"));
		}
    	
		return shiftUsers;
	}
    
}
