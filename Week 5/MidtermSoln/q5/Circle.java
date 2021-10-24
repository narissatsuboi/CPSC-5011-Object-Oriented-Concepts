package q5;

import java.awt.Color; 

/**
 * The Circle class.
 * (a) Write correct implementations of the equals and clone methods in Circle.
 * (f) Write an implementation of the hashCode method for the Circle class.
 * @author ohsh
 */
class Circle implements Shape {
	
	public void setRadius(int r) { 
		this.r = r; 
	}
	
	public int getRadius() { 
		return r; 
	}
	
	@Override
	public void draw(Color c) { 
		BasicGLib.drawCircle(c, r); 
	}
	
	@Override
	public Object clone() { 
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
	@Override
	public boolean equals(Object o) { 
		if (this == o) return true;
		if (!(o instanceof Circle)) return false;
		Circle c = (Circle) o;
		return c.r == r; 
	}
	
	@Override
	public int hashCode() {
		//int result = 17;
		//result = 31 * result + r; // or result = 31 * result + Integer.hashCode(r);
		//return result;
		return Integer.hashCode(r);
	}
	
	private int r;

}
