
package com.aljabali.exercise.hotels.model;


public class Destination {

    private String regionID;
    private String associatedMultiCityRegionId;
    private String longName;
    private String shortName;
    private String country;
    private String province;
    private String city;
    private String tla;
    private String nonLocalizedCity;

    public String getRegionID() {
        return regionID;
    }

    public Destination setRegionID(String regionID) {
        this.regionID = regionID;
        return this;
    }

    public String getAssociatedMultiCityRegionId() {
        return associatedMultiCityRegionId;
    }

    public Destination setAssociatedMultiCityRegionId(String associatedMultiCityRegionId) {
        this.associatedMultiCityRegionId = associatedMultiCityRegionId;
        return this;
    }

    public String getLongName() {
        return longName;
    }

    public Destination setLongName(String longName) {
        this.longName = longName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public Destination setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Destination setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public Destination setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Destination setCity(String city) {
        this.city = city;
        return this;
    }

    public String getTla() {
        return tla;
    }

    public Destination setTla(String tla) {
        this.tla = tla;
        return this;
    }

    public String getNonLocalizedCity() {
        return nonLocalizedCity;
    }

    public Destination setNonLocalizedCity(String nonLocalizedCity) {
        this.nonLocalizedCity = nonLocalizedCity;
        return this;
    }
}
