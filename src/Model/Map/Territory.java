package Model.Map;

import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;

import java.util.ArrayList;

public class Territory {
    private Agent defender;
    private int noOfArmies;
    private ArmyUnits armyUnits;
    private ArrayList<Territory> neighboringTerritories;


    Territory(Agent Owner){
        this.defender = Owner;
        System.out.println("Added Territory");
    }

    public void attack(ArmyUnits armyUnits)
    {

    }
    public void addSoldiers(int noOfArmiesAdded)
    {
        armyUnits.setNoOfUnits(armyUnits.getNoOfUnits()+noOfArmies);
        noOfArmies=noOfArmies+noOfArmiesAdded;
    }

    public ArmyUnits removeArmies(int noOfArmiesRemoved)
    {
        if (armyUnits.getNoOfUnits()-noOfArmiesRemoved>1)
        {
            armyUnits.setNoOfUnits(armyUnits.getNoOfUnits()-noOfArmiesRemoved);
            noOfArmies=armyUnits.getNoOfUnits();
            return new ArmyUnits(noOfArmiesRemoved);
        }
        else return null;
    }

    public Agent getDefender() {
        return defender;
    }

    public void setDefender(Agent defender) {
        this.defender = defender;
    }

    public int getNoOfArmies() {
        return noOfArmies;
    }

    public void setNoOfArmies(int noOfArmies) {
        this.noOfArmies = noOfArmies;
    }

    public ArmyUnits getArmyUnits() {
        return armyUnits;
    }

    public void setArmyUnits(ArmyUnits armyUnits) {
        this.armyUnits = armyUnits;
    }

    public ArrayList<Territory> getNeighboringTerritories() {
        return neighboringTerritories;
    }

    public void setNeighboringTerritories(ArrayList<Territory> neighboringTerritories) {
        this.neighboringTerritories = neighboringTerritories;
    }

}
