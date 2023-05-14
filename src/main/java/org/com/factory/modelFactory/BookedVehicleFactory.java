package org.com.factory.modelFactory;

import org.com.dto.BookedVehicle;
import org.com.model.Vehicle;

public class BookedVehicleFactory {

    public static BookedVehicle getBookedVehicle(Vehicle bookingVehicle, float vehicleBookingPricePerDay) {
        return new BookedVehicle(bookingVehicle, vehicleBookingPricePerDay);
    }
}
