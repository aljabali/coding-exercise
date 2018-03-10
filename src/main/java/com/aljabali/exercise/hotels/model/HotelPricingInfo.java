
package com.aljabali.exercise.hotels.model;


public class HotelPricingInfo {

    private Double averagePriceValue;
    private Double totalPriceValue;
    private Double crossOutPriceValue;
    private Double originalPricePerNight;
    private String currency;
    private Double percentSavings;
    private Boolean drr;

    public Double getAveragePriceValue() {
        return averagePriceValue;
    }

    public HotelPricingInfo setAveragePriceValue(Double averagePriceValue) {
        this.averagePriceValue = averagePriceValue;
        return this;
    }

    public Double getTotalPriceValue() {
        return totalPriceValue;
    }

    public HotelPricingInfo setTotalPriceValue(Double totalPriceValue) {
        this.totalPriceValue = totalPriceValue;
        return this;
    }

    public Double getCrossOutPriceValue() {
        return crossOutPriceValue;
    }

    public HotelPricingInfo setCrossOutPriceValue(Double crossOutPriceValue) {
        this.crossOutPriceValue = crossOutPriceValue;
        return this;
    }

    public Double getOriginalPricePerNight() {
        return originalPricePerNight;
    }

    public HotelPricingInfo setOriginalPricePerNight(Double originalPricePerNight) {
        this.originalPricePerNight = originalPricePerNight;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public HotelPricingInfo setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Double getPercentSavings() {
        return percentSavings;
    }

    public HotelPricingInfo setPercentSavings(Double percentSavings) {
        this.percentSavings = percentSavings;
        return this;
    }

    public Boolean getDrr() {
        return drr;
    }

    public HotelPricingInfo setDrr(Boolean drr) {
        this.drr = drr;
        return this;
    }
}
