package KnapSack;

public class KnapsackMain {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(
                new Thing("Книга", 1, 600),
                new Thing("Бинокль", 2, 5000),
               new Thing("Аптечка", 4, 1500),
                new Thing("Ноутбук", 2, 40000),
                new Thing("Котелок", 1, 500));


        for(Thing t: knapsack.getBestPackage())
            System.out.println(t.getName());
    }
}
