package com.example.newservlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONProcessor {
    public static HashMap<String, String> parseJSON(String stringJSON) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, String>> type = new TypeReference<HashMap<String, String>>() {};
        return mapper.readValue(stringJSON, type);
    }
}
