package ky.fex.discordbotinterface.discord;

import ky.fex.discordbotinterface.DBIConstants;
import ky.fex.discordbotinterface.utils.DiscordJSONObject;

import java.util.ArrayList;

public class User extends DiscordJSONObject {
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

    public User(String linkPart) {
        super(linkPart);
        if(linkPart.equals("users/@me")){
            DBIConstants.properties.setProperty("botName",this.username);
        }
    }

    public ArrayList<Guild> getGuilds(){
        return Guild.getArray("/users/@me/guilds", Guild.class);
    }
}
