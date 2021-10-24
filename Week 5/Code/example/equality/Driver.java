package example.equality;

public class Driver {
    
    public static void main(String [] args) {
        Rectangle r1 = new Rectangle(1, 2);
        Rectangle r2 = new Rectangle(1, 2);
    
        System.out.println("test r1.toString...");
        testToString(r1);
        System.out.println("test r2.toString...");
        testToString(r2);
        
        System.out.println("\ntest equals...");
        testEquals(r1, r2);
        System.out.println("test hashcode...");
        testHashCode(r1, r2);    
        
        System.out.println("\nnow assigning r1 = r2;");
        r1 = r2;
        System.out.println("test equals...");
        testEquals(r1, r2);
        System.out.println("test hashcode...");
        testHashCode(r1, r2);    
    }
    
    private static void testToString(Object o) {
        System.out.println(o.toString());
        System.out.println(((Rectangle)o).toString());        
    }
    
    private static void testEquals(Object o1, Object o2) {
        if (o1.equals(o2))
            System.out.println("o1.equals(o2)");
        else
            System.out.println("!(o1.equals(o2))");
        if (o2.equals(o1))
            System.out.println("o2.equals(o1)");
        else
            System.out.println("!(o2.equals(o1))");
    }
    
    private static void testHashCode(Object o1, Object o2) {
        if (o1.hashCode() == o2.hashCode())
            System.out.println("o1.hashCode() == o2.hashCode()");
        else
            System.out.println("!(o1.hashCode() == o2.hashCode())");
    }
}
