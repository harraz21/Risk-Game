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
    ObservableList<String> firstAgentList = FXCollections.observableArrayList("Human Agent", "Passive Agent", "Aggressive Agent"
            , "Pacifist Agent", "Greedy Agent", "A* Agent", "Real time A* Agent", "Minimax Agent");
    ObservableList<String> secondAgentList = FXCollections.observableArrayList("Human Agent", "Passive Agent", "Aggressive Agent"
            , "Pacifist Agent", "Greedy Agent", "A* Agent", "Real time A* Agent", "Minimax Agent");
    ObservableList<String> mapList = FXCollections.observableArrayList("Egypt", "USA");

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
        String firstAgent = (String) firstAgentComboBox.getValue();
        String secondAgent = (String) secondAgentComboBox.getValue();
        String map = (String) mapComboBox.getValue();
        switch (firstAgent) {
            case "Human Agent":
                //write your code here
                break;
            case "Passive Agent":
                //write your code here
                break;
            case "Aggressive Agent":
                //write your code here
                break;
            case "Pacifist Agent":
                //write your code here
                break;
            case "Greedy Agent":
                //write your code here
                break;
            case "A* Agent":
                //write your code here
                break;
            case "Real time A* Agent":
                //write your code here
                break;
            case "Minimax Agent":
                //write your code here
                break;
            default:
                //write your code here
                break;
        }
        switch (secondAgent) {
            case "Human Agent":
                //write your code here
                break;
            case "Passive Agent":
                //write your code here
                break;
            case "Aggressive Agent":
                //write your code here
                break;
            case "Pacifist Agent":
                //write your code here
                break;
            case "Greedy Agent":
                //write your code here
                break;
            case "A* Agent":
                //write your code here
                break;
            case "Real time A* Agent":
                //write your code here
                break;
            case "Minimax Agent":
                //write your code here
                break;
            default:
                //write your code here
                break;
        }

        switch (map) {
            case "Egypt":
                //write your code here
                break;
            case "USA":
                //write your code here
                break;
            default:
                //write your code here
                break;
        }
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primarystage.setTitle("Risk Game");
        primarystage.setScene(new Scene(root));//, 300, 275));
        primarystage.show();
    }
}
