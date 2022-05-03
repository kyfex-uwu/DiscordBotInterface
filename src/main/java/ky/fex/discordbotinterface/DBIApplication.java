package ky.fex.discordbotinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//hi
//i have no idea what im doing, please tell me what im doing wrong
public class DBIApplication extends Application {
    //IMPORTANT LINK THAT I AM IGNORING RN
    //https://discord.com/developers/docs/topics/rate-limits#rate-limits

    @Override
    public void start(Stage stage) throws IOException {
        File configFile = new File("config.properties");
        configFile.createNewFile();
        DBIConstants.properties.load(new FileReader(configFile));

        DBIConstants.currStage=stage;

        FXMLLoader fxmlLoader = new FXMLLoader(DBIApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Kyfex's Discord Bot Interface");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws IOException {
        File configFile = new File("config.properties");
        configFile.createNewFile();
        FileWriter writer = new FileWriter(configFile);
        DBIConstants.properties.store(writer,"uwu");
        writer.close();
    }

    public static void main(String[] args) {
        launch();
    }
}