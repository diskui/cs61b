import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author diskui
 */
public class TestArrayDequeGold {

    /**
     * refer to
     * https://github.com/PKUFlyingPig/CS61B/
     */
    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> test = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> right = new ArrayDequeSolution<>();
        String log = "";

        for (int i = 0; i < 1000; i += 1) {
            int select = StdRandom.uniform(4);
            Integer toAdd = StdRandom.uniform(1000);
            switch (select) {
                case 0:
                    test.addFirst(toAdd);
                    right.addFirst(toAdd);
                    log += "addFrist(" + toAdd + ")\n";
                    break;
                case 1:
                    test.addLast(toAdd);
                    right.addLast(toAdd);
                    log += "addLast(" + toAdd + ")\n";
                    break;
                case 2:
                    if (!test.isEmpty() && !right.isEmpty()) {
                        Integer testRemove = test.removeFirst();
                        Integer rightRemove = right.removeFirst();
                        assertEquals(log,rightRemove,testRemove);
                        log += "removeFirst()\n";
                        break;
                    }
                case 3:
                    if (!test.isEmpty() && !right.isEmpty()) {
                        Integer testRemove = test.removeLast();
                        Integer rightRemove = right.removeLast();
                        assertEquals(log,rightRemove,testRemove);
                        log += "removeLast()\n";
                        break;
                    }
                default:
            }
        }
    }
}
