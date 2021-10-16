package inheritance.employee;

public class Manager extends Employee {
    
    public Manager(String aName) {
        super(aName); // calls superclass constructor
        bonus = 0;
     }

    public void setBonus(double bonus) { 
        this.bonus = bonus;
    }
    
    @Override
    public double getSalary() { 
        return super.getSalary() + bonus;   
    }

    @Override
    public String toString() {
        return super.toString() + ", Manager [bonus=" + bonus + "]";
    }
    
    private double bonus; // new field
}

