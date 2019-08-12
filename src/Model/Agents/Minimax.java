package Model.Agents;

import Model.Map.RiskMap;
import Model.Tree.GameState;
import javafx.util.Pair;
import utility.Utility;

public class Minimax {
    public Pair<GameState,Integer> minMaxDecision(GameState position , int depth, int beta, boolean maximizingAgent)
    {
        if (depth == 0 /**  || game is over**/)
        {
            Pair<GameState,Integer> pair = new Pair<>(position,Utility.eval(position));

            return pair;
        }

        if (maximizingAgent)
        {
            int maxEval = Integer.MIN_VALUE;
            /**for (: child for position  ) {
                int eval = minMaxDecision(child,depth-1,false);
             maxEval = max(maxEval,eval)
            }
             return the value and the last gamestate returned that value
             **/
        }else {
            int minEval = Integer.MAX_VALUE;
            /**
             * foreach child
             * eval = minimax(child ,depth-1,true)
             * minEval = min(minEval,eval)
             *
             * return the value and the last gamestate returned that value
             * **/
        }
        //temporary
        return null;
    }



}
