package example.clone.v1;

/**
 * Reference: 
 * https://howtodoinjava.com/java/cloning/a-guide-to-object-cloning-in-java/
 */
public class Department
{
    private int id;
    private String name;
  
    public Department(int id, String name)
    {
        this.id = id;
        this.name = name;
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
