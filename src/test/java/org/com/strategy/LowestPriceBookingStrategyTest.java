package org.com.strategy;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.com.constant.AppConstants;
import org.com.dto.BookedVehicle;
import org.com.exception.NoBranchExistsException;
import org.com.exception.VehicleNotFoundException;
import org.com.factory.modelFactory.BranchFactory;
import org.com.factory.modelFactory.VehicleFactory;
import org.com.model.Branch;
import org.com.model.Vehicle;
import org.com.model.VehicleType;
import org.com.service.BranchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class LowestPriceBookingStrategyTest {

    @Mock
    private BranchService mockedBranchService;

    @InjectMocks
    private LowestPriceBookingStrategy strategy;

    @Test
    public void testGetVehicleWithNoBranches() {
        when(mockedBranchService.getAllBranches()).thenReturn(null);

        Assertions.assertThrows(NoBranchExistsException.class, () -> strategy.getVehicle(VehicleType.SUV, LocalDateTime.now(), LocalDateTime.now()));
    }

    @Test
    public void testGetVehicleWithBranches() throws NoBranchExistsException, VehicleNotFoundException {
        List<Branch> branchList = new ArrayList<>();
        Branch b1 = BranchFactory.createBranch("branch1", AppConstants.cityId);
        b1.getVehicleTypePriceMap().put(VehicleType.Hatchback, 1000f);
        b1.getVehicleTypePriceMap().put(VehicleType.SUV, 300f);
        branchList.add(b1);
        when(mockedBranchService.getAllBranches()).thenReturn(branchList);

        Vehicle v1 = VehicleFactory.createVehicle("vehicle-id-1", VehicleType.SUV, b1.getId());
        b1.getAvailableVehicleMap().get(v1.getVehicleType()).add(v1);

        BookedVehicle returnedVehicle = strategy.getVehicle(VehicleType.SUV);

        assertNotNull(returnedVehicle);
        assertEquals(new BookedVehicle(v1, 0f), returnedVehicle);

    }
}
