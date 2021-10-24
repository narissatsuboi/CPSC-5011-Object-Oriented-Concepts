package bloch;

//import java.util.Comparator;

public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
    
    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }
    
    public static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
           throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
     } 
    
    @Override public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix 
                && pn.areaCode == areaCode;
    }
    
    @Override public int hashCode() {
        int result = hashCode;
        if (result == 0) {
           result = Short.hashCode(areaCode);
           result = 31 * result + Short.hashCode(prefix);
           result = 31 * result + Short.hashCode(lineNum);
           hashCode = result;
        }
        return result;
    }
    
    /**
     * Returns the string representation of this phone number. 
     * The string consists of 12 characters whose format is 
     * "XXX-YYY-ZZZZ", where XXX is the area code, YYY is the 
     * prefix, and ZZZZ is the line number. Each of the capital
     * letters represents a single digital digit.
     */
    @Override public String toString() {
        return String.format("%03d-%03d-%04d", 
                    areaCode, prefix, lineNum);
    }
     
    // Clone method for class with no references to mutable state
    @Override public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();    // can’t happen
        }
    }
    
    @Override
    public int compareTo(PhoneNumber pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix);
            if (result == 0)
                result = Short.compare(lineNum, pn.lineNum);
        }            
        return result;
    }
    
//    @Override
//    public int compareTo(Object o) {
//        return COMPARATOR.compare(this, (PhoneNumber)o);
//    }
    
    private final short areaCode, prefix, lineNum;
    private int hashCode;    // automatically initialized to 0
//    private static final Comparator<PhoneNumber> COMPARATOR =
//        Comparator.<PhoneNumber>comparingInt((PhoneNumber pn) -> pn.areaCode)
//            .thenComparingInt(pn -> pn.prefix)
//            .thenComparingInt(pn -> pn.lineNum);



}
     