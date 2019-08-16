package Lesson3_DZ;

public interface QSCommon<E> {
    int DEFAULT_SIZE = 16;
    E peek();
    boolean isFull();
    boolean isEmpty();
    int getSize();
}
