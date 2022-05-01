package ky.fex.discordbotinterface;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ky.fex.discordbotinterface.utils.DiscordHTTPRequest;

public class HelloController {
    @FXML
    private TextField messageField;

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
    void updateLastMessage(){
        lastMessage.setText("yeeyee");
    }
}
