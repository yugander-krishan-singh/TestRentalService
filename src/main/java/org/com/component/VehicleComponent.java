package org.com.component;

import org.com.exception.NoBranchExistsException;
import org.com.exception.VehicleNotFoundException;
import org.com.model.Branch;
import org.com.model.VehicleType;
import org.com.service.VehicleService;

public class VehicleComponent {
    private final VehicleService vehicleService;

    public VehicleComponent(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public void addVehicle(String vehicleId, VehicleType vehicleType, String branchName)
            throws VehicleNotFoundException, NoBranchExistsException {
        if(vehicleType == VehicleType.None) {
            // TODO: Move exception string to a ExceptionConstants class.
            throw new VehicleNotFoundException("Vehicle doesn't exist");
        }

        Branch branch = this.vehicleService.validateBranchForAVehicle(branchName);

        if(branch == null) {
            throw new NoBranchExistsException("Branch doesn't exist");
        }

        this.vehicleService.addVehicle(vehicleId, vehicleType, branchName);

        System.out.println("Vehicle added successfully");
    }
}
