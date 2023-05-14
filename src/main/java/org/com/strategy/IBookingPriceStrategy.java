package org.com.strategy;

import java.time.LocalDateTime;

import org.com.dto.BookedVehicle;
import org.com.exception.NoBranchExistsException;
import org.com.exception.VehicleNotFoundException;
import org.com.model.Vehicle;
import org.com.model.VehicleType;

public interface IBookingPriceStrategy {
    BookedVehicle getVehicle(VehicleType vehicleType, LocalDateTime startDateTime, LocalDateTime endDateTime) throws NoBranchExistsException, VehicleNotFoundException;
}
