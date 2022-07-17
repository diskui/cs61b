/** This class outputs all palindromes in
 * the words file in the current directory.
 * @author diskui
 */
public class PalindromeFinder {
    /**
     * find all palindrome word in a txt file.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(2))) {
                System.out.println(word);
            }
        }
    }
}
