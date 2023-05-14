package org.com.model;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<City> cityList;

    public BookingSystem() {
        this.cityList = new ArrayList<>();
    }

    public List<City> getCityList() {
        return cityList;
    }
}
