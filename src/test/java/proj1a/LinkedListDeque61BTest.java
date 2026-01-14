package proj1a;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/** * Performs basic linked list tests using standard JUnit 5 assertions.
 */
public class LinkedListDeque61BTest {

    @Test
    public void addFirstTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("back");
        assertIterableEquals(List.of("back"), lld1.toList());

        lld1.addFirst("middle");
        assertIterableEquals(List.of("middle", "back"), lld1.toList());

        lld1.addFirst("front");
        assertIterableEquals(List.of("front", "middle", "back"), lld1.toList());
    }

    @Test
    public void addLastTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        assertIterableEquals(List.of("front", "middle", "back"), lld1.toList());
    }

    @Test
    public void addFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertIterableEquals(List.of(-2, -1, 0, 1, 2), lld1.toList());
    }

    @Test
    public void sizeTest(){
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        assertTrue(lld1.isEmpty());
        assertEquals(0, lld1.size());

        lld1.addFirst("Test string");
        assertFalse(lld1.isEmpty());
        assertEquals(1, lld1.size());

        lld1.addLast("Test string 2");
        lld1.addFirst("Test string 3");
        lld1.addLast("Test string 4");

        assertEquals(4, lld1.size());

        lld1.removeLast();
        lld1.removeFirst();

        assertEquals(2, lld1.size());
    }

    @Test
    public void getTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(1);
        lld1.addFirst(0);
        lld1.addLast(2);
        lld1.addLast(3);

        assertEquals(2, lld1.get(2));
        assertNull(lld1.get(4));
        assertNull(lld1.get(-1));

    }

    @Test
    public void getRecursiveTest(){
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();
        lld1.addLast(1);
        lld1.addFirst(0);
        lld1.addLast(2);
        lld1.addLast(3);

        assertEquals(2, lld1.getRecursive(2));
        assertNull(lld1.getRecursive(4));
        assertNull(lld1.getRecursive(-1));

    }

    @Test
    public void removeFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]
        lld1.removeFirst();   // [-1, 0, 1, 2]
        lld1.removeLast();    // [-1, 0, 1]

        assertEquals(3, lld1.size());
        assertIterableEquals(List.of(-1, 0, 1), lld1.toList());
    }

}