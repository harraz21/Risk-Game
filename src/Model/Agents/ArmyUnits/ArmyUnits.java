package Model.Agents.ArmyUnits;

public class ArmyUnits {
   private int noOfUnits;
   private int territoryOccupied;

    public ArmyUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;

    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    public int getTerritoryOccupied() {
        return territoryOccupied;
    }

    public void setTerritoryOccupied(int territoryOccupied) {
        this.territoryOccupied = territoryOccupied;
    }
}
