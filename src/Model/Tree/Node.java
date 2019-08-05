package Model.Tree;




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

    Node(GameState myState) {
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
                    children.set(newChildren.indexOf(newChild), newChild);
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
        GameState n = new GameState();

        return false;}


}
