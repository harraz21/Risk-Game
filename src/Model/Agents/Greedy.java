package Model.Agents;

import Model.Map.RiskMap;
import Model.Tree.Franz_Hahn;
import Model.Tree.GameState;
import Model.Tree.Heuristic;
import Model.Tree.Node;

import java.util.ArrayList;

public class Greedy extends Agent {

    public RiskMap play(RiskMap myMap){
        Heuristic myHeuristic = new Franz_Hahn();
        Node myNode = new Node(new GameState(myMap));
        System.out.println("Generate Children Started");
        myNode.generateChildren(this);
        System.out.println("Generate Children Ended");
        this.setNoOfUnitsAvaliable(0);
        ArrayList<Node>list = myNode.getChildren();
        double val = myHeuristic.getHeuristic(list.get(0).getState());
        RiskMap Max= list.get(0).getState().getCurrentRiskMap();
        for (Node A:
             list) {
            System.out.println("sttarted " + val +" "+new Franz_Hahn().getHeuristic(A.getState()));
            if (new Franz_Hahn().getHeuristic(A.getState()) > val){
                Max = A.getState().getCurrentRiskMap();
                val = new Franz_Hahn().getHeuristic(A.getState());
                System.out.println("Val is "+val);
            }

        }
        Max.print();
        Max.getPlayers().get(myMap.getPlayers().indexOf(this)).setNoOfUnitsAvaliable(0);
        return Max;
    }
}
