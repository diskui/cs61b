package synthesizer;

import java.util.Iterator;

/**
 * @param <T> type
 * @author diskui
 */
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {

    /**
     * Index for the next dequeue or peek.
     */
    private int first;

    /**
     * Index for the next enqueue.
     */
    private int last;

    /**
     * Array for storing the buffer data.
     */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     *
     * @param capacity capacity
     */
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        rb = (T[]) new Object[this.capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     *
     * @param x the item to be enqueued
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last += 1;
        if (last == capacity) {
            last = 0;
        }
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     *
     * @return T type
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T t = rb[first];
        first += 1;
        if (first == capacity) {
            first = 0;
        }
        fillCount -= 1;
        return t;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    @Override
    /** the method to accomplish iteration */
    public Iterator<T> iterator() {
        return new TheIterator();
    }

    /** the helper method of iterator. */
    private class TheIterator implements Iterator {
        /** the current position. */
        private int pos;

        /** the construtor method. */
        TheIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos != capacity;
        }

        @Override
        public Object next() {
            T t = rb[pos];
            pos += 1;
            return t;
        }
    }

}
