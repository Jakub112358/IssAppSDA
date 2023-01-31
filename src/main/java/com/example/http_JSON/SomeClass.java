package com.example.http_JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class SomeClass {
    private final static String BASE_URL = "http://api.open-notify.org/iss-now.json";

    public static void main(String[] args) throws IOException {
        URL url = new URL(BASE_URL);
        JsonNode pojo = jsonDeserialization(url);
        System.out.println(jsonDeserialization(url).toString());

        int timestamp = pojo.get("timestamp").asInt();
        double latitude = pojo.get("iss_position").get("latitude").asDouble();
        double longitude = pojo.get("iss_position").get("longitude").asDouble();
    }

    public static JsonNode jsonDeserialization(URL url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(url);
    }
}