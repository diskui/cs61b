/**
 * @author diskui
 */
public class Palindrome {
    /**
     * convert a String to a deque.
     * @param word given string
     * @return a deque
     */
    public Deque<Character> wordToDeque(String word){
        Deque<Character> dq = new LinkedListDeque<>();
        for(int i = 0; i < word.length();i++){
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    /**
     * return whether a string is palindrome
     * @param word given string
     * @return whether it's palindrome
     */
    public boolean isPalindrome(String word){
        if(word == null || word.length() <= 1){
            return true;
        }
        Deque<Character> dq = wordToDeque(word);
        boolean flag = true;
        while(dq.size() > 1){
            if(dq.removeLast() != dq.removeFirst()){
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * the overload of above is palindrome
     * @param word given string
     * @param cc a character comparator
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word == null || word.length() <= 1){
            return true;
        }
        Deque<Character> dq = wordToDeque(word);
        boolean flag = true;
        while(dq.size() > 1){
            if(!cc.equalChars(dq.removeFirst(),dq.removeLast())){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
