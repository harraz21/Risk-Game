package Model.Map;

import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;

import java.util.ArrayList;
import java.util.HashMap;

public class Territory implements Cloneable {

    public String name;
    private Agent defender;
    private Agent attacker;
    public ArmyUnits armyUnits;
    private ArrayList<Territory> neighboringTerritories;


    public Territory(Agent defender, ArmyUnits armyUnits) {
        this.defender = defender;
        if (this.defender != null)
        {
            this.defender.getTerritoriesOccuopied().add(this);
        }
        this.armyUnits = armyUnits;
        neighboringTerritories = new ArrayList<Territory>();
    }
    public void move(Territory adjacent){
        int num = this.armyUnits.getNoOfUnits();
        if (num<2){
            return;
        }

        if ((adjacent.getDefender() != this.getDefender())||(adjacent.getDefender()==null)){
            //attack Territory
            System.out.println("moved "+ this.getArmyUnits().getNoOfUnits());
            attack(this.getArmyUnits(),this.getDefender());
        }else {
            adjacent.addSoldiers(num-1);
            this.removeArmies(num);
        }
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
                } else {
                    this.armyUnits.setNoOfUnits(Math.abs(remainingForces));
                }
            } else {
                if (defender != null) {
                    defender.getTerritoriesOccuopied().remove(this);
                }
                defender = attacker;
                defender.getTerritoriesOccuopied().add(this);
                this.armyUnits = armyUnits;
            }
        }
    }

    public void addSoldiers(ArmyUnits armyUnits, Agent agent) {
        if (armyUnits != null && agent == defender && neighboringTerritories.contains(armyUnits.getTerritoryOccupied())) {
            this.armyUnits.setNoOfUnits(this.armyUnits.getNoOfUnits() + armyUnits.getNoOfUnits());
        }
    }
    public void addSoldiers(int noOfArmies){
        this.armyUnits.setNoOfUnits(this.armyUnits.getNoOfUnits() + noOfArmies);
    }
    public ArmyUnits removeArmies(int noOfArmiesRemoved) {
        if (armyUnits.getNoOfUnits() - noOfArmiesRemoved >= 1) {
            armyUnits.setNoOfUnits(armyUnits.getNoOfUnits() - noOfArmiesRemoved);
            ArmyUnits newArmyUnits = new ArmyUnits(noOfArmiesRemoved);
            newArmyUnits.setTerritoryOccupied(this);
            return newArmyUnits;
        } else return null;
    }

    ///attack be 5 -> remove army 5 return Army Class -> attack?? ya bentyyyyyyyyyyyyy ?
//wat ?, 3awza size neghbor itrate 3aleh mana 3mlto kda

    public Agent getDefender() {
        return defender;
    }
    public Agent getAttacker() {
        return attacker;
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
    }//3awza size da xD

    public void setNeighboringTerritories(ArrayList<Territory> neighboringTerritories) {
        this.neighboringTerritories = neighboringTerritories;
    }
    public void addNeigbor(Territory neighboringTerritory){
        if (!this.neighboringTerritories.contains(neighboringTerritory))
          this.neighboringTerritories.add(neighboringTerritory);
        System.out.println(this.neighboringTerritories.size());
    }
    public static void neighbor(Territory A,Territory B){
        A.addNeigbor(B);
        B.addNeigbor(A);
    }
    public boolean isNeighbor(Territory A){
        if (this.neighboringTerritories.contains(A)) {
            return true;
        }else {
            return false;
        }
    }
    public Object clone() throws CloneNotSupportedException {
        Territory newTerritory = new Territory(defender, armyUnits);
        ArrayList<Territory> newNeighbours = new ArrayList<>();
        for (Territory territory : neighboringTerritories) {
            //newNeighbours.add((Territory) territory.clone());
        }
        newTerritory.setNeighboringTerritories(newNeighbours);
        return newTerritory;
    }

}
