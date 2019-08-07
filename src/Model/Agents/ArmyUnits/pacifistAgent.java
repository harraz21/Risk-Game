package Model.Agents.ArmyUnits;

import Model.Agents.Agent;
import Model.Map.RiskMap;
import Model.Map.Territory;

import java.awt.*;
import java.util.ArrayList;
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
        int min = 999;




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
                  Territory armies = stayHereArmedCountry.getValue();
                if (armies<min) {
                    min = armies; // my country with the least armies
                    c = stayHereArmedCountry.getKey();
                }
            }

        }
        if (num < 3) {
            int x = min;
            x = x + 3;
            armies.put(c, x);
        } else {
            int x = min;
            x = x + num;
            armies.put(c, x);

        }
    }









}
