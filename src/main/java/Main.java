

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
       List<City> resultList =  cityList.stream().filter(fi.and(oh)).collect(Collectors.toList());


        System.out.println("RESULT\n______________________________________");
        for (int i = 0; i < resultList.size(); i++) {

            System.out.println("CITY "+i+":"+
                    resultList.get(i).getName()
            +"  " + resultList.get(i).getPop() +
                    "  "+resultList.get(i).getDistrict()
            +"  "+resultList.get(i).getCode()+"\n");

        }


    }







}
