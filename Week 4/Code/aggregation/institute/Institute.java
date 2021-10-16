package aggregation.institute;

import java.util.List;

class Institute  { 
      
    Institute(String instituteName, List<Department> departments) { 
        this.instituteName = instituteName; 
        this.departments = departments; 
    } 
      
    // count total students of all departments in a given institute  
    public int getTotalStudentsInInstitute() { 
        int noOfStudents = 0; 
        List<Student> students;  
        for(Department dept : departments) { 
            students = dept.getStudents(); 
            //for(Student s : students) 
            for (int i = 0; i < students.size(); i++)
                noOfStudents++; 
        } 
        return noOfStudents; 
    } 
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Institute [\n\tname=");
        sb.append(instituteName);
        sb.append(", \n\tdepartments=");
        sb.append(departments);
        sb.append("\n]");
        return sb.toString();
    } 
    
    private String instituteName; 
    private List<Department> departments; 
      
} 
