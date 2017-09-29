package com.slashidea.commuteassist.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.slashidea.commuteassist.model.Trackpoint;
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
                        
        store.getTrackpoints().add(trackpoint);
    }
    
}
