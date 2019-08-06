package Model.Agents.ArmyUnits;

import Model.Map.Territory;

public class ArmyUnits implements Cloneable {
   private int noOfUnits;
   private Territory territoryOccupied;

    public ArmyUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;

    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public Territory getTerritoryOccupied() {
        return territoryOccupied;
    }

    public void setTerritoryOccupied(Territory territoryOccupied) {
        this.territoryOccupied = territoryOccupied;
    }

    public Object clone() throws CloneNotSupportedException {
        ArmyUnits newArmyUnits=new ArmyUnits(noOfUnits);
        newArmyUnits.setTerritoryOccupied(territoryOccupied);
        return new ArmyUnits(noOfUnits);
    }
}
