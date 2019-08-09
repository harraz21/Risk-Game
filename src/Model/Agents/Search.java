package Model.Agents;

import Model.Map.RiskMap;
import Model.Map.Territory;
import Model.Tree.GameState;
import Model.Tree.GreedyNode;

import java.util.ArrayList;
import java.util.Queue;

public class Search extends Agent  {
   ArrayList <Territory >attackingList=new ArrayList<Territory>();

    GameState state;
    GreedyNode root;

    public  Territory TerritoryForDeployment(){
        int min=10000;
        int borderSecurityThreat=0;
        int sum=0;
        Territory territory=null;
        for(Territory t: this.getTerritoriesOccuopied()){
            for(Territory s: t.getNeighboringTerritories()) {
                if (!getTerritoriesOccuopied().contains(s.name)) {
                    sum += s.armyUnits.getNoOfUnits();
                    if(sum==0)
                        return null;
                    borderSecurityThreat = t.armyUnits.getNoOfUnits() / sum;
                    if (borderSecurityThreat < min) {
                        min = borderSecurityThreat;
                        territory = t;
                    }


                }
            }
        }
        return territory;
    }

}
