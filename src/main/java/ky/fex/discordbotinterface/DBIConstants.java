package ky.fex.discordbotinterface;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ky.fex.discordbotinterface.discord.internals.Cache;
import ky.fex.discordbotinterface.discord.User;
import ky.fex.discordbotinterface.discord.internals.RateLimitHandler;

import java.io.IOException;
import java.util.Properties;

public final class DBIConstants {
    public static String thisToken;
    public static Stage currStage;
    public static User thisUser;

    public static Properties properties = new Properties();
    public static RateLimitHandler rateLimitHandler = new RateLimitHandler();
    public static Cache cache = new Cache();

    public static void changeScene(String fxml) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(DBIApplication.class.getResource(fxml)));
        DBIConstants.currStage.setScene(scene);
    }
}
