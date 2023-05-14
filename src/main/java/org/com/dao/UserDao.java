package org.com.dao;

import java.util.HashMap;
import java.util.Map;

import org.com.model.User;

public class UserDao implements IUserDao {
    private final Map<String, User> userMap;

    public UserDao() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void store(User user) {
        this.userMap.put(user.getId(), user);
    }
}
