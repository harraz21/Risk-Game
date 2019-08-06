package Model.Tree;

import Model.Agents.Agent;
import Model.Map.Map;
import Model.Map.Territory;

import java.util.ArrayList;

public class GameState {
    private Map currentMap;


    public GameState(Map state){
        this.currentMap = state;
    }

    public Map getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }
    public ArrayList<Agent> getAgents(){
        ArrayList<Agent> agents = new ArrayList<Agent>();
        for (Territory i: currentMap.getTerritories()) {
            if(i.getDefender()!=null){
                if (!agents.contains(i.getDefender())){
                    agents.add(i.getDefender());
                }
            }
        }
        return agents;
    }
}
