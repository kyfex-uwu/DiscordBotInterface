package ky.fex.discordbotinterface.guis;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ky.fex.discordbotinterface.DBIConstants;
import ky.fex.discordbotinterface.discord.User;
import ky.fex.discordbotinterface.discord.internals.Rate;
import ky.fex.discordbotinterface.discord.internals.RateLimitHandler;

import java.io.IOException;
import java.net.URL;

public class LoginGUI {
    @FXML
    private TextField botToken;

    @FXML
    private Button prevSessionButton;

    @FXML
    protected void initialize(){
        var nameProp=DBIConstants.properties.getProperty("botName");
        if(nameProp!=null){
            prevSessionButton.textProperty().set(nameProp);
        }
    }

    @FXML
    protected void keyReleased(KeyEvent key) throws IOException {
        if(key.getCode() == KeyCode.ENTER){
            login(botToken.getText());
        }
    }

    @FXML
    protected void attemptPrevSession() throws IOException {
        var token=DBIConstants.properties.getProperty("botToken");
        if(token!=null){
            login(token);
        }
    }

    private void login(String botToken) throws IOException {
        DBIConstants.thisToken=botToken;
        DBIConstants.thisUser=new User("users/@me");
        DBIConstants.properties.setProperty("botToken",botToken);
        DBIConstants.changeScene("main.fxml");
    }
}
