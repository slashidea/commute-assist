package com.slashidea.commuteassist.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.slashidea.commuteassist.model.DriveShareGroup;
import com.slashidea.commuteassist.model.LatLon;
import com.slashidea.commuteassist.model.RidePoint;
import com.slashidea.commuteassist.model.RidePointIndex;
import com.slashidea.commuteassist.model.VehicleTypeEnum;
import com.slashidea.commuteassist.store.InMemoryStore;

@Component
public class RideService {
    
    private Logger LOG = LoggerFactory.getLogger(RideService.class);
    
    @Autowired
    private InMemoryStore store;

    public Map<Integer, List<RidePoint>> getPossibleRideOptionsMock(Long userId) {
        LOG.debug("getPossibleRideOptionsMock(), userId: " + userId);
        Assert.notNull(userId, "userId can not be null!");
        
        Map<Integer, List<RidePoint>> possibletravelOptions = new HashMap<>();  
        
        List<RidePoint> toList1 = new ArrayList<>();
        toList1.add(new RidePoint(VehicleTypeEnum.CAR, getTimeMinusMinutes(45), new LatLon(4.968046, -94.420307)));
        toList1.add(new RidePoint(VehicleTypeEnum.DRIVE_SHARE, getTimeMinusMinutes(25), new LatLon(44.33328, -89.132008)));
        
        List<RidePoint> toList2 = new ArrayList<>();
        toList2.add(new RidePoint(VehicleTypeEnum.BIKE, getTimeMinusMinutes(43), new LatLon(4.968046, -94.420307)));
        toList2.add(new RidePoint(VehicleTypeEnum.BIKE, getTimeMinusMinutes(30), new LatLon(44.33328, -89.132008)));
        toList2.add(new RidePoint(VehicleTypeEnum.TRAIN, getTimeMinusMinutes(16), new LatLon(44.31328, -89.122008)));
        
        List<RidePoint> toList3 = new ArrayList<>();
        toList3.add(new RidePoint(VehicleTypeEnum.BIKE, getTimeMinusMinutes(51), new LatLon(4.958046, -94.420307)));
        toList3.add(new RidePoint(VehicleTypeEnum.DRIVE_SHARE, getTimeMinusMinutes(25), new LatLon(44.32328, -89.132008)));
        
        possibletravelOptions.put(1, toList1);
        possibletravelOptions.put(2, toList2);       
        possibletravelOptions.put(3, toList3); 
        return possibletravelOptions;        
    }
    
