package synthesizer;

/**
 * @author diskui
 * @param <T> type
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /** the number of filled items. */
    protected int fillCount;
    /** the length of the queue. */
    protected int capacity;
    @Override
    public int capacity() {
        return capacity;
    }
    @Override
    public int fillCount() {
        return fillCount;
    }
}
