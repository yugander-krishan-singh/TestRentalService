package org.com.factory.inputFactory;

import org.com.component.BookingComponent;
import org.com.component.BranchComponent;
import org.com.component.VehicleComponent;

public class ComponentFactory {

    private static BranchComponent branchComponent;

    private static VehicleComponent vehicleComponent;

    private static BookingComponent bookingComponent;

    public static BranchComponent getBranchComponent() {
        if(branchComponent == null) {
            branchComponent = new BranchComponent(ServiceFactory.getBranchService());
        }

        return branchComponent;
    }

    public static VehicleComponent getVehicleComponent() {
        if(vehicleComponent == null) {
            vehicleComponent = new VehicleComponent(ServiceFactory.getVehicleService());
        }

        return vehicleComponent;
    }

    public static BookingComponent getBookingComponent() {
        if(bookingComponent == null) {
            bookingComponent = new BookingComponent(ServiceFactory.getBookingService());
        }

        return bookingComponent;
    }
}
