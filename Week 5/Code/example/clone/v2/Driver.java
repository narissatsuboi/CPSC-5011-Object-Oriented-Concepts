package example.clone.v2;

/**
 * Reference: 
 * https://howtodoinjava.com/java/cloning/a-guide-to-object-cloning-in-java/
 */
public class Driver {

	public static void main(String[] args) throws CloneNotSupportedException {
        Department hr = new Department(1, "Human Resource");
 
        Employee original = new Employee(1, "Admin", hr);
        Employee cloned = (Employee) original.clone();
 
        // Let change the department name in cloned object  
        // and we will verify in original object
        cloned.getDepartment().setName("Finance");
 
        System.out.println(original.getDepartment().getName());
        System.out.println(cloned.getDepartment().getName());
	}

}
