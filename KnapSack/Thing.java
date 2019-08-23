package KnapSack;

public class Thing {
    private int weight, cost;
    private String name;

    Thing(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    int getWeight() {
        return weight;
    }

    int getCost() {
        return cost;
    }

    String getName() {
        return name;
    }

}
