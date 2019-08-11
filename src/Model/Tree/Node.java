package Model.Tree;




import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.RiskMap;
import Model.Map.Territory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


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
    }



    public void generateChildren(Agent myAgent) {
        //generate
        children = new ArrayList<>(Arrays.asList(new Node[4]));
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
        ArrayList<Node> newChildren = new ArrayList<>(Arrays.asList(new Node[4]));

        Agent i = cAgent;
        int index = state.getAgents().indexOf(i);
            if (i == null){
                return;
            }
            long num =  (long)Math.pow(10, i.getTerritoriesOccuopied().size());
            System.out.println("Started ++++++++++"+ num);
            for (long j = 0; j < num; j++) {
                long n = j;
                long sum = 0;
                while (n > 0) {
                    sum += n % 10;
                    n /= 10;
                }

                if (sum > i.getNoOfUnitsAvaliable()){
                    continue;
                }
                sum = j;
                System.out.println("num is "+sum  );
                RiskMap newRiskMap = null;
                try {
                    newRiskMap = (RiskMap) state.getCurrentRiskMap().clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println("could'nt clone");
                    e.printStackTrace();
                }
                GameState newState = new GameState(newRiskMap);

                Agent myAgent = newState.getAgents().get(state.getAgents().indexOf(i)) ;
                for (Territory x:
                     myAgent.getTerritoriesOccuopied()) {
                    x.addSoldiers(new ArmyUnits((int)(sum%10)),myAgent);
                    sum /=10;
                }

                newChildren.add(new Node(newState));
                System.out.println("placing Size "+ newChildren.size());
            }
            //don't over analyze it
        for (Node x:
             newChildren) {
            System.out.println("here");
            if (x == null){
                continue;
            }
            System.out.println("there");

            GameState s = x.getState();
            Agent ss = s.getAgents().get(index);
            Territory yy = ss.getTerritoriesOccuopied().get(0);
            GameState a = new GameState((RiskMap) x.getState().getCurrentRiskMap().clone());
            System.out.println(" a has " + a.getCurrentRiskMap().getTerritories().size()
                                + " is "+ a.getCurrentRiskMap());
           for (Territory y:a.getAgents().get(index).getTerritoriesOccuopied()) {
                for (Territory z:
                     y.getNeighboringTerritories()) {
                        y.move(z);//attack or move the whole army
                        children.add(new Node(a));
                }
            }
        }

        for (Node a:
             children) {
            System.out.println("          ++++++      ");
            if (a == null){
                continue;
            }
            for (Territory x:
                 a.getState().getCurrentRiskMap().getTerritories()) {
                System.out.println(x+ "  "+ x.getArmyUnits().getNoOfUnits());
            }
        }
        System.out.println("size of children  " + newChildren.size());
        if (parent != null) {
            for (Node newChild : newChildren) {
                if (newChild != null) {
                    if (!newChild.getState().equals(parent.getState())) {
                        children.set(newChildren.indexOf(newChild), newChild);
                    }
                }
            }
        }else {
            for (Node newChild : newChildren) {
                if (newChild != null) {
                    children.add( newChild);
                }
            }
        }
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
