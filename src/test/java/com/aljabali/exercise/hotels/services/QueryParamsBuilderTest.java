package com.aljabali.exercise.hotels.services;

import com.aljabali.exercise.hotels.model.FilterRequest;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueryParamsBuilderTest {

    @Test
    public void givenFilterRequestWithTripDates_whenBuildMap_thenReturnMapWithTripDates() {
        FilterRequest filterRequest = new FilterRequest().setDestinationCity("Amman");
        QueryParamsBuilder queryParamsBuilder = new QueryParamsBuilder()
                .injectDestinationCity(filterRequest.getDestinationCity())
                .injectTripStartDateParams(filterRequest.getMinTripStartDate(), filterRequest.getMaxTripStartDate())
                .injectLengthOfStay(filterRequest.getLengthOfStay());
        assertTrue(queryParamsBuilder.getQueryParamsMap().containsKey("minTripStartDate"));
        assertTrue(queryParamsBuilder.getQueryParamsMap().containsKey("maxTripStartDate"));

    }

    @Test
    public void givenNullTripDates_whenBuildMap_thenReturnMapWithoutTripDates() {
        FilterRequest filterRequest = new FilterRequest().setDestinationCity("Amman").setMinTripStartDate(null).setMaxTripStartDate(null);
        QueryParamsBuilder queryParamsBuilder = new QueryParamsBuilder()
                .injectDestinationCity(filterRequest.getDestinationCity())
                .injectTripStartDateParams(filterRequest.getMinTripStartDate(), filterRequest.getMaxTripStartDate())
                .injectLengthOfStay(filterRequest.getLengthOfStay());
        assertFalse(queryParamsBuilder.getQueryParamsMap().containsKey("minTripStartDate"));
        assertFalse(queryParamsBuilder.getQueryParamsMap().containsKey("maxTripStartDate"));

    }
}