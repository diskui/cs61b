/**
 * deque based on array.
 *
 * @param <T> type T
 * @author diskui
 */
public class ArrayDeque<T> {
    /**
     * a array of type T.
     */
    private T[] items;
    /**
     * the size of deque.
     */
    private int size;
    /**
     * the index of the next first position to add.
     */
    private int nextFirst;
    /**
     * the index of the next last position to add.
     */
    private int nextLast;
    /**
     * the length of the array, default to 8.
     */
    private int length;

    /**
     * create a empty deque.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        length = 8;
        nextFirst = 4;
        nextLast = 5;
    }

    /**
     * extend the array to the double size of before.
     */
    private void grow() {
        T[] newArray = (T[]) new Object[length * 2];
        for (int i = (nextFirst + 1) % length, j = 0;
             j < size;
             j += 1, i = (i + 1) % length) {
            newArray[j] = items[i];
        }
        length *= 2;
        nextFirst = length - 1;
        nextLast = size;

        items = newArray;
    }

    /**
     * add an item of type T to the front of the deque.
     *
     * @param item item
     */
    public void addFirst(T item) {
        if (size == length - 1) {
            grow();
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst + length - 1) % length;

        size += 1;
    }

    /**
     * add an item of type T to the end of the deque.
     *
     * @param item item
     */
    public void addLast(T item) {
        if (size == length - 1) {
            grow();
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % length;

        size += 1;
    }

    /**
     * return whether the deque is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items in deque.
     */
    public int size() {
        return size;
    }

    /**
     shrink the array to the size of it's half.
     */
    private void shrink() {
        T[] newArray = (T[]) new Object[length / 2];
        for (int i = (nextFirst + 1) % length, j = 0;
             j < size;
             j += 1, i = (i + 1) % length) {
            newArray[j] = items[i];
        }
        length /= 2;
        nextFirst = length - 1;
        nextLast = size;

        items = newArray;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        nextFirst = (nextFirst + 1) % length;
        size -= 1;
        return items[nextFirst];
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        nextLast = (nextLast + length - 1) % length;
        size -= 1;
        return items[nextLast];
    }


    /**
     * Gets the item at the given index,
     * where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     *
     * @param index index
     */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(nextFirst + index + 1) % length];
    }

    /**
     * print the entire deque from front to end.
     */
    public void printDeque() {
        for (int i = (nextFirst + 1) % length;
             i != nextLast;
             i = (i + 1) % length) {
            System.out.print(items[i] + " ");
        }
    }


}
