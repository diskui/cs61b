import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("rtu5665utr"));
        assertFalse(palindrome.isPalindrome("kfjdkj343jj"));
        assertTrue(palindrome.isPalindrome("x"));
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testIsOffByOnePalindrome() {
        assertTrue(palindrome.isPalindrome("flake", new OffByOne()));
        assertTrue(palindrome.isPalindrome("s", new OffByOne()));
        assertTrue(palindrome.isPalindrome("", new OffByOne()));

        assertFalse(palindrome.isPalindrome("fdffdf", new OffByOne()));
    }
}
