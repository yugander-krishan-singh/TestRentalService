package org.com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final List<Booking> bookingList;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.bookingList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }
}
