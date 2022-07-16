
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int length;

    /** create a empty deque */
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        length = 8;
        nextFirst = 4;
        nextLast = 5;
    }

    /** extend the array to the double size of before */
    private void grow(){
        T[] newArray = (T[]) new Object[length * 2];
        for(int i = (nextFirst + 1) % length, j = 0; j < size; j+=1,i+=1){
            newArray[j] = items[i];
        }
        length *= 2;
        nextFirst = length - 1;
        nextLast = size;

        items = newArray;
    }

    /** add an item of type T to the front of the deque */
    public void addFirst(T item){
        if(size == length -1){
            grow();
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst + length - 1) % length;
    }

    /** add an item of type T to the end of the deque */
    public void addLast(T item){
        if(size == length -1){
            grow();
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % length;
    }

    /** return whether the deque is empty */
    public boolean isEmpty(){
        return size == 0;
    }

    /** return the number of items in deque */
    public int size(){
        return size;
    }

    /** shrink the array to the size of it's half */
    private void shrink(){
        T[] newArray = (T[]) new Object[length / 2];
        for(int i = (nextFirst+1)%length,j = 0;j < size;j+=1,i+=1){
            newArray[j] = items[i];
        }
        length /= 2;
        nextFirst = length - 1;
        nextLast = size;

        items = newArray;
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        nextFirst = (nextFirst + 1) % length;
        size -= 1;
        return items[nextFirst];
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        nextLast = (nextLast + length - 1) % length;
        size -= 1;
        return items[nextLast];
    }


    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     */
    public T get(int index) {
        return items[(nextFirst + index) % length];
    }

    /** print the entire deque from front to end */
    public void print(){
        for(int i = (nextFirst+1)%length;i != nextLast; i = (i + 1)%length){
            System.out.print(items[i] + " ");
        }
    }


}
