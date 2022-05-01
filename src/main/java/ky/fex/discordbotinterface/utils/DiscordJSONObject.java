package ky.fex.discordbotinterface.utils;

import ky.fex.discordbotinterface.discord.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.invoke.MethodHandles;
import java.net.http.HttpResponse;

public class DiscordJSONObject {
    public static String baseLink="https://discord.com/api/";

    public DiscordJSONObject(String id){
        HttpResponse response = new DiscordHTTPRequest(baseLink+id).sendRequest(DiscordHTTPRequest.postMethod.GET);
        var responseParsed = new JSONObject(response.body().toString());

        var fields = this.getClass().getDeclaredFields();
        for(Field field : fields){
            try {
                Object getFromJson = null;
                try{
                    getFromJson=responseParsed.get(field.getName());
                }catch(JSONException ignored){}

                field.set(this, getFromJson);
            } catch(IllegalArgumentException | IllegalAccessException ignored){}
        }
    }
}
