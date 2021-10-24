package q3.one;

public class A {
	private int x0;
	        int x1;
	public int x3;

	int f1(A that) {
		return this.x0 + this.x1  + this.x3
				+ that.x0 + that.x1  + that.x3;
	}
}
