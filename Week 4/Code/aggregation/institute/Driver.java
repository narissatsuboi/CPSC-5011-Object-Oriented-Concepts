package aggregation.institute;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    
    public static void main(String[] args) {
        
        // students
        List<Student> cpscStudents = new ArrayList<>();    
        List<Student> biolStudents = new ArrayList<>();    
        List<Student> mathStudents = new ArrayList<>();    
        cpscStudents.add(new Student("Bob", 100));
        cpscStudents.add(new Student("Sue", 101));
        cpscStudents.add(new Student("Jan", 102));
        cpscStudents.add(new Student("Uma", 103));
        biolStudents.add(new Student("Joe", 104));
        biolStudents.add(new Student("Ann", 105));
        mathStudents.add(new Student("Pat", 106));
        mathStudents.add(new Student("Dee", 107));
        mathStudents.add(new Student("Don", 108));
        
        // departments
        List<Department> depts = new ArrayList<>();
        depts.add(new Department("CPSC", cpscStudents));
        depts.add(new Department("BIOL", biolStudents));
        depts.add(new Department("MATH", mathStudents));
        
        // institute
        Institute school = new Institute("Seattle University", depts);

        // print results
        System.out.println(school.toString());
        System.out.println("\n\n# students: " + school.getTotalStudentsInInstitute());
    }
    
}
