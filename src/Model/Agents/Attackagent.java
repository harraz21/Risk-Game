package Model.Agents;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import Model.Map.Territory;
import java.util.ArrayList;

public class Attackagent extends Agent {
     Territory attacker;



    public Territory getAttacker() {
        if(this.continueAttacking())
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

    public boolean continueAttacking()
    {
        return (this.attacker== getMax() && this.attack());
    }
    protected void setNOofAttackingArmies() {
        attacker.armyUnits = attacker.armyUnits - 1;
        if(attacker.armyUnits > 3)
            attacker.armyUnits = 3;
    }
}




