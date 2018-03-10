
package com.aljabali.exercise.hotels.model;


public class FilterResponse {

    private final OfferInfo offerInfo = new OfferInfo();
    private final UserInfo userInfo = new UserInfo();
    private final Offers offers = new Offers();

    public OfferInfo getOfferInfo() {
        return offerInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public Offers getOffers() {
        return offers;
    }
}
