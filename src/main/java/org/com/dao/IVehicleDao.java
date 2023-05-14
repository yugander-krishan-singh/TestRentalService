package org.com.dao;

import org.com.model.Vehicle;

public interface IVehicleDao {
    void store(Vehicle vehicle);

    Vehicle getVehicleById(String vehicleId);
}
