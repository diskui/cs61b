/**
 * @author diskui
 */
public class OffByN implements CharacterComparator{
    /** the offset number */
    private int offset;

    public OffByN(int n){
        offset = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == offset;
    }
}
