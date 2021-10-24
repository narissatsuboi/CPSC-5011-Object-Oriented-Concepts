package q1.e;

public abstract class Q1Integer implements Comparable<Q1Integer> {

	public abstract void set(int v);
	
	public int get() { 
		return v;
	}
	
	@Override
	public int compareTo(Q1Integer o) {
		return Integer.compare(v, o.v);
	}
	
	protected int v;	
}
