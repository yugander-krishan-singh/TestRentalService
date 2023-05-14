package org.com.strategy;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.com.dto.BookedVehicle;
import org.com.exception.NoBranchExistsException;
import org.com.exception.VehicleNotFoundException;
import org.com.factory.modelFactory.BookedVehicleFactory;
import org.com.model.Branch;
import org.com.model.Vehicle;
import org.com.model.VehicleType;
import org.com.service.BranchService;

public class LowestPriceBookingStrategy implements IBookingPriceStrategy{
    private final BranchService branchService;

    public LowestPriceBookingStrategy(BranchService branchService) {
        this.branchService = branchService;
    }

    @Override
    public synchronized BookedVehicle getVehicle(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime)
            throws NoBranchExistsException, VehicleNotFoundException {
        List<Branch> branchList = this.branchService.getAllBranches();

        /*
        1. Sort branches by price for the vehicle type
        2. Go over each branch
        3. Get list of unavailable vehicle for a branch from BookingDAO for a branch
        4. Check if anything is available post removing them
        5. If nothing is left compare the startTime and endTime to see if there are no overlapping intervals for the time

        just sort booking by startTime and use binarySort. Once u get the location just compare the startTime is > endTime of prev and endTime is < startTime of next
        Just check the corner case where the interval startTime is less than 0 index or greater than last index just need to do one comparison in that case

         */

        if(branchList == null || branchList.isEmpty()) {
            throw new NoBranchExistsException("There are no branches available");
        }

        return updateBookedVehicleList(vehicleType, branchList, startTime, endTime);
    }

    public BookedVehicle updateBookedVehicleList(VehicleType vehicleType, List<Branch> branchList, LocalDateTime startTime, LocalDateTime endTime)
            throws VehicleNotFoundException {
        Branch outBranch = getBranchHavingLowestPriceVehicle(vehicleType, branchList);

        if(!outBranch.getAvailableVehicleMap().containsKey(vehicleType)) {
            throw new VehicleNotFoundException("No vehicle of given type present in branch");
        }

        List<Vehicle> availableVehicleList = outBranch.getAvailableVehicleMap().get(vehicleType);
        List<Vehicle> bookedVehicleList = outBranch.getBookedVehicleMap().get(vehicleType);

        Vehicle bookingVehicle = availableVehicleList.remove(availableVehicleList.size()-1);

        if(bookingVehicle != null) {
            bookedVehicleList.add(bookingVehicle);
            return BookedVehicleFactory
                    .getBookedVehicle(bookingVehicle,
                            outBranch.getVehicleTypePriceMap().get(bookingVehicle.getVehicleType()
                            ));
        }

        return null;
    }

    public Branch getBranchHavingLowestPriceVehicle(VehicleType vehicleType, List<Branch> branchList) {
        Branch outBranch = null;

        branchList.sort(new Comparator<Branch>() {
            @Override
            public int compare(Branch o1, Branch o2) {
                return (int) (o1.getVehicleTypePriceMap().get(vehicleType) - o2.getVehicleTypePriceMap().get(
                        vehicleType));
            }
        });

        for(Branch branch: branchList) {
            Map<VehicleType, List<Vehicle>> availableVehicleMap = branch.getAvailableVehicleMap();

            if(availableVehicleMap.get(vehicleType).isEmpty()) {
                // check for bookedvehicle map and see if booked vehicle start and end
                continue;
            }

            if(outBranch == null) {
                outBranch = branch;
            } else {
                float currentOutPrice = outBranch.getVehicleTypePriceMap().get(vehicleType);
                float currentBranchPrice = branch.getVehicleTypePriceMap().get(vehicleType);

                if(currentBranchPrice < currentOutPrice) {
                    outBranch = branch;
                }
            }
        }
        return outBranch;
    }
}
