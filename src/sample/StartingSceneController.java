package sample;

import Model.Agents.*;
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
                Message.Player1 = new Human();

                break;
            case "Passive Agent":
                Message.Player1 = new Passive();
                break;
            case "Aggressive Agent":
                Message.Player1 = new Aggressive();
                break;
            case "Pacifist Agent":
                Message.Player1 = new Pacifist();
                break;
            case "Greedy Agent":
                Message.Player1 = new Greedy();
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
                System.out.println("Dont choose human as player 2 !");
                Message.Player2 = new Human();
                break;
            case "Passive Agent":
                Message.Player2 = new Passive();
                break;
            case "Aggressive Agent":
                Message.Player2 = new Aggressive();
                break;
            case "Pacifist Agent":
                Message.Player2 = new Pacifist();
                break;
            case "Greedy Agent":
                Message.Player2 = new Greedy();
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
                Message.isEgypt = true;
                break;
            case "USA":
                Message.isEgypt = false;
                break;
            default:
                //write your code here
                break;
        }
        Message.once = false;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primarystage.setTitle("Risk Game");
        primarystage.setScene(new Scene(root));//, 300, 275));
        primarystage.show();

    }
}
