package org.com.dao;

import java.util.HashMap;
import java.util.Map;

import org.com.model.City;

public class CityDao implements ICityDao {

    private final Map<String, City> cityIdMap;

    private final Map<String, City> cityNameMap;

    public CityDao() {
        this.cityIdMap = new HashMap<>();
        this.cityNameMap = new HashMap<>();
    }

    @Override
    public void store(City city) {
        this.cityIdMap.put(city.getId(), city);
    }

    @Override
    public City getCityById(String cityId) {
        return this.cityIdMap.get(cityId);
    }

    @Override
    public City getCityByName(String cityName) {
        return this.cityNameMap.get(cityName);
    }
}
