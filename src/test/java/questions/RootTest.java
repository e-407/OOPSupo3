package questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RootTest {

    @Test
    void testRoots() {
        assertEquals(5.0, Maths.root(25.0), 0.00001);
        assertEquals(1.4142, Maths.root(2.0), 0.0001);
        assertEquals(0.0, Maths.root(0.0), 0.0000000001);
        assertThrows(IllegalArgumentException.class, () -> {
            Maths.root(-5.0);
        });
    }
}
