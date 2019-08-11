package sample;

import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Agents.Attackagent;
import Model.Agents.Passive;
import Model.Agents.*;
import Model.Map.RiskMap;

import Model.Map.Territory;
import Model.Tree.GameState;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.reflect.generics.tree.Tree;

import javax.swing.tree.DefaultTreeSelectionModel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));//, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //System.out.close();
        Agent A = new Pacifist();
        Agent B = new Pacifist();
        RiskMap myMap = new RiskMap(A,B);

        Territory myTerritoryA =new Territory(A, new ArmyUnits(5));
        myMap.addTerritory(myTerritoryA);
        Territory myTerritoryB = new Territory(A, new ArmyUnits(5));
        myMap.addTerritory(myTerritoryB);
        Territory.neighbor(myTerritoryA,myTerritoryB);
        Territory myTerritoryC = new Territory(B, new ArmyUnits(5));
        myMap.addTerritory(myTerritoryC);
        Territory myTerritoryD = new Territory(B, new ArmyUnits(5));
        myMap.addTerritory(myTerritoryD);
        Territory.neighbor(myTerritoryC,myTerritoryD);
        Territory.neighbor(myTerritoryB,myTerritoryC);
        Territory.neighbor(myTerritoryA,myTerritoryD);
        Territory.neighbor(myTerritoryB,myTerritoryD);

        myMap.getPlayers().get(0).setNoOfUnitsAvaliable(50);
        myMap.getPlayers().get(1).setNoOfUnitsAvaliable(0);
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