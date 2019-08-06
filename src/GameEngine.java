//import Model.Agents.Agent;
//import Model.Map.Territory;
//
//public class GameEngine {
//    Agent playerA;
//    Agent playerB;
//    private static GameEngine ourInstance = new GameEngine();
//
//    public static GameEngine getInstance() {
//        return ourInstance;
//    }
//
//    private GameEngine() {
//    }
//    void newGame(Agent A,Agent B){
//        playerA = A;
//        playerB = B;
//    }
//    void addSoldier(Territory myTerrirtory){
//        if (myTerrirtory.getDefender().getNoOfUnitsAvaliable() >0){
//            myTerrirtory.addSoldiers(1);
//            myTerrirtory.getDefender().setNoOfArmyUnits(myTerrirtory.getNoOfArmies()-1);
//        }
//    }
//    void attackTerritory(Territory Attacker,Territory Defender){
//        if (Attacker.getArmyUnits().getNoOfUnits()>Defender.getArmyUnits().getNoOfUnits()){
//            Defender.removeArmies(Defender.getNoOfArmies());
//            Defender.addSoldiers(Attacker.getNoOfArmies());
//            Attacker.removeArmies(Attacker.getNoOfArmies());
//            //Defender.setDefender(Attacker.getDefender());
//            if (Defender.getDefender() == playerA){
//                playerA.addTerrirtory(Defender);
//            }else {
//                playerB.addTerrirtory(Defender);
//            }
//
//        }else {
//            Defender.removeArmies(Attacker.getNoOfArmies());
//            Attacker.removeArmies(Attacker.getNoOfArmies());
//        }
//    }
//}
