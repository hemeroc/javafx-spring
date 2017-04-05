package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    @FXML
    private TextField tfName;

    // Proxy does not work when Method is private (damn)
    // If method is public proxy is working but tfName is null
    @FXML
    public void hello() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Hello, " + tfName.getText() + "!");
        alert.showAndWait();
    }

}
