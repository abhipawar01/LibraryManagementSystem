import java.util.Scanner;
import java.util.List;

public class LibraryManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        // ... (main method remains the same)
    }

    private static void printMenu() {
        // ... (printMenu method remains the same)
    }

    private static void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            library.addBook(isbn, title, author, year);
            System.out.println("Book added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void borrowBook() {
        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();

        try {
            library.borrowBook(isbn);
            System.out.println("Book borrowed successfully.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void returnBook() {
        System.out.print("Enter ISBN of the book to return: ");
        String isbn = scanner.nextLine();

        try {
            library.returnBook(isbn);
            System.out.println("Book returned successfully.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAvailableBooks() {
        List<Book> availableBooks = library.getAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No books are currently available.");
        } else {
            System.out.println("Available books:");
            for (Book book : availableBooks) {
                System.out.println(book);
            }
        }
    }
}