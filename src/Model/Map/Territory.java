package Model.Map;

import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;

import java.util.ArrayList;

public class Territory implements Cloneable {
    private Agent defender;
    private ArmyUnits armyUnits;
    private ArrayList<Territory> neighboringTerritories;


    public Territory(Agent defender, ArmyUnits armyUnits) {
        this.defender = defender;
        this.armyUnits = armyUnits;
        neighboringTerritories = new ArrayList<Territory>();
    }

    public void attack(ArmyUnits armyUnits, Agent attacker) {
        if (armyUnits != null && attacker != defender) {
            if (this.armyUnits != null) {
                int remainingForces = armyUnits.getNoOfUnits() - this.armyUnits.getNoOfUnits();
                if (remainingForces >= 0) {
                    defender.getTerritoriesOccuopied().remove(this);
                    defender = attacker;
                    defender.getTerritoriesOccuopied().add(this);
                    armyUnits.setTerritoryOccupied(this);
                    armyUnits.setNoOfUnits(remainingForces);
                    this.armyUnits = armyUnits;
                }
            } else {
                defender = attacker;
                defender.getTerritoriesOccuopied().add(this);
                armyUnits.setTerritoryOccupied(this);
                this.armyUnits=armyUnits;
            }
        }
    }

    public void addSoldiers(ArmyUnits armyUnits, Agent agent) {
        if (armyUnits != null && agent == defender && neighboringTerritories.contains(armyUnits.getTerritoryOccupied())) {
            this.armyUnits.setNoOfUnits(armyUnits.getNoOfUnits() + armyUnits.getNoOfUnits());
        }
    }

    public ArmyUnits removeArmies(int noOfArmiesRemoved) {
        if (armyUnits.getNoOfUnits() - noOfArmiesRemoved > 1) {
            armyUnits.setNoOfUnits(armyUnits.getNoOfUnits() - noOfArmiesRemoved);
            return new ArmyUnits(noOfArmiesRemoved);
        } else return null;
    }

    public Agent getDefender() {
        return defender;
    }

    public void setDefender(Agent defender) {
        this.defender = defender;
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


    public Object clone() throws CloneNotSupportedException {
        Territory newTerritory = new Territory(defender,armyUnits);
        ArrayList<Territory> newNeighbours = new ArrayList<>();
        for (Territory territory:neighboringTerritories) {
            newNeighbours.add((Territory) territory.clone());
        }
        newTerritory.setNeighboringTerritories(newNeighbours);
        return newTerritory;
    }

}
