package library;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagement();
        TransactionManagement transactionManagement = new TransactionManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add New Book");
            System.out.println("2. Update Book Information");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Books");
            System.out.println("5. View Catalog");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. View Borrowing History");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> bookManagement.addNewBook();
                case 2 -> bookManagement.updateBookInfo();
                case 3 -> bookManagement.deleteBook();
                case 4 -> bookManagement.searchBooks();
                case 5 -> bookManagement.viewCatalog();
                case 6 -> transactionManagement.issueBook(bookManagement);
                case 7 -> transactionManagement.returnBook(bookManagement);
                case 8 -> transactionManagement.viewBorrowingHistory();
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
