package library;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookManagement {
    private final List<Book> books = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addNewBook() {
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                System.out.println("Book with this ISBN already exists.");
                return;
            }
        }

        books.add(new Book(title, author, genre, isbn));
        System.out.println("Book added successfully.");
    }

    public void updateBookInfo() {
        System.out.print("Enter ISBN of the book to update: ");
        String isbn = scanner.nextLine();

        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                System.out.print("Enter new Title (leave blank to keep unchanged): ");
                String title = scanner.nextLine();
                if (!title.isEmpty()) book.title = title;

                System.out.print("Enter new Author (leave blank to keep unchanged): ");
                String author = scanner.nextLine();
                if (!author.isEmpty()) book.author = author;

                System.out.print("Enter new Genre (leave blank to keep unchanged): ");
                String genre = scanner.nextLine();
                if (!genre.isEmpty()) book.genre = genre;

                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void deleteBook() {
        System.out.print("Enter ISBN of the book to delete: ");
        String isbn = scanner.nextLine();

        for (Iterator<Book> iterator = books.iterator(); iterator.hasNext(); ) {
            Book book = iterator.next();
            if (book.isbn.equals(isbn)) {
                iterator.remove();
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchBooks() {
        System.out.print("Enter search term (Title, Author, Genre, ISBN): ");
        String term = scanner.nextLine().toLowerCase();

        for (Book book : books) {
            if (book.title.toLowerCase().contains(term) || book.author.toLowerCase().contains(term) || book.genre.toLowerCase().contains(term) || book.isbn.toLowerCase().contains(term)) {
                book.display();
            }
        }
    }

    public void viewCatalog() {
        for (Book book : books) {
            book.display();
        }
    }

    public List<Book> getBooks() {
        return books;
    }

}
