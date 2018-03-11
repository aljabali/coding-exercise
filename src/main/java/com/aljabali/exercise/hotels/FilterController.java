package com.aljabali.exercise.hotels;

import com.aljabali.exercise.hotels.model.FilterRequest;
import com.aljabali.exercise.hotels.model.HotelResponse;
import com.aljabali.exercise.hotels.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class FilterController {

    private static final String FILTER_VIEW = "hotel-filter";
    private static final String HOTEL_RESULTS_VIEW = "hotel-results";

    @Autowired
    private HotelService hotelService;

    @GetMapping("/")
    public String initFilter(Model model) {
        model.addAttribute("filterRequest", new FilterRequest());
        return FILTER_VIEW;
    }

    @GetMapping("/hotel-filter")
    public String doFilter(@ModelAttribute @Valid FilterRequest filterRequest, BindingResult bindingResult, Model model) {
        return filterAndForward(filterRequest, bindingResult, model);
    }

    private String filterAndForward(FilterRequest filterRequest, BindingResult bindingResult, Model model) {
        technicalValidation(filterRequest, bindingResult);
        String resultView = FILTER_VIEW;

        if (!bindingResult.hasErrors()) {
            List<HotelResponse> hotels = hotelService.doSearch(filterRequest);
            if (!hotels.isEmpty()) {
                model.addAttribute("hotelDeals", hotels);
                resultView = HOTEL_RESULTS_VIEW;
            } else {
                model.addAttribute("noDeals", true);
            }
        }

        return resultView;
    }

    private void technicalValidation(FilterRequest filterRequest, BindingResult bindingResult) {
        validateAnyDestinationProvided(filterRequest, bindingResult);
        validateTripStartDate(filterRequest, bindingResult);
        validateRange(filterRequest.getMinStarRating(), filterRequest.getMaxStarRating(), "minStarRating", bindingResult);
        validateRange(filterRequest.getMinTotalRate(), filterRequest.getMaxTotalRate(), "minTotalRate", bindingResult);
        validateRange(filterRequest.getMinGuestRating(), filterRequest.getMaxGuestRating(), "minGuestRating", bindingResult);
    }

    private void validateAnyDestinationProvided(FilterRequest filterRequest, BindingResult bindingResult) {
        if (StringUtils.isEmpty(filterRequest.getDestinationCity()) && StringUtils.isEmpty(filterRequest.getDestinationCountry())) {
            FieldError objectError = new FieldError("filterRequest", "destinationCity", filterRequest.getDestinationCity(), false, null, null, "Destination is required, you can fill City or Country ");
            bindingResult.addError(objectError);
        }
    }

    private void validateTripStartDate(FilterRequest filterRequest, BindingResult bindingResult) {
        if (Objects.nonNull(filterRequest.getMinTripStartDate()) && Objects.nonNull(filterRequest.getMaxTripStartDate()) &&
                filterRequest.getMinTripStartDate().getTime() > filterRequest.getMaxTripStartDate().getTime()) {
            FieldError objectError = new FieldError("filterRequest", "minTripStartDate", filterRequest.getMinTripStartDate(), false, null, null, "Min check in date should be prior to max check in date");
            bindingResult.addError(objectError);
        }
    }

    private void validateRange(Double min, Double max, String fieldName, BindingResult bindingResult) {
        if (Objects.nonNull(min) && Objects.nonNull(max) && min > max) {
            FieldError objectError = new FieldError("filterRequest", fieldName, min, false, null, null, "Min value should be less than or equal related max");
            bindingResult.addError(objectError);
        }
    }

}