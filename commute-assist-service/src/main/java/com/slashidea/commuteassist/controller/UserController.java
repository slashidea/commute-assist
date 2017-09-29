package com.slashidea.commuteassist.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slashidea.commuteassist.model.Ride;
import com.slashidea.commuteassist.model.RideOption;
import com.slashidea.commuteassist.service.RideService;

@RestController
public class UserController {
    
    @Autowired
    private RideService rideService;

    @RequestMapping("/user/{userId}/ride/options")
    public List<Ride> possibleOptions(@PathVariable(value="userId", required=true) Long userId) {        
        Map<Integer, List<RideOption>> possibleOptions = rideService.getPossibleRideOptionsMock(userId);        
        List<Ride> result = new ArrayList<>();
        if (possibleOptions != null) {            
            result = possibleOptions.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                    .map(ro -> new Ride(ro.getKey(), ro.getValue())).collect(Collectors.toList());
        }
        return result;
    }
}
