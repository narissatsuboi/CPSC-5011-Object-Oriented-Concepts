package bloch;

import java.util.Objects;

public final class CaseInsensitiveString 
        implements Comparable<CaseInsensitiveString> {
    
    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }
    
    // Broken - violates symmetry
    @Override public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
        if (o instanceof String) // one-way interoperability!
            return s.equalsIgnoreCase((String)o);
        return false;
    }
    
//    @Override public boolean equals(Object o) {
//        return o instanceof CaseInsensitiveString && 
//                ((CaseInsensitiveString)o).s.equalsIgnoreCase(s);
//    }

    @Override public int hashCode() {
        return s.toLowerCase().hashCode();
        // can also use toUpperCase()
    }

    @Override public String toString() {
        return s;
    }
    
    // Single field Comparable with object reference field
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }
    
    private final String s;

}
