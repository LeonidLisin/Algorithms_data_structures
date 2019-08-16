package Lesson3_DZ.Queue;

public class DoQueue<E> implements Queue<E> {

    private int head, rear;
    private E[] queue;
    int size;

    public DoQueue(){
        this (DEFAULT_SIZE);
    }

    public DoQueue(int capacity){
        //noinspection unchecked
        queue = (E[]) new Object[capacity];
        this.size = 0;
        head = DEFAULT_HEAD;
        rear = DEFAUTL_REAR;
    }
    @Override
    public boolean insert(E e) {
        if (isFull()) return false;
        queue[rear++] = e;
        if (rear == queue.length) rear = DEFAUTL_REAR;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) return null;
        int temp = head++;
        if(head == queue.length) head = DEFAULT_HEAD;
        size--;
        return queue[temp];
    }

    @Override
    public E peek() {
        return isEmpty() ? null : queue[head];
    }

    @Override
    public boolean isFull() {
        return size == queue.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
