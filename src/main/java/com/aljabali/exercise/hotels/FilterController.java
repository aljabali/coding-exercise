package com.aljabali.exercise.hotels;

import com.aljabali.exercise.hotels.model.FilterRequest;
import com.aljabali.exercise.hotels.model.HotelResponse;
import com.aljabali.exercise.hotels.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/hotel-filter")
    public String doFilter(@ModelAttribute @Valid FilterRequest filterRequest, BindingResult bindingResult, Model model) {
        return filterAndForward(filterRequest, bindingResult, model);
    }

    @ModelAttribute("cities")
    public List<String> populateCities() {
        //TODO this is mock only and we need api to retrieve the list or pick from somewhere
        return Arrays.asList("Amman", "Aqaba", "Bangkok", "New Orleans");

    }

    private String filterAndForward(FilterRequest filterRequest, BindingResult bindingResult, Model model) {
        validateTripStartDate(filterRequest, bindingResult);
        String destinationView = FILTER_VIEW;


        if (!bindingResult.hasErrors()) {
            List<HotelResponse> hotels = hotelService.doSearch(filterRequest);
            model.addAttribute("hotelDeals", hotels);
            if (!hotels.isEmpty()) {
                destinationView = HOTEL_RESULTS_VIEW;
            }
        }

        return destinationView;
    }

    private void validateTripStartDate(FilterRequest filterRequest, BindingResult bindingResult) {
        if (Objects.nonNull(filterRequest.getMinTripStartDate()) && Objects.nonNull(filterRequest.getMaxTripStartDate()) &&
                filterRequest.getMinTripStartDate().getTime() > filterRequest.getMaxTripStartDate().getTime()) {
            FieldError objectError = new FieldError("filterRequest", "minTripStartDate", filterRequest.getMinTripStartDate(), false, null, null, "Min check in date should be prior to max check in date");
            bindingResult.addError(objectError);
        }
    }

}