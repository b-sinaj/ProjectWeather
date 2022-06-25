package service;

import com.google.gson.Gson;
import com.squareup.okhttp.*;
import model.CurrentResponse;
import model.WeatherResponse;

public class WeatherService {

    private final String ACCESS_KEY ="c1192590413603096f0ba5a889ac77cc";
    private final String BASE_URL = "http://api.weatherstack.com";

    public CurrentResponse getWeatherFromCity(String city){
        try {
            // Create http client
            OkHttpClient client = new OkHttpClient();

            // Set URL and parameters
            HttpUrl.Builder urlBuilder
                    = HttpUrl.parse(BASE_URL + "/current").newBuilder();

            // Set query parameters
            urlBuilder.addQueryParameter("access_key", ACCESS_KEY);
            urlBuilder.addQueryParameter("query", city);
            String url = urlBuilder.build().toString();

            // Build request and execute
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = client.newCall(request);
            Response response = call.execute();

            // Convert response to String
            String sResponse = response.body().string();

            // Convert String to our class model
            Gson gson = new Gson();
            WeatherResponse weatherResponse = gson.fromJson(sResponse, WeatherResponse.class);

            // Return class model
            return weatherResponse.getCurrent();
        }
        catch (Exception e){
            e.printStackTrace();
        }
      return null;

    }
}
