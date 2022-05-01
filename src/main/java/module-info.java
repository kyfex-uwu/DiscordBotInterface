module ky.fex.discordbotinterface {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    requires java.net.http;
    requires org.json;

    opens ky.fex.discordbotinterface to javafx.fxml;
    exports ky.fex.discordbotinterface;
}