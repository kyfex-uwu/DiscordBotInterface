package ky.fex.discordbotinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ky.fex.discordbotinterface.discord.User;

import java.io.IOException;

public class DBIApplication extends Application {
    public User thisUser;

    @Override
    public void start(Stage stage) throws IOException {
        this.thisUser=User.get("869068223365140510");

        FXMLLoader fxmlLoader = new FXMLLoader(DBIApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Kyfex's Discord Bot Interface");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}