package q2.a;

class MyBool {
	private boolean v;
	public MyBool(boolean v) { set(v); }
	public void set(boolean v) { this.v = v; }
	public boolean get() { return v; }
	public boolean equals(Object that) {
		return (that instanceof MyBool)
	        && (this.get() == ((MyBool) that).get());
	}
}
public class Main {
	public static void main(String[] args) {
	    MyBool x = new MyBool(false);
	    MyBool y = x;
	    System.out.println( (x.equals(y)) + "," + (x == y) );
	    y.set(true);
	    System.out.println( (x.equals(y)) + "," + (x == y) );  
	    MyBool u = new MyBool(false);
	    MyBool v = new MyBool(false);
	    System.out.println( (u.equals(v)) + "," + (u == v) );
	    v.set(true);
	    System.out.println( (u.equals(v)) + "," + (u == v) );
	}
}
