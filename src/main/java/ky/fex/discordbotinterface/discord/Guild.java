package ky.fex.discordbotinterface.discord;

import ky.fex.discordbotinterface.utils.DiscordJSONObject;
import org.json.JSONObject;

import java.util.ArrayList;


public class Guild extends DiscordJSONObject {
    public String id;
    public String name;
    public String icon;
    public String icon_hash;
    public String splash;
    public String discovery_splash;
    public boolean owner=false;
    public String owner_id;
    public String permissions;
    public String region;
    public String afk_channel_id;
    public int afk_timeout;
    public boolean widget_enabled;
    public String widget_channel_id;
    public int verification_level;
    public int default_message_notifications;
    public int explicit_content_filter;
    //public Role[] roles;
    //public Emoji[] emojis;
    public String[] features;
    public int mfa_level;
    public String application_id;
    public String system_channel_id;
    public int system_channel_flags;
    public String rules_channel_id;
    public String joined_at;
    public boolean large;
    public boolean unavailable;
    public int member_count;
    //public array of partial <a class="link-2CdggY" href="/developers/docs/resources/voice#voice-state-object">voice state</a> objects voice_states? *;
    //public array of <a class="link-2CdggY" href="/developers/docs/resources/guild#guild-member-object">guild member</a> objects members? *;
    public ArrayList<Channel> channels;
    public ArrayList<Channel> threads;
    //public array of partial <a class="link-2CdggY" href="/developers/docs/topics/gateway#presence-update">presence update</a> objects presences? *;
    public int max_presences;
    public int max_members;
    public String vanity_url_code;
    public String description;
    public String banner;
    public int premium_tier;
    public int premium_subscription_count;
    public String preferred_locale;
    public String public_updates_channel_id;
    public int max_video_channel_users;
    public int approximate_member_count;
    public int approximate_presence_count;
    //public <a class="link-2CdggY" href="/developers/docs/resources/guild#welcome-screen-object">welcome screen</a> object welcome_screen?;
    public int nsfw_level;
    //public array of <a class="link-2CdggY" href="/developers/docs/resources/stage-instance#stage-instance-object">stage instance</a> objects stage_instances? *;
    //public array of <a class="link-2CdggY" href="/developers/docs/resources/sticker#sticker-object">sticker</a> objects stickers?;
    //public array of <a class="link-2CdggY" href="/developers/docs/resources/guild-scheduled-event#guild-scheduled-event-object">guild scheduled event</a> objects guild_scheduled_events? *;
    public boolean premium_progress_bar_enabled;

    public Guild(String linkPart) {
        super(linkPart);
    }
    public Guild(JSONObject json) {
        super(json);
    }
}
