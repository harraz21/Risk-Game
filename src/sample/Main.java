package sample;

import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Agents.*;
import Model.Map.RiskMap;

import Model.Map.Territory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage primarystage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primarystage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("startingScene.fxml"));
        primaryStage.setTitle("Risk Game");
        primaryStage.setScene(new Scene(root));//, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //System.out.close();
        launch(args);
        Agent A = new Pacifist();
        Agent B = new Aggressive();
        RiskMap myMap = new RiskMap(A,B);

        Territory myTerritoryA =new Territory(A, new ArmyUnits(5));
        myMap.addTerritory(myTerritoryA);
        Territory myTerritoryB = new Territory(A, new ArmyUnits(5));
        myMap.addTerritory(myTerritoryB);
        Territory myTerritoryC = new Territory(B, new ArmyUnits(5));
        myMap.addTerritory(myTerritoryC);
        Territory myTerritoryD = new Territory(B, new ArmyUnits(5));
        myMap.addTerritory(myTerritoryD);
        Territory.neighbor(myTerritoryA,myTerritoryB);
        Territory.neighbor(myTerritoryC,myTerritoryD);
        Territory.neighbor(myTerritoryB,myTerritoryC);
        Territory.neighbor(myTerritoryA,myTerritoryD);

       // Territory.neighbor(myTerritoryB,myTerritoryD);
        //Territory.neighbor(myTerritoryA,myTerritoryC);

        myMap.getPlayers().get(0).setNoOfUnitsAvaliable(20);
        myMap.getPlayers().get(1).setNoOfUnitsAvaliable(15);
        myMap.print();
        int current = 0;
        while (!myMap.isGoal()){
            System.out.println(current);

            myMap.getPlayers().get(current).play(myMap);
            myMap.getPlayers().get(current).updateUnitsAvaliable();
            myMap.print();
            current = current ==0 ? 1:0;
        }
        System.out.println("Enddd");


       // Model.Tree.Node myNode = new Model.Tree.Node(new GameState(myMap));
       // myNode.generateChildren(A);
        //System.out.println("Enter C");

        //launch(args);
        /*Attackagent cc = new Attackagent();
        Territory myTerritoryForAttacker =new Territory(cc, new ArmyUnits(10));
        myMap.addTerritory(new Territory(cc, new ArmyUnits(5)));
        cc.continueAttacking();
        cc.getDefender();
        cc.getAttacker();
        System.out.println("Enter Continoing is done");
*/
    }

}