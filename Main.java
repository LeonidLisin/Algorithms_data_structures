public class Main {

    public static void main(String[] args) {
        HashTable<ItemDefinition, Integer> hashTable = new HashTableChains<>(5);

        ItemDefinition orange = new ItemDefinition(1, "Orange");
        ItemDefinition banana = new ItemDefinition(71, "Banana");
        ItemDefinition lemon = new ItemDefinition(60, "Lemon");
        ItemDefinition milk = new ItemDefinition(52, "Milk");
        ItemDefinition potato = new ItemDefinition(21, "Potato");
        ItemDefinition cucumber = new ItemDefinition(24, "Cucumber");

        hashTable.put(orange, 150);
        hashTable.put(banana, 100);
        hashTable.put(lemon, 250);
        hashTable.put(milk, 120);
        hashTable.put(potato, 67);
        hashTable.put(cucumber, 637);

        hashTable.display();
        System.out.println("Size is " + hashTable.size());
        System.out.println("Is full? " + hashTable.isFull());
        System.out.println();

        System.out.println("Contains potato? " + hashTable.contains(potato));
        System.out.println("Contains cucumber? " + hashTable.contains(cucumber));

        System.out.println();
        System.out.println("Attempt to remove banana, value is " + hashTable.remove(banana));
        System.out.println("Attempt to remove potato, value is " + hashTable.remove(potato));
        System.out.println("Attempt to remove orange, value is " + hashTable.remove(orange));

        hashTable.display();
        System.out.println("Size is " + hashTable.size());
        System.out.println("Is full? " + hashTable.isFull());
        System.out.println();


        System.out.println("Attempt to put potato: " + hashTable.put(potato, 3));
        System.out.println("Attempt to put cucumber: " + hashTable.put(cucumber, 30));
        System.out.println("Attempt to put potato: " + hashTable.put(potato, 45));
        System.out.println("Attempt to put banana: " + hashTable.put(banana, 23));

        hashTable.display();

        System.out.println("Potato value is " + hashTable.get(potato));
        System.out.println("Contains potato? " + hashTable.contains(potato));
        System.out.println("Contains banana? " + hashTable.contains(banana));
        System.out.println("Contains cucumber? " + hashTable.contains(cucumber));
        System.out.println("Attempt to remove banana, value is " + hashTable.remove(banana));
        System.out.println("Contains banana? " + hashTable.contains(banana));
        System.out.println("Attempt to remove banana, value is " + hashTable.remove(banana));
    }
}