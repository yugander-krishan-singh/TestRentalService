package org.com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class City {
    private final String id;
    private final String cityName;
    private final Map<String, List<Branch>> cityBranchMap;

    public City(String cityName) {
        this.id = UUID.randomUUID().toString();
        this.cityName = cityName;
        this.cityBranchMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public Map<String, List<Branch>> getCityBranchMap() {
        return this.cityBranchMap;
    }
}
