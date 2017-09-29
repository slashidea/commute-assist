package com.slashidea.commuteassist.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.slashidea.commuteassist.model.LatLon;
import com.slashidea.commuteassist.model.RideOption;
import com.slashidea.commuteassist.model.VehicleTypeEnum;

@Component
public class RideService {

    public Map<Integer, List<RideOption>> getPossibleRideOptionsMock(Long userId) {
        Map<Integer, List<RideOption>> possibletravelOptions = new HashMap<>();  
        
        List<RideOption> toList1 = new ArrayList<>();
        toList1.add(new RideOption(VehicleTypeEnum.CAR, System.currentTimeMillis(), new LatLon(4.968046, -94.420307)));
        toList1.add(new RideOption(VehicleTypeEnum.BIKE, System.currentTimeMillis(), new LatLon(44.33328, -89.132008)));
        toList1.add(new RideOption(VehicleTypeEnum.CAR, System.currentTimeMillis(), new LatLon(44.31328, -89.122008)));
        
        List<RideOption> toList2 = new ArrayList<>();
        toList2.add(new RideOption(VehicleTypeEnum.BIKE, System.currentTimeMillis(), new LatLon(4.968046, -94.420307)));
        toList2.add(new RideOption(VehicleTypeEnum.BIKE, System.currentTimeMillis(), new LatLon(44.33328, -89.132008)));
        toList2.add(new RideOption(VehicleTypeEnum.TRAIN, System.currentTimeMillis(), new LatLon(44.31328, -89.122008)));
        
        List<RideOption> toList3 = new ArrayList<>();
        toList3.add(new RideOption(VehicleTypeEnum.BIKE, System.currentTimeMillis(), new LatLon(4.958046, -94.420307)));
        toList3.add(new RideOption(VehicleTypeEnum.TRAIN, System.currentTimeMillis(), new LatLon(44.32328, -89.132008)));
        toList3.add(new RideOption(VehicleTypeEnum.TRAIN, System.currentTimeMillis(), new LatLon(44.32328, -89.122008)));
        
        possibletravelOptions.put(1, toList1);
        possibletravelOptions.put(2, toList2);       
        possibletravelOptions.put(3, toList3); 
        return possibletravelOptions;        
    }
    
}
