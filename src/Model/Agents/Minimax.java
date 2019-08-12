package Model.Agents;

import Model.Map.RiskMap;
import Model.Tree.Franz_Hahn;
import Model.Tree.GameState;
import Model.Tree.Node;
import javafx.util.Pair;
import utility.Utility;

import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Minimax  extends Agent{




    public  RiskMap play (RiskMap myMap){
        Pair<GameState, Integer> result = minMaxDecision(
          new GameState(myMap),3,Integer.MIN_VALUE,Integer.MAX_VALUE,true
        ,myMap.getPlayers().indexOf(this));

        return result.getKey().getCurrentRiskMap();
    }
    public Pair<GameState, Integer> minMaxDecision(GameState position, int depth, int alpha, int beta, boolean maximizingAgent
    ,int index) {
        if (depth == 0 /**  || game is over**/) {
            Pair<GameState, Integer> pair = new Pair<GameState, Integer>(position,(int)(new Franz_Hahn()).getHeuristic(position));
            return pair;
        }
        Node myNode = new Node(position);
        GameState myGameState = null;
        //fix this laterrr
        myNode.generateChildren(((myNode.getDepth()%2)==0) ?
                myNode.getState().getAgents().get(index) : myNode.getState().getAgents().get(index).getOpponent());
        ArrayList<Node> list = myNode.getChildren();

        if (maximizingAgent) {
            int maxEval = Integer.MIN_VALUE;
            for (Node a :list ) {

                Pair<GameState, Integer>  m = minMaxDecision(a.getState(),depth-1,alpha,beta,false,index);
                int eval = m.getValue();
                 maxEval = max(maxEval,eval);
                 if (maxEval == eval){
                     myGameState = m.getKey();
                 }
                 alpha = max(alpha,eval);
                 if (beta <= alpha){
                     break;
                 }
             }
             return new Pair<GameState, Integer>(myGameState,maxEval);

        } else {
            int minEval = Integer.MAX_VALUE;

             for (Node a :list ) {

                 Pair<GameState, Integer>  m = minMaxDecision(a.getState(),depth-1,alpha,beta,true,index);
                 int eval = m.getValue();

                 minEval = min(minEval,eval) ;
                 if (minEval == eval){
                     myGameState = m.getKey();
                 }
                   beta = min(beta,eval);
              if (beta <= alpha)
                 {
                        break;
                 }
              }

            return new Pair<GameState, Integer>(myGameState,minEval);
        }

    }


}
