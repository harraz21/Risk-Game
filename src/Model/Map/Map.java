package Model.Map;

import java.util.ArrayList;

public class Map implements Cloneable{
    private ArrayList<Territory> territories;



    public Object clone() throws  CloneNotSupportedException
    {
        ArrayList<Territory> territoryArrayList=new ArrayList<>();
        for (Territory territory : territories) {
            territoryArrayList.add((Territory) territory.clone());
        }
        Map newMap = new Map();
        newMap.setTerritories(territoryArrayList);
        return newMap;
    }

    public ArrayList<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(ArrayList<Territory> territories) {
        this.territories = territories;
    }
}
