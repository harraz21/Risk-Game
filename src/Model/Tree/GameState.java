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
        return currentRiskMap.getPlayers();
    }
    public Object clone() throws  CloneNotSupportedException
    {

        RiskMap newRiskMap =  new RiskMap();
        newRiskMap.setTerritories(( (RiskMap) currentRiskMap.clone()).getTerritories());
        return new GameState(newRiskMap);
    }
}
