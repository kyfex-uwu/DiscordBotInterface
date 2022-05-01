package ky.fex.discordbotinterface;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Properties;

public final class DBIConstants {
    private static String botID="";
    public static Stage currStage;
    public static Properties properties = new Properties();

    public static void changeScene(String fxml) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(DBIApplication.class.getResource(fxml)));
        DBIConstants.currStage.setScene(scene);
    }

    public static void setBotID(String newId){
        botID=newId;
        properties.setProperty("botID",botID);
    }
    public static String getBotID(){return botID;}
}
