package composition.plane;

public class Plane{   
    
     public Plane(Engine e) { 
        this.engine = e;  
    }       
    
     public void replaceEngine(Engine e) {           
         this.engine = e;  
    } 
    
    @Override
    public String toString() {
        return "Plane [engine=" + engine + "]";
    }
     
     private Engine engine; 
} 
