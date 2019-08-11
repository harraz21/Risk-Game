package Model.Agents;

import Model.Map.RiskMap;
import Model.Map.Territory;

public class Aggressive extends Agent{
    public void play(RiskMap map){
        if (this.getNoOfUnitsAvaliable()>0){
            int max = 0;
            max = this.getTerritoriesOccuopied().get(0).getArmyUnits().getNoOfUnits();
            Territory most = this.getTerritoriesOccuopied().get(0);
            for (Territory myTerritory:
                    this.getTerritoriesOccuopied()) {
                if (myTerritory.getArmyUnits().getNoOfUnits() >= max){
                    most = myTerritory;
                    max = myTerritory.getArmyUnits().getNoOfUnits();
                }
            }
            most.addSoldiers(this.getNoOfUnitsAvaliable());
            this.setNoOfUnitsAvaliable(0);
        }
        int size = this.getTerritoriesOccuopied().size();
        for (int i =0 ;i<size ; i++) {
            Territory x = this.getTerritoriesOccuopied().get(i);

            int diff = 100000;
            Territory attack = null;
            for (Territory y:
                    x.getNeighboringTerritories()) {

                if (y.getDefender()!=x.getDefender()){
                    if (y.getArmyUnits().getNoOfUnits()<(x.getArmyUnits().getNoOfUnits()-1)){
                        if (diff>((x.getArmyUnits().getNoOfUnits()-1)-y.getArmyUnits().getNoOfUnits())){
                            diff = ((x.getArmyUnits().getNoOfUnits()-1)-y.getArmyUnits().getNoOfUnits());
                            attack = y;
                        }
                    }
                }
            }
            if (attack !=null)
               attack.attack(x.removeArmies(x.getArmyUnits().getNoOfUnits()-1),x.getDefender());
        }

    }
}
