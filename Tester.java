package Lesson3_DZ;

import Lesson3_DZ.Flip.StringFlip;
import Lesson3_DZ.Queue.*;
import Lesson3_DZ.Stack.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tester {

    private Stack<Integer> stack;
    private Queue<Integer> queue;
    private Queue<Integer> prQueue;
    private Dequeue<Integer> dequeue;
    private StringFlip flipper;

    @SuppressWarnings("unchecked")
    @Before
    public void init(){
        stack = new DoStack(3);
        queue = new DoQueue(3);
        prQueue = new PriorityQueue<>(3);
        dequeue = new Dequeue(3);
        flipper = new StringFlip();
    }

    @Test()
    public void stackTest(){
        Assert.assertEquals(0, stack.getSize());
        stack.push(2);
        stack.push(3);
        stack.push(5);
        Assert.assertFalse(stack.push(55));
        Assert.assertEquals(3, stack.getSize());
        Assert.assertEquals(stack.peek(), Integer.valueOf(5));
        Assert.assertEquals(stack.pop(), Integer.valueOf(5));
        Assert.assertEquals(stack.peek(), Integer.valueOf(3));
    }

    @Test()
    public void queueTest(){
        Assert.assertEquals(0, queue.getSize());
        queue.insert(9);
        queue.insert(19);
        queue.insert(119);
        Assert.assertEquals(queue.peek(), Integer.valueOf(9));
        Assert.assertEquals(queue.getSize(), 3);
        Assert.assertFalse(queue.insert(555));
        Assert.assertEquals(queue.remove(), Integer.valueOf(9));
        Assert.assertEquals(queue.remove(), Integer.valueOf(19));
        Assert.assertEquals(queue.remove(), Integer.valueOf(119));
        Assert.assertNull(queue.remove());
    }

    @Test
    public void dequeueTest(){
        dequeue.insertRight(1);
        dequeue.insertRight(2);
        dequeue.insertRight(3);

        Assert.assertFalse(dequeue.insertLeft(3));
        Assert.assertEquals(dequeue.getSize(), 3);
        Assert.assertEquals(dequeue.peekLeft(), Integer.valueOf(1));
        Assert.assertEquals(dequeue.removeLeft(), Integer.valueOf(1));
        Assert.assertEquals(dequeue.peekRight(), Integer.valueOf(3));
        Assert.assertEquals(dequeue.removeRight(), Integer.valueOf(3));
        Assert.assertEquals(dequeue.removeLeft(), Integer.valueOf(2));
        Assert.assertNull(dequeue.removeRight());
        Assert.assertEquals(dequeue.getSize(), 0);

        dequeue.insertLeft(3);
        Assert.assertEquals(dequeue.removeRight(), Integer.valueOf(3));
    }

    @Test()
    public void priorityQueueTest(){
        prQueue.insert(2);
        prQueue.insert(7);
        prQueue.insert(9);
        Assert.assertFalse(prQueue.insert(2));
        Assert.assertEquals(prQueue.peek(), Integer.valueOf(2));
        Assert.assertEquals(prQueue.remove(), Integer.valueOf(2));
        Assert.assertEquals(prQueue.remove(), Integer.valueOf(7));
        Assert.assertEquals(prQueue.remove(), Integer.valueOf(9));
        Assert.assertNull(prQueue.remove());
    }

    @Test()
    public void stringFlipTest(){
        Assert.assertEquals(flipper.flip("123"), new StringBuilder("321"));
    }

}
