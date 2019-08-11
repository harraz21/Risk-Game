package Model.Map;

import java.util.ArrayList;
import java.util.HashMap;

public class RiskMap implements Cloneable{
    private ArrayList<Territory> territories;
    HashMap<Territory, String> myTerritories = new HashMap<Territory, String>();
    HashMap<Territory, String> armies = new HashMap<Territory, String>();


    public RiskMap(){

        territories = new ArrayList<Territory>();
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

    public void addTerritory(Territory newTerritory) {
        this.territories.add(newTerritory);
    }
    public void setTerritories(ArrayList<Territory> territories) {
        this.territories = territories;
    }
}