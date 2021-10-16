package composition.library;

public class Book  {      
    
    public Book(String title, String author) { 
        this.title = title; 
        this.author = author; 
    } 
        
    @Override
    public String toString() {
        return "\n\t\tBook [title=" + title + ", author=" + author + "]";
    }

    private String title; 
    private String author; 
    
} 
