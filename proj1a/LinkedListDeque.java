public class LinkedListDeque<T> {
    private class Node{
        private T item;
        private Node prev;
        private Node next;

        /** construct a new node with three parameters:
         * item
         * previous node
         * next node
         * @param item
         * @param prev
         * @param next
         * */
        public Node(T item,Node prev,Node next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        /** construct a new node with two parameters:
         * previous node
         * next node
         * @param prev
         * @param next
         */
        public Node(Node prev,Node next){
            this.prev = prev;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;

    /** construct a empty double-ended quene */
    public LinkedListDeque(){
        sentinel = new Node(null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** add an item of type T to the front of the double-ended queue */
    public void addFirst(T item){
        Node newNode = new Node(item,sentinel,sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /** add an item of type of T to the end of the double-ended queue */
    public void addLast(T item){
        Node newNode = new Node(item,sentinel.prev,sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;

        size += 1;
    }

    /** return whether the queue is empty */
    public boolean isEmpty(){
//        return sentinel.next.prev == sentinel.next;
        return size == 0;
    }

    /** return the size of the queue */
    public int size(){
        return size;
    }

    /** print the item(s) of the list from first to last, separated by a space */
    public void printDeque(){
        Node p = sentinel.next;
        while(p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /** remove and return the first item of the queue, return null if it doesn't exist */
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }

        T t = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;

        size -= 1;

        return t;
    }

    /** remove and return the last item of the queue, return null if it doesn't exist */
    public T removeLast(){
        if(isEmpty()){
            return null;
        }

        T t = sentinel.prev.item;

        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;

        size -= 1;

        return t;

    }

    /** get the item at given index where 0 is the front, if doesn't exist return null
     * must use iteration
     * */
    public T get(int index){
        if(isEmpty()){
            return null;
        }
        if(index > size){
            return null;
        }
        Node p = sentinel.next;
        while(index != 0){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** get the item at given index where 0 is the front, if doesn't exist return null
     * recursive version
     * */
    public T getRecursive(int index){
        if(index >= size){
            return null;
        }
        return getHelper(sentinel.next,index);
    }

    private T getHelper(Node n,int index){
        if(index == 0) {
            return n.item;
        }else{
            return getHelper(n.next,index -1);
        }
    }

}
