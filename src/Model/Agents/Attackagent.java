package Model.Agents;
import java.util.HashMap;
import java.util.Random;

import Model.Map.Territory;

import java.util.ArrayList;

public class Attackagent extends Agent {

    //ArrayList<Territory> myTerritory;->Agent Class
    ArrayList<String> neighbours;
    public String playerName;
    static boolean attackAgain ;
    String attackSameCountryAgain ;


    public static void attackCountry(String playerName, HashMap<Terrritory> list_T) {
        attackAgain = true;
        attackSameCountryAgain= "Yes";
        boolean adjacencyCheck = false;
        boolean noOfArmiesCheck = false;
        boolean checkValidityOfDef = false;


    }



}
