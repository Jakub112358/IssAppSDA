package com.example.jsonDeserialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class JsonOperations {
    private final static String BASE_URL = "http://api.open-notify.org/iss-now.json";

    public static void main(String[] args) throws IOException, InterruptedException {

        waitingMessage();
        ISSLocation loc1 = getLocation();
        ISSLocation loc2 = getLocation();
        ISSLocation loc3 = getLocation();

        System.out.println("1. " + loc1 + "\n2. " + loc2 + "\n3. " + loc3);
    }

    public static JsonNode jsonDeserialization(URL url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(url);
    }

    public static ISSLocation getLocation () throws IOException, InterruptedException {
        JsonNode request = jsonDeserialization(new URL(BASE_URL));
        Thread.sleep(5000);
        return new ISSLocation(request.get("timestamp").asInt(),
                request.get("iss_position").get("latitude").asDouble(),
                request.get("iss_position").get("longitude").asDouble());
    }

    public static void waitingMessage () {
        System.out.println("Carrying out measurements. Please wait...\n");
    }


}