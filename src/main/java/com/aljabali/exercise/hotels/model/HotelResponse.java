package com.aljabali.exercise.hotels.model;

import java.util.Date;

public class HotelResponse {

    private final String hotelName;
    private final Double hotelLatitude;
    private final String hotelStreetAddress;
    private final Double hotelStarRating;
    private final Double hotelGuestReviewRating;
    private final long hotelReviewTotal;
    private final String hotelImageUrl;
    private final Date travelStartDate;
    private final Date travelEndDate;
    private final Integer lengthOfStay;

    public HotelResponse(Hotel hotel) {
        hotelName = hotel.getHotelInfo().getHotelName();
        hotelLatitude = hotel.getHotelInfo().getHotelLatitude();
        hotelStreetAddress = hotel.getHotelInfo().getHotelStreetAddress();
        hotelStarRating = hotel.getHotelInfo().getHotelStarRating();
        hotelGuestReviewRating = hotel.getHotelInfo().getHotelGuestReviewRating();
        hotelReviewTotal = hotel.getHotelInfo().getHotelReviewTotal();
        hotelImageUrl = hotel.getHotelInfo().getHotelImageUrl();
        travelStartDate = hotel.getOfferDateRange().wrapTravelStartDate();
        travelEndDate = hotel.getOfferDateRange().wrapTravelEndDate();
        lengthOfStay = hotel.getOfferDateRange().getLengthOfStay();
    }

    public String getHotelName() {
        return hotelName;
    }

    public Double getHotelLatitude() {
        return hotelLatitude;
    }

    public String getHotelStreetAddress() {
        return hotelStreetAddress;
    }

    public Double getHotelStarRating() {
        return hotelStarRating;
    }

    public Double getHotelGuestReviewRating() {
        return hotelGuestReviewRating;
    }

    public long getHotelReviewTotal() {
        return hotelReviewTotal;
    }

    public String getHotelImageUrl() {
        return hotelImageUrl;
    }

    public Date getTravelStartDate() {
        return travelStartDate;
    }

    public Date getTravelEndDate() {
        return travelEndDate;
    }

    public Integer getLengthOfStay() {
        return lengthOfStay;
    }

    @Override
    public String toString() {
        return "HotelResponse{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelLatitude=" + hotelLatitude +
                ", hotelStreetAddress='" + hotelStreetAddress + '\'' +
                ", hotelStarRating=" + hotelStarRating +
                ", hotelGuestReviewRating=" + hotelGuestReviewRating +
                ", hotelReviewTotal=" + hotelReviewTotal +
                ", hotelImageUrl='" + hotelImageUrl + '\'' +
                ", travelStartDate=" + travelStartDate +
                ", travelEndDate=" + travelEndDate +
                ", lengthOfStay=" + lengthOfStay +
                '}';
    }
}
