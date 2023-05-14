package org.com.factory.modelFactory;

import org.com.model.City;

public class CityFactory {
    public static City createCity(String cityName) {
        return new City(cityName);
    }
}
