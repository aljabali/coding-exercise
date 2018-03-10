
package com.aljabali.exercise.hotels.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelInfo {

    private String hotelId;
    private String hotelName;
    private String localizedHotelName;
    private String hotelDestination;
    private String hotelDestinationRegionID;
    private String hotelLongDestination;
    private String hotelStreetAddress;
    private String hotelCity;
    private String hotelProvince;
    private String hotelCountryCode;
    private Double hotelLatitude;
    private Double hotelLongitude;
    private Double hotelStarRating;
    private Double hotelGuestReviewRating;
    private Integer hotelReviewTotal;
    private String hotelImageUrl;
    private Boolean vipAccess;
    @JsonProperty("isOfficialRating")
    private Boolean officialRating;

    public String getHotelId() {
        return hotelId;
    }

    public HotelInfo setHotelId(String hotelId) {
        this.hotelId = hotelId;
        return this;
    }

    public String getHotelName() {
        return hotelName;
    }

    public HotelInfo setHotelName(String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public String getLocalizedHotelName() {
        return localizedHotelName;
    }

    public HotelInfo setLocalizedHotelName(String localizedHotelName) {
        this.localizedHotelName = localizedHotelName;
        return this;
    }

    public String getHotelDestination() {
        return hotelDestination;
    }

    public HotelInfo setHotelDestination(String hotelDestination) {
        this.hotelDestination = hotelDestination;
        return this;
    }

    public String getHotelDestinationRegionID() {
        return hotelDestinationRegionID;
    }

    public HotelInfo setHotelDestinationRegionID(String hotelDestinationRegionID) {
        this.hotelDestinationRegionID = hotelDestinationRegionID;
        return this;
    }

    public String getHotelLongDestination() {
        return hotelLongDestination;
    }

    public HotelInfo setHotelLongDestination(String hotelLongDestination) {
        this.hotelLongDestination = hotelLongDestination;
        return this;
    }

    public String getHotelStreetAddress() {
        return hotelStreetAddress;
    }

    public HotelInfo setHotelStreetAddress(String hotelStreetAddress) {
        this.hotelStreetAddress = hotelStreetAddress;
        return this;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public HotelInfo setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
        return this;
    }

    public String getHotelProvince() {
        return hotelProvince;
    }

    public HotelInfo setHotelProvince(String hotelProvince) {
        this.hotelProvince = hotelProvince;
        return this;
    }

    public String getHotelCountryCode() {
        return hotelCountryCode;
    }

    public HotelInfo setHotelCountryCode(String hotelCountryCode) {
        this.hotelCountryCode = hotelCountryCode;
        return this;
    }

    public Double getHotelLatitude() {
        return hotelLatitude;
    }

    public HotelInfo setHotelLatitude(Double hotelLatitude) {
        this.hotelLatitude = hotelLatitude;
        return this;
    }

    public Double getHotelLongitude() {
        return hotelLongitude;
    }

    public HotelInfo setHotelLongitude(Double hotelLongitude) {
        this.hotelLongitude = hotelLongitude;
        return this;
    }

    public Double getHotelStarRating() {
        return hotelStarRating;
    }

    public HotelInfo setHotelStarRating(Double hotelStarRating) {
        this.hotelStarRating = hotelStarRating;
        return this;
    }

    public Double getHotelGuestReviewRating() {
        return hotelGuestReviewRating;
    }

    public HotelInfo setHotelGuestReviewRating(Double hotelGuestReviewRating) {
        this.hotelGuestReviewRating = hotelGuestReviewRating;
        return this;
    }

    public Integer getHotelReviewTotal() {
        return hotelReviewTotal;
    }

    public HotelInfo setHotelReviewTotal(Integer hotelReviewTotal) {
        this.hotelReviewTotal = hotelReviewTotal;
        return this;
    }

    public String getHotelImageUrl() {
        return hotelImageUrl;
    }

    public HotelInfo setHotelImageUrl(String hotelImageUrl) {
        this.hotelImageUrl = hotelImageUrl;
        return this;
    }

    public Boolean getVipAccess() {
        return vipAccess;
    }

    public HotelInfo setVipAccess(Boolean vipAccess) {
        this.vipAccess = vipAccess;
        return this;
    }

    public Boolean getOfficialRating() {
        return officialRating;
    }

    public HotelInfo setOfficialRating(Boolean officialRating) {
        this.officialRating = officialRating;
        return this;
    }
}
