package com.aljabali.exercise.hotels.services;

import com.aljabali.exercise.hotels.model.FilterRequest;
import com.aljabali.exercise.hotels.model.FilterResponse;
import com.aljabali.exercise.hotels.model.HotelResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class HotelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelService.class);

    @Value("${expedia.base-url}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<HotelResponse> doSearch(FilterRequest filterRequest) {
        MultiValueMap<String, String> queryParamsMap = buildQueryParamsMap(filterRequest);
        FilterResponse results = null;

        try {
            results = restTemplate.getForObject(buildUri(queryParamsMap).buildAndExpand(queryParamsMap).toUri(), FilterResponse.class);
        } catch (Exception e) {
            LOGGER.error("unable to retrieve data query [{}]", filterRequest, e);
        }

        if (Objects.isNull(results)) {
            results = new FilterResponse();
        }

        return results.getOffers().getHotel().stream().map(HotelResponse::new).collect(Collectors.toList());
    }

    private UriComponentsBuilder buildUri(MultiValueMap<String, String> queryParamsMap) {
        return UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .queryParams(queryParamsMap);
    }

    private MultiValueMap<String, String> buildQueryParamsMap(FilterRequest filterRequest) {
        QueryParamsBuilder queryParamsBuilder = new QueryParamsBuilder()
                .injectDestinationCity(filterRequest.getDestinationCity())
                .injectTripStartDateParams(filterRequest.getMinTripStartDate(), filterRequest.getMaxTripStartDate())
                .injectLengthOfStay(filterRequest.getLengthOfStay());
        return queryParamsBuilder.getQueryParamsMap();
    }

}
