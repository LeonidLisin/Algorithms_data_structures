package Lesson3_DZ.Queue;

public class PriorityQueue<E extends Object & Comparable<? super E>> extends DoQueue<E> {

    private E[] prQueue;

    public PriorityQueue(){
        this (DEFAULT_SIZE);
    }

    public PriorityQueue(int capacity){
        //noinspection unchecked
        prQueue = (E[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public boolean insert(E e){
        if (isFull()) return false;
        if (isEmpty()) {
            prQueue[size++] = e;
            return true;
        }
        int i;
        for (i = size-1; i >= 0 ; i--) {
            if(e.compareTo(prQueue[i]) > 0)
                prQueue[i+1] = prQueue[i];
            else {
                break;
            }
        }
        size++;
        prQueue[i+1] = e;
        return true;
    }

    @Override
    public E remove(){
        if (size == 0) return null;
        return prQueue[--size];
    }

    @Override
    public E peek(){
        if (size == 0) return null;
        return prQueue[size-1];
    }

    @Override
    public boolean isFull() {
        return size == prQueue.length;
    }
}
