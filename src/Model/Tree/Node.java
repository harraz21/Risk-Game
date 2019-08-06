package Model.Tree;




import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.Map;
import Model.Map.Territory;

import java.util.ArrayList;
import java.util.Arrays;



public class Node {

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



    public void generateChildren() {
        //generate
        children = new ArrayList<>(Arrays.asList(new Node[4]));
        int emptyTile = -1;

        moveTile(emptyTile);
    }

    private void moveTile(int emptyTile) {
        //Move
        ArrayList<Node> newChildren = new ArrayList<>(Arrays.asList(new Node[4]));

        for (Agent i:
             state.getAgents()) {
            if (i == null){
                continue;
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
                Map newMap = null;
                try {
                    newMap = (Map) state.getCurrentMap().clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println("could'nt clone");
                    e.printStackTrace();
                }
                GameState newState = new GameState(newMap);

                Agent myAgent = newState.getAgents().get(state.getAgents().indexOf(i)) ;
                for (Territory x:
                     myAgent.getTerritoriesOccuopied()) {
                    x.addSoldiers(new ArmyUnits((int)(sum%10)),myAgent);
                    sum /=10;
                }
                newChildren.add(new Node(newState));
                System.out.println("Size "+ newChildren.size());
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


}
