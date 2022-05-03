package ky.fex.discordbotinterface.discord.internals;


import java.net.http.HttpHeaders;
import java.util.HashMap;

public class RateLimitHandler {
    public HashMap rates = new HashMap();

    public RateLimitHandler(){}

    public void updateRates(int statusCode, HttpHeaders headers){
        System.out.println(headers.toString());
        if(headers.firstValue("Retry-After").isPresent()){
            Float.parseFloat(headers.firstValue("Retry-After").get());
        }
    }
}
