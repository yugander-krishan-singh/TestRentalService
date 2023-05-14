package org.com.service;

import org.com.dao.IVehicleDao;
import org.com.factory.modelFactory.VehicleFactory;
import org.com.model.Branch;
import org.com.model.Vehicle;
import org.com.model.VehicleType;

public class VehicleService {
    private final IVehicleDao vehicleDao;

    private final BranchService branchService;

    public VehicleService(IVehicleDao vehicleDao, BranchService branchService) {
        this.vehicleDao = vehicleDao;
        this.branchService = branchService;
    }

    public Vehicle addVehicle(String vehicleId, VehicleType vehicleType, String branchName) {
        final Vehicle vehicle = VehicleFactory.createVehicle(vehicleId, vehicleType, branchName);
        vehicleDao.store(vehicle);

        this.branchService.addVehicleToBranch(vehicle, branchName);

        return vehicle;
    }

    public Vehicle getVehicleById(String vehicleId) {
        // validate and throw VehicleNotFoundException

        return this.vehicleDao.getVehicleById(vehicleId);
    }

    public Branch validateBranchForAVehicle(String branchName) {
        return this.branchService.getBranchByName(branchName);
    }
}
