
package com.aljabali.exercise.hotels.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.ArrayList;
import java.util.List;

public class Offers {

    @JsonAlias("Hotel")
    private List<Hotel> hotel = new ArrayList<>();

    public List<Hotel> getHotel() {
        return hotel;
    }

    public Offers setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
        return this;
    }
}
