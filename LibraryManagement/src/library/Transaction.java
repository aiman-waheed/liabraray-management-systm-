package library;
import java.util.*;
public class Transaction {
    String userId, bookIsbn;
    Date borrowDate, dueDate, returnDate;

    public Transaction(String userId, String bookIsbn, Date borrowDate, Date dueDate) {
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

    public void display() {
        System.out.println("User ID: " + userId + ", Book ISBN: " + bookIsbn + ", Borrow Date: " + borrowDate + ", Due Date: " + dueDate + ", Return Date: " + (returnDate != null ? returnDate : "Not Returned"));
    }
}

}
