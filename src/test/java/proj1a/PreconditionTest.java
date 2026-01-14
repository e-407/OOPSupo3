package proj1a;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PreconditionTest {

    /** Helper to get the inner class and verify there is only one. */
    private Class<?> getLldInnerClass() {
        Class<?>[] innerClasses = LinkedListDeque61B.class.getDeclaredClasses();
        assertEquals(1, innerClasses.length,
                "LinkedListDeque61B should have exactly one inner class (the Node class).");
        return innerClasses[0];
    }

    /** Replaces the jh61b utility to find fields that shouldn't be there. */
    private List<Field> getBadFields(Class<?> c, Class<?> nodeClass) {
        return Arrays.stream(c.getDeclaredFields())
                .filter(f -> !f.isSynthetic()) // Ignore compiler-generated fields
                .filter(f -> {
                    Class<?> type = f.getType();
                    // A field is "bad" if it's NOT a primitive, NOT the Node class,
                    // and NOT the generic Object (which represents T).
                    return !type.isPrimitive() &&
                            !type.equals(nodeClass) &&
                            !type.equals(Object.class);
                })
                .collect(Collectors.toList());
    }

    @Test
    @Order(0)
    @DisplayName("LinkedListDeque61B is structured and generified properly")
    public void genericTest() {
        Class<?> lldClass = LinkedListDeque61B.class;

        // 1. Check outer class is generic
        assertEquals(1, lldClass.getTypeParameters().length,
                "LinkedListDeque61B should have exactly one type parameter <T>.");

        // 2. Check inner class exists and is NOT generic (should use outer T)
        Class<?> nodeClass = getLldInnerClass();
        assertEquals(0, nodeClass.getTypeParameters().length,
                "Inner Node class should NOT be generic (it should use the T from the outer class).");

        // 3. Verify the 'val' field inside Node is generic T, not a raw Object
        Field[] nodeFields = nodeClass.getDeclaredFields();
        boolean foundGenericVal = false;
        for (Field f : nodeFields) {
            // In the JVM, the generic T looks like Object, but its 'GenericType'
            // will be the type variable T.
            if (f.getType().equals(Object.class) && !f.getGenericType().equals(Object.class)) {
                foundGenericVal = true;
            }
        }
        assertTrue(foundGenericVal, "The value field in your Node class must be of type T.");
    }

    @Test
    @Order(1)
    @DisplayName("Node class follows a strict doubly-linked topology")
    public void doublyLinkedTest() {
        Class<?> nodeClass = getLldInnerClass();
        Field[] fields = nodeClass.getDeclaredFields();

        long nodeTypeCount = Arrays.stream(fields)
                .filter(f -> f.getType().equals(nodeClass))
                .count();

        long valTypeCount = Arrays.stream(fields)
                .filter(f -> f.getType().equals(Object.class))
                .count();

        assertEquals(2, nodeTypeCount, "Node class must have exactly two fields of type Node (prev and next).");
        assertEquals(1, valTypeCount, "Node class must have exactly one field for the value (type T).");
    }

    @Test
    @Order(2)
    @DisplayName("LinkedListDeque61B has no illegal fields")
    public void noNonTrivialFieldsTest() {
        Class<?> nodeClass = getLldInnerClass();

        List<Field> badLldFields = getBadFields(LinkedListDeque61B.class, nodeClass);
        List<Field> badNodeFields = getBadFields(nodeClass, nodeClass);

        assertTrue(badLldFields.isEmpty(), "Found illegal fields in LinkedListDeque61B: " + badLldFields);
        assertTrue(badNodeFields.isEmpty(), "Found illegal fields in Node class: " + badNodeFields);
    }

    @Test
    @Order(3)
    @DisplayName("LinkedListDeque61B has only an empty constructor")
    public void noNonTrivialConstructorsTest() {
        Constructor<?>[] ctors = LinkedListDeque61B.class.getConstructors();
        assertEquals(1, ctors.length, "You should only have one constructor.");
        assertEquals(0, ctors[0].getParameterCount(), "The constructor must take zero arguments.");
    }
}