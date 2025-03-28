package digitallibrarymanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public void issueBook() { this.isIssued = true; }
    public void returnBook() { this.isIssued = false; }
}

class User {
    private String name;
    private String email;
    private List<Book> issuedBooks;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.issuedBooks = new ArrayList<>();
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    
    public void issueBook(Book book) {
        if (!book.isIssued()) {
            book.issueBook();
            issuedBooks.add(book);
            System.out.println(name + " issued " + book.getTitle());
        } else {
            System.out.println("Book already issued!");
        }
    }
    
    public void returnBook(Book book) {
        if (issuedBooks.remove(book)) {
            book.returnBook();
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println("Book not found in issued list!");
        }
    }
}

class Library {
    private List<Book> books = new ArrayList<>();
    private Map<String, User> users = new HashMap<>();
    
    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        System.out.println("Book added: " + title);
    }
    
    public void registerUser(String name, String email) {
        users.put(email, new User(name, email));
        System.out.println("User registered: " + name);
    }
    
    public void issueBook(String email, int bookId) {
        User user = users.get(email);
        for (Book book : books) {
            if (book.getId() == bookId) {
                user.issueBook(book);
                return;
            }
        }
        System.out.println("Book not found!");
    }
    
    public void returnBook(String email, int bookId) {
        User user = users.get(email);
        for (Book book : books) {
            if (book.getId() == bookId) {
                user.returnBook(book);
                return;
            }
        }
        System.out.println("Book not found!");
    }
    
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book.getId() + " | " + book.getTitle() + " | " + book.getAuthor() + " | " + (book.isIssued() ? "Issued" : "Available"));
        }
    }
}
