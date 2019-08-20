package Linkedlist;


import Lesson4.ICollection;

import java.util.Iterator;

public interface LinkedList<E> extends ICollection, Iterable<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    void display();

    E getFirstValue();

    Node<E> getFirst();

    Iterator<E> iterator();

    @Override
    default boolean isFull() {
        return false;
    }

    class Node<T> {
        public final T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}