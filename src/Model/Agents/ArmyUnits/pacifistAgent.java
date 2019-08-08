package Model.Agents.ArmyUnits;

import Model.Agents.Agent;
import Model.Map.Territory;

import java.util.ArrayList;

public class pacifistAgent  extends Agent {
    String theplayerName = new Agent().getNameOfplayer();

    ArrayList<Territory> myTerritories = new ArrayList<Territory>();


    public ArrayList<Territory> reinforce() {


        for(Territory territory:myTerritories) {
            if (territory.armyUnits.getNoOfUnits() > 3) {
                int i = 0;
                ArrayList<Territory> myTerritoriesN =new ArrayList<Territory>();
                   myTerritoriesN= myTerritories.get(i).getNeighboringTerritories();

                for (Territory enemy :myTerritoriesN) {
                    if (enemy.armyUnits.getNoOfUnits() == 1)
                        return myTerritories;

                }
            }
        }

        return  null;

    }

    public ArrayList<Territory> getDefender() {/**/
        ArrayList<Territory> min = this.myTerritories.get(0).getNeighboringTerritories();//mtl3bsh
     int iteration =  min.size();//size;hena moshkela  3awza size*********** neighbor***!!!
        for(int i=1;i<iteration;i++)
        {
            if(this.myTerritories.get(i).getNeighboringTerritories().equals(min))
            {
                min = this.myTerritories.get(i).getNeighboringTerritories();
            }
        }
        return min;
    }


    public boolean continueAttacking()
    {
    return  true; }


    protected void setNOofAttackingArmies() {






    }



}


