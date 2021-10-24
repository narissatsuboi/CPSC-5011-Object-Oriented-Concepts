package example.clone.v2;

/**
 * Reference: 
 * https://howtodoinjava.com/java/cloning/a-guide-to-object-cloning-in-java/
 */
public class Department implements Cloneable {
	
    private int id;
    private String name;
  
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }
 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}
