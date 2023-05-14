package org.com.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.com.dao.BookingDao;
import org.com.dao.IBookingDao;
import org.com.dto.BookedVehicle;
import org.com.exception.NoBranchExistsException;
import org.com.exception.VehicleNotFoundException;
import org.com.factory.modelFactory.BookingFactory;
import org.com.model.Booking;
import org.com.model.BookingStatus;
import org.com.model.Vehicle;
import org.com.model.VehicleType;
import org.com.strategy.IBookingPriceStrategy;

public class BookingService {

    private final IBookingPriceStrategy bookingPriceStrategy;

    private final IBookingDao bookingDao;

    public BookingService(IBookingPriceStrategy bookingPriceStrategy, IBookingDao bookingDao) {
        this.bookingPriceStrategy = bookingPriceStrategy;
        this.bookingDao = bookingDao;
    }

    public Booking bookVehicle(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime)
            throws NoBranchExistsException, VehicleNotFoundException {

        Booking currentBooking = BookingFactory.createBooking(startTime, endTime);

        BookedVehicle bookedVehicle = bookingPriceStrategy.getVehicle(vehicleType, startTime, endTime);

        if(bookedVehicle == null) {
            throw new VehicleNotFoundException("No vehicle exists for booking");
        }

        currentBooking.setVehicle(bookedVehicle);
        currentBooking.setBookingStatus(BookingStatus.CONFIRMED);

        float totalBookingPrice = calculatePrice(startTime, endTime, bookedVehicle.getBookingPricePerDay());
        currentBooking.setBookingPrice(totalBookingPrice);

        this.bookingDao.store(currentBooking);

        return currentBooking;
    }

    private float calculatePrice(LocalDateTime startDateTime, LocalDateTime endDateTime, float pricePerDay) {
        return Duration.between(startDateTime, endDateTime).toDays()*pricePerDay;
    }
}
