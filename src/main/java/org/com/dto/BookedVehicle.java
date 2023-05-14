package org.com.dto;

import org.com.model.Vehicle;

public class BookedVehicle {
    private final Vehicle vehicle;

    private final float bookingPricePerDay;

    public BookedVehicle(Vehicle vehicle, float bookingPrice) {
        this.vehicle = vehicle;
        this.bookingPricePerDay = bookingPrice;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public float getBookingPricePerDay() {
        return bookingPricePerDay;
    }
}
