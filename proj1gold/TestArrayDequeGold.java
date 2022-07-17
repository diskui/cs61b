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

        for (int i = 0; i < 100; i += 0) {
            if (right.isEmpty()) {
                int select = StdRandom.uniform(2);
                Integer toAdd = StdRandom.uniform(1000);
                if (select == 0) {
                    test.addFirst(toAdd);
                    right.addFirst(toAdd);
                    log += "addFrist(" + toAdd + ")\n";
                } else {
                    test.addLast(toAdd);
                    right.addLast(toAdd);
                    log += "addLast(" + toAdd + ")\n";
                }
            } else {
                int select = StdRandom.uniform(4);
                Integer toAdd = StdRandom.uniform(1000);
                Integer testRemove = 1;
                Integer rightRemove = 1;
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
                        testRemove = test.removeFirst();
                        rightRemove = right.removeFirst();
                        log += "removeFirst()\n";
                        break;
                    case 3:
                        testRemove = test.removeLast();
                        rightRemove = right.removeLast();
                        log += "removeLast()\n";
                        break;
                    default:
                }
                assertEquals(log,rightRemove, testRemove);
            }
        }
    }
}
