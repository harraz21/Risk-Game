package Model.Tree;


import Model.Agents.Agent;

public class Franz_Hahn implements Heuristic {
    @Override
    public double getHeuristic(GameState state) {
            double score = 0 ;
            Agent A = state.getAgents().get(0);
            score += A.getTerritoriesOccuopied().size();
            score += A.getNoOfArmyUnits();
        Agent B = state.getAgents().get(0);
        score -= B.getTerritoriesOccuopied().size();
        score -= B.getNoOfArmyUnits();

        return score;
    }
}
