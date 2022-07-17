/**
 * deque based on linked list.
 *
 * @param <T>
 * @author diskui
 */
public class LinkedListDeque<T> implements Deque<T>{
    /**
     * inner node class.
     */
    private class Node {
        /** type T node. */
        private T item;
        /** previous node. */
        private Node prev;
        /** next node. */
        private Node next;

        /** construct a new node with three parameters.
         * @param t item
         * @param p prev
         * @param n next
         */
        Node(T t, Node p, Node n) {
            item = t;
            prev = p;
            next = n;
        }

        /** construct a new node with two parameters.
         * previous node
         * next node
         *
         * @param p prev
         * @param n next
         */
        Node(Node p, Node n) {
            prev = p;
            next = n;
        }
    }

    /** sentinel node. */
    private Node sentinel;
    /** the size of deque. */
    private int size;

    /** construct a empty double-ended quene.
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** add an item of type T to the front of the double-ended queue.
     * @param item item
     */
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /** add an item of type of T to the end of the double-ended queue.
     * @param item item
     */
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;

        size += 1;
    }

    /** return whether the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** return the size of the queue.
     */
    @Override
    public int size() {
        return size;
    }

    /** print the item(s) of the list from first to last,
     *  separated by a space.
     */
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /** remove and return the first item of the queue, return null
     *  if it doesn't exist.
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T t = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;

        size -= 1;

        return t;
    }

    /** remove and return the last item of the queue, return null
     *  if it doesn't exist.
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T t = sentinel.prev.item;

        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;

        size -= 1;

        return t;

    }

    /** get the item at given index where 0 is the front,
     *  if doesn't exist return null.
     * must use iteration
     *
     * @param index index
     */
    @Override
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index > size) {
            return null;
        }
        Node p = sentinel.next;
        while (index != 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** get the item at given index where 0 is the front.
     * if doesn't exist return null.
     * recursive version
     *
     * @param index index
     */
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getHelper(sentinel.next, index);
    }

    /** helper method of get recursive.
     *
     * @param n node
     * @param index index
     * @return type T
     */
    private T getHelper(Node n, int index) {
        if (index == 0) {
            return n.item;
        } else {
            return getHelper(n.next, index - 1);
        }
    }

}
