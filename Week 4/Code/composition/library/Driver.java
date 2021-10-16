package composition.library;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();        
        books.add(new Book("Title1", "First1 Last1"));
        books.add(new Book("Title2", "First2 Last2"));
        Library lib = new Library(books);
        
        System.out.println("original...");
        System.out.println(lib.toString());
                
        System.out.println("\nadd book to composition.library...");
        lib.addBook(new Book("Title3", "First3 Last3"));
        System.out.println(lib.toString());
        
        System.out.println("\nupdated book to composition.library...");
        lib.updateBook(1, new Book("Title4", "First4 Last4"));
        System.out.println(lib.toString());
    }
    
}
