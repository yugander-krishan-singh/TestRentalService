package org.com.dao;

import java.util.HashMap;
import java.util.Map;

import org.com.model.Booking;

public class BookingDao implements IBookingDao {

    private final Map<String, Booking> bookingMap;

    public BookingDao() {
        this.bookingMap = new HashMap<>();
    }

    @Override
    public void store(Booking booking) {
        this.bookingMap.put(booking.getId(), booking);
    }
}
