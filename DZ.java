import Linkedlist.*;

public class DZ {
    public static void main(String[] args) {
        LinkedList<Integer> simpleLinkedList = new SimpleLinkedListImpl();

        simpleLinkedList.insertFirst(1);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(3);

        for (Integer f: simpleLinkedList){
            System.out.println(f);
        }

        simpleLinkedList.removeFirst();

        System.out.println("=====");

        for (Integer f: simpleLinkedList){
            System.out.println(f);
        }



    }
}
