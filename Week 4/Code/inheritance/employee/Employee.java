package inheritance.employee;

public class Employee {
    
    public Employee(String name) { 
        this.name = name;
    }
    
    public void setSalary(double salary) { 
         this.salary = salary;
    }
    
    public String getName() { 
        return name;
    }
    
    public double getSalary() { 
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + "]";
    }

    private String name;
    private double salary;
}

