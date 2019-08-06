package Model.Agents;
import java.util.HashMap;
import java.util.Random;

import Model.Map.Territory;
import java.util.ArrayList;

public class Attackagent extends Agent {




    Public Territory getAttacker() {
        if(this.canAttack())
        {
            ArrayList<Territory> canAttackTerritories = new ArrayList<>();
            territories.stream().filter((ter) -> (ter.canAttack())).forEachOrdered((ter) -> {
                canAttackTerritories.add(ter);
            });
            Territory max = canAttackTerritories.get(0);
            for(int i=1;i<canAttackTerritories.size();i++)
            {
                if(canAttackTerritories.get(i).compareTo(max) > 0)
                {
                    max = canAttackTerritories.get(i);
                }else if(canAttackTerritories.get(i).compareTo(max) == 0)
                {
                    if(canAttackTerritories.get(i).enemyNeighbors.size() > max.enemyNeighbors.size())
                        max = canAttackTerritories.get(i);
                }
            }
            return max;
        }
        return null;
    }


    public Territory getDefender() {
        Territory min = this.attacker.enemyNeighbors.get(0);
        for(int i=1;i<this.attacker.enemyNeighbors.size();i++)
        {
            if(this.attacker.enemyNeighbors.get(i).compareTo(min) < 0)
            {
                min = this.attacker.enemyNeighbors.get(i);
            }
        }
        return min;
    }

    public boolean continueAttacking()
    {
        return (this.attacker == getMax() && this.canAttack());
    }
    protected void setNOofAttackingArmies() {
        attacker.noOfFightingArmies = attacker.noOfArmies - 1;
        if(attacker.noOfFightingArmies > 3)
            attacker.noOfFightingArmies = 3;
    }
}



}
