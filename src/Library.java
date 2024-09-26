import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

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
    public void borrowBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist.");
        }
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book with ISBN " + isbn + " is not available.");
        }
        book.setAvailable(false);
    }

    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist.");
        }
        if (book.isAvailable()) {
            throw new IllegalStateException("Book with ISBN " + isbn + " is already available.");
        }
        book.setAvailable(true);
    }
    public List<Book> getAvailableBooks() {
        return books.values().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    // TODO: Add methods for adding, borrowing, and returning books
}