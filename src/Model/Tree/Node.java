package Model.Tree;




import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.RiskMap;
import Model.Map.Territory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


public class Node  {

    /**
     * (RIGHT = childre[0], LEFT = childre[1], UP = childre[2], DOWN =
     * childre[3]).
     *
     */
    protected GameState state;
    private ArrayList<Node> children;
    private Node parent;
    private int depth;
    public Node(GameState state, Node parent) {
        if (parent == null){
            depth = 0;
        }else {
            depth = parent.depth+1;
        }
        this.state = state;
        this.parent = parent;
    }

    public Node(GameState myState) {
        this.state = myState;
        this.parent = null;
    }



    public void generateChildren(Agent myAgent) {
        //generate
        children = new ArrayList<>();
        int emptyTile = -1;

        try {
            moveTile(myAgent);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("couldn;t generate children");
        }
    }

    private void moveTile(Agent cAgent) throws CloneNotSupportedException {
        //Move
        ArrayList<Node> newChildren = new ArrayList<>();

        Agent i = cAgent;
        int index = state.getCurrentRiskMap().getPlayers().indexOf(i);
            if (i == null){
                return;
            }
            i.updateUnitsAvaliable();
            int sum = i.getNoOfUnitsAvaliable();
            long num =  20;
            System.out.println(index + " Started ++++++++++ "+ num);
            for (long j = 0; j < num; j++) {


                RiskMap newRiskMap = null;

                try {
                    newRiskMap = (RiskMap) state.getCurrentRiskMap().clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println("could'nt clone");
                    e.printStackTrace();
                }
                GameState newState = new GameState(newRiskMap);
                int x = sum;
                int flag = 0;
                while (x >0){
                    try {
                        newRiskMap.getPlayers().get(index).getTerritoriesOccuopied().
                                get((new Random().nextInt
                                        (newRiskMap.getPlayers().get(index)
                                                .getTerritoriesOccuopied().size())))
                                .addSoldiers(1);
                    }catch (Exception e){
                        System.out.println("Game Won");
                        e.printStackTrace();
                        flag = 1;
                        break;
                    }

                    x--;
                }
                if (flag ==1){
                    continue;
                }
                newChildren.add(new Node(newState));
               // System.out.println("placing Size "+ newChildren.size());
            }



        for (Node A:
             newChildren) {
            RiskMap B = (RiskMap)A.getState().getCurrentRiskMap();
           // System.out.println(B.getPlayers().size());
            //System.out.println(index + " Started "+ this.getDepth());
            Agent C = B.getPlayers().get(index);
            int n = 30;
            while (n>0) {
                RiskMap myClonedMap = (RiskMap) B.clone();

                for (Territory D :
                        C.getTerritoriesOccuopied()) {
                    int indexofD = B.getTerritories().indexOf(D);
                    // System.out.println(D);
                    if ((new Random()).nextBoolean())
                        myClonedMap.getTerritories().get(indexofD)
                                .move(myClonedMap.getTerritories().get(indexofD)
                                        .getNeighboringTerritories().get(
                                                (new Random().nextInt(myClonedMap.getTerritories().get(indexofD)
                                                        .getNeighboringTerritories().size()))
                                        ));
                    //myClonedMap.print();
                }
                children.add(new Node(new GameState(myClonedMap), this));
                n--;
            }
            // B.print();
        }

        System.out.println("size of children  " + children.size());



        //System.out.println("Size of Children is " + children.size());
    }



    public GameState getState() {
        return state;
    }


    public void setState(GameState state) {
        this.state = state;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getDepth() {
        return depth;
    }

    boolean isGoal() {
        //GameState n = new GameState();

        return false;}



    public int compareTo(Node node) {

        return 0;
    }
}
