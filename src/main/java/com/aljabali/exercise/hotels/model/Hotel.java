
package com.aljabali.exercise.hotels.model;


public class Hotel {

    private OfferDateRange offerDateRange;
    private Destination destination;
    private HotelInfo hotelInfo;
    private HotelPricingInfo hotelPricingInfo;
    private HotelUrls hotelUrls;


    public OfferDateRange getOfferDateRange() {
        return offerDateRange;
    }

    public Hotel setOfferDateRange(OfferDateRange offerDateRange) {
        this.offerDateRange = offerDateRange;
        return this;
    }

    public Destination getDestination() {
        return destination;
    }

    public Hotel setDestination(Destination destination) {
        this.destination = destination;
        return this;
    }

    public HotelInfo getHotelInfo() {
        return hotelInfo;
    }

    public Hotel setHotelInfo(HotelInfo hotelInfo) {
        this.hotelInfo = hotelInfo;
        return this;
    }

    public HotelPricingInfo getHotelPricingInfo() {
        return hotelPricingInfo;
    }

    public Hotel setHotelPricingInfo(HotelPricingInfo hotelPricingInfo) {
        this.hotelPricingInfo = hotelPricingInfo;
        return this;
    }

    public HotelUrls getHotelUrls() {
        return hotelUrls;
    }

    public Hotel setHotelUrls(HotelUrls hotelUrls) {
        this.hotelUrls = hotelUrls;
        return this;
    }
}
