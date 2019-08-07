package Model.Agents;

import Model.Tree.GameState;
import Model.Tree.GreedyNode;
import Model.Tree.Heuristic;
import Model.Tree.Node;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;


public class A_Star_Agent extends Agent {



        private GreedyNode initialState;
        private Heuristic heuristicType;
        private PriorityQueue<GreedyNode> frontier;
        private ArrayList<GreedyNode> frontierList;
        private ArrayList<GreedyNode> explored;
        private ArrayList<Node> path;
        private int pathCost;
        private Agent myAgent;

        public A_Star_Agent(Agent myAgent, Heuristic heuristicType) {
            this.myAgent = myAgent;
            this.heuristicType = heuristicType;
        }


        public ArrayList<Node> search(GameState board, Node parent) {
            initialState =  new GreedyNode(board, null);
            frontier = new PriorityQueue<>();
            frontierList = new ArrayList<>();
            frontier.add(initialState);
            frontierList.add(initialState);
            explored = new ArrayList<>();
            while (!frontier.isEmpty()) {
                GreedyNode state = frontier.poll();
                frontierList.remove(state);
                explored.add(state);

                if (true /* Reached goal ?*/) {
                    pathCost=state.getCost();
                    return pathToGoal(state);
                }
                state.generateChildren(myAgent);
                for (Node node : state.getChildren()) {
                    if (node != null) {
                        node = new GreedyNode(node.getState(), state);
                        if (!containedInFrontier((GreedyNode) node) && !containedInExplored((GreedyNode) node)) {
                            calculateWeight((GreedyNode) node);
                            frontier.add((GreedyNode) node);
                            frontierList.add((GreedyNode) node);
                        } else {
                            for (GreedyNode test : frontierList) {
                                if (true /*java.util.Arrays.equals(test.getState(), node.getState())*/) {
                                    calculateWeight((GreedyNode) node);
                                    if (test.getWeight() > ((GreedyNode) node).getWeight()) {
                                        frontierList.remove(test);
                                        frontier.remove(test);
                                        frontier.add((GreedyNode) node);
                                        frontierList.add((GreedyNode) node);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            return null;
        }

        public int getExploredNoOfNodes(Stack<Node> solutionPath) {
            return explored.size();
        }


        public int getMaxDepth(Stack<Node> solutionPath, int[] goal) {
            int maxDepth=0;
            for (GreedyNode node:frontierList) {
                if (node.getCost()>maxDepth)
                    maxDepth=node.getCost();
            }
            for (GreedyNode node:explored) {
                if (node.getCost()>maxDepth)
                    maxDepth=node.getCost();
            }
            return maxDepth;
        }

        private boolean containedInFrontier(GreedyNode node) {
            return false;
            /*
            for (GreedyNode test : frontierList) {
                if ((test.getState(), node.getState())) {
                    return true;
                }
            }
            return false;
            */
        }
        private boolean containedInExplored(GreedyNode node) {
            /*
            for (GreedyNode test : explored) {
                if ((test.getState()  node.getState())) {
                    return true;
                }
            }
            */
            return false;
        }

        private ArrayList<Node> pathToGoal(GreedyNode state) {
            Stack<Node> pathToGoal = new Stack<>();
            path =new ArrayList<>();
            Node node=state;
            pathToGoal.push(state);
            while (node.getParent()!=null)
            {
                pathToGoal.push(node.getParent());
                node=node.getParent();
            }
            int size = pathToGoal.size();
            for (int i = size ; i > 0 ; i--) {
                path.add(pathToGoal.pop());
            }
            return path;
        }

        private void calculateWeight(GreedyNode greedyNode) {
            greedyNode.setWeight(heuristicType.getHeuristic(greedyNode.getState()) + greedyNode.getCost());
        }

        public ArrayList<GreedyNode> getExploredgreedy() {
            return explored;
        }
        public ArrayList<Node> getExplored(){
            ArrayList<Node> x = new ArrayList<Node>();
            for (GreedyNode i:
                    explored) {
                x.add(i);
            }
            return x;
        }
        public void setExplored(ArrayList<GreedyNode> explored) {
            this.explored = explored;
        }

        public ArrayList<Node> getPath() {
            return path;
        }

        public void setPath(ArrayList<Node> path) {
            this.path = path;
        }


        public int getCostPath() {
            return pathCost;
        }

        public int getSearchDepth() {
            int  searchDepth = 0;

            for (GreedyNode node:frontierList) {
                if (node.getDepth()>searchDepth)
                    searchDepth=node.getDepth();
            }
            for (GreedyNode node:explored) {
                if (node.getDepth()>searchDepth)
                    searchDepth=node.getDepth();
            }
            return searchDepth;
        }


        public Heuristic getHeuristicType() {
            return heuristicType;
        }

        public void setHeuristicType(Heuristic heuristicType) {
            this.heuristicType = heuristicType;
        }

}
