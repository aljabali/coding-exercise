package com.aljabali.exercise.hotels.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class FilterRequest {

    private String destinationName;
    private String destinationCountry;

    @NotEmpty
    private String destinationCity;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minTripStartDate = defaultFilterDate(1);

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxTripStartDate = defaultFilterDate(2);

    private long lengthOfStay = 1l;
    private String minStarRating;
    private String maxStarRating;
    private String minTotalRate;
    private String maxTotalRate;
    private String minGuestRating;
    private String maxGuestRating;


    private Date defaultFilterDate(int extraDays) {
        return Date.from(LocalDate.now().plusDays(extraDays).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public String getDestinationName() {
        return destinationName;
    }

    public FilterRequest setDestinationName(String destinationName) {
        this.destinationName = destinationName;
        return this;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public FilterRequest setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
        return this;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public FilterRequest setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
        return this;
    }

    public Date getMinTripStartDate() {
        return minTripStartDate;
    }

    public FilterRequest setMinTripStartDate(Date minTripStartDate) {
        this.minTripStartDate = minTripStartDate;
        return this;
    }

    public Date getMaxTripStartDate() {
        return maxTripStartDate;
    }

    public FilterRequest setMaxTripStartDate(Date maxTripStartDate) {
        this.maxTripStartDate = maxTripStartDate;
        return this;
    }

    public long getLengthOfStay() {
        return lengthOfStay;
    }

    public FilterRequest setLengthOfStay(long lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
        return this;
    }

    public String getMinStarRating() {
        return minStarRating;
    }

    public FilterRequest setMinStarRating(String minStarRating) {
        this.minStarRating = minStarRating;
        return this;
    }

    public String getMaxStarRating() {
        return maxStarRating;
    }

    public FilterRequest setMaxStarRating(String maxStarRating) {
        this.maxStarRating = maxStarRating;
        return this;
    }

    public String getMinTotalRate() {
        return minTotalRate;
    }

    public FilterRequest setMinTotalRate(String minTotalRate) {
        this.minTotalRate = minTotalRate;
        return this;
    }

    public String getMaxTotalRate() {
        return maxTotalRate;
    }

    public FilterRequest setMaxTotalRate(String maxTotalRate) {
        this.maxTotalRate = maxTotalRate;
        return this;
    }

    public String getMinGuestRating() {
        return minGuestRating;
    }

    public FilterRequest setMinGuestRating(String minGuestRating) {
        this.minGuestRating = minGuestRating;
        return this;
    }

    public String getMaxGuestRating() {
        return maxGuestRating;
    }

    public FilterRequest setMaxGuestRating(String maxGuestRating) {
        this.maxGuestRating = maxGuestRating;
        return this;
    }

    @Override
    public String toString() {
        return "FilterRequest{" +
                "destinationName='" + destinationName + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", minTripStartDate=" + minTripStartDate +
                ", maxTripStartDate=" + maxTripStartDate +
                ", lengthOfStay=" + lengthOfStay +
                ", minStarRating='" + minStarRating + '\'' +
                ", maxStarRating='" + maxStarRating + '\'' +
                ", minTotalRate='" + minTotalRate + '\'' +
                ", maxTotalRate='" + maxTotalRate + '\'' +
                ", minGuestRating='" + minGuestRating + '\'' +
                ", maxGuestRating='" + maxGuestRating + '\'' +
                '}';
    }
}
