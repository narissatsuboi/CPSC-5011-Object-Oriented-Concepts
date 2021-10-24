package example.assignment;

public class Box {
    
    public int value;
    
    public static void main(String [] args) {
        Box x = new Box();
        x.value = 7;
        System.out.println("x = " + x.value);
        
        Box y = x;
        y.value = 12;  // what is x.value?
        System.out.println("x = " + x.value);
    }
    
}
