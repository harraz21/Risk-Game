package Model.Tree;


import Model.Agents.Agent;
import Model.Map.Territory;

public class Franz_Hahn implements Heuristic {
    @Override
    public double getHeuristic(GameState state) {
            double score = 0 ;
        int sizearmy = 0;

        Agent A = state.getAgents().get(0);
        for (Territory a:
                A.getTerritoriesOccuopied()) {
            sizearmy += a.getArmyUnits().getNoOfUnits();
        }
        for (Territory a:
             A.getTerritoriesOccuopied()) {
            for (Territory b:
                 a.getNeighboringTerritories()) {
                if (b.getDefender()!=a.getDefender()){
                    score+= a.getArmyUnits().getNoOfUnits()+1;
                }
            }
        }
            score += A.getTerritoriesOccuopied().size()*10;
            score += sizearmy;
        sizearmy = 0;

        Agent B = state.getAgents().get(1);
        score -= B.getTerritoriesOccuopied().size()*5;
        for (Territory a:
                A.getTerritoriesOccuopied()) {
            sizearmy += a.getArmyUnits().getNoOfUnits();
        }
        score -= sizearmy;

        return score;
    }
    public double getHeuristic(GameState state, Agent myAgent) {
        double score = 0 ;
        int sizearmy = 0;

        Agent A = myAgent;
        for (Territory a:
                A.getTerritoriesOccuopied()) {
            sizearmy += a.getArmyUnits().getNoOfUnits();
        }
        for (Territory a:
                A.getTerritoriesOccuopied()) {
            for (Territory b:
                    a.getNeighboringTerritories()) {
                if (b.getDefender()!=a.getDefender()){
                    score+= a.getArmyUnits().getNoOfUnits()+1;
                }
            }
        }
        score += A.getTerritoriesOccuopied().size()*10;
        score += sizearmy;
        sizearmy = 0;

        Agent B = myAgent.getOpponent();
        score -= B.getTerritoriesOccuopied().size()*10;
        for (Territory a:
                A.getTerritoriesOccuopied()) {
            sizearmy += a.getArmyUnits().getNoOfUnits();
        }
        score -= sizearmy;

        return score;
    }
}
