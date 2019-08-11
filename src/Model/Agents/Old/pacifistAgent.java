package Model.Agents.Old;

import Model.Agents.Agent;
import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.Territory;

import java.util.ArrayList;

public class pacifistAgent  extends Agent {
    String theplayerName = new Agent().getNameOfplayer();

    ArrayList<Territory> myTerritories = new ArrayList<Territory>();
    Territory attacker;
    ArmyUnits xx;

    public ArrayList<Territory> reinforce() {


        for (Territory territory : myTerritories) {
            if (territory.armyUnits.getNoOfUnits() > 3) {
                int i = 0;
                ArrayList<Territory> myTerritoriesN = new ArrayList<Territory>();
                myTerritoriesN = myTerritories.get(i).getNeighboringTerritories();

                for (Territory enemy : myTerritoriesN) {
                    if (enemy.armyUnits.getNoOfUnits() == 1)
                        return myTerritories;

                }
            }
        }

        return null;

    }

    public ArrayList<Territory> getDefender() {/**/
        ArrayList<Territory> min = this.myTerritories.get(0).getNeighboringTerritories();//mtl3bsh
        int iteration = min.size();//size Neighbor
        for (int i = 1; i < iteration; i++) {
            if (this.myTerritories.get(i).getNeighboringTerritories().equals(min)) {
                min = this.myTerritories.get(i).getNeighboringTerritories();
            }
        }
        return min;
    }






    public int continueAttacking() {
        int y= xx.getNoOfUnits();
        int b = attacker.getNeighboringTerritories().size();
        int c =b-y;
        return c ;
    }


    public void setNOofAttackingArmies() {

int attackingUnits = getNoOfArmyUnits();
int noOfFightingArmies= attackingUnits -1;
setNoOfUnitsAvaliable(noOfFightingArmies);
int fightingArmies = getNoOfArmyUnits();
        if(fightingArmies > 3) {
            fightingArmies = 3;
    }





    }
}

