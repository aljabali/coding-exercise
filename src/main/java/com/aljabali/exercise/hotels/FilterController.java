package com.aljabali.exercise.hotels;

import com.aljabali.exercise.hotels.model.FilterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilterController {

    private static final String FILTER_VIEW = "hotel-filter";


    @GetMapping("/")
    public String initFilter(Model model) {
        model.addAttribute("filterRequest", new FilterRequest());
        return FILTER_VIEW;
    }


}
