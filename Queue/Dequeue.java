package Lesson3_DZ.Queue;

public class Dequeue<E> extends DoQueue<E> {

    private int left, right;
    private E[] dequeue;

    public Dequeue(){
        this(DEFAULT_SIZE);
    }

    public Dequeue(int capacity){
        //noinspection unchecked
        dequeue = (E[]) new Object[capacity];
        this.size = 0;
        left = 0;
        right = -1;
    }

    public boolean insertLeft(E e) {
        if (isFull()) return false;
        if (--left == -1) left = dequeue.length-1;
        if(isEmpty()) right = left;
        dequeue[left] = e;
        size++;
        return true;
    }

    public boolean insertRight(E e) {
        if (isFull()) return false;
        if (++right == dequeue.length) right = 0;
        if(isEmpty()) left = right;
        dequeue[right] = e;
        size++;
        return true;
    }

    public E removeLeft() {
        if (isEmpty()) return null;
        int temp = left++;
        if(left == dequeue.length) left = 0;
        size--;
        return dequeue[temp];
    }

    public E removeRight() {
        if (isEmpty()) return null;
        int temp = right--;
        if(right == -1) right = dequeue.length-1;
        size--;
        return dequeue[temp];
    }

    public E peekLeft() {
        return isEmpty() ?  null : dequeue[left];
    }

    public E peekRight() {
        return isEmpty() ?  null : dequeue[right];
    }

    public boolean isFull() {
        return size == dequeue.length;
    }

}
