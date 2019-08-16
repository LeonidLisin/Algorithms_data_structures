package Lesson3_DZ.Queue;

import Lesson3_DZ.QSCommon;

public interface Queue<E> extends QSCommon<E> {
    int DEFAUTL_REAR = 0, DEFAULT_HEAD = 0;;
    boolean insert(E e);
    E remove();
    E peek();
    boolean isFull();
    boolean isEmpty();
}
