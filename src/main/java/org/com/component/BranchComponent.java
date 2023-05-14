package org.com.component;

import org.com.exception.NoBranchExistsException;
import org.com.exception.VehicleNotFoundException;
import org.com.model.Branch;
import org.com.model.VehicleType;
import org.com.service.BranchService;

public class BranchComponent {

    private final BranchService branchService;

    public BranchComponent(BranchService branchService) {
        this.branchService = branchService;
    }

    public void addBranch(String branchName) {
        this.branchService.addBranch(branchName);
    }

    public void allocatePrice(String branchName, VehicleType vehicleType, float price)
            throws VehicleNotFoundException, NoBranchExistsException {

        if(vehicleType == VehicleType.None) {
            // TODO: Move exception string to a ExceptionConstants class.
            throw new VehicleNotFoundException("Vehicle doesn't exist");
        }

        Branch branch = branchService.getBranchByName(branchName);
        if(branch == null) {
            throw new NoBranchExistsException("Branch not found");
        }

        this.branchService.setVehicleTypePriceForBranch(branchName, vehicleType, price);

        System.out.println("Vehicle price updated at branch for the vehicle type");
    }
}
