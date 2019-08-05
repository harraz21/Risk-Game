package Model.Agents;

import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.Territory;

import java.util.ArrayList;

public class Agent {
    private ArrayList<Territory> territoriesOccuopied;
    private int noOfArmyUnits;
    private int noOfUnitsAvaliable;

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
        return noOfUnitsAvaliable;
    }

    public void setNoOfUnitsAvaliable(int noOfUnitsAvaliable) {
        this.noOfUnitsAvaliable = noOfUnitsAvaliable;
    }

    public int getNoOfArmyUnits() {
        return noOfArmyUnits;
    }

    public void setNoOfArmyUnits(int noOfArmyUnits) {
        this.noOfArmyUnits = noOfArmyUnits;
    }
}
