package aggregation.institute;

import java.util.List;

public class Department  {     
    
    public Department(String name, List<Student> students)  {    
        this.name = name; 
        this.students = students;          
    } 

    public List<Student> getStudents() { 
        return students; 
    } 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\tDepartment [\n\t\t\tname=");
        sb.append(name);
        sb.append(", \n\t\t\tstudents=");
        sb.append(students);
        sb.append("]");
        return sb.toString();
    } 

    private String name; 
    private List<Student> students;
}

