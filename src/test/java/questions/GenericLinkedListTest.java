package questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {

    @Test
    void testGenerics() {
        OOPLinkedList<String> stringList = new OOPLinkedList<>();
        stringList.add("Hello");
        stringList.add("World");

        assertEquals("World", stringList.get(0));
        assertEquals("Hello", stringList.get(1));
        assertEquals(2, stringList.length());

        OOPLinkedList<Double> intList = new OOPLinkedList<>();
        intList.add(5.0);
        intList.add(10.0);

        assertEquals(10.0, intList.get(0));
        assertEquals(5.0, intList.get(1));
        assertEquals(2, intList.length());
    }
}