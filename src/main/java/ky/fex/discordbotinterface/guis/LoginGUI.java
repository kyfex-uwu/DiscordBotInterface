package ky.fex.discordbotinterface.guis;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ky.fex.discordbotinterface.DBIConstants;

import java.io.IOException;

public class LoginGUI {
    @FXML
    private TextField botID;

    @FXML
    protected void keyReleased(KeyEvent key) throws IOException {
        if(key.getCode()== KeyCode.ENTER){
            DBIConstants.setBotID(botID.getText());
            DBIConstants.changeScene("main.fxml");
        }
    }

    @FXML
    protected void attemptPrevSession() throws IOException {
        if(!DBIConstants.properties.getProperty("botID").isEmpty()){
            DBIConstants.setBotID(DBIConstants.properties.getProperty("botID"));
            DBIConstants.changeScene("main.fxml");
        }
    }
}
