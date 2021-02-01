import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class API {


    private  final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    static List<City> cityList = new ArrayList<>();

    public  List<City> getRequest() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://itsovy.sk:5000/data"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


      return createListFromJSON(response.body());


    }

    private  List<City> createListFromJSON(String body) {


        JSONObject object = new JSONObject(body);
        JSONArray arr = object.getJSONArray("world_x");


        for (int i = 0; i < arr.length(); i++) {
            City city = new City();

            JSONObject jsons = arr.getJSONObject(i);
            city.setCode(jsons.getString("code"));
            city.setDistrict(jsons.getString("district"));
            city.setName(jsons.getString("name"));
            city.setPop(jsons.getInt("pop"));

            cityList.add(city);



        }
        return cityList;
    }
}
