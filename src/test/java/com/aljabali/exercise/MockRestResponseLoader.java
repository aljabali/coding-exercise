package com.aljabali.exercise;

import com.aljabali.exercise.hotels.model.FilterResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class MockRestResponseLoader {


    public static FilterResponse importWorkflow() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(MockRestResponseLoader.class.getResourceAsStream("/JsonHotelResponse.json"), FilterResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
