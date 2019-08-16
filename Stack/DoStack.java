package Lesson3_DZ.Stack;

public class DoStack<E> implements Stack<E>{

    private E[] stack;
    private int index;

    public DoStack(){
        this(DEFAULT_SIZE);
    }

    public DoStack(int capacity){
        //noinspection unchecked
        stack = (E[])new Object[capacity];
        index = -1;
    }

    @Override
    public boolean push(E e) {
        if (isFull()) return false;
        stack[++index] = e;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()) return null;
        return stack[index--];
    }

    @Override
    public E peek() {
        if(isEmpty()) return null;
        return stack[index];
    }

    @Override
    public boolean isFull() {
        return index == stack.length-1;
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public int getSize() {
        return index+1;
    }
}
