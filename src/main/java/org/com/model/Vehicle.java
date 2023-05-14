package org.com.model;

import java.util.UUID;

public class Vehicle {
    private String vehicleId;
    private VehicleType vehicleType;
    private String branchId;

    public Vehicle(String vehicleId, VehicleType vehicleType, String branchId) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.branchId = branchId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
}
