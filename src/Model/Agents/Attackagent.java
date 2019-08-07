package Model.Agents;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.Territory;
import java.util.ArrayList;

import static sun.management.MemoryUsageCompositeData.getMax;

public class Attackagent extends Agent {
     Territory attacker;
    ArmyUnits xx;



    public Territory getAttacker() {
        if(this.continueAttacking()==0)
        {


            ArrayList<Territory> canAttackTerritories = new ArrayList<Territory>();
            ArrayList<Territory> territories = new ArrayList<>();


            Territory max = canAttackTerritories.get(0);
            for(int i=1;i<canAttackTerritories.size();i++)
            {boolean comparing = canAttackTerritories.get(i).equals(max);

                if(comparing =false)
                {
                    max = canAttackTerritories.get(i);
                }else if(comparing= true)
                {
                    if(canAttackTerritories.get(i).getNeighboringTerritories().size() > max.getNeighboringTerritories().size())
                        max = canAttackTerritories.get(i);
                }
            }
            return max;
        }
        return null;
    }


    public Territory getDefender() {
        Territory min = this.attacker.getNeighboringTerritories().get(0);
        for(int i=1;i<this.attacker.getNeighboringTerritories().size();i++)
        {
            boolean y = attacker.getNeighboringTerritories().get(i).equals(min);
            if(y =false )
            {
                min = this.attacker.getNeighboringTerritories().get(i);
            }
        }
        return min;
    }

    public int  continueAttacking()
    {
          int y= xx.getNoOfUnits();
          int b = attacker.getNeighboringTerritories().size();
        int c =b-y;
        return c ;
    }




}




