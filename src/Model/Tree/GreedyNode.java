package Model.Tree;




public class GreedyNode extends Node implements Comparable<GreedyNode> {

    private int cost;
    private double weight;


    public GreedyNode(GameState state, GreedyNode parent) {
        super(state, parent);
        if (parent == null) {
            cost = 0;
        } else {
            cost = parent.getCost() + 1;
        }
    }

    @Override
    public int compareTo(GreedyNode greedyNode) {
        return (int) (this.weight - greedyNode.weight);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }

    public GreedyNode(GameState state, Node parent) {
        super(state, parent);
    }


}
