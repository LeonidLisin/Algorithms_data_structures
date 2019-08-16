package Lesson3_DZ.Stack;

import Lesson3_DZ.QSCommon;

public interface Stack<E> extends QSCommon<E> {
    boolean push(E e);
    E pop();
    E peek();
    boolean isFull();
    boolean isEmpty();
    int getSize();
}
