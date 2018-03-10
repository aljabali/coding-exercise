package com.aljabali.exercise.hotels;

import com.aljabali.exercise.MockRestResponseLoader;
import com.aljabali.exercise.hotels.model.FilterRequest;
import com.aljabali.exercise.hotels.services.HotelService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FilterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    @Spy
    @Autowired
    private HotelService hotelService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenNavigateToRootContext_thenNavigateToFilterView() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(model().attributeExists("filterRequest"));
    }

    @Test
    public void givenFilterView_whenCityNotFilled_thenFlagDestinationCityAsError() throws Exception {
        this.mockMvc.perform(post("/hotel-filter")
                .flashAttr("filterRequest", filterWithMissingCity()))
                .andExpect(status().isOk())
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("filterRequest", "destinationCity"));
    }

    @Test
    public void givenFilterView_whenStartDateRangeAndFlipped_thenFlagMinTripDateAsError() throws Exception {
        this.mockMvc.perform(post("/hotel-filter")
                .flashAttr("filterRequest", filterWithFlippedStartDateRange()))
                .andExpect(status().isOk())
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("filterRequest", "minTripStartDate"));
    }

    @Test
    public void givenFilterView_whenStartDateRangeAndFlipped_thenReturnErrors() throws Exception {
        this.mockMvc.perform(post("/hotel-filter")
                .flashAttr("filterRequest", filterWithFlippedStartDateRange()))
                .andExpect(status().isOk())
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("filterRequest", "minTripStartDate"));
    }

    @Test
    public void givenFilterView_whenRestReturnOffers_thenReturnHotelsDeals() throws Exception {

        when(restTemplate.getForObject(any(URI.class), any())).thenReturn(MockRestResponseLoader.importWorkflow());

        this.mockMvc.perform(post("/hotel-filter")
                .flashAttr("filterRequest", new FilterRequest().setDestinationCity("Amman")))
                .andExpect(status().isOk())
                .andExpect(model().errorCount(0))
                .andExpect(model().attributeExists("hotelDeals"));
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