package org.com.dao;

import java.util.HashMap;
import java.util.Map;

import org.com.model.Vehicle;

public class VehicleDao implements IVehicleDao {

    private final Map<String, Vehicle> vehicleMap;

    public VehicleDao() {
        this.vehicleMap = new HashMap<>();
    }

    @Override
    public void store(Vehicle vehicle) {
        this.vehicleMap.put(vehicle.getVehicleId(), vehicle);
    }

    @Override
    public Vehicle getVehicleById(String vehicleId) {
        return this.vehicleMap.get(vehicleId);
    }
}
