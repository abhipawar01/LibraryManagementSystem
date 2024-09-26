import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class Library {
    // Using java.util.Map to store books with ISBN as key
    private Map<String, Book> books;

    // Constructor
    public Library() {
        // Initialize the books map using java.util.HashMap
        this.books = new HashMap<>();
    }

    /**
     * Adds a new book to the library.
     * Uses java.lang.String for parameters and java.lang.IllegalArgumentException for error handling.
     *
     * @param isbn Unique identifier for the book
     * @param title Title of the book
     * @param author Author of the book
     * @param publicationYear Year the book was published
     * @throws IllegalArgumentException if a book with the given ISBN already exists
     */
    public void addBook(String isbn, String title, String author, int publicationYear) {
        // Check if the book already exists using Map.containsKey()
        if (books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " already exists.");
        }
        // Add the new book to the map using Map.put()
        books.put(isbn, new Book(isbn, title, author, publicationYear));
    }

    /**
     * Marks a book as borrowed (not available).
     * Uses java.lang.String for parameter and java.lang.IllegalArgumentException and
     * java.lang.IllegalStateException for error handling.
     *
     * @param isbn ISBN of the book to borrow
     * @throws IllegalArgumentException if the book doesn't exist
     * @throws IllegalStateException if the book is not available
     */
    public void borrowBook(String isbn) {
        // Retrieve the book from the map using Map.get()
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist.");
        }
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book with ISBN " + isbn + " is not available.");
        }
        // Mark the book as not available
        book.setAvailable(false);
    }

    /**
     * Marks a book as returned (available).
     * Uses java.lang.String for parameter and java.lang.IllegalArgumentException and
     * java.lang.IllegalStateException for error handling.
     *
     * @param isbn ISBN of the book to return
     * @throws IllegalArgumentException if the book doesn't exist
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook(String isbn) {
        // Retrieve the book from the map using Map.get()
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist.");
        }
        if (book.isAvailable()) {
            throw new IllegalStateException("Book with ISBN " + isbn + " is already available.");
        }
        // Mark the book as available
        book.setAvailable(true);
    }

    /**
     * Retrieves a list of all available books.
     * Uses java.util.stream.Stream for filtering and collecting results.
     *
     * @return List of available Book objects
     */
    public List<Book> getAvailableBooks() {
        // Use Stream API to filter and collect available books
        return books.values().stream()
                .filter(Book::isAvailable)  // Method reference to filter available books
                .collect(Collectors.toList());  // Collect results into a List
    }
}