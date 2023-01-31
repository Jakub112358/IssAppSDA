package com.example.http_JSON;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class SomeClass {
    private final static String BASE_URL = "http://api.open-notify.org/iss-now.json";

    public static void main(String[] args) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }



}

