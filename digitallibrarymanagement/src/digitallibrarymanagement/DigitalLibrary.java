package digitallibrarymanagement;
public class DigitalLibrary {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(1, "Java Programming", "James Gosling");
        library.addBook(2, "Data Structures", "Robert Lafore");
        
        library.registerUser("Alice", "alice@example.com");
        library.registerUser("Bob", "bob@example.com");
        
        library.issueBook("alice@example.com", 1);
        library.displayBooks();
        
        library.returnBook("alice@example.com", 1);
        library.displayBooks();
    }
}

