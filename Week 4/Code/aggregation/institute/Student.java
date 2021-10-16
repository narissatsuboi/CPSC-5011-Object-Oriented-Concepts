package aggregation.institute;

public class Student  {   
    
    public Student(String name, int id) {           
        this.name = name; 
        this.id = id; 
    } 
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\t\t\tStudent [name=");
        sb.append(name);
        sb.append(", id=");
        sb.append(id);
        sb.append("]");
        return sb.toString();
    }
    
    private String name; 
    private int id; 
} 

