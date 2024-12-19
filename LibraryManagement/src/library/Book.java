package library;
	class Book {
	    String title, author, genre, isbn;
	    boolean isAvailable;

	    public Book(String title, String author, String genre, String isbn) {
	        this.title = title;
	        this.author = author;
	        this.genre = genre;
	        this.isbn = isbn;
	        this.isAvailable = true;
	    }

	    public void display() {
	        System.out.println("Title: " + title + ", Author: " + author + ", Genre: " + genre + ", ISBN: " + isbn + ", Available: " + (isAvailable ? "Yes" : "No"));
	    }
	}

