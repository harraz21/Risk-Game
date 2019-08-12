package Model.Agents;

import Model.Map.RiskMap;
import Model.Map.Territory;

public class Pacifist extends Agent{

    public RiskMap play(RiskMap map){
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
        int size = this.getTerritoriesOccuopied().size();
        for (int i =0 ;i<size ; i++) {
            Territory x = this.getTerritoriesOccuopied().get(i);
            int diff = 0;
            Territory attack = null;
            for (Territory y:
                 x.getNeighboringTerritories()) {
                if (y.getDefender()!=x.getDefender()){
                    if (y.getArmyUnits().getNoOfUnits()<(x.getArmyUnits().getNoOfUnits()-1)){
                        if (diff<((x.getArmyUnits().getNoOfUnits()-1)-y.getArmyUnits().getNoOfUnits())){
                            diff = ((x.getArmyUnits().getNoOfUnits()-1)-y.getArmyUnits().getNoOfUnits());
                            attack = y;
                        }
                    }
                }
            }
            if (attack !=null)
                attack.attack(x.removeArmies(x.getArmyUnits().getNoOfUnits()-1),x.getDefender());
        }
        return null;
    }
}
