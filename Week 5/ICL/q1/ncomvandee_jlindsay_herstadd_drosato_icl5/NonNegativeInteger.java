package ncomvandee_jlindsay_herstadd_drosato_icl5;

public class NonNegativeInteger {
	private int value;
	
	public NonNegativeInteger() {
		value = 0;
	}
	
	public void set(int v) throws IllegalArgumentException {
		if(v >= 0) {
			value = v;
		} else {
			throw new IllegalArgumentException("Only non-negative values allowed!");
		}
	}
	
	public int get() {
		return value;
	}
	
	public boolean equals(Object that) {
		if(!(that instanceof NonNegativeInteger)) {
			return false;
		}
		NonNegativeInteger n = (NonNegativeInteger) that;
		return value == n.get();
	}
	
	public int compareTo(NonNegativeInteger n) {
		return value - n.get();
	}
}
