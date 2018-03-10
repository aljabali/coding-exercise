package com.aljabali.exercise.hotels.services;

import com.aljabali.exercise.MockRestResponseLoader;
import com.aljabali.exercise.hotels.model.FilterRequest;
import com.aljabali.exercise.hotels.model.FilterResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {

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
    public void givenValidFilter_whenEmptyResponseFromRest_thenReturnEmptyHotelsOffers() {
        when(restTemplate.getForObject(any(URI.class), any())).thenReturn(new FilterResponse());
        assertTrue(hotelService.doSearch(new FilterRequest().setDestinationCity("Ammimeoutan")).isEmpty());
    }

    @Test
    public void givenValidFilter_whenResponseFromRest_thenReturnNonEmptyHotelsOffers() {
        when(restTemplate.getForObject(any(URI.class), any())).thenReturn(MockRestResponseLoader.importWorkflow());
        assertTrue(!hotelService.doSearch(new FilterRequest().setDestinationCity("Amman")).isEmpty());
    }

    @Test
    public void whenRestThrowsException_thenReturnEmptyHotelsOffers() {
        when(restTemplate.getForObject(any(URI.class), any())).thenThrow(new NullPointerException("t"));
        assertTrue(hotelService.doSearch(new FilterRequest().setDestinationCity("Amman")).isEmpty());
    }


}