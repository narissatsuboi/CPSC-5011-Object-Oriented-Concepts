package q1.d;

/**
 * Invariants: 
 * - if set has not been called, get should return 0
 * - if set has been called, get should return the value of the last set
 * - get should never return a negative value
 * @author ohsh
 */
class NonNegativeInteger implements Comparable<NonNegativeInteger> {

	private NonNegativeInteger(int v) { 
		this.v = v;
	}
	
	public NonNegativeInteger() { 
		this(MIN_VALUE);
	}
	
	public void set(int v) throws IllegalArgumentException { 
		if (v < MIN_VALUE)
			throw new IllegalArgumentException();
		this.v = v;
	}
	
	public int get() { 
		return v;
	}
	
	@Override
	public boolean equals (Object that) { 
		if (this == that) return true;
		if (!(that instanceof NonNegativeInteger)) return false;
		NonNegativeInteger nni = (NonNegativeInteger) that;
		return nni.v == v;
	}
	
	@Override
	public int compareTo(NonNegativeInteger o) {
		return Integer.compare(v, o.v);
	}
	
	private final static int MIN_VALUE = 0;
	private int v;
}
