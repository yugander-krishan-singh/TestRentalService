package org.com.factory.inputFactory;

import org.com.dao.BookingDao;
import org.com.dao.BranchDao;
import org.com.dao.IBookingDao;
import org.com.dao.IBranchDao;
import org.com.dao.IVehicleDao;
import org.com.dao.VehicleDao;

public class DaoFactory {
    private static IVehicleDao vehicleDao;
    private static IBranchDao branchDao;

    private static IBookingDao bookingDao;

    public static synchronized IVehicleDao getVehicleDao() {
        if(vehicleDao == null) {
            vehicleDao = new VehicleDao();
        }

        return vehicleDao;
    }

    public static synchronized IBranchDao getBranchDao() {
        if(branchDao == null) {
            branchDao = new BranchDao();
        }

        return branchDao;
    }

    public static synchronized IBookingDao getBookingDao() {
        if(bookingDao == null) {
            bookingDao = new BookingDao();
        }

        return bookingDao;
    }
}
