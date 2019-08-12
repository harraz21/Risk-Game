package Model.Agents;

import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.RiskMap;
import Model.Map.Territory;

import java.util.ArrayList;

public class Agent implements Cloneable {
    private ArrayList<Territory> territoriesOccuopied;
    private int noOfArmyUnits;
    private int noOfUnitsAvailable;
    private String playerName;
    private Agent opponent;
    public Agent(){
        territoriesOccuopied = new ArrayList<Territory>();
    }
    public ArrayList<Territory> getTerritoriesOccuopied() {
        return territoriesOccuopied;
    }

    public void setOpponent(Agent opponent) {
        this.opponent = opponent;
    }

    public void setTerritoriesOccuopied(ArrayList<Territory> territoriesOccuopied) {
        this.territoriesOccuopied = territoriesOccuopied;
    }
    public void addTerrirtory(Territory addedTerritory) {
        this.territoriesOccuopied.add(addedTerritory);
    }

    public int getNoOfUnitsAvaliable() {
        return noOfUnitsAvailable;
    }
    public String getNameOfplayer() {
        return playerName;
    }

    public void setNoOfUnitsAvaliable(int noOfUnitsAvaliable) {
        this.noOfUnitsAvailable = noOfUnitsAvaliable;
    }

    public int getNoOfArmyUnits() {
        return noOfArmyUnits;
    }

    public void setNoOfArmyUnits(int noOfArmyUnits) {
        this.noOfArmyUnits = noOfArmyUnits;
    }

    public void updateUnitsAvaliable(){
        int no = this.getTerritoriesOccuopied().size()/3;
        if (no<3){
            no = 3;
        }
        System.out.println("updated with "+no);
        this.setNoOfUnitsAvaliable(no);
    }
    public RiskMap play(RiskMap myMap){
        try {
           return  ((Passive)this).play(myMap);

        }catch (Exception a){
            try {
                return ((Pacifist)this).play(myMap);

            }catch (Exception b){
                try {
                    return  ((Aggressive)this).play(myMap);

                }catch (Exception c){
                    try {
                        return ((Human)this).play(myMap);

                    }catch (Exception d){
                        try {
                            return ((Greedy)this).play(myMap);

                        }catch (Exception e){
                            try {
                                return  ((A_Star)this).play(myMap);

                            }catch (Exception f){
                                   f.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    public Object clone() throws  CloneNotSupportedException
    {

        Agent newAgent= null;
        if (this instanceof Aggressive){
            newAgent = new Aggressive();
        }else if (this instanceof Passive){
            newAgent = new Passive();
        }else if (this instanceof Pacifist){
        newAgent = new Pacifist();
         }else if (this instanceof Human    ){
            newAgent = new Human();
        }else if (this instanceof Greedy){
            newAgent = new Greedy();
        }else{
            System.out.println("Something is wrong");
        }
        newAgent.setNoOfArmyUnits(noOfArmyUnits);
        newAgent.setNoOfUnitsAvaliable(noOfUnitsAvailable);
       // newAgent.setTerritoriesOccuopied(newTerritories);
        return newAgent;
    }
}
