package ky.fex.discordbotinterface.guis;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ky.fex.discordbotinterface.DBIConstants;
import ky.fex.discordbotinterface.utils.DiscordHTTPRequest;

public class MainGUI {
    @FXML
    private TextField messageField;

    @FXML
    protected void initialize(){
        DBIConstants.thisUser.getChannels();
    }

    @FXML
    protected void keyReleased(KeyEvent key){
        if(key.getCode()== KeyCode.ENTER) {
            this.onSend();
        }
    }

    @FXML
    protected void onSend(){
        new DiscordHTTPRequest("https://discord.com/api/channels/835900826412384297/messages")
                .sendRequest(DiscordHTTPRequest.postMethod.POST,
                        "{\"content\":\""+
                                messageField.getText().replace("\\","\\\\")
                                        .replace("\"","\\\"")
                                +"\"}");
    }

    @FXML
    private Label lastMessage;
    protected void updateLastMessage(){
        lastMessage.setText("yeeyee");
    }
}
