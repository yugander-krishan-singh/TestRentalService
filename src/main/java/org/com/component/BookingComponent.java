package org.com.component;

import java.time.LocalDateTime;

import org.com.exception.IncorrectTimeException;
import org.com.exception.NoBranchExistsException;
import org.com.exception.VehicleNotFoundException;
import org.com.model.Booking;
import org.com.model.VehicleType;
import org.com.service.BookingService;

public class BookingComponent {

    private final BookingService bookingService;

    public BookingComponent(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void bookVehicle(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime)
            throws VehicleNotFoundException, NoBranchExistsException, IncorrectTimeException {
        if(vehicleType == VehicleType.None) {
            // TODO: Move exception string to a ExceptionConstants class.
            throw new VehicleNotFoundException("Vehicle doesn't exist");
        }

        if(startTime.isBefore(LocalDateTime.now())) {
            throw new IncorrectTimeException("Start Date-time is before current time");
        }

        if(endTime.isBefore(LocalDateTime.now())) {
            throw new IncorrectTimeException("End Date-time is before current time");
        }

        if(endTime.isBefore(startTime)) {
            throw new IncorrectTimeException("End Date-time is before start time");
        }

        Booking booking = this.bookingService.bookVehicle(vehicleType, startTime, endTime);
        System.out.println("booking successful for total price " + booking.getBookingPrice());
    }
}
