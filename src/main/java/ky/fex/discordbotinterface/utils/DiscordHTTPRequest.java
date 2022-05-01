package ky.fex.discordbotinterface.utils;

import ky.fex.discordbotinterface.DBIConstants;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DiscordHTTPRequest {
    private HttpRequest.Builder request;

    public DiscordHTTPRequest(URI link){
        request=HttpRequest.newBuilder(link)
                .header("Authorization","Bot "+ DBIConstants.getBotID())
                .header("User-Agent","ungaBungaTestBot (http://some.url, v0.0)")
                .header("Content-Type","application/json");
    }
    public DiscordHTTPRequest(String link) {
        this(URI.create(link));
    }

    public DiscordHTTPRequest addHeader(String headerName, String headerValue){
        request=request.header(headerName,headerValue);
        return this;
    }

    public enum postMethod{
        POST,
        GET,
        PATCH
    }
    public HttpResponse sendRequest(postMethod method, String toPost){
        try {
            return HttpClient.newHttpClient().send(
                    request.method(String.valueOf(method),HttpRequest.BodyPublishers.ofString(toPost)).build(),
                    HttpResponse.BodyHandlers.ofString()
            );
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public HttpResponse sendRequest(postMethod method){
        return sendRequest(method,"");
    }
}
