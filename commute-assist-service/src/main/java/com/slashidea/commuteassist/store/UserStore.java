package com.slashidea.commuteassist.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.slashidea.commuteassist.model.User;
import com.slashidea.commuteassist.model.UserGroup;

public class UserStore {

    private Map<Long, User> users = new HashMap<>();
    private List<UserGroup> userGroup = new ArrayList<>();
    
    public UserStore() {
        
    }

    public Map<Long, User> getUsers() {
        return users;
    }

    public List<UserGroup> getUserGroup() {
        return userGroup;
    }

}
