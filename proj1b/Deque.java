/**
 * @author diskui
 * @param <T> type
 */
public interface Deque<T> {
    /** add an item of T type do the front of the deque.
     * @param item item
     */
    void addFirst(T item);
    /** add an item of T type do the end of the deque.
     * @param item item
     */
    void addLast(T item);
    /** return whether the deque is empty. */
    boolean isEmpty();
    /** return the size of deque. */
    int size();
    /** print the deque from front to the end. */
    void printDeque();
    /** remove and return the first item of deque. */
    T removeFirst();
    /** remove and return the last item of deque. */
    T removeLast();
    /** return the index th item of the deque.
     * @param index index
     */
    T get(int index);
}
