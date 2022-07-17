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

        for (int i = 0; i < 100; i += 0) {
            if (right.isEmpty()) {
                int select = StdRandom.uniform(2);
                Integer toAdd = StdRandom.uniform(1000);
                if (select == 0) {
                    test.addFirst(toAdd);
                    right.addFirst(toAdd);
                } else {
                    test.addLast(toAdd);
                    right.addLast(toAdd);
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
                        break;
                    case 1:
                        test.addLast(toAdd);
                        right.addLast(toAdd);
                        break;
                    case 2:
                        testRemove = test.removeFirst();
                        rightRemove = right.removeFirst();
                        break;
                    case 3:
                        testRemove = test.removeLast();
                        rightRemove = right.removeLast();
                        break;
                    default:
                }
                assertEquals(testRemove, rightRemove);
            }
        }
    }
}
