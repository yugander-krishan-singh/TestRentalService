package org.com.factory.inputFactory;

import org.com.dao.IBookingDao;
import org.com.dao.IBranchDao;
import org.com.dao.IVehicleDao;
import org.com.service.BookingService;
import org.com.service.BranchService;
import org.com.service.VehicleService;
import org.com.strategy.LowestPriceBookingStrategy;

public class ServiceFactory {
    private static BranchService branchService;

    private static VehicleService vehicleService;

    private static BookingService bookingService;

    public static synchronized BranchService getBranchService() {
        if(branchService == null) {
            IBranchDao branchDao = DaoFactory.getBranchDao();
            branchService = new BranchService(branchDao);
        }

        return branchService;
    }

    public static synchronized VehicleService getVehicleService() {
        if(vehicleService == null) {
            IVehicleDao vehicleDao = DaoFactory.getVehicleDao();
            vehicleService = new VehicleService(vehicleDao, getBranchService());
        }

        return vehicleService;
    }

    public static synchronized BookingService getBookingService() {
        if(bookingService == null) {
            IBookingDao bookingDao = DaoFactory.getBookingDao();
            bookingService = new BookingService(new LowestPriceBookingStrategy(getBranchService()), bookingDao);
        }

        return bookingService;
    }
}
