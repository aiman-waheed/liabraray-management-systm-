package library;
import java.util.*;
public class TransactionManagement {
    private final List<Transaction> transactions = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void issueBook(BookManagement bookManagement) {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        for (Book book : bookManagement.getBooks()) {
            if (book.isbn.equals(isbn)) {
                if (!book.isAvailable) {
                    System.out.println("Book is already checked out.");
                    return;
                }

                Date borrowDate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(borrowDate);
                calendar.add(Calendar.DATE, 14); // 14-day due date
                Date dueDate = calendar.getTime();

                transactions.add(new Transaction(userId, isbn, borrowDate, dueDate));
                book.isAvailable = false;
                System.out.println("Book issued successfully. Due date: " + dueDate);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(BookManagement bookManagement) {
        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        for (Transaction transaction : transactions) {
            if (transaction.bookIsbn.equals(isbn) && transaction.returnDate == null) {
                transaction.returnDate = new Date();
                for (Book book : bookManagement.getBooks()) {
                    if (book.isbn.equals(isbn)) {
                        book.isAvailable = true;
                        break;
                    }
                }
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Transaction not found or book already returned.");
    }

    public void viewBorrowingHistory() {
        for (Transaction transaction : transactions) {
            transaction.display();
        }
    }
}
