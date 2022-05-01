package ky.fex.discordbotinterface.discord;

import ky.fex.discordbotinterface.utils.DiscordHTTPRequest;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.net.http.HttpResponse;

public class User {
    public String id;
    public String username;
    public String discriminator;
    public String avatar;
    public boolean bot=false;
    public boolean system=false;
    public boolean mfa_enabled=false;
    public String banner;
    public int accent_color;
    public String locale;
    public boolean verified=false;
    public String email;
    public int flags=0;
    public int premium_type=0;
    public int public_flags=0;

    public User(){}
    public static User get(String id) {
        HttpResponse response = new DiscordHTTPRequest("https://discord.com/api/users/"+id).sendRequest(DiscordHTTPRequest.postMethod.GET);
        var responseParsed = new JSONObject(response.body().toString());
        var userToReturn= new User();

        var fields = User.class.getDeclaredFields();
        for(Field field : fields){
            try {
                Object getFromJson = null;
                try{
                    getFromJson=responseParsed.get(field.getName());
                }catch(JSONException ignored){}

                field.set(userToReturn, getFromJson);
            } catch(IllegalArgumentException | IllegalAccessException ignored){}
        }

        return userToReturn;
    }
}
