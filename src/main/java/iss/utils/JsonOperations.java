package iss.utils;

import iss.model.Astronaut;
import iss.model.ISSLocation;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class JsonOperations {
    private final static String BASE_URL = "http://api.open-notify.org/iss-now.json";
    private final static String PEOPLE_URL = "http://api.open-notify.org/astros.json";


    private JsonNode jsonDeserialization1(URL url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(url);
    }

    public ISSLocation getLocation() {
        JsonNode request;
        try {
            request = jsonDeserialization1(new URL(BASE_URL));
            System.out.println(request.toString());
            return new ISSLocation(request.get("timestamp").asInt(),
                    request.get("iss_position").get("latitude").asDouble(),
                    request.get("iss_position").get("longitude").asDouble());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Astronaut[] getAstronauts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode request = jsonDeserialization1(new URL(PEOPLE_URL));
        String json = request.get("people").toString();
        System.out.println(json);
        return objectMapper.readValue(json, Astronaut[].class);
    }
}