// The Book class doesn't explicitly import any external libraries.
// It uses basic Java language features and String class from java.lang package.

/**
 * Represents a book in the library system.
 */
class Book {
    // Private fields to store book information
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    /**
     * Constructor to create a new Book object.
     * @param isbn The ISBN of the book (String)
     * @param title The title of the book (String)
     * @param author The author of the book (String)
     * @param publicationYear The year of publication (int)
     */
    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;  // New books are initially available
    }

    // Getter methods to access private fields

    /**
     * @return The ISBN of the book (String)
     */
    public String getIsbn() { return isbn; }

    /**
     * @return The title of the book (String)
     */
    public String getTitle() { return title; }

    /**
     * @return The author of the book (String)
     */
    public String getAuthor() { return author; }

    /**
     * @return The publication year of the book (int)
     */
    public int getPublicationYear() { return publicationYear; }

    /**
     * @return The availability status of the book (boolean)
     */
    public boolean isAvailable() { return isAvailable; }

    /**
     * Setter method to update the availability status of the book
     * @param available The new availability status (boolean)
     */
    public void setAvailable(boolean available) { isAvailable = available; }

    /**
     * Overrides the default toString method to provide a string representation of the Book object.
     * This method uses string concatenation to create a formatted string with all book details.
     * @return A string representation of the Book object
     */
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", isAvailable=" + isAvailable +
                '}';
    }
}