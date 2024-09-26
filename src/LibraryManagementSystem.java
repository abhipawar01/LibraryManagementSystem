import java.util.Scanner;  // For user input
import java.util.List;     // For storing and displaying available books

public class LibraryManagementSystem {
    // Scanner for user input, using System.in as the input stream
    private static final Scanner scanner = new Scanner(System.in);
    // Instance of the Library class to manage book operations
    private static final Library library = new Library();

    /**
     * Main method to run the Library Management System.
     * Uses an infinite loop with a switch statement for menu options.
     */
    public static void main(String[] args) {
        while (true) {
            printMenu();
            // Read user choice, using Scanner.nextInt()
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt()

            // Switch expression (Java 14+ feature) to handle user choices
            switch (choice) {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> viewAvailableBooks();
                case 5 -> {
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);  // Terminate the program
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     * Uses System.out.println() for output.
     */
    private static void printMenu() {
        System.out.println("\n--- Library Management System ---");
        System.out.println("1. Add a book");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. View available books");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles the process of adding a new book to the library.
     * Uses Scanner for user input and try-catch for error handling.
     */
    private static void addBook() {
        // Collect book details from user input
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt()

        try {
            // Attempt to add the book to the library
            library.addBook(isbn, title, author, year);
            System.out.println("Book added successfully.");
        } catch (IllegalArgumentException e) {
            // Handle case where book already exists
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Handles the process of borrowing a book from the library.
     * Uses Scanner for user input and try-catch for error handling.
     */
    private static void borrowBook() {
        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();

        try {
            // Attempt to borrow the book
            library.borrowBook(isbn);
            System.out.println("Book borrowed successfully.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            // Handle cases where book doesn't exist or is unavailable
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Handles the process of returning a book to the library.
     * Uses Scanner for user input and try-catch for error handling.
     */
    private static void returnBook() {
        System.out.print("Enter ISBN of the book to return: ");
        String isbn = scanner.nextLine();

        try {
            // Attempt to return the book
            library.returnBook(isbn);
            System.out.println("Book returned successfully.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            // Handle cases where book doesn't exist or is already available
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Displays all available books in the library.
     * Uses List to store and iterate over available books.
     */
    private static void viewAvailableBooks() {
        // Get list of available books from the library
        List<Book> availableBooks = library.getAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No books are currently available.");
        } else {
            System.out.println("Available books:");
            // Iterate through available books and print each one
            for (Book book : availableBooks) {
                System.out.println(book);
            }
        }
    }
}