package org.com.dao;

import org.com.model.City;

public interface ICityDao {
    void store(City city);

    City getCityById(String cityId);

    City getCityByName(String cityName);
}
