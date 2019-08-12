package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.primarystage;

public class StartingSceneController implements Initializable {
    @FXML
    public ComboBox firstAgentComboBox;
    @FXML
    public ComboBox secondAgentComboBox;
    @FXML
    public ComboBox mapComboBox;
    @FXML
    public Label AlertLabel;
    ObservableList<String> firstAgentList = FXCollections.observableArrayList("Human Agent","Passive Agent","Aggressive Agent"
            ,"Pacifist Agent","Greedy Agent","A* Agent","Real time A* Agent","Minimax Agent");
    ObservableList<String> secondAgentList = FXCollections.observableArrayList("Human Agent","Passive Agent","Aggressive Agent"
            ,"Pacifist Agent","Greedy Agent","A* Agent","Real time A* Agent","Minimax Agent");
    ObservableList<String> mapList = FXCollections.observableArrayList("Egypt","USA");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstAgentComboBox.setValue("Human Agent");
        firstAgentComboBox.setItems(firstAgentList);
        secondAgentComboBox.setValue("Greedy Agent");
        secondAgentComboBox.setItems(secondAgentList);
        mapComboBox.setValue("Egypt");
        mapComboBox.setItems(mapList);
    }

    public void startButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primarystage.setTitle("Risk Game");
        primarystage.setScene(new Scene(root));//, 300, 275));
        primarystage.show();
    }
}
