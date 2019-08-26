import java.util.Random;

public class Main {

    private final static int TREES_NUMBER = 20, MAX_HEIGHT = 4, THRESHOLD = 20;

    public static void main(String[] args) {

        Tree<Integer>[] trees = new TreeImpl[TREES_NUMBER];
        int balancedCount = 0, maxIter = getMaxIter();

        for (int i = 0; i < TREES_NUMBER; i++) {
            trees[i] = new TreeImpl<>(MAX_HEIGHT);
            buildTree(trees[i], maxIter);
            if (trees[i].isBalanced()) balancedCount++;
        }

        System.out.println("Количество сбалансированных деревьев составляет " +
                (double)balancedCount/(double)TREES_NUMBER*100 + " % от общего количества");
    }

    private static int getMaxIter(){
        int maxIter = 0;
        for (int i = 0; i < MAX_HEIGHT; i++)
            maxIter += Math.pow(2, i);
        return maxIter;
    }

    private static void buildTree(Tree tree, int maxIter){
        Random random = new Random();
        for (int i = 0; i < maxIter; i++) {
            Integer n = -THRESHOLD + random.nextInt(THRESHOLD*2);
            tree.add(n);
        }
    }

}