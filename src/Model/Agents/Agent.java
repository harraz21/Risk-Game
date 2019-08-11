package Model.Agents;

import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.Territory;

import java.util.ArrayList;

public class Agent implements Cloneable {
    private ArrayList<Territory> territoriesOccuopied;
    private int noOfArmyUnits;
    private int noOfUnitsAvailable;
    private String playerName;
    private Agent opponent;
    public Agent(){
        territoriesOccuopied = new ArrayList<Territory>();
    }
    public ArrayList<Territory> getTerritoriesOccuopied() {
        return territoriesOccuopied;
    }

    public void setOpponent(Agent opponent) {
        this.opponent = opponent;
    }

    public void setTerritoriesOccuopied(ArrayList<Territory> territoriesOccuopied) {
        this.territoriesOccuopied = territoriesOccuopied;
    }
    public void addTerrirtory(Territory addedTerritory) {
        this.territoriesOccuopied.add(addedTerritory);
    }

    public int getNoOfUnitsAvaliable() {
        return noOfUnitsAvailable;
    }
    public String getNameOfplayer() {
        return playerName;
    }

    public void setNoOfUnitsAvaliable(int noOfUnitsAvaliable) {
        this.noOfUnitsAvailable = noOfUnitsAvaliable;
    }

    public int getNoOfArmyUnits() {
        return noOfArmyUnits;
    }

    public void setNoOfArmyUnits(int noOfArmyUnits) {
        this.noOfArmyUnits = noOfArmyUnits;
    }

    public Object clone() throws  CloneNotSupportedException
    {
       ArrayList<Territory> newTerritories = new ArrayList<>();
        for (Territory territory:territoriesOccuopied) {
            newTerritories.add((Territory) territory.clone());
        }
        for (Territory x:
             territoriesOccuopied) {
            for (Territory y:
                 territoriesOccuopied) {
                if (x.isNeighbor(y)){
                    Territory.neighbor(newTerritories.get(territoriesOccuopied.indexOf(x))
                            ,newTerritories.get(territoriesOccuopied.indexOf(y))) ;
                }
            }

        }
        Agent newAgent= new Agent();
        newAgent.setNoOfArmyUnits(noOfArmyUnits);
        newAgent.setNoOfArmyUnits(noOfUnitsAvailable);
        newAgent.setTerritoriesOccuopied(newTerritories);
        return newAgent;
    }
}
