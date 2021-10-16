package composition.library;

import java.util.List;

public class Library {  
    
    public Library(List<Book> books) { 
        this.books = books;  
    } 
    
    public List<Book> getBooks () {           
       return books;   
    } 
    
    public void addBook(Book b) {
        books.add(b);
    }
    
    public void updateBook(int index, Book b) {
        books.set(index, b);
    }
    
    @Override
    public String toString() {
        return "Library [\n\tbooks=" + books + "\n]";
    }

    private final List<Book> books; 
    // the contents are still mutable, but cannot assign books 
    // variable to another reference
    
} 

