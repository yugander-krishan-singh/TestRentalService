package org.com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Branch {
    private final String id;
    private final String name;
    private final String cityId;
    private final Map<VehicleType, List<Vehicle>> availableVehicleMap;

    private final Map<VehicleType, List<Vehicle>> bookedVehicleMap;

    private final Map<VehicleType, Float> vehicleTypePriceMap;

    public Branch(String branchName, String cityId) {
        this.id = UUID.randomUUID().toString();
        this.name = branchName;
        this.cityId = cityId;
        this.availableVehicleMap = new HashMap<>();
        this.vehicleTypePriceMap = new HashMap<>();
        this.bookedVehicleMap = new HashMap<>();

        updateBookedVehiclesMap();
        updateAvailableVehiclesMap();
        updateVehicleTypePriceMap();
    }

    private void updateBookedVehiclesMap() {
        for(VehicleType vehicleType: VehicleType.values()) {
            this.bookedVehicleMap.put(vehicleType, new ArrayList<>());
        }
    }

    private void updateAvailableVehiclesMap() {
        for(VehicleType vehicleType: VehicleType.values()) {
            this.availableVehicleMap.put(vehicleType, new ArrayList<>());
        }
    }

    private void updateVehicleTypePriceMap() {
        for(VehicleType vehicleType: VehicleType.values()) {
            this.vehicleTypePriceMap.put(vehicleType, Float.MAX_VALUE);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCityId() {
        return cityId;
    }

    public Map<VehicleType, List<Vehicle>> getAvailableVehicleMap() {
        return availableVehicleMap;
    }

    public Map<VehicleType, List<Vehicle>> getBookedVehicleMap() {
        return bookedVehicleMap;
    }
    public Map<VehicleType, Float> getVehicleTypePriceMap() {
        return vehicleTypePriceMap;
    }
}
