package com.slashidea.commuteassist.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slashidea.commuteassist.model.Ride;
import com.slashidea.commuteassist.model.RidePoint;
import com.slashidea.commuteassist.model.ShiftMessage;
import com.slashidea.commuteassist.model.Trackpoint;
import com.slashidea.commuteassist.model.UserCurrentPosition;
import com.slashidea.commuteassist.service.RideService;
import com.slashidea.commuteassist.service.ShiftService;
import com.slashidea.commuteassist.service.TrackService;

@RestController
public class MainController {
    
    @Autowired
    private RideService rideService;
    
    @Autowired
    private TrackService trackService;
    
    @Autowired
    private ShiftService shiftService;

    @RequestMapping("/user/{userId}/ride/options")
    public List<Ride> getRideOptions(@PathVariable(value="userId", required=true) Long userId) {        
        Map<Integer, List<RidePoint>> possibleOptions = rideService.getPossibleRideOptionsMock(userId);        
        List<Ride> result = new ArrayList<>();
        if (possibleOptions != null) {            
            result = possibleOptions.entrySet().stream()
            		.sorted(Comparator.comparing(Map.Entry::getKey))
                    .map(ro -> new Ride(ro.getKey(), ro.getValue()))
                    .collect(Collectors.toList());
        }
        return result;
    }
    
    @RequestMapping("/user/{userId}/ride/option")
    public List<RidePoint> getRideOptionDetails(@PathVariable(value="userId", required=true) Long userId, 
    		@PathVariable(value="priorityId", required=true) Long priorityId) {
    	
    	return rideService.getRideOptionsMock(userId, priorityId);       
    }
    
    /**
     * 
     * @param userId drivers id
     * @param priorityId which option he chose and wants to go with 
     * @return OK
     */
    @RequestMapping(value = "/ride/assign", method = RequestMethod.POST) 
    public ResponseEntity<?> assignUser(@PathVariable(value="userId", required=true) Long userId, 
    		@PathVariable(value="priorityId", required=true) Long priorityId) {
    	
    	//assign this user to user group regarding his option
        rideService.assignUser(userId, priorityId);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    //TODO endpoint where user sends that he is a driver - available until some time 
    
    //TODO endpoint where driver gets list of travelers who is he taking with (drive share)
    
    
    @RequestMapping(value = "/user/{userId}/trackpoint", method = RequestMethod.POST) 
    public ResponseEntity<?> saveTrackpoint(@PathVariable(value="userId", required=true) Long userId,
            @RequestBody Trackpoint trackpoint) {        
        trackService.saveTrackpoint(userId, trackpoint);       
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user/{userId}/delay/message", method = RequestMethod.POST) 
    public ResponseEntity<?> saveTrackpoint(@PathVariable(value="userId", required=true) Long userId,
            @RequestBody ShiftMessage shiftMessage) {        
        shiftService.saveShiftMessage(userId, shiftMessage);       
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/shiftManager", method = RequestMethod.GET) 
    public List<UserCurrentPosition> shiftManagerEmployees() {        
    	//TODO use store.getUsersCurrentPositions() to get current locations
        return shiftService.getShiftUsers();
    }
    
}
