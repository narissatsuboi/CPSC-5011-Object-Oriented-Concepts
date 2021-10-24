package example.assignment;

public class StringAssign {
    public static void main(String [] args) {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1);
        System.out.println(s2);
        
        s2 = "goodbye";
        s1 = s2;
        System.out.println(s1);
        System.out.println(s2);    
        
        if (s1 == s2)
            System.out.println("s1 == s2");
        else
            System.out.println("s1 != s2");
        
        if (s1.equals(s2))
            System.out.println("s1.equals(s2)");
        if (s2.equals(s1))
            System.out.println("s2.equals(s1)");
        
    }
}
