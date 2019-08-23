package KnapSack;

import java.util.*;

public class Knapsack {
    private final int MAX_WEIGHT = 5;
    private ArrayList<Thing> things;
    private ArrayList<ArrayList<Thing>> combinations;
    Knapsack(Thing... things){
        this.things = new ArrayList();
        combinations = new ArrayList<>();
        Collections.addAll(this.things, things);
    }

    ArrayList<Thing> getBestPackage(){
        ArrayList<Thing> bestPackage = new ArrayList<>();
        ArrayList<ArrayList<Thing>> temp = new ArrayList<>();
        int summaryCost = 0, summaryWeigth = 0, bestCost = 0;
        select(things.size(), things);
        for(ArrayList<Thing> c: combinations) {
            for (Thing t : c) {
                summaryWeigth += t.getWeight();
            }
            if(summaryWeigth <= MAX_WEIGHT) temp.add(c);
            summaryWeigth = 0;
        }

        for (ArrayList<Thing> c: temp) {
            for (Thing t : c)
                summaryCost += t.getCost();
            if (summaryCost > bestCost){
                bestCost = summaryCost;
                bestPackage = c;
            }
            summaryCost = 0;
        }

        return bestPackage;
    }

    private void select(int size, ArrayList<Thing> things2){
        if(size == 0) return;
        ArrayList<Thing> collect = new ArrayList<>(), temp;
        for (int i = 0; i < size ; i++) {
            collect.add(things2.get(i));
            temp = new ArrayList<>(things2);
            temp.remove(i);
            select(size-1, temp);
        }
        combinations.add(collect);

    }
}
