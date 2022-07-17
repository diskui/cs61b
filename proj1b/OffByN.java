/**
 * @author diskui
 */
public class OffByN implements CharacterComparator {
    /** the offset number. */
    private int offset;

    /** one int parameter construtor.
     * n version of offset
     * @param n number
     */
    public OffByN(int n) {
        offset = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == offset;
    }
}
