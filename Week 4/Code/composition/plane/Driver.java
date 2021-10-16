package composition.plane;

import java.time.LocalDate;

public class Driver {
    
    public static void main(String [] args) {
        
        Engine e = new Engine("Type1", LocalDate.of(2014, 1, 1));
        Plane p = new Plane(e);
        
        System.out.println("original...");
        System.out.println(p.toString());
        
        System.out.println("\nreplaced engine...");
        e = new Engine("Type2", LocalDate.of(2018, 10, 18));
        p.replaceEngine(e);
        System.out.println(p.toString());
    }
    
}
