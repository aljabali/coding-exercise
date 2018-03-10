package com.aljabali.exercise.hotels;

import com.aljabali.exercise.hotels.model.FilterRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FilterControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void whenNavigateToRootContext_thenNavigateToFilterView() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(model().attributeExists("filterRequest"));
    }

    @Test
    public void givenFilterView_whenCityNotFilled_thenReturnErrors() throws Exception {
        this.mockMvc.perform(post("/hotel-filter", filterWithMissingCity())).andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("filterRequest", "destinationCity"));
    }

    @Test
    public void givenFilterView_whenStartDateRangeAndFlipped_thenReturnErrors() throws Exception {
        this.mockMvc.perform(post("/hotel-filter", filterWithFlippedStartDateRange())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(model().errorCount(1));
    }

    private FilterRequest filterWithMissingCity() {
        return new FilterRequest().setDestinationCity("");
    }

    private FilterRequest filterWithFlippedStartDateRange() {
        Date fromDate = Date.from(LocalDate.now().plusDays(5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return new FilterRequest().setDestinationCity("Amman")
                .setMinTripStartDate(fromDate)
                .setMaxTripStartDate(new Date());
    }

}