package Model.Agents;

import Model.Agents.ArmyUnits.ArmyUnits;
import Model.Map.Territory;
import Model.Tree.GameState;
import Model.Tree.GreedyNode;

import java.util.ArrayList;

public class Search extends Agent  {
   ArrayList <Territory >attackingList=new ArrayList<Territory>();
    ArrayList<Territory> attacker;
    GreedyNode Greedy;
    ArrayList<GreedyNode> g;


    GameState state;
    Territory root;

    public  Territory TerritoryForDeployment(){
        int min=10000;
        int borderSecurityThreat=0;
        int sum=0;
        Territory territory=null;
        for(Territory t: this.getTerritoriesOccuopied()){
            for(Territory s: t.getNeighboringTerritories()) {
                if (!getTerritoriesOccuopied().contains(s.name)) {
                    sum += s.armyUnits.getNoOfUnits();
                    if(sum==0)
                        return null;
                    borderSecurityThreat = t.armyUnits.getNoOfUnits() / sum;
                    if (borderSecurityThreat < min) {
                        min = borderSecurityThreat;
                        territory = t;
                    }


                }
            }
        }
        return territory;
    }

    public void Search() {/*
        attacker = new ArrayList<>();
        GreedyNode s;
        long t2 = 0;
        long t1 = System.currentTimeMillis();
        GreedyNode solution = null;
        GameState state = null;
        GreedyNode parent = null;

        GreedyNode parent1 = parent;

        int min= new ArrayList<Territory>;
        for (Territory t : this.getTerritoriesOccuopied()) {
            int i = 0;
            solution.setCost(getNoOfArmyUnits());
            getTerritoriesOccuopied();




                   }
        Territory x = TerritoryForDeployment();
        if (x == null) return ;

        min=x.armyUnits.getNoOfUnits();
        int root = min;
Greedy.setCost(root);




                while (!getTerritoriesOccuopied().isEmpty() && (t2 - t1) / 1000 < 5) {
            ArrayList<Territory> ter = new ArrayList<Territory>();
            ArrayList<Territory> ter1 =getTerritoriesOccuopied();
            for (Territory t : ter1) {
                ter.add(t);

            }
            for (Territory t : ter) {
                for (Territory territory : t.getNeighboringTerritories()) {

                    if (!Contain(ter, territory) && t.armyUnits.getNoOfUnits() > territory.armyUnits.getNoOfUnits()) {
                        g = new GreedyNode(GameState state, GreedyNode parent);
                        for (Territory ter2 : ter) {
                          //  g.add(ter2);

                        }

                        // Log.e("g.occupied", String.valueOf(g.occupied.size()));
                        g.add(goToNextNode());
                        if (solution.getDepth() < g.size()) {
                            solution = g;
                            root.addChild(g);
                            Greedy.add(g);
                            T++;
                        }
                    }
                }


            }
            if (Greedy.getDepth() > 0) {
                root = NextNode();
                //same.add(root);
            }
            t2 = System.currentTimeMillis();
        }
        while (solution != null) {
            ArrayList<Territory>   p = getTerritoriesOccuopied();
            attacker.add(p);
            solution = solution.getParent();
        }
*/    }

      /*  private GreedyNode goToNextNode(){
            int alpha = 300000000;
            int index = 0;
            for (int i=0; i<Greedy.getDepth();i++) {
                int h = (Greedy.getDepth());
                if (h < alpha) {
                    alpha = h;
                    index = Greedy.getDepth(i);

                }
            }

            GreedyNode newNode = Greedy.getDepth(i);
            Greedy.remove(index);
            return newNode;

        }*/



    public int heuristic(GreedyNode node) {
        int h=0;
        int sum=0;
        ArrayList<Territory> territory;
        int numberOfTroops= getNoOfArmyUnits();
        Agent defender=null;
        ArmyUnits y=null;

        Territory neib= new Territory(defender,y);

        territory= getTerritoriesOccuopied();
        for(Territory s: neib.getNeighboringTerritories()){
            if(this.getTerritoriesOccuopied().contains(s.name)){
             //   sum+=s.numberOfTroops;
            }
        }
        if(numberOfTroops==0)
            return 0;
        h=sum/numberOfTroops;


        return h;
    }



    }








