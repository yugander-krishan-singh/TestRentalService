package org.com.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Locale;

import org.com.exception.IncorrectTimeException;
import org.com.model.VehicleType;

public class CommonUtils {
    public static VehicleType getVehicleType(String vehicleType) {
        return Arrays.stream(VehicleType.values())
                .filter(v -> v.name().equals(vehicleType.toUpperCase()))
                .findFirst()
                .orElse(VehicleType.None);
    }

    public static void testDat(String startDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
            System.out.println(startDateTime);
        } catch(DateTimeParseException e) {
            System.out.println(e.getErrorIndex());
        }
    }

    public static void main(String[] args) {
        String startdate = "2023-07-01 05:00:00";
        CommonUtils.testDat(startdate);
    }
}
