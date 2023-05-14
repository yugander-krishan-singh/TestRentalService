package org.com.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.com.dto.BookedVehicle;

public class Booking {
    private final String id;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private BookingStatus bookingStatus;
    private BookedVehicle vehicle;

    private float bookingPrice;

    public void setBookingPrice(float bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public Booking(LocalDateTime startDate, LocalDateTime endDate) {
        this.id = UUID.randomUUID().toString();
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingStatus = BookingStatus.IN_PROGRESS;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setVehicle(BookedVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BookedVehicle getVehicle() {
        return this.vehicle;
    }

    public float getBookingPrice() {
        return bookingPrice;
    }
}
