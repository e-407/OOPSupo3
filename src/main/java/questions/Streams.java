package questions;

import java.util.List;
import static java.util.Comparator.comparing;

public class Streams {
    public static List<String> getSortedTitles(){
        record Book(String title, String author, int pages) {}
        List<Book> library = List.of(
                new Book("Moby Dick","Herman Melville",720) ,
                new Book ("1984","George Orwell",328) ,
                new Book ("Ulysses","James Joyce",730) ,
                new Book ("War and Peace","Leo Tolstoy",1225)
        );
        return library.stream()
                .filter(book -> book.pages > 500)
                .sorted(comparing(book -> book.author))
                .map(book -> book.title)
                .toList();
    }
}
