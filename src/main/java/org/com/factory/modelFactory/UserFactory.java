package org.com.factory.modelFactory;

import org.com.model.User;

public class UserFactory {

    public static User createUser(String name) {
        return new User(name);
    }
}
