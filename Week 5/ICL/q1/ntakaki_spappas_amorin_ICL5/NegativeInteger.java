
public class NegativeInteger implements Comparable<NegativeInteger> {
    
    // Constructors
    public NegativeInteger() {
        x = 0;
    }
    
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (that instanceof NegativeInteger) {
            if (this.get() == ((NegativeInteger) that).get()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public void set(int v) throws IllegalArgumentException {
        if (v > 0) {
            throw new IllegalArgumentException();
        } else {
            x = v;
        }
    }
    
    public int get() {
        return x;
    }
    
    public int compareTo(NegativeInteger that) {
        return this.get() - that.get();
    }
    
    // Fields
    int x;
 }

