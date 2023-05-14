package org.com.factory.modelFactory;

import java.time.LocalDateTime;

import org.com.model.Booking;
import org.com.model.User;
import org.com.model.Vehicle;

public class BookingFactory {
    public static Booking createBooking(LocalDateTime startDate, LocalDateTime endDate) {
        return new Booking(startDate, endDate);
    }
}
