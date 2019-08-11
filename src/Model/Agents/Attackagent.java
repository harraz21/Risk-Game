package Model.Agents;

import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.Territory;

import java.util.ArrayList;

public class Attackagent extends Agent {
     Territory attacker;



    public Territory getAttacker() {
        System.out.println("Attacking Her :'( ");

        if(this.continueAttacking()>0)
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

        System.out.println("Spreed Units");
        if ( this.attacker.getNeighboringTerritories().get(0)!=null){
        Territory min = this.attacker.getNeighboringTerritories().get(0);
        for(int i=1;i<this.attacker.getNeighboringTerritories().size();i++)
        {
            boolean y = attacker.getNeighboringTerritories().get(i).equals(min);
            if(y =false )
            {
                min = this.attacker.getNeighboringTerritories().get(i);
            }
        }        return min;
        }
        return null;
    }

    public int  continueAttacking()
    {  ArmyUnits xx = new ArmyUnits(0);
        System.out.println("3arekny After ta3del");
         xx.setNoOfUnits(5);
        int u = xx.getNoOfUnits();
        System.out.println(u);
       // System.out.println(u +"units" );

        int b =2;// attacker.getNeighboringTerritories().size();
        System.out.println(b);

        int c =u-b;
        System.out.println(c );
        return c ;
    }




}




