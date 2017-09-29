package com.slashidea.commuteassist.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.slashidea.commuteassist.model.ShiftMessage;
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
        
        shiftMessage.setUserId(userId); 
                        
        store.getShiftMessages().add(shiftMessage);
    }
    
}
