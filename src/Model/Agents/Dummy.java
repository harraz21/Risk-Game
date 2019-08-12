package Model.Agents;

import Model.Map.RiskMap;
import Model.Map.Territory;

import java.util.Random;

public class Dummy extends Agent {
    public RiskMap play(RiskMap map){
        if (this.getNoOfUnitsAvaliable()>0){
            int min = 0;
            min = this.getTerritoriesOccuopied().get(0).getArmyUnits().getNoOfUnits();
            Territory least = this.getTerritoriesOccuopied().get(0);
            int x = this.getNoOfUnitsAvaliable();
            while (x>0){
                this.getTerritoriesOccuopied().get(
                        (new Random()).nextInt(this.getTerritoriesOccuopied().size())
                ).addSoldiers(1);
                x--;
            }
            this.setNoOfUnitsAvaliable(0);
        }
        return null;
    }


}
