package bloch;

import java.awt.Color;

public class Driver {
    
    public static void main(String [] arg) {
        testCaseInsensitiveString();
        testPointViolateSymmetry();
        testPointViolateTransitivity();
        testColorPointFix();
        testPhoneNumber();
    }
    
    private static void testCaseInsensitiveString() {
        System.out.println("------------------------------");
        System.out.println("test CaseInSensitiveString...");
        CaseInsensitiveString cis = new CaseInsensitiveString("Hello");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("HEllO");
        String s = "heLLo";

        if (cis.equals(cis2)) 
            System.out.println("cis.equals(cis2)");
        if (cis2.equals(cis)) 
            System.out.println("cis2.equals(cis)");
        if (cis.equals(s)) 
            System.out.println("cis.equals(s)");
        if (s.equals(cis)) 
            System.out.println("s.equals(cis)");
    }
    
    private static void testPointViolateSymmetry() {
        System.out.println("------------------------------");
        System.out.println("test Point (violate symmetry)...");
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        if (p.equals(cp)) 
            System.out.println("p.equals(cp)");
        if (cp.equals(p)) 
            System.out.println("cp.equals(p)");
    }
    
    private static void testPointViolateTransitivity() {
        System.out.println("------------------------------");
        System.out.println("test Point (violate transitivity)...");
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        if (p1.equals(p2)) 
            System.out.println("p1.equals(p2)");
        if (p2.equals(p3)) 
            System.out.println("p2.equals(p3)");
        if (p1.equals(p3)) 
            System.out.println("p1.equals(p3)");
    }

    private static void testColorPointFix() {
        System.out.println("------------------------------");
        System.out.println("test ColorPoint (fix)...");
        ColorPointFix p1 = new ColorPointFix(1, 2, Color.RED);
        ColorPointFix p2 = new ColorPointFix(1, 2, Color.RED);
        ColorPointFix p3 = new ColorPointFix(1, 2, Color.RED);
        if (p1.equals(p2)) 
            System.out.println("p1.equals(p2)");
        if (p2.equals(p2)) 
            System.out.println("p2.equals(p1)");
        if (p2.equals(p3)) 
            System.out.println("p2.equals(p3)");
        if (p1.equals(p3)) 
            System.out.println("p1.equals(p3)");
    }
    
    private static void testPhoneNumber() {
        System.out.println("------------------------------");
        System.out.println("test PhoneNumber...");
        PhoneNumber p1 = new PhoneNumber(206, 111, 1111);
        PhoneNumber p2 = new PhoneNumber(206, 111, 1111);
        
        System.out.println("test equals (p1, p2)...");
        if (p1.equals(p2)) 
            System.out.println("p1.equals(p2)");
        if (p2.equals(p1)) 
            System.out.println("p2.equals(p1)");
    
        System.out.println("\ntest hashCode (p1, p2)...");
        if (p1.hashCode() == p2.hashCode()) 
            System.out.println("p1.hashCode() == p2.hashCode()");

        System.out.println("\ntest clone (p3)...");
        PhoneNumber p3 = p1.clone();
        if (p1.equals(p3)) 
            System.out.println("p1.equals(p3)");
        if (p3.equals(p1)) 
            System.out.println("p3.equals(p1)");    
        
        System.out.println("\ntest compareTo (p1, p2)...");
        if (p1.compareTo(p2) == 0)
            System.out.println("p1.compareTo(p2) == 0");
        if (p2.compareTo(p1) == 0)
            System.out.println("p2.compareTo(p1) == 0");
        
    }
}
