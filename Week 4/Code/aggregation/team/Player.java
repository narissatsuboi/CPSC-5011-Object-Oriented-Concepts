package aggregation.team;

public class Player {  
    
    public Player(String name) { 
        this.name = name; 
    }
    
    @Override
    public String toString() {
        return "\n\t\tPlayer [name=" + name + "]";
    }
    
    private String name; 
} 
