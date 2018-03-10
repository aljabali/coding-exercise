package com.aljabali.exercise.hotels.services;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

class QueryParamsBuilder extends LinkedMultiValueMap<String, String> {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private MultiValueMap<String, String> uriVariables = new LinkedMultiValueMap<>();

    public QueryParamsBuilder() {
        uriVariables.add("scenario", "deal-finder");
        uriVariables.add("page", "foo");
        uriVariables.add("uid", "foo");
        uriVariables.add("productType", "Hotel");
    }

    public MultiValueMap<String, String> getQueryParamsMap() {
        return this.uriVariables;
    }

    public QueryParamsBuilder injectTripStartDateParams(Date minStartDate, Date maxStartDate) {
        if (Objects.nonNull(minStartDate))
            uriVariables.add("minTripStartDate", formatDate(minStartDate));

        if (Objects.nonNull(maxStartDate))
            uriVariables.add("maxTripStartDate", formatDate(maxStartDate));

        return this;
    }

    public QueryParamsBuilder injectDestinationCity(String destinationCity) {
        uriVariables.add("destinationCity", destinationCity);
        return this;
    }

    public QueryParamsBuilder injectLengthOfStay(long lengthOfStay) {
        if (lengthOfStay > 0)
            uriVariables.add("lengthOfStay", String.valueOf(lengthOfStay));

        return this;
    }

    private String formatDate(Date targetDate) {
        return simpleDateFormat.format(targetDate);
    }

}
