package Model.Tree;

import Model.Agents.Agent;
import Model.Map.RiskMap;
import Model.Map.Territory;

import java.util.ArrayList;

public class GameState implements Cloneable{
    private RiskMap currentRiskMap;


    public GameState(RiskMap state){
        this.currentRiskMap = state;
    }

    public RiskMap getCurrentRiskMap() {
        return currentRiskMap;
    }

    public void setCurrentRiskMap(RiskMap currentRiskMap) {
        this.currentRiskMap = currentRiskMap;
    }
    public ArrayList<Agent> getAgents(){
        ArrayList<Agent> agents = new ArrayList<Agent>();
        for (Territory i: currentRiskMap.getTerritories()) {
            if(i.getDefender()!=null){
                if (!agents.contains(i.getDefender())){
                    agents.add(i.getDefender());
                }
            }
        }
        return agents;
    }
    public Object clone() throws  CloneNotSupportedException
    {

        RiskMap newRiskMap =  new RiskMap();
        newRiskMap.setTerritories(( (RiskMap) currentRiskMap.clone()).getTerritories());
        return new GameState(newRiskMap);
    }
}
