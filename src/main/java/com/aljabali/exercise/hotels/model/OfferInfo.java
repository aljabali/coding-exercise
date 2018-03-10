
package com.aljabali.exercise.hotels.model;


public class OfferInfo {

    private String siteID;
    private String language;
    private String currency;
    private String userSelectedCurrency;


    public String getSiteID() {
        return siteID;
    }

    public OfferInfo setSiteID(String siteID) {
        this.siteID = siteID;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public OfferInfo setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public OfferInfo setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getUserSelectedCurrency() {
        return userSelectedCurrency;
    }

    public OfferInfo setUserSelectedCurrency(String userSelectedCurrency) {
        this.userSelectedCurrency = userSelectedCurrency;
        return this;
    }
}
