package ky.fex.discordbotinterface.utils;

import ky.fex.discordbotinterface.DBIConstants;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;

public class DiscordJSONObject {
    public static String baseLink="https://discord.com/api/";
    private String responseBody;

    private static HttpResponse request(String linkPart){
        HttpResponse response = new DiscordHTTPRequest(baseLink+linkPart).sendRequest(DiscordHTTPRequest.postMethod.GET);
        DBIConstants.rateLimitHandler.updateRates(response.statusCode(), response.headers());
        return response;
    }

    public DiscordJSONObject(String linkPart){
        this(new JSONObject(request(linkPart).body().toString()));
    }
    public DiscordJSONObject(JSONObject json){
        this.responseBody= json.toString();
        var fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Object getFromJson = null;
                try {
                    getFromJson = json.get(field.getName());
                } catch (JSONException ignored) {}

                field.set(this, getFromJson);
            } catch (IllegalArgumentException | IllegalAccessException ignored) {
            }
        }
    }
    private DiscordJSONObject(){}

    public <T extends DiscordJSONObject> T toClass(Class subclass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var constructor = subclass.getConstructor(JSONObject.class);
        return (T) constructor.newInstance(new JSONObject(this.responseBody));//this.responsebody is null
    }

    public static <T extends DiscordJSONObject> ArrayList<T> getArray(String linkPart, Class thisClass){
        var responseArray = request(linkPart).body().toString().split("}, \\{");
        responseArray[0]=responseArray[0].substring(2);
        var l=responseArray.length-1;
        responseArray[l]=responseArray[l].substring(0,responseArray[l].length()-2);

        var toReturn = new ArrayList<T>();
        for(String responseElement : responseArray){
            try {
                var newObj=new DiscordJSONObject();
                newObj.responseBody="{" + responseElement + "}";
                toReturn.add(newObj.toClass(thisClass));
            }catch(InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException ignored){}
        }

        return toReturn;
    }
}
