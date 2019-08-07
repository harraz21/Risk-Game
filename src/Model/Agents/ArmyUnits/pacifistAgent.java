package Model.Agents.ArmyUnits;

import Model.Agents.Agent;
import Model.Map.Territory;

import java.util.HashMap;
import java.util.Map;

public class pacifistAgent  extends Agent {
    String theplayerName = new Agent().getNameOfplayer();
    HashMap<Territory, String> armies = new HashMap<Territory, String>();
    HashMap<Territory, String> myTerritories = new HashMap<Territory, String>();
    public void reinforce() {
        int count = 0;
        int d = 0;
        int num = 0;
        String name;
        String min = "minimumCountry";




        for (Map.Entry<Territory, String> entry :myTerritories.entrySet()) {
            name = myTerritories.get(entry.getKey());
            if (name == theplayerName) {
                d++;
            }
        }
        // d now has number of all my territories
        num = d / 3;
        Territory c = null;

        for (Map.Entry<Territory, String> stayHereArmedCountry: armies.entrySet()) {
            name = myTerritories.get(stayHereArmedCountry.getKey());
            if (name == theplayerName) {
                  String armies = stayHereArmedCountry.getValue();
                if (armies.compareTo(min)>0) {//comparing strings xD
                    min = armies; // my country with the least armies
                    c = stayHereArmedCountry.getKey();
                }
            }

        }
        if (num < 3) {
            String x = min;
            x = x + 3;
            armies.put(c, x);
        } else {
            String x = min;
            x = x + num;
            armies.put(c, x);

        }
    }
    public boolean checkMycountry(String s) {
        for (Map.Entry<Territory, String> entry : myTerritories.entrySet()) {
            if (entry.getKey().name.equals(s) && !entry.getValue().equals(theplayerName)) {
                return true;
            }
        }
        return false;
    }

    public String getArmies(String s) {
        String theName = null;

        for (Map.Entry<Territory, String> entry : armies.entrySet()) {
            if (entry.getKey().name.equals(s)) {
                theName =entry.getValue();
            }
            return theName;

        }
        return theName;
    }}

