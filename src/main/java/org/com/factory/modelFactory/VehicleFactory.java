package org.com.factory.modelFactory;

import org.com.model.Vehicle;
import org.com.model.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleId, VehicleType vehicleType, String branchId) {
        return new Vehicle(vehicleId, vehicleType, branchId);
    }
}
