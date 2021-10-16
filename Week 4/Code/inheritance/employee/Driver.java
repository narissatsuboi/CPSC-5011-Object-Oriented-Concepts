package inheritance.employee;

public class Driver {
    public static void main(String [] args) {
        Manager m = new Manager("manager1");
        m.setSalary(10000);
        m.setBonus(500);
        System.out.println(m.toString());
        
        Employee e = new Manager("manager2");
        e.setSalary(6000);
        // bonus is not available
        System.out.println(e.toString());
        
        Employee e2 = new Employee("manager3");
        e2.setSalary(5000);
        // bonus is not available
        System.out.println(e2.toString());
    }
}
