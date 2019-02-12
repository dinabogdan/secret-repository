package com.freesoft.identity.manager.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String json(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
