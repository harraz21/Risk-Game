package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.primarystage;

public class StartingSceneController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primarystage.setTitle("Risk Game");
        primarystage.setScene(new Scene(root));//, 300, 275));
        primarystage.show();
    }
}
