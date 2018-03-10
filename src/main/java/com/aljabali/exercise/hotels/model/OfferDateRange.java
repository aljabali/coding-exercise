
package com.aljabali.exercise.hotels.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OfferDateRange {

    private List<Integer> travelStartDate = null;
    private List<Integer> travelEndDate = null;
    private Integer lengthOfStay;

    public Date wrapTravelStartDate() {
        return Objects.isNull(travelStartDate) ? null : toDate(travelStartDate);
    }

    public Date wrapTravelEndDate() {
        return Objects.isNull(travelStartDate) ? null : toDate(travelEndDate);
    }

    private Date toDate(List<Integer> integerArray) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, integerArray.get(0));
        calendar.set(Calendar.MONTH, integerArray.get(1));
        calendar.set(Calendar.DAY_OF_YEAR, integerArray.get(2));
        return calendar.getTime();
    }

    public Integer getLengthOfStay() {
        return lengthOfStay;
    }

    public List<Integer> getTravelStartDate() {
        return travelStartDate;
    }

    public OfferDateRange setTravelStartDate(List<Integer> travelStartDate) {
        this.travelStartDate = travelStartDate;
        return this;
    }

    public List<Integer> getTravelEndDate() {
        return travelEndDate;
    }

    public OfferDateRange setTravelEndDate(List<Integer> travelEndDate) {
        this.travelEndDate = travelEndDate;
        return this;
    }

    public OfferDateRange setLengthOfStay(Integer lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
        return this;
    }
}
