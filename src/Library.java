import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }
    public void addBook(String isbn, String title, String author, int publicationYear) {
        if (books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " already exists.");
        }
        books.put(isbn, new Book(isbn, title, author, publicationYear));
    }

    // TODO: Add methods for adding, borrowing, and returning books
}