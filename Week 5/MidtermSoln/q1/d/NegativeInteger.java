package q1.d;

/**
 * Invariants: 
 * - if set has not been called, get should return -1
 * - if set has been called, get should return the value of the last set
 * - get should never return a nonnegative value
 * @author ohsh
 */
class NegativeInteger implements Comparable <NegativeInteger>{

	private NegativeInteger(int v) { 
		this.v = v;
	}
	
	public NegativeInteger() { 
		this(MAX_VALUE);
	}	
	
	public void set(int v) throws IllegalArgumentException { 
		if (v > MAX_VALUE)
			throw new IllegalArgumentException();
		this.v = v;
	}
	
	public int get() { 
		return v;
	}
	
	@Override
	public boolean equals (Object that) { 
		if (this == that) return true;
		if (!(that instanceof NegativeInteger)) return false;
		NegativeInteger ni = (NegativeInteger) that;
		return ni.v == v;
	}
	
	@Override
	public int compareTo(NegativeInteger o) {
		return Integer.compare(v, o.v);
	}
	
	private final static int MAX_VALUE = -1;
	private int v;
}
