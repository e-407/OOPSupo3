package questions;

import java.util.List;

public class StringUtils {
    public static void main ( String [] args ) {
        List<String> words = List.of("Apple", "Banana", "Cherry");

        // 1. Print each word
        words.forEach(System.out::println);

        // 2. Get list of lengths
        List<Integer> lengths = words.stream()
                .map(String::length)
                .toList();

        // 3. Create new String objects
        List<String> copies = words.stream ()
                .map(String::new)
                .toList();
    }
}