    public List<RidePoint> getRideOptionsMock(Long userId, Long priorityId) {
        LOG.debug("getRideOptionsMock(), userId: " + userId + "priorityId: " + priorityId);
        Assert.notNull(userId, "userId can not be null!");
        Assert.notNull(priorityId, "userId can not be null!");
        
        List<RidePoint> rideOptions = new ArrayList<>();
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, getTimeMinusMinutes(45), new LatLon(4.968046, -94.420307)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, getTimeMinusMinutes(40), new LatLon(4.968056, -94.420317)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, getTimeMinusMinutes(38), new LatLon(4.968066, -94.420317)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, getTimeMinusMinutes(36), new LatLon(4.968076, -94.420327)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, getTimeMinusMinutes(32), new LatLon(4.968086, -94.420327)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, getTimeMinusMinutes(29), new LatLon(4.968096, -94.420327)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, getTimeMinusMinutes(27), new LatLon(4.968007, -94.420337)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.BUS, getTimeMinusMinutes(24), new LatLon(44.33328, -89.132008)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.BUS, getTimeMinusMinutes(22), new LatLon(44.33338, -89.132006)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.BUS, getTimeMinusMinutes(20), new LatLon(44.33348, -89.132005)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.BUS, getTimeMinusMinutes(19), new LatLon(44.33358, -89.132002)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.BUS, getTimeMinusMinutes(17), new LatLon(44.33368, -89.132012)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.BUS, getTimeMinusMinutes(14), new LatLon(44.33378, -89.132043)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.BUS, getTimeMinusMinutes(10), new LatLon(44.33388, -89.132056)));
        
        return rideOptions;        
    }
    
    public List<RidePoint> getRideOptionsWithDriveShareMock(Long userId, Long priorityId) {
        LOG.debug("getRideOptionsWithDriveShareMock(), userId: " + userId + "priorityId: " + priorityId);
        Assert.notNull(userId, "userId can not be null!");
        Assert.notNull(priorityId, "userId can not be null!");
        
        List<RidePoint> rideOptions = new ArrayList<>();
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, LocalDateTime.now().minusMinutes(45).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(4.968046, -94.420307)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, LocalDateTime.now().minusMinutes(40).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(4.968056, -94.420317)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, LocalDateTime.now().minusMinutes(38).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(4.968066, -94.420317)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, LocalDateTime.now().minusMinutes(36).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(4.968076, -94.420327)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, LocalDateTime.now().minusMinutes(32).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(4.968086, -94.420327)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, LocalDateTime.now().minusMinutes(29).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(4.968096, -94.420327)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.CAR, LocalDateTime.now().minusMinutes(27).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(4.968007, -94.420337)));
        rideOptions.add(new RidePoint(VehicleTypeEnum.DRIVE_SHARE, LocalDateTime.now().minusMinutes(24).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(44.33328, -89.132008), 25l, 145l));
        rideOptions.add(new RidePoint(VehicleTypeEnum.DRIVE_SHARE, LocalDateTime.now().minusMinutes(22).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(44.33338, -89.132006), 25l, 145l));
        rideOptions.add(new RidePoint(VehicleTypeEnum.DRIVE_SHARE, LocalDateTime.now().minusMinutes(20).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(44.33348, -89.132005), 25l, 145l));
        rideOptions.add(new RidePoint(VehicleTypeEnum.DRIVE_SHARE, LocalDateTime.now().minusMinutes(19).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(44.33358, -89.132002), 25l, 145l));
        rideOptions.add(new RidePoint(VehicleTypeEnum.DRIVE_SHARE, LocalDateTime.now().minusMinutes(17).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(44.33368, -89.132012), 25l, 145l));
        rideOptions.add(new RidePoint(VehicleTypeEnum.DRIVE_SHARE, LocalDateTime.now().minusMinutes(14).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(44.33378, -89.132043), 25l, 145l));
        rideOptions.add(new RidePoint(VehicleTypeEnum.DRIVE_SHARE, LocalDateTime.now().minusMinutes(10).toInstant(ZoneOffset.UTC).toEpochMilli(), new LatLon(44.33388, -89.132056), 25l, 145l));
        
        return rideOptions;        
    }
    
    public void assignUser(Long userId, Long priorityId) {
        LOG.debug("assignUser()");
        Assert.notNull(userId, "userId can not be null!"); 
        Assert.notNull(priorityId, "priorityId can not be null!");
        LOG.debug("userId: " + userId);
        LOG.debug("priorityId: " + priorityId);
        
        //assign this user to his desired option
        List<RidePoint> selectedOption = getRideOptionsMock(userId, priorityId);
        store.getEmployeeSelectedRides().put(userId, selectedOption);
        
        //if selected ride contains drive share then assign to drive share group for driver 
        Optional<RidePoint> rpDriveShare = selectedOption.stream().filter(ridePointIsDriveShare()).findFirst(); //here we take in consideration only the option that he never jumps to other car share!
        
        if (rpDriveShare.isPresent()) {
        	if(!store.getDriveShareGroups().containsKey(rpDriveShare.get().getDriverId())) {
        		store.getDriveShareGroups().put(rpDriveShare.get().getDriverId(), new ArrayList<RidePoint>());	
        	}
        	store.getDriveShareGroups().get(rpDriveShare.get().getDriverId()).add(rpDriveShare.get());
        }
        
        //create user (employee or driver) group for each point he went through so we can get an information who is traveling with who
        store.getRidePointGroups().put(userId, new HashMap<RidePointIndex, Set<Long>>());
        
        for(RidePoint rp: selectedOption) {
        	RidePointIndex idx = rp.toIndex();
        	store.getRidePointGroups().get(userId).put(idx, new HashSet<Long>());
        	
        	store.getRidePointGroups().forEach((k,v)-> {
        		if(v.containsKey(idx)) {
        			if(!k.equals(userId)) {
        				//add curent user to this group
        				v.get(idx).add(userId);
        				if(store.getRidePointGroups().get(userId).get(idx).isEmpty()) {
        					//add current user all users that are traveling with him
        					store.getRidePointGroups().get(userId).get(idx).addAll(v.get(idx));
        				}
        			}
        		}
        	});
        
        	//we need to create ridePointGroups also for drivers, these are not defined and must be created from list of employees rides
        	if(VehicleTypeEnum.DRIVE_SHARE.equals(rp.getVehicleType())) {
        		if(!store.getRidePointGroups().containsKey(rp.getDriverId())) {
        			store.getRidePointGroups().put(rp.getDriverId(), new HashMap<RidePointIndex, Set<Long>>());
        		}
        		if(!store.getRidePointGroups().get(rp.getDriverId()).containsKey(idx)) {
        			store.getRidePointGroups().get(rp.getDriverId()).put(idx, new HashSet<Long>());
        		}
        		store.getRidePointGroups().get(rp.getDriverId()).get(idx).addAll(store.getRidePointGroups().get(userId).get(idx));
        	}
        }        
    }
    
    private Predicate<? super DriveShareGroup> findDriverWithEmployeeAndPosition(Long userId, Long driverId, LatLon latLon) {
    	return ug -> (driverId.equals(ug.getDriverId()) 
                && userId.equals(ug.getUserId())
                && latLon.equals(ug.getLatLon()));
    }
    
    
    private Long getTimeMinusMinutes(long minutes) {
    	return LocalDateTime.now().minusMinutes(minutes).toInstant(ZoneOffset.UTC).toEpochMilli();
    }
    
    private Predicate<? super RidePoint> ridePointIsDriveShare() {
    	return ro -> VehicleTypeEnum.DRIVE_SHARE.equals(ro.getVehicleType());
    }
    
    
}
