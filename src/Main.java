package sample;

import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.RiskMap;
import Model.Map.Territory;
import Model.Tree.GameState;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //System.out.close();
        RiskMap myRiskMap = new RiskMap();
        Agent A = new Agent();
        Agent B = new Agent();
        Territory myTerritory =new Territory(A, new ArmyUnits(10));
        System.out.println("ksk"  + myTerritory);
        myRiskMap.addTerritory(myTerritory);

        myTerritory = new Territory(A, new ArmyUnits(5));
        myRiskMap.addTerritory(myTerritory);


        myRiskMap.addTerritory(new Territory(B, new ArmyUnits(5)));
        myRiskMap.addTerritory(new Territory(B, new ArmyUnits(5)));

        myRiskMap.getTerritories().get(0).getDefender().setNoOfUnitsAvaliable(3);
        Model.Tree.Node myNode = new Model.Tree.Node(new GameState(myRiskMap));
        myNode.generateChildren();

        launch(args);
    }

}