

import java.util.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.json.*;

public class Main {




    public static void main(String[] args) throws Exception {


        API api = new API();
       List<City>  cityList=  api.getRequest();

      FromItaly<City> fi = new FromItaly<>();



        Predicate<City>oh = c -> c.getPop() > 100000;


        cityList.stream().filter(fi.and(oh)).forEach(System.out::println);



    }







}
