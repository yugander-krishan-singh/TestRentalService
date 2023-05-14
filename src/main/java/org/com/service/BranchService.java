package org.com.service;

import static org.com.constant.AppConstants.cityId;

import java.util.ArrayList;
import java.util.List;

import org.com.dao.IBranchDao;
import org.com.factory.modelFactory.BranchFactory;
import org.com.model.Branch;
import org.com.model.Vehicle;
import org.com.model.VehicleType;

public class BranchService {

    private final IBranchDao branchDao;

    public BranchService(IBranchDao branchDao) {
        this.branchDao = branchDao;
    }

    public void addBranch(String branchName) {
        final Branch branch = BranchFactory.createBranch(branchName, cityId);
        branchDao.storeBranch(branch);
    }

    public void setVehicleTypePriceForBranch(String branchName, VehicleType vehicleType, Float price) {
        final Branch branch = this.branchDao.getBranchByName(branchName);
        branch.getVehicleTypePriceMap().put(vehicleType, price);
    }

    public List<Branch> getAllBranches() {
        return this.branchDao.getAllBranches();
    }

    public Branch getBranchByName(String branchName) {
        return branchDao.getBranchByName(branchName);
    }

    public void addVehicleToBranch(Vehicle vehicle, String branchName) {
        final Branch branch = this.branchDao.getBranchByName(branchName);

        branch.getAvailableVehicleMap().putIfAbsent(vehicle.getVehicleType(), new ArrayList<>());
        branch.getAvailableVehicleMap().get(vehicle.getVehicleType()).add(vehicle);
    }
}
