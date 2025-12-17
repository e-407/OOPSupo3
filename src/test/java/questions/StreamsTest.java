package questions;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamsTest {
    @Test
    public void testGetSortedTitles() {
        List<String> result = Streams.getSortedTitles();
        assertEquals(List.of("Moby Dick", "Ulysses", "War and Peace"), result);
    }
}
