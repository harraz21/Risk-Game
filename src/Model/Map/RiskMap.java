package Model.Map;

import Model.Agents.Agent;

import java.util.ArrayList;
import java.util.HashMap;

public class RiskMap implements Cloneable{
    private ArrayList<Territory> territories;
    HashMap<Territory, String> myTerritories = new HashMap<Territory, String>();
    HashMap<Territory, String> armies = new HashMap<Territory, String>();

    private ArrayList<Agent> Players = new ArrayList<Agent>();
    public RiskMap(){

        territories = new ArrayList<Territory>();
    }
    public RiskMap(Agent A, Agent B){
        Players.add(A);
        Players.add(B);
        A.setOpponent(B);
        B.setOpponent(A);
        territories = new ArrayList<Territory>();
    }

    public ArrayList<Agent> getPlayers() {
        return Players;
    }

    public Object clone() throws  CloneNotSupportedException
    {
        ArrayList<Territory> territoryArrayList=new ArrayList<>();
        for (Territory territory : territories) {
            territoryArrayList.add((Territory) territory.clone());
        }

        RiskMap newRiskMap = new RiskMap();
        newRiskMap.setTerritories(territoryArrayList);
        return newRiskMap;
    }

    public ArrayList<Territory> getTerritories() {
        return territories;
    }
    public boolean isGoal(){
        for (Agent x:
             getPlayers()) {
            if (x.getTerritoriesOccuopied().size()==0)
                return true;
        }
        return false;
    }
    public void print(){
        System.out.println("+++++++++++++++++");
        for (Territory x:
             territories) {
            System.out.println("Territory "+ territories.indexOf(x)+ " " +x.getArmyUnits().getNoOfUnits()
            +" "+Players.indexOf(x.getDefender()));
        }
        System.out.println("---------------");

    }
    public void addTerritory(Territory newTerritory) {
        this.territories.add(newTerritory);
    }
    public void setTerritories(ArrayList<Territory> territories) {
        this.territories = territories;
    }
}
