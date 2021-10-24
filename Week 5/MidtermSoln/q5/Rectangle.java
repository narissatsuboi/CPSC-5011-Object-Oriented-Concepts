package q5;

import java.awt.Color; 

/**
 * The Rectangle class.
 * 
 * @author ohsh
 */
class Rectangle implements Shape {
	
	public void setXY(int x, int y) { 
		this.x = x; 
		this.y = y; 
	}
	
	public int getX() { 
		return x; 
	}
	
	public int getY() { 
		return y; 
	}
	
	@Override
	public void draw(Color c) { 
		BasicGLib.drawRect(c, x, y); 
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
		if (!(o instanceof Rectangle)) return false;
		Rectangle r = (Rectangle) o;
		return r.x == x && r.y == y; 
	}
	
	@Override
	public int hashCode() {
		//int result = 17;
		//result = 31 * result + x; // or result = 31 * result + Integer.hashCode(x);
		//result = 31 * result + y; // or result = 31 * result + Integer.hashCode(y);
		//return result;
		int result = Integer.hashCode(x);
		result = 31 * result + Integer.hashCode(y);
		return result;
	}
	
	private int x, y;
	
}
