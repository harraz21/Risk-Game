package Model.Agents;

import Model.Map.RiskMap;
import Model.Map.Territory;

public class Passive extends Agent {
    public void play(RiskMap map){
        if (this.getNoOfUnitsAvaliable()>0){
            int min = 0;
            min = this.getTerritoriesOccuopied().get(0).getArmyUnits().getNoOfUnits();
            Territory least = this.getTerritoriesOccuopied().get(0);
            for (Territory myTerritory:
                 this.getTerritoriesOccuopied()) {
                if (myTerritory.getArmyUnits().getNoOfUnits() <= min){
                    least = myTerritory;
                    min = myTerritory.getArmyUnits().getNoOfUnits();
                }
            }
            least.addSoldiers(this.getNoOfUnitsAvaliable());
            this.setNoOfUnitsAvaliable(0);
        }

    }


}
