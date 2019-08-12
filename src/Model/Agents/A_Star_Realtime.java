package Model.Agents;

import Model.Map.RiskMap;
import Model.Tree.Franz_Hahn;
import Model.Tree.GameState;
import Model.Tree.Node;

import java.util.ArrayList;
import java.util.Comparator;


public class A_Star_Realtime extends Agent {
    int index;
    private class myPair{

        double weight;
        Node myGameState;
        myPair(double weight,Node myGameState){
            this.weight = weight;
            this.myGameState = myGameState;
        }
    }
    ArrayList<myPair> Explored = new ArrayList<myPair>();
    public RiskMap play(RiskMap myMap) {
        Node myNode = new Node(new GameState(myMap));
         index = myMap.getPlayers().indexOf(this);

        while (myNode.getDepth() < 5) {
            System.out.println("Generate Children Started");
            myNode.generateChildren(((myNode.getDepth()%2)==0) ?
                    myNode.getState().getAgents().get(index) : myNode.getState().getAgents().get(index).getOpponent());
            System.out.println("Generate Children Ended");

            ArrayList<Node> list = myNode.getChildren();
            for (Node A :
                    list) {
                double cost = (new Franz_Hahn().getHeuristic(A.getState()
                        , this)) + A.getDepth();
                Explored.add(new myPair(cost, A));

            }
            System.out.println("Weight befo " + Explored.get(Explored.size() - 1).weight);
            System.out.println("Weight befo " + Explored.get(0).weight);

            Explored.sort(new Comparator<myPair>() {
                public int compare(myPair p1, myPair p2) {
                    return Double.compare(p1.weight, p2.weight);
                }
            });
            System.out.println("Weight after " + Explored.get(Explored.size() - 1).weight);
            System.out.println("Weight after " + Explored.get(0).weight);

            myNode = Explored.get(Explored.size() - 1).myGameState;
            System.out.println("Depth "+myNode.getDepth());
        }
        while (myNode.getDepth() !=1)
            myNode = myNode.getParent();
        myNode.getState().getAgents().get(index).setNoOfUnitsAvaliable(0);
        return myNode.getState().getCurrentRiskMap();
    }

}