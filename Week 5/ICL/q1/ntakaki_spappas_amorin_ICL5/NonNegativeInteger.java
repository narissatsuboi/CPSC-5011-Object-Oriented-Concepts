
public class NonNegativeInteger implements Comparable<NonNegativeInteger> {
    
    // Constructors
    public NonNegativeInteger() {
        x = 0;
    }
    
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (that instanceof NonNegativeInteger) {
            if (this.get() == ((NonNegativeInteger) that).get()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public void set(int v) throws IllegalArgumentException {
        if (v < 0) {
            throw new IllegalArgumentException();
        } else {
            x = v;
        }
    }
    
    public int get() {
        return x;
    }
    
    public int compareTo(NonNegativeInteger that) {
        return this.get() - that.get();
    }
    
    // Fields
    int x;
 }

