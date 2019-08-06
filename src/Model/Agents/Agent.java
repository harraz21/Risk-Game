package Model.Agents;

import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.Territory;

import java.util.ArrayList;

public class Agent implements Cloneable {
    private ArrayList<Territory> territoriesOccuopied;
    private int noOfArmyUnits;
    private int noOfUnitsAvailable;

    public ArrayList<Territory> getTerritoriesOccuopied() {
        return territoriesOccuopied;
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
        Agent newAgent= new Agent();
        newAgent.setNoOfArmyUnits(noOfArmyUnits);
        newAgent.setNoOfArmyUnits(noOfUnitsAvailable);
        newAgent.setTerritoriesOccuopied(newTerritories);
        return newAgent;
    }
}
