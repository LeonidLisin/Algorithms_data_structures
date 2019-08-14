public interface Array<E> {
    int DEFAULT_SIZE = 16;
    void add(E element);
    boolean addByIndex(int index, E element);
    boolean insert(int index, E element);
    boolean removeByIndex(int index);
    boolean remove(E element);
    boolean contains(E element);
    void sort(SortingMethod sm);
    E get(int index);
    E[] getArray();
    int getSize();
}
