package com.aljabali.exercise.hotels.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class FilterRequest {

    private String destinationName;
    private String destinationCountry;
    private String destinationCity;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minTripStartDate = defaultFilterDate(1);

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxTripStartDate = defaultFilterDate(2);

    private long lengthOfStay = 1l;

    @DecimalMin(value = "0")
    @DecimalMax(value = "7")
    private Double minStarRating;

    @DecimalMin(value = "0")
    @DecimalMax(value = "7")
    private Double maxStarRating;

    @DecimalMin(value = "0")
    private Double minTotalRate;

    @DecimalMin(value = "0")
    private Double maxTotalRate;


    @DecimalMin(value = "0")
    @DecimalMax(value = "10")
    private Double minGuestRating;

    @DecimalMin(value = "0")
    @DecimalMax(value = "10")
    private Double maxGuestRating;


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

    public Double getMinStarRating() {
        return minStarRating;
    }

    public FilterRequest setMinStarRating(Double minStarRating) {
        this.minStarRating = minStarRating;
        return this;
    }

    public Double getMaxStarRating() {
        return maxStarRating;
    }

    public FilterRequest setMaxStarRating(Double maxStarRating) {
        this.maxStarRating = maxStarRating;
        return this;
    }

    public Double getMinTotalRate() {
        return minTotalRate;
    }

    public FilterRequest setMinTotalRate(Double minTotalRate) {
        this.minTotalRate = minTotalRate;
        return this;
    }

    public Double getMaxTotalRate() {
        return maxTotalRate;
    }

    public FilterRequest setMaxTotalRate(Double maxTotalRate) {
        this.maxTotalRate = maxTotalRate;
        return this;
    }

    public Double getMinGuestRating() {
        return minGuestRating;
    }

    public FilterRequest setMinGuestRating(Double minGuestRating) {
        this.minGuestRating = minGuestRating;
        return this;
    }

    public Double getMaxGuestRating() {
        return maxGuestRating;
    }

    public FilterRequest setMaxGuestRating(Double maxGuestRating) {
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
