package org.com.inputManager;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import org.com.component.BranchComponent;
import org.com.dao.BranchDao;
import org.com.dao.IBranchDao;
import org.com.dao.IVehicleDao;
import org.com.dao.VehicleDao;
import org.com.exception.IncorrectPriceException;
import org.com.exception.IncorrectTimeException;
import org.com.exception.NoBranchExistsException;
import org.com.exception.VehicleNotFoundException;
import org.com.factory.inputFactory.ComponentFactory;
import org.com.factory.inputFactory.ServiceFactory;
import org.com.model.VehicleType;
import org.com.service.BranchService;
import org.com.service.VehicleService;
import org.com.util.CommonUtils;

public class InputManager {
    public static void handleAddBranch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Branch Name ");
        String branchName = scan.nextLine();
        BranchComponent branchComponent = new BranchComponent(ServiceFactory.getBranchService());
        branchComponent.addBranch(branchName);
    }

    public static void handleAllocatePrice()
            throws VehicleNotFoundException, NoBranchExistsException, IncorrectPriceException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter branch name");
        String branchName = scan.nextLine();

        System.out.println("Enter vehicle type");
        String vehicleType = scan.nextLine();

        System.out.println("Enter price");
        String price = scan.nextLine();

        Float vehiclePrice = null;
        try {
            vehiclePrice = Float.parseFloat(price);
        } catch(NumberFormatException e) {
            throw new IncorrectPriceException("Incorrect price entered");
        }

        ComponentFactory.getBranchComponent().allocatePrice(branchName, CommonUtils.getVehicleType(vehicleType), Float.parseFloat(price));
    }

    public static void handleAddVehicle() throws VehicleNotFoundException, NoBranchExistsException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter vehicle id");
        String vehicleId = scan.nextLine();

        System.out.println("Enter vehicle type");
        String vehicleType = scan.nextLine();

        System.out.println("Enter branch name");
        String branchName = scan.nextLine();

        ComponentFactory.getVehicleComponent().addVehicle(vehicleId, CommonUtils.getVehicleType(vehicleType), branchName);
    }

    public static void handleBookVehicle()
            throws IncorrectTimeException, NoBranchExistsException, VehicleNotFoundException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter vehicle type");
        String vehicleType = scan.nextLine();

        System.out.println("Enter start time hr. in 24 hr format using yyyy-MM-dd HH:mm:ss");
        String startDate = scan.nextLine();

        LocalDateTime startDateTime = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            startDateTime = LocalDateTime.parse(startDate, formatter);
        } catch(DateTimeParseException e) {
            throw new IncorrectTimeException("Start date-time is not of correct format");
        }

        System.out.println("Enter end time hr. in 24 hr format using yyyy-MM-dd HH:mm:ss");
        String endDate = scan.nextLine();

        LocalDateTime endDateTime = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            endDateTime = LocalDateTime.parse(endDate, formatter);
        } catch(DateTimeParseException e) {
            throw new IncorrectTimeException("End date-time is not of correct format");
        }

        ComponentFactory.getBookingComponent().bookVehicle(CommonUtils.getVehicleType(vehicleType), startDateTime, endDateTime);
    }
}